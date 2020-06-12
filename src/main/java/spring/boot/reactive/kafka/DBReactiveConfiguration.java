package spring.boot.reactive.kafka;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.r2dbc.connectionfactory.init.CompositeDatabasePopulator;
import org.springframework.data.r2dbc.connectionfactory.init.ConnectionFactoryInitializer;
import org.springframework.data.r2dbc.connectionfactory.init.ResourceDatabasePopulator;
import org.springframework.data.r2dbc.core.DatabaseClient;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import io.r2dbc.spi.ConnectionFactory;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class DBReactiveConfiguration {

    private final DatabaseClient databaseClient;

    @Bean
    public void initializer() {

        final var statements = Arrays.asList(
                "DROP TABLE IF EXISTS order_table;",
                "CREATE TABLE order_table(id SERIAL primary key, orderCode VARCHAR(255), amount BIGINT);"
        );

        statements.forEach(it ->
                databaseClient.execute(it)
                        .fetch()
                        .rowsUpdated()
                        .subscribe()
        );
    }
}
