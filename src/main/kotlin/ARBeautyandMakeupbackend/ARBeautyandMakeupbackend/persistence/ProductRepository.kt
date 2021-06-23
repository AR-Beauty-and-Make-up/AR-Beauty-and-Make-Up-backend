package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.persistence

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.category.Category
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.product.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : JpaRepository<Product, Long> {

    //@Query(value = "SELECT * FROM PRODUCT product WHERE product.category = :aCategory", nativeQuery = true)
    fun findAllByCategory(category: Category): List<Product>

    @Query(value = "SELECT DISTINCT Category FROM PRODUCT", nativeQuery = true)
    fun findAllCategories(): List<String>
}