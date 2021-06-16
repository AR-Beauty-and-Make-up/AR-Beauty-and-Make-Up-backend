package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.services


import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.handlers.BadRequestException
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.turn.Turn
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.persistence.TurnRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.LocalDateTime

@Service
class TurnService {

    @Autowired
    lateinit var turnRepository: TurnRepository

    fun getTurns(): List<Turn> {
        return turnRepository.findAll()
    }

    fun addTurn(aTurn: Turn): Turn {
        canAddTurn(aTurn.date)
        return turnRepository.save(aTurn)
    }

    private fun canAddTurn(aDate: LocalDateTime) {
        if (getTurns().stream().anyMatch { turn -> turn.date == aDate }) {
            throw BadRequestException("A turn already exisist on this date")
        }
    }

    fun find(id: Long): Turn {

        return turnRepository.findById(id).get()
    }

    fun findAllByDate(date: LocalDate): List<Turn> {
        return turnRepository.findAllByDate(date)
    }

    fun updateTurn(id: Long, aTurn: Turn): Turn {
        val retrievedTurn: Turn = this.find(id)

        retrievedTurn.clientName = aTurn.clientName
        retrievedTurn.date = aTurn.date
        retrievedTurn.service = aTurn.service
        retrievedTurn.contactNumber = aTurn.contactNumber

        return turnRepository.save(retrievedTurn)
    }

    fun deleteTurn(aTurn: Turn) {
        turnRepository.delete(aTurn)
    }

    fun getDates(): List<String> {
        return turnRepository.getDates()
    }


}