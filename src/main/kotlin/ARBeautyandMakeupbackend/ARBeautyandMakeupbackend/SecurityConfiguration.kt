package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend

import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter


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