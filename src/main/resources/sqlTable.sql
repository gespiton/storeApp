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


INSERT INTO storeApp.goods (name, serialCode, weight, stockNumber, preSaleNumber, storeId, midUserPrice, marketPrice, realPrice, redeemPoint, categoryId, brandId, standId, addTime, lastModifiedTime, description, imagePath, isDividable, defaultExpress) VALUES ('test goods', '123', 1, 0, 0, '0', 11, 11, 10, 0, 2, 0, null, '', '', 'Donec rutrum congue leo eget malesuada. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec velit neque, auctor sit amet aliquam vel, ullamcorper sit amet ligula. Cras ultricies ligula sed magna dictum porta. Sed porttitor lectus nibh. Praesent sapien massa, convallis a pellentesque nec, egestas non nisi. Cras ultricies ligula sed magna dictum porta. Curabitur arcu erat, accumsan id imperdiet et, porttitor at sem. Nulla porttitor accumsan tincidunt. Cras ultricies ligula sed magna dictum porta. Nulla quis lorem ut libero malesuada feugiat.', '0.jpg', 1, 'union');
INSERT INTO storeApp.goods (name, serialCode, weight, stockNumber, preSaleNumber, storeId, midUserPrice, marketPrice, realPrice, redeemPoint, categoryId, brandId, standId, addTime, lastModifiedTime, description, imagePath, isDividable, defaultExpress) VALUES ('ha', '1231', 1, 8, 0, '0', 11, 11, 10, 0, 0, 0, null, '', '', 'Donec rutrum congue leo eget malesuada. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec velit neque, auctor sit amet aliquam vel, ullamcorper sit amet ligula. Cras ultricies ligula sed magna dictum porta. Sed porttitor lectus nibh. Praesent sapien massa, convallis a pellentesque nec, egestas non nisi. Cras ultricies ligula sed magna dictum porta. Curabitur arcu erat, accumsan id imperdiet et, porttitor at sem. Nulla porttitor accumsan tincidunt. Cras ultricies ligula sed magna dictum porta. Nulla quis lorem ut libero malesuada feugiat.', '0.jpg', 1, 'union');
INSERT INTO storeApp.goods (name, serialCode, weight, stockNumber, preSaleNumber, storeId, midUserPrice, marketPrice, realPrice, redeemPoint, categoryId, brandId, standId, addTime, lastModifiedTime, description, imagePath, isDividable, defaultExpress) VALUES ('aaa', '1', 1, 0, 0, '0', 11, 11, 10, 0, 0, 0, null, '', '', 'Donec rutrum congue leo eget malesuada. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec velit neque, auctor sit amet aliquam vel, ullamcorper sit amet ligula. Cras ultricies ligula sed magna dictum porta. Sed porttitor lectus nibh. Praesent sapien massa, convallis a pellentesque nec, egestas non nisi. Cras ultricies ligula sed magna dictum porta. Curabitur arcu erat, accumsan id imperdiet et, porttitor at sem. Nulla porttitor accumsan tincidunt. Cras ultricies ligula sed magna dictum porta. Nulla quis lorem ut libero malesuada feugiat.', '0.jpg', 1, 'union');
INSERT INTO storeApp.goods (name, serialCode, weight, stockNumber, preSaleNumber, storeId, midUserPrice, marketPrice, realPrice, redeemPoint, categoryId, brandId, standId, addTime, lastModifiedTime, description, imagePath, isDividable, defaultExpress) VALUES ('fff', '111', 1, 0, 0, '0', 11, 11, 10, 0, 0, 0, null, '', '', 'Donec rutrum congue leo eget malesuada. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec velit neque, auctor sit amet aliquam vel, ullamcorper sit amet ligula. Cras ultricies ligula sed magna dictum porta. Sed porttitor lectus nibh. Praesent sapien massa, convallis a pellentesque nec, egestas non nisi. Cras ultricies ligula sed magna dictum porta. Curabitur arcu erat, accumsan id imperdiet et, porttitor at sem. Nulla porttitor accumsan tincidunt. Cras ultricies ligula sed magna dictum porta. Nulla quis lorem ut libero malesuada feugiat.', '0.jpg', 1, 'union');
INSERT INTO storeApp.goods (name, serialCode, weight, stockNumber, preSaleNumber, storeId, midUserPrice, marketPrice, realPrice, redeemPoint, categoryId, brandId, standId, addTime, lastModifiedTime, description, imagePath, isDividable, defaultExpress) VALUES ('abc', '132', 1, 0, 0, '0', 11, 11, 10, 0, 0, 0, 5, '', '', 'Donec rutrum congue leo eget malesuada. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec velit neque, auctor sit amet aliquam vel, ullamcorper sit amet ligula. Cras ultricies ligula sed magna dictum porta. Sed porttitor lectus nibh. Praesent sapien massa, convallis a pellentesque nec, egestas non nisi. Cras ultricies ligula sed magna dictum porta. Curabitur arcu erat, accumsan id imperdiet et, porttitor at sem. Nulla porttitor accumsan tincidunt. Cras ultricies ligula sed magna dictum porta. Nulla quis lorem ut libero malesuada feugiat.', '0.jpg', 1, 'union');

INSERT INTO storeApp.brand (name, website, description, type) VALUES ('hqchou', 'hqchou.me', 'ka programmer', 1);
INSERT INTO storeApp.brand (name, website, description, type) VALUES ('one', 'hqchou.me', 'ka programmer', 1);
INSERT INTO storeApp.brand (name, website, description, type) VALUES ('two', 'hqchou.me', 'ka programmer', 1);
INSERT INTO storeApp.brand (name, website, description, type) VALUES ('three', 'hqchou.me', 'ka programmer', 1);


INSERT INTO storeApp.category (name, upperCategoryId, rank, priority, type) VALUES ('shoe3', null, 1, 0, 0);
INSERT INTO storeApp.category (name, upperCategoryId, rank, priority, type) VALUES ('best shoes', 1, 1, 0, 1);
INSERT INTO storeApp.category (name, upperCategoryId, rank, priority, type) VALUES ('shit shoes', 1, 1, 0, 1);
INSERT INTO storeApp.category (name, upperCategoryId, rank, priority, type) VALUES ('food', null, 1, 0, 1);
INSERT INTO storeApp.category (name, upperCategoryId, rank, priority, type) VALUES ('mexical', 4, 1, 0, 1);
INSERT INTO storeApp.category (name, upperCategoryId, rank, priority, type) VALUES ('hamburger', 5, 2, 0, 1);
INSERT INTO storeApp.category (name, upperCategoryId, rank, priority, type) VALUES ('clothes', null, 1, 0, 1);


INSERT INTO storeApp.stand (goodsId, midUserPrice, marketPrice, realPrice, onMarketTime, offMarketTime, preSaleCount) VALUES (1, 11, 11, 10, '123', '', 0);
INSERT INTO storeApp.stand (goodsId, midUserPrice, marketPrice, realPrice, onMarketTime, offMarketTime, preSaleCount) VALUES (3, 11, 11, 10, '123', '', 0);
INSERT INTO storeApp.stand (goodsId, midUserPrice, marketPrice, realPrice, onMarketTime, offMarketTime, preSaleCount) VALUES (4, 11, 11, 10, 'qwe', '', 0);
INSERT INTO storeApp.stand (goodsId, midUserPrice, marketPrice, realPrice, onMarketTime, offMarketTime, preSaleCount) VALUES (5, 11, 11, 10, '123', '', 0);
INSERT INTO storeApp.stand (goodsId, midUserPrice, marketPrice, realPrice, onMarketTime, offMarketTime, preSaleCount) VALUES (6, 11, 11, 10, '', '', 0);