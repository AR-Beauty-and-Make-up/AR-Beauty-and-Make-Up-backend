package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.persistence

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.product.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM PRODUCT product WHERE product.category = :aCategory", nativeQuery = true)
    fun findAllByACategory(aCategory: String): List<Product>
}