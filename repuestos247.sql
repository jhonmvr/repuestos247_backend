--repuestos 24 7
-- Tabla de Categorías
CREATE TABLE categorias (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL UNIQUE,
    imagen VARCHAR(255) NOT NULL
);

-- Tabla de Productos
CREATE TABLE productos (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    precio NUMERIC(10, 2) NOT NULL,
    imagen VARCHAR(255),
    descripcion TEXT,
    marca VARCHAR(255) NOT NULL,
    modelo VARCHAR(255) NOT NULL,
    categoria_id INTEGER NOT NULL REFERENCES categorias(id),
    subcategoria VARCHAR(255) NOT NULL
);

-- Tabla de Años por Producto
CREATE TABLE años_producto (
    id SERIAL PRIMARY KEY,
    producto_id INTEGER NOT NULL REFERENCES productos(id) ON DELETE CASCADE,
    año INTEGER NOT NULL
);

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL, -- Encriptada
    email VARCHAR(100) UNIQUE NOT NULL,
    role VARCHAR(20) DEFAULT 'user', -- Ejemplo de roles: 'user', 'admin'
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


INSERT INTO categorias (nombre, imagen) VALUES
('ILUMINACION', 'assets/catilum.jpg'),
('CARROCERIA', 'assets/catcarr.jpg');


INSERT INTO productos (nombre, precio, imagen, descripcion, marca, modelo, categoria_id, subcategoria) VALUES
('Faro Delantero Grand Cherokee 2005/2007 RH', 124.57, 
 'https://jepimportaciones.com.ec/114974-large_default/faro-delantero-ford-f-150-2015-2017-lh.jpg', 
 'Faro delantero derecho para Jeep Grand Cherokee modelos 2005 a 2007.', 
 'JEEP', 'GRAND CHEROKEE', 1, 'FARO DELANTERO'),

('Faro Delantero Kia Picanto 2015/2017 LH', 124.57, 
 'https://jepimportaciones.com.ec/115297-large_default/faro-delantero-kia-picanto-x-line-2017-2019-lh.jpg', 
 'Faro Delantero Kia Picanto X Line modelos 2015 a 2017.', 
 'KIA', 'GRAND CHEROKEE', 1, 'FARO DELANTERO'),

('Direccional Delantero Cherokee 1993/1997 RH', 49.71, 
 'https://jepimportaciones.com.ec/115978-large_default/direccional-mitsubishi-montero-92-97-lh.jpg', 
 'Direcciona delantero derecho para Jeep Cherokee modelos 1993 a 1997.', 
 'JEEP', 'CHEROKEE', 1, 'DIRECCIONAL'),

('Neblinero Delanteros DMAX 2016/2024 LH', 49.71, 
 'https://jepimportaciones.com.ec/116478-medium_default/juego-neblineros-hilux-revo-con-tapa-2016-2023.jpg', 
 'Neblineros delanteros para Toyota Hilux modelos 2016 a 2024', 
 'TOYOTA', 'HILUX', 1, 'NEBLINERO'),

('Faro Kia Sportage GT Line LED 2017/2020', 307.53, 
 'https://jepimportaciones.com.ec/112372-medium_default/faro-posterior-esquinero-hyundai-tucson-2019-21-lh.jpg', 
 'Faro Posterior con tecnología LED para Kia Sportage GT Line año 2017.', 
 'KIA', 'SPORTAGE GT LINE', 1, 'FARO POSTERIOR'),

('Capot Ford Escape 2013/2018', 625.77, 
 'https://jepimportaciones.com.ec/98405-medium_default/capot-chevrolet-groove-2021-2024.jpg', 
 'Capot para Ford Escape modelos a partir de 2013.', 
 'FORD', 'ESCAPE', 2, 'CAPOT'),

('Capot Mercedes Benz W202 C-Class 97/2000 LH', 23.80, 
 'https://jepimportaciones.com.ec/99078-large_default/capot-great-wall-poer-2022-2024.jpg', 
 'Direccional izquierda para Mercedes Benz W202 C-Class años 1997 a 2000.', 
 'MERCEDES BENZ', 'W202 C-CLASS', 2, 'CAPOT'),

('Guardafango Onix Sedan 2021/2023', 69.99, 
 'https://jepimportaciones.com.ec/98419-medium_default/guardafango-chevrolet-onix-4p-5p-2021-2023-rh.jpg', 
 'Guardafango Delatero Chevrolet Onix Sedan y Hatchback 2021/2023', 
 'CHEVROLET', 'ONIX', 2, 'GUARDAFANGO'),

('Guardafango Sail 2017/2020', 69.99, 
 'https://jepimportaciones.com.ec/44764-medium_default/guardafango-posterior-chevrolet-sail-2017-2020-rh.jpg', 
 'Guardafango Posterior Chevrolet Sail Sedan a partir de los años 2017/2020', 
 'CHEVROLET', 'SAIL', 2, 'GUARDAFANGO'),

('Guardachoque Hilux 2016/2020 RH', 150.00, 
 'https://jepimportaciones.com.ec/99017-medium_default/guardachoque-delantero-kia-picanto-lx-logo-redondo-2018-2021.jpg', 
 'Guardachoque Delantero Toyota Picanto Lx Logo Redondo 2016/2020', 
 'TOYOTA', 'HILUX', 2, 'GUARDACHOQUE');

INSERT INTO años_producto (producto_id, año) VALUES
-- Producto 1
(1, 2005),
(1, 2006),
(1, 2007),

-- Producto 2
(2, 2015),
(2, 2016),
(2, 2017),

-- Producto 3
(3, 1993),
(3, 1994),
(3, 1995),
(3, 1996),
(3, 1997),

-- Producto 4
(4, 2016),
(4, 2017),
(4, 2018),
(4, 2022),
(4, 2024),

-- Producto 5
(5, 2017),

-- Producto 6
(6, 2013),

-- Producto 7
(7, 1997),
(7, 1998),
(7, 1999),
(7, 2000),

-- Producto 8
(8, 2021),
(8, 2022),
(8, 2023),

-- Producto 9
(9, 2017),
(9, 2018),
(9, 2019),

-- Producto 10
(10, 2016),
(10, 2017),
(10, 2018),
(10, 2019),
(10, 2020);

