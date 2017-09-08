-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.7.17-log


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema dpf
--

CREATE DATABASE IF NOT EXISTS dpf;
USE dpf;

--
-- Definition of table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hibernate_sequence`
--

/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` (`next_val`) VALUES 
 (7),
 (7);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;


--
-- Definition of table `quality_range`
--

DROP TABLE IF EXISTS `quality_range`;
CREATE TABLE `quality_range` (
  `range_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `range_nm` varchar(45) NOT NULL,
  `range_short_nm` varchar(45) NOT NULL,
  `range_from` int(10) unsigned NOT NULL,
  `range_to` int(10) unsigned NOT NULL,
  `valid_ind` varchar(2) DEFAULT 'Y',
  PRIMARY KEY (`range_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='Quality range master';

--
-- Dumping data for table `quality_range`
--

/*!40000 ALTER TABLE `quality_range` DISABLE KEYS */;
INSERT INTO `quality_range` (`range_id`,`range_nm`,`range_short_nm`,`range_from`,`range_to`,`valid_ind`) VALUES 
 (1,'A++','A++',90,100,'Y'),
 (2,'A+','A+',75,90,'Y'),
 (3,'A','A',60,70,'Y'),
 (4,'A-','A-',55,60,'Y'),
 (5,'A--','A--',0,55,'Y');
/*!40000 ALTER TABLE `quality_range` ENABLE KEYS */;


--
-- Definition of table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `role`
--

/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`role_id`,`role`) VALUES 
 (1,'ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;


--
-- Definition of table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `active` int(11) DEFAULT NULL,
  `last_name` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`user_id`,`active`,`last_name`,`name`,`password`,`user_name`) VALUES 
 (4,1,'murari','murari','$2a$10$bz2hV1B5VhZfCgBkPpmisOEtjmp1R6/G6v2g9M3wJj3HzbP38gZU.','murari'),
 (5,1,'v','aruna','$2a$10$e0dRFyMMSypAKcPjlQ0CQOHm3NaWKy8Ok8gOt2GA3m1gyXTC1w3xi','aruna'),
 (6,1,'ammu','ammu','$2a$10$aeIe1ZsdgKgbsqD8.LBrgO5rIlZixItKtIz4HYJzx4o/Rs7n.vpM.','ammu');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


--
-- Definition of table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_role`
--

/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` (`user_id`,`role_id`) VALUES 
 (4,1),
 (5,1),
 (6,1);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
