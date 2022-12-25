
DROP TABLE IF EXISTS product_sherwin;
CREATE TABLE product_sherwin(
                                id INT(11) PRIMARY KEY AUTO_INCREMENT,
                                product_name VARCHAR(100) DEFAULT '',
                                product_price DECIMAL(25,7) DEFAULT 0,
                                type_id INT(11),
                                vendor_id  INT(11),
                                last_update_date TIMESTAMP ON UPDATE CURRENT_TIMESTAMP DEFAULT NOW(),
                                last_update_by VARCHAR(50) DEFAULT ''
);

DROP TABLE IF EXISTS image_sherwin;
CREATE TABLE image_sherwin(
                              id INT(11) PRIMARY KEY AUTO_INCREMENT,
                              image_name TEXT,
                              type_image ENUM('MAIN','SUB'),
                              product_id INT(11)

);

DROP TABLE IF EXISTS vendor_sherwin;
CREATE TABLE vendor_sherwin(
                               id INT(11) PRIMARY KEY AUTO_INCREMENT,
                               vendor_name TEXT,
                               country VARCHAR(50)
);


INSERT INTO `product_sherwin`
(
    `product_name`,
    `product_price`,
    `type_id`,
    `vendor_id`)
VALUES
    (
        'TN',
        500.23,
        1,
        1),
    (
        'TN2',
        512.23,
        1,
        1),
    (
        'TN1',
        400.23,
        1,
        1),
    (
        'TN5',
        500.23,
        1,
        2),
    (
        'TN4',
        500.23,
        2,
        3)
;


INSERT INTO `image_sherwin` (`image_name`, `type_image`, `product_id`) VALUES ('TN.jpg', 'MAIN', '1');
INSERT INTO `image_sherwin` (`image_name`, `type_image`, `product_id`) VALUES ('456', 'SUB', '1');
INSERT INTO `image_sherwin` (`image_name`, `type_image`, `product_id`) VALUES ('TN.jpg', 'MAIN', '2');
INSERT INTO `image_sherwin` (`image_name`, `type_image`, `product_id`) VALUES ('456', 'SUB', '2');

INSERT INTO `vendor_sherwin` (`id`, `vendor_name`, `country`) VALUES ('1', 'Trung Nguyen', 'Vietnam');
INSERT INTO `vendor_sherwin` (`id`, `vendor_name`, `country`) VALUES ('2', 'Thao Nguyen', 'QN Garden');
INSERT INTO `vendor_sherwin` (`id`, `vendor_name`, `country`) VALUES ('3', 'Be Nguyen', 'TN');

