package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.user

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.purchase.Purchase
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.Inheritance
import javax.persistence.InheritanceType

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
class AdminUser : User {


    constructor(photo: String?, fullname: String, password: String, email: String, dateOfBirth: LocalDate?, contactNumber: Int?, address: String?)
            : super(photo, fullname, password, email, dateOfBirth, contactNumber, address)  {
        this.isAdmin = true
    }

    constructor(id:Long?, photo: String?, fullname: String, password: String, email: String, dateOfBirth: LocalDate?, contactNumber: Int?, address: String?)
            : super(id, photo, fullname, password, email, dateOfBirth, contactNumber, address)  {
        this.isAdmin = true
    }

    override fun addPurchase(aPurchase: Purchase) {
        throw RuntimeException("Admin user shouldn't add a purchase")
    }

}