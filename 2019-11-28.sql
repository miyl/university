-- MariaDB dump 10.17  Distrib 10.4.10-MariaDB, for Linux (x86_64)
--
-- Host: dbserver01.cwfsz5blza8v.eu-central-1.rds.amazonaws.com    Database: university
-- ------------------------------------------------------
-- Server version	5.7.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE IF NOT EXISTS `university`;
USE `university`;

--
-- Table structure for table `approved_students_teachers`
--

DROP TABLE IF EXISTS `approved_students_teachers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `approved_students_teachers` (
  `course_id` int(11) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`course_id`,`user_id`),
  KEY `FKlcunol32gnojagcr6djgpy1dg` (`user_id`),
  CONSTRAINT `FKl9s4cdqcpbbjnd8juo4mwk6ao` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`),
  CONSTRAINT `FKlcunol32gnojagcr6djgpy1dg` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `approved_students_teachers`
--

LOCK TABLES `approved_students_teachers` WRITE;
/*!40000 ALTER TABLE `approved_students_teachers` DISABLE KEYS */;
INSERT INTO `approved_students_teachers` VALUES (24,1),(29,1),(34,1),(36,1),(36,2),(53,2),(55,2),(57,2),(58,2),(60,2),(24,3),(57,3),(59,3),(33,5);
/*!40000 ALTER TABLE `approved_students_teachers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_code` varchar(255) NOT NULL,
  `content` varchar(255) NOT NULL,
  `course_language` varchar(255) NOT NULL,
  `ects` int(11) NOT NULL,
  `exam_form` varchar(255) NOT NULL,
  `expected_students` int(11) NOT NULL,
  `learning_outcome` varchar(255) NOT NULL,
  `mandatory_or_elective` varchar(255) NOT NULL,
  `max_students` int(11) NOT NULL,
  `min_students` int(11) NOT NULL,
  `name_da` varchar(255) NOT NULL,
  `name_en` varchar(255) NOT NULL,
  `prerequisites` varchar(255) NOT NULL,
  `semester` int(11) NOT NULL,
  `study_programme` varchar(255) NOT NULL,
  `learning_activities` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (24,'WD-2020-F-NODEJS','NodeJS, Flexbox, Grid, CSS, MongoDB, AJAX, Websockets, JSONobjects, Setting up a server in Amazon Web Servers and locally.Use of the terminal and FTP. Also, the setup and use of HTTPS.','English',30,'Internal oral exam based on hand in product. Graded based onthe 7-scale.',35,'Students will be able to code a full stack web based application,set-up a NODEJS server in the cloud and decide the best possibleuse of MongoDB','Elective',50,15,'Full Stack NodeJs','Full Stack NodeJs','Students must know HTML, CSS, JS, PHP and MySQL.Students must know HTML, CSS, JS, PHP and MySQL.',2,'Hardcore Web Development','Individual work and exam. Communication takes place via ourRyver channel WD-2020-F-NODEJS'),(25,'WD-2020-F-NODEJS','NodeJS, Flexbox, Grid, CSS, MongoDB, AJAX, Websockets, JSON\r\nobjects, Setting up a server in Amazon Web Servers and locally.\r\nUse of the terminal and FTP. Also, the setup and use of HTTPS.','English',10,'Internal oral exam based on hand in product. Graded based on\r\nthe 7-scale.',35,'Students will be able to code a full stack web based application,\r\nset-up a NODEJS server in the cloud and decide the best possible\r\nuse of MongoDB','Elective',50,15,'Full Stack NodeJs','Full Stack NodeJs','Students must know HTML, CSS, JS, PHP and MySQL.Students must know HTML, CSS, JS, PHP and MySQL.',2,'Web Development','Individual work and exam. Communication takes place via our\r\nRyver channel WD-2020-F-NODEJS'),(26,'WD-2020-F-NODEJS','NodeJS, Flexbox, Grid, CSS, MongoDB, AJAX, Websockets, JSON\r\nobjects, Setting up a server in Amazon Web Servers and locally.\r\nUse of the terminal and FTP. Also, the setup and use of HTTPS.','English',10,'Internal oral exam based on hand in product. Graded based on\r\nthe 7-scale.',35,'Students will be able to code a full stack web based application,\r\nset-up a NODEJS server in the cloud and decide the best possible\r\nuse of MongoDB','Elective',50,15,'Full Stack NodeJs','Full Stack NodeJs','Students must know HTML, CSS, JS, PHP and MySQL.Students must know HTML, CSS, JS, PHP and MySQL.',2,'Web Development','Individual work and exam. Communication takes place via our\r\nRyver channel WD-2020-F-NODEJS'),(28,'WD-2020-F-NODEJS','NodeJS, Flexbox, Grid, CSS, MongoDB, AJAX, Websockets, JSONobjects, Setting up a server in Amazon Web Servers and locally.Use of the terminal and FTP. Also, the setup and use of HTTPS.','English',10,'Internal oral exam based on hand in product. Graded based onthe 7-scale.',35,'Students will be able to code a full stack web based application,set-up a NODEJS server in the cloud and decide the best possibleuse of MongoDB','Elective',50,15,'Full Stack NodeJs','Full Stack NodeJs','Students must know HTML, CSS, JS, PHP and MySQL.Students must know HTML, CSS, JS, PHP and MySQL.',2,'Web Development','Individual work and exam. Communication takes place via ourRyver channel WD-2020-F-NODEJS'),(29,'WD-2020-F-NODEJS','NodeJS, Flexbox, Grid, CSS, MongoDB, AJAX, Websockets, JSON\r\nobjects, Setting up a server in Amazon Web Servers and locally.\r\nUse of the terminal and FTP. Also, the setup and use of HTTPS.','English',10,'Internal oral exam based on hand in product. Graded based on\r\nthe 7-scale.',35,'Students will be able to code a full stack web based application,\r\nset-up a NODEJS server in the cloud and decide the best possible\r\nuse of MongoDB','Elective',50,15,'Full Stack NodeJs','Full Stack NodeJs','Students must know HTML, CSS, JS, PHP and MySQL.Students must know HTML, CSS, JS, PHP and MySQL.',2,'Web Development','Individual work and exam. Communication takes place via our\r\nRyver channel WD-2020-F-NODEJS'),(30,'WD-2020-F-NODEJS','NodeJS, Flexbox, Grid, CSS, MongoDB, AJAX, Websockets, JSON\r\nobjects, Setting up a server in Amazon Web Servers and locally.\r\nUse of the terminal and FTP. Also, the setup and use of HTTPS.','English',10,'Internal oral exam based on hand in product. Graded based on\r\nthe 7-scale.',35,'Students will be able to code a full stack web based application,\r\nset-up a NODEJS server in the cloud and decide the best possible\r\nuse of MongoDB','Elective',50,15,'Full Stack NodeJs','Full Stack NodeJs','Students must know HTML, CSS, JS, PHP and MySQL.Students must know HTML, CSS, JS, PHP and MySQL.',2,'Web Development','Individual work and exam. Communication takes place via our\r\nRyver channel WD-2020-F-NODEJS'),(31,'WD-2020-F-NODEJS','NodeJS, Flexbox, Grid, CSS, MongoDB, AJAX, Websockets, JSON\r\nobjects, Setting up a server in Amazon Web Servers and locally.\r\nUse of the terminal and FTP. Also, the setup and use of HTTPS.','English',10,'Internal oral exam based on hand in product. Graded based on\r\nthe 7-scale.',35,'Students will be able to code a full stack web based application,\r\nset-up a NODEJS server in the cloud and decide the best possible\r\nuse of MongoDB','Elective',50,15,'Full Stack NodeJs','Full Stack NodeJs','Students must know HTML, CSS, JS, PHP and MySQL.Students must know HTML, CSS, JS, PHP and MySQL.',2,'Web Development','Individual work and exam. Communication takes place via our\r\nRyver channel WD-2020-F-NODEJS'),(32,'WD-2020-F-NODEJS','NodeJS, Flexbox, Grid, CSS, MongoDB, AJAX, Websockets, JSON\r\nobjects, Setting up a server in Amazon Web Servers and locally.\r\nUse of the terminal and FTP. Also, the setup and use of HTTPS.','English',10,'Internal oral exam based on hand in product. Graded based on\r\nthe 7-scale.',35,'Students will be able to code a full stack web based application,\r\nset-up a NODEJS server in the cloud and decide the best possible\r\nuse of MongoDB','Elective',50,15,'Full Stack NodeJs','Full Stack NodeJs','Students must know HTML, CSS, JS, PHP and MySQL.Students must know HTML, CSS, JS, PHP and MySQL.',2,'Web Development','Individual work and exam. Communication takes place via our\r\nRyver channel WD-2020-F-NODEJS'),(33,'WD-2020-F-NODEJS','NodeJS, Flexbox, Grid, CSS, MongoDB, AJAX, Websockets, JSON\r\nobjects, Setting up a server in Amazon Web Servers and locally.\r\nUse of the terminal and FTP. Also, the setup and use of HTTPS.','English',10,'Internal oral exam based on hand in product. Graded based on\r\nthe 7-scale.',35,'Students will be able to code a full stack web based application,\r\nset-up a NODEJS server in the cloud and decide the best possible\r\nuse of MongoDB','Elective',50,15,'Full Stack NodeJs','Full Stack NodeJs','Students must know HTML, CSS, JS, PHP and MySQL.Students must know HTML, CSS, JS, PHP and MySQL.',2,'Web Development','Individual work and exam. Communication takes place via our\r\nRyver channel WD-2020-F-NODEJS'),(34,'WD-2020-F-NODEJS','NodeJS, Flexbox, Grid, CSS, MongoDB, AJAX, Websockets, JSON\r\nobjects, Setting up a server in Amazon Web Servers and locally.\r\nUse of the terminal and FTP. Also, the setup and use of HTTPS.','English',10,'Internal oral exam based on hand in product. Graded based on\r\nthe 7-scale.',35,'Students will be able to code a full stack web based application,\r\nset-up a NODEJS server in the cloud and decide the best possible\r\nuse of MongoDB','Elective',50,15,'Full Stack NodeJs','Full Stack NodeJs','Students must know HTML, CSS, JS, PHP and MySQL.Students must know HTML, CSS, JS, PHP and MySQL.',2,'Web Development','Individual work and exam. Communication takes place via our\r\nRyver channel WD-2020-F-NODEJS'),(35,'WD-2020-F-NODEJS','NodeJS, Flexbox, Grid, CSS, MongoDB, AJAX, Websockets, JSON\r\nobjects, Setting up a server in Amazon Web Servers and locally.\r\nUse of the terminal and FTP. Also, the setup and use of HTTPS.','English',10,'Internal oral exam based on hand in product. Graded based on\r\nthe 7-scale.',35,'Students will be able to code a full stack web based application,\r\nset-up a NODEJS server in the cloud and decide the best possible\r\nuse of MongoDB','Elective',50,15,'Full Stack NodeJs','Full Stack NodeJs','Students must know HTML, CSS, JS, PHP and MySQL.Students must know HTML, CSS, JS, PHP and MySQL.',2,'Web Development','Individual work and exam. Communication takes place via our\r\nRyver channel WD-2020-F-NODEJS'),(36,'WD-2020-F-NODEJS','NodeJS, Flexbox, Grid, CSS, MongoDB, AJAX, Websockets, JSON\r\nobjects, Setting up a server in Amazon Web Servers and locally.\r\nUse of the terminal and FTP. Also, the setup and use of HTTPS.','English',10,'Internal oral exam based on hand in product. Graded based on\r\nthe 7-scale.',35,'Students will be able to code a full stack web based application,\r\nset-up a NODEJS server in the cloud and decide the best possible\r\nuse of MongoDB','Elective',50,15,'Full Stack NodeJs','Full Stack NodeJs','Students must know HTML, CSS, JS, PHP and MySQL.Students must know HTML, CSS, JS, PHP and MySQL.',2,'Web Development','Individual work and exam. Communication takes place via our\r\nRyver channel WD-2020-F-NODEJS'),(37,'WD-2020-F-NODEJS','NodeJS, Flexbox, Grid, CSS, MongoDB, AJAX, Websockets, JSON\r\nobjects, Setting up a server in Amazon Web Servers and locally.\r\nUse of the terminal and FTP. Also, the setup and use of HTTPS.','English',10,'Internal oral exam based on hand in product. Graded based on\r\nthe 7-scale.',35,'Students will be able to code a full stack web based application,\r\nset-up a NODEJS server in the cloud and decide the best possible\r\nuse of MongoDB','Elective',50,15,'Full Stack NodeJs','Full Stack NodeJs','Students must know HTML, CSS, JS, PHP and MySQL.Students must know HTML, CSS, JS, PHP and MySQL.',2,'Web Development','Individual work and exam. Communication takes place via our\r\nRyver channel WD-2020-F-NODEJS'),(38,'WD-2020-F-NODEJS','NodeJS, Flexbox, Grid, CSS, MongoDB, AJAX, Websockets, JSON\r\nobjects, Setting up a server in Amazon Web Servers and locally.\r\nUse of the terminal and FTP. Also, the setup and use of HTTPS.','English',10,'Internal oral exam based on hand in product. Graded based on\r\nthe 7-scale.',35,'Students will be able to code a full stack web based application,\r\nset-up a NODEJS server in the cloud and decide the best possible\r\nuse of MongoDB','Elective',50,15,'Full Stack NodeJs','Full Stack NodeJs','Students must know HTML, CSS, JS, PHP and MySQL.Students must know HTML, CSS, JS, PHP and MySQL.',2,'Web Development','Individual work and exam. Communication takes place via our\r\nRyver channel WD-2020-F-NODEJS'),(39,'WD-2020-F-NODEJS','NodeJS, Flexbox, Grid, CSS, MongoDB, AJAX, Websockets, JSON\r\nobjects, Setting up a server in Amazon Web Servers and locally.\r\nUse of the terminal and FTP. Also, the setup and use of HTTPS.','English',10,'Internal oral exam based on hand in product. Graded based on\r\nthe 7-scale.',35,'Students will be able to code a full stack web based application,\r\nset-up a NODEJS server in the cloud and decide the best possible\r\nuse of MongoDB','Elective',50,15,'Full Stack NodeJs','Full Stack NodeJs','Students must know HTML, CSS, JS, PHP and MySQL.Students must know HTML, CSS, JS, PHP and MySQL.',2,'Web Development','Individual work and exam. Communication takes place via our\r\nRyver channel WD-2020-F-NODEJS'),(40,'WD-2020-F-NODEJS','NodeJS, Flexbox, Grid, CSS, MongoDB, AJAX, Websockets, JSON\r\nobjects, Setting up a server in Amazon Web Servers and locally.\r\nUse of the terminal and FTP. Also, the setup and use of HTTPS.','English',10,'Internal oral exam based on hand in product. Graded based on\r\nthe 7-scale.',35,'Students will be able to code a full stack web based application,\r\nset-up a NODEJS server in the cloud and decide the best possible\r\nuse of MongoDB','Elective',50,15,'Full Stack NodeJs','Full Stack NodeJs','Students must know HTML, CSS, JS, PHP and MySQL.Students must know HTML, CSS, JS, PHP and MySQL.',2,'Web Development','Individual work and exam. Communication takes place via our\r\nRyver channel WD-2020-F-NODEJS'),(41,'WD-2020-F-NODEJS','NodeJS, Flexbox, Grid, CSS, MongoDB, AJAX, Websockets, JSON\r\nobjects, Setting up a server in Amazon Web Servers and locally.\r\nUse of the terminal and FTP. Also, the setup and use of HTTPS.','English',10,'Internal oral exam based on hand in product. Graded based on\r\nthe 7-scale.',35,'Students will be able to code a full stack web based application,\r\nset-up a NODEJS server in the cloud and decide the best possible\r\nuse of MongoDB','Elective',50,15,'Full Stack NodeJs','Full Stack NodeJs','Students must know HTML, CSS, JS, PHP and MySQL.Students must know HTML, CSS, JS, PHP and MySQL.',2,'Web Development','Individual work and exam. Communication takes place via our\r\nRyver channel WD-2020-F-NODEJS'),(42,'WD-2020-F-NODEJS','NodeJS, Flexbox, Grid, CSS, MongoDB, AJAX, Websockets, JSON\r\nobjects, Setting up a server in Amazon Web Servers and locally.\r\nUse of the terminal and FTP. Also, the setup and use of HTTPS.','English',10,'Internal oral exam based on hand in product. Graded based on\r\nthe 7-scale.',35,'Students will be able to code a full stack web based application,\r\nset-up a NODEJS server in the cloud and decide the best possible\r\nuse of MongoDB','Elective',50,15,'Full Stack NodeJs','Full Stack NodeJs','Students must know HTML, CSS, JS, PHP and MySQL.Students must know HTML, CSS, JS, PHP and MySQL.',2,'Web Development','Individual work and exam. Communication takes place via our\r\nRyver channel WD-2020-F-NODEJS'),(43,'111','SCRUM','English',10,'Yup',20,'Nada','Elective',30,10,'Full Stack NodeJs','Full Stack NodeJs','Knowledge',2,'Web Development','Nothing'),(53,'123sd','Summoning theory and exercises','English',7,'Presentation with a tangible result',3,'Basic abilities to summon','Elective',10,5,'Crocodille Fremaning','Crocodile Summoning','Basic summoning',2,'Self explanatory','Summoning theory and exercises'),(54,'123sd','Summoning theory and exercises','English',1,'Presentation with a tangible result',1,'Basic abilities to summon','Elective',1,1,'Crocodille Fremaning','Crocodile Summoning','Basic summoning',1,'Self explanatory','Summoning theory and exercises'),(55,'123sd','Summoning theory and exercises','English',2,'Presentation with a tangible result',2,'Basic abilities to summon','Elective',2,2,'Crocodille Fremaning','Crocodile Summoning','Basic summoning',2,'Self explanatory','Summoning theory and exercises'),(56,'123sd','Summoning theory and exercises','English',1,'Presentation with a tangible result',2,'Basic abilities to summon','Elective',2,2,'dfs','sds','Basic summoning',1,'Self explanatory','Summoning theory and exercises'),(57,'123sd','Summoning theory and exercises','English',2,'Presentation with a tangible result',2,'Basic abilities to summon','Elective',2,2,'Crocodille Fremaning','Crocodile Summoning','Basic summoning',1,'Self explanatory','Summoning theory and exercises'),(58,'123sd','Summoning theory and exercises','English',2,'Presentation with a tangible result',1,'Basic abilities to summon','Elective',1,1,'Crocodille Fremaning','Crocodile Summoning','Basic summoning',2,'Self explanatory','Summoning theory and exercises'),(59,'WD-2020-F-NODEJS','NodeJS, Flexbox, Grid, CSS, MongoDB, AJAX, Websockets, JSONobjects, Setting up a server in Amazon Web Servers and locally.Use of the terminal and FTP. Also, the setup and use of HTTPS.','English',5,'Internal oral exam based on hand in product. Graded based onthe 7-scale.',5,'Students will be able to code a full stack web based application,set-up a NODEJS server in the cloud and decide the best possibleuse of MongoDB','Elective',10,3,'Full Stack NodeJs','Full Stack NodeJs','Students must know HTML, CSS, JS, PHP and MySQL.Students must know HTML, CSS, JS, PHP and MySQL.',2,'Web Development','Individual work and exam. Communication takes place via ourRyver channel WD-2020-F-NODEJS'),(60,'123sd','Summoning theory and exercises','English',2,'Presentation with a tangible result',2,'Basic abilities to summon','Elective',2,2,'Crocodille Fremaning','Crocodile Summoning','Basic summoning',2,'Self explanatory','Summoning theory and exercises');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pending_students`
--

DROP TABLE IF EXISTS `pending_students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pending_students` (
  `course_id` int(11) NOT NULL,
  `student_id` bigint(20) NOT NULL,
  PRIMARY KEY (`course_id`,`student_id`),
  KEY `FKpsuw4eyahp0u8cftdmqy9prw8` (`student_id`),
  CONSTRAINT `FKpsuw4eyahp0u8cftdmqy9prw8` FOREIGN KEY (`student_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKxd08qv5knd0c0y6kpnr74b3w` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pending_students`
--

LOCK TABLES `pending_students` WRITE;
/*!40000 ALTER TABLE `pending_students` DISABLE KEYS */;
INSERT INTO `pending_students` VALUES (25,1),(26,1),(28,1),(30,1),(31,1),(35,1),(37,1),(36,5);
/*!40000 ALTER TABLE `pending_students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) NOT NULL,
  `email` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'2019-11-23 18:11:32.000000','youreawizardharry@yahoo.com','Tariq','Zamani','p',2,'max'),(2,'2019-11-23 18:13:13.000000','romer@cybercity.dk','Andreas','Rømer','p',1,'eve'),(3,'2019-11-23 18:14:01.000000','flagstad@gmail.com','Esben','Flagstad','p',1,'neve'),(4,'1633-11-23 18:14:01.000000','mynameisneo@woot.com','Mr.','Anderson','p',0,'hacker'),(5,'2019-11-18 00:00:00.000000','hermione@granger.com','Hermione','Granger','p',2,'granger');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-28 20:49:09
