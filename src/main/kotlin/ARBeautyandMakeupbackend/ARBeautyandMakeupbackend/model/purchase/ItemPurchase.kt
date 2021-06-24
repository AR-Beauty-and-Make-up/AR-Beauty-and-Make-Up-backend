package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.purchase

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.product.Product
import java.time.LocalDate
import javax.persistence.*

@Entity
class ItemPurchase {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id : Long?

    @ManyToOne(cascade = [CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE, CascadeType.DETACH], fetch = FetchType.EAGER)
    open var product : Product
    open var quantity : Int

    constructor(id : Long?, product : Product, quantity : Int) {
        this.id = id
        this.product = product
        this.quantity = quantity
    }

    constructor(product : Product, quantity : Int) {
        this.id = null
        this.product = product
        this.quantity = quantity
    }

}
