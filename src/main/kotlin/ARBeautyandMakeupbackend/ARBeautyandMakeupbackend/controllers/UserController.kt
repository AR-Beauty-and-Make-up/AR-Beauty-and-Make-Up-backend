package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.controllers


import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.turn.Turn
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.user.User
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate


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

}