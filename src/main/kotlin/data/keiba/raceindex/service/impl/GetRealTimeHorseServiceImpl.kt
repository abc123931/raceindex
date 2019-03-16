package data.keiba.raceindex.service.impl

import data.keiba.raceindex.controller.resource.request.GetRealTimeHorseRequest
import data.keiba.raceindex.infrastructure.db.mybatis.RealTimeHorseRepository
import data.keiba.raceindex.infrastructure.db.mybatis.entity.RealTimeHorseEntity
import data.keiba.raceindex.service.GetRealTimeHorseService
import org.springframework.stereotype.Component

@Component
class GetRealTimeHorseServiceImpl(
        private val realTimeHorseRepository: RealTimeHorseRepository
) : GetRealTimeHorseService {
    override fun getRealTimeHorse(getRealTimeHorseRequest: GetRealTimeHorseRequest):
            List<RealTimeHorseEntity> {
        return realTimeHorseRepository.select(getRealTimeHorseRequest.raceKey)
    }
}