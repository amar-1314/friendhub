CREATE DATABASE  IF NOT EXISTS `friendhub` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `friendhub`;
-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: friendhub
-- ------------------------------------------------------
-- Server version	5.6.23-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `albums`
--

DROP TABLE IF EXISTS `albums`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `albums` (
  `Album_ID` int(11) NOT NULL AUTO_INCREMENT,
  `User_ID` int(11) NOT NULL,
  PRIMARY KEY (`Album_ID`),
  KEY `User_ID` (`User_ID`),
  CONSTRAINT `User_ID` FOREIGN KEY (`User_ID`) REFERENCES `user` (`UserID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `albums`
--

LOCK TABLES `albums` WRITE;
/*!40000 ALTER TABLE `albums` DISABLE KEYS */;
/*!40000 ALTER TABLE `albums` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attachments`
--

DROP TABLE IF EXISTS `attachments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attachments` (
  `Attachment_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Message_ID` int(11) NOT NULL,
  `File` longblob,
  `File_Name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Attachment_ID`),
  UNIQUE KEY `Attachment_ID_UNIQUE` (`Attachment_ID`),
  KEY `Message_ID` (`Message_ID`),
  CONSTRAINT `Message_ID` FOREIGN KEY (`Message_ID`) REFERENCES `message` (`Message_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attachments`
--

LOCK TABLES `attachments` WRITE;
/*!40000 ALTER TABLE `attachments` DISABLE KEYS */;
/*!40000 ALTER TABLE `attachments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blocked_users`
--

DROP TABLE IF EXISTS `blocked_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `blocked_users` (
  `User_ID` int(11) NOT NULL,
  `Blocked_User_ID` int(11) NOT NULL,
  PRIMARY KEY (`User_ID`,`Blocked_User_ID`),
  KEY `User_ID_Blocked_Users` (`Blocked_User_ID`),
  CONSTRAINT `User_ID_Blocked_Users` FOREIGN KEY (`Blocked_User_ID`) REFERENCES `user` (`UserID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blocked_users`
--

LOCK TABLES `blocked_users` WRITE;
/*!40000 ALTER TABLE `blocked_users` DISABLE KEYS */;
INSERT INTO `blocked_users` VALUES (1,3);
/*!40000 ALTER TABLE `blocked_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `Category_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Category_Name` varchar(45) NOT NULL,
  PRIMARY KEY (`Category_ID`),
  UNIQUE KEY `Category_ID_UNIQUE` (`Category_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Education'),(2,'Family'),(3,'Work'),(4,'Friends');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comments` (
  `Comment_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Status_ID` int(11) NOT NULL,
  `Commentor_User_ID` int(11) NOT NULL,
  `Comment` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`Comment_ID`),
  KEY `Status_ID_Comments` (`Status_ID`),
  CONSTRAINT `Status_ID_Comments` FOREIGN KEY (`Status_ID`) REFERENCES `statusupdate` (`Status_Update_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `education_profile`
--

DROP TABLE IF EXISTS `education_profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `education_profile` (
  `Education_Profile_id` int(11) NOT NULL AUTO_INCREMENT,
  `User_ID` int(11) NOT NULL,
  `College_Name` varchar(100) DEFAULT NULL,
  `From_Date` date DEFAULT NULL,
  `To_Date` datetime DEFAULT NULL,
  `Degree_Obtained` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Education_Profile_id`),
  UNIQUE KEY `Education_Profile_id_UNIQUE` (`Education_Profile_id`),
  KEY `User_ID_Edu_Profile` (`User_ID`),
  CONSTRAINT `User_ID_Edu_Profile` FOREIGN KEY (`User_ID`) REFERENCES `user` (`UserID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `education_profile`
--

LOCK TABLES `education_profile` WRITE;
/*!40000 ALTER TABLE `education_profile` DISABLE KEYS */;
INSERT INTO `education_profile` VALUES (1,1,'New Horizon College of Engineering','2005-05-23','2009-04-20 00:00:00','B.E');
/*!40000 ALTER TABLE `education_profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `friend_list`
--

DROP TABLE IF EXISTS `friend_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `friend_list` (
  `User_ID` int(11) NOT NULL,
  `Friend_User_ID` int(11) NOT NULL,
  `Request_Status` char(1) DEFAULT NULL,
  `Category_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`User_ID`,`Friend_User_ID`),
  KEY `Category_ID_Friend_List` (`Category_ID`),
  CONSTRAINT `Category_ID_Friend_List` FOREIGN KEY (`Category_ID`) REFERENCES `category` (`Category_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `User_ID_Friend_List` FOREIGN KEY (`User_ID`) REFERENCES `user` (`UserID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friend_list`
--

LOCK TABLES `friend_list` WRITE;
/*!40000 ALTER TABLE `friend_list` DISABLE KEYS */;
INSERT INTO `friend_list` VALUES (1,2,'Y',1);
/*!40000 ALTER TABLE `friend_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group`
--

DROP TABLE IF EXISTS `group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `group` (
  `Group_ID` int(11) NOT NULL AUTO_INCREMENT,
  `User_ID` int(11) NOT NULL,
  `TimeStamp` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Group_ID`),
  UNIQUE KEY `Group_ID_UNIQUE` (`Group_ID`),
  KEY `User_ID_Groups` (`User_ID`),
  CONSTRAINT `User_ID_Groups` FOREIGN KEY (`User_ID`) REFERENCES `user` (`UserID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group`
--

LOCK TABLES `group` WRITE;
/*!40000 ALTER TABLE `group` DISABLE KEYS */;
/*!40000 ALTER TABLE `group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_message`
--

DROP TABLE IF EXISTS `group_message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `group_message` (
  `Group_ID` int(11) NOT NULL,
  `Message` varchar(45) DEFAULT NULL,
  `Sender_ID` int(11) DEFAULT NULL,
  `Time_Stamp` varchar(45) NOT NULL,
  `Group__Message_ID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Group__Message_ID`),
  UNIQUE KEY `Group__Message_ID_UNIQUE` (`Group__Message_ID`),
  KEY `Group_ID` (`Group_ID`),
  CONSTRAINT `Group_ID` FOREIGN KEY (`Group_ID`) REFERENCES `group` (`Group_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_message`
--

LOCK TABLES `group_message` WRITE;
/*!40000 ALTER TABLE `group_message` DISABLE KEYS */;
/*!40000 ALTER TABLE `group_message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hidden_status`
--

DROP TABLE IF EXISTS `hidden_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hidden_status` (
  `User_ID` int(11) NOT NULL,
  `Hidden_User_ID` int(11) NOT NULL,
  PRIMARY KEY (`User_ID`),
  KEY `User_ID_Hidden_Status` (`Hidden_User_ID`),
  CONSTRAINT `User_ID_Hidden_Status` FOREIGN KEY (`Hidden_User_ID`) REFERENCES `user` (`UserID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hidden_status`
--

LOCK TABLES `hidden_status` WRITE;
/*!40000 ALTER TABLE `hidden_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `hidden_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message` (
  `Message_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Message` varchar(200) DEFAULT NULL,
  `Sender_ID` int(11) NOT NULL,
  `Receiver_ID` int(11) NOT NULL,
  `Time_Stamp` datetime DEFAULT NULL,
  PRIMARY KEY (`Message_ID`),
  UNIQUE KEY `Messgae_ID_UNIQUE` (`Message_ID`),
  KEY `Receiver_ID_Message` (`Receiver_ID`),
  CONSTRAINT `Receiver_ID_Message` FOREIGN KEY (`Receiver_ID`) REFERENCES `user` (`UserID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notification_type`
--

DROP TABLE IF EXISTS `notification_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notification_type` (
  `Notification_Type_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Notification_Name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Notification_Type_ID`),
  UNIQUE KEY `Notification_Type_ID_UNIQUE` (`Notification_Type_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notification_type`
--

LOCK TABLES `notification_type` WRITE;
/*!40000 ALTER TABLE `notification_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `notification_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notifications`
--

DROP TABLE IF EXISTS `notifications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notifications` (
  `Notificaton_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Notification_Type_ID` int(11) DEFAULT NULL,
  `Sender_ID` int(11) DEFAULT NULL,
  `Receiver_ID` int(11) DEFAULT NULL,
  `Read/Unread_Flag` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`Notificaton_ID`),
  UNIQUE KEY `Notificaton_ID_UNIQUE` (`Notificaton_ID`),
  KEY `Notification_Type_ID` (`Notification_Type_ID`),
  KEY `Receiver_ID` (`Receiver_ID`),
  CONSTRAINT `Notification_Type_ID` FOREIGN KEY (`Notification_Type_ID`) REFERENCES `notification_type` (`Notification_Type_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Receiver_ID` FOREIGN KEY (`Receiver_ID`) REFERENCES `user` (`UserID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notifications`
--

LOCK TABLES `notifications` WRITE;
/*!40000 ALTER TABLE `notifications` DISABLE KEYS */;
/*!40000 ALTER TABLE `notifications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `picture_comments`
--

DROP TABLE IF EXISTS `picture_comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `picture_comments` (
  `Comment_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Picture_ID` int(11) NOT NULL,
  `Commentor_User_ID` int(11) NOT NULL,
  `Comment` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`Comment_ID`),
  UNIQUE KEY `Comment_ID_UNIQUE` (`Comment_ID`),
  KEY `Picture_ID` (`Picture_ID`),
  KEY `Commentor_User_ID` (`Commentor_User_ID`),
  CONSTRAINT `Commentor_User_ID` FOREIGN KEY (`Commentor_User_ID`) REFERENCES `user` (`UserID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Picture_ID` FOREIGN KEY (`Picture_ID`) REFERENCES `pictures` (`Picture_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `picture_comments`
--

LOCK TABLES `picture_comments` WRITE;
/*!40000 ALTER TABLE `picture_comments` DISABLE KEYS */;
/*!40000 ALTER TABLE `picture_comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pictures`
--

DROP TABLE IF EXISTS `pictures`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pictures` (
  `Picture_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Album_ID` int(11) NOT NULL,
  `Picture` mediumblob,
  `Like_Count` int(11) DEFAULT NULL,
  `Dislike_Count` int(11) DEFAULT NULL,
  `Comment_Count` int(11) DEFAULT NULL,
  PRIMARY KEY (`Picture_ID`),
  UNIQUE KEY `Picture_ID_UNIQUE` (`Picture_ID`),
  KEY `Album_ID` (`Album_ID`),
  CONSTRAINT `Album_ID` FOREIGN KEY (`Album_ID`) REFERENCES `albums` (`Album_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pictures`
--

LOCK TABLES `pictures` WRITE;
/*!40000 ALTER TABLE `pictures` DISABLE KEYS */;
/*!40000 ALTER TABLE `pictures` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `privacy_settings`
--

DROP TABLE IF EXISTS `privacy_settings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `privacy_settings` (
  `Privacy_Settings_ID` int(11) NOT NULL AUTO_INCREMENT,
  `User_ID` int(11) NOT NULL,
  `Searchable_Flag` tinyint(1) DEFAULT NULL,
  `Profile_Data_Flag` char(1) DEFAULT NULL,
  `Messagable_Flag` char(1) DEFAULT NULL,
  `Status_Flag` char(1) DEFAULT NULL,
  PRIMARY KEY (`Privacy_Settings_ID`),
  UNIQUE KEY `Privacy_Settings_ID_UNIQUE` (`Privacy_Settings_ID`),
  KEY `User_ID_Privacy_Settings` (`User_ID`),
  CONSTRAINT `User_ID_Privacy_Settings` FOREIGN KEY (`User_ID`) REFERENCES `user` (`UserID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `privacy_settings`
--

LOCK TABLES `privacy_settings` WRITE;
/*!40000 ALTER TABLE `privacy_settings` DISABLE KEYS */;
INSERT INTO `privacy_settings` VALUES (1,1,1,'Y','Y','Y');
/*!40000 ALTER TABLE `privacy_settings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `statusupdate`
--

DROP TABLE IF EXISTS `statusupdate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `statusupdate` (
  `User_ID` int(11) NOT NULL,
  `Status_Update_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Status_Update` varchar(200) NOT NULL,
  `Time_Stamp` datetime NOT NULL,
  `Like_Count` int(11) DEFAULT NULL,
  `Dislike_Count` int(11) DEFAULT NULL,
  `Comment_Count` int(11) DEFAULT NULL,
  PRIMARY KEY (`Status_Update_ID`),
  UNIQUE KEY `StatusUpdatecol1_UNIQUE` (`Time_Stamp`),
  KEY `User_ID_Status_Update` (`User_ID`),
  CONSTRAINT `User_ID_Status_Update` FOREIGN KEY (`User_ID`) REFERENCES `user` (`UserID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `statusupdate`
--

LOCK TABLES `statusupdate` WRITE;
/*!40000 ALTER TABLE `statusupdate` DISABLE KEYS */;
/*!40000 ALTER TABLE `statusupdate` ENABLE KEYS */;
UNLOCK TABLES;


CREATE TABLE `messages` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `author_id` int(11) NOT NULL,
  `message` text NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `messages_User_ID` (`author_id`),
  CONSTRAINT `messages_User_ID` FOREIGN KEY (`author_id`) REFERENCES `user` (`UserID`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;


CREATE TABLE `statusupdatelikedislikecount` (
  `status_update_id` int(11) DEFAULT NULL,
  `UserID` int(11) DEFAULT NULL,
  `LikeOrDisLikeFlag` int(11) DEFAULT NULL,
  PRIMARY KEY  (`status_update_id`,`UserID`),
  CONSTRAINT `UserID_LikesDislikes` FOREIGN KEY (`UserID`) REFERENCES `user` (`UserID`),
  CONSTRAINT `status_update_id_ForLikesDislikes` FOREIGN KEY (`status_update_id`) REFERENCES `statusupdate` (`Status_Update_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `friend_list`;

-- Table structure for table `friend_list`
--

CREATE TABLE `friend_list` (
  `unique_ID` int(11) NOT NULL AUTO_INCREMENT,
  `User_ID` int(11) DEFAULT NULL,
  `FRIEND_USER_ID` varchar(45) DEFAULT NULL,
  `REQUEST_STATUS` varchar(3) DEFAULT NULL,
  `CATEGORY_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`unique_ID`),
  KEY `FRIEND_USER_ID_table` (`User_ID`),
  CONSTRAINT `FRIEND_USER_ID_table` FOREIGN KEY (`User_ID`) REFERENCES `user` (`UserID`),
  CONSTRAINT `User_ID_for_friend` FOREIGN KEY (`User_ID`) REFERENCES `user` (`UserID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;


-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `UserID` int(11) NOT NULL AUTO_INCREMENT,
  `EmailID` varchar(45) NOT NULL,
  `Password` varchar(256) NOT NULL,
  `First_Name` varchar(45) NOT NULL,
  `Middle_Name` varchar(45) DEFAULT NULL,
  `Last_Name` varchar(45) NOT NULL,
  `Phone_Number` int(11) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `Address_Line_1` varchar(45) DEFAULT NULL,
  `Address_Line_2` varchar(45) DEFAULT NULL,
  `City` varchar(45) NOT NULL,
  `State` varchar(45) NOT NULL,
  `Zip` varchar(45) NOT NULL,
  `Country` varchar(45) NOT NULL,
  `Gender` varchar(1) NOT NULL,
  `Profile_Picture` mediumblob,
  `2F_Auth_flag` tinyint(1) DEFAULT NULL,
  `Security_Question` varchar(100) NOT NULL,
  `Security_Answer` varchar(45) NOT NULL,
  `Active_Flag` tinyint(1) NOT NULL,
  PRIMARY KEY (`UserID`),
  UNIQUE KEY `UserID_UNIQUE` (`UserID`),
  UNIQUE KEY `EmailID_UNIQUE` (`EmailID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'acharyap@indiana.edu','12345','Pranam',NULL,'Acharya',1234567899,'1982-12-21','2669 E','7th Street','Bloomington','IN','47408','USA','M',NULL,0,'What is your pet\'s name?','Cat',1),(2,'pnagaraj@indiana.edu','12345','Prashanth',NULL,'Nagaraja',1234567899,'1982-12-21','2669 E','7th Street','Bloomington','IN','47408','USA','M','?',0,'What is your pet\'s name?','Dog',1),(3,'vsangara@indiana.edu','12345','Vineeta','','Verma',1234567899,'1992-02-20','2678 B','7th Street','Bloomington','IN','47408','USA','F','0',0,'What is your pet\'s name?','Cat',1);





/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_profile`
--

DROP TABLE IF EXISTS `work_profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `work_profile` (
  `Work_ProfileID` int(11) NOT NULL AUTO_INCREMENT,
  `User_ID` int(11) NOT NULL,
  `Company_Name` varchar(45) DEFAULT NULL,
  `FromDate` date DEFAULT NULL,
  `ToDate` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Work_ProfileID`),
  UNIQUE KEY `idWork_Profile_UNIQUE` (`Work_ProfileID`),
  KEY `User_ID` (`User_ID`),
  CONSTRAINT `work_profile_ibfk_1` FOREIGN KEY (`User_ID`) REFERENCES `user` (`UserID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_profile`
--

LOCK TABLES `work_profile` WRITE;
/*!40000 ALTER TABLE `work_profile` DISABLE KEYS */;
INSERT INTO `work_profile` VALUES (1,1,'TCS','2009-08-09','2013-08-09'),(2,1,'Omegle','2013-08-09','2014-08-09');
/*!40000 ALTER TABLE `work_profile` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;



-- Dump completed on 2015-04-14  0:19:59
