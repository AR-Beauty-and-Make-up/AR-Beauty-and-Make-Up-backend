package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.controllers

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.Turn
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.services.TurnService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RestController
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
}