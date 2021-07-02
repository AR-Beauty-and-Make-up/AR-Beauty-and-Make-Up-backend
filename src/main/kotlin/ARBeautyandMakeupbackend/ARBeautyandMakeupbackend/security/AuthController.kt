package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.security

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.user.ValidationUserDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@Transactional
@CrossOrigin(origins = ["*"], allowedHeaders = ["*"])
class AuthController {

    @Autowired
    lateinit var passwordEncoder: PasswordEncoder

    @Autowired
    lateinit var authenticationManager: AuthenticationManager

    @Autowired
    lateinit var jwtProvider: JwtProvider


    @PostMapping("/login")
    fun login(@RequestBody loginUsuario: ValidationUserDTO): ResponseEntity<JwtDto> {

        val authentication: Authentication = authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken(loginUsuario.getEmail(),
                                                    loginUsuario.getPassword())
        )

        SecurityContextHolder.getContext().authentication = authentication
        val jwt: String = jwtProvider.generateToken(authentication)
        val userDetails = authentication.getPrincipal() as UserDetails
        val jwtDto = JwtDto(jwt, userDetails.username, userDetails.authorities)
        return ResponseEntity<JwtDto>(jwtDto, HttpStatus.OK)
    }

}