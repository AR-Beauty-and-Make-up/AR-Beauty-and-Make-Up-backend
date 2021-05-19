package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.user


import com.fasterxml.jackson.annotation.JsonAutoDetect
import javax.persistence.*


@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long?
    open var fullname: String
    open var password: String

    @Column(unique = true)
    open var email: String

    open var admin: Boolean


    constructor(fullName: String, password: String, email: String) {
        this.id = null
        this.fullname = fullName
        this.password = password
        this.email = email
        this.admin = false

    }

    constructor(id: Long?, fullName: String, password: String,email: String) {
        this.id = id
        this.fullname = fullName
        this.password = password
        this.email = email
        this.admin = false
    }

}