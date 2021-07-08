package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
class ArBeautyAndMakeUpBackendApplication

fun main(args: Array<String>) {
	runApplication<ArBeautyAndMakeUpBackendApplication>(*args)
}
