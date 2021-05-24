package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.controllers


import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.user.Client
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.user.User
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.user.ValidationUserDTO
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*


@RestController
@Transactional
@EnableAutoConfiguration
@CrossOrigin(origins = ["*"], allowedHeaders = ["*"])
class UserController {

    @Autowired
    lateinit var userService: UserService


    @GetMapping("/user/{id}")
    fun getTurnsByDate(@PathVariable("id") id: Long): ResponseEntity<User> {
        val user = userService.getUser(id)
        val response = ResponseEntity.status(HttpStatus.OK).body(user)
        return response
    }

    @GetMapping("/users")
    fun getAllUsers(): List<User> {
        return userService.getUsers()
    }

    @RequestMapping("/users", method = [RequestMethod.POST])
    fun createUser(@RequestBody aUser: Client): ResponseEntity<Client> {
        val savedUser: Client = userService.addUser(aUser)
        return ResponseEntity.status(HttpStatus.OK).body(savedUser)
    }

    @RequestMapping("/validateUser", method = [RequestMethod.POST])
    fun validateUser(@RequestBody validationUserDTO: ValidationUserDTO): ResponseEntity<User>{
        val aUser = userService.authenticateUser(validationUserDTO.getEmail()!!, validationUserDTO.getPassword()!!)
        return ResponseEntity.status(HttpStatus.OK).body(aUser)
    }

}