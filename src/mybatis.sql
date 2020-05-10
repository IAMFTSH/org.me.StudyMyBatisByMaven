/*
 Navicat MySQL Data Transfer

 Source Server         : ftsh
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : 127.0.0.1:3306
 Source Schema         : mybatis

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 10/05/2020 16:56:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for Address
-- ----------------------------
DROP TABLE IF EXISTS `Address`;
CREATE TABLE `Address` (
  `addressId` int NOT NULL,
  `homeAddress` varchar(45) DEFAULT NULL,
  `family` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`addressId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of Address
-- ----------------------------
BEGIN;
INSERT INTO `Address` VALUES (20, '天安門', '北京');
COMMIT;

-- ----------------------------
-- Table structure for People
-- ----------------------------
DROP TABLE IF EXISTS `People`;
CREATE TABLE `People` (
  `peopleId` int NOT NULL,
  `id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`peopleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of People
-- ----------------------------
BEGIN;
INSERT INTO `People` VALUES (99, '12');
INSERT INTO `People` VALUES (100, '11');
COMMIT;

-- ----------------------------
-- Table structure for Person
-- ----------------------------
DROP TABLE IF EXISTS `Person`;
CREATE TABLE `Person` (
  `id` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `age` varchar(45) DEFAULT NULL,
  `sex` int DEFAULT NULL,
  `addressid` int DEFAULT NULL,
  `peopleid` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of Person
-- ----------------------------
BEGIN;
INSERT INTO `Person` VALUES (11, 'ccc', '30', 1, 20, '100');
INSERT INTO `Person` VALUES (12, 'ccc', '30', 1, 20, '100');
INSERT INTO `Person` VALUES (13, 'ddd', '30', 1, 20, '100');
INSERT INTO `Person` VALUES (14, 'ddd', '30', 0, 20, '100');
INSERT INTO `Person` VALUES (15, 'ddd', '30', 0, 20, '100');
INSERT INTO `Person` VALUES (16, 'ddd', '30', 0, 20, '100');
INSERT INTO `Person` VALUES (17, 'ddd', '30', 0, 20, '100');
INSERT INTO `Person` VALUES (20, 'ccc', '30', 0, 2, '1');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
