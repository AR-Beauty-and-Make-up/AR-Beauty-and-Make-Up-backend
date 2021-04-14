package model

import java.time.LocalDateTime

open class Turn(client: String, aDate: LocalDateTime, aService: String) {

    open var date: LocalDateTime = aDate
    open var clientName: String = client
    open var service: String = aService

    fun date(): LocalDateTime {
        return this.date
    }

    fun clientName(): String {
        return this.clientName
    }

    fun service(): String {
        return this.service
    }

}
