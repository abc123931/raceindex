package data.keiba.raceindex.service.impl

import data.keiba.raceindex.infrastructure.db.mybatis.BabasRepository
import data.keiba.raceindex.infrastructure.db.mybatis.entity.BabasEntity
import data.keiba.raceindex.service.GetBabaService
import org.springframework.stereotype.Component

@Component
class GetBabaServiceImpl(
        private val babasRepository: BabasRepository
) : GetBabaService {
    override fun getBaba(id: Int): BabasEntity {
        return babasRepository.select(id)
    }
}