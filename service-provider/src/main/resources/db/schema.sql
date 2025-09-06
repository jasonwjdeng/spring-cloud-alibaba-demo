DROP TABLE user_info IF EXISTS;
CREATE TABLE user_info (
    id BIGINT AUTO_INCREMENT,
    name VARCHAR(20),
    age INT,
    balance DECIMAL(10, 2),
    PRIMARY KEY (id)
);
