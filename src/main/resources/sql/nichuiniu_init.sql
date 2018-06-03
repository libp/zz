/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 80011
Source Host           : 127.0.0.1:3306
Source Database       : nichuiniu

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2018-06-03 09:11:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tbl_nichuiniu_agree
-- ----------------------------
DROP TABLE IF EXISTS `tbl_nichuiniu_agree`;
CREATE TABLE `tbl_nichuiniu_agree` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `UserId` int(11) DEFAULT NULL COMMENT '用户ID',
  `ArticleId` int(11) DEFAULT NULL COMMENT '文章ID',
  `AgreeTime` datetime DEFAULT NULL COMMENT '点赞时间',
  `AgreeStatus` int(11) DEFAULT NULL COMMENT '点赞状态，1表示显示，2表示取消赞',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbl_nichuiniu_article
-- ----------------------------
DROP TABLE IF EXISTS `tbl_nichuiniu_article`;
CREATE TABLE `tbl_nichuiniu_article` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Num` varchar(255) DEFAULT NULL COMMENT '文章编号',
  `Title` varchar(255) DEFAULT NULL COMMENT '文章标题',
  `CreateTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '文章在该网站发布时间',
  `GetTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '文章抓取时间',
  `Author` varchar(255) DEFAULT NULL COMMENT '作者',
  `Content` longtext COMMENT '文章内容',
  `ImgUrl` varchar(255) DEFAULT NULL COMMENT '图片路径',
  `Url` varchar(255) DEFAULT NULL COMMENT '文章链接',
  `IsUse` int(11) DEFAULT '0' COMMENT '文章是否符合要求。 0表示刚抓到数据，1表示符合，2表示不符合',
  `WebName` varchar(255) DEFAULT NULL COMMENT '网站名称：新华网、新浪等',
  `Tag` varchar(255) DEFAULT NULL COMMENT '文章标签',
  `Category` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '内容分类',
  PRIMARY KEY (`Id`),
  KEY `Url` (`Url`) USING BTREE,
  KEY `Title` (`Title`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=148134 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbl_nichuiniu_log
-- ----------------------------
DROP TABLE IF EXISTS `tbl_nichuiniu_log`;
CREATE TABLE `tbl_nichuiniu_log` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `LogTime` datetime DEFAULT NULL COMMENT '日志记录时间',
  `ClassName` varchar(255) DEFAULT NULL COMMENT '产生日志的类名',
  `Level` varchar(255) DEFAULT NULL COMMENT '日志级别',
  `Message` varchar(1000) DEFAULT NULL COMMENT '日志内容',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=40254 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbl_nichuiniu_recommend
-- ----------------------------
DROP TABLE IF EXISTS `tbl_nichuiniu_recommend`;
CREATE TABLE `tbl_nichuiniu_recommend` (
  `id` int(11) NOT NULL,
  `RecommendId` int(11) DEFAULT NULL,
  `CreateTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `UpdateTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbl_nichuiniu_story
-- ----------------------------
DROP TABLE IF EXISTS `tbl_nichuiniu_story`;
CREATE TABLE `tbl_nichuiniu_story` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(255) DEFAULT NULL COMMENT '内容,应该限制为35个汉字',
  `Num` varchar(255) DEFAULT '' COMMENT '文章编号',
  `Content` text COMMENT '内容,65535个字节',
  `Author` varchar(255) DEFAULT NULL COMMENT '作者',
  `CreateTime` datetime DEFAULT NULL COMMENT '吹牛皮时间',
  `RealizeTime` datetime DEFAULT NULL COMMENT '牛皮实现时间',
  `OriginPlace` varchar(255) DEFAULT NULL COMMENT '牛皮起源的地方，知名网站、报纸、电视',
  `ClickTime` int(11) NOT NULL DEFAULT '0' COMMENT '点击量',
  `AgreeTime` int(11) NOT NULL DEFAULT '0' COMMENT '点赞数',
  `IsShow` int(255) NOT NULL DEFAULT '1' COMMENT '是否显示1显示，0不显示',
  `StoryType` varchar(255) DEFAULT '' COMMENT '故事类型：1、时事、政治、企业、个人...等等。故事类型应该是可配置的，例如字典 ',
  `StroyTag` varchar(255) DEFAULT NULL COMMENT '故事的标签，先留着字段',
  `Source` int(11) NOT NULL DEFAULT '0' COMMENT '牛皮来源：1、用户提供；0蜘蛛抓取',
  `Url` varchar(255) DEFAULT NULL COMMENT '来源URL地址',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=504 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbl_nichuiniu_user
-- ----------------------------
DROP TABLE IF EXISTS `tbl_nichuiniu_user`;
CREATE TABLE `tbl_nichuiniu_user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `RoleId` int(11) DEFAULT NULL,
  `UserName` varchar(255) DEFAULT NULL,
  `PassWord` varchar(255) DEFAULT NULL,
  `LoginTime` int(11) DEFAULT NULL COMMENT '登录次数',
  `LastLoginTime` datetime DEFAULT NULL COMMENT '上次登录时间',
  `LastLoginIP` varchar(255) DEFAULT NULL COMMENT '上次登录IP',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
