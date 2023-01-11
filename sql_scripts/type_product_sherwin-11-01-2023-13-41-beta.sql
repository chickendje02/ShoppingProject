-- MariaDB dump 10.19  Distrib 10.5.12-MariaDB, for Linux (x86_64)
--
-- Host: mysql.hostinger.ro    Database: u574849695_15
-- ------------------------------------------------------
-- Server version	10.5.12-MariaDB-cll-lve

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

--
-- Table structure for table `type_product_sherwin`
--

DROP TABLE IF EXISTS `type_product_sherwin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `type_product_sherwin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `last_update_date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `last_update_by` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type_product_sherwin`
--

LOCK TABLES `type_product_sherwin` WRITE;
/*!40000 ALTER TABLE `type_product_sherwin` DISABLE KEYS */;
INSERT INTO `type_product_sherwin` VALUES (1,'dolores','2021-08-30 16:20:57','floyd.ondricka'),(2,'nostrum','2000-11-09 09:59:06','o\'conner.oswaldo'),(3,'sint','1989-12-20 10:12:08','andres24'),(4,'qui','1985-06-06 07:21:25','marvin.creola'),(5,'omnis','1983-10-09 03:06:19','helen96'),(6,'est','2022-10-22 13:41:42','crist.leo'),(7,'voluptatem','2013-01-13 10:56:21','ashlee.watsica'),(8,'accusantium','2014-11-03 09:29:57','keely.green'),(9,'similique','2003-06-07 17:26:50','cyril02'),(10,'vel','1988-01-18 18:46:28','lowe.jerome'),(11,'earum','2006-01-05 22:19:09','mreilly'),(12,'explicabo','2008-02-01 04:41:36','oran.breitenberg'),(13,'corrupti','2015-06-11 06:05:24','steuber.alisha'),(14,'quasi','1990-02-15 02:47:12','dorris95'),(15,'eum','1995-07-07 20:07:02','dstiedemann'),(16,'libero','1983-07-02 03:25:03','alyson13'),(17,'expedita','1979-10-05 17:52:28','xdubuque'),(18,'ipsam','1995-11-27 21:37:10','bednar.shanon'),(19,'ea','2008-05-01 15:00:53','schowalter.maude'),(20,'esse','2016-11-09 00:01:13','rbednar'),(21,'rerum','1997-06-28 16:56:17','o\'connell.finn'),(22,'atque','1998-05-21 13:31:44','lonie05'),(23,'unde','2015-05-24 07:26:59','nasir.reichert'),(24,'sunt','2004-07-27 17:04:18','carmel.swaniawski'),(25,'ut','1988-12-29 17:09:24','davin.satterfield'),(26,'odio','2008-05-02 14:25:11','murazik.kurt'),(27,'harum','1978-10-05 07:48:45','johan.wunsch'),(28,'recusandae','2017-06-13 20:50:43','vfeest'),(29,'molestiae','1992-05-22 08:05:56','howell.tristian'),(30,'a','1996-08-19 04:33:18','bschiller'),(31,'quam','1970-05-13 22:51:59','emilio83'),(32,'tempora','1974-09-03 05:54:18','frederick98'),(33,'velit','2005-05-23 10:00:00','kwyman'),(34,'sit','1994-10-22 01:24:36','uwhite'),(35,'maxime','2022-05-22 02:08:25','thauck'),(36,'nemo','1984-02-24 21:10:44','oo\'connell'),(37,'occaecati','1976-06-15 07:17:56','ashtyn95'),(38,'modi','1971-11-27 12:29:23','tgleason'),(39,'adipisci','1984-08-05 08:39:56','effertz.gaylord'),(40,'voluptas','2021-03-19 03:45:13','corrine27'),(41,'quae','2011-08-01 03:04:44','quincy48'),(42,'aliquid','1995-12-14 06:26:56','turcotte.francis'),(43,'debitis','1987-09-16 21:07:09','geovanni.tremblay'),(44,'quia','1985-08-13 02:20:07','esenger'),(45,'ab','2009-08-27 14:37:03','walker64'),(46,'et','2001-12-07 11:03:18','jwillms'),(47,'asperiores','1972-10-28 06:44:13','mcdermott.jaime'),(48,'necessitatibus','1982-12-20 10:37:07','tjaskolski'),(49,'alias','1979-05-03 18:11:11','raleigh70'),(50,'incidunt','1975-08-28 16:16:21','kbeahan'),(51,'optio','1989-06-21 23:11:27','schimmel.hudson'),(52,'vero','1970-04-28 04:13:26','afisher'),(53,'impedit','1994-04-11 17:55:13','iva26'),(54,'labore','1986-05-10 16:39:11','nicole.rolfson'),(55,'consequatur','1981-09-30 17:47:39','scarlett.skiles'),(56,'non','1994-06-06 23:57:57','pbeatty'),(57,'quis','1986-05-08 02:59:39','hdoyle'),(58,'tempore','2016-08-22 06:12:04','block.earnest'),(59,'nulla','2022-04-20 04:33:06','hackett.annalise'),(60,'dolorem','1990-09-16 10:02:02','daniel.colleen'),(61,'at','1981-03-01 08:23:10','jerrold59'),(62,'ad','1983-03-21 22:58:29','heller.delia'),(63,'reiciendis','1995-01-03 17:35:09','xondricka'),(64,'repellendus','1989-08-27 17:36:24','gcrist'),(65,'nihil','2014-01-20 23:07:49','atoy'),(66,'autem','2013-10-17 15:52:23','gerardo09'),(67,'temporibus','1991-02-24 17:45:32','mcglynn.xzavier'),(68,'quo','1995-01-09 05:41:39','ffeeney'),(69,'id','2015-08-13 14:18:16','nkuvalis'),(70,'vitae','1991-02-15 12:18:53','kariane.howe'),(71,'iste','1980-05-30 14:18:35','lilliana.thiel'),(72,'soluta','2021-08-08 06:33:16','lockman.alejandra'),(73,'consequuntur','2000-06-24 00:51:14','greta.conroy'),(74,'voluptatibus','1972-05-11 15:40:26','qjerde'),(75,'voluptates','1989-08-18 20:32:51','bblick'),(76,'ipsa','1989-03-21 06:13:56','salvatore.boyle'),(77,'eos','2003-10-22 20:32:55','yasmine22'),(78,'eius','1975-08-10 04:27:01','toy.kessler'),(79,'veniam','1974-09-22 16:39:21','vwilderman'),(80,'rem','1997-03-11 14:47:44','betsy.reynolds'),(81,'pariatur','1979-02-26 02:15:37','reichert.ephraim'),(82,'aliquam','1993-07-17 08:28:22','langworth.maeve'),(83,'porro','1995-02-01 20:03:02','kdicki'),(84,'aperiam','2009-01-06 15:36:00','mose.sawayn'),(85,'commodi','2010-10-22 14:15:44','thompson.israel'),(86,'aut','1979-10-21 12:18:04','meta.bode'),(87,'placeat','2008-05-12 15:14:04','abel.fay'),(88,'eveniet','1978-08-25 01:47:42','wmaggio'),(89,'illo','2018-05-01 07:07:12','emilie90'),(90,'nisi','2009-11-09 19:16:04','jed39'),(91,'dignissimos','1979-08-09 10:31:14','johnston.jammie'),(92,'blanditiis','2014-09-11 00:51:34','maybell.konopelski'),(93,'fugiat','2009-03-11 12:24:49','oberbrunner.jaylan'),(94,'hic','2018-08-30 07:51:41','vgaylord'),(95,'assumenda','2013-04-15 03:28:29','karson.champlin'),(96,'dolor','1995-03-19 01:57:17','garret04'),(97,'ullam','2012-10-06 22:11:01','esmeralda65'),(98,'sed','2011-03-08 02:53:44','greyson01'),(99,'deserunt','1983-12-10 02:11:47','laron61'),(100,'voluptate','2006-09-28 03:02:10','denis.hahn');
/*!40000 ALTER TABLE `type_product_sherwin` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-11 13:41:06
