package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.controllers

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers


@SpringBootTest
@RunWith(SpringRunner::class)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

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
        mockMvc.perform(MockMvcRequestBuilders.get("/products/Cremas")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.jsonPath("$").isArray)
            .andExpect(MockMvcResultMatchers.jsonPath("$.[0].category").value("Cremas"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.[1].category").value("Cremas"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.[2].category").value("Cremas"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.[3].category").value("Cremas"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.[4].category").value("Cremas"))
    }

    @Test
    fun ifWeAskForAllCateogriesOfProductsWeGetAllCategoriesAnd200Satus(){
        mockMvc.perform(MockMvcRequestBuilders.get("/categories")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.jsonPath("$").isArray)
            .andExpect(MockMvcResultMatchers.jsonPath("$.[0]").value("Cremas"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.[1]").value("Maquillaje"))
    }
}