package kr.kdev.demo

import ch.qos.logback.core.model.Model
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import reactor.core.publisher.Mono

@Controller
class IndexController {

    @GetMapping("/")
    fun index(model: Model): Mono<String> = Mono.just("index")
}