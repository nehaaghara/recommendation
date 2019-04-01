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

/*Table structure for table `tbl_branch` */

DROP TABLE IF EXISTS `tbl_branch`;

CREATE TABLE `tbl_branch` (
  `branchPK` bigint(20) NOT NULL AUTO_INCREMENT,
  `branchName` varchar(30) DEFAULT NULL,
  `isActive` int(20) DEFAULT NULL,
  PRIMARY KEY (`branchPK`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_branch` */

insert  into `tbl_branch`(`branchPK`,`branchName`,`isActive`) values 
(1,'Computer Science',1),
(2,'IT',1),
(3,'Civil',1),
(4,'Mechanical',1),
(16,'mca',1);

/*Table structure for table `tbl_branchmapping` */

DROP TABLE IF EXISTS `tbl_branchmapping`;

CREATE TABLE `tbl_branchmapping` (
  `branchMappingPk` bigint(20) NOT NULL AUTO_INCREMENT,
  `branchFk` bigint(30) DEFAULT NULL,
  `instituteFk` bigint(30) DEFAULT NULL,
  `createdBy` bigint(30) DEFAULT NULL,
  `createdOn` date DEFAULT NULL,
  PRIMARY KEY (`branchMappingPk`)
) ENGINE=MyISAM AUTO_INCREMENT=42 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_branchmapping` */

insert  into `tbl_branchmapping`(`branchMappingPk`,`branchFk`,`instituteFk`,`createdBy`,`createdOn`) values 
(41,1,26,1,'2019-03-19');

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
  `createdBy` bigint(20) DEFAULT NULL,
  `createdOn` date DEFAULT NULL,
  PRIMARY KEY (`institutePk`)
) ENGINE=MyISAM AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_institute` */

insert  into `tbl_institute`(`institutePk`,`instituteName`,`contactNo`,`contactPerson`,`emailId`,`address`,`zipCode`,`website`,`description`,`createdBy`,`createdOn`) values 
(26,'c u shahhaa','322563','dAKSH','neha@gmail.com','DQWEQWE','233445','www.google.com','EWRR',1,'2019-03-19'),
(27,'c u shah','32343465','dAKSH','neha@gmail.com','WEWQEQ','233445','www.google.com','QWEWWQE',1,'2019-03-19');

/*Table structure for table `tbl_institutebranch` */

DROP TABLE IF EXISTS `tbl_institutebranch`;

CREATE TABLE `tbl_institutebranch` (
  `institutebranchPK` bigint(20) NOT NULL AUTO_INCREMENT,
  `instituteFk` bigint(20) DEFAULT NULL,
  `branchFk` bigint(20) DEFAULT NULL,
  `createdBy` bigint(20) DEFAULT NULL,
  `createdOn` date DEFAULT NULL,
  PRIMARY KEY (`institutebranchPK`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_institutebranch` */

insert  into `tbl_institutebranch`(`institutebranchPK`,`instituteFk`,`branchFk`,`createdBy`,`createdOn`) values 
(1,26,1,NULL,NULL),
(2,26,2,NULL,NULL),
(3,26,3,NULL,NULL);

/*Table structure for table `tbl_result` */

DROP TABLE IF EXISTS `tbl_result`;

CREATE TABLE `tbl_result` (
  `resultPk` bigint(20) NOT NULL AUTO_INCREMENT,
  `instituteBranchFk` bigint(20) DEFAULT NULL,
  `year` varchar(20) DEFAULT NULL,
  `cutOffMarks` int(11) DEFAULT NULL,
  PRIMARY KEY (`resultPk`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_result` */

insert  into `tbl_result`(`resultPk`,`instituteBranchFk`,`year`,`cutOffMarks`) values 
(2,3,'2019',250),
(4,2,'2019',256),
(5,1,'2019',655);

/*Table structure for table `tbl_role` */

DROP TABLE IF EXISTS `tbl_role`;

CREATE TABLE `tbl_role` (
  `rolePk` bigint(30) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(30) DEFAULT NULL,
  `isActive` int(20) DEFAULT NULL,
  PRIMARY KEY (`rolePk`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_role` */

insert  into `tbl_role`(`rolePk`,`roleName`,`isActive`) values 
(1,'Admin',1),
(2,'User',1);

/*Table structure for table `tbl_userdetails` */

DROP TABLE IF EXISTS `tbl_userdetails`;

CREATE TABLE `tbl_userdetails` (
  `studentId` bigint(20) NOT NULL AUTO_INCREMENT,
  `studentName` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone` bigint(20) DEFAULT NULL,
  `field` varchar(100) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  PRIMARY KEY (`studentId`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_userdetails` */

insert  into `tbl_userdetails`(`studentId`,`studentName`,`email`,`phone`,`field`,`score`) values 
(1,'hardik','hardik@gmail.com',8140321630,'Civil',565),
(3,'vikas','hinguvikas@2214.com',951753456,'Civil',898),
(6,'path','admin123@gmail.com',1213546789,'Civil',898),
(7,'parth','admin@gmail.com',8140321630,'Mechanical',898),
(8,'parth','admin@gmail.com',8140321630,'Mechanical',898),
(9,'parth','admin@gmail.com',8140321630,'Mechanical',898),
(10,'parth','admin@gmail.com',8140321630,'Mechanical',898),
(11,'yogesh','neha@gmail.com',8140321630,'Civil',200),
(12,'yogesh','neha@gmail.com',8140321630,'Civil',200),
(13,'yogesh','neha@gmail.com',8140321630,'Civil',200),
(14,'yogesh','neha@gmail.com',8140321630,'Civil',200),
(15,'yogesh','neha@gmail.com',8140321630,'Civil',200),
(16,'yogesh','neha@gmail.com',8140321630,'Civil',200),
(17,'yogesh1','hardik@gmail.com',1213546789,'Mechanical',1000),
(18,'yogesh1','hardik@gmail.com',1213546789,'Mechanical',1000),
(19,'yogesh1','hardik@gmail.com',1213546789,'Mechanical',1000),
(20,'hemal','hemal@gmail.com',1213546789,'IT',2000),
(21,'Yashvi Aghara','yashvi@gmail.com',346556,'Civil',300),
(22,'Yashvi Aghara','yashvi@gmail.com',346556,'Civil',300);

/*Table structure for table `tbluser` */

DROP TABLE IF EXISTS `tbluser`;

CREATE TABLE `tbluser` (
  `userid` bigint(20) NOT NULL AUTO_INCREMENT,
  `fullName` varchar(50) DEFAULT NULL,
  `userName` varchar(50) DEFAULT NULL,
  `emailAddress` varchar(100) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `conformPassword` varchar(20) DEFAULT NULL,
  `roleFk` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

/*Data for the table `tbluser` */

insert  into `tbluser`(`userid`,`fullName`,`userName`,`emailAddress`,`password`,`conformPassword`,`roleFk`) values 
(1,'Admin','admin','admin123@gmail.com','123','123',1),
(2,'hingu vikas nileshbhai','vikashingu','vikas@gmail.com','vikas123','vikas123',2),
(12,'Neha','neha','neha@gmail.com','123','123',2),
(14,'Yashvi ','yashvi','yashvi@gmail.com','123','123',2),
(15,'hingu vikas nileshbhai','vikas','vikas@gmail.com','vikas','vikas',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
