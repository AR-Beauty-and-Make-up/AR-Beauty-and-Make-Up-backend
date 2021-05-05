package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.product

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.category.Category
import javax.persistence.*

@Entity
open class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long?
    open var productName: String
    open var price: Double

    @Enumerated(EnumType.STRING)
    open var category: Category
    open var photo: String


    constructor(name: String, price: Double, category: Category, photo: String) {
        this.id = null
        this.productName = name
        this.price = price
        this.category = category
        this.photo = photo
    }

    constructor(id: Long, name: String, price: Double, category: Category, photo: String) {
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

    fun category(): Category {
        return  this.category
    }

    fun photo(): String {
        return this.photo
    }
}
