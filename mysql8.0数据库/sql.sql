-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: covid9_server
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `check_record`
--

DROP TABLE IF EXISTS `check_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `check_record` (
  `id` int NOT NULL AUTO_INCREMENT,
  `patient_id` int DEFAULT NULL,
  `check_type` varchar(10) DEFAULT NULL,
  `result` varchar(10) DEFAULT NULL,
  `check_date` datetime DEFAULT NULL,
  `order_no` int DEFAULT NULL,
  `patient_level` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `check_record_patient_l1_id_fk` (`patient_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `check_record`
--

LOCK TABLES `check_record` WRITE;
/*!40000 ALTER TABLE `check_record` DISABLE KEYS */;
INSERT INTO `check_record` VALUES (9,17,'CT','Y','2021-04-28 16:16:15',1,1),(10,17,'HS','N','2021-04-21 16:24:05',2,1),(11,17,'CT','N','2021-04-28 16:24:28',3,1),(19,18,'HS','N','2021-04-28 16:27:08',1,1),(20,18,'CT','Y','2021-04-29 16:27:26',2,1),(25,20,'HS','N','2021-04-28 16:28:47',1,3),(26,20,'CT','N','2021-04-01 17:25:58',1,1),(27,21,'CT','N','2021-03-30 17:55:47',1,1),(28,21,'HS','N','2021-04-06 17:55:55',2,1),(29,21,'HS','N','2021-04-06 17:58:52',1,3),(30,22,'CT','N','2021-04-13 18:37:08',1,1),(31,22,'HS','N','2021-04-08 18:37:16',2,1),(32,22,'HS','N','2021-04-06 18:40:10',1,3);
/*!40000 ALTER TABLE `check_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leader`
--

DROP TABLE IF EXISTS `leader`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `leader` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `gender` varchar(100) DEFAULT NULL,
  `group_name` varchar(100) DEFAULT NULL,
  `duty` varchar(500) DEFAULT NULL,
  `phone_no` varchar(100) DEFAULT NULL,
  `remark` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leader`
--

LOCK TABLES `leader` WRITE;
/*!40000 ALTER TABLE `leader` DISABLE KEYS */;
INSERT INTO `leader` VALUES (2,'wqwq','male','武切维奇无','我去问清楚','武切维奇','驱蚊器');
/*!40000 ALTER TABLE `leader` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `news` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(500) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_user` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` VALUES (2,'测试啊','动态啊','2021-04-04 20:52:24',6),(4,'212121','212121','2021-04-05 17:59:39',7),(5,'测试','测试','2021-04-05 17:59:50',6),(6,'2121','21','2021-04-05 18:30:08',6),(7,'21','21','2021-04-05 18:30:29',7);
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient_l1`
--

DROP TABLE IF EXISTS `patient_l1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient_l1` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `gender` varchar(100) NOT NULL,
  `age` int NOT NULL,
  `idcard_no` varchar(100) NOT NULL,
  `source` varchar(200) NOT NULL,
  `symptom_type` varchar(5) NOT NULL,
  `enter_date` datetime NOT NULL,
  `performance` varchar(300) NOT NULL,
  `hospital` varchar(200) NOT NULL,
  `remark` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_l1`
--

LOCK TABLES `patient_l1` WRITE;
/*!40000 ALTER TABLE `patient_l1` DISABLE KEYS */;
INSERT INTO `patient_l1` VALUES (2,'212','male',150,'212','212','Y','2021-03-25 23:35:32','12121','2121','2121'),(3,'2121','female',150,'21212','2121','Y','2021-03-31 23:43:02','2121','2121','2121'),(4,'2121','male',150,'2121','212','Y','2021-03-31 23:44:16','212','212','2121'),(5,'12121','male',150,'2121','2121','Y','2021-04-17 15:35:47','212','2121','212'),(6,'2121','female',150,'2121','2121','Y','2021-04-23 15:39:11','2121','2121','21212'),(7,'2121','male',150,'2121','2121','Y','2021-04-23 15:39:11','2121','2121','21212'),(8,'2121','female',150,'2121','2121','Y','2021-04-23 15:39:11','2121','2121','21212'),(9,'2121','male',150,'2121','2121','Y','2021-04-23 15:39:11','2121','2121','21212'),(10,'2121','male',150,'2121','2121','Y','2021-04-23 15:39:11','2121','2121','21212'),(17,'王伟','male',28,'622921199208061236','密切接触','N','2021-04-22 17:43:16','咳嗽，胸痛','西安交通大学第一附属医院','无'),(18,'122','male',150,'212','212','Y','2021-04-15 18:47:23','2121','2121','2121');
/*!40000 ALTER TABLE `patient_l1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient_l2`
--

DROP TABLE IF EXISTS `patient_l2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient_l2` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `idcard_no` varchar(100) DEFAULT NULL,
  `hot_cough` varchar(10) DEFAULT NULL,
  `from_city` varchar(100) DEFAULT NULL,
  `setout_date` datetime DEFAULT NULL,
  `traffic_type` int DEFAULT NULL,
  `traffic_no` varchar(100) DEFAULT NULL,
  `sit_no` varchar(100) DEFAULT NULL,
  `status` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_l2`
--

LOCK TABLES `patient_l2` WRITE;
/*!40000 ALTER TABLE `patient_l2` DISABLE KEYS */;
INSERT INTO `patient_l2` VALUES (4,'王伟','male',12,'6229200299918290019','N','美国纽约','2021-03-31 20:07:35',2,'MU2203','23F',99),(5,'张小海','female',33,'622901210902028791821','N','美国芝加哥','2021-03-30 20:18:28',2,'MU5562','10Q',99),(20,'张小海','male',67,'622901210902028791821','N','美国芝加哥','2021-03-30 20:18:28',2,'MU5562','10Q',99),(21,'入境测试','male',55,'622023092902910029','Y','英国伦敦','2021-04-20 14:14:12',2,'MU2222','123M',99),(22,'入境测试','male',55,'622023092902910029','Y','英国伦敦','2021-04-20 14:14:12',2,'MU2222','123M',1),(25,'测试入境','male',23,'2628392019289902','Y','美国麦肯瑟','2021-04-06 17:26:42',2,'MU2205','123R',2);
/*!40000 ALTER TABLE `patient_l2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient_l3`
--

DROP TABLE IF EXISTS `patient_l3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient_l3` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `idcard_no` varchar(50) DEFAULT NULL,
  `route` varchar(10) DEFAULT NULL,
  `traffic` varchar(10) DEFAULT NULL,
  `contact` varchar(10) DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_l3`
--

LOCK TABLES `patient_l3` WRITE;
/*!40000 ALTER TABLE `patient_l3` DISABLE KEYS */;
INSERT INTO `patient_l3` VALUES (2,'13213',150,'male','321','Y','Y','Y','32131','2021-04-21 15:46:15'),(3,'13213',150,'male','321','Y','Y','Y','32131','2021-04-21 15:46:15'),(4,'13213',150,'male','321','Y','Y','Y','32131','2021-04-21 15:46:15'),(5,'13213',150,'male','321','Y','Y','Y','32131','2021-04-21 15:46:15'),(6,'13213',150,'male','321','Y','Y','Y','32131','2021-04-21 15:46:15'),(7,'13213',150,'male','321','Y','Y','Y','32131','2021-04-21 15:46:15'),(8,'13213',150,'male','321','Y','Y','Y','32131','2021-04-21 15:46:15'),(9,'13213',150,'male','321','Y','Y','Y','32131','2021-04-21 15:46:15'),(11,'13213',150,'male','321','Y','Y','Y','32131','2021-04-21 15:46:15'),(12,'13213',150,'male','321','Y','Y','Y','32131','2021-04-21 15:46:15'),(13,'13213',150,'male','321','Y','Y','Y','32131','2021-04-21 15:46:15'),(14,'13213',150,'male','321','Y','Y','Y','32131','2021-04-21 15:46:15'),(15,'13213',150,'male','321','Y','Y','Y','32131','2021-04-21 15:46:15'),(16,'13213',150,'male','321','Y','Y','Y','32131','2021-04-21 15:46:15'),(17,'13213',150,'male','321','Y','Y','Y','32131','2021-04-21 15:46:15'),(18,'13213',150,'male','321','Y','Y','Y','32131','2021-04-21 15:46:15'),(19,'13213',150,'male','321','Y','Y','Y','32131','2021-04-21 15:46:15'),(20,'测试一下',21,'female','2312131321321321321312','N','N','N','111111111111111111111111','2021-03-31 15:46:15'),(21,'21212222222222',23,'female','222222222222222222','Y','N','N','12212','2021-03-30 17:58:33'),(22,'测试患者2',25,'female','122222222222222222','N','Y','Y','21212','2021-03-29 18:39:43');
/*!40000 ALTER TABLE `patient_l3` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient_l4`
--

DROP TABLE IF EXISTS `patient_l4`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient_l4` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `idcard_no` varchar(100) DEFAULT NULL,
  `health_code` varchar(10) DEFAULT NULL,
  `traffic_type` int DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_l4`
--

LOCK TABLES `patient_l4` WRITE;
/*!40000 ALTER TABLE `patient_l4` DISABLE KEYS */;
INSERT INTO `patient_l4` VALUES (3,'2121',12,'female','222222222222222222','N',2,'21212');
/*!40000 ALTER TABLE `patient_l4` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nick_name` varchar(100) DEFAULT NULL,
  `account` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `phone_no` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES (2,'111111','111111','111111','male','12121212'),(3,'212','212','111111','male','2121'),(4,'212','212','111111','male','21212'),(5,'2121','2121','111111','male','21212'),(6,'212','1','111111','male','1212'),(7,'admin','admin','111111','male','16689205681'),(8,'212','121','111111','male','2121'),(9,'11111','admin2','111111','female','11111'),(10,'admin','admin3','111111','male','18809320912'),(11,'admin5','admin5','111111','male','17782909832'),(12,'usertest','admin7','111111','female','16789290912'),(13,'admin','admin6','111111','male','16609203298');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `watch_l1`
--

DROP TABLE IF EXISTS `watch_l1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `watch_l1` (
  `id` int NOT NULL AUTO_INCREMENT,
  `patient_id` int DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `test_1_date` datetime DEFAULT NULL,
  `test_1_result` varchar(10) DEFAULT NULL,
  `test_2_date` datetime DEFAULT NULL,
  `test_2_result` varchar(10) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `watch_l1`
--

LOCK TABLES `watch_l1` WRITE;
/*!40000 ALTER TABLE `watch_l1` DISABLE KEYS */;
INSERT INTO `watch_l1` VALUES (1,13,'2021-04-29 21:13:06','2021-04-14 21:13:11','N','2021-04-20 21:13:15','N','奥德赛大'),(3,16,'2021-04-07 23:53:19','2021-04-07 23:53:25','N','2021-04-15 23:53:29','N','321321'),(4,12,'2021-04-01 23:59:58','2021-03-31 00:00:01','N','2021-04-28 00:00:08','N','wqeq'),(6,6,'2021-04-02 00:09:52','2021-04-01 00:09:56','N','2021-04-23 00:09:59','N','2321313'),(7,10,'2021-04-01 00:20:06','2021-03-31 00:20:10','N','2021-04-28 00:20:13','N','2121'),(8,17,'2021-04-07 00:20:30','2021-04-01 00:20:33','N','2021-05-04 00:20:38','N','2121'),(9,24,'2021-04-05 17:34:41','2021-04-28 17:34:42','Y','2021-04-28 17:34:45','N','21'),(10,24,'2021-04-05 17:34:41','2021-04-28 17:34:42','Y','2021-04-28 17:34:45','N','21'),(11,23,'2021-04-21 17:38:08','2021-04-20 17:38:16','N','2021-04-27 17:38:18','N','21'),(12,23,'2021-04-22 17:38:08','2021-04-20 17:38:16','N','2021-04-27 17:38:18','N','21'),(13,22,'2021-04-05 17:50:28','2021-04-05 17:50:31','N','2021-04-05 17:50:34','N','21212121'),(14,26,'2021-04-07 17:57:14','2021-03-30 17:57:18','N','2021-04-02 17:57:21','N','21211'),(15,27,'2021-03-30 18:38:17','2021-04-05 18:38:22','N','2021-04-07 18:38:26','N','12312131');
/*!40000 ALTER TABLE `watch_l1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `watch_l2`
--

DROP TABLE IF EXISTS `watch_l2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `watch_l2` (
  `id` int NOT NULL AUTO_INCREMENT,
  `patient_id` int DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `test_3_date` datetime DEFAULT NULL,
  `test_3_result` varchar(10) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `watch_l2`
--

LOCK TABLES `watch_l2` WRITE;
/*!40000 ALTER TABLE `watch_l2` DISABLE KEYS */;
INSERT INTO `watch_l2` VALUES (1,13,'2021-04-02 22:38:12','2021-03-31 22:38:38','N','2132132'),(2,16,'2021-04-08 23:54:03','2021-04-06 23:54:09','N','213131'),(3,12,'2021-04-02 00:13:05','2021-04-29 00:13:10','N','21'),(4,25,'2021-04-15 17:27:59','2021-04-06 17:28:04','N','212121212'),(5,22,'2021-04-28 17:51:23','2021-04-05 17:51:30','N','21'),(6,26,'2021-03-31 17:57:41','2021-04-01 17:57:46','N','2121'),(7,27,'2021-03-30 18:38:44','2021-04-07 18:38:48','N','231');
/*!40000 ALTER TABLE `watch_l2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `watch_l3`
--

DROP TABLE IF EXISTS `watch_l3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `watch_l3` (
  `id` int NOT NULL AUTO_INCREMENT,
  `patient_id` int DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `test_4_date` datetime DEFAULT NULL,
  `test_4_result` varchar(10) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `watch_l3`
--

LOCK TABLES `watch_l3` WRITE;
/*!40000 ALTER TABLE `watch_l3` DISABLE KEYS */;
INSERT INTO `watch_l3` VALUES (1,13,'2021-04-11 23:41:55','2021-04-01 23:42:01','N','323213213'),(2,16,'2021-04-02 00:15:58','2021-04-23 00:16:02','N','121'),(3,25,'2021-04-06 17:28:26','2021-04-07 17:28:30','N','2121212'),(4,26,'2021-04-06 17:57:59','2021-04-01 17:58:03','N','2121'),(5,27,'2021-03-30 18:39:04','2021-04-05 18:39:09','N','2133');
/*!40000 ALTER TABLE `watch_l3` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-08 19:56:49
