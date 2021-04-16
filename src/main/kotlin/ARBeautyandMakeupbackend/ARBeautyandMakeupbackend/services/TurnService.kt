package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.services

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.Turn
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.persistence.TurnRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TurnService : ITurnService{

    @Autowired
    lateinit var turnRepository: TurnRepository

    override fun getTurns(): List<Turn> {
        return turnRepository.findAll()
    }
}