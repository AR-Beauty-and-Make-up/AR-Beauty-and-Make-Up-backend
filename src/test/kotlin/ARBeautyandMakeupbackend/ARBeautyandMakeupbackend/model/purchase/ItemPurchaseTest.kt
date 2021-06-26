package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.purchase

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.builders.ProductBuilder
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.builders.PurchaseBuilder
import org.junit.Assert
import org.junit.Test
import java.time.LocalDate

class ItemPurchaseTest {


    @Test
    fun aPurchaseItemHasAProduct(){
        val aProductName = "Crema"
        val aProduct = ProductBuilder.aProduct().withName(aProductName).build()
        val aItemPurchase = ItemPurchase(aProduct, 1)
        Assert.assertEquals(aItemPurchase.product.productName, aProductName)
    }

    @Test
    fun aPurchaseItemHasOneProduct(){
        val aProduct = ProductBuilder.aProduct().build()
        val aItemPurchase = ItemPurchase(aProduct, 1)
        Assert.assertEquals(aItemPurchase.quantity, 1)
    }

}