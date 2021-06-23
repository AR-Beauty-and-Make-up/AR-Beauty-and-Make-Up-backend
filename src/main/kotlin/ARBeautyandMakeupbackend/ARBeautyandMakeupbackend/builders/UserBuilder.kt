package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.builders

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.purchase.Purchase
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.user.AdminUser
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.user.ClientUser
import java.time.LocalDate

class UserBuilder {


    private var id: Long? = null
    private var photo: String? = null
    private var fullname: String = "Lucas Avalos"
    private var password: String = "Pass1234"
    private var email: String = "lucas@gmail.com"
    private var dateOfBirth: LocalDate = LocalDate.of(1994,3,12)
    private var contactNumber: Int = 1151214699
    private var address: String = "Calle Falsa 123, Berna, Buenos Aires (1879)"
    private var purchases: MutableList<Purchase> = mutableListOf(PurchaseBuilder.aPurchase().build())

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

    fun withPurchases(purchases: MutableList<Purchase>): UserBuilder {
        this.purchases = purchases
        return this
    }


}