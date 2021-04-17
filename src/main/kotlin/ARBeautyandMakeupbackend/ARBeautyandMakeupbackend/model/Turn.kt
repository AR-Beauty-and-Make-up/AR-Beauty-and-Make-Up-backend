package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


@Entity
open class Turn{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long?
    open var date: LocalDateTime
    open var clientName: String
    open var service: String
    open var contactNumber: Int


    constructor(client: String, aDate: LocalDateTime, aService: String, aNumber: Int) {
        this.id = null
        this.date = aDate
        this.clientName = client
        this.service = aService
        this.contactNumber = aNumber

    }

    constructor(id: Long?, client: String, aDate: LocalDateTime, aService: String, aNumber: Int)  {
        this.id = id
        this.date = aDate
        this.clientName = client
        this.service = aService
        this.contactNumber = aNumber
    }



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
