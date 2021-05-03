package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.repository

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.builders.ProductBuilder
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.persistence.ProductRepository
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductRepositoryTest {

    @Autowired
    lateinit var productRepository : ProductRepository

    @Test
    fun productRepositorySaveAndRetriveProduct(){
        val aProduct = ProductBuilder.aProduct().build()
        productRepository.save(aProduct)

        val retrievedProduct = productRepository.findById(aProduct.id!!).get()

        Assert.assertEquals(aProduct.productName(), retrievedProduct.productName())

    }

    @Test
    fun whenWeAskForAllProductsProductsRepositoryReturnsAListWithAllProducts(){
        val aProduct = ProductBuilder.aProduct().build()
        val anotherProduct = ProductBuilder.aProduct().withName("Agua Micelar").build()
        productRepository.save(aProduct)
        productRepository.save(anotherProduct)

        val retrievedProductList = productRepository.findAll()
        Assert.assertEquals(2, retrievedProductList.size)
    }

    @Test
    fun whenWeAskForAllProductsWithACategoryProductsRepositoryReturnsAListWithAllProductsWithThatCategory(){
        val cateogry ="Cremas"
        val aProduct = ProductBuilder.aProduct().build()
        val anotherProduct = ProductBuilder.aProduct().withName("Agua Micelar").build()
        val productWithDiferentCategory = ProductBuilder.aProduct().withCategory("Maquillaje").build()
        productRepository.save(productWithDiferentCategory)
        productRepository.save(aProduct)
        productRepository.save(anotherProduct)

        val retrievedProductList = productRepository.findAllByACategory(cateogry)
        Assert.assertEquals(2, retrievedProductList.size)
        Assert.assertFalse(retrievedProductList.contains(productWithDiferentCategory))
    }

}