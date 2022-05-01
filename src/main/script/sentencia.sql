-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: localhost    Database: dacagroup
-- ------------------------------------------------------
-- Server version	8.0.27

CREATE DATABASE `dacagroup`;

USE `dacagroup`;

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
                            `id` bigint NOT NULL AUTO_INCREMENT,
                            `apellido` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                            `email` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                            `nombre` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                            `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                            `telefono` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                            `rol` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (3,'Gup','admin@gmail.com','Jose','$argon2id$v=19$m=1024,t=1,p=1$ISqKME6snSdvw+0Z+k55bA$wMuouHiklyA+UzDlZYQ3VwJ56YVcHRHrCpI3BCw6Bi0','11615589','Admin'),(4,'Moy','daca@gmail.com','Lucas','$argon2id$v=19$m=1024,t=1,p=1$vjyBP5VX1ZMxGOYr61fzUg$ykm9IvfHAQ26nNvT3av06E2IdfkOFDRPnFNKBoc+by8','7862297234','Daca');

UNLOCK TABLES;