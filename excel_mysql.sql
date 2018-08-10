/*
SQLyog Ultimate v11.22 (64 bit)
MySQL - 5.0.67-community-nt : Database - excel_mysql
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`excel_mysql` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `excel_mysql`;

/*Table structure for table `tb_student` */

DROP TABLE IF EXISTS `tb_student`;

CREATE TABLE `tb_student` (
  `id` bigint(50) NOT NULL auto_increment,
  `name` varchar(100) NOT NULL,
  `sex` varchar(10) NOT NULL,
  `age` int(50) NOT NULL,
  `register_date` varchar(100) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `tb_student` */

insert  into `tb_student`(`id`,`name`,`sex`,`age`,`register_date`) values (1,'tom','男',21,'2018-08-10 15:09:08'),(2,'serry','女',20,'2018-08-10 14:10:11'),(5,'钢铁侠','男',21,'2018-08-10 16:11:44'),(6,'黑寡妇','女',20,'2018-08-10 16:11:44'),(7,'钢铁侠','男',21,'2018-08-10 星期五 16:16:16'),(8,'黑寡妇','女',20,'2018-08-10 星期五 16:16:16'),(9,'雷神','男',22,'2018-08-10 星期五 16:21:08'),(10,'雷神','男',22,'2018-08-10 星期五 16:24:03'),(11,'雷神','男',22,'2018-08-10 星期五 16:25:15'),(12,'异人','男',20,'2018-08-10 星期五 16:25:15'),(13,'緑巨人','男',22,'2018-08-10 星期五 16:48:45'),(14,'蜘蛛侠','男',20,'2018-08-10 星期五 16:48:45'),(15,'北极星小姐姐','女',20,'2018-08-10 星期五 16:48:45');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
