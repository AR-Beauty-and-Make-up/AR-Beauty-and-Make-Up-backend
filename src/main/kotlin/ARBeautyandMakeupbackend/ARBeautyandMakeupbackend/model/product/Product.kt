package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.product

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
open class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long?
    open var productName: String
    open var price: Double
    open var category: String
    open var photo: String


    constructor(name: String, price: Double, category: String, photo: String) {
        this.id = null
        this.productName = name
        this.price = price
        this.category = category
        this.photo = photo
    }

    constructor(id: Long, name: String, price: Double, category: String, photo: String) {
        this.id = id
        this.productName = name
        this.price = price
        this.category = category
        this.photo = photo
    }

    fun productName() : String {
        return this.productName
    }

    fun price(): Double {
        return this.price
    }

    fun category(): String {
        return  this.category
    }

    fun photo(): String {
        return this.photo
    }
}
