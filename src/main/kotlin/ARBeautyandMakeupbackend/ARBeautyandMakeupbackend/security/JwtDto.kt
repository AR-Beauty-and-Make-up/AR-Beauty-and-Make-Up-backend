package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.security

import org.springframework.security.core.GrantedAuthority

class JwtDto(jwt: String, username: String, authorities: MutableCollection<out GrantedAuthority>) {
}