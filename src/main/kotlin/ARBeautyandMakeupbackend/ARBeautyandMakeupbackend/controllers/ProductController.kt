package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.controllers

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.category.Category
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.product.Product
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.services.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.data.domain.Page
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import java.util.*


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


    @GetMapping("/products/page")
    fun getProducts(@RequestParam page : Optional<Int>, @RequestParam sort : Optional<String>): ResponseEntity<Page<Product>> {
        val products = productService.getProductPaginated(page.orElse(0), sort.orElse("id"))
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