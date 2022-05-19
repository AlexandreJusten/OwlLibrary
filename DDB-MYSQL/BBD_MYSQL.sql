-- MySQL dump 10.13  Distrib 8.0.29, for Linux (x86_64)
--
-- Host: localhost    Database: LivrariaDDS
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Fantasia'),(2,'Ficção Cientifica'),(3,'Distopia'),(4,'Ação e aventura'),(5,'Ficção Policial'),(6,'Horror'),(7,'Romance'),(8,'Conto'),(9,'Biografia'),(10,'Humor');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nomedelogin` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `nomecompleto` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `telefone` varchar(11) DEFAULT NULL,
  `endereco` varchar(90) DEFAULT NULL,
  `senha` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (80,'Admin','Admin','1','sc','C1C224B03CD9BC7B6A86D77F5DACE40191766C485CD55DC48CAF9AC873335D6F'),(81,'Alexandre.jf10','Alexandre Justen','22222222','Sc','B7E94BE513E96E8C45CD23D162275E5A12EBDE9100A425C4EBCDD7FA4DCD897C'),(83,'Japa','Vinicus coisa','2','sc','747F16FE0DC7179509BBAA6364A754904017EC7C5E9D2DEBD26E9AFA37981CC6'),(84,'a','a','2','s','CA978112CA1BBDCAFAC231B39A23DC4DA786EFF8147C4E72B9807785AFEE48BB'),(85,'Gabriel1','Gabriel duran','2222','sc','B7E94BE513E96E8C45CD23D162275E5A12EBDE9100A425C4EBCDD7FA4DCD897C');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `editora`
--

DROP TABLE IF EXISTS `editora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `editora` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `endereco` varchar(20) DEFAULT NULL,
  `telefone` varchar(11) DEFAULT NULL,
  `gerente` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `editora`
--

LOCK TABLES `editora` WRITE;
/*!40000 ALTER TABLE `editora` DISABLE KEYS */;
INSERT INTO `editora` VALUES (1,'Editora A','SC','123456789','Gerente A'),(2,'Editora B','PR','123456789',NULL),(3,'Editora C','PR','123456789','Gerente C'),(4,'Editora D','PR','123456789','Gerente B'),(5,'Editora E','SC','123456789','Gerente E');
/*!40000 ALTER TABLE `editora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `livro`
--

DROP TABLE IF EXISTS `livro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `livro` (
  `id` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(255) DEFAULT NULL,
  `assunto` varchar(45) DEFAULT NULL,
  `autor` varchar(45) DEFAULT NULL,
  `estoque` int DEFAULT NULL,
  `editora_id` int NOT NULL,
  `categoria_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_livro_editoras_idx` (`editora_id`),
  KEY `categoria_id` (`categoria_id`),
  CONSTRAINT `fk_livro_editoras` FOREIGN KEY (`editora_id`) REFERENCES `editora` (`id`),
  CONSTRAINT `livro_ibfk_1` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `livro`
--

LOCK TABLES `livro` WRITE;
/*!40000 ALTER TABLE `livro` DISABLE KEYS */;
INSERT INTO `livro` VALUES (1,'Nas pegadas da alemoa','Assunto 1','Autor 1',10,1,1),(2,'Vade Mecum Saraiva 2022','Assunto 2','Autor 2',9,2,2),(3,'Mais esperto que o diabo','Assunto 3','Autor 3',13,3,3),(4,'O poder da autorresponsabilidade','Assunto 4','Autor 4',18,4,4),(5,'Mulheres que correm com os lobos','Assunto 5','Autor 5',5,5,6),(6,'É assim que acaba','Assunto 6','Autor 6',10,1,5),(7,'Os sete maridos de Evelyn Hugo','Assunto 7','Autor 7',15,2,7),(8,'Amor & gelato','Assunto 8','Autor 8',4,3,8),(9,'Demon Slayer: Kimetsu No Yaiba','Assunto 9','Autor 9',9,4,9),(10,'Os dois morrem no final','Assunto 10','Autor 10',1,5,9),(11,'O sol é para todos','assunto 11','autor 11',15,1,9),(12,'O poder do habito','assunto 12','autor 12',21,5,8),(13,'Vidas Secas','assunto 13','autor 13',8,2,7),(14,'O nome do vento','assunto 14','autor 14',12,4,5),(15,'A ultima flecha','assunto 15','autor 15',19,3,3),(16,'O ultimo homem','assunto 16','autor 16',20,3,1),(17,'O Leão, a Feiticeira e o Guarda-Roupa','Assunto 5','C. S. Lewis',15,1,3),(18,'O Código Da Vinci','Assunto 9','Dan Brown',14,1,8),(19,'Pense e Enriqueça','Assunto 5','Napoleon Hill',10,4,2),(20,'O Alquimista','Assunto 9','Paulo Coelho',5,3,3),(21,'Harry Potter e o Enigma do Príncipe','Assunto 8','J. K. Rowling',3,1,9),(22,'O Apanhador no Campo de Centeio ','Assunto 1','J. D. Salinger',13,1,8),(23,'Harry Potter e a Câmara Secreta','Assunto 9','J. K. Rowling',20,2,3),(24,'Harry Potter e o Prisioneiro de Azkaban','Assunto 6','J. K. Rowling',17,4,2),(25,'Harry Potter e o Cálice de Fogo','Assunto 1','J. K. Rowling',6,3,3),(26,'Harry Potter e a Ordem da Fênix','Assunto 6','J. K. Rowling',3,4,2),(27,'Harry Potter e as Relíquias da Morte','Assunto 8','J. K. Rowling',5,5,8),(28,'Cem Anos de Solidão','Assunto 4','Gabriel García Márquez',3,4,2),(29,'Lolita','Assunto 1','Vladimir Nabokov',15,2,7),(30,'Heidi','Assunto 3','Johanna Spyri',19,5,8),(31,'Meu Filho, Meu Tesouro','Assunto 4','Dr. Benjamin Spock',12,5,7),(32,'Anne of Green ','Assunto 7','Lucy Maud Montgomery',6,5,1),(33,'Beleza Negra','Assunto 3','Anna Sewell',14,3,1),(34,'O Nome da Rosa','Assunto 10','Umberto Eco',7,3,7),(35,'A Águia Pousou','Assunto 6','Jack Higgins',7,2,1),(36,'Era uma Vez em Watership Down','Assunto 2','Richard Adams',12,5,6),(37,'O Relatório Hite sobre sexualidade feminina','Assunto 1','Shere Hite',7,3,4),(38,'A Menina e o Porquinho','Assunto 8','Elwyn Brooks White',20,5,10),(39,'Um Safado em Dublin','Assunto 3','J. P. Donleavy',7,2,2),(40,'As Pontes de Madison','Assunto 3','Robert James Waller',3,2,10),(41,'Ben-Hur: Uma História dos Tempos de Cristo','Assunto 6','Lew Wallace',3,1,7),(42,'The Mark of Zorro','Assunto 6','Johnston McCulley',18,3,8);
/*!40000 ALTER TABLE `livro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venda`
--

DROP TABLE IF EXISTS `venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venda` (
  `id` int NOT NULL AUTO_INCREMENT,
  `livro_id` int NOT NULL,
  `cliente_id` int NOT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`,`livro_id`,`cliente_id`),
  KEY `fk_cliente_has_livro_livro1_idx` (`livro_id`),
  KEY `fk_cliente_has_livro_cliente1_idx` (`cliente_id`),
  CONSTRAINT `fk_cliente_has_livro_cliente1` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`),
  CONSTRAINT `fk_cliente_has_livro_livro1` FOREIGN KEY (`livro_id`) REFERENCES `livro` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=212 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venda`
--

LOCK TABLES `venda` WRITE;
/*!40000 ALTER TABLE `venda` DISABLE KEYS */;
INSERT INTO `venda` VALUES (1,1,84,'2022-06-20'),(204,32,84,'2022-05-03'),(205,40,84,'2022-05-03'),(206,8,81,'2022-05-03'),(207,8,80,'2022-05-03'),(208,4,84,'2022-05-04'),(209,2,81,'2022-05-05'),(210,7,80,'2022-05-05'),(211,3,84,'2022-05-09');
/*!40000 ALTER TABLE `venda` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-19 14:48:04
