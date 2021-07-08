package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.purchase

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.builders.ProductBuilder
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.builders.PurchaseBuilder
import org.junit.Assert
import org.junit.Test
import java.time.LocalDate
import java.time.LocalDateTime

class PurchaseTest {

    @Test
    fun aPurchaseHasADate(){
        val aDate = LocalDate.now()
        val aPurchase = PurchaseBuilder.aPurchase().withDate(aDate).build()
        Assert.assertEquals(aPurchase.date, aDate)
    }

    @Test
    fun aPurchaseHasItems(){
        val aItemPurchase = ItemPurchase(ProductBuilder.aProduct().build(), 1)
        val aPurchaseWithItems = PurchaseBuilder.aPurchase().withPurchaseItems(setOf(aItemPurchase)).build()

        Assert.assertEquals(aPurchaseWithItems.purchaseItems.size, 1)
    }

}