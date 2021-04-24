package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.controllers

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.builders.TurnBuilder
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.services.TurnService
import org.junit.Test
import org.junit.experimental.results.ResultMatchers
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.mockito.Mockito.any
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.JsonPathResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import java.util.*


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


    /*@Test
    fun addedANewTurnWeGetStatusOK(){
        var aTurn = TurnBuilder.aTurn().build()
        `when`(turnServiceMock.addTurn(aTurn)).thenReturn(aTurn)

        mockMvc.perform(MockMvcRequestBuilders.post("/turn"))
            .andExpect(MockMvcResultMatchers.status().isOk)
    }*/


}