package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


@Entity
open class Turn(client: String, aDate: LocalDateTime, aService: String) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long? = null
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
