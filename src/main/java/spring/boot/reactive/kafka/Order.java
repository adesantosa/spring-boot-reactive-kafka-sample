package spring.boot.reactive.kafka;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {

    private String orderCode;
    private Double amount;
}
