package data.keiba.raceindex.service

import data.keiba.raceindex.controller.resource.request.GetRealTimeHorseRequest
import data.keiba.raceindex.infrastructure.db.mybatis.RealTimeHorseRepository
import data.keiba.raceindex.infrastructure.db.mybatis.entity.RealTimeHorseEntity
import data.keiba.raceindex.service.impl.GetRealTimeHorseServiceImpl
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner
import org.springframework.test.context.ActiveProfiles

@RunWith(MockitoJUnitRunner::class)
@ActiveProfiles("test")
class GetRealTimeHorseServiceImplTest {

    @InjectMocks
    private lateinit var target: GetRealTimeHorseServiceImpl

    @Mock
    private lateinit var realTimeHorseRepository: RealTimeHorseRepository

    private lateinit var request:  GetRealTimeHorseRequest

    @Before
    fun setUp() {
        request = GetRealTimeHorseRequest("011111")
    }

    @Test
    fun normalTest() {
        `when`(realTimeHorseRepository.select(ArgumentMatchers.anyString()))
                .thenReturn(createRealTimeHorseData())
        val actual = target.getRealTimeHorse(request)
        assertThat(actual[0].horse).isEqualTo("test_horse")
        assertThat(actual[0].totalIndex).isEqualTo("70.0")

        verify(realTimeHorseRepository).select("011111")
    }

    fun createRealTimeHorseData(): List<RealTimeHorseEntity> {
        var response = mutableListOf<RealTimeHorseEntity>()
        response.add(RealTimeHorseEntity("test_horse", "70.0"))
        return response
    }


}