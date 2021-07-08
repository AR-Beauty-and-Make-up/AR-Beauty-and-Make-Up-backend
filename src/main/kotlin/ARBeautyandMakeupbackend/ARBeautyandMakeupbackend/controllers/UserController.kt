package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.controllers


import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.purchase.Purchase
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.user.ClientUser
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

class UserController {

    @Autowired
    lateinit var userService: UserService


    @GetMapping("/user/{id}")
    fun getUserById(@PathVariable("id") id: Long): ResponseEntity<User> {
        val user = userService.getUser(id)
        val response = ResponseEntity.status(HttpStatus.OK).body(user)
        return response
    }

    @GetMapping("/users")
    fun getAllUsers(): List<User> {
        return userService.getUsers()
    }

    @RequestMapping("/users", method = [RequestMethod.POST])
    fun createUser(@RequestBody aUser: ClientUser): ResponseEntity<ClientUser> {
        val savedUser: ClientUser = userService.addUser(aUser)
        return ResponseEntity.status(HttpStatus.OK).body(savedUser)
    }

    @RequestMapping("/updateUser/{id}", method = [RequestMethod.PUT])
    fun updateUser(@RequestBody aUser: ClientUser, @PathVariable id: Long): ResponseEntity<User> {
        val updatedUser = userService.updateUser(id, aUser)
        return ResponseEntity.status(HttpStatus.OK).body(updatedUser)
    }

    @RequestMapping("/addPurchase/{id}", method = [RequestMethod.PUT])
    fun addPurchase(@RequestBody purchase: Purchase, @PathVariable id: Long): ResponseEntity<User> {
        val updatedUser = userService.addPurchase(id, purchase)
        return ResponseEntity.status(HttpStatus.OK).body(updatedUser)
    }

    @GetMapping("/purchases/{id}")
    fun getPurchases(@PathVariable id: Long): ResponseEntity<MutableSet<Purchase>> {
        val purchases = userService.getPurchases(id)
        return ResponseEntity.status(HttpStatus.OK).body(purchases)
    }

}