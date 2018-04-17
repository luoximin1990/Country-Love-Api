/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : country_love

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-03-14 11:26:19
*/

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `birthday` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `marital_status` int(11) NOT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `new_address` varchar(255) DEFAULT NULL,
  `old_address` varchar(255) DEFAULT NULL,
  `new_password` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `signin` varchar(255) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `old_password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

CREATE TABLE `j_position_province` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `province_id` int(11) unsigned NOT NULL COMMENT '省份id、省份编号',
  `province_name` char(32) NOT NULL COMMENT '省份名称',
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `province_id` (`province_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COMMENT='省份数据库';

CREATE TABLE `j_position_city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `province_id` int(10) unsigned NOT NULL COMMENT '地级市id',
  `city_id` bigint(20) unsigned NOT NULL COMMENT '县级市id',
  `city_name` char(64) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `city_id` (`city_id`),
  KEY `province_id` (`province_id`)
) ENGINE=InnoDB AUTO_INCREMENT=346 DEFAULT CHARSET=utf8 COMMENT='县级市数据库';

CREATE TABLE `j_position_country` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '地级市主键ID',
  `city_id` bigint(20) unsigned NOT NULL COMMENT '地级市id',
  `country_id` bigint(20) unsigned NOT NULL COMMENT '县级id',
  `country_name` char(64) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `country_id` (`country_id`),
  KEY `city_id` (`city_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2857 DEFAULT CHARSET=utf8 COMMENT='地区市数据库';

CREATE TABLE `j_position_town` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `country_id` bigint(20) unsigned NOT NULL COMMENT '县级市id',
  `town_id` bigint(20) unsigned NOT NULL COMMENT '镇id',
  `town_name` char(64) NOT NULL,
  `country_name` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `town_id` (`town_id`),
  KEY `country_id` (`country_id`)
) ENGINE=InnoDB AUTO_INCREMENT=43855 DEFAULT CHARSET=utf8 COMMENT='镇数据库';

CREATE TABLE `j_position_village` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `town_id` bigint(20) unsigned NOT NULL COMMENT '镇id',
  `village_id` bigint(20) unsigned NOT NULL COMMENT '村id--唯一',
  `village_name` char(64) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `village_id` (`village_id`),
  KEY `town_id` (`town_id`)
) ENGINE=InnoDB AUTO_INCREMENT=693338 DEFAULT CHARSET=utf8 COMMENT='省市县镇村数据';