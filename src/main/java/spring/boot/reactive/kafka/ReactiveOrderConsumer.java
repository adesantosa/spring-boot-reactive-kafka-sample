package spring.boot.reactive.kafka;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import java.util.function.Consumer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class ReactiveOrderConsumer {

    private final OrderRepository orderRepository;

    @Bean
    public Consumer<Order> orderConsumer() {
        return order -> orderRepository
                .save(getOrderEntity(order))
                .subscribe();
    }

    private OrderEntity getOrderEntity(Order order){
        log.info("{}", order);
        return OrderEntity.builder()
                .orderCode(order.getOrderCode())
                .amount(order.getAmount())
                .build();
    }
 }
