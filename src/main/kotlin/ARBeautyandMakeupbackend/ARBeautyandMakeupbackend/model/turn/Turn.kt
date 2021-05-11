package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.turn

import java.time.LocalDateTime
import javax.persistence.*


@Entity
@Table(uniqueConstraints=arrayOf(UniqueConstraint(columnNames=arrayOf("date"))))
open class Turn{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long?
    open var date: LocalDateTime
    open var clientName: String
    open var service: String
    open var contactNumber: Int
    open var email: String


    constructor(client: String, aDate: LocalDateTime, aService: String, aNumber: Int, aEmail: String) {
        this.id = null
        this.date = aDate
        this.clientName = client
        this.service = aService
        this.contactNumber = aNumber
        this.email = aEmail

    }

    constructor(id: Long?, client: String, aDate: LocalDateTime, aService: String, aNumber: Int, aEmail: String)  {
        this.id = id
        this.date = aDate
        this.clientName = client
        this.service = aService
        this.contactNumber = aNumber
        this.email = aEmail
    }



}
