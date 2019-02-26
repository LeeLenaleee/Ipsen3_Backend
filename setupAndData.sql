-- MySQL dump 10.15  Distrib 10.0.38-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: ipsen3
-- ------------------------------------------------------
-- Server version	10.0.38-MariaDB-0ubuntu0.16.04.1

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
-- Table structure for table `brief`
--

DROP TABLE IF EXISTS `brief`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `brief` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `datum` varchar(12) DEFAULT NULL,
  `correspondentie` int(11) DEFAULT NULL,
  `betreft` varchar(25) DEFAULT NULL,
  `adressering` varchar(50) DEFAULT NULL,
  `verhaal` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brief`
--

LOCK TABLES `brief` WRITE;
/*!40000 ALTER TABLE `brief` DISABLE KEYS */;
INSERT INTO `brief` VALUES (1,'01-02-2020',1288,'Kasper van den Berg','duckstad 11','Pietje ging vissen en ving een karper '),(2,'12-04-1990',48,'Jazzlyn TAN','xd 211','Piet sprinte naar het station, helaas de trein ging net weg'),(3,'24-02-2002',158,'Wietse Nicolaas','testshit 511','pietje went on his PC, he found out he got hacked\n:('),(4,'18-08-2015',2,'Jacco van den Berg','henkers 1211','Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley ');
/*!40000 ALTER TABLE `brief` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `btw_percentage`
--

DROP TABLE IF EXISTS `btw_percentage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `btw_percentage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `btw_percentage_hoog` int(2) DEFAULT NULL,
  `btw_percentage_laag` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `btw_percentage`
--

LOCK TABLES `btw_percentage` WRITE;
/*!40000 ALTER TABLE `btw_percentage` DISABLE KEYS */;
INSERT INTO `btw_percentage` VALUES (1,21,6);
/*!40000 ALTER TABLE `btw_percentage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contactpersoon`
--

DROP TABLE IF EXISTS `contactpersoon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contactpersoon` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `contact_achternaam` varchar(25) DEFAULT NULL,
  `contact_voornaam` varchar(25) DEFAULT NULL,
  `contact_bedrijf` varchar(25) DEFAULT NULL,
  `contact_straatnaam` varchar(50) DEFAULT NULL,
  `contact_postcode` varchar(25) DEFAULT NULL,
  `contact_plaats` varchar(25) DEFAULT NULL,
  `contact_land` varchar(25) DEFAULT NULL,
  `contact_relatie` varchar(30) DEFAULT NULL,
  `contact_website` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contactpersoon`
--

LOCK TABLES `contactpersoon` WRITE;
/*!40000 ALTER TABLE `contactpersoon` DISABLE KEYS */;
INSERT INTO `contactpersoon` VALUES (1,'Park','Morris','Bake Shop','Bazuinpad 3','6295AH','Leuven','Nederland','Kennis','morrisss.nl'),(2,'Langley','Gracie','The Movable Feast','Tjalkmeen 2','5921VR','Amersfort','Nederland','Vriend','themovablefeast.nl'),(3,'Kane','Johnathan','Trendkoo','Hanzemeen 67','9372CE','Den Bosch','Nederland','Familie','jfiofg.nlfd'),(4,'Millar','Derek','Vogeltre','Busken Huetlaan 12','0563ZN','Zutphen','Nederland','Klant','vogeltre.com'),(5,'Blanchard','Zavier','Notenkoor','Weisteeg 98','2479KD','Deventer','Nederland','Kennis','dfigovdfjgiv.nl');
/*!40000 ALTER TABLE `contactpersoon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `email`
--

DROP TABLE IF EXISTS `email`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `email` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(60) DEFAULT NULL,
  `contact_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `email`
--

LOCK TABLES `email` WRITE;
/*!40000 ALTER TABLE `email` DISABLE KEYS */;
INSERT INTO `email` VALUES (9,'info@notenkoor.nl',5),(10,'zavier@blanchard.nl',5),(14,'morris@park.nl',1),(15,'gracie@langley.nl',2),(17,'johnny@gmail.nl',3),(18,'info@trendkoo.nl',3),(19,'derek@millar.nl',4);
/*!40000 ALTER TABLE `email` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factuur`
--

DROP TABLE IF EXISTS `factuur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `factuur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `datum` varchar(12) DEFAULT NULL,
  `aflever_datum` varchar(12) DEFAULT NULL,
  `factuur_omschrijving` varchar(250) DEFAULT NULL,
  `bruto_kosten` double(9,2) DEFAULT NULL,
  `btw_percentage` int(2) DEFAULT NULL,
  `btw_kosten` double(9,2) DEFAULT NULL,
  `netto_kosten` double(9,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factuur`
--

LOCK TABLES `factuur` WRITE;
/*!40000 ALTER TABLE `factuur` DISABLE KEYS */;
INSERT INTO `factuur` VALUES (1,'12-09-2019','16-02-2019','Schildering museum',1.00,6,1.00,1.06),(3,'07-02-2019','08-03-2019','Software aangeschaft',40.10,6,40.10,42.50),(4,'08-01-2017','08-01-2020','Winrar aangeschaft',5665564.60,21,5665564.60,554456.00);
/*!40000 ALTER TABLE `factuur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gebruiker`
--

DROP TABLE IF EXISTS `gebruiker`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gebruiker` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gebruikersnaam` varchar(25) DEFAULT NULL,
  `email_adres` varchar(25) DEFAULT NULL,
  `wachtwoord` varchar(64) DEFAULT NULL,
  `rol` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gebruiker`
--

LOCK TABLES `gebruiker` WRITE;
/*!40000 ALTER TABLE `gebruiker` DISABLE KEYS */;
INSERT INTO `gebruiker` VALUES (1,'KAAAAAAZPER','test@test.com','9F86D081884C7D659A2FEAA0C55AD015A3BF4F1B2B0B822CD15D6C15B0F00A08','ADMIN'),(2,'Meneer Nicolaas','test1@test.com','1B4F0E9851971998E732078544C96B36C3D01CEDF7CAA332359D6F1D83567014','USER'),(3,'Loek','info@loekweijts.nl','72D0166B5707D129DC321E56692FE454C034552EE9E2B38F5A7F1C1306A632EA','ADMIN');
/*!40000 ALTER TABLE `gebruiker` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kostenpost`
--

DROP TABLE IF EXISTS `kostenpost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kostenpost` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kostenpost_kostenpost` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kostenpost`
--

LOCK TABLES `kostenpost` WRITE;
/*!40000 ALTER TABLE `kostenpost` DISABLE KEYS */;
INSERT INTO `kostenpost` VALUES (12,'anders'),(13,'huur'),(14,'kantoorartikelen'),(15,'reiskosten'),(16,'eten'),(17,'Vrije Tijd'),(18,'fictAnalyse');
/*!40000 ALTER TABLE `kostenpost` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `offerte`
--

DROP TABLE IF EXISTS `offerte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `offerte` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `datum` varchar(12) DEFAULT NULL,
  `correspondentienummer` int(25) DEFAULT NULL,
  `naamklant` varchar(25) DEFAULT NULL,
  `uren` double(9,2) DEFAULT NULL,
  `btwPercentage` double(9,2) DEFAULT NULL,
  `kostenBruto` double(9,2) DEFAULT NULL,
  `kostenBTW` double(9,2) DEFAULT NULL,
  `kostenNetto` double(9,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `offerte`
--

LOCK TABLES `offerte` WRITE;
/*!40000 ALTER TABLE `offerte` DISABLE KEYS */;
INSERT INTO `offerte` VALUES (1,'03-02-1990',124,'piet',55.00,41.00,55.00,9.00,999.00),(2,'05-12-2000',98,'Klaas',555.00,34.00,3.00,91.00,7.00),(3,'03-05-2136',12,'Jan',96.00,4.00,74.00,95.00,77.00),(4,'22-12-5845',95,'Melanie',2.00,7.00,8.00,19.00,23.00);
/*!40000 ALTER TABLE `offerte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `onkosten`
--

DROP TABLE IF EXISTS `onkosten`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `onkosten` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `onkosten_bedrijf` varchar(50) DEFAULT NULL,
  `onkosten_datum` varchar(20) DEFAULT NULL,
  `onkosten_kostenpost` varchar(50) DEFAULT NULL,
  `onkosten_omschrijving` varchar(250) DEFAULT NULL,
  `onkosten_bruto_kosten` double(9,2) DEFAULT NULL,
  `onkosten_btw_percentage` int(2) DEFAULT NULL,
  `onkosten_btw_kosten` double(9,2) DEFAULT NULL,
  `onkosten_netto_kosten` double(9,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `onkosten`
--

LOCK TABLES `onkosten` WRITE;
/*!40000 ALTER TABLE `onkosten` DISABLE KEYS */;
INSERT INTO `onkosten` VALUES (1,'hema','15-05-2018','kantoorartikelen','tekenpennen rood zwart',6.00,10,1.00,156.00),(2,'Boring Company','12-09-2018','anders','boring flamethrower',500.00,21,105.00,605.00),(3,'vogeltre','06-03-2018','huur','ruimte om te tekenen',54.00,18,9.72,63.72),(5,'Vogeltre','24-01-2018','kantoorartikelen','bellen met klant',12.00,19,4.00,2.00),(10,'Albert Heijn','06-08-2012','eten','croissant',2.00,5,0.10,2.10),(11,'Analyse','31-01-2019','fictAnalyse','Analyse',529.00,21,111.09,640.09);
/*!40000 ALTER TABLE `onkosten` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telefoonnummer`
--

DROP TABLE IF EXISTS `telefoonnummer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `telefoonnummer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `telnr` varchar(15) DEFAULT NULL,
  `contact_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telefoonnummer`
--

LOCK TABLES `telefoonnummer` WRITE;
/*!40000 ALTER TABLE `telefoonnummer` DISABLE KEYS */;
INSERT INTO `telefoonnummer` VALUES (9,'58653346',5),(11,'12345678',1),(12,'23456789',2),(13,'34567890',2),(14,'09876543',3),(15,'38590215',4),(16,'98765432',4),(17,'87654321',4);
/*!40000 ALTER TABLE `telefoonnummer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-26 16:05:56
