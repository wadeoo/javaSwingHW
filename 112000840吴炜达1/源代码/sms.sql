/*
 Navicat Premium Data Transfer

 Source Server         : 本机
 Source Server Type    : MySQL
 Source Server Version : 50553 (5.5.53)
 Source Host           : localhost:3306
 Source Schema         : sms

 Target Server Type    : MySQL
 Target Server Version : 50553 (5.5.53)
 File Encoding         : 65001

 Date: 06/01/2023 17:21:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_classe
-- ----------------------------
DROP TABLE IF EXISTS `tb_classe`;
CREATE TABLE `tb_classe`  (
  `Classe` int(11) NOT NULL,
  `Grade` int(11) NOT NULL,
  `Major_ID` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`Classe`, `Grade`, `Major_ID`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_classe
-- ----------------------------
INSERT INTO `tb_classe` VALUES (1, 2020, '11');
INSERT INTO `tb_classe` VALUES (1, 2020, '12');
INSERT INTO `tb_classe` VALUES (1, 2020, '13');
INSERT INTO `tb_classe` VALUES (2, 2020, '11');
INSERT INTO `tb_classe` VALUES (2, 2020, '12');
INSERT INTO `tb_classe` VALUES (2, 2020, '13');
INSERT INTO `tb_classe` VALUES (3, 2020, '11');
INSERT INTO `tb_classe` VALUES (3, 2020, '12');
INSERT INTO `tb_classe` VALUES (3, 2020, '13');
INSERT INTO `tb_classe` VALUES (4, 2020, '11');
INSERT INTO `tb_classe` VALUES (4, 2020, '12');
INSERT INTO `tb_classe` VALUES (4, 2020, '13');
INSERT INTO `tb_classe` VALUES (5, 2020, '11');
INSERT INTO `tb_classe` VALUES (5, 2020, '12');
INSERT INTO `tb_classe` VALUES (5, 2020, '13');
INSERT INTO `tb_classe` VALUES (6, 2020, '11');
INSERT INTO `tb_classe` VALUES (6, 2020, '12');
INSERT INTO `tb_classe` VALUES (6, 2020, '13');
INSERT INTO `tb_classe` VALUES (7, 2020, '11');
INSERT INTO `tb_classe` VALUES (7, 2020, '12');
INSERT INTO `tb_classe` VALUES (7, 2020, '13');
INSERT INTO `tb_classe` VALUES (8, 2020, '11');
INSERT INTO `tb_classe` VALUES (8, 2020, '12');
INSERT INTO `tb_classe` VALUES (8, 2020, '13');
INSERT INTO `tb_classe` VALUES (9, 2020, '11');
INSERT INTO `tb_classe` VALUES (9, 2020, '12');
INSERT INTO `tb_classe` VALUES (9, 2020, '13');

-- ----------------------------
-- Table structure for tb_course
-- ----------------------------
DROP TABLE IF EXISTS `tb_course`;
CREATE TABLE `tb_course`  (
  `Course_Name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Major_ID` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Grade` int(11) NOT NULL,
  PRIMARY KEY (`Course_Name`, `Major_ID`, `Grade`) USING BTREE,
  INDEX `Major_ID`(`Major_ID`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_course
-- ----------------------------
INSERT INTO `tb_course` VALUES ('数据结构', '11', 2020);
INSERT INTO `tb_course` VALUES ('数据结构', '12', 2020);
INSERT INTO `tb_course` VALUES ('数据结构', '13', 2020);
INSERT INTO `tb_course` VALUES ('英语', '11', 2020);
INSERT INTO `tb_course` VALUES ('英语', '12', 2020);
INSERT INTO `tb_course` VALUES ('英语', '13', 2020);
INSERT INTO `tb_course` VALUES ('计算机组成原理', '11', 2020);
INSERT INTO `tb_course` VALUES ('计算机网络', '13', 2020);
INSERT INTO `tb_course` VALUES ('软件工程导论', '12', 2020);
INSERT INTO `tb_course` VALUES ('面向对象程序设计', '11', 2020);
INSERT INTO `tb_course` VALUES ('面向对象程序设计', '12', 2020);
INSERT INTO `tb_course` VALUES ('面向对象程序设计', '13', 2020);
INSERT INTO `tb_course` VALUES ('高等数学', '11', 2020);
INSERT INTO `tb_course` VALUES ('高等数学', '12', 2020);
INSERT INTO `tb_course` VALUES ('高等数学', '13', 2020);

-- ----------------------------
-- Table structure for tb_department
-- ----------------------------
DROP TABLE IF EXISTS `tb_department`;
CREATE TABLE `tb_department`  (
  `Department_ID` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Department_Name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`Department_ID`) USING BTREE,
  UNIQUE INDEX `Department_Name`(`Department_Name`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_department
-- ----------------------------
INSERT INTO `tb_department` VALUES ('01', '艺术系');
INSERT INTO `tb_department` VALUES ('02', '中国语言文学系');
INSERT INTO `tb_department` VALUES ('03', '电子信息系');
INSERT INTO `tb_department` VALUES ('04', '计算机科学与技术系');
INSERT INTO `tb_department` VALUES ('05', '物流与信息管理系');
INSERT INTO `tb_department` VALUES ('06', '旅游管理系');
INSERT INTO `tb_department` VALUES ('07', '机械与汽车工程系');
INSERT INTO `tb_department` VALUES ('08', '国际贸易与金融系');
INSERT INTO `tb_department` VALUES ('09', '工商管理系');
INSERT INTO `tb_department` VALUES ('10', '公共管理系');
INSERT INTO `tb_department` VALUES ('11', '建筑学系');
INSERT INTO `tb_department` VALUES ('12', '化学与药学系');
INSERT INTO `tb_department` VALUES ('13', '外语系');
INSERT INTO `tb_department` VALUES ('14', '音乐舞蹈学院');

-- ----------------------------
-- Table structure for tb_major
-- ----------------------------
DROP TABLE IF EXISTS `tb_major`;
CREATE TABLE `tb_major`  (
  `Major_ID` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Major_Name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Department_ID` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`Major_ID`) USING BTREE,
  UNIQUE INDEX `Major_Name`(`Major_Name`) USING BTREE,
  INDEX `Department_ID`(`Department_ID`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_major
-- ----------------------------
INSERT INTO `tb_major` VALUES ('01', '视觉传达设计专业', '01');
INSERT INTO `tb_major` VALUES ('02', '动画专业', '01');
INSERT INTO `tb_major` VALUES ('03', '汉语言文学专业', '02');
INSERT INTO `tb_major` VALUES ('04', '广告学专业', '02');
INSERT INTO `tb_major` VALUES ('05', '汉语国际教育专业', '02');
INSERT INTO `tb_major` VALUES ('06', '电子信息科学与技术专业', '03');
INSERT INTO `tb_major` VALUES ('07', '微电子科学与工程专业', '03');
INSERT INTO `tb_major` VALUES ('08', '自动化专业', '03');
INSERT INTO `tb_major` VALUES ('09', '通信工程专业', '03');
INSERT INTO `tb_major` VALUES ('10', '测控技术与仪器专业', '03');
INSERT INTO `tb_major` VALUES ('11', '计算机科学与技术专业', '04');
INSERT INTO `tb_major` VALUES ('12', '软件工程专业', '04');
INSERT INTO `tb_major` VALUES ('13', '网络工程专业', '04');
INSERT INTO `tb_major` VALUES ('14', '物流管理专业', '05');
INSERT INTO `tb_major` VALUES ('15', '信息管理与信息系统专业', '05');
INSERT INTO `tb_major` VALUES ('16', '电子商务专业', '05');
INSERT INTO `tb_major` VALUES ('17', '旅游管理专业', '06');
INSERT INTO `tb_major` VALUES ('18', '机械设计制造及其自动化专业', '07');
INSERT INTO `tb_major` VALUES ('19', '汽车服务工程专业', '07');
INSERT INTO `tb_major` VALUES ('20', '车辆工程专业', '07');
INSERT INTO `tb_major` VALUES ('21', '工业工程专业', '07');
INSERT INTO `tb_major` VALUES ('22', '国际经济与贸易专业', '08');
INSERT INTO `tb_major` VALUES ('23', '金融学专业', '08');
INSERT INTO `tb_major` VALUES ('24', '工商管理专业', '09');
INSERT INTO `tb_major` VALUES ('25', '市场营销专业', '09');
INSERT INTO `tb_major` VALUES ('26', '人力资源管理专业', '09');
INSERT INTO `tb_major` VALUES ('27', '会计学专业', '09');
INSERT INTO `tb_major` VALUES ('28', '行政管理专业', '10');
INSERT INTO `tb_major` VALUES ('29', '劳动与社会保障专业', '10');
INSERT INTO `tb_major` VALUES ('30', '社会工作专业', '10');
INSERT INTO `tb_major` VALUES ('31', '建筑学专业', '11');
INSERT INTO `tb_major` VALUES ('32', '城乡规划专业', '11');
INSERT INTO `tb_major` VALUES ('33', '应用化学专业', '12');
INSERT INTO `tb_major` VALUES ('34', '制药工程(生物制药)专业', '12');
INSERT INTO `tb_major` VALUES ('35', '药物制剂专业', '12');
INSERT INTO `tb_major` VALUES ('36', '中药学专业', '12');
INSERT INTO `tb_major` VALUES ('37', '化学工程与工艺专业', '12');
INSERT INTO `tb_major` VALUES ('38', '英语专业', '13');
INSERT INTO `tb_major` VALUES ('39', '日语专业', '13');
INSERT INTO `tb_major` VALUES ('40', '朝鲜语（韩国语）专业', '13');
INSERT INTO `tb_major` VALUES ('41', '音乐表演专业', '14');
INSERT INTO `tb_major` VALUES ('42', '舞蹈编导专业', '14');

-- ----------------------------
-- Table structure for tb_score
-- ----------------------------
DROP TABLE IF EXISTS `tb_score`;
CREATE TABLE `tb_score`  (
  `Student_Id` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Student_Name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Course_Name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Score` decimal(4, 1) NULL DEFAULT NULL,
  PRIMARY KEY (`Course_Name`, `Student_Id`) USING BTREE,
  INDEX `Student_Id`(`Student_Id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_score
-- ----------------------------
INSERT INTO `tb_score` VALUES ('041120540', 'wu', '计算机组成原理', 9.0);
INSERT INTO `tb_score` VALUES ('041120540', 'wu', '数据结构', 9.0);
INSERT INTO `tb_score` VALUES ('041120540', 'wu', '英语', 9.0);
INSERT INTO `tb_score` VALUES ('041120540', 'wu', '高等数学', 9.0);
INSERT INTO `tb_score` VALUES ('041120540', 'wu', '面向对象程序设计', 9.0);
INSERT INTO `tb_score` VALUES ('041120543', '123', '高等数学', 8.0);
INSERT INTO `tb_score` VALUES ('041120543', '123', '英语', 9.0);
INSERT INTO `tb_score` VALUES ('041120543', '123', '数据结构', 8.0);
INSERT INTO `tb_score` VALUES ('041120543', '123', '计算机组成原理', 0.0);
INSERT INTO `tb_score` VALUES ('041120543', '123', '面向对象程序设计', 8.0);

-- ----------------------------
-- Table structure for tb_student
-- ----------------------------
DROP TABLE IF EXISTS `tb_student`;
CREATE TABLE `tb_student`  (
  `Student_Id` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Student_Name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Student_Sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '男',
  `Grade` int(11) NOT NULL,
  `Classe` int(11) NOT NULL,
  `Major_ID` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Major_Name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Department_ID` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Department_Name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`Student_Id`) USING BTREE,
  INDEX `Department_ID`(`Department_ID`) USING BTREE,
  INDEX `Major_ID`(`Major_ID`) USING BTREE,
  INDEX `Department_Name`(`Department_Name`) USING BTREE,
  INDEX `Major_Name`(`Major_Name`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_student
-- ----------------------------
INSERT INTO `tb_student` VALUES ('041120540', 'wu', '男', 2020, 5, '11', '计算机科学与技术专业', '04', '计算机科学与技术系');
INSERT INTO `tb_student` VALUES ('041120543', '123', '男', 2020, 5, '11', '计算机科学与技术专业', '04', '计算机科学与技术系');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `User_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Password_` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `IsLogin` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`User_name`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('123', '123', b'1');

SET FOREIGN_KEY_CHECKS = 1;
