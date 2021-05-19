package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.user

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.product.Product
import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
class Client : User {

    @OneToMany(fetch = FetchType.EAGER)
    open var orders: MutableList<Product>


    constructor(fullname: String, password: String, email: String) : super(fullname, password, email)  {
        this.orders = arrayListOf()
    }

    constructor(id:Long?, fullname: String, password: String, email: String) : super(id, fullname, password, email)  {
        this.orders = arrayListOf()
    }

    constructor(fullname: String, password: String,email: String, orders: MutableList<Product>) : super(fullname, password, email)  {
        this.orders = orders
    }

    constructor(id: Long?, fullname: String, password: String,email: String, orders: MutableList<Product>) : super(id, fullname, password, email)  {
        this.orders = orders
    }


}