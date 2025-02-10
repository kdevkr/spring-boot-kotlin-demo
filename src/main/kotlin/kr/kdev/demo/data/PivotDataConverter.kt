package kr.kdev.demo.data

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

object PivotDataConverter {
    private val mapper = jacksonObjectMapper()
    private val avgReports = setOf("POWER", "TEMP", "HERTZ").associateWith { it }

    fun from(list: List<Data>): List<PivotData> {
        return mapper.convertValue(
            list.groupBy { it.date to it.id }
                .map { (key, values) ->
                    val (date, id) = key
                    val row: MutableMap<String, Any?> = values.associate { data ->
                        data.report to if (avgReports.containsKey(data.report)) data.avg else data.sum
                    }.toMutableMap()
                    row["date"] = date
                    row["id"] = id
                    row
                }, object : TypeReference<List<PivotData>>() {})
    }
}