package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.turn

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.builders.TurnBuilder
import org.junit.Assert
import org.junit.Test
import java.time.LocalDateTime


class TurnTest {

    @Test
    fun aTurnHasADate(){
        val date = LocalDateTime.of(2021, 4, 20, 16,0)
        val aTurn = TurnBuilder.aTurn().withDate(date).build()
        Assert.assertEquals(aTurn.date(), date)
    }

    @Test
    fun aTurnHasAClient(){
        val aClient = "Lucas Avalos"
        val aTurn = TurnBuilder.aTurn().withName(aClient).build()
        Assert.assertEquals(aTurn.clientName(), aClient)
    }

    @Test
    fun aTurnHasACategory(){
        val aService = "Masajes"
        val aTurn = TurnBuilder.aTurn().withService(aService).build()
        Assert.assertEquals(aTurn.service(), aService)
    }

    @Test
    fun aTurnHasAClientContactNumber(){
        val aNumber = 1168686868
        val aTurn = TurnBuilder.aTurn().withContactClient(aNumber).build()
        Assert.assertEquals(aTurn.contactNumber(), aNumber)
    }
}