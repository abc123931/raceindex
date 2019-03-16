package data.keiba.raceindex.controller

import data.keiba.raceindex.controller.resource.response.GetBabaResponse
import data.keiba.raceindex.controller.resource.response.factory.GetBabaResponseFactory
import data.keiba.raceindex.service.GetBabaService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/baba")
class GetBabaController(
        private val getBabaService: GetBabaService,
        private val getBabaResponseFactory: GetBabaResponseFactory
) {
    @GetMapping
    fun getBaba(@RequestParam(value = "id", required = false) id: Int): GetBabaResponse {
        return getBabaResponseFactory.create(getBabaService.getBaba(id))
    }
}