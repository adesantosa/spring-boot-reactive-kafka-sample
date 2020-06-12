package spring.boot.reactive.kafka;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface OrderRepository extends ReactiveCrudRepository<OrderEntity, Long> {
}
