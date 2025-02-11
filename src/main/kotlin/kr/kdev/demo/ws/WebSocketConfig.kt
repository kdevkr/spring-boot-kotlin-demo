package kr.kdev.demo.ws

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.HandlerMapping
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping

@Configuration
class WebSocketConfig {
    @Bean
    fun handlerMapping(): HandlerMapping {
        val map = mapOf("/ws" to EchoWebSocketHandler())
        val order = -1 // before annotated controllers
        return SimpleUrlHandlerMapping(map, order)
    }
}