CREATE DATABASE  if not EXISTS storeApp
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;
USE storeApp;
CREATE TABLE goods (
  id               BIGINT AUTO_INCREMENT PRIMARY KEY,
  name             VARCHAR(40)        NOT NULL,
  serialCode       VARCHAR(40) UNIQUE NOT NULL,
  weight           DOUBLE DEFAULT 0,
  stockNumber      INT    DEFAULT 0,
  preSaleNumber    INT    DEFAULT 0,
  storeId          VARCHAR(40),
  midUserPrice     DOUBLE DEFAULT 0,
  marketPrice      DOUBLE DEFAULT 0,
  realPrice        DOUBLE DEFAULT 0,
  redeemPoint      INT    DEFAULT 0,
  categoryId       INT    DEFAULT NULL,
  brandId          INT    DEFAULT NULL,
  standId          INT    DEFAULT NULL,
  outMarketTime    VARCHAR(20),
  addTime          VARCHAR(20),
  lastModifiedTime VARCHAR(20),
  description      VARCHAR(1000),
  imagePath        VARCHAR(100),
  isDividable      BOOL   DEFAULT FALSE,
  defaultExpress   VARCHAR(20)
);

CREATE TABLE category (
  id              BIGINT PRIMARY KEY       AUTO_INCREMENT,
  name            VARCHAR(40) UNIQUE NOT NULL,
  upperCategoryId BIGINT                   DEFAULT NULL,
  rank            INT                      DEFAULT 1,
  priority        INT                      DEFAULT 0,
  type            INT                      DEFAULT 1,
  FOREIGN KEY (upperCategoryId) REFERENCES category (id)
);

CREATE TABLE brand (
  id          BIGINT PRIMARY KEY AUTO_INCREMENT,
  name        VARCHAR(40) NOT NULL,
  website     VARCHAR(40),
  description VARCHAR(1000),
  type        INT                DEFAULT 1
);

CREATE TABLE stand (
  id            BIGINT PRIMARY KEY AUTO_INCREMENT,
  goodsId       BIGINT REFERENCES goods (id),
  midUserPrice  DOUBLE,
  marketPrice   DOUBLE,
  realPrice     DOUBLE,
  onMarketTime  VARCHAR(20),
  offMarketTime VARCHAR(20),
  preSaleCount  LONG
);