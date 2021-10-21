Auth API
Products API
Orders API
Line Items API
Checkouts API
Payments API
Addresses API
Shipping API
ReviewsAndRatings API



INSERT IGNORE INTO categories(categoryname) VALUES('Women Ethnic');

INSERT IGNORE INTO sub_categories(name) VALUES('Sarees');
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('http://lovevivah.com/matrimony/blog/wp-content/uploads/2017/02/indian-bridal-saree-for-marriage.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('Wedding');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(1,1);
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('http://lovevivah.com/matrimony/blog/wp-content/uploads/2017/02/indian-bridal-saree-for-marriage.jpg');
INSERT IGNORE INTO product(name,currency,retail_price,selling_price,description) VALUES('Adrika Fashion Sarees','Rs',480.50,450.00,'Fabric: Georgette,Blouse: Seperate Blouse piece, Blouse Fabric: Cotton,Pattern:Printed');
INSERT IGNORE INTO product_variants_products(product_variants_id,product_id) VALUES (1,1);
INSERT IGNORE INTO product_image(imageURL) VALUES('http://lovevivah.com/matrimony/blog/wp-content/uploads/2017/02/indian-bridal-saree-for-marriage.jpg');
INSERT IGNORE INTO product_product_image(product_id,product_image_id) VALUES (1,1);
INSERT IGNORE INTO seller(name) VALUES('Malli Fashion Stores');
INSERT IGNORE INTO product_sellers(product_id,sellers_id) VALUES (1,1);


INSERT IGNORE INTO product_variants(name) VALUES('Festive');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(2,2);
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('https://i.ebayimg.com/images/g/LcgAAOSw0LJfMTZr/s-l640.jpg');
INSERT IGNORE INTO product(name,currency,retail_price,selling_price,description) VALUES('Trendy Sarees','Rs',580.50,550.00,'Fabric: Georgette,Blouse: Seperate Blouse piece, Blouse Fabric: Cotton,Pattern:Printed');
INSERT IGNORE INTO product_variants_products(product_variants_id,product_id) VALUES (2,2);
INSERT IGNORE INTO product_image(imageURL) VALUES('http://lovevivah.com/matrimony/blog/wp-content/uploads/2017/02/indian-bridal-saree-for-marriage.jpg');
INSERT IGNORE INTO product_product_image(product_id,product_image_id) VALUES (2,2);
INSERT IGNORE INTO seller(name) VALUES('Vikram Fashion Stores');
INSERT IGNORE INTO product_sellers(product_id,sellers_id) VALUES (2,2);

INSERT IGNORE INTO product_variants(name) VALUES('Combo');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(3,3);
INSERT IGNORE INTO product(name,currency,retail_price,selling_price,description) VALUES('Aagam Alluring Sarees','Rs',380.50,350.00,'Fabric: Georgette,Blouse: Seperate Blouse piece, Blouse Fabric: Cotton,Pattern:Printed');
INSERT IGNORE INTO product_variants_products(product_variants_id,product_id) VALUES (3,3);
INSERT IGNORE INTO product_image(imageURL) VALUES('http://lovevivah.com/matrimony/blog/wp-content/uploads/2017/02/indian-bridal-saree-for-marriage.jpg');
INSERT IGNORE INTO product_product_image(product_id,product_image_id) VALUES (3,3);
INSERT IGNORE INTO seller(name) VALUES('Swaraj Fashion Stores');
INSERT IGNORE INTO product_sellers(product_id,sellers_id) VALUES (3,3);

INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(1,1);
INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(1,2);
INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(1,3);




INSERT IGNORE INTO sub_categories(name) VALUES('Kurtis');
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('http://lovevivah.com/matrimony/blog/wp-content/uploads/2017/02/indian-bridal-saree-for-marriage.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('COTTON');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(4,4);
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('http://lovevivah.com/matrimony/blog/wp-content/uploads/2017/02/indian-bridal-saree-for-marriage.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('ANARKALIS');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(5,5);
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('https://i.ebayimg.com/images/g/LcgAAOSw0LJfMTZr/s-l640.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('DAILYWEAR');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(6,6);


INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(2,4);
INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(2,5);
INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(2,6);


INSERT IGNORE INTO sub_categories(name) VALUES('Kurta Sets');

INSERT IGNORE INTO product_variant_image(imageURL) VALUES('http://lovevivah.com/matrimony/blog/wp-content/uploads/2017/02/indian-bridal-saree-for-marriage.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('COTTON');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(7,7);
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('http://lovevivah.com/matrimony/blog/wp-content/uploads/2017/02/indian-bridal-saree-for-marriage.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('RAYON');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(8,8);
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('https://i.ebayimg.com/images/g/LcgAAOSw0LJfMTZr/s-l640.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('DAILYWEAR');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(9,9);


INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(3,7);
INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(3,8);
INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(3,9);

INSERT IGNORE INTO sub_categories(name) VALUES('Dupatta Sets');
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('http://lovevivah.com/matrimony/blog/wp-content/uploads/2017/02/indian-bridal-saree-for-marriage.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('COTTON');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(10,10);
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('http://lovevivah.com/matrimony/blog/wp-content/uploads/2017/02/indian-bridal-saree-for-marriage.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('RAYON');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(11,11);
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('https://i.ebayimg.com/images/g/LcgAAOSw0LJfMTZr/s-l640.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('PRINTED');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(12,12);


INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(4,10);
INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(4,11);
INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(4,12);


INSERT IGNORE INTO sub_categories(name) VALUES('Suits & Dress Material');

INSERT IGNORE INTO product_variant_image(imageURL) VALUES('http://lovevivah.com/matrimony/blog/wp-content/uploads/2017/02/indian-bridal-saree-for-marriage.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('COTTON');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(13,13);
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('http://lovevivah.com/matrimony/blog/wp-content/uploads/2017/02/indian-bridal-saree-for-marriage.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('CREPE');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(14,14);
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('https://i.ebayimg.com/images/g/LcgAAOSw0LJfMTZr/s-l640.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('EMBROIDERED');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(15,15);


INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(5,13);
INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(5,14);
INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(5,15);

INSERT IGNORE INTO sub_categories(name) VALUES('Lehengas');
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('http://lovevivah.com/matrimony/blog/wp-content/uploads/2017/02/indian-bridal-saree-for-marriage.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('Lehenga Cholis');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(16,16);
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('http://lovevivah.com/matrimony/blog/wp-content/uploads/2017/02/indian-bridal-saree-for-marriage.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('Net Lehenga');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(17,17);
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('https://i.ebayimg.com/images/g/LcgAAOSw0LJfMTZr/s-l640.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('Bridal Lehenga');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(18,18);


INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(6,16);
INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(6,17);
INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(6,18);


INSERT IGNORE INTO sub_categories(name) VALUES('Other Ethnic Wear');

INSERT IGNORE INTO product_variant_image(imageURL) VALUES('http://lovevivah.com/matrimony/blog/wp-content/uploads/2017/02/indian-bridal-saree-for-marriage.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('Skirts & bottom Wear');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(19,19);
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('http://lovevivah.com/matrimony/blog/wp-content/uploads/2017/02/indian-bridal-saree-for-marriage.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('Blouses');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(20,20);
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('https://i.ebayimg.com/images/g/LcgAAOSw0LJfMTZr/s-l640.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('Jackets');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(21,21);


INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(7,19);
INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(7, 20);
INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(7,21);


INSERT IGNORE INTO category_sub_categories(category_id,sub_category_id) VALUES(9,1);
INSERT IGNORE INTO category_sub_categories(category_id,sub_category_id) VALUES(9,2);
INSERT IGNORE INTO category_sub_categories(category_id,sub_category_id) VALUES(9,3);
INSERT IGNORE INTO category_sub_categories(category_id,sub_category_id) VALUES(9,4);
INSERT IGNORE INTO category_sub_categories(category_id,sub_category_id) VALUES(9,5);
INSERT IGNORE INTO category_sub_categories(category_id,sub_category_id) VALUES(9,6);
INSERT IGNORE INTO category_sub_categories(category_id,sub_category_id) VALUES(9,7);

-----------------------------------------------------------
INSERT IGNORE INTO categories(categoryname) VALUES('Women Western');
INSERT IGNORE INTO sub_categories(name) VALUES('Top Wear');
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('http://lovevivah.com/matrimony/blog/wp-content/uploads/2017/02/indian-bridal-saree-for-marriage.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('Tops & Tunics');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(22,22);
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('http://lovevivah.com/matrimony/blog/wp-content/uploads/2017/02/indian-bridal-saree-for-marriage.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('T Shirts');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(23,23);
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('https://i.ebayimg.com/images/g/LcgAAOSw0LJfMTZr/s-l640.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('Gowns');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(24,24);


INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(8,22);
INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(8, 23);
INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(8,24);




INSERT IGNORE INTO sub_categories(name) VALUES('Bottom Wear');
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('http://lovevivah.com/matrimony/blog/wp-content/uploads/2017/02/indian-bridal-saree-for-marriage.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('Jeans & Jeggings');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(25,25);
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('http://lovevivah.com/matrimony/blog/wp-content/uploads/2017/02/indian-bridal-saree-for-marriage.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('Trousers & Pants');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(26,26);
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('https://i.ebayimg.com/images/g/LcgAAOSw0LJfMTZr/s-l640.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('Plazzzos');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(27,27);


INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(9,25);
INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(9, 26);
INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(9,27);

INSERT IGNORE INTO sub_categories(name) VALUES('Plus Size');
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('http://lovevivah.com/matrimony/blog/wp-content/uploads/2017/02/indian-bridal-saree-for-marriage.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('Tops & Tees');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(28,28);
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('http://lovevivah.com/matrimony/blog/wp-content/uploads/2017/02/indian-bridal-saree-for-marriage.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('Dresses');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(29,29);
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('https://i.ebayimg.com/images/g/LcgAAOSw0LJfMTZr/s-l640.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('Bootom Wear');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(30,30);


INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(10,28);
INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(10, 29);
INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(10,30);

INSERT IGNORE INTO sub_categories(name) VALUES('Inner Wear');
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('http://lovevivah.com/matrimony/blog/wp-content/uploads/2017/02/indian-bridal-saree-for-marriage.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('Women Inner Wear');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(31,31);
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('http://lovevivah.com/matrimony/blog/wp-content/uploads/2017/02/indian-bridal-saree-for-marriage.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('Bra');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(32,32);
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('https://i.ebayimg.com/images/g/LcgAAOSw0LJfMTZr/s-l640.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('Briefs');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(33,33);


INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(11,31);
INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(11, 32);
INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(11,33);

INSERT IGNORE INTO sub_categories(name) VALUES('Sleep Wear');
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('http://lovevivah.com/matrimony/blog/wp-content/uploads/2017/02/indian-bridal-saree-for-marriage.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('Women Sleep Wear');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(34,34);
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('http://lovevivah.com/matrimony/blog/wp-content/uploads/2017/02/indian-bridal-saree-for-marriage.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('Night Suits');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(35,35);
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('https://i.ebayimg.com/images/g/LcgAAOSw0LJfMTZr/s-l640.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('Night Dress');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(36,36);


INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(12,34);
INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(12, 35);
INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(12,36);

INSERT IGNORE INTO sub_categories(name) VALUES('Maternity Wear');
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('http://lovevivah.com/matrimony/blog/wp-content/uploads/2017/02/indian-bridal-saree-for-marriage.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('Maternity dresses');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(37,37);
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('http://lovevivah.com/matrimony/blog/wp-content/uploads/2017/02/indian-bridal-saree-for-marriage.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('feeding Bras');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(38,38);
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('https://i.ebayimg.com/images/g/LcgAAOSw0LJfMTZr/s-l640.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('Maternity Kurties');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(39,39);


INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(13,37);
INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(13, 38);
INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(13,39);

INSERT IGNORE INTO sub_categories(name) VALUES('Sports Wear');
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('http://lovevivah.com/matrimony/blog/wp-content/uploads/2017/02/indian-bridal-saree-for-marriage.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('Women Sports Wear');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(40,40);
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('http://lovevivah.com/matrimony/blog/wp-content/uploads/2017/02/indian-bridal-saree-for-marriage.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('Women Sports Bottom wear');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(41,41);
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('https://i.ebayimg.com/images/g/LcgAAOSw0LJfMTZr/s-l640.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('Sports Bra');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(42,42);


INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(14,40);
INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(14, 41);
INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(14,42);

INSERT IGNORE INTO category_sub_categories(category_id,sub_category_id) VALUES(10,8);
INSERT IGNORE INTO category_sub_categories(category_id,sub_category_id) VALUES(10,9);
INSERT IGNORE INTO category_sub_categories(category_id,sub_category_id) VALUES(10,10);
INSERT IGNORE INTO category_sub_categories(category_id,sub_category_id) VALUES(10,11);
INSERT IGNORE INTO category_sub_categories(category_id,sub_category_id) VALUES(10,12);
INSERT IGNORE INTO category_sub_categories(category_id,sub_category_id) VALUES(10,13);
INSERT IGNORE INTO category_sub_categories(category_id,sub_category_id) VALUES(10,14);
------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------

INSERT IGNORE INTO categories(categoryname) VALUES('Men');
INSERT IGNORE INTO sub_categories(name) VALUES('Top Wear');
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('http://lovevivah.com/matrimony/blog/wp-content/uploads/2017/02/indian-bridal-saree-for-marriage.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('T-Shirts');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(43,43);
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('http://lovevivah.com/matrimony/blog/wp-content/uploads/2017/02/indian-bridal-saree-for-marriage.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('Shirts');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(44,44);
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('https://i.ebayimg.com/images/g/LcgAAOSw0LJfMTZr/s-l640.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('Winter Wear');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(45,45);
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('https://i.ebayimg.com/images/g/LcgAAOSw0LJfMTZr/s-l640.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('Jackets');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(46,46);
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('https://i.ebayimg.com/images/g/LcgAAOSw0LJfMTZr/s-l640.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('Formals');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(47,47);


INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(15,43);
INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(15, 44);
INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(15,45);
INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(15, 46);
INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(15,47);

INSERT IGNORE INTO sub_categories(name) VALUES('Bottom Wear');
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('http://lovevivah.com/matrimony/blog/wp-content/uploads/2017/02/indian-bridal-saree-for-marriage.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('Jeans');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(48,48);
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('http://lovevivah.com/matrimony/blog/wp-content/uploads/2017/02/indian-bridal-saree-for-marriage.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('Shorts');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(49,49);
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('https://i.ebayimg.com/images/g/LcgAAOSw0LJfMTZr/s-l640.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('Trousers');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(50,50);


INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(16,48);
INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(16, 49);
INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(16,50);

INSERT IGNORE INTO sub_categories(name) VALUES('Men Accessories');
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('http://lovevivah.com/matrimony/blog/wp-content/uploads/2017/02/indian-bridal-saree-for-marriage.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('Watches');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(51,51);
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('http://lovevivah.com/matrimony/blog/wp-content/uploads/2017/02/indian-bridal-saree-for-marriage.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('Belts & Wallets');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(52,52);
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('https://i.ebayimg.com/images/g/LcgAAOSw0LJfMTZr/s-l640.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('Sun Glasses');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(53,53);


INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(17,51);
INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(17, 52);
INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(17,53);

INSERT IGNORE INTO sub_categories(name) VALUES('Ethnic Wear');
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('http://lovevivah.com/matrimony/blog/wp-content/uploads/2017/02/indian-bridal-saree-for-marriage.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('Kurtas');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(54,54);
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('http://lovevivah.com/matrimony/blog/wp-content/uploads/2017/02/indian-bridal-saree-for-marriage.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('Jackets');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(55,55);
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('https://i.ebayimg.com/images/g/LcgAAOSw0LJfMTZr/s-l640.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('Dhotis');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(56,56);


INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(18,54);
INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(18, 55);
INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(18,56);

INSERT IGNORE INTO sub_categories(name) VALUES('Inner Wear & Sleep Wear');
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('http://lovevivah.com/matrimony/blog/wp-content/uploads/2017/02/indian-bridal-saree-for-marriage.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('Boxers');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(57,57);
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('http://lovevivah.com/matrimony/blog/wp-content/uploads/2017/02/indian-bridal-saree-for-marriage.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('Underwears');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(58,58);
INSERT IGNORE INTO product_variant_image(imageURL) VALUES('https://i.ebayimg.com/images/g/LcgAAOSw0LJfMTZr/s-l640.jpg');
INSERT IGNORE INTO product_variants(name) VALUES('Banions');
INSERT IGNORE INTO product_variants_product_variants_images(product_variants_id,product_variants_image_id) VALUES(59,59);


INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(19,57);
INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(19, 58);
INSERT IGNORE INTO sub_categories_product_variants(sub_category_id,product_variants_id) VALUES(19,59);

INSERT IGNORE INTO category_sub_categories(category_id,sub_category_id) VALUES(11,15);
INSERT IGNORE INTO category_sub_categories(category_id,sub_category_id) VALUES(11,16);
INSERT IGNORE INTO category_sub_categories(category_id,sub_category_id) VALUES(11,17);
INSERT IGNORE INTO category_sub_categories(category_id,sub_category_id) VALUES(11,18);
INSERT IGNORE INTO category_sub_categories(category_id,sub_category_id) VALUES(11,19);





INSERT IGNORE INTO categories(categoryname) VALUES('Kids');
INSERT IGNORE INTO sub_categories(name) VALUES('Baby Care');
INSERT IGNORE INTO sub_categories(name) VALUES('Infant 0-2 years');
INSERT IGNORE INTO sub_categories(name) VALUES('Boys Wear');
INSERT IGNORE INTO sub_categories(name) VALUES('Girls Wear');
INSERT IGNORE INTO sub_categories(name) VALUES('Toys & Accessories');

INSERT IGNORE INTO category_sub_categories(category_id,sub_category_id) VALUES(12,20);
INSERT IGNORE INTO category_sub_categories(category_id,sub_category_id) VALUES(12,21);
INSERT IGNORE INTO category_sub_categories(category_id,sub_category_id) VALUES(12,22);
INSERT IGNORE INTO category_sub_categories(category_id,sub_category_id) VALUES(12,23);
INSERT IGNORE INTO category_sub_categories(category_id,sub_category_id) VALUES(12,24);




INSERT IGNORE INTO categories(categoryname) VALUES('Home & Kitchen');
INSERT IGNORE INTO sub_categories(name) VALUES('Kitchen & Appliances');
INSERT IGNORE INTO sub_categories(name) VALUES('Furnishing');
INSERT IGNORE INTO sub_categories(name) VALUES('Decor & Organizers');
INSERT IGNORE INTO sub_categories(name) VALUES('Home Improvement');

INSERT IGNORE INTO category_sub_categories(category_id,sub_category_id) VALUES(13,25);
INSERT IGNORE INTO category_sub_categories(category_id,sub_category_id) VALUES(13,26);
INSERT IGNORE INTO category_sub_categories(category_id,sub_category_id) VALUES(13,27);
INSERT IGNORE INTO category_sub_categories(category_id,sub_category_id) VALUES(13,28);












