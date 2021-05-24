package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.persistence

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.user.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {

    fun findByEmailAndPassword(email: String, password: String): User?

}