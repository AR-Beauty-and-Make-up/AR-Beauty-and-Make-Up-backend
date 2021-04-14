package model

import java.time.LocalDateTime

open class Turn(aDate: LocalDateTime, client: String) {

    open var date: LocalDateTime = aDate
    open var clientName: String = client

    fun date(): LocalDateTime {
        return this.date
    }

    fun clientName(): String {
        return this.clientName
    }

}
