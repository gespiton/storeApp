USE test;
DROP TABLE items;
CREATE TABLE items (
  id               BIGINT AUTO_INCREMENT PRIMARY KEY,
  name             VARCHAR(40)        NOT NULL,
  serialCode       VARCHAR(40) UNIQUE NOT NULL,
  weight           DOUBLE DEFAULT 0,
  stockNumber      INT    DEFAULT 0,
  preSaleNumber    INT    DEFAULT 0,
  shop             VARCHAR(40),
  introducedPrice  DOUBLE DEFAULT 0,
  marketPrice      DOUBLE DEFAULT 0,
  bankPrice        DOUBLE DEFAULT 0,
  exchangeCredit   INT    DEFAULT 0,
  categoryName     VARCHAR(40),
  brandName        VARCHAR(40),
  onMarketTime     VARCHAR(20),
  outMarketTime    VARCHAR(20),
  addedTime        VARCHAR(20),
  lastModifiedTime VARCHAR(20),
  description      VARCHAR(1000),
  imagePath        VARCHAR(100),
  isDividable      BOOL   DEFAULT FALSE,
  defaultExpress   VARCHAR(20)
);
INSERT INTO items (name, serialCode, weight,
                   stockNumber, preSaleNumber) VALUES ('me', 123341, 23, 1, 13);

INSERT INTO items (name, serialCode, weight,
                   stockNumber, preSaleNumber) VALUES ('you', 1233431, 23, 1, 13);
INSERT INTO items (id, name, serialCode, weight, stockNumber, preSaleNumber, shop, itroducedUserPrice, marketPrice, bankPrice, exchangeCredit, catagoryName, brandName, onMarketTime, outMarketTime, addedTime, lastModifiedTime, description, imageNumber, isDividable)
VALUES ();
SELECT *
FROM items;

SELECT count(*)
FROM items;

CREATE TABLE category (
  id              BIGINT PRIMARY KEY       AUTO_INCREMENT,
  name            VARCHAR(40) UNIQUE NOT NULL,
  upperCategoryId BIGINT                   DEFAULT NULL,
  rank            INT                      DEFAULT NULL,
  FOREIGN KEY (upperCategoryId) REFERENCES category (id)
);
DROP TABLE category;

INSERT INTO category (name) VALUES ('shoe');
INSERT INTO category (name, upperCategoryId, rank) VALUES ('best shoes', 1, 1);
INSERT INTO category (name, upperCategoryId, rank) VALUES ('shit shoes', 1, 1);
INSERT INTO category (name) VALUE ('food');
INSERT INTO category (name, upperCategoryId, rank) VALUES ('mexical', 4, 1);
INSERT INTO category (name, upperCategoryId, rank) VALUES ('hamburger', 5, 2);
INSERT INTO category (name) VALUES ('clothes');

SELECT name
FROM category
WHERE id = 1;

SELECT id
FROM category
WHERE name = 'shoe';

SELECT *
FROM category;

DELETE FROM items;

SELECT *
FROM items;
