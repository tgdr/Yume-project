/*
 Navicat Premium Data Transfer

 Source Server         : bluewhite
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : 192.168.1.220:3306
 Source Schema         : yume

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 05/07/2020 15:34:42
*/
CREATE database yume;
use yume;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for live_log
-- ----------------------------
DROP TABLE IF EXISTS `live_log`;
CREATE TABLE `live_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `live_start` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `live_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `live_url` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `live_status` tinyint(1) NOT NULL,
  `live_end` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of live_log
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
