package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@EnableWebSecurity
class SecurityConfiguration : WebSecurityConfigurerAdapter() {


    @Override
    override fun configure(http: HttpSecurity?) {
        http!!.authorizeRequests()
                .antMatchers("/**")
                .permitAll().and()
                .formLogin()
        http.cors().and().csrf().disable();

    }


}

