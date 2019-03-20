/*
SQLyog Community v13.0.1 (64 bit)
MySQL - 5.7.19 : Database - recommendation
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`recommendation` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `recommendation`;

/*Table structure for table `tbl_institute` */

DROP TABLE IF EXISTS `tbl_institute`;

CREATE TABLE `tbl_institute` (
  `institutePk` bigint(20) NOT NULL AUTO_INCREMENT,
  `instituteName` varchar(50) DEFAULT NULL,
  `contactNo` varchar(20) DEFAULT NULL,
  `contactPerson` varchar(20) DEFAULT NULL,
  `emailId` varchar(20) DEFAULT NULL,
  `address` varchar(150) DEFAULT NULL,
  `zipCode` varchar(30) DEFAULT NULL,
  `website` varchar(20) DEFAULT NULL,
  `description` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`institutePk`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_institute` */

insert  into `tbl_institute`(`institutePk`,`instituteName`,`contactNo`,`contactPerson`,`emailId`,`address`,`zipCode`,`website`,`description`) values 
(2,'Nirma University','1234567898','Neha','neha123@gmail.com','qeswew','323445','www.google.com','rfwerw');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
