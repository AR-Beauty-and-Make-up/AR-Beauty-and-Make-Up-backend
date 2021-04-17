package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.builders

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.Turn
import java.time.LocalDateTime
import java.util.*

class TurnBuilder {

    private var id: Long? =  null
    private var client: String = "Lucas Avalos"
    private var date: LocalDateTime = LocalDateTime.of(2021, 4, 20, 16,0)
    private var service: String = "Masajes"
    private var contactNumber: Int = 1168686868

    companion object {
        fun aTurn(): TurnBuilder {
            return TurnBuilder()
        }

        fun turnList(): List<Turn> {
            var aTurn = this.aTurn().build()
            var anotherTurn = this.aTurn().withName("Luciana Alonso").build()
            return listOf(aTurn, anotherTurn)
        }

        fun turnListBySameDate(date: LocalDateTime): List<Turn> {
            var aTurn = this.aTurn().withDate(date).build()
            var anotherTurn = this.aTurn().withDate(date).build()
            return listOf(aTurn, anotherTurn)
        }

    }

    fun withName(name: String): TurnBuilder {
        this.client = name
        return this
    }

    fun withId(id: Long): TurnBuilder {
        this.id = id
        return this
    }

    fun withDate(date: LocalDateTime): TurnBuilder {
        this.date = date
        return this
    }

    fun withService(service: String): TurnBuilder {
        this.service = service
        return this
    }

    fun build(): Turn {
        return Turn(this.id, this.client, this.date, this.service, this.contactNumber)
    }
}
