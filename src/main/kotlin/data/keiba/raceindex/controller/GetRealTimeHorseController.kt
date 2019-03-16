package data.keiba.raceindex.controller

import data.keiba.raceindex.controller.resource.request.GetRealTimeHorseRequest
import data.keiba.raceindex.controller.resource.response.GetBabaResponse
import data.keiba.raceindex.controller.resource.response.GetRealTimeHorseResponse
import data.keiba.raceindex.controller.resource.response.factory.GetBabaResponseFactory
import data.keiba.raceindex.controller.resource.response.factory.GetRealTimeHorseResponseFactory
import data.keiba.raceindex.service.GetBabaService
import data.keiba.raceindex.service.GetRealTimeHorseService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/realTimeHorse")
class GetRealTimeHorseController(
        private val getRealTimeHorseService: GetRealTimeHorseService,
        private val getRealTimeHorseResponseFactory: GetRealTimeHorseResponseFactory
) {
    @GetMapping
    fun getRealTimeHorse(@RequestParam(value = "raceKey", required = false) raceKey: String,
                         getRealTimeHorseRequest: GetRealTimeHorseRequest):
            GetRealTimeHorseResponse {
        return getRealTimeHorseResponseFactory
                .create(getRealTimeHorseService.getRealTimeHorse(getRealTimeHorseRequest))
    }
}