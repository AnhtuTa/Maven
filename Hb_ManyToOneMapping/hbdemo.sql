-- MySQL dump 10.13  Distrib 5.7.20, for Linux (x86_64)
--
-- Host: localhost    Database: hbdemo
-- ------------------------------------------------------
-- Server version	5.7.20-0ubuntu0.16.04.1

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
-- Table structure for table `cmtnd`
--

DROP TABLE IF EXISTS `cmtnd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cmtnd` (
  `student_id` int(11) NOT NULL,
  `cmt_id` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ngay_cap` date DEFAULT NULL,
  `noi_cap` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`student_id`),
  UNIQUE KEY `cmt_id_UNIQUE` (`cmt_id`),
  CONSTRAINT `MaSV_cmt_fk` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cmtnd`
--

LOCK TABLES `cmtnd` WRITE;
/*!40000 ALTER TABLE `cmtnd` DISABLE KEYS */;
INSERT INTO `cmtnd` VALUES (20131001,'12346','2011-11-12','Hanoi'),(20131002,'12347','2011-11-21','HCM'),(20131003,'12349','2011-11-09','Hanoi'),(20131007,'12350','2010-01-29','Hai Phong'),(20131102,'12348','2010-12-23','Da Nang'),(20134509,'12345','2012-12-20','Hanoi');
/*!40000 ALTER TABLE `cmtnd` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `id` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `subject_id` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `time` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'format: dayOfWeek;time. VD: 2;6h45 - 10h5',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES ('10001','IT3010','2;6h45 - 10h5'),('10002','IT3010','3;6h45 - 10h5'),('10003','IT3019','2;12h30 - 15h'),('10004','IT3019','5;12h30 - 15h'),('10005','ET3020','2;12h30 - 15h50'),('10006','ET3020','6;6h45 - 10h5');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `register`
--

DROP TABLE IF EXISTS `register`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `register` (
  `student_id` int(11) NOT NULL,
  `course_id` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`student_id`,`course_id`),
  KEY `fk_register_1_idx` (`course_id`),
  KEY `MaKhoaHoc_register_fk_idx` (`course_id`),
  CONSTRAINT `MaKhoaHoc_register_fk` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `MaSV_register_fk` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `register`
--

LOCK TABLES `register` WRITE;
/*!40000 ALTER TABLE `register` DISABLE KEYS */;
INSERT INTO `register` VALUES (20131001,'10001'),(20131002,'10001'),(20134509,'10001'),(20131003,'10002'),(20134509,'10003'),(20131001,'10004'),(20131003,'10005'),(20131002,'10006'),(20134509,'10006');
/*!40000 ALTER TABLE `register` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `class_id` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `MaLop_idx` (`class_id`),
  CONSTRAINT `MaLop_student_fk` FOREIGN KEY (`class_id`) REFERENCES `svclass` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (20131001,'Nguyen Van Linh','cntt2.01k58'),(20131002,'Trung Anh','dt04k58'),(20131003,'Phuong Anh','dt04k58'),(20131007,'Nguyen Van Trung','cntt2.01k58'),(20131100,'Phanh Lee','dt04k58'),(20131102,'Toan noob','cntt2.01k58'),(20131103,'Huy ga','cntt2.01k58'),(20134509,'Anhtu','dt04k58');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `svclass`
--

DROP TABLE IF EXISTS `svclass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `svclass` (
  `id` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `faculty` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `svclass`
--

LOCK TABLES `svclass` WRITE;
/*!40000 ALTER TABLE `svclass` DISABLE KEYS */;
INSERT INTO `svclass` VALUES ('cntt2.01k58','CNTT2.01 - K58','CNTT'),('cntt2.02k58','CNTT2.02 - K58','CNTT'),('dt01k58','DTTT01 - K58','DTVT'),('dt02k58','DTTT02 - K58','DTVT'),('dt03k58','DTTT03 - K58','DTVT'),('dt04k58','DTTT04 - K58','DTVT'),('dt05k58','DTTT05 - K58','DTVT');
/*!40000 ALTER TABLE `svclass` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-08 23:13:24
