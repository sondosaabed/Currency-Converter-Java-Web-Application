CREATE DATABASE currencyConverter;
CREATE TABLE currency(  
    id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    symbol CHAR,
    code VARCHAR(3)
) ;

CREATE TABLE currencyConversionRate(  
    id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    source_currency_id int,
    target_currency_id int,
    rate DOUBLE,
    FOREIGN KEY (source_currency_id) REFERENCES Currency(id),
    FOREIGN KEY (target_currency_id) REFERENCES Currency(id)
) ;