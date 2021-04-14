package model

import org.junit.Assert
import org.junit.Test
import java.time.LocalDateTime


class TurnTest {

    @Test
    fun aTurnHasADate(){
        val date = LocalDateTime.of(2021, 4, 20, 16,0)
        val aClient = "Lucas Avalos"
        val aTurn = Turn(date,aClient)
        Assert.assertEquals(aTurn.date(), date)
    }

    @Test
    fun aTurnHasAClient(){
        val date = LocalDateTime.of(2021, 4, 20, 16,0)
        val aClient = "Lucas Avalos"
        val aTurn = Turn(date, aClient)
        Assert.assertEquals(aTurn.clientName(), aClient)
    }
}