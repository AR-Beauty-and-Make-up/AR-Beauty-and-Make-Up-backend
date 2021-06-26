package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.builders

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.category.Category
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.product.Product
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.purchase.ItemPurchase
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.purchase.Purchase
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.user.AdminUser
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.user.ClientUser
import java.time.LocalDate

class UserBuilder {


    val productCremaCorporal = Product("Body Training - Crema corporal", 450.0, Category.Cremas, "https://image.jimcdn.com/app/cms/image/transf/dimension=2048x2048:format=jpg/path/sd10c94a28a61d989/image/i0d53a6e6910adf28/version/1564426448/image.jpg")
    val productCremaParaCara = Product("Gold - Crema para Cara", 580.0, Category.Cremas, "https://image.jimcdn.com/app/cms/image/transf/dimension=2048x2048:format=jpg/path/sd10c94a28a61d989/image/ibb02f9cd79ab9020/version/1564156140/image.jpg")
    val productLabial30 = Product("Labial Idraet - Hypnotic Red", 320.0, Category.Cremas, "http://d2r9epyceweg5n.cloudfront.net/stores/001/206/163/products/pro-hyaluron-ultracolor-creamy-lip-lapiz-labial-cremoso-11-hypnotic-red1-e3bd77bab9d79c4ddd15850833487905-640-0.png")
    val productLabial21 = Product("Labial Idraet - Crush Coral", 320.0, Category.Cremas, "http://d2r9epyceweg5n.cloudfront.net/stores/001/170/247/products/pro-hyaluron-ultracolor-matte-lip-lapiz-labial-mate-30-crush-coral1-e6e5ff0a9f3e11890a15850837599452-640-01-1f7e745695d3baa20f16024443648168-640-0.png")
    val productDelineadorLiquido = Product("Delineador Líquido Idraet - Negro", 475.0, Category.Maquillaje, "https://www.heavenimagenes.com/heavencommerce/cbed7736-4c76-4fd0-b719-9ff071142423/images/v2/IDRAET/1809061423593523_01_medium.jpg")
    val productGelLipiadorCara = Product("Gel Lipiador Mandelic", 670.0, Category.Maquillaje, "http://d2r9epyceweg5n.cloudfront.net/stores/431/014/products/732-c1968d70dcaa70a5cb15964731733632-640-0.jpg")
    val productEspumaMicelar = Product("Espuma Micelar Exel", 590.0, Category.Maquillaje, "http://d3ugyf2ht6aenh.cloudfront.net/stores/887/684/products/espuma-promoter1-0e13680cbb79101ffc16166887759909-640-0.jpg")


    private var id: Long? = null
    private var photo: String? = null
    private var fullname: String = "Lucas Avalos"
    private var password: String = "Pass1234"
    private var email: String = "lucas@gmail.com"
    private var dateOfBirth: LocalDate = LocalDate.of(1994,3,12)
    private var contactNumber: Int = 1151214699
    private var address: String = "Calle Falsa 123, Berna, Buenos Aires (1879)"
    private var purchases: MutableSet<Purchase> = mutableSetOf(
            PurchaseBuilder.aPurchase().withDate(LocalDate.now().minusDays(2)).withPurchaseItems(setOf(
                    ItemPurchase(productLabial30, 2),
                    ItemPurchase(productDelineadorLiquido, 1))).build(),
            PurchaseBuilder.aPurchase().withDate(LocalDate.now().minusDays(1)).withPurchaseItems(setOf(
                    ItemPurchase(productGelLipiadorCara, 1),
                    ItemPurchase(productLabial21, 3))).build(),
            PurchaseBuilder.aPurchase().withPurchaseItems(setOf(
                    ItemPurchase(productCremaCorporal, 1),
                    ItemPurchase(productCremaParaCara, 1),
                    ItemPurchase(productEspumaMicelar, 1))).build()
    )

    companion object {
        fun aUser(): UserBuilder {
            return UserBuilder()
        }
    }

    fun build() : ClientUser {
        return ClientUser(this.id, this.photo, this.fullname, this.password, this.email, this.dateOfBirth, this.contactNumber, this.address, this.purchases)
    }

    fun buildAdmin() : AdminUser {
        return AdminUser(this.id, this.photo, this.fullname, this.password, this.email, this.dateOfBirth, this.contactNumber, this.address)
    }


    fun withId(anId: Long): UserBuilder {
        this.id = anId
        return this
    }

    fun withFullname(aFullname: String): UserBuilder {
        this.fullname = aFullname
        return this
    }

    fun withPassword(aPassword: String): UserBuilder {
        this.password = aPassword
        return this
    }


    fun withEmail(aEmail: String): UserBuilder {
        this.email = aEmail
        return this
    }

    fun withDateOfBirth(aDate: LocalDate): UserBuilder {
        this.dateOfBirth = aDate
        return this
    }

    fun withConcatNumber(aContactNumber: Int): UserBuilder {
        this.contactNumber = aContactNumber
        return this
    }

    fun withAddress(anAddress: String): UserBuilder {
        this.address = anAddress
        return this
    }

    fun withPhoto(aPhoto: String): UserBuilder {
        this.photo = aPhoto
        return this
    }

    fun withPurchases(purchases: MutableSet<Purchase>): UserBuilder {
        this.purchases = purchases
        return this
    }


}