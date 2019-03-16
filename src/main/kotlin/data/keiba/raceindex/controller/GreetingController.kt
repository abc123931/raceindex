package data.keiba.raceindex.controller

import data.keiba.raceindex.controller.resource.response.GreetingResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingController {
    @GetMapping("/hello")
    fun exec(): GreetingResponse {
        return GreetingResponse("hello matsumo!")
    }
}