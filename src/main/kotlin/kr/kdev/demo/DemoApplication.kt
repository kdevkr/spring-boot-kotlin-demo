package kr.kdev.demo

import io.github.oshai.kotlinlogging.KotlinLogging
import lombok.extern.slf4j.Slf4j
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.context.event.EventListener

@Slf4j // <-- Not working!!
@SpringBootApplication
class DemoApplication {

    private val logger = KotlinLogging.logger {}
    companion object {
        private val log: Logger = LoggerFactory.getLogger(this::class.java)
    }

    @EventListener
    fun onEvent(event: ContextRefreshedEvent) {
        log.info("Application started")
        logger.info { "Application started" }
    }
}

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}