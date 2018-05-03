/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : grad

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2018-05-03 23:35:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `employee`
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `manager_name` varchar(20) NOT NULL COMMENT '员工姓名',
  `phone` varchar(20) NOT NULL COMMENT '员工手机号',
  `privilege` int(11) NOT NULL COMMENT '员工权限 0 查看所有数据权限 1 可以添加设备监控人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modifie_time` datetime NOT NULL COMMENT '修改时间',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '数据状态(1:有效, 0:删除)',
  PRIMARY KEY (`id`),
  KEY `idx_phone` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='监控员工信息表';

-- ----------------------------
-- Records of employee
-- ----------------------------

-- ----------------------------
-- Table structure for `sensor_data`
-- ----------------------------
DROP TABLE IF EXISTS `sensor_data`;
CREATE TABLE `sensor_data` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `sensor_id` varchar(50) NOT NULL COMMENT '传感器主键',
  `type` varchar(20) NOT NULL DEFAULT '指标类型',
  `value` float(20,0) NOT NULL COMMENT '即时数据',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modified_time` datetime NOT NULL COMMENT '修改时间',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '数据状态(1:有效, 0:删除)',
  PRIMARY KEY (`id`),
  KEY `idx_sensor_id` (`sensor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='传感器表';

-- ----------------------------
-- Records of sensor_data
-- ----------------------------

-- ----------------------------
-- Table structure for `sensor_info`
-- ----------------------------
DROP TABLE IF EXISTS `sensor_info`;
CREATE TABLE `sensor_info` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `sensor_name` varchar(50) NOT NULL COMMENT '传感器名字/型号',
  `sensor_addr` varchar(20) NOT NULL COMMENT '传感器地址',
  `sensor_type` varchar(20) NOT NULL COMMENT '传感器检测数据类型',
  `thres_max` int(20) unsigned NOT NULL COMMENT '最高阈值',
  `thres_min` int(20) unsigned NOT NULL COMMENT '最低阈值',
  `managers` varchar(200) NOT NULL COMMENT '监控人员工号',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modifie_time` datetime NOT NULL COMMENT '修改时间',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '数据状态(1:有效, 0:删除)',
  PRIMARY KEY (`id`),
  KEY `idx_sensor_type` (`sensor_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='传感器表';

-- ----------------------------
-- Records of sensor_info
-- ----------------------------
