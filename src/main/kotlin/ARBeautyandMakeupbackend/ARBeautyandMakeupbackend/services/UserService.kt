package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.services

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.user.Admin
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.user.Client
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

    fun addUser(clientUser : Client) : Client {
        return userRepository.save(clientUser)
    }

    fun getUsers(): List<User> {
        return userRepository.findAll()
    }

    fun addAdminUser(admin: Admin): Admin {
        return userRepository.save(admin)
    }
}