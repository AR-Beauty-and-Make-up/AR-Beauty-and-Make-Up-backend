package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.services

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.handlers.NotFoundException
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.handlers.BadRequestException
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.purchase.Purchase
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
        canAddUser(clientUserUser.email)
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
        return userRepository.save(adminUser)
    }

    fun authenticateUser(email: String, password: String): User? {
        return userRepository.findByEmailAndPassword(email, password) ?: throw NotFoundException("Invalid user or password")
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

    @Transactional(readOnly = true)
    override fun loadUserByUsername(email: String): UserDetails {
        val user = userRepository.findByEmail(email)
        return org.springframework.security.core.userdetails.User(user?.email, user?.password, emptyList())
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