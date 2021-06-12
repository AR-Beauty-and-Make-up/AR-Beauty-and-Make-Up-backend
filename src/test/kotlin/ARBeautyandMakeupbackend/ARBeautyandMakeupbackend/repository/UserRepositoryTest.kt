package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.repository

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.builders.UserBuilder
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.user.User
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.persistence.UserRepository
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@DataJpaTest
class UserRepositoryTest {

    @Autowired
    lateinit var userRepository: UserRepository

    @Test
    fun testUserRepositorySaveAndRetrievedAClientUser(){
        val clientUser: User = UserBuilder.aUser().build()
        userRepository.save(clientUser)

        val retrievedClienUser: User = userRepository.findById(clientUser.id!!).get()

        Assert.assertEquals(clientUser.fullname, retrievedClienUser.fullname)
    }

    @Test
    fun testUserRepositorySaveAndRetrievedAnAdminUser(){
        val adminUser: User = UserBuilder.aUser().buildAdmin()
        userRepository.save(adminUser)

        val retrievedAdminUser = userRepository.findById(adminUser.id!!).get()

        Assert.assertEquals(adminUser.fullname, retrievedAdminUser.fullname)
        Assert.assertTrue(retrievedAdminUser.isAdmin)
    }

    @Test
    fun testUserRepositoryUpdateAndRetrievedaClientUser(){
        val clientUser: User = UserBuilder.aUser().build()
        userRepository.save(clientUser)

        val retrievedClientUser: User = userRepository.findById(clientUser.id!!).get()
        retrievedClientUser.fullname = "Lucas Emiliano Avalos"

        userRepository.save(retrievedClientUser)

        Assert.assertEquals("Lucas Emiliano Avalos", retrievedClientUser.fullname)
    }
}