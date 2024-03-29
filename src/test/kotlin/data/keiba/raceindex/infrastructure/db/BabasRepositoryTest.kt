package data.keiba.raceindex.infrastructure.db

import com.github.springtestdbunit.DbUnitTestExecutionListener
import data.keiba.raceindex.infrastructure.db.mybatis.BabasRepository
import data.keiba.raceindex.infrastructure.db.mybatis.entity.BabasEntity
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
class BabasRepositoryTest {
    @Autowired
    lateinit var babasRepository: BabasRepository

    @Test
    fun testSelect() {
        val babasEntity: BabasEntity = babasRepository.select(1)
        assertThat(babasEntity.id).isEqualTo(1)
    }

}