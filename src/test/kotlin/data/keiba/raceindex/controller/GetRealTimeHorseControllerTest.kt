package data.keiba.raceindex.controller

import data.keiba.raceindex.controller.resource.request.GetRealTimeHorseRequest
import data.keiba.raceindex.controller.resource.response.GetRealTimeHorseResponse
import data.keiba.raceindex.controller.resource.response.factory.GetRealTimeHorseResponseFactory
import data.keiba.raceindex.infrastructure.db.mybatis.entity.RealTimeHorseEntity
import data.keiba.raceindex.service.GetRealTimeHorseService
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner
import org.springframework.test.context.ActiveProfiles

@RunWith(MockitoJUnitRunner::class)
@ActiveProfiles("test")
class GetRealTimeHorseControllerTest {
    @InjectMocks
    private lateinit var target: GetRealTimeHorseController
    @Mock
    private lateinit var getRealTimeHorseService: GetRealTimeHorseService
    @Mock
    private lateinit var getRealTimeHorseResponseFactory: GetRealTimeHorseResponseFactory

    @Test
    fun normalTest() {
        val request = GetRealTimeHorseRequest(raceKey = "0001")
        val expected = GetRealTimeHorseResponse(
                listOf(RealTimeHorseEntity("test_horse","70.0")))
        `when`(getRealTimeHorseService.getRealTimeHorse(request))
                .thenReturn(createRealTimeHorseData())
        `when`(getRealTimeHorseResponseFactory.create(anyList()))
                .thenReturn(expected)

        val actual = target.getRealTimeHorse("0001", request)
        assertThat(actual).isEqualTo(expected)
        verify(getRealTimeHorseResponseFactory).create(createRealTimeHorseData())
    }

    fun createRealTimeHorseData(): List<RealTimeHorseEntity> {
        var response = mutableListOf<RealTimeHorseEntity>()
        response.add(RealTimeHorseEntity("test_horse", "70.0"))
        return response
    }

}
