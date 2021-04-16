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
import org.springframework.test.context.junit4.SpringRunner

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
}