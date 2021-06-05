package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.user

import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.Inheritance
import javax.persistence.InheritanceType

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
class AdminUser : User {


    constructor(fullname: String, password: String, email: String, dateOfBirth: LocalDate?, contactNumber: Int?, address: String?)
            : super(fullname, password, email, dateOfBirth, contactNumber, address)  {
        this.isAdmin = true
    }

    constructor(id:Long?, fullname: String, password: String, email: String, dateOfBirth: LocalDate?, contactNumber: Int?, address: String?)
            : super(id, fullname, password, email, dateOfBirth, contactNumber, address)  {
        this.isAdmin = true
    }

}