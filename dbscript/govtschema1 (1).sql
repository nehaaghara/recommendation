-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 21, 2019 at 04:19 PM
-- Server version: 5.6.12-log
-- PHP Version: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `govtschema1`
--
CREATE DATABASE IF NOT EXISTS `govtschema1` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `govtschema1`;

-- --------------------------------------------------------

--
-- Table structure for table `applicationdocument`
--

CREATE TABLE IF NOT EXISTS `applicationdocument` (
  `applicationdocumentId` int(50) NOT NULL AUTO_INCREMENT,
  `ApplicationID` int(50) NOT NULL,
  `SchemaDocID` int(50) NOT NULL,
  `DocFileName` varchar(50) NOT NULL,
  PRIMARY KEY (`applicationdocumentId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `approvalofficer`
--

CREATE TABLE IF NOT EXISTS `approvalofficer` (
  `ApprovalID` int(50) NOT NULL AUTO_INCREMENT,
  `DataCaptureStatusID` int(50) NOT NULL,
  `ApplicationID` int(50) NOT NULL,
  `FinalApprovalStatus` varchar(50) NOT NULL,
  `ApprovedBy` varchar(50) NOT NULL,
  `Description` varchar(100) NOT NULL,
  `Date` varchar(25) NOT NULL,
  PRIMARY KEY (`ApprovalID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `attestedocument`
--

CREATE TABLE IF NOT EXISTS `attestedocument` (
  `attestedocumentId` int(50) NOT NULL AUTO_INCREMENT,
  `ApplicationID` int(50) NOT NULL,
  `AttestedBy` varchar(50) NOT NULL,
  `Status` varchar(50) NOT NULL,
  `Description` varchar(100) NOT NULL,
  `Date` varchar(25) NOT NULL,
  PRIMARY KEY (`attestedocumentId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `categoryId` int(50) NOT NULL AUTO_INCREMENT,
  `category` int(50) NOT NULL,
  PRIMARY KEY (`categoryId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `datacaptureapp`
--

CREATE TABLE IF NOT EXISTS `datacaptureapp` (
  `DatacaptureappId` int(50) NOT NULL AUTO_INCREMENT,
  `ApplicationID` int(50) NOT NULL,
  `DataCaptureBy` varchar(50) NOT NULL,
  `QuestionID` int(50) NOT NULL,
  `Answer` varchar(100) NOT NULL,
  `Date` varchar(25) NOT NULL,
  PRIMARY KEY (`DatacaptureappId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `datacapturestatus`
--

CREATE TABLE IF NOT EXISTS `datacapturestatus` (
  `DatacapturestatusId` int(50) NOT NULL AUTO_INCREMENT,
  `VerificatonID` int(50) NOT NULL,
  `ApplicationID` int(50) NOT NULL,
  `CaptureBy` varchar(50) NOT NULL,
  `Description` varchar(100) NOT NULL,
  `Status` varchar(50) NOT NULL,
  `Date` varchar(25) NOT NULL,
  PRIMARY KEY (`DatacapturestatusId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `gvtschema`
--

CREATE TABLE IF NOT EXISTS `gvtschema` (
  `gvtschemaId` int(50) NOT NULL AUTO_INCREMENT,
  `SchemaName` varchar(50) NOT NULL,
  `Category` varchar(50) NOT NULL,
  `Description` varchar(100) NOT NULL,
  `Gender` varchar(25) NOT NULL,
  `Duration` varchar(50) NOT NULL,
  PRIMARY KEY (`gvtschemaId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `menu`
--

CREATE TABLE IF NOT EXISTS `menu` (
  `MenuID` int(50) NOT NULL AUTO_INCREMENT,
  `ParentID` int(50) NOT NULL,
  `MenuName` varchar(50) NOT NULL,
  `Icon` varchar(50) NOT NULL,
  `Page` varchar(50) NOT NULL,
  `UserTypeID` int(50) NOT NULL,
  `userId` int(50) NOT NULL,
  PRIMARY KEY (`MenuID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `registryofficer`
--

CREATE TABLE IF NOT EXISTS `registryofficer` (
  `registryofficerId` int(50) NOT NULL AUTO_INCREMENT,
  `ApprovalID` int(50) NOT NULL,
  `NotificationMessage` varchar(50) NOT NULL,
  `RegistryBy` varchar(50) NOT NULL,
  `Date` varchar(25) NOT NULL,
  PRIMARY KEY (`registryofficerId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `schemadoc`
--

CREATE TABLE IF NOT EXISTS `schemadoc` (
  `schemadocId` int(50) NOT NULL AUTO_INCREMENT,
  `SchemaID` int(50) NOT NULL,
  `DocName` varchar(50) NOT NULL,
  PRIMARY KEY (`schemadocId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `userId` int(50) NOT NULL AUTO_INCREMENT,
  `UserTypeID` int(50) NOT NULL,
  `FirstName` varchar(50) NOT NULL,
  `LastName` varchar(50) NOT NULL,
  `UserName` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `City` varchar(25) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `Contact` int(25) NOT NULL,
  `DOB` varchar(25) NOT NULL,
  `Gender` varchar(25) NOT NULL,
  `Password` varchar(25) NOT NULL,
  `profilePic` int(50) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `userapplication`
--

CREATE TABLE IF NOT EXISTS `userapplication` (
  `applicationId` int(50) NOT NULL AUTO_INCREMENT,
  `UserID` int(50) NOT NULL,
  `SchemaID` int(50) NOT NULL,
  `ApplicantName` varchar(50) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `AdharNumber` int(50) NOT NULL,
  `ContactNumber` int(25) NOT NULL,
  `EmailID` varchar(50) NOT NULL,
  `AppliedDate` varchar(50) NOT NULL,
  `StatusDate` varchar(50) NOT NULL,
  `ApplicationNo` int(50) NOT NULL,
  `Appcode` int(50) NOT NULL,
  `status` varchar(50) NOT NULL,
  PRIMARY KEY (`applicationId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `userrights`
--

CREATE TABLE IF NOT EXISTS `userrights` (
  `UserrightsId` int(50) NOT NULL AUTO_INCREMENT,
  `UserID` int(50) NOT NULL,
  `MenuID` int(50) NOT NULL,
  PRIMARY KEY (`UserrightsId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `verificationapp`
--

CREATE TABLE IF NOT EXISTS `verificationapp` (
  `VerificationappId` int(50) NOT NULL AUTO_INCREMENT,
  `AttestedAppID` int(50) NOT NULL,
  `ApplicationID` int(50) NOT NULL,
  `VerifiedBy` varchar(50) NOT NULL,
  `VerificationStatus` varchar(50) NOT NULL,
  `Description` varchar(100) NOT NULL,
  `Date` varchar(25) NOT NULL,
  PRIMARY KEY (`VerificationappId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
