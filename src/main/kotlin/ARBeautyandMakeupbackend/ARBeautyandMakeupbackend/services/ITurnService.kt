package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.services

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.turn.Turn
import java.time.LocalDate
import java.time.LocalDateTime

interface ITurnService {

    fun getTurns(): List<Turn>
    fun addTurn(aTurn: Turn): Turn
    fun find(id: Long): Turn
    fun findAllByDate(date: LocalDate): List<Turn>
    fun updateTurn(id: Long, aTurn: Turn): Turn
    fun deleteTurn(aTurn: Turn)
    fun getDates(): List<String>
}