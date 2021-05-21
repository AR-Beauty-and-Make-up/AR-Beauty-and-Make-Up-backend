package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.user


import com.fasterxml.jackson.annotation.JsonAutoDetect
import java.time.LocalDateTime
import javax.persistence.*


@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long?
    open var fullname: String
    open var password: String
    open var dateOfBirth: LocalDateTime
    open var contactNumber: Int
    open var address: String
    @Column(unique = true)
    open var email: String

    open var admin: Boolean


    constructor(fullName: String, password: String, email: String, dateOfBirth: LocalDateTime, contactNumber: Int, address: String) {
        this.id = null
        this.fullname = fullName
        this.password = password
        this.email = email
        this.dateOfBirth = dateOfBirth
        this.contactNumber = contactNumber
        this.address = address
        this.admin = false

    }

    constructor(id: Long?, fullName: String, password: String,email: String, dateOfBirth: LocalDateTime, contactNumber: Int, address: String) {
        this.id = id
        this.fullname = fullName
        this.password = password
        this.email = email
        this.dateOfBirth = dateOfBirth
        this.contactNumber = contactNumber
        this.address = address
        this.admin = false
    }

}