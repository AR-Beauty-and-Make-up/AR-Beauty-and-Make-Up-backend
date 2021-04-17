package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.services

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.Turn
import java.time.LocalDateTime

interface ITurnService {

    fun getTurns(): List<Turn>
    fun addTurn(aTurn: Turn): Turn
    fun find(id: Long): Turn
    fun findAllByDate(date: LocalDateTime): List<Turn>
}