package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.controllers

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.user.User
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.user.ValidationUserDTO
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.services.UserService
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletResponse


@RestController
@Transactional
class AuthController {

    @Autowired
    private lateinit var userService : UserService


    @PostMapping("/validateUser")
    fun validateUser(@RequestBody validationUserDTO: ValidationUserDTO, response: HttpServletResponse): ResponseEntity<User> {

        val user = userService.authenticateUser(validationUserDTO.getEmail()!!, validationUserDTO.getPassword()!!)

        val jwt = Jwts.builder()
                    .setIssuer(user.id.toString())
                    .setExpiration(Date(System.currentTimeMillis() + 60 * 24 * 1000 * 7)) // 7 days
                    .signWith(SignatureAlgorithm.HS512, "secret-AR").compact()

        val cookie = Cookie("jwt", jwt)
        cookie.isHttpOnly = true

        response.addCookie(cookie)
        return ResponseEntity.status(HttpStatus.OK).body(user)
    }

    @GetMapping("/user")
    fun getAuthenticatedUser(@CookieValue("jwt") jwt: String?) : ResponseEntity<Any> {
        return if(jwt ==  null) {
            ResponseEntity.status(HttpStatus.OK).body(null)
        }
        else {
            val body = Jwts.parser().setSigningKey("secret-AR").parseClaimsJws(jwt).body
            ResponseEntity.status(HttpStatus.OK).body(this.userService.getUser(body.issuer.toLong()))
        }
    }

    @PostMapping("logout-user")
    fun logout(response: HttpServletResponse): ResponseEntity<Any> {
        val cookie = Cookie("jwt", "")
        cookie.maxAge = 0

        response.addCookie(cookie)

        return ResponseEntity.ok("Logged out")
    }

}