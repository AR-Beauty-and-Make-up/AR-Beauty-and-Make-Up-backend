package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.util

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.user.User
import com.fasterxml.jackson.databind.ObjectMapper
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm

import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import java.util.*
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JWTAuthenticationFilter(authManager: AuthenticationManager) : UsernamePasswordAuthenticationFilter() {
    init {
        authenticationManager = authManager
    }

    val SECRET = "SecretKeyToGenJWTs"
    val EXPIRATION_TIME: Long = 864000000 // 10 days
    val TOKEN_PREFIX = "Bearer "
    val HEADER_STRING = "Authorization"


    override fun attemptAuthentication(
            req: HttpServletRequest, res: HttpServletResponse): org.springframework.security.core.Authentication? {
        val creds = ObjectMapper()
                .readValue(req.inputStream, User::class.java)
        return authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken(
                        creds.email,
                        creds.password,
                        emptyList<GrantedAuthority>()
                )
        )
    }


    override fun successfulAuthentication(
            req: HttpServletRequest,
            res: HttpServletResponse, chain: FilterChain?,
            auth: Authentication) {
        val JWT = Jwts.builder()
                .setSubject((auth.principal as org.springframework.security.core.userdetails.User).username)
                .setExpiration(Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact()
        res.addHeader(HEADER_STRING, "$TOKEN_PREFIX $JWT")
    }
}