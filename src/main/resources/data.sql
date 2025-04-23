DELETE FROM products;
DELETE FROM receptions;
DELETE FROM pvz;
DELETE FROM users;

ALTER SEQUENCE users_id_seq RESTART WITH 1;
ALTER SEQUENCE pvz_id_seq RESTART WITH 1;
ALTER SEQUENCE receptions_id_seq RESTART WITH 1;
ALTER SEQUENCE products_id_seq RESTART WITH 1;

INSERT INTO users (id, email, password, role)
VALUES (1, 'string@gmail.com', '$2a$10$DKNZ0r9oLWxA/KBu3J.0NOzIxyUE45VIO25ohaWQQXUD91mKVZQ/S', 'EMPLOYEE');

INSERT INTO pvz (id, registration_date, city)
VALUES (1, '2025-04-23 09:33:26.878645 +00:00', '_1');

-- INSERT INTO receptions (id, date_time, pvz_id, status)
-- VALUES (1, CURRENT_TIMESTAMP, 1, 'IN_PROGRESS');
--
-- INSERT INTO products (id, date_time, type, reception_id)
-- VALUES (1, CURRENT_TIMESTAMP, 'электроника', 1);