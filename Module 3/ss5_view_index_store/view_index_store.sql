

use view_index_store;

create table Products(
	id int auto_increment primary key,
    productCode int,
    productName nvarchar(45),
    productPrice double,
    productAmount double,
    productDescription nvarchar(100),
    productStatus bit
);

insert into Products (productCode, productName, productPrice, productAmount, productDescription, productStatus) values (43, 'Pork - Bacon,back Peameal', 7716.94, 7591.47, 'Bag - Bread, White, Plain', 0);
insert into Products (productCode, productName, productPrice, productAmount, productDescription, productStatus) values (48, 'Petite Baguette', 1322.11, 5714.14, 'Fiddlehead - Frozen', 0);
insert into Products (productCode, productName, productPrice, productAmount, productDescription, productStatus) values (16, 'Banana - Leaves', 5564.84, 3118.86, 'Tofu - Firm', 0);
insert into Products (productCode, productName, productPrice, productAmount, productDescription, productStatus) values (50, 'Beer - Steamwhistle', 6742.85, 8038.95, 'Bagelers - Cinn / Brown', 0);
insert into Products (productCode, productName, productPrice, productAmount, productDescription, productStatus) values (54, 'Soup - Cream Of Broccoli', 2182.07, 6305.9, 'Beef - Cow Feet Split', 1);


-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
ALTER TABLE products ADD UNIQUE INDEX idx_productCode(productCode);

select * from products
where productCode = 4;

-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
ALTER TABLE products ADD INDEX idx_productName_productPrice(productName, productPrice);

-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
EXPLAIN select * from products
where productCode = 4;

-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
CREATE VIEW products_views AS
SELECT productCode, productName, productPrice, productStatus
FROM  products;

select * from products_views;

-- Tiến hành sửa đổi view
CREATE OR REPLACE VIEW update_products_views AS
SELECT productCode, productName, productPrice, productStatus, productAmount
FROM products;

-- Tiến hành xoá view
DROP VIEW update_products_views;

-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product.
DELIMITER //
CREATE PROCEDURE findAllProducts()
BEGIN
  SELECT * FROM products;
END //
DELIMITER ;

call findAllProducts();

-- Tạo store procedure thêm một sản phẩm mới
DELIMITER //
CREATE PROCEDURE addNewProduct(IN productCode int, productName nvarchar(45), productPrice double, productAmount double, productDescription nvarchar(100), productStatus bit)
BEGIN
  insert into products (productCode, productName, productPrice, productAmount, productDescription, productStatus) values(productCode, productName, productPrice, productAmount, productDescription, productStatus);
END //
DELIMITER ;

call addNewProduct(53, "Bánh", 30000, 1000, "Bánh gạo", 1);

-- Tạo store procedure sửa thông tin sản phẩm theo id
DELIMITER //
CREATE PROCEDURE updateProduct(IN productId int, product_name nvarchar(45))
BEGIN
  update products set productName = product_name where id = productId;
END //
DELIMITER ;

call updateProduct(2, "Soup");

-- Tạo store procedure xoá sản phẩm theo id
DELIMITER //
CREATE PROCEDURE deleteProduct(IN productId int)
BEGIN
  delete from products where id = productId;
END //
DELIMITER ;

call deleteProduct(10);