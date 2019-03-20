/*
SQLyog Enterprise Trial - MySQL GUI v7.11 
MySQL - 5.6.12-log : Database - recommendation
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`recommendation` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `recommendation`;

/*Table structure for table `tblbranch` */

DROP TABLE IF EXISTS `tblbranch`;

CREATE TABLE `tblbranch` (
  `branchPk` bigint(10) NOT NULL AUTO_INCREMENT,
  `branchname` varchar(50) DEFAULT NULL,
  `isActive` int(10) DEFAULT NULL,
  PRIMARY KEY (`branchPk`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `tblbranch` */

insert  into `tblbranch`(`branchPk`,`branchname`,`isActive`) values (1,'civil123',1);

/*Table structure for table `tbluser` */

DROP TABLE IF EXISTS `tbluser`;

CREATE TABLE `tbluser` (
  `userid` bigint(20) NOT NULL AUTO_INCREMENT,
  `fullName` varchar(50) DEFAULT NULL,
  `userName` varchar(50) DEFAULT NULL,
  `emailAddress` varchar(100) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `conformPassword` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `tbluser` */

insert  into `tbluser`(`userid`,`fullName`,`userName`,`emailAddress`,`password`,`conformPassword`) values (1,'hingu vikas nileshbhai','vikas',NULL,'vikas','vikas'),(2,'hingu vikas nileshbhai','vikashingu','vikas@gmail.com','vikas123','vikas123');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
