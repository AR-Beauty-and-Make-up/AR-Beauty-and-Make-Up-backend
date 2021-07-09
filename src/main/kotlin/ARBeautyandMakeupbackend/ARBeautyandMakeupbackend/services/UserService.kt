package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.services

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.handlers.NotFoundException
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.handlers.BadRequestException
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.purchase.Purchase
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.user.AdminUser
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.user.ClientUser
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.user.User
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.persistence.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService  {

    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var passwordEncoder: BCryptPasswordEncoder

    fun getUser(id: Long) : User {
        return userRepository.findById(id).get()
    }

    fun addUser(clientUserUser : ClientUser) : ClientUser {
        canAddUser(clientUserUser.email)
        clientUserUser.password = this.passwordEncoder.encode(clientUserUser.password)
        return userRepository.save(clientUserUser)
    }

    private fun canAddUser(email: String) {
        if(userRepository.existsUserByEmail(email)){
            throw BadRequestException("Mail already register")
        }
    }

    fun getUsers(): List<User> {
        return userRepository.findAll()
    }

    fun addAdminUser(adminUser: AdminUser): AdminUser {
        adminUser.password = this.passwordEncoder.encode(adminUser.password)
        return userRepository.save(adminUser)
    }



    fun authenticateUser(email: String, password: String): User {
        val user = userRepository.findByEmail(email) ?: throw NotFoundException("Invalid user")

        if(!this.passwordEncoder.matches(password, user.password)) {  throw NotFoundException("Invalid password") }

        return user
    }

    fun updateUser(id: Long, aUser: ClientUser): User {
        val retrievedUser = getUser(id);
        retrievedUser.fullname = aUser.fullname
        retrievedUser.dateOfBirth = aUser.dateOfBirth
        retrievedUser.contactNumber = aUser.contactNumber
        retrievedUser.address = aUser.address
        retrievedUser.password = aUser.password
        return userRepository.save(retrievedUser)
    }

    @Bean
    fun passwordEncoder() : BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }

    fun getPurchases(id: Long): MutableSet<Purchase> {
        return (this.getUser(id) as ClientUser).purchases
    }

    fun addPurchase(id: Long, purchase: Purchase) : User? {
        var user = this.getUser(id)
        user.addPurchase(purchase)
        return this.userRepository.save(user)
    }
}