/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.0.96-community-nt : Database - demo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`demo` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `demo`;

/*Table structure for table `t_role` */

DROP TABLE IF EXISTS `t_role`;

CREATE TABLE `t_role` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(50) default NULL,
  `uid` int(11) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `FK6219bqej86dnax4u89iue5e9s` (`uid`)
) ENGINE=MyISAM AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

/*Data for the table `t_role` */

insert  into `t_role`(`id`,`name`,`uid`) values (1,'ROLE_user',1),(2,'ROLE_user_post',2);

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL auto_increment COMMENT '自增id',
  `username` varchar(500) default NULL,
  `realname` varchar(500) default NULL COMMENT '真实姓名',
  `cratedate` date default NULL COMMENT '创建日期',
  `email` varchar(50) default NULL,
  `password` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`username`,`realname`,`cratedate`,`email`,`password`) values (1,'test','测试','2017-07-24',NULL,'202cb962ac59075b964b07152d234b70'),(2,'test2','测试','2017-07-24',NULL,'202cb962ac59075b964b07152d234b70');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
