package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.builders

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.category.Category
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.product.Product
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.user.Admin
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.user.Client
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.user.User
import javax.persistence.Column

class UserBuilder {

    private var id: Long? = null
    private var fullname: String = "Lucas Avalos"
    private var password: String = "password"
    private var email: String = "lucas@gmail.com"


    companion object {
        fun aUser(): UserBuilder {
            return UserBuilder()
        }
    }

    fun build() : User {
        return Client(this.id, this.fullname, this.password, this.email)
    }

    fun buildAdmin() : User {
        return Admin(this.id, this.fullname, this.password, this.email)
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



}