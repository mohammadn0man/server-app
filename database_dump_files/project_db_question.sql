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
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `question` (
  `question_id` int(11) NOT NULL,
  `accepted_answer_id` int(11) NOT NULL,
  `closed_date` datetime(6) DEFAULT NULL,
  `creation_date` datetime(6) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `question_subject` varchar(255) DEFAULT NULL,
  `content` varchar(6380) DEFAULT NULL,
  PRIMARY KEY (`question_id`),
  KEY `FKr27h1qc056hx8lc60nvgyhw64` (`product_id`),
  KEY `FK7rnpup7eaonh2ubt922ormoij` (`user_id`),
  CONSTRAINT `FK7rnpup7eaonh2ubt922ormoij` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `FKr27h1qc056hx8lc60nvgyhw64` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (10,0,NULL,'2021-06-01 19:39:30.701000','Equivalent of varchar(max) in MySQL?',4,10001,'What is the equivalent of varchar(max) in MySQL?','These clarifications come amid concerns triggered by some recent comments made by senior officials indicating that the government may consider doing away with the second dose of Covishield.\n\nApart from this, head of a government-appointed expert panel recently said India may begin testing to determine whether mixing two doses of different Covid-19 vaccines could boost immune response. Dr NK Arora, Chairman of the Centre\'s Covid-19 working group, said this amid speculation whether such mix and match could give better immunity against Covid-19.\n\nAddressing a press briefing, Dr VK Paul, Member (health) Niti Aayog and a key member of the government\'s Covid-19 task force, said the government has not made any change in the vaccination schedule for Covishield and Cov'),(12,32,'2021-06-05 21:33:15.704000','2021-06-01 19:40:50.740000','Equivalent of varchar(max) in MySQL?',1,10001,'What is the equivalent of varchar(max) in MySQL?','The amount of data that a column could store in Microsoft SQL server versions prior to version 2005 was limited to 8KB. In order to store more than 8KB you would have to use TEXT, NTEXT, or BLOB columns types, these column types stored their data as a collection of 8K pages separate from the table data pages; they supported storing up to 2GB per row.'),(15,0,NULL,'2021-06-01 22:19:20.562000','UK Scientists Urge Caution Over Lockdown End Amid Covid Third Wave Fears',1,10103,' COVID-19 cases ','On Monday, 3,383 new COVID-19 cases were reported in the UK, making a total of 23,418 over the past week an increase of 28.8 per cent over the previous week. There was one new death from the deadly virus, with the weekly tally of 58 up 45 per cent on the previous week.\n\nProfessor Adam Finn, the expert scientist on the Joint Committee on Vaccination and Immunisation (JCVI) which determines the vaccination rollout cohorts in the country, warned the UK remained vulnerable as there were still large numbers of unvaccinated people.\n\n\"The idea that somehow the job is done is wrong we\'ve still got a lot of people out there who have neither had this virus infection nor yet been immunised and that\'s why we\'re in a vulnerable position right now,\" he said.\n\nProfessor Finn also echoed other scientists in the view that it was \"so much better to delay slightly than to go around with another cycle\" of lockdown restrictions.'),(16,0,NULL,'2021-06-02 12:10:38.622000','Security configuration with Spring-boot',3,10001,'THis asda','The amount of data that a column could store in Microsoft SQL server versions prior to version 2005 was limited to 8KB. In order to store more than 8KB you would have to use TEXT, NTEXT, or BLOB columns types, these column types stored their data as a collection of 8K pages separate from the table data pages; they supported storing up to 2GB per row.'),(19,0,NULL,'2021-06-02 14:14:34.685000','Do I really have to Open Source my project?',1,10001,'Security configuration with Spring-boot','The amount of data that a column could store in Microsoft SQL server versions prior to version 2005 was limited to 8KB. In order to store more than 8KB you would have to use TEXT, NTEXT, or BLOB columns types, these column types stored their data as a collection of 8K pages separate from the table data pages; they supported storing up to 2GB per row.'),(35,0,NULL,'2021-06-02 17:13:44.460000','How to apply Spring Security AntMatchers pattern only to url with pathVariable',5,10202,'Method to configure ignored security antMatches looks like this:','where {itemId} is in UUID format\n\nThe issues is that with this configuration endpoints like/items/report, /items/images are also opened, but they should not.\n\nIs there a way to apply ignoring rule only to uri with path variables ?'),(41,0,NULL,'2021-06-03 13:40:57.619000','new asdf asdfuas da casd fasidf cas ;dif',1,10003,'sfasd','asdfas'),(48,50,'2021-06-07 11:55:00.066000','2021-06-03 15:32:04.270000','Test',1,10202,'new ','Question?'),(53,0,NULL,'2021-06-03 20:10:34.095000','af',1,10202,'sf','fa'),(54,61,'2021-06-05 21:21:52.649000','2021-06-03 21:49:35.273000','asdf',1,10202,'afd','afasdf'),(73,0,NULL,'2021-06-04 17:11:40.491000','ad',1,10001,'sdf','sfd'),(75,0,NULL,'2021-06-04 18:17:29.014000','new asdf asdfuas da casd fasidf cas ;dif',1,10003,'sfasd','asdfas'),(76,0,NULL,'2021-06-05 20:34:03.380000','new ques',1,10001,'afd','asdff'),(77,0,NULL,'2021-06-05 20:34:18.867000','afds',1,10001,'asdf','asdf'),(80,0,NULL,'2021-06-05 20:47:08.193000','new asdf asdfuas da casd fasidf cas ;dif',1,10003,'sfasd','asdfas'),(82,83,'2021-06-06 14:35:56.425000','2021-06-06 14:34:53.971000','How are you',2,10202,'alsa s','asfasdf iasi isadfj asp'),(85,0,NULL,'2021-06-07 14:14:03.683000','Hello ',1,10001,'test ','this is final'),(86,87,'2021-06-07 15:03:58.410000','2021-06-07 15:03:18.800000','new ques',1,10001,'asf','asa asdfj i afa');
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
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
