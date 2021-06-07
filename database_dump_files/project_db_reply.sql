CREATE DATABASE  IF NOT EXISTS `project_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `project_db`;
-- MySQL dump 10.13  Distrib 8.0.14, for Win64 (x86_64)
--
-- Host: localhost    Database: project_db
-- ------------------------------------------------------
-- Server version	8.0.14

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `reply`
--

DROP TABLE IF EXISTS `reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `reply` (
  `reply_id` int(11) NOT NULL,
  `creation_date` datetime(6) DEFAULT NULL,
  `question_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `content` varchar(6380) DEFAULT NULL,
  PRIMARY KEY (`reply_id`),
  KEY `FKlf3483md4ptkyewrkrjehfg56` (`question_id`),
  KEY `FKmtfnx1efxiq3p9n6kh3org2yj` (`user_id`),
  CONSTRAINT `FKlf3483md4ptkyewrkrjehfg56` FOREIGN KEY (`question_id`) REFERENCES `question` (`question_id`),
  CONSTRAINT `FKmtfnx1efxiq3p9n6kh3org2yj` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reply`
--

LOCK TABLES `reply` WRITE;
/*!40000 ALTER TABLE `reply` DISABLE KEYS */;
INSERT INTO `reply` VALUES (29,'2021-06-02 17:10:00.904000',19,10001,'This is old question.'),(30,'2021-06-02 17:10:08.285000',19,10001,'Hii\n'),(31,'2021-06-02 17:11:11.760000',12,10001,'hello there'),(32,'2021-06-02 17:11:21.882000',12,10001,'You are awesome.'),(33,'2021-06-02 17:12:18.791000',15,10202,'This is terrifying. '),(34,'2021-06-02 17:12:38.376000',12,10202,'What is that meant?'),(37,'2021-06-02 17:15:29.702000',35,10001,'According to the documentation for AntPathMarcher, you need to specify the path variable with the regex as per doc:\n\n{spring:[a-z]+} matches the regexp [a-z]+ as a path variable named \"spring\".\n\nIn your case it will be:'),(38,'2021-06-02 17:15:45.018000',35,10001,'Try this.'),(39,'2021-06-02 17:41:52.548000',35,10202,'Thanks bro it worked.'),(49,'2021-06-03 15:32:12.037000',48,10202,'hello'),(50,'2021-06-03 15:32:55.159000',48,10001,'whats up\n'),(51,'2021-06-03 15:33:03.733000',48,10202,'good'),(52,'2021-06-03 15:33:13.047000',48,10001,'what is this\n'),(55,'2021-06-03 22:01:54.317000',54,10001,'adfsas\n'),(56,'2021-06-03 22:04:32.690000',54,10001,'adssa'),(57,'2021-06-03 22:08:09.343000',54,10202,'apsf'),(58,'2021-06-03 22:11:58.860000',35,10001,'asdas'),(59,'2021-06-03 22:13:41.770000',35,10001,'asd'),(60,'2021-06-03 22:23:44.914000',54,10001,'asdf'),(61,'2021-06-03 22:26:39.385000',54,10001,'asdf'),(62,'2021-06-03 22:33:36.526000',54,10001,'asdfa'),(63,'2021-06-03 22:33:58.195000',54,10001,'ffff'),(64,'2021-06-03 22:34:42.648000',54,10001,'asdf'),(65,'2021-06-03 22:35:00.138000',54,10001,'sadfsa'),(66,'2021-06-03 22:35:04.283000',54,10001,'dfsd'),(67,'2021-06-03 22:37:30.652000',54,10001,'asdf'),(68,'2021-06-03 22:37:37.919000',54,10001,'sadffff'),(81,'2021-06-06 13:54:10.881000',10,10202,'Hwlasd'),(83,'2021-06-06 14:35:21.043000',82,10001,'THis is cool>'),(84,'2021-06-06 14:35:28.458000',82,10202,'not cool'),(87,'2021-06-07 15:03:54.782000',86,10202,'wells');
/*!40000 ALTER TABLE `reply` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-07 16:04:03
