package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.security

import org.slf4j.LoggerFactory
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.stereotype.Component
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@Component
class JwtEntryPoint : AuthenticationEntryPoint {

    companion object {
        private val logger = LoggerFactory.getLogger(JwtEntryPoint::class.java)
    }

    @Throws(IOException::class, ServletException::class)
    override fun commence(req: HttpServletRequest?, res: HttpServletResponse, e: AuthenticationException?) {
        logger.error("fail en el método commence")
        res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "no autorizado")
    }

}