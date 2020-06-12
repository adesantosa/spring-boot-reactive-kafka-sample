package spring.boot.reactive.kafka;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final ReactiveOrderProducer reactiveOrderProducer;
    private final OrderRepository orderRepository;

    @PostMapping
    public Mono<Order> generatorOrder(@RequestBody Order order) {
        return reactiveOrderProducer.send(order);
    }

    @GetMapping
    public Flux<Order> getAllItems() {
        return orderRepository.findAll()
                .doOnNext(it -> System.out.println("Running..."))
                .map(it ->
                Order.builder()
                        .orderCode(it.getOrderCode())
                        .amount(it.getAmount())
                .build()
        );
    }
}
