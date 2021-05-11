package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.services

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.category.Category
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.product.Product
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.persistence.ProductPaginatedRepository
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.persistence.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class ProductService {

    @Autowired
    lateinit var productRepository: ProductRepository

    @Autowired
    lateinit var productPaginatedRepository: ProductPaginatedRepository

    fun getProducts(): List<Product> {
        return productRepository.findAll()
    }

    fun addProduct(aProduct: Product): Product {
        return productRepository.save(aProduct)
    }

    fun find(id: Long): Product {
        return productRepository.findById(id).get()
    }

    fun findAllByACategory(aCategory: Category): List<Product> {
        return productRepository.findAllByACategory(aCategory.toString())
    }

    fun getCategories(): List<String> {
        return productRepository.findAllCategories()
    }

    fun getProductPaginated(page: Int, sort: String) : Page<Product> {

        return productPaginatedRepository.findAll(
                PageRequest.of(page,
                          5,
                               Sort.Direction.ASC,
                               sort),
        )
    }

}
