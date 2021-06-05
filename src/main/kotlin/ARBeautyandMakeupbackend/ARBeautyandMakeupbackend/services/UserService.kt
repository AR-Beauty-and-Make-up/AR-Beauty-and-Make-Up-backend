package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.services

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.exceptions.NotFoundUserException
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.user.AdminUser
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.user.ClientUser
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.user.User
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.persistence.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService : UserDetailsService {

    @Autowired
    lateinit var userRepository: UserRepository


    fun getUser(id: Long) : User {
        return userRepository.findById(id).get()
    }

    fun addUser(clientUserUser : ClientUser) : ClientUser {
        return userRepository.save(clientUserUser)
    }

    fun getUsers(): List<User> {
        return userRepository.findAll()
    }

    fun addAdminUser(adminUser: AdminUser): AdminUser {
        return userRepository.save(adminUser)
    }

    fun authenticateUser(email: String, password: String): User? {
        return userRepository.findByEmailAndPassword(email, password) ?: throw NotFoundUserException("Invalid user or password")
    }

    @Transactional(readOnly = true)
    override fun loadUserByUsername(email: String): UserDetails {
        val user = userRepository.findByEmail(email)
        return org.springframework.security.core.userdetails.User(user?.email, user?.password, emptyList())
    }
}