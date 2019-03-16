package data.keiba.raceindex.controller.resource.response

import data.keiba.raceindex.infrastructure.db.mybatis.entity.RealTimeHorseEntity

data class GetRealTimeHorseResponse(
        val realTimeHorses: List<RealTimeHorseEntity>
)