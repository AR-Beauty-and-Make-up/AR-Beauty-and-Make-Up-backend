
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.builders.ProductBuilder
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.product.Product
import org.junit.Assert
import org.junit.Test



class ProductTest {

    @Test
    fun aProductHasAName(){
        val aName = "Crema desmaquillante"
        val aProduct = ProductBuilder.aProduct().withName(aName).build()
        Assert.assertEquals(aProduct.name(), aName)
    }

    @Test
    fun aProductHasAPrice(){
        val aPrice = 100.00
        val aProduct = ProductBuilder.aProduct().withPrice(aPrice).build()
        Assert.assertEquals(aProduct.price(), aPrice, 0.00)
    }

    @Test
    fun aProductHasACategory(){
        val aCategory = "Cremas"
        val aProduct = ProductBuilder.aProduct().withCategory(aCategory).build()
        Assert.assertEquals(aProduct.category(), aCategory)
    }

    @Test
    fun aProductHasAClientContactPhoto(){
        val aPhoto = "base64"
        val aProduct = ProductBuilder.aProduct().withPhoto(aPhoto).build()
        Assert.assertEquals(aProduct.photo(), aPhoto)
    }
}