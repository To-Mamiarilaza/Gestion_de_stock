-- SCRIPT FOR THE DATABASE

CREATE DATABASE gestion_stock;

\c gestion_stock;

CREATE SEQUENCE IF NOT EXISTS seq_store;
CREATE TABLE store
(
    id_store   VARCHAR(10) PRIMARY KEY,
    store_name VARCHAR(30),
    etat       INTEGER
);

CREATE SEQUENCE IF NOT EXISTS seq_unite;
CREATE TABLE unite
(
    id_unite   VARCHAR(7) PRIMARY KEY,
    unite_name VARCHAR(30),
    etat       INTEGER
);

CREATE SEQUENCE IF NOT EXISTS seq_article;
CREATE TABLE article
(
    id_article    VARCHAR(10) PRIMARY KEY,
    article_code  VARCHAR(10),  -- In case we should change article code
    article_name  VARCHAR(30),
    id_unite      VARCHAR(7),
    movement_type VARCHAR(4),
    etat          INTEGER,
    FOREIGN KEY (id_unite) REFERENCES unite (id_unite)
);

CREATE SEQUENCE IF NOT EXISTS seq_incoming;
CREATE TABLE incoming
(
    id_incoming VARCHAR(10) PRIMARY KEY,
    date        DATE,
    id_article  VARCHAR(10),
    id_store    VARCHAR(10),
    quantity    DECIMAL(8, 2),
    unit_price  DECIMAL(10, 2),
    etat        INTEGER,
    FOREIGN KEY (id_article) REFERENCES article (id_article),
    FOREIGN KEY (id_store) REFERENCES store (id_store)
);

CREATE SEQUENCE IF NOT EXISTS seq_outgoing;
CREATE TABLE outgoing
(
    id_outgoing VARCHAR(10) PRIMARY KEY,
    date        DATE,
    id_incoming  VARCHAR(10),
    quantity    DECIMAL(8, 2),
    unit_price  DECIMAL(10, 2),
    etat        INTEGER,
    FOREIGN KEY (id_incoming) REFERENCES incoming (id_incoming)
);

-- Data for testing
ALTER SEQUENCE seq_store RESTART WITH 3;
INSERT INTO store (id_store, store_name, etat) VALUES
('STR0001', 'Stockage de Bongolava', 1),
('STR0002', 'Stockage d'' Antsirabe', 1);

ALTER SEQUENCE seq_unite RESTART WITH 2;
INSERT INTO unite (id_unite, unite_name, etat) VALUES
('UNT0001', 'kg', 1);

ALTER SEQUENCE seq_article RESTART WITH 5;
INSERT INTO article (id_article, article_code, article_name, id_unite, movement_type, etat) VALUES
('ART0001', 'R011', 'Vary fotsy', 'UNT0001', 'FIFO', 1),
('ART0002', 'R012', 'Vary mena', 'UNT0001', 'FIFO', 1),
('ART0003', 'R021', 'Katsaka', 'UNT0001', 'LIFO', 1),
('ART0004', 'R022', 'Katsaka voatoto', 'UNT0001', 'LIFO', 1);

ALTER SEQUENCE seq_incoming RESTART WITH 10;
INSERT INTO incoming (id_incoming, date, id_article, id_store, quantity, unit_price, etat) VALUES
('INC0001', '2023-01-10', 'ART0001', 'STR0001', 1000, 2000, 1),
('INC0002', '2023-02-01', 'ART0001', 'STR0001', 500, 2500, 1),
('INC0003', '2023-01-10', 'ART0002', 'STR0001', 800, 2200, 1),
('INC0004', '2023-02-01', 'ART0002', 'STR0001', 500, 2600, 1),
('INC0005', '2023-01-10', 'ART0003', 'STR0002', 500, 1400, 1),
('INC0006', '2023-02-01', 'ART0003', 'STR0002', 600, 1200, 1),
('INC0007', '2023-01-20', 'ART0001', 'STR0002', 800, 2100, 1),
('INC0008', '2023-02-01', 'ART0004', 'STR0001', 400, 1300, 1);

ALTER SEQUENCE seq_outgoing RESTART WITH 5;
INSERT INTO outgoing (id_outgoing, date, id_incoming, quantity, unit_price, etat) VALUES
('OUT0001', '2023-01-15', 'INC0001', 200, 2000, 1),
('OUT0002', '2023-01-20', 'INC0001', 500, 2000, 1),
('OUT0003', '2023-02-05', 'INC0001', 300, 2250, 1),
('OUT0004', '2023-02-05', 'INC0002', 300, 2250, 1);



-- Reinitialisation script

DELETE FROM outgoing;

DELETE FROM incoming;

DELETE FROM article;

DELETE FROM unite;

DELETE FROM store;

