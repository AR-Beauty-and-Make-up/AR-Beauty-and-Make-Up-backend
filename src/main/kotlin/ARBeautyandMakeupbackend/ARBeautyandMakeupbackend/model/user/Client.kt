package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.user

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.product.Product
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
class Client : User {

    @OneToMany(fetch = FetchType.EAGER)
    open var orders: MutableList<Product>


    constructor(fullname: String, password: String, email: String, dateOfBirth: LocalDateTime, contactNumber: Int, address: String)
            : super(fullname, password, email, dateOfBirth, contactNumber, address)  {
        this.orders = arrayListOf()
    }

    constructor(id:Long?, fullname: String, password: String, email: String, dateOfBirth: LocalDateTime, contactNumber: Int, address: String)
            : super(id, fullname, password, email, dateOfBirth, contactNumber, address)  {
        this.orders = arrayListOf()
    }

    constructor(fullname: String, password: String,email: String, dateOfBirth: LocalDateTime, contactNumber: Int,
                address: String, orders: MutableList<Product>)
            : super(fullname, password, email, dateOfBirth, contactNumber, address)  {
        this.orders = orders
    }

    constructor(id: Long?, fullname: String, password: String,email: String, dateOfBirth: LocalDateTime,
                contactNumber: Int, address: String, orders: MutableList<Product>)
            : super(id, fullname, password, email, dateOfBirth, contactNumber, address)  {
        this.orders = orders
    }


}