package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.user


import com.fasterxml.jackson.annotation.JsonAutoDetect
import java.time.LocalDate
import javax.persistence.*


@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Table(name = "users")
abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long?
    @Column(length = 4000)
    open var photo: String?
    open var fullname: String
    open var password: String
    open var dateOfBirth: LocalDate?
    open var contactNumber: Int?
    open var address: String?
    @Column(unique = true)
    open var email: String

    open var isAdmin: Boolean


    constructor(photo: String?, fullName: String, password: String, email: String, dateOfBirth: LocalDate?, contactNumber: Int?, address: String?) {
        this.id = null
        this.photo = photo
        this.fullname = fullName
        this.password = password
        this.email = email
        this.dateOfBirth = dateOfBirth
        this.contactNumber = contactNumber
        this.address = address
        this.isAdmin = false

    }

    constructor(id: Long?, photo: String?, fullName: String, password: String,email: String, dateOfBirth: LocalDate?, contactNumber: Int?, address: String?) {
        this.id = id
        this.photo = photo
        this.fullname = fullName
        this.password = password
        this.email = email
        this.dateOfBirth = dateOfBirth
        this.contactNumber = contactNumber
        this.address = address
        this.isAdmin = false
    }

}