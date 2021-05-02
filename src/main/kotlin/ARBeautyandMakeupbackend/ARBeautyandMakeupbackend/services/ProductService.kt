package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.services

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.product.Product
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.persistence.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductService {

    @Autowired
    lateinit var productRepository: ProductRepository

    fun getProducts(): List<Product> {
        return productRepository.findAll()
    }

    fun addProduct(aProduct: Product): Product {
        return productRepository.save(aProduct)
    }

    fun find(id: Long): Product {
        return productRepository.findById(id).get()
    }

    fun findAllByACategory(aCategory: String): List<Product> {
        return productRepository.findAllByACategory(aCategory)
    }

}
