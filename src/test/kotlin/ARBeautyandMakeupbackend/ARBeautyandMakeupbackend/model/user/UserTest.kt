package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.user

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.builders.UserBuilder
import org.junit.Assert
import org.junit.Test


class UserTest {


    @Test
    fun aUserHasAFullName(){
        val aFullname = "Lucas Avalos"
        val aUser = UserBuilder.aUser().withFullname(aFullname).build()
        Assert.assertEquals(aUser.fullname,aFullname)
    }

    @Test
    fun aUserHasAPassword(){
        val aPassword = "password"
        val aUser = UserBuilder.aUser().withPassword(aPassword).build()
        Assert.assertEquals(aUser.password, aPassword)
    }

    @Test
    fun aUserIsNotAdmin(){
        val aUser = UserBuilder.aUser().build()
        Assert.assertFalse(aUser.admin)
    }

    @Test
    fun aUserIsAdmin(){
        val aUser = UserBuilder.aUser().buildAdmin()
        Assert.assertTrue(aUser.admin)
    }

    @Test
    fun aUserClientHasOrders(){
        val aUser  = UserBuilder.aUser().build() as Client
        Assert.assertEquals(aUser.orders.size, 0)
    }

    @Test
    fun aUserHasAEmail(){
        val aEmail = "email"
        val aTurn = UserBuilder.aUser().withEmail(aEmail).build()
        Assert.assertEquals(aTurn.email, aEmail)
    }
}