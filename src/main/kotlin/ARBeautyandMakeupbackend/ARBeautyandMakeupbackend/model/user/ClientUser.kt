package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.user

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.product.Product
import java.time.LocalDate
import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
class ClientUser : User {

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    open var orders: MutableList<Product>


    constructor(photo: String?, fullname: String, password: String, email: String, dateOfBirth: LocalDate?, contactNumber: Int?, address: String?)
            : super(photo, fullname, password, email, dateOfBirth, contactNumber, address)  {
        this.orders = arrayListOf()
    }

    constructor(id:Long?, photo: String?, fullname: String, password: String, email: String, dateOfBirth: LocalDate?, contactNumber: Int?, address: String?)
            : super(id, photo, fullname, password, email, dateOfBirth, contactNumber, address)  {
        this.orders = arrayListOf()
    }

    constructor(photo: String?, fullname: String, password: String,email: String, dateOfBirth: LocalDate?, contactNumber: Int?,
                address: String?, orders: MutableList<Product>)
            : super(photo, fullname, password, email, dateOfBirth, contactNumber, address)  {
        this.orders = orders
    }

    constructor(id: Long?, photo: String?, fullname: String, password: String,email: String, dateOfBirth: LocalDate?,
                contactNumber: Int?, address: String?, orders: MutableList<Product>)
            : super(id, photo, fullname, password, email, dateOfBirth, contactNumber, address)  {
        this.orders = orders
    }


}