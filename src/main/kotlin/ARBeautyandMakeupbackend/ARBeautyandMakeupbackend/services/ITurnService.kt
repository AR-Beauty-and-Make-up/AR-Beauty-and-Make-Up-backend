package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.services

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.Turn

interface ITurnService {

    fun getTurns(): List<Turn>
    fun addTurn(aTurn: Turn)
}