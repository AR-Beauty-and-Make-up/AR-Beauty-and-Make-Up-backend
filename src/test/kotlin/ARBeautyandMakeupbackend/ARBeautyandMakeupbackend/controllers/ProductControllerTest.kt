package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.controllers

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.builders.ProductBuilder
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.category.Category
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.services.ProductService
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers


@SpringBootTest
@RunWith(SpringRunner::class)
@AutoConfigureMockMvc
class ProductControllerTest {

    @MockBean
    lateinit var productServiceMock: ProductService

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun ifWeAskForProductsWeGetTheAllProducts(){
        var allProducts = ProductBuilder.productList()
        `when`(productServiceMock.getProducts()).thenReturn(allProducts)

        mockMvc.perform(MockMvcRequestBuilders.get("/products"))
            .andExpect(MockMvcResultMatchers.status().isOk)
    }

    /*
    @Test
    fun ifWeAskForProductsOfASpecificCategoryWeGetTheoOnlyProductsWithThatCategory(){
        var allProducts = ProductBuilder.productListWithDifrentCategory()
        `when`(productServiceMock.findAllByACategory(Category.Cremas)).thenReturn(allProducts)

        mockMvc.perform(MockMvcRequestBuilders.get("/products/Cremas"))
                .andExpect(MockMvcResultMatchers.status().isOk)
    }
    */
}