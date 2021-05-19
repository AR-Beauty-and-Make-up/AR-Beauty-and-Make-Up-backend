package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.controllers

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.builders.TurnBuilder
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.services.TurnService
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers


@SpringBootTest
@RunWith(SpringRunner::class)
@AutoConfigureMockMvc
class TurnControllerTest {

    @MockBean
    lateinit var turnServiceMock: TurnService

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun ifWeAskForTurnsWeGetTheAllTurns(){
        var allTurns = TurnBuilder.turnList()
        `when`(turnServiceMock.getTurns()).thenReturn(allTurns)

        mockMvc.perform(MockMvcRequestBuilders.get("/turns"))
            .andExpect(MockMvcResultMatchers.status().isOk)
    }
/*
    @Test
    fun ifWeEditATurnReturnsTheUpdatedTurn(){
        var id = Random().nextLong()
        var aTurn = TurnBuilder.aTurn().withId(id).build()
        `when`(turnServiceMock.updateTurn(id, aTurn)).thenReturn(aTurn)

        val body: JSONObject = genereteTurnBody(aTurn)

        mockMvc.perform(MockMvcRequestBuilders.put("/turns/" + aTurn.id().toString())
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.content().string(body.toString()))
            .andExpect(MockMvcResultMatchers.jsonPath("$.clientName").value(Matchers.equalTo(aTurn.clientName())))
    }

    private fun genereteTurnBody(aTurn: Turn): JSONObject {
        var jsonObject = JSONObject()
        jsonObject.put("clientName", aTurn.clientName() )
        jsonObject.put("date", aTurn.date())
        jsonObject.put("service", aTurn.service())
        jsonObject.put("contactNumber", aTurn.contactNumber())

        return jsonObject
    }*/

/*

    @Test
    fun addedANewTurnWeGetStatusOK(){
        var aTurn = TurnBuilder.aTurn().build()
        `when`(turnServiceMock.addTurn(aTurn)).thenReturn(aTurn)

        mockMvc.perform(MockMvcRequestBuilders.post("/turn"))
            .andExpect(MockMvcResultMatchers.status().isOk)
    }
*/


}