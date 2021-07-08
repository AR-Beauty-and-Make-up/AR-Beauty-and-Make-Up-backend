package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.controllers

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.DatabaseInitializate
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.builders.UserBuilder
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.user.ClientUser
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.services.FlushService
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.services.UserService
import org.json.JSONObject
import org.junit.After
import org.junit.Before
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.transaction.annotation.Transactional


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
class UserControllerTest() {

    @Autowired
    lateinit var userService: UserService

    @Autowired
    lateinit var mockMvc: MockMvc

    @MockBean
    lateinit var databaseInitializate: DatabaseInitializate

    @Test
    fun askingForAUserByIdReturnsTheUserAnd200Status() {
        val clientUser = UserBuilder.aUser().build()
        val retrievedUser = userService.addUser(clientUser)

        mockMvc.perform(MockMvcRequestBuilders
            .get("/user/" + retrievedUser.id)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.jsonPath("$.fullname").value("Lucas Avalos"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.contactNumber").value("1151214699"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("lucas@gmail.com"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.isAdmin").value("false"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.address").value("Calle Falsa 123, Bernal, Buenos Aires (1879)"))
    }

    @Test
    fun askingForAAdminUserByIdReturnsTheAdminUserAnd200Status() {
        val adminUser = UserBuilder.aUser().withFullname("Andrea Rudi").withConcatNumber(1162434990).withEmail("andrearudi@gmail.com").buildAdmin()
        val retrievedUser = userService.addAdminUser(adminUser)

        mockMvc.perform(MockMvcRequestBuilders
            .get("/user/" + retrievedUser.id)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.jsonPath("$.fullname").value("Andrea Rudi"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.password").value("Pass1234"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.contactNumber").value("1162434990"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("andrearudi@gmail.com"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.isAdmin").value("true"))
    }

    @Test
    fun creatingANewClientUserTheUserItsReturnedAndTheStatusIs200(){

        val newUser = UserBuilder.aUser().withEmail("beluamat@gmail.com").withFullname("Belen Amat").withPassword("belu123").build()
        val body = asJson(newUser)

        mockMvc.perform(MockMvcRequestBuilders
            .post("/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content(body.toString()))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.jsonPath("$.fullname").value("Belen Amat"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.contactNumber").value("1151214699"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("beluamat@gmail.com"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.isAdmin").value("false"))
            .andReturn()
    }

    @Test
    fun creatingANewClientUserWithAlreadyExistingMailReturnsBadRequest(){
        val newUser = UserBuilder.aUser().withEmail("belen@gmail.com").build()
        userService.addUser(newUser)
        val body = asJson(newUser)

        mockMvc.perform(MockMvcRequestBuilders
            .post("/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content(body.toString()))
            .andExpect(MockMvcResultMatchers.status().isBadRequest)
    }

    @Test
    fun  aUserIsValidatedIfItsEmailMatchesWithItsPassword(){
        val user = UserBuilder.aUser().build()
        val password = user.password
        userService.addUser(user)

        val body = userToValidate(user)
        body.put("password", password)

        mockMvc.perform(MockMvcRequestBuilders
            .post("/validateUser")
            .contentType(MediaType.APPLICATION_JSON)
            .content(body.toString()))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("lucas@gmail.com"))
    }

    @Test
    fun  aUserIsNotValidatedIfItsUsernameMatchesWithItsPassword(){
        val body = userToFail()

        mockMvc.perform(MockMvcRequestBuilders
            .post("/validateUser")
            .contentType(MediaType.APPLICATION_JSON)
            .content(body.toString()))
            .andExpect(MockMvcResultMatchers.status().isNotFound)
    }

    @Test
    fun updatingAClientUserReturnsTheUserUpdatedAndStatusOk(){
        val retrievedUser = userService.addUser(UserBuilder.aUser().build())
        val userToUpdated = UserBuilder.aUser().withFullname("Lucas Emiliano Avalos").build()
        val body = asJson(userToUpdated)

        mockMvc.perform(MockMvcRequestBuilders
            .put("/updateUser/" + retrievedUser.id)
            .contentType(MediaType.APPLICATION_JSON)
            .content(body.toString()))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.jsonPath("$.fullname").value(userToUpdated.fullname))
    }

    private fun userToFail(): JSONObject {
        val userToValidate = JSONObject()
        userToValidate.put("email", "lucas@gmail.com")
        userToValidate.put("password", "invalid")

        return userToValidate
    }

    private fun userToValidate(aUser: ClientUser): JSONObject {
        val userToValidate = JSONObject()
        userToValidate.put("email", aUser.email)
        userToValidate.put("password", aUser.password)

        return userToValidate
    }

    private fun asJson(newUser: ClientUser): JSONObject {
        val newClientJson = JSONObject()
        newClientJson.put("email", newUser.email)
        newClientJson.put("fullname", newUser.fullname)
        newClientJson.put("password", newUser.password)
        newClientJson.put("contactNumber", newUser.contactNumber)
        newClientJson.put("address", newUser.address)
        newClientJson.put("dateOfBirth", newUser.dateOfBirth)
        newClientJson.put("isAdmin", newUser.isAdmin)

        return newClientJson
    }
}