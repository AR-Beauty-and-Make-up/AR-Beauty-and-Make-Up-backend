package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.user

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty


class ValidationUserDTO {

    @JsonProperty
    private var email: String? = null

    @JsonProperty
    private var password: String? = null

    @JsonCreator
    fun ValidationUserDTO(@JsonProperty("email") email: String?, @JsonProperty("password") password: String?) {
        this.email = email
        this.password = password
    }

    fun getEmail(): String? {
        return email
    }

    fun getPassword(): String? {
        return password
    }

    fun setMail(email: String?) {
        this.email = email
    }

    fun setPassword(password: String?) {
        this.password = password
    }

}
