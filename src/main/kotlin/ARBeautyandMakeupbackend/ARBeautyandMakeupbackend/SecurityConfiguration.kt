package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder


@EnableWebSecurity
class SecurityConfiguration : WebSecurityConfigurerAdapter() {


    @Autowired
    private lateinit var userDetailService : UserService

    @Override
    override fun configure(http: HttpSecurity?) {
        http!!.authorizeRequests()
                .antMatchers("/**")
                .permitAll().and()
                .formLogin()
        http.cors().and().csrf().disable();

    }

    @Override
    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth?.userDetailsService(userDetailService)?.passwordEncoder(passwordEncoder())
    }

    @Bean
    fun passwordEncoder() : PasswordEncoder {
        return NoOpPasswordEncoder.getInstance()
    }
}