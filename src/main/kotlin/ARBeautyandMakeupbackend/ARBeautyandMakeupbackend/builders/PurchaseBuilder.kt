package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.builders

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.purchase.ItemPurchase
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.purchase.Purchase
import java.time.LocalDate

class PurchaseBuilder {

    private var id: Long? = null
    private var date: LocalDate = LocalDate.now()
    private var purchaseItems: Set<ItemPurchase> = setOf(
            ItemPurchase(ProductBuilder.aProduct().build(), 1),
            ItemPurchase(ProductBuilder.aProduct().build(), 1)
    )


    companion object {
        fun aPurchase(): PurchaseBuilder {
            return PurchaseBuilder()
        }
    }

    fun build() : Purchase {
        return Purchase(this.id, this.date, this.purchaseItems)
    }

    fun withId(id: Long) : PurchaseBuilder {
        this.id = id
        return this
    }

    fun withDate(date: LocalDate) : PurchaseBuilder {
        this.date = date
        return this
    }

    fun withPurchaseItems(purchaseItems: Set<ItemPurchase>) : PurchaseBuilder {
        this.purchaseItems = purchaseItems
        return this
    }

}
