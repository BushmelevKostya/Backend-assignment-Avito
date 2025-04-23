DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS products CASCADE;
DROP TABLE IF EXISTS receptions CASCADE;
DROP TABLE IF EXISTS pvz CASCADE;

CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       email VARCHAR(255) NOT NULL,
                       password VARCHAR(255),
                       role VARCHAR(50) NOT NULL
);

CREATE TABLE pvz (
                     id SERIAL PRIMARY KEY,
                     registration_date TIMESTAMP WITH TIME ZONE,
                     city VARCHAR(50) NOT NULL
);

CREATE TABLE receptions (
                            id SERIAL PRIMARY KEY,
                            date_time TIMESTAMP WITH TIME ZONE NOT NULL,
                            pvz_id bigint NOT NULL REFERENCES pvz(id),
                            status VARCHAR(50) NOT NULL
);

CREATE TABLE products (
                          id SERIAL PRIMARY KEY,
                          date_time TIMESTAMP WITH TIME ZONE,
                          type VARCHAR(50) NOT NULL,
                          reception_id bigint NOT NULL,
                          CONSTRAINT fk_product_reception FOREIGN KEY (reception_id) REFERENCES receptions (id)
);
