use module03;
-- Table banners
CREATE TABLE banners (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255),
    image VARCHAR(255),
    summary TEXT,
    link VARCHAR(255),
    order_by INT,
    status INT
);

-- Table contacts
CREATE TABLE contacts (
    id INT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(255),
    address VARCHAR(255),
    message TEXT,
    status INT
);

-- Table blogs
CREATE TABLE blogs (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255),
    image VARCHAR(255),
    content TEXT,
    status INT
);

-- Table abouts
CREATE TABLE abouts (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255),
    image VARCHAR(255),
    content TEXT,
    status INT
);

-- Table customers
CREATE TABLE customers (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    address VARCHAR(255),
    phone VARCHAR(15),
    email VARCHAR(255)
);

-- Table orders
CREATE TABLE orders (
    id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT,
    total DECIMAL(10, 2),
    status INT,
    FOREIGN KEY (customer_id) REFERENCES customers(id)
);

-- Table order_details
CREATE TABLE order_details (
    id INT PRIMARY KEY AUTO_INCREMENT,
    order_id INT,
    product_id INT,
    price DECIMAL(10, 2),
    quantity INT,
    FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (product_id) REFERENCES products(id)
);

-- Table products
CREATE TABLE products (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    category_id INT,
    image VARCHAR(255),
    list_image TEXT,
    price DECIMAL(10, 2),
    sale_price DECIMAL(10, 2),
    description TEXT,
    keyword VARCHAR(255),
    content TEXT,
    status INT,
    FOREIGN KEY (category_id) REFERENCES categorys(id)
);

-- Table categorys
CREATE TABLE categorys (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    keyword VARCHAR(255),
    description TEXT,
    status INT
);

-- Table services
CREATE TABLE services (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    summary TEXT,
    content TEXT,
    image VARCHAR(255),
    order_by INT,
    status INT
);

-- Table books
CREATE TABLE books (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    service_id INT,
    name VARCHAR(255),
    phone VARCHAR(15),
    date DATE,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (service_id) REFERENCES services(id)
);

-- Table users (assuming it's a default table in Laravel)
CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT
);

-- Table comments
CREATE TABLE comments (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    product_id INT,
    message TEXT,
    status INT,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (product_id) REFERENCES products(id)
);
