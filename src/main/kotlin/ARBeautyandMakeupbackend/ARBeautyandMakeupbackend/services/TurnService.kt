package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.services


import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.turn.Turn
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.persistence.TurnRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class TurnService : ITurnService{

    @Autowired
    lateinit var turnRepository: TurnRepository

    override fun getTurns(): List<Turn> {
        return turnRepository.findAll()
    }

    override fun addTurn(aTurn: Turn): Turn {

        return turnRepository.save(aTurn)
    }

    override fun find(id: Long): Turn {

        return turnRepository.findById(id).get()
    }

    override fun findAllByDate(date: LocalDate): List<Turn> {
        return turnRepository.findAllByDate(date)
    }

    override fun updateTurn(id: Long, aTurn: Turn): Turn {
        val retrievedTurn: Turn = this.find(id)

        retrievedTurn.clientName = aTurn.clientName
        retrievedTurn.date = aTurn.date
        retrievedTurn.service = aTurn.service
        retrievedTurn.contactNumber = aTurn.contactNumber

        return turnRepository.save(retrievedTurn)
    }

    override fun deleteTurn(aTurn: Turn) {
        turnRepository.delete(aTurn)
    }

    override fun getDates(): List<String> {
        return turnRepository.getDates()
    }


}