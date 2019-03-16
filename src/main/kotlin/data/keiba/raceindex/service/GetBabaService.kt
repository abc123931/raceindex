package data.keiba.raceindex.service

import data.keiba.raceindex.infrastructure.db.mybatis.entity.BabasEntity

interface GetBabaService {
    fun getBaba(id: Int): BabasEntity
}
