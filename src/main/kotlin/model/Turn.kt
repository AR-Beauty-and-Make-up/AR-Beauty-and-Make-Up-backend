package model

import java.time.LocalDateTime

open class Turn(client: String, aDate: LocalDateTime, aService: String, aNumber: Int) {

    open var date: LocalDateTime = aDate
    open var clientName: String = client
    open var service: String = aService
    open var contactNumber: Int = aNumber

    fun date(): LocalDateTime {
        return this.date
    }

    fun clientName(): String {
        return this.clientName
    }

    fun service(): String {
        return this.service
    }

    fun contactNumber(): Int {
        return this.contactNumber
    }

}
