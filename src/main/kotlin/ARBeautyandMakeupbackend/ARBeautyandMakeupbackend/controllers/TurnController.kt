package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.controllers

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.Turn
import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.services.TurnService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

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
}