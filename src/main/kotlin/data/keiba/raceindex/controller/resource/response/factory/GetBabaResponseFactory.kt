package data.keiba.raceindex.controller.resource.response.factory

import data.keiba.raceindex.controller.resource.response.GetBabaResponse
import data.keiba.raceindex.infrastructure.db.mybatis.entity.BabasEntity
import org.springframework.stereotype.Component

@Component
class GetBabaResponseFactory {
    fun create(babasEntity: BabasEntity): GetBabaResponse {
        return GetBabaResponse(babasEntity.id, babasEntity.name)
    }
}