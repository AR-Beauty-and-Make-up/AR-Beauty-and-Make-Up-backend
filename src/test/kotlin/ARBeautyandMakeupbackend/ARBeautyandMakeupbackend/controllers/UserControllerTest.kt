package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.controllers

import org.junit.Assert
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@RunWith(SpringRunner::class)
@AutoConfigureMockMvc
class UserControllerTest(@Autowired val restTemplate: TestRestTemplate) {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun askingForAUserByIdReturnsTheUserAnd200Status() {
        val entity: ResponseEntity<String> = restTemplate.getForEntity<String>("/user/1")

        Assert.assertEquals(HttpStatus.OK, entity.statusCode)
        Assert.assertTrue(entity.body?.contains("Lucas Avalos")!!)
        Assert.assertTrue(entity.body?.contains("password")!!)
        Assert.assertTrue(entity.body?.contains("lucas@gmail.com")!!)
        Assert.assertTrue(entity.body?.contains("1151214699")!!)
        Assert.assertTrue(entity.body?.contains("Calle Falsa 123, Berna, Buenos Aires (1879)")!!)

    }

    @Test
    fun anotherWay() {
        mockMvc.perform(MockMvcRequestBuilders
            .get("/user/1")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.jsonPath("$.fullname").value("Lucas Avalos"))
    }
}