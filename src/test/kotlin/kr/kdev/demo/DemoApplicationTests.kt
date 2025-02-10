package kr.kdev.demo

import kr.kdev.demo.data.Data
import kr.kdev.demo.data.PivotDataConverter
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class DemoApplicationTests {

    private val log = LoggerFactory.getLogger(DemoApplicationTests::class.java)

    @Test
    fun contextLoads() {
        val list = mutableListOf<Data>()
        list.add(Data("2025-01-01", null, "POWER", 10.0, 0.0))
        list.add(Data("2025-01-01", null, "ENERGY", 0.0, 110.0))
        val pivotDataList = PivotDataConverter.from(list)
        log.info("$pivotDataList")
    }

}
