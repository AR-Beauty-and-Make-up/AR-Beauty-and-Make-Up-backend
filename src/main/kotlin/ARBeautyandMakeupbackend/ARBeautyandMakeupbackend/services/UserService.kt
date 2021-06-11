package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.services

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.handlers.NotFoundException
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.handlers.UserException
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.user.AdminUser
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.user.ClientUser
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.user.User
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.persistence.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

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
            throw UserException("Mail already register")
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
}