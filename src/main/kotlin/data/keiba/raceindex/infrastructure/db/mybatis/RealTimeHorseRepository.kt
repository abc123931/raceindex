package data.keiba.raceindex.infrastructure.db.mybatis

import data.keiba.raceindex.infrastructure.db.mybatis.entity.RealTimeHorseEntity
import data.keiba.raceindex.infrastructure.db.mybatis.mapper.RealTimeHorseMapper
import org.springframework.stereotype.Repository

@Repository
class RealTimeHorseRepository(
        private val realTimeHorseMapper: RealTimeHorseMapper
) {
   fun select(race_key: String): List<RealTimeHorseEntity> {
      return realTimeHorseMapper.select(race_key)
   }
}