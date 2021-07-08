package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.services

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.persistence.ProductPaginatedRepository
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.persistence.ProductRepository
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.persistence.TurnRepository
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.persistence.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FlushService {

    @Autowired
    lateinit var productRepository: ProductRepository

    @Autowired
    lateinit var productPaginatedRepository: ProductPaginatedRepository

    @Autowired
    lateinit var turnRepository: TurnRepository

    @Autowired
    lateinit var userRepository: UserRepository


    fun deleteAll() {
        productPaginatedRepository.deleteAll()
        productRepository.deleteAll()
        turnRepository.deleteAll()
        userRepository.deleteAll()
    }


}