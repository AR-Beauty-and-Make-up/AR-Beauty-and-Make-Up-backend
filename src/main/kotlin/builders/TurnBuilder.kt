package builders

import model.Turn
import java.time.LocalDateTime

class TurnBuilder {

    private var client: String = "Lucas Avalos"
    private var date: LocalDateTime = LocalDateTime.of(2021, 4, 20, 16,0)
    private var service: String = "Masajes"
    private var contactNumber: Int = 1168686868

    companion object {
        fun aTurn(): TurnBuilder {
            return TurnBuilder()
        }
    }

    fun build(): Turn {
        return Turn(this.client, this.date, this.service, this.contactNumber)
    }
}
