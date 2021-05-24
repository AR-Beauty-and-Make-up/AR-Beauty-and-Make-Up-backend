package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.builders

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.category.Category
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.product.Product
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.user.Admin
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.user.Client
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.user.User
import java.time.LocalDateTime
import javax.persistence.Column

class UserBuilder {

    private var id: Long? = null
    private var fullname: String = "Lucas Avalos"
    private var password: String = "password"
    private var email: String = "lucas@gmail.com"
    private var dateOfBirth: LocalDateTime = LocalDateTime.of(1994,3,12, 7 ,0)
    private var contactNumber: Int = 1151214699
    private var address: String = "Calle Falsa 123, Berna, Buenos Aires (1879)"


    companion object {
        fun aUser(): UserBuilder {
            return UserBuilder()
        }
    }

    fun build() : Client {
        return Client(this.id, this.fullname, this.password, this.email, this.dateOfBirth, this.contactNumber, this.address)
    }

    fun buildAdmin() : Admin {
        return Admin(this.id, this.fullname, this.password, this.email, this.dateOfBirth, this.contactNumber, this.address)
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

    fun withDateOfBirth(aDate: LocalDateTime): UserBuilder {
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



}