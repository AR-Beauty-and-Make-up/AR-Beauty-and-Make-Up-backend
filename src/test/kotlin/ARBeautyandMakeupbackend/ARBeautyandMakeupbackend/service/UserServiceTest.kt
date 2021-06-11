package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.service

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.builders.TurnBuilder
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.builders.UserBuilder
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.persistence.TurnRepository
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.persistence.UserRepository
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.services.TurnService
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.services.UserService
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.any
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.springframework.boot.test.context.SpringBootTest
import java.util.*


@SpringBootTest
@RunWith(MockitoJUnitRunner::class)
class UserServiceTest {

    @Mock
    lateinit var userRepositoryMock : UserRepository

    @InjectMocks
    lateinit var userService: UserService

    @Test
    fun whenWeAskUserServiceAUserReturnThatUser(){
        val user = UserBuilder.aUser().withId(1).build()
        Mockito.`when`(userRepositoryMock.findById(user.id!!)).thenReturn(Optional.of(user))

        Assert.assertEquals(user.fullname, userService.getUser(user.id!!).fullname)
    }

    @Test
    fun aClientUserCanHaveItsDataUpdated(){
        val user = UserBuilder.aUser().withId(1).build()
        val updatedUser = UserBuilder.aUser().withId(1).withFullname("Lucas Emiliano Avalos").build()

        Mockito.`when`(userRepositoryMock.findById(user.id!!)).thenReturn(Optional.of(user))
        Mockito.`when`(userRepositoryMock.save(any())).thenReturn(updatedUser)

        val retrievedUser = userService.updateUser(user.id!!, updatedUser)

        Assert.assertEquals("Lucas Emiliano Avalos", retrievedUser.fullname)
    }


}