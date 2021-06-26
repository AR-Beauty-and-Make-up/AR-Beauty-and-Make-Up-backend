package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.purchase

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.purchase.ItemPurchase
import java.time.LocalDate
import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id : Long?
    open var date : LocalDate

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    open var purchaseItems : Set<ItemPurchase>

    constructor(id : Long?, date : LocalDate, purchaseItems : Set<ItemPurchase>) {
        this.id = id
        this.date = date
        this.purchaseItems = purchaseItems
    }

    constructor(date : LocalDate, purchaseItems : Set<ItemPurchase>) {
        this.id = null
        this.date = date
        this.purchaseItems = purchaseItems
    }

}
