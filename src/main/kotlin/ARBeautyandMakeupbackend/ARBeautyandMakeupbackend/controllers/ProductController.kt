package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.controllers

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.category.Category
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.product.Product
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.services.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController


@RestController
@Transactional
@EnableAutoConfiguration
@CrossOrigin(origins = ["*"], allowedHeaders = ["*"])
class ProductController {

    @Autowired
    lateinit var productService: ProductService

    @GetMapping("/products")
    fun getProducts(): ResponseEntity<List<Product>> {
        val products = productService.getProducts()
        return ResponseEntity.status(HttpStatus.OK).body(products)
    }

    @GetMapping("/categories")
    fun getCategories(): ResponseEntity<List<String>> {
        val categories = productService.getCategories()
        val response = ResponseEntity.status(HttpStatus.OK).body(categories)

        return response
    }

    @GetMapping("/categories/{category}")
    fun getProductByCategory(@PathVariable("category") category: String): ResponseEntity<List<Product>> {
        val categories = productService.findAllByACategory(Category.valueOf(category))
        val response = ResponseEntity.status(HttpStatus.OK).body(categories)

        return response
    }
}