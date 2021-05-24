package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.handlers

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.exceptions.NotFoundUserException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@RestControllerAdvice
@EnableWebMvc
class ExceptionHandlerAPI {

    @ExceptionHandler(NotFoundUserException::class)
    fun notFoundUser(exception: Exception): ResponseEntity<String?>? {
        return ResponseEntity(exception.message, HttpStatus.NOT_FOUND)
    }
}