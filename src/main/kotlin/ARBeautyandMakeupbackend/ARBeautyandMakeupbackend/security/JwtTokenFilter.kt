package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.security

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.services.UserService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class JwtTokenFilter : OncePerRequestFilter() {

    companion object {
        private val logger = LoggerFactory.getLogger(JwtTokenFilter::class.java)
    }

    @Autowired
    lateinit var jwtProvider: JwtProvider

    @Autowired
    lateinit var userDetailsService: UserService

    @Throws(ServletException::class, IOException::class)
    protected override fun doFilterInternal(req: HttpServletRequest, res: HttpServletResponse, filterChain: FilterChain) {
        try {
            val token = getToken(req)
            if (token != null && jwtProvider.validateToken(token)) {
                val nombreUsuario = jwtProvider.getNombreUsuarioFromToken(token)
                val userDetails: UserDetails = userDetailsService.loadUserByUsername(nombreUsuario)
                val auth = UsernamePasswordAuthenticationToken(userDetails, null, userDetails.authorities)
                SecurityContextHolder.getContext().authentication = auth
            }
        } catch (e: Exception) {
            logger.error("fail en el método doFilter " + e.message)
        }
        filterChain.doFilter(req, res)
    }

    private fun getToken(request: HttpServletRequest): String? {
        val header = request.getHeader("Authorization")
        return if (header != null && header.startsWith("Bearer")) header.replace("Bearer ", "") else null
    }


}