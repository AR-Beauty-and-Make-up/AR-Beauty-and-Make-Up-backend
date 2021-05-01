package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.turn.Turn
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.services.TurnService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class DatabaseInitializate : CommandLineRunner {

    @Autowired
    lateinit var turnService: TurnService


    override fun run(vararg args: String?) {

        var turnLucas = Turn("Lucas Avalos", LocalDateTime.of(2021, 4, 26, 9, 0), "Limpieza facial", 123456789)
        var turnLuciana = Turn("Luciana Alonso", LocalDateTime.of(2021, 4, 20, 10, 30), "Masajes", 1122334455)
        var turnBelen = Turn("Belen Amat", LocalDateTime.of(2021, 4, 20, 15, 0), "Maquillaje", 987654321)
        var turnMicaela = Turn("Micaela Alonso", LocalDateTime.of(2021, 4, 26, 15, 0,0), "Masajes", 123456789)
        var turnFrancisco = Turn("Francisco Perez", LocalDateTime.of(2021, 4, 20, 13, 30), "Mesoterapia", 123456789)
        var turnNicolas = Turn("Nicolas Rodriguez", LocalDateTime.of(2021, 4, 26, 16, 30), "Masajes", 123456789)

        turnService.addTurn(turnLucas)
        turnService.addTurn(turnLuciana)
        turnService.addTurn(turnBelen)
        turnService.addTurn(turnMicaela)
        turnService.addTurn(turnFrancisco)
        turnService.addTurn(turnNicolas)


    }
}