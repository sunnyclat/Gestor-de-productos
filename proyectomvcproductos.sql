-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-06-2023 a las 19:05:32
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyectomvcproductos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `CODIGOARTICULO` varchar(10) NOT NULL,
  `NOMBREARTICULO` varchar(20) NOT NULL,
  `PRECIO` double NOT NULL,
  `IMPORTADO` varchar(10) NOT NULL,
  `fecha` date NOT NULL,
  `PAISORIGEN` varchar(15) NOT NULL,
  `SECCION` varchar(15) NOT NULL,
  `CODIGOSEG` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`CODIGOARTICULO`, `NOMBREARTICULO`, `PRECIO`, `IMPORTADO`, `fecha`, `PAISORIGEN`, `SECCION`, `CODIGOSEG`) VALUES
('ar56', 'remeras deportivas', 20, 'si', '0014-11-13', 'alemania', 'deportiva', '234df'),
('rt45', 'pantalones cowboy', 23, 'no', '0025-10-11', 'argentina', 'rareza', '45th');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
