package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.services

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.user.User
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.persistence.TurnRepository
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

    fun addUser(user : User) : User{
        return userRepository.save(user)
    }
}