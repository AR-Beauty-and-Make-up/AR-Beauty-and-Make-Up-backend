package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.controllers


import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.purchase.Purchase
import com.mercadopago.MercadoPago
import com.mercadopago.resources.Preference
import com.mercadopago.resources.datastructures.preference.BackUrls
import com.mercadopago.resources.datastructures.preference.Item
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
@Transactional
@EnableAutoConfiguration
@CrossOrigin(origins = ["http://localhost:3000/**"])
class MercadoPagoController {


    @PostMapping("/check-out")
    fun checkOut(@RequestBody purchase: Purchase): ResponseEntity<String>? {

        MercadoPago.SDK.setAccessToken("TEST-3941930486304580-061815-0686b6de26a316f6adeb2b5c4701a2db-777675718");

        val preference = Preference()

        purchase.purchaseItems.forEach { purchaseItem ->

            val item = Item()
            item.setTitle(purchaseItem.product.productName)
                    .setQuantity(purchaseItem.quantity)
                    .setUnitPrice(purchaseItem.product.price.toFloat())
            preference.appendItem(item)
        }

        val backUrls = BackUrls(
                "http://localhost:3000/postpayment",
                "http://localhost:3000/postpayment",
                "http://localhost:3000/postpayment")

        preference.backUrls = backUrls
        preference.autoReturn = Preference.AutoReturn.approved
        preference.save()

        return ResponseEntity.status(HttpStatus.OK).body(preference.initPoint)
    }

}