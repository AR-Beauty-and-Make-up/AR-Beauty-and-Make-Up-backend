package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.builders.UserBuilder
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.category.Category
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.product.Product
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.service.Service
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.turn.Turn
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.services.FlushService
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.services.ProductService
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.services.TurnService
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class DatabaseInitializate : CommandLineRunner {

    @Autowired
    lateinit var turnService: TurnService

    @Autowired
    lateinit var productService: ProductService

    @Autowired
    lateinit var userService: UserService

    @Autowired
    lateinit var flushService : FlushService


    override fun run(vararg args: String?) {

        flushService.deleteAll()

        val turnLucas = Turn("Lucas Avalos", LocalDateTime.of(2021, 6, 4, 9, 0), Service.Mesoterapia, 123456789, "lucas@gmail.com")
        val turnLuciana = Turn("Luciana Alonso", LocalDateTime.of(2021, 4, 20, 10, 30), Service.MasajeReductor, 1122334455, "luciana@gmail.com")
        val turnBelen = Turn("Belen Amat", LocalDateTime.of(2021, 4, 20, 15, 0), Service.Maquillaje, 987654321, "belen@gmail.com")
        val turnMicaela = Turn("Micaela Alonso", LocalDateTime.of(2021, 4, 26, 15, 0,0), Service.Mesoterapia, 123456789, "mica@gmail.com")
        val turnFrancisco = Turn("Francisco Perez", LocalDateTime.of(2021, 4, 20, 13, 30), Service.MasajeReductor, 123456789, "fran@gmail.com")
        val turnNicolas = Turn("Nicolas Rodriguez", LocalDateTime.of(2021, 4, 26, 16, 30), Service.Ultracavitacion, 123456789, "nico@gmail.com")

        turnService.addTurn(turnLucas)
        turnService.addTurn(turnLuciana)
        turnService.addTurn(turnBelen)
        turnService.addTurn(turnMicaela)
        turnService.addTurn(turnFrancisco)
        turnService.addTurn(turnNicolas)

        val productCremaCorporal = Product("Body Training - Crema corporal", 450.0, Category.Cremas, "https://image.jimcdn.com/app/cms/image/transf/dimension=2048x2048:format=jpg/path/sd10c94a28a61d989/image/i0d53a6e6910adf28/version/1564426448/image.jpg")
        val productCremaParaCara = Product("Gold - Crema para Cara", 580.0, Category.Cremas, "https://image.jimcdn.com/app/cms/image/transf/dimension=2048x2048:format=jpg/path/sd10c94a28a61d989/image/ibb02f9cd79ab9020/version/1564156140/image.jpg")
        val productLabial30 = Product("Labial Idraet - Hypnotic Red", 320.0, Category.Cremas, "http://d2r9epyceweg5n.cloudfront.net/stores/001/206/163/products/pro-hyaluron-ultracolor-creamy-lip-lapiz-labial-cremoso-11-hypnotic-red1-e3bd77bab9d79c4ddd15850833487905-640-0.png")
        val productLabial21 = Product("Labial Idraet - Crush Coral", 320.0, Category.Cremas, "http://d2r9epyceweg5n.cloudfront.net/stores/001/170/247/products/pro-hyaluron-ultracolor-matte-lip-lapiz-labial-mate-30-crush-coral1-e6e5ff0a9f3e11890a15850837599452-640-01-1f7e745695d3baa20f16024443648168-640-0.png")
        val productDelineadorLiquido = Product("Delineador Líquido Idraet - Negro", 475.0, Category.Maquillaje, "https://www.heavenimagenes.com/heavencommerce/cbed7736-4c76-4fd0-b719-9ff071142423/images/v2/IDRAET/1809061423593523_01_medium.jpg")
        val productGelLipiadorCara = Product("Gel Lipiador Mandelic", 670.0, Category.Maquillaje, "http://d2r9epyceweg5n.cloudfront.net/stores/431/014/products/732-c1968d70dcaa70a5cb15964731733632-640-0.jpg")
        val productEspumaMicelar = Product("Espuma Micelar Exel", 590.0, Category.Maquillaje, "http://d3ugyf2ht6aenh.cloudfront.net/stores/887/684/products/espuma-promoter1-0e13680cbb79101ffc16166887759909-640-0.jpg")

        val productCremaCorporal2 = Product("Body Training - Crema corporal", 450.0, Category.Cremas, "https://image.jimcdn.com/app/cms/image/transf/dimension=2048x2048:format=jpg/path/sd10c94a28a61d989/image/i0d53a6e6910adf28/version/1564426448/image.jpg")
        val productCremaParaCara2 = Product("Gold - Crema para Cara", 580.0, Category.Cremas, "https://image.jimcdn.com/app/cms/image/transf/dimension=2048x2048:format=jpg/path/sd10c94a28a61d989/image/ibb02f9cd79ab9020/version/1564156140/image.jpg")
        val productLabial302 = Product("Labial Idraet - Hypnotic Red", 320.0, Category.Cremas, "http://d2r9epyceweg5n.cloudfront.net/stores/001/206/163/products/pro-hyaluron-ultracolor-creamy-lip-lapiz-labial-cremoso-11-hypnotic-red1-e3bd77bab9d79c4ddd15850833487905-640-0.png")
        val productLabial212 = Product("Labial Idraet - Crush Coral", 320.0, Category.Cremas, "http://d2r9epyceweg5n.cloudfront.net/stores/001/170/247/products/pro-hyaluron-ultracolor-matte-lip-lapiz-labial-mate-30-crush-coral1-e6e5ff0a9f3e11890a15850837599452-640-01-1f7e745695d3baa20f16024443648168-640-0.png")
        val productDelineadorLiquido2 = Product("Delineador Líquido Idraet - Negro", 475.0, Category.Maquillaje, "https://www.heavenimagenes.com/heavencommerce/cbed7736-4c76-4fd0-b719-9ff071142423/images/v2/IDRAET/1809061423593523_01_medium.jpg")
        val productGelLipiadorCara2 = Product("Gel Lipiador Mandelic", 670.0, Category.Maquillaje, "http://d2r9epyceweg5n.cloudfront.net/stores/431/014/products/732-c1968d70dcaa70a5cb15964731733632-640-0.jpg")
        val productEspumaMicelar2 = Product("Espuma Micelar Exel", 590.0, Category.Maquillaje, "http://d3ugyf2ht6aenh.cloudfront.net/stores/887/684/products/espuma-promoter1-0e13680cbb79101ffc16166887759909-640-0.jpg")

        val productCremaCorporal3 = Product("Body Training - Crema corporal", 450.0, Category.Cremas, "https://image.jimcdn.com/app/cms/image/transf/dimension=2048x2048:format=jpg/path/sd10c94a28a61d989/image/i0d53a6e6910adf28/version/1564426448/image.jpg")
        val productCremaParaCara3 = Product("Gold - Crema para Cara", 580.0, Category.Cremas, "https://image.jimcdn.com/app/cms/image/transf/dimension=2048x2048:format=jpg/path/sd10c94a28a61d989/image/ibb02f9cd79ab9020/version/1564156140/image.jpg")
        val productLabial303 = Product("Labial Idraet - Hypnotic Red", 320.0, Category.Cremas, "http://d2r9epyceweg5n.cloudfront.net/stores/001/206/163/products/pro-hyaluron-ultracolor-creamy-lip-lapiz-labial-cremoso-11-hypnotic-red1-e3bd77bab9d79c4ddd15850833487905-640-0.png")
        val productLabial213 = Product("Labial Idraet - Crush Coral", 320.0, Category.Cremas, "http://d2r9epyceweg5n.cloudfront.net/stores/001/170/247/products/pro-hyaluron-ultracolor-matte-lip-lapiz-labial-mate-30-crush-coral1-e6e5ff0a9f3e11890a15850837599452-640-01-1f7e745695d3baa20f16024443648168-640-0.png")
        val productDelineadorLiquido3 = Product("Delineador Líquido Idraet - Negro", 475.0, Category.Maquillaje, "https://www.heavenimagenes.com/heavencommerce/cbed7736-4c76-4fd0-b719-9ff071142423/images/v2/IDRAET/1809061423593523_01_medium.jpg")
        val productGelLipiadorCara3 = Product("Gel Lipiador Mandelic", 670.0, Category.Maquillaje, "http://d2r9epyceweg5n.cloudfront.net/stores/431/014/products/732-c1968d70dcaa70a5cb15964731733632-640-0.jpg")
        val productEspumaMicelar3 = Product("Espuma Micelar Exel", 590.0, Category.Maquillaje, "http://d3ugyf2ht6aenh.cloudfront.net/stores/887/684/products/espuma-promoter1-0e13680cbb79101ffc16166887759909-640-0.jpg")

        productService.addProduct(productCremaCorporal)
        productService.addProduct(productCremaParaCara)
        productService.addProduct(productLabial30)
        productService.addProduct(productLabial21)
        productService.addProduct(productDelineadorLiquido)
        productService.addProduct(productGelLipiadorCara)
        productService.addProduct(productEspumaMicelar)

        productService.addProduct(productCremaCorporal2)
        productService.addProduct(productCremaParaCara2)
        productService.addProduct(productLabial302)
        productService.addProduct(productLabial212)
        productService.addProduct(productDelineadorLiquido2)
        productService.addProduct(productGelLipiadorCara2)
        productService.addProduct(productEspumaMicelar2)

        productService.addProduct(productCremaCorporal3)
        productService.addProduct(productCremaParaCara3)
        productService.addProduct(productLabial303)
        productService.addProduct(productLabial213)
        productService.addProduct(productDelineadorLiquido3)
        productService.addProduct(productGelLipiadorCara3)
        productService.addProduct(productEspumaMicelar3)



        val photo = "https://scontent.feze12-1.fna.fbcdn.net/v/t1.6435-9/42743411_10217402236033253_5298019150923300864_n.jpg?_nc_cat=102&ccb=1-3&_nc_sid=09cbfe&_nc_eui2=AeHfxPwmHPJiM33kjui7QZ8J5GW77mO_KxPkZbvuY78rEwUyPMWjEPXhLUxOX8atDh0&_nc_ohc=z0Dky4E7oMUAX_-Lomu&_nc_ht=scontent.feze12-1.fna&oh=09d27eedce44f332a1378c2ccbec7935&oe=60E3DC97"
        val user = UserBuilder.aUser().withPhoto(photo).build()
        val anotherUser = UserBuilder.aUser().withFullname("Luciana Alonso").withEmail("luciana@gamil.com").withConcatNumber(1144778899).build()
        val admin = UserBuilder.aUser().withFullname("Andrea Rudi").withConcatNumber(1162434990).withEmail("andrearudi@gmail.com").buildAdmin()

        userService.addUser(user)
        userService.addUser(anotherUser)
        userService.addAdminUser(admin)
    }
}