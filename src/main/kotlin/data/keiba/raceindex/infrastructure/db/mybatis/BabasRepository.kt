package data.keiba.raceindex.infrastructure.db.mybatis

import data.keiba.raceindex.infrastructure.db.mybatis.entity.BabasEntity
import data.keiba.raceindex.infrastructure.db.mybatis.mapper.BabasMapper
import org.springframework.stereotype.Repository

@Repository
class BabasRepository(
        private val babasMapper: BabasMapper
) {
   fun select(id: Int): BabasEntity {
      return babasMapper.select(id)
   }
}