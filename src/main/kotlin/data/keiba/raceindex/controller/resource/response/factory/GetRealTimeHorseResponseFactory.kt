package data.keiba.raceindex.controller.resource.response.factory

import data.keiba.raceindex.controller.resource.response.GetRealTimeHorseResponse
import data.keiba.raceindex.infrastructure.db.mybatis.entity.RealTimeHorseEntity
import org.springframework.stereotype.Component

@Component
class GetRealTimeHorseResponseFactory {
    fun create(realTimeHorseEntities: List<RealTimeHorseEntity>): GetRealTimeHorseResponse {
        return GetRealTimeHorseResponse(realTimeHorseEntities)
    }
}