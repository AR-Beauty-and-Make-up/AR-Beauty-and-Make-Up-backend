package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.service

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.builders.TurnBuilder
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.persistence.TurnRepository
import org.junit.Assert
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.services.TurnService
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDateTime
import java.util.*

@SpringBootTest
@RunWith(MockitoJUnitRunner::class)
class TurnServiceTest {

    @Mock
    lateinit var turnRepositoryMock : TurnRepository

    @InjectMocks
    lateinit var turnService: TurnService

    @Test
    fun whenWeAskTurnServiceForAllTurnsOfItReturnsAListOfTurns(){
        var allTurns = TurnBuilder.turnList()
        `when`(turnRepositoryMock.findAll()).thenReturn(allTurns)

        Assert.assertEquals(allTurns, turnService.getTurns())
    }

    @Test
    fun whenWeAskTurnServiceToAddANewTurnReturnTheNewTurn() {
        var aTurn = TurnBuilder.aTurn().build()
        `when`(turnRepositoryMock.save(aTurn)).thenReturn(aTurn)

        Assert.assertEquals(aTurn, turnService.addTurn(aTurn))
    }


    @Test
    fun whenWeAskTurnServiceForATurnByIdReturnTheTurn() {
        var aId: Long = 1
        var aTurn = TurnBuilder.aTurn().withId(aId).build()
        `when`(turnRepositoryMock.findById(aId)).thenReturn(Optional.of(aTurn))

        Assert.assertEquals(aTurn.clientName, turnService.find(aId).clientName)
    }

    @Test
    fun whenWeAskTurnServiceForAllTheTurnsByDateReturnAListOfTurn() {
        var aDate =  LocalDateTime.now()
        var aListOfTurnByDate = TurnBuilder.turnListBySameDate(aDate)
        `when`(turnRepositoryMock.findAllByDate(aDate)).thenReturn(aListOfTurnByDate)

        Assert.assertEquals(aListOfTurnByDate.size, turnService.findAllByDate(aDate).size)
    }
}