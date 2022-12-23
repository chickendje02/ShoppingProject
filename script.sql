
DROP TABLE IF EXISTS product_sherwin;
CREATE TABLE product_sherwin(
	id INT(11) PRIMARY KEY,
	name VARCHAR(100) DEFAULT '',
	price DECIMAL(25,7) DEFAULT 0,
	type_id INT(11),
	vendor_id  INT(11),
	last_update_date TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	last_update_by VARCHAR(50)
)

CREATE TABLE image_sherwin(
	id INT(11) PRIMARY KEY,
	name TEXT,
	type_image ENUM('MAIN','SUB'),
	product_id INT(11)
	
)

CREATE TABLE vendor_sherwin(
	id INT(11) PRIMARY KEY,
	name TEXT,
	country VARCHAR(50),
	product_id INT(11)
)