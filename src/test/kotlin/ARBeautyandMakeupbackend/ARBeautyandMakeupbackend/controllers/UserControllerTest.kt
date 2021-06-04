package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.controllers

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.builders.UserBuilder
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.user.ClientUser
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.services.UserService
import org.json.JSONObject
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class UserControllerTest() {

    @Autowired
    lateinit var userService: UserService

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun anotheraskingForAUserByIdReturnsTheUserAnd200Status() {
        mockMvc.perform(MockMvcRequestBuilders
            .get("/user/1")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.jsonPath("$.fullname").value("Lucas Avalos"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.password").value("password"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.contactNumber").value("1151214699"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("lucas@gmail.com"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.isAdmin").value("false"))
    }

    @Test
    fun askingForAAdminUserByIdReturnsTheAdminUserAnd200Status() {
        mockMvc.perform(MockMvcRequestBuilders
            .get("/user/3")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.jsonPath("$.fullname").value("Andrea Rudi"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.password").value("password"))
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
            .andExpect(MockMvcResultMatchers.jsonPath("$.password").value("belu123"))
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
        val body = userToValidate(UserBuilder.aUser().build())

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