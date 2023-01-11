CREATE
DATABASE mydb;

DROP TABLE IF EXISTS type_product_sherwin;
CREATE TABLE type_product_sherwin
(
    id               INT(11) PRIMARY KEY AUTO_INCREMENT,
    type_name        VARCHAR(100),
    last_update_date TIMESTAMP ON UPDATE CURRENT_TIMESTAMP DEFAULT NOW(),
    last_update_by   VARCHAR(50) DEFAULT ''
);

DROP TABLE IF EXISTS product_sherwin;
CREATE TABLE product_sherwin
(
    id               INT(11) PRIMARY KEY AUTO_INCREMENT,
    product_name     VARCHAR(100)   DEFAULT '',
    product_price    DECIMAL(25, 7) DEFAULT 0,
    product_quantity INT,
    type_id          INT(11),
    vendor_id        INT(11),
    last_update_date TIMESTAMP ON UPDATE CURRENT_TIMESTAMP DEFAULT NOW(),
    last_update_by   VARCHAR(50)    DEFAULT ''
);

DROP TABLE IF EXISTS image_sherwin;
CREATE TABLE image_sherwin
(
    id               INT(11) PRIMARY KEY AUTO_INCREMENT,
    image_name       TEXT,
    type_image       ENUM('MAIN','SUB'),
    product_id       INT(11),
    last_update_date TIMESTAMP ON UPDATE CURRENT_TIMESTAMP DEFAULT NOW(),
    last_update_by   VARCHAR(50) DEFAULT ''

);

DROP TABLE IF EXISTS vendor_sherwin;
CREATE TABLE vendor_sherwin
(
    id               INT(11) PRIMARY KEY AUTO_INCREMENT,
    vendor_name      TEXT,
    vendor_address   VARCHAR(100),
    vendor_phone_number VARCHAR(20),
    last_update_date TIMESTAMP ON UPDATE CURRENT_TIMESTAMP DEFAULT NOW(),
    last_update_by   VARCHAR(50) DEFAULT ''
);

DROP TABLE IF EXISTS customer_logging_sherwin;
CREATE TABLE customer_logging_sherwin
(
    uuid     VARCHAR(50) PRIMARY KEY,
    action   ENUM('SEARCH','FILTER','VIEW'),
    content  TEXT,
    log_date TIMESTAMP ON UPDATE CURRENT_TIMESTAMP DEFAULT NOW()
);

DROP TABLE IF EXISTS system_config_sherwin;
CREATE TABLE system_config_sherwin
(
    id           INT(11) PRIMARY KEY AUTO_INCREMENT,
    config_key   VARCHAR(50),
    config_value VARCHAR(50),
    log_date     TIMESTAMP ON UPDATE CURRENT_TIMESTAMP DEFAULT NOW()
);

DROP TABLE IF EXISTS country_support_sherwin;
CREATE TABLE country_support_sherwin
(
    id               INT(11) PRIMARY KEY AUTO_INCREMENT,
    country_code     VARCHAR(10),
    last_update_date TIMESTAMP ON UPDATE CURRENT_TIMESTAMP DEFAULT NOW(),
    last_update_by   VARCHAR(50) DEFAULT ''
);