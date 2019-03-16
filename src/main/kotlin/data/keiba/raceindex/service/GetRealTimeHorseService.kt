package data.keiba.raceindex.service

import data.keiba.raceindex.controller.resource.request.GetRealTimeHorseRequest
import data.keiba.raceindex.infrastructure.db.mybatis.entity.RealTimeHorseEntity

interface GetRealTimeHorseService {
    fun getRealTimeHorse(getRealTimeHorseRequest: GetRealTimeHorseRequest):
            List<RealTimeHorseEntity>
}
