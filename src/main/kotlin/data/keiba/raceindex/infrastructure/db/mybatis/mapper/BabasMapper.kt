package data.keiba.raceindex.infrastructure.db.mybatis.mapper

import data.keiba.raceindex.infrastructure.db.mybatis.entity.BabasEntity
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface BabasMapper {
    @Select("""
        SELECT
          baba_id, name
        FROM
           babas
        WHERE
          baba_id = #{id}
    """)
    fun select(id: Int): BabasEntity
}
