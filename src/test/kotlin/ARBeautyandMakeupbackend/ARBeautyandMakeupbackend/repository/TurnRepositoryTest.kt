package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.repository

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.builders.TurnBuilder
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.turn.Turn
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.persistence.TurnRepository
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit4.SpringRunner
import java.time.LocalDate

@RunWith(SpringRunner::class)
@DataJpaTest
class TurnRepositoryTest {

    @Autowired
    lateinit var repository : TurnRepository

    @Test
    fun testTurnRepositorySaveAndRetriveTurn(){
        var turn : Turn = TurnBuilder.aTurn().build()
        repository.save(turn)

        var turnFromDb : Turn = repository.findById(turn.id!!).get()
        Assert.assertEquals(turn.clientName, turnFromDb.clientName)
    }


    @Test
    fun testTurnRepositoryRetrievedAEmptyListWhenWeFindByDate(){
        Assert.assertEquals(listOf<Turn>(), repository.findAllByDate(LocalDate.now()))
    }

}