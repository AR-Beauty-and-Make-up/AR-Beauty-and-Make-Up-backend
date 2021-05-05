package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.service

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.builders.TurnBuilder
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.turn.Turn
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.persistence.TurnRepository
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.services.TurnService
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDate
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
        val aDate =  LocalDateTime.now()
        val aListOfTurnByDate = TurnBuilder.turnListBySameDate(aDate)
        val aLocalDate = LocalDate.of(aDate.year, aDate.month, aDate.dayOfMonth)
        `when`(turnRepositoryMock.findAllByDate(aLocalDate)).thenReturn(aListOfTurnByDate)

        Assert.assertEquals(aListOfTurnByDate.size, turnService.findAllByDate(aLocalDate).size)
    }

    @Test
    fun aTurnCanHaveItDataUpdated(){
        val newService = "Masoterapia"
        var id = Random().nextLong()
        var aTurn = TurnBuilder.aTurn().withId(id).build()
        var updatedTurn = TurnBuilder.aTurn().withService(newService).build()

        `when`(turnRepositoryMock.findById(anyLong())).thenReturn(Optional.of(aTurn))
        `when`(turnRepositoryMock.save(aTurn)).thenReturn(updatedTurn)

        var retrievedTurn = turnService.updateTurn(aTurn.id()!!, updatedTurn)
        Assert.assertEquals(retrievedTurn.service(), newService)

    }

    @Test
    fun whenWeDeleteATurnItsDeleteFromTheList(){
        var id = Random().nextLong()
        var aTurn = TurnBuilder.aTurn().withId(id).build()

        `when`(turnRepositoryMock.save(aTurn)).thenReturn(aTurn)

        turnService.addTurn(aTurn)
        var turnList = listOf<Turn>(aTurn)


        turnService.deleteTurn(aTurn)
        var turnListWithoutATurn = listOf<Turn>()

        Assert.assertNotEquals(turnList.size, turnListWithoutATurn.size)
    }

    @Test
    fun whenWeAskTurnServiceForAllDatesOfItReturnsAListOfStringDates(){
        var allDates = listOf(
            "2021-04-20 10:30:00.0",
            "2021-04-20 13:30:00.0",
            "2021-04-20 15:00:00.0",
            "2021-04-26 09:00:00.0",
            "2021-04-26 15:00:00.0",
            "2021-04-26 16:30:00.0")

        `when`(turnRepositoryMock.getDates()).thenReturn(allDates)

        Assert.assertEquals(allDates, turnService.getDates())
    }


}