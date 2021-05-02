package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.service

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.builders.ProductBuilder
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.persistence.ProductRepository
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.services.ProductService
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import org.springframework.boot.test.context.SpringBootTest
import java.util.*


@SpringBootTest
@RunWith(MockitoJUnitRunner::class)
class ProductServiceTest {

    @Mock
    lateinit var productRepositoryMock: ProductRepository

    @InjectMocks
    lateinit var productService: ProductService

    @Test
    fun whenWeAskProductServiceForAllProductsItReturnsAListOfTurns(){
        val allProducts = ProductBuilder.productList()
        `when`(productRepositoryMock.findAll()).thenReturn(allProducts)

        Assert.assertEquals(allProducts, productService.getProducts())
    }

    @Test
    fun whenWeAskProductServiceToAddANewProductReturnTheNewProduct() {
        val productToAdd = ProductBuilder.aProduct().build()
        `when`(productRepositoryMock.save(productToAdd)).thenReturn(productToAdd)

        Assert.assertEquals(productToAdd, productService.addProduct(productToAdd))
    }

    @Test
    fun whenWeAskProductServiceForAProductByIdReturnTheProduct() {
        val anId: Long = 1
        val aProduct = ProductBuilder.aProduct().withId(anId).build()
        `when`(productRepositoryMock.findById(anId)).thenReturn(Optional.of(aProduct))

        Assert.assertEquals(aProduct.productName(), productService.find(anId).productName())
    }

    @Test
    fun whenWeAskProductServiceForAllProductsWithACategoryReturnsAListOfProduct() {
        val listOfProductsWithDifrentCategory = ProductBuilder.productListWithDifrentCategory()
        `when`(productRepositoryMock.findAllByACategory("Cremas")).thenReturn(listOfProductsWithDifrentCategory)

        Assert.assertEquals(listOfProductsWithDifrentCategory.size, productService.findAllByACategory("Cremas").size)
    }

}