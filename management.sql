/*
Navicat MySQL Data Transfer

Source Server         : cheai
Source Server Version : 50726
Source Host           : 127.0.0.1:3306
Source Database       : management

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-12-28 14:09:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `management_id` int(4) NOT NULL AUTO_INCREMENT,
  `management_user` varchar(32) NOT NULL COMMENT '用户名',
  `management_pass` varchar(32) NOT NULL COMMENT '密码',
  PRIMARY KEY (`management_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='管理员';

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'ck', '4QrcOUm6Wau+VuBX8g+IPg==');
INSERT INTO `admin` VALUES ('2', 'cheai', '4QrcOUm6Wau+VuBX8g+IPg==');

-- ----------------------------
-- Table structure for cargo
-- ----------------------------
DROP TABLE IF EXISTS `cargo`;
CREATE TABLE `cargo` (
  `cargo_id` int(64) NOT NULL AUTO_INCREMENT,
  `cargo_name` varchar(64) NOT NULL COMMENT '货物名字',
  `cargo_description` varchar(128) DEFAULT NULL COMMENT '描述',
  `weight` int(128) NOT NULL,
  `purchasing_cost` decimal(8,2) NOT NULL COMMENT '进价',
  `vip_price` decimal(8,2) NOT NULL COMMENT '会员价',
  `retail_price` decimal(8,2) NOT NULL COMMENT '零售价',
  `cargo_img_add` varchar(32) NOT NULL,
  PRIMARY KEY (`cargo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='货物表';

-- ----------------------------
-- Records of cargo
-- ----------------------------
INSERT INTO `cargo` VALUES ('1', '良品小铺 甜辣薄豆干', '甜辣薄豆干麻辣味豆腐干子零食品小吃小包装', '160', '40.00', '45.90', '49.00', 'img/甜辣薄豆干.jpg');
INSERT INTO `cargo` VALUES ('2', '良品小铺 70%黑巧克力', '纯可可脂苦巧克力烘焙礼盒装送女友网红零食', '688', '140.00', '156.50', '158.00', 'img/70%黑巧克力.jpg');
INSERT INTO `cargo` VALUES ('3', '良品小铺 甜辣鸭舌', '卤味特产休闲零食小吃肉类熟食', '120', '78.00', '98.50', '99.80', 'img/甜辣鸭舌.jpg');
INSERT INTO `cargo` VALUES ('4', '良品小铺 夏威夷果', '奶油味坚果休闲食品干货干果零', '238', '25.00', '52.90', '53.80', 'img/夏威夷果.jpg');
INSERT INTO `cargo` VALUES ('5', '良品小铺 菲律宾芒果干', '酸甜水果蜜饯果脯休闲零食小吃特产', '70', '18.00', '30.50', '31.80', 'img/菲律宾芒果干.jpg');
INSERT INTO `cargo` VALUES ('6', '良品小铺 岩焗乳酪吐司手撕夹心小面包', '网红早餐孕妇儿童饼干蛋糕办公室小吃休闲零食礼盒', '500', '29.00', '38.90', '39.90', 'img/岩焗乳酪吐司手撕夹心小面包.jpg');
INSERT INTO `cargo` VALUES ('7', '良品小铺 岩焗乳酪吐司 整箱装早餐蛋糕', '手撕软面包网红点心孕妇儿童食品 办公室代餐休闲零食', '500', '28.00', '39.00', '39.90', 'img/整箱装早餐蛋糕.jpg');
INSERT INTO `cargo` VALUES ('8', '良品小铺 麻辣零食大礼包', '网红小吃鸭脖烤肠鸡爪豆干卤藕金针菇休闲零食小吃', '405', '36.00', '46.00', '46.90', 'img/麻辣零食大礼包.jpg');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `emp_id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(4) NOT NULL,
  `emp_sex` varchar(2) NOT NULL,
  `department` varchar(32) DEFAULT NULL,
  `role` varchar(4) NOT NULL,
  `entry_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '入职时间',
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='员工表';

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', '张三', '男', '管理部', '后勤', '2019-10-27 22:59:32');
INSERT INTO `employee` VALUES ('2', '李四', '男', '销售部', '销售', '2019-10-27 23:02:25');

-- ----------------------------
-- Table structure for procurement
-- ----------------------------
DROP TABLE IF EXISTS `procurement`;
CREATE TABLE `procurement` (
  `id` int(4) NOT NULL,
  `client_name` varchar(64) NOT NULL COMMENT '客户名字',
  `order_id` int(32) NOT NULL COMMENT '订单号',
  `buy_data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '订货日期',
  `commodity_name` varchar(32) NOT NULL COMMENT '商品名',
  `money` decimal(8,2) NOT NULL COMMENT '金额',
  `amount` int(4) NOT NULL COMMENT '数量',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='采购表';

-- ----------------------------
-- Records of procurement
-- ----------------------------

-- ----------------------------
-- Table structure for warehouse
-- ----------------------------
DROP TABLE IF EXISTS `warehouse`;
CREATE TABLE `warehouse` (
  `house_id` int(32) NOT NULL COMMENT 'ID',
  `house_address` varchar(64) NOT NULL COMMENT '仓库地址',
  `admin_name` varchar(8) NOT NULL COMMENT '仓库姓名',
  `area` double(8,2) NOT NULL COMMENT '仓库面积',
  PRIMARY KEY (`house_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='仓库';

-- ----------------------------
-- Records of warehouse
-- ----------------------------
INSERT INTO `warehouse` VALUES ('10000', '湖北武汉', '李甜食', '68.56');
INSERT INTO `warehouse` VALUES ('10001', '福建厦门', '张海鲜', '94.30');
INSERT INTO `warehouse` VALUES ('10002', '中国香港', '王富贵', '90.05');

-- ----------------------------
-- Table structure for wms_supplier
-- ----------------------------
DROP TABLE IF EXISTS `wms_supplier`;
CREATE TABLE `wms_supplier` (
  `SUPPLIER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `SUPPLIER_NAME` varchar(30) NOT NULL,
  `SUPPLIER_PERSON` varchar(10) NOT NULL COMMENT '供货人',
  `SUPPLIER_TEL` varchar(20) NOT NULL,
  `SUPPLIER_EMAIL` varchar(20) NOT NULL,
  `SUPPLIER_ADDRESS` varchar(30) NOT NULL,
  `SUPPLIER_CREATEDATE` date NOT NULL,
  PRIMARY KEY (`SUPPLIER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1020 DEFAULT CHARSET=utf8 COMMENT='供货商';

-- ----------------------------
-- Records of wms_supplier
-- ----------------------------
INSERT INTO `wms_supplier` VALUES ('1013', '浙江有限公司', '王泽伟', '13777771126', '86827868@126.com', '中国 浙江 温州市龙湾区 龙湾区永强大道1648号', '2019-12-03');
INSERT INTO `wms_supplier` VALUES ('1014', '醴陵春天实业有限公司', '温仙容', '13974167256', '23267999@126.com', '中国 湖南 醴陵市 东正街15号', '2010-10-20');
INSERT INTO `wms_supplier` VALUES ('1015', '洛阳嘉吉利饮品有限公司', '郑绮云', '26391678', '22390898@qq.com', '中国 广东 佛山市顺德区 北滘镇怡和路2号怡和中心14楼', '2019-05-21');
INSERT INTO `wms_supplier` VALUES ('1016', '武汉某零食有限公司', '张翼德', '13269854103', '478622546@qq.com', '中国 湖北 武汉 江汉区 江汉路68号', '2019-12-11');
INSERT INTO `wms_supplier` VALUES ('1017', '广东某甜品有限公司', '袁本初', '13965842016', '479852142@qq.com', '中国 广东 佛山市', '2014-10-29');
INSERT INTO `wms_supplier` VALUES ('1018', '上海某饮品有限公司', '曹孟德', '18965201236', '862547896@qq.com', '中国 北京 安定', '2019-12-09');
INSERT INTO `wms_supplier` VALUES ('1019', '深圳某肉铺有限公司', '刘玄德', '19852146320', '14203554139@163.com', '中国 湖北 武汉 江夏区', '2019-02-22');
