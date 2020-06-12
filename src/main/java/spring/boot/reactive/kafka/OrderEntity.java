package spring.boot.reactive.kafka;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Builder;
import lombok.Data;

@Table("order_table")
@Data
@Builder
public class OrderEntity {

    @Id
    private Long id;
    private String orderCode;
    private Double amount;
}
