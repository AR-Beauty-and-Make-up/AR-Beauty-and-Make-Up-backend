package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.user

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.builders.UserBuilder
import org.junit.Assert
import org.junit.Test
import java.time.LocalDateTime


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
        val aUser = UserBuilder.aUser().withEmail(aEmail).build()
        Assert.assertEquals(aUser.email, aEmail)
    }

    @Test
    fun aUserHasADateOfBirth(){
        val aDate = LocalDateTime.of(1994,3,12,12,0)
        val aUser = UserBuilder.aUser().withDateOfBirth(aDate).build()
        Assert.assertEquals(aUser.dateOfBirth, aDate)
    }

    @Test
    fun aUserHasAContactNumber(){
        val aContactNumber = 1151214699
        val aUser = UserBuilder.aUser().withConcatNumber(aContactNumber).build()
        Assert.assertEquals(aUser.contactNumber, aContactNumber)
    }

    @Test
    fun aUserHasAnAddress(){
        val anAddress = "Calle falsa 123, Bernal, Buenos Aires (1878)"
        val aUser = UserBuilder.aUser().withAddress(anAddress).build()
        Assert.assertEquals(aUser.address, anAddress)
    }
}