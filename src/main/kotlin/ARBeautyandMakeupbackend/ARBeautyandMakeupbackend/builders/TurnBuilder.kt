package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.builders

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.Turn
import java.time.LocalDateTime

class TurnBuilder {

    private var client: String = "Lucas Avalos"
    private var date: LocalDateTime = LocalDateTime.of(2021, 4, 20, 16,0)
    private var service: String = "Masajes"

    companion object {
        fun aTurn(): TurnBuilder {
            return TurnBuilder()
        }
    }

    fun build(): Turn {
        return Turn(this.client, this.date, this.service)
    }
}
