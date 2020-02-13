INSERT INTO `shopstack`.`ss_product`(`product_code`,`product_name`,`purchase_date`, `category_id`,`price`, `decription`)

VALUES
(1,'beans',27-02-2020, 10, 200, 'food for sale'),
(2,'rice',28-02-2020, 11, 400, 'food for sale');

INSERT INTO `shopstack`.`category`( `category_id`,`category_name`)
VALUES
(10, 'food'),
(11,'foods');