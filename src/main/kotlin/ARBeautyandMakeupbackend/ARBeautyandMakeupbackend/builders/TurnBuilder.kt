package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.builders

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.service.Service
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.turn.Turn
import java.time.LocalDateTime

class TurnBuilder {

    private var id: Long? =  null
    private var client: String = "Lucas Avalos"
    private var date: LocalDateTime = LocalDateTime.of(2021, 4, 20, 16,0,0)
    private var service: Service = Service.MasajeReductor
    private var contactNumber: String = "1168686868"
    private var email: String = "lucas@gmail.com"

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

    fun withService(service: Service): TurnBuilder {
        this.service = service
        return this
    }

    fun withContactClient(contactNumber: String): TurnBuilder {
        this.contactNumber = contactNumber
        return this
    }

    fun withEmail(email: String): TurnBuilder {
        this.email = email
        return this
    }

    fun build(): Turn {
        return Turn(this.id, this.client, this.date, this.service, this.contactNumber, this.email)
    }
}
