package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.user

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.purchase.Purchase
import java.time.LocalDate
import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
class ClientUser : User {

    @OneToMany(cascade = [CascadeType.ALL])
    open var purchases: MutableList<Purchase>


    constructor(photo: String?, fullname: String, password: String, email: String, dateOfBirth: LocalDate?, contactNumber: Int?, address: String?)
            : super(photo, fullname, password, email, dateOfBirth, contactNumber, address)  {
        this.purchases = mutableListOf()
    }

    constructor(id:Long?, photo: String?, fullname: String, password: String, email: String, dateOfBirth: LocalDate?, contactNumber: Int?, address: String?)
            : super(id, photo, fullname, password, email, dateOfBirth, contactNumber, address)  {
        this.purchases = mutableListOf()
    }

    constructor(photo: String?, fullname: String, password: String,email: String, dateOfBirth: LocalDate?, contactNumber: Int?,
                address: String?, orders: MutableList<Purchase>)
            : super(photo, fullname, password, email, dateOfBirth, contactNumber, address)  {
        this.purchases = orders
    }

    constructor(id: Long?, photo: String?, fullname: String, password: String, email: String, dateOfBirth: LocalDate?,
                contactNumber: Int?, address: String?, orders: MutableList<Purchase>)
            : super(id, photo, fullname, password, email, dateOfBirth, contactNumber, address)  {
        this.purchases = orders
    }

    override fun addPurchase(aPurchase: Purchase) {
        this.purchases.add(aPurchase)
    }

}