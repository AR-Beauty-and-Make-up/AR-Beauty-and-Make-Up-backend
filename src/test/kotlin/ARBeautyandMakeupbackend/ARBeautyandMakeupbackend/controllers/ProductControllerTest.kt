package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.controllers

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.DatabaseInitializate
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.builders.ProductBuilder
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.category.Category
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.services.FlushService
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.services.ProductService
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.transaction.annotation.Transactional


@SpringBootTest
@RunWith(SpringRunner::class)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
class ProductControllerTest {

    @Autowired
    lateinit var productService: ProductService

    @Autowired
    lateinit var mockMvc: MockMvc

    @MockBean
    lateinit var databaseInitializate: DatabaseInitializate

    @Test
    fun ifWeAskForProductsWeGetTheAllProducts(){
        //Como podria testear el contenido? guardar los productos en una lista pidiendoselos al service?
        //Como puedo chequear la cantidad de elementos de la lista retornada??
        mockMvc.perform(MockMvcRequestBuilders.get("/products")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.jsonPath("$").isArray)
    }

    @Test
    fun ifWeAskForProductsOfASpecificCategoryWeGetAllProductsWithThatCategory(){
        val product1 = ProductBuilder.aProduct().build()
        val product2 = ProductBuilder.aProduct().withName("Agua Micelar").build()
        val product3 = ProductBuilder.aProduct().withName("Crema para manos").build()
        productService.addProduct(product1)
        productService.addProduct(product2)
        productService.addProduct(product3)

        mockMvc.perform(MockMvcRequestBuilders.get("/products/Cremas")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.jsonPath("$").isArray)
            .andExpect(MockMvcResultMatchers.jsonPath("$.[0].category").value("Cremas"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.[1].category").value("Cremas"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.[2].category").value("Cremas"))
    }

    @Test
    fun ifWeAskForAllCateogriesOfProductsWeGetAllCategoriesAnd200Satus(){
        val product1 = ProductBuilder.aProduct().build()
        val product2 = ProductBuilder.aProduct().withName("Agua Micelar").build()
        val product3 = ProductBuilder.aProduct().withCategory(Category.Maquillaje).build()
        productService.addProduct(product1)
        productService.addProduct(product2)
        productService.addProduct(product3)

        mockMvc.perform(MockMvcRequestBuilders.get("/categories")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.jsonPath("$").isArray)
            .andExpect(MockMvcResultMatchers.jsonPath("$.[0]").value("Cremas"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.[1]").value("Maquillaje"))
    }


}