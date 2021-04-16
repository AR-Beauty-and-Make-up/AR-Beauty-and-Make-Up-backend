package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.builders

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.Turn
import java.time.LocalDateTime
import java.util.*

class TurnBuilder {

    private var client: String = "Lucas Avalos"
    private var date: LocalDateTime = LocalDateTime.of(2021, 4, 20, 16,0)
    private var service: String = "Masajes"
    private var contactNumber: Int = 1168686868

    companion object {
        fun aTurn(): TurnBuilder {
            return TurnBuilder()
        }

        fun turnList(): List<Turn> {
            var aTurn = aTurn().build()
            var anotherTurn = aTurn().withName("Luciana Alonso").build()
            return Arrays.asList(aTurn, anotherTurn)
        }
    }

    private fun withName(name: String): TurnBuilder {
        client = name
        return this
    }

    fun build(): Turn {
        return Turn(this.client, this.date, this.service, this.contactNumber)
    }
}
