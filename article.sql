/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.25-log : Database - article
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`article` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `article`;

/*Table structure for table `article` */

DROP TABLE IF EXISTS `article`;

CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `content` text COMMENT '内容',
  `publish_user` varchar(128) DEFAULT NULL COMMENT '发布人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(128) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `article` */

insert  into `article`(`id`,`title`,`content`,`publish_user`,`create_time`,`create_user`) values (1,'111',NULL,'月月月','2019-04-22 14:38:52','月月月');

/*Table structure for table `provinces` */

DROP TABLE IF EXISTS `provinces`;

CREATE TABLE `provinces` (
  `id` int(11) DEFAULT NULL COMMENT '主键',
  `name` varchar(256) DEFAULT NULL COMMENT '名称',
  `parentId` int(11) DEFAULT NULL COMMENT '父id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(128) DEFAULT NULL COMMENT '创建人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `provinces` */

/*Table structure for table `sys_menu` */

DROP TABLE IF EXISTS `sys_menu`;

CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL COMMENT '菜单名',
  `url` varchar(32) DEFAULT NULL COMMENT '连接地址',
  `level` int(11) DEFAULT NULL COMMENT '如果是直接跳转目录:0 如果目录下面还有目录这里为1,如果再有目录,懒得设计了',
  `parent_id` int(11) DEFAULT NULL COMMENT '如果是第一级，父类ID为0；',
  `status` int(32) DEFAULT NULL COMMENT '0：不可用；1：可用',
  `icon` datetime DEFAULT NULL COMMENT '界面映射图标',
  `sorter` int(11) DEFAULT NULL COMMENT '排序',
  `create_user` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '第一次创建时间',
  `modify_user` varchar(32) DEFAULT NULL COMMENT '修改人',
  `modify_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='菜单';

/*Data for the table `sys_menu` */

insert  into `sys_menu`(`id`,`name`,`url`,`level`,`parent_id`,`status`,`icon`,`sorter`,`create_user`,`create_time`,`modify_user`,`modify_time`) values (1,'测试首页','/index',0,0,1,NULL,1,'月月月','2019-04-16 18:19:20',NULL,NULL),(2,'系统管理',NULL,1,0,1,NULL,3,'月yueyue','2019-04-19 14:58:27',NULL,NULL),(3,'角色管理','/role',NULL,2,1,NULL,1,'月月月','2019-04-19 14:59:12',NULL,NULL),(4,'菜单管理','/menu',NULL,2,1,NULL,2,'月月月','2019-04-20 11:54:18',NULL,NULL),(5,'用户管理','/user',NULL,2,1,NULL,3,'月月月','2019-04-20 11:54:19',NULL,NULL),(6,'文章管理','/article',0,0,1,NULL,2,'月月月','2019-04-22 11:52:52',NULL,NULL);

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(32) DEFAULT NULL COMMENT '角色代码',
  `name` varchar(32) DEFAULT NULL COMMENT '角色名称',
  `status` int(11) DEFAULT NULL COMMENT '1:有效，0:禁止登录',
  `parent_id` int(1) DEFAULT NULL COMMENT '父角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='角色表';

/*Data for the table `sys_role` */

insert  into `sys_role`(`id`,`code`,`name`,`status`,`parent_id`) values (1,'SYS_ROLE','admin',1,NULL);

/*Table structure for table `sys_role_menu` */

DROP TABLE IF EXISTS `sys_role_menu`;

CREATE TABLE `sys_role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL COMMENT '角色ID',
  `menu_id` int(11) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='rolemenu中间表';

/*Data for the table `sys_role_menu` */

insert  into `sys_role_menu`(`id`,`role_id`,`menu_id`) values (1,1,1),(2,1,2),(3,1,3),(4,1,6);

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) DEFAULT NULL COMMENT '登录帐号',
  `nickname` varchar(32) DEFAULT NULL COMMENT '用户昵称',
  `password` varchar(256) DEFAULT NULL COMMENT '密码',
  `email` varchar(128) DEFAULT NULL COMMENT '邮箱',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `status` int(1) DEFAULT NULL COMMENT '1:有效，0:禁止',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`username`,`nickname`,`password`,`email`,`create_time`,`modify_time`,`status`) values (1,'admin','你猜','$2a$10$oQcvfteOSy5bNFZErI5r6eIRc3b8Q7RpTpnr47t8MTNcCcIt8iSfe',NULL,'2019-04-16 18:16:22','2019-04-16 18:16:23',1);

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='userrole中间表';

/*Data for the table `sys_user_role` */

insert  into `sys_user_role`(`id`,`role_id`,`user_id`) values (1,1,1);

/*Table structure for table `test_student` */

DROP TABLE IF EXISTS `test_student`;

CREATE TABLE `test_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(11) DEFAULT NULL COMMENT '测试表名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='测试学生表';

/*Data for the table `test_student` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
