package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.persistence

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.product.Product
import org.springframework.data.repository.PagingAndSortingRepository

interface ProductPaginatedRepository : PagingAndSortingRepository<Product, Long> {




}