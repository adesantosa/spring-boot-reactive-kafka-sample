package spring.boot.reactive.kafka;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.EmitterProcessor;

@Configuration
public class EmitterProcessorConfiguration {

    @Bean
    public EmitterProcessor<Order> emitterProcessor() {
        return EmitterProcessor.create();
    }
}
