package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.product

open class Product {

    open var id: Long?
    open var name: String
    open var price: Double
    open var category: String
    open var photo: String


    constructor(name: String, price: Double, category: String, photo: String) {
        this.id = null
        this.name = name
        this.price = price
        this.category = category
        this.photo = photo
    }

    constructor(id: Long, name: String, price: Double, category: String, photo: String) {
        this.id = id
        this.name = name
        this.price = price
        this.category = category
        this.photo = photo
    }

    fun name() : String {
        return this.name
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
