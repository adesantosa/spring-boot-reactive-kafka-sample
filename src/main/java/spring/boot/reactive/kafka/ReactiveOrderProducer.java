package spring.boot.reactive.kafka;

import org.springframework.cloud.function.context.PollableBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.function.Supplier;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@Slf4j
@RequiredArgsConstructor
public class ReactiveOrderProducer {

    private final EmitterProcessor<Order> emitterProcessor;

    public Mono<Order> send(Order order) {
        log.info("{}", order);
        emitterProcessor.onNext(order);
        log.info("{}", emitterProcessor);
        return Mono.just(order);
    }

    @PollableBean
    public Supplier<Flux<Order>> orderProducer() {
        return () -> emitterProcessor;
    }

}
