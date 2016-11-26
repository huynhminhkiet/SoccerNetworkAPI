-- phpMyAdmin SQL Dump
-- version 4.0.10.12
-- http://www.phpmyadmin.net
--
-- Host: 127.8.108.2:3306
-- Generation Time: Nov 26, 2016 at 09:54 PM
-- Server version: 5.5.52
-- PHP Version: 5.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `soccernetworkapi`
--

-- --------------------------------------------------------

--
-- Table structure for table `city`
--

CREATE TABLE IF NOT EXISTS `city` (
  `city_id` int(11) NOT NULL AUTO_INCREMENT,
  `city_code` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `city_name` varchar(255) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`city_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=17 ;

--
-- Dumping data for table `city`
--

INSERT INTO `city` (`city_id`, `city_code`, `city_name`) VALUES
(2, 'asdasd2020ádas', 'ád'),
(12, 'A2020', 'Ha Noi'),
(13, '1023220', 'Vinh'),
(14, 'abc', '12312'),
(16, '123', '12312');

-- --------------------------------------------------------

--
-- Table structure for table `district`
--

CREATE TABLE IF NOT EXISTS `district` (
  `district_id` int(11) NOT NULL AUTO_INCREMENT,
  `district_code` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `district_name` varchar(255) CHARACTER SET utf8 NOT NULL,
  `city_id` int(11) NOT NULL,
  PRIMARY KEY (`district_id`),
  KEY `fk_district_c_idx` (`city_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=8 ;

--
-- Dumping data for table `district`
--

INSERT INTO `district` (`district_id`, `district_code`, `district_name`, `city_id`) VALUES
(2, 'DDDoo12321', 'Liên Chiểu', 14),
(7, '324', 'Thanh Khê', 12);

-- --------------------------------------------------------

--
-- Table structure for table `field`
--

CREATE TABLE IF NOT EXISTS `field` (
  `field_id` int(11) NOT NULL AUTO_INCREMENT,
  `field_name` varchar(255) CHARACTER SET utf8 NOT NULL,
  `district_id` int(11) NOT NULL,
  `address` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `phone_number` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`field_id`),
  KEY `fk_field__idx` (`district_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=6 ;

--
-- Dumping data for table `field`
--

INSERT INTO `field` (`field_id`, `field_name`, `district_id`, `address`, `latitude`, `longitude`, `phone_number`) VALUES
(4, 'adasdadsad', 2, 'q?eqw', 120120, 0, '01698624222'),
(5, '123', 2, '123', 120120, 0, '1231');

-- --------------------------------------------------------

--
-- Table structure for table `match`
--

CREATE TABLE IF NOT EXISTS `match` (
  `match_id` int(11) NOT NULL AUTO_INCREMENT,
  `field_id` int(11) NOT NULL,
  `host_id` int(11) NOT NULL,
  `status` int(11) DEFAULT NULL,
  `maximum_players` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `is_verified` bit(1) DEFAULT NULL,
  `verification_code` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`match_id`),
  KEY `fk_match_field_idx` (`field_id`),
  KEY `fk_match__idx` (`host_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=14 ;

--
-- Dumping data for table `match`
--

INSERT INTO `match` (`match_id`, `field_id`, `host_id`, `status`, `maximum_players`, `price`, `start_time`, `end_time`, `is_verified`, `verification_code`) VALUES
(11, 4, 17, 0, 10, 100000, '2016-11-25 12:47:37', '2016-11-25 18:47:00', b'1', 'Big'),
(12, 4, 17, 0, 10, 10000, '2016-11-29 12:50:45', '2016-11-29 18:30:00', b'1', 'Big'),
(13, 4, 17, 0, 11, 1, '2016-11-26 12:52:08', '2016-11-26 18:52:00', b'1', 'Big');

-- --------------------------------------------------------

--
-- Table structure for table `match_feedback`
--

CREATE TABLE IF NOT EXISTS `match_feedback` (
  `match_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `feedback` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `created_date` datetime DEFAULT NULL,
  PRIMARY KEY (`match_id`,`user_id`),
  KEY `fk_feedback_user_idx` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `rating`
--

CREATE TABLE IF NOT EXISTS `rating` (
  `user_rating_id` int(11) NOT NULL,
  `voter_id` int(11) NOT NULL,
  `rating` int(11) NOT NULL,
  PRIMARY KEY (`user_rating_id`,`voter_id`),
  KEY `fk_rating__idx` (`voter_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `slot`
--

CREATE TABLE IF NOT EXISTS `slot` (
  `match_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `is_verified` bit(1) DEFAULT NULL,
  `verification_code` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`match_id`,`user_id`),
  KEY `fk_slot__idx` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 NOT NULL,
  `email` varchar(255) CHARACTER SET utf8 NOT NULL,
  `phone_number` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `status` int(11) DEFAULT '0',
  `district_id` int(11) NOT NULL,
  `user_type` int(11) DEFAULT '0',
  `last_login` datetime DEFAULT NULL,
  `is_verified` bit(1) DEFAULT NULL,
  `verification_code` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=18 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `username`, `password`, `email`, `phone_number`, `status`, `district_id`, `user_type`, `last_login`, `is_verified`, `verification_code`) VALUES
(5, 'ntanh1061', '123456', 'tuananh@gmail.com', '0963158600', 0, 1, 0, '0032-05-08 06:07:45', b'0', ''),
(6, 'maria', '123456', 'a@gmail.com', '0963158600', 0, 1, 0, NULL, b'0', ''),
(7, 'ozawa', '123456', 'maria@gmail.com', '0999999999', 0, 1, 0, NULL, b'0', ''),
(11, 'anh', '123456', 'adasdasd@fadafsadfadsf', '123123123', 0, 1, 0, NULL, b'0', ''),
(12, 'a', '123435', 'a@ad', '124356789', 0, 3, 0, NULL, b'0', ''),
(17, 'anh', '123', 'a@gmail.com', '00000', 0, 2, 0, NULL, b'0', '');

-- --------------------------------------------------------

--
-- Table structure for table `user_rating`
--

CREATE TABLE IF NOT EXISTS `user_rating` (
  `user_rating_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`user_rating_id`),
  KEY `fk_user_rating_user_idx` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `district`
--
ALTER TABLE `district`
  ADD CONSTRAINT `fk_district_c` FOREIGN KEY (`city_id`) REFERENCES `city` (`city_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `field`
--
ALTER TABLE `field`
  ADD CONSTRAINT `fk_field_` FOREIGN KEY (`district_id`) REFERENCES `district` (`district_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `match`
--
ALTER TABLE `match`
  ADD CONSTRAINT `fk_match_` FOREIGN KEY (`host_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_match_field` FOREIGN KEY (`field_id`) REFERENCES `field` (`field_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `match_feedback`
--
ALTER TABLE `match_feedback`
  ADD CONSTRAINT `fk_feedback_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_match_feedback_match` FOREIGN KEY (`match_id`) REFERENCES `match` (`match_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `rating`
--
ALTER TABLE `rating`
  ADD CONSTRAINT `fk_rating_` FOREIGN KEY (`voter_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_rating_user_rating` FOREIGN KEY (`user_rating_id`) REFERENCES `user_rating` (`user_rating_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `slot`
--
ALTER TABLE `slot`
  ADD CONSTRAINT `fk_slot_match` FOREIGN KEY (`match_id`) REFERENCES `match` (`match_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_slot_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `user_rating`
--
ALTER TABLE `user_rating`
  ADD CONSTRAINT `fk_user_rating_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
