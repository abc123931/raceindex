package data.keiba.raceindex.infrastructure.db.mybatis.mapper

import data.keiba.raceindex.infrastructure.db.mybatis.entity.RealTimeHorseEntity
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface RealTimeHorseMapper {
    @Select("""
        SELECT
          horse_name,
          total_index
        FROM
          realtimehorses
        WHERE
          race_key = #{race_key}
    """)
    fun select(race_key: String): List<RealTimeHorseEntity>
}
