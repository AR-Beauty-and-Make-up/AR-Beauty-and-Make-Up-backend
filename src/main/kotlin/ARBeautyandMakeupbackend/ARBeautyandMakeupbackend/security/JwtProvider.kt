package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.security

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.user.User
import io.jsonwebtoken.*
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import java.util.*


@Component
class JwtProvider {

    companion object {
        private val logger = LoggerFactory.getLogger(JwtProvider::class.java)
    }

    @Value("\${jwt.secret}")
    private val secret: String? = null

    @Value("\${jwt.expiration}")
    private val expiration = 0
    fun generateToken(authentication: Authentication): String {
        val usuarioPrincipal: User = authentication.principal as User
        return Jwts.builder().setSubject(usuarioPrincipal.email)
                .setIssuedAt(Date())
                .setExpiration(Date(Date().time + expiration * 1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact()
    }

    fun getNombreUsuarioFromToken(token: String?): String {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).body.subject
    }

    fun validateToken(token: String?): Boolean {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token)
            return true
        } catch (e: MalformedJwtException) {
            logger.error("token mal formado")
        } catch (e: UnsupportedJwtException) {
            logger.error("token no soportado")
        } catch (e: ExpiredJwtException) {
            logger.error("token expirado")
        } catch (e: IllegalArgumentException) {
            logger.error("token vacío")
        } catch (e: SignatureException) {
            logger.error("fail en la firma")
        }
        return false
    }


}