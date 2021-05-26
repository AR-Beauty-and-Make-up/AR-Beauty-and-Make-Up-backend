package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.controllers

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.builders.TurnBuilder
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.turn.Turn
import org.json.JSONObject
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.time.LocalDateTime


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@RunWith(SpringRunner::class)
class TurnControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun ifWeAskForTurnsWeGetTheAllTurns(){
        mockMvc.perform(MockMvcRequestBuilders.get("/turns")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk)
    }

    @Test
    fun addedANewTurnWeGetStatusOK(){
        var aTurn = TurnBuilder.aTurn().withName("German Dos Santos").withEmail("german@gmail.com").withDate(LocalDateTime.of(2021, 5, 27, 9,0)).build()
        val body = genereteTurnBody(aTurn)

        mockMvc.perform(MockMvcRequestBuilders.post("/turn")
            .contentType(MediaType.APPLICATION_JSON)
            .content(body.toString()))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.jsonPath("$.clientName").value(aTurn.clientName))
            //.andExpect(MockMvcResultMatchers.jsonPath("$.date").value(aTurn.date))
            //.andExpect(MockMvcResultMatchers.jsonPath("$.service").value(aTurn.service))
            .andExpect(MockMvcResultMatchers.jsonPath("$.contactNumber").value(aTurn.contactNumber))
            .andExpect(MockMvcResultMatchers.jsonPath("$.email").value(aTurn.email))
    }

    @Test
    fun ifWeEditATurnReturnsTheUpdatedTurn(){
        var aTurn = TurnBuilder.aTurn().withContactClient(1177889944).build()

        val body = genereteTurnBody(aTurn)

        mockMvc.perform(MockMvcRequestBuilders.put("/turns/1")
            .contentType(MediaType.APPLICATION_JSON)
            .content(body.toString()))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.jsonPath("$.clientName").value(aTurn.clientName))
            //.andExpect(MockMvcResultMatchers.jsonPath("$.date").value(aTurn.date.toString()))
            //.andExpect(MockMvcResultMatchers.jsonPath("$.service").value(aTurn.service))
            .andExpect(MockMvcResultMatchers.jsonPath("$.contactNumber").value(aTurn.contactNumber))
            .andExpect(MockMvcResultMatchers.jsonPath("$.email").value(aTurn.email))
    }


    private fun genereteTurnBody(aTurn: Turn): JSONObject {
        var jsonTurn = JSONObject()
        jsonTurn.put("clientName", aTurn.clientName)
        jsonTurn.put("date", aTurn.date.toString())
        jsonTurn.put("service", aTurn.service)
        jsonTurn.put("contactNumber", aTurn.contactNumber)
        jsonTurn.put("email", aTurn.email)

        return jsonTurn
    }


}