-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 05, 2020 at 11:36 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `astronomy`
--

-- --------------------------------------------------------

--
-- Table structure for table `planets`
--

CREATE TABLE `planets` (
  `id` int(11) NOT NULL,
  `planet` varchar(255) DEFAULT NULL,
  `mass` double DEFAULT NULL,
  `distance` double DEFAULT NULL,
  `gforce` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `planets`
--

INSERT INTO `planets` (`id`, `planet`, `mass`, `distance`, `gforce`) VALUES
(1, 'Mercury', 3.3e23, 57.9, 1.306764474214073e40),
(2, 'Venus', 4.87e24, 108.2, 5.522235791612711e40),
(3, 'Earth', 5.98e24, 149.6, 3.5471414210622265e40),
(4, 'Mars', 6.42e23, 227.9, 1.6409180206710214e39),
(5, 'Jupiter', 1.9e27, 778.3, 4.163897659316688e41),
(6, 'Saturn', 5.69e26, 1427, 3.709409901985386e40),
(7, 'Uranus', 8.68e25, 2871, 1.39795710908676e39),
(8, 'Neptune', 1.02e26, 4497.1, 6.695385520686304e38);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `planets`
--
ALTER TABLE `planets`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `planets`
--
ALTER TABLE `planets`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
