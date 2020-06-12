DROP TABLE IF EXISTS order_table;
CREATE TABLE order_table(
    id SERIAL primary key,
    orderCode VARCHAR(255),
    amount BIGINT
)