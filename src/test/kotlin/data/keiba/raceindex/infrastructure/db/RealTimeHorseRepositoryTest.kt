package data.keiba.raceindex.infrastructure.db

import com.github.springtestdbunit.DbUnitTestExecutionListener
import data.keiba.raceindex.infrastructure.db.mybatis.BabasRepository
import data.keiba.raceindex.infrastructure.db.mybatis.RealTimeHorseRepository
import data.keiba.raceindex.infrastructure.db.mybatis.entity.BabasEntity
import data.keiba.raceindex.infrastructure.db.mybatis.entity.RealTimeHorseEntity
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestExecutionListeners
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener
import org.springframework.test.context.support.DirtiesContextTestExecutionListener
import org.springframework.test.context.transaction.TransactionalTestExecutionListener

@RunWith(SpringRunner::class)
@SpringBootTest
@ContextConfiguration
@TestExecutionListeners(
        DependencyInjectionTestExecutionListener::class,
        DirtiesContextTestExecutionListener::class,
        TransactionalTestExecutionListener::class,
        DbUnitTestExecutionListener::class )
class RealTimeHorseRepositoryTest {
    @Autowired
    lateinit var realTimeHorseRepository: RealTimeHorseRepository

    @Test
    fun testSelect() {
        val realTimeHorses: List<RealTimeHorseEntity> = realTimeHorseRepository.select("06181101")
        assertThat(realTimeHorses.size).isEqualTo(3)
        assertThat(realTimeHorses[0].horse).isEqualTo("マヤノフロスティ")
        assertThat(realTimeHorses[0].totalIndex).isEqualTo("70.0")
    }

}