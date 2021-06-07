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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_k8d0f2n7n88w1a16yhua64onx` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (10001,'Mr Heckels','$2a$10$uGHGNHANd95d2PupLbD0LOOvrN59CJaasgLDzVo58ahmrX1355GLu','asas@a'),(10002,'Cris','$2a$10$Rq6EaoqszxnfX1Izn7IRzeyeOq6RQskEPWxVZ2BXqZpiAChAvnLGy',NULL),(10003,'Mike','$2a$10$TfBgz3NJNaoW03vL92xhN.15Vdc0ZeJYvryxQtU2DJmOFX9M36LAa','theta'),(10102,'Rosen','$2a$10$ATgYzdvOOcCyYUbG6upbZ.AxUqejcudFEUUQzCr5xxshRCuv80peW','thsta'),(10103,'Ramzy Boltan','$2a$10$IylNE0B6aB/3q2TJYi3i.uyHsPrM51qzyj6CvmpvweA1uZOLsqu0K','bol@gmail.com'),(10202,'Erlich Bachman','$2a$10$Nk8kJq7oP1.V78vXS98Vp.5DoOu5IHdsQHEH5DV1mAMjuCiO8aQuO','erlic@mail.com'),(10302,'hrma ara s','$2a$10$FP/Tz67psv8odrJmZNiZRu5Dpv1BqOCQCEeWEVf.OqO5LtuM6s82.','Gamma'),(10402,'asd','$2a$10$vy9/I7bjX3bwCmzAfNWBWemXsYBB0Yge/mV6iWv8JTe8Crs229IbC','asas@aj'),(10502,'h','$2a$10$SUFmGJj4/HDdjPzXSKUiduWVuv7ioMr7kVTEwcHUqB1Ok2PTSpDBm','asas@gamil.com');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
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
