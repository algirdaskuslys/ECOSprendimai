-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 12, 2021 at 01:57 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `task`
--

-- --------------------------------------------------------

--
-- Table structure for table `Categories`
--

CREATE TABLE `categories` (
  `id` int(11) NOT NULL,
  `lft` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rght` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Categories`
--

INSERT INTO `Categories` (`id`, `lft`, `name`, `rght`) VALUES
(1, 1, 'Home', 260),
(2, 2, 'Skydai', 27),
(3, 3, 'Lauko skydai', 4),
(4, 5, 'Vidaus skydai', 24),
(5, 6, 'Metalinės dėžės', 7),
(6, 8, 'Potinkiniai skydeliai', 13),
(7, 9, 'Metaliniai', 10),
(8, 11, 'Plastikiniai', 12),
(9, 14, 'Virštinkiniai skydeliai', 23),
(10, 15, 'Metaliniai', 16),
(11, 17, 'Plastikiniai', 22),
(12, 18, 'IP40', 19),
(13, 20, 'IP65', 21),
(14, 24, 'Remontiniai skydeliai', 25),
(15, 28, 'Apšvietimas', 77),
(16, 29, 'Lauko apšvietimas', 46),
(17, 30, 'Gatviniai šviestuvai', 31),
(18, 32, 'Lauko prožektoriai', 33),
(19, 34, 'Parkiniai šviestuvai', 35),
(20, 36, 'Atramos gembės', 43),
(21, 37, 'Atramos', 38),
(22, 39, 'Gembės', 40),
(23, 41, 'Pamatai', 42),
(24, 44, 'Priedai lauko apšvietimui', 45),
(25, 47, 'Vidaus apšvietimas', 76),
(26, 48, 'LED panelės 60x60', 49),
(27, 50, 'LED panelės', 55),
(28, 51, 'IP20', 52),
(29, 53, 'IP44', 54),
(30, 56, 'Downlight', 61),
(31, 57, 'IP20', 58),
(32, 59, 'IP44', 60),
(33, 62, 'Lubiniai IP65', 63),
(34, 64, 'Sieniniai', 69),
(35, 65, 'IP44', 66),
(36, 67, 'IP65', 68),
(37, 70, 'Pakabinami', 71),
(38, 72, 'Avarinis apšvietimas', 73),
(39, 74, 'High Bay', 75),
(40, 78, 'Kabeliai', 113),
(41, 79, 'Instaliaciniai kabeliai', 80),
(42, 81, 'Jėgos kabeliai', 86),
(43, 82, 'NYY-J', 83),
(44, 84, 'CYKY-J', 85),
(45, 87, 'Behalogeniniai kabeliai', 92),
(46, 88, 'Cca', 89),
(47, 90, 'B2ca', 91),
(48, 93, 'Kontroliniai kabeliai', 94),
(49, 95, 'Aliuminiai kabeliai', 96),
(50, 97, 'Laidai', 98),
(51, 99, 'Internetinai kabeliai', 112),
(52, 100, 'Cat5', 105),
(53, 101, 'UTP', 102),
(54, 103, 'FTP', 104),
(55, 106, 'Cat6', 111),
(56, 107, 'UTP', 108),
(57, 109, 'FTP', 110),
(58, 114, 'Vamzdžiai ir gofra', 149),
(59, 115, 'Lauko', 130),
(60, 116, 'APE', 117),
(61, 118, 'Gofros', 125),
(62, 119, '450N', 112),
(63, 121, '750N', 122),
(64, 123, '1250N', 124),
(65, 126, 'Prakalimo vamzdis', 127),
(66, 128, 'Sudedamas vazdis', 129),
(67, 131, 'Vidaus', 148),
(68, 132, 'Gofros', 137),
(69, 133, '320N', 134),
(70, 135, '750N', 136),
(71, 138, 'Behalogeninės gofros', 139),
(72, 140, 'Vamzdžiai', 141),
(73, 142, 'Behalogeniniai vamzdžiai', 143),
(74, 144, 'Gofros su kabeliu', 145),
(75, 146, 'Gofros su laidu', 147),
(76, 150, 'Instaliacinės prekės', 197),
(77, 151, 'Jungikliai ir kištukiniai lizdai', 158),
(78, 152, 'Potinkiniai jungikliai ir kištukiniai lizdai', 153),
(79, 154, 'Virštinkiniai jungikliai ir kištukiniai lizdai', 155),
(80, 156, 'Pramoniniai lizdai ir kištukai', 157),
(81, 159, 'Potinkinės dėžutės', 164),
(82, 160, 'Dėžutė į mūrą', 161),
(83, 162, 'Dėžutė į gipsą', 163),
(84, 165, 'Šildymo elementai', 172),
(85, 166, 'Šildymo kilimėliai', 167),
(86, 168, 'Šildymo kabeliai', 169),
(87, 170, 'Šildymo įranga', 171),
(88, 173, 'Judesio ir būvio jutikliai', 186),
(89, 174, 'Judesio', 179),
(90, 175, 'virštinkiniai', 176),
(91, 177, 'Potinkiniai', 178),
(92, 180, 'Būvio', 185),
(93, 181, 'virštinkiniai', 182),
(94, 183, 'Potinkiniai', 184),
(95, 187, 'Virštinkinės instaliacinės dėžutės', 188),
(96, 189, 'Grindinės dėžutės', 194),
(97, 190, 'Plastikinės', 191),
(98, 192, 'Metalinės', 193),
(99, 195, 'Modulinė 45x45 sistema', 196),
(100, 198, 'Metalinės konstrukcijos', 213),
(101, 199, 'Kopėčios', 204),
(102, 200, 'Karšto cinkavimo', 201),
(103, 202, 'Šalto cinkavimo', 203),
(104, 205, 'Loveliai', 210),
(105, 206, 'Karšto cinkavimo', 207),
(106, 208, 'Šalto cinkavimo', 209),
(107, 211, 'Apšvietimo lovelis', 212),
(108, 214, 'Įžeminimas ir žaibosauga', 237),
(109, 215, 'Įžeminimo strypai', 220),
(110, 216, 'Variuoti strypai', 217),
(111, 218, 'Cinkuoti strypai', 219),
(112, 221, 'Cinkuota juosta', 222),
(113, 223, 'Cinkuota viela', 224),
(114, 225, 'Jungtys', 226),
(115, 227, 'Laikikliai', 228),
(116, 229, 'Aktyvi žaibosauga', 230),
(117, 231, 'Pasyvi žaibosauga', 232),
(118, 233, 'Viršįtampio ribotuvai', 234),
(119, 235, 'Priedai', 236),
(120, 238, 'Elektromechanika', 259),
(121, 239, 'Automatiniai jungikliai', 244),
(122, 240, '6kA', 241),
(123, 242, '10kA', 243),
(124, 245, 'Relės', 246),
(125, 247, 'Kontaktoriai', 248),
(126, 249, 'Kirtikliai', 254),
(127, 250, 'Moduliniai', 251),
(128, 252, 'Paneliniai', 253),
(129, 255, 'Moduliniai jungikliai', 256),
(130, 257, 'Saugikliai', 258);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Categories`
--
ALTER TABLE `Categories`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
