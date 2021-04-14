package model

import builders.TurnBuilder
import org.junit.Assert
import org.junit.Test
import java.time.LocalDateTime


class TurnTest {

    @Test
    fun aTurnHasADate(){
        val date = LocalDateTime.of(2021, 4, 20, 16,0)
        val aTurn = TurnBuilder.aTurn().build()
        Assert.assertEquals(aTurn.date(), date)
    }

    @Test
    fun aTurnHasAClient(){
        val aTurn = TurnBuilder.aTurn().build()
        val aClient = "Lucas Avalos"
        Assert.assertEquals(aTurn.clientName(), aClient)
    }

    @Test
    fun aTurnHasACategory(){
        val aTurn = TurnBuilder.aTurn().build()
        val aService = "Masajes"
        Assert.assertEquals(aTurn.service(), aService)
    }
}