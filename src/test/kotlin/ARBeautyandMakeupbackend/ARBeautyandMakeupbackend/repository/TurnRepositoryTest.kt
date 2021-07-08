package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.repository

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.DatabaseInitializate
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.builders.TurnBuilder
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.turn.Turn
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.persistence.TurnRepository
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.services.FlushService
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional

@RunWith(SpringRunner::class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
class TurnRepositoryTest {

    @Autowired
    lateinit var repository : TurnRepository

    @MockBean
    lateinit var databaseInitializate: DatabaseInitializate

    @Test
    fun testTurnRepositorySaveAndRetriveTurn(){
        var turn : Turn = TurnBuilder.aTurn().build()
        repository.save(turn)

        var turnFromDb : Turn = repository.findById(turn.id!!).get()
        Assert.assertEquals(turn.clientName, turnFromDb.clientName)
    }


}