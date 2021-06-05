package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.repository

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.builders.ProductBuilder
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.persistence.ProductPaginatedRepository
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.persistence.ProductRepository
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.domain.PageRequest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@DataJpaTest
class ProductPaginatedRepositoryTest {
    @Autowired
    lateinit var productPaginatedRepository : ProductPaginatedRepository

    @Test
    fun productRepositorySaveAndRetriveAListOfProducts(){
        val aProduct = ProductBuilder.aProduct().build()
        productPaginatedRepository.save(aProduct)

        val listOfProducts = productPaginatedRepository.findAll()

        Assert.assertTrue(listOfProducts.contains(aProduct))

    }

    @Test
    fun productRepositorySaveAndRetriveAListOfProductsPaginated(){
        val product1 = ProductBuilder.aProduct().build()
        val product2 = ProductBuilder.aProduct().withName("Rubor").build()
        productPaginatedRepository.save(product1)
        productPaginatedRepository.save(product2)

        val listOfProducts = productPaginatedRepository.findAll(PageRequest.of(1, 1)).toList()

        Assert.assertFalse(listOfProducts.contains(product1))
        Assert.assertTrue(listOfProducts.contains(product2))

    }
}