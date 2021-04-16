package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.Turn
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

        var turnLucas = Turn("Lucas Avalos", LocalDateTime.of(2021, 4, 25, 16, 0), "Masajes", 123456789)
        var turnLuciana = Turn("Luciana Alonso", LocalDateTime.of(2021, 4, 20, 10, 0), "Masajes", 1122334455)
        var turnBelen = Turn("Belen Amat", LocalDateTime.of(2021, 4, 20, 11, 0), "Maquillaje", 987654321)
        var turnMicaela = Turn("Micaela Alonso", LocalDateTime.of(2021, 4, 25, 15, 0), "Limpieza facial", 123456789)
        var turnFrancisco = Turn("Francisco Perez", LocalDateTime.of(2021, 4, 20, 16, 0), "Mesoterapia", 123456789)
        var turnNicolas = Turn("Nicolas Rodriguez", LocalDateTime.of(2021, 4, 25, 10, 0), "Masajes", 123456789)

        turnService.addTurn(turnLucas)
        turnService.addTurn(turnLuciana)
        turnService.addTurn(turnBelen)
        turnService.addTurn(turnMicaela)
        turnService.addTurn(turnFrancisco)
        turnService.addTurn(turnNicolas)


    }
}