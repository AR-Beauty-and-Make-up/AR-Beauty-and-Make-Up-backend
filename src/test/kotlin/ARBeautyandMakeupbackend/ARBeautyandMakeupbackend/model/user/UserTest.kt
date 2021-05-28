package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.user

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.builders.UserBuilder
import org.junit.Assert
import org.junit.Test
import java.time.LocalDate
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
        Assert.assertFalse(aUser.isAdmin)
    }

    @Test
    fun aUserIsAdmin(){
        val aUser = UserBuilder.aUser().buildAdmin()
        Assert.assertTrue(aUser.isAdmin)
    }

    @Test
    fun aUserClientHasOrders(){
        val aUser  = UserBuilder.aUser().build() as ClientUser
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
        val aDate = LocalDate.of(1994,3,12)
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

    @Test
    fun aUserHasAPhoto(){
        val aPhoto = "https://scontent.feze12-1.fna.fbcdn.net/v/t1.6435-9/42743411_10217402236033253_5298019150923300864_n.jpg?_nc_cat=102&ccb=1-3&_nc_sid=09cbfe&_nc_eui2=AeHfxPwmHPJiM33kjui7QZ8J5GW77mO_KxPkZbvuY78rEwUyPMWjEPXhLUxOX8atDh0&_nc_ohc=ViXyES6I23kAX8t8hi3&_nc_ht=scontent.feze12-1.fna&oh=08e0bf940508955c0a61f65bc06e8b58&oe=60D40A97"
        val aUser = UserBuilder.aUser().withPhoto(aPhoto).build()
        Assert.assertEquals(aUser.photo, aPhoto)
    }
}