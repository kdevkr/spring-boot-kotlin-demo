package kr.kdev.demo.ws

import org.springframework.web.reactive.socket.WebSocketHandler
import org.springframework.web.reactive.socket.WebSocketSession
import reactor.core.publisher.Mono

class EchoWebSocketHandler : WebSocketHandler {
    override fun handle(session: WebSocketSession): Mono<Void> {
        val output = session.receive()
            .doOnNext { }
            .map { session.textMessage("Echo ${it.payloadAsText}") }
            .log()
        return session.send(output)
    }
}