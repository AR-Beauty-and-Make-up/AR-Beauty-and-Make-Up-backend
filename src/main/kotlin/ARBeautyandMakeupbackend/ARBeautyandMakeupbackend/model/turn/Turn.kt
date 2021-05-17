package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.turn

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.service.Service
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
    open var service: Service
    open var contactNumber: Int
    open var email: String


    constructor(client: String, aDate: LocalDateTime, aService: Service, aNumber: Int, aEmail: String) {
        this.id = null
        this.date = aDate
        this.clientName = client
        this.service = aService
        this.contactNumber = aNumber
        this.email = aEmail

    }

    constructor(id: Long?, client: String, aDate: LocalDateTime, aService: Service, aNumber: Int, aEmail: String)  {
        this.id = id
        this.date = aDate
        this.clientName = client
        this.service = aService
        this.contactNumber = aNumber
        this.email = aEmail
    }



}
