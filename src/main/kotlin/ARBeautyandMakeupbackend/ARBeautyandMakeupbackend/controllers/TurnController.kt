package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.controllers

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.Turn
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.services.TurnService
import com.fasterxml.jackson.databind.JsonNode
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import java.time.LocalDate
import java.time.LocalDateTime


@RestController
@Transactional
@EnableAutoConfiguration
@CrossOrigin(origins = ["*"], allowedHeaders = ["*"])
class TurnController {

    @Autowired
    lateinit var turnService: TurnService

    @GetMapping("/turns")
    fun getTurns(): ResponseEntity<List<Turn>> {

        val turns = turnService.getTurns()
        val response = ResponseEntity.status(HttpStatus.OK).body(turns)

        return response
    }

    @GetMapping("/turns/{date}")
    fun getTurnsByDate(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) date: LocalDate): ResponseEntity<List<Turn>> {
        val turns = turnService.findAllByDate(date)
        val response = ResponseEntity.status(HttpStatus.OK).body(turns)

        return response
    }

    @PostMapping("/turn")
    fun createTurn(@RequestBody aTurn: JsonNode): HttpStatus {
        var dateTime = aTurn["date"].toString().filterNot { it == '"' }


        var newTurn = Turn(aTurn["name"].toString().filterNot { it == '"' }, LocalDateTime.parse(dateTime), aTurn["service"].toString().filterNot { it == '"' }, aTurn["tel"].asInt())
        turnService.addTurn(newTurn)

        return HttpStatus.OK
    }

    @PutMapping("turns/{id}")
    fun updateTurn(@RequestBody aTurn: Turn, @PathVariable("id") id: String): ResponseEntity<Turn>{
        var turnId = id.toLong()
        var turnToUpdate = turnService.updateTurn(turnId, aTurn)

        return ResponseEntity.status(HttpStatus.OK).body(turnToUpdate)
    }

    @DeleteMapping("turns/delete/{id}")
    fun deleteTurn(@PathVariable("id") id: String): ResponseEntity<Turn>{
        var turnId = id.toLong()
        var aTurn = turnService.find(turnId)
        turnService.deleteTurn(aTurn)

        return ResponseEntity.status(HttpStatus.OK).body(aTurn)
    }




}