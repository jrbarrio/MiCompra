CREATE TABLE cadena (id int(10) PRIMARY KEY, nombre varchar(45) NOT NULL);
CREATE TABLE comercio (id int(10) PRIMARY KEY, nombre varchar(45) NOT NULL, cadena int(10) REFERENCES cadena (id));  
CREATE TABLE marca (id int(10) PRIMARY KEY, nombre varchar(45) NOT NULL);
CREATE TABLE medida (id int(10) PRIMARY KEY, nombre varchar(45) NOT NULL);
CREATE TABLE producto (id int(10) PRIMARY KEY, nombre varchar(45) NOT NULL, medida int(10) NOT NULL REFERENCES medida (id));
CREATE TABLE articulo (id int(10) PRIMARY KEY, nombre varchar(45) NOT NULL, producto int(10) NOT NULL REFERENCES producto (id), marca int(10) NOT NULL REFERENCES marca (id), precio int(10) NOT NULL);
CREATE TABLE precio (id int(10) PRIMARY KEY, medida int(10) NOT NULL REFERENCES `medida` (id), cantidad decimal(10,0) NOT NULL, precio decimal(10,0) NOT NULL, articulo int(10) NOT NULL REFERENCES articulo (id));
