-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-03-2022 a las 20:24:20
-- Versión del servidor: 10.4.17-MariaDB
-- Versión de PHP: 7.4.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `puntoventanube`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `area`
--

CREATE TABLE `area` (
  `id_area` int(11) NOT NULL,
  `estatus_area` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `id_sucursal` int(11) DEFAULT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `propietario` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `area`
--

INSERT INTO `area` (`id_area`, `estatus_area`, `id_sucursal`, `nombre`, `propietario`) VALUES
(1, 'vigente', 1, 'ALPESUR', 'Jely'),
(2, 'vigente', 1, 'NOGAL', 'Jely'),
(3, 'vigente', 1, 'PURINA', 'Jely'),
(4, 'vigente', 1, 'CAMPI', 'Jely'),
(5, 'vigente', 1, 'MALTA', 'Jely'),
(6, 'vigente', 1, 'NUPEC', 'Jely'),
(7, 'vigente', 1, 'PROPLAN', 'Jely');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id_cliente` int(11) NOT NULL,
  `direccion` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `eliminado` bit(1) NOT NULL,
  `email` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `estatus_cliente` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `id_sucursal` int(11) DEFAULT NULL,
  `limite_credito` int(11) NOT NULL,
  `mayorista` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `propietario` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `rfc` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `telefono` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `credito`
--

CREATE TABLE `credito` (
  `id_credito` int(11) NOT NULL,
  `abonado` float NOT NULL,
  `fecha` datetime(6) DEFAULT NULL,
  `fecha_venta` datetime(6) DEFAULT NULL,
  `finalizado` bit(1) NOT NULL,
  `id_cliente` int(11) DEFAULT NULL,
  `id_sucursal` int(11) DEFAULT NULL,
  `id_ticket` int(11) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `monto` float NOT NULL,
  `propietario` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movimientos_extras`
--

CREATE TABLE `movimientos_extras` (
  `id_movimiento` int(11) NOT NULL,
  `descripcion` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `fecha` datetime(6) DEFAULT NULL,
  `id_sucursal` int(11) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `monto` float NOT NULL,
  `propietario` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `revisado` bit(1) NOT NULL,
  `tipo` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movimientos_inv`
--

CREATE TABLE `movimientos_inv` (
  `id_movimiento_inv` int(11) NOT NULL,
  `cantidad` float NOT NULL,
  `departamento` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `descripcion` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `fecha` datetime(6) DEFAULT NULL,
  `habia` float NOT NULL,
  `hay` float NOT NULL,
  `id_sucursal` int(11) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `propietario` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `tipo_movimiento` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `movimientos_inv`
--

INSERT INTO `movimientos_inv` (`id_movimiento_inv`, `cantidad`, `departamento`, `descripcion`, `fecha`, `habia`, `hay`, `id_sucursal`, `id_usuario`, `nombre`, `propietario`, `tipo_movimiento`) VALUES
(1, 0, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:21.000000', 0, 0, 1, 0, 'ALPET ADULTO 25KG', 'Jely', 'Entrada'),
(2, 1, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:21.000000', 0, 1, 1, 0, 'ALPET ADULTO 2KG', 'Jely', 'Entrada'),
(3, 0, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:21.000000', 0, 0, 1, 0, 'ALPET ADULTO 8KG', 'Jely', 'Entrada'),
(4, 3, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:21.000000', 0, 3, 1, 0, 'ALPET CACHORRO 2KG', 'Jely', 'Entrada'),
(5, 1, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:21.000000', 0, 1, 1, 0, 'ALPET CACHORRO 8KG', 'Jely', 'Entrada'),
(6, 2, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:21.000000', 0, 2, 1, 0, 'ARENA TIDY CATS 4.54KG', 'Jely', 'Entrada'),
(7, 5, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:21.000000', 0, 5, 1, 0, 'AUDAZ 1KG', 'Jely', 'Entrada'),
(8, 0, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:21.000000', 0, 0, 1, 0, 'AUDAZ 25KG', 'Jely', 'Entrada'),
(9, 1, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:21.000000', 0, 1, 1, 0, 'BENEFUL MINIS SALMON 10KG', 'Jely', 'Entrada'),
(10, 0, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:21.000000', 0, 0, 1, 0, 'BERISCAN CACHORRO 1/2KG', 'Jely', 'Entrada'),
(11, 6, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:21.000000', 0, 6, 1, 0, 'BERISCAN CACHORRO 20kg', 'Jely', 'Entrada'),
(12, 7, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:21.000000', 0, 7, 1, 0, 'BERISCAN PRO 1KG', 'Jely', 'Entrada'),
(13, 10, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:21.000000', 0, 10, 1, 0, 'BERISCAN PRO 25KG', 'Jely', 'Entrada'),
(14, 1, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:21.000000', 0, 1, 1, 0, 'BERISCAT 1/2KG', 'Jely', 'Entrada'),
(15, 15, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:21.000000', 0, 15, 1, 0, 'BERISCAT 15KG', 'Jely', 'Entrada'),
(16, 2, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:21.000000', 0, 2, 1, 0, 'BLOCK DE SAL ', 'Jely', 'Entrada'),
(17, 0, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:21.000000', 0, 0, 1, 0, 'BORREGO 13%', 'Jely', 'Entrada'),
(18, 0.5, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:21.000000', 0, 0.5, 1, 0, 'BORREGO CRECIMIENTO 16%', 'Jely', 'Entrada'),
(19, 3, 'NOGAL', 'Nuevo producto', '2022-03-03 13:16:21.000000', 0, 3, 1, 0, 'CABALLO FIEL', 'Jely', 'Entrada'),
(20, 19, 'NOGAL', 'Nuevo producto', '2022-03-03 13:16:21.000000', 0, 19, 1, 0, 'CABALLO FIEL D MANZANA 40KG', 'Jely', 'Entrada'),
(21, 8, 'NOGAL', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 8, 1, 0, 'CABALLO FIEL PLUS', 'Jely', 'Entrada'),
(22, 20, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 20, 1, 0, 'CAMPEON 1KG', 'Jely', 'Entrada'),
(23, 0, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 0, 1, 0, 'CAMPEON ADULTO 25KG', 'Jely', 'Entrada'),
(24, 2, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 2, 1, 0, 'CAMPEON CACHORRO 1/2KG', 'Jely', 'Entrada'),
(25, 0, 'PURINA', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 0, 1, 0, 'CAMPEON CACHORRO 20KG', 'Jely', 'Entrada'),
(26, 9, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 9, 1, 0, 'CAMPICAN 25KG', 'Jely', 'Entrada'),
(27, 0, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 0, 1, 0, 'CAMPIDOG 25KG', 'Jely', 'Entrada'),
(28, 1, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 1, 1, 0, 'CASA CHICA PERRO', 'Jely', 'Entrada'),
(29, 1, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 1, 1, 0, 'CASA GRANDE PERRO', 'Jely', 'Entrada'),
(30, 4, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 4, 1, 0, 'CAT CHOW DELICIAS 20KG', 'Jely', 'Entrada'),
(31, 7, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 7, 1, 0, 'CAT CHOW GATITOS 1.5KG', 'Jely', 'Entrada'),
(32, 8.5, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 8.5, 1, 0, 'CAZADOR 1KG', 'Jely', 'Entrada'),
(33, 1, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 1, 1, 0, 'CAZADOR CACHORRO 20KG', 'Jely', 'Entrada'),
(34, 0, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 0, 1, 0, 'CAZADOR ECO 25KG', 'Jely', 'Entrada'),
(35, 37, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 37, 1, 0, 'CONEJO 1KG', 'Jely', 'Entrada'),
(36, 1, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 1, 1, 0, 'CONEJO 5KG', 'Jely', 'Entrada'),
(37, 0, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 0, 1, 0, 'CONEJO ALPESUR 40KG', 'Jely', 'Entrada'),
(38, 2, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 2, 1, 0, 'CRECIMIENTO ALTA 40KG', 'Jely', 'Entrada'),
(39, 1, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 1, 1, 0, 'CRECIMIENTO C', 'Jely', 'Entrada'),
(40, 13, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 13, 1, 0, 'CRECIMIENTO CERDO T', 'Jely', 'Entrada'),
(41, 19, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 19, 1, 0, 'CRECIMIENTO CERDO T 5 KG', 'Jely', 'Entrada'),
(42, 44, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 44, 1, 0, 'CRECIMIENTO GA 40KG', 'Jely', 'Entrada'),
(43, 9, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 9, 1, 0, 'CRIANZA POLLITA 40KG', 'Jely', 'Entrada'),
(44, 0, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 0, 1, 0, 'DESARROLLO C CERDOS 40 KG', 'Jely', 'Entrada'),
(45, 0, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 0, 1, 0, 'DESARROLLO GA 40KG', 'Jely', 'Entrada'),
(46, 0, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 0, 1, 0, 'DOG CHOW ADULTO 25KG RAZAS GRANDES', 'Jely', 'Entrada'),
(47, 3, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 3, 1, 0, 'DOG CHOW ADULTO 25KG RAZAS PEQUEÑAS', 'Jely', 'Entrada'),
(48, 12, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 12, 1, 0, 'DOG CHOW ADULTO RAZAS PEQUEÑAS 1KG', 'Jely', 'Entrada'),
(49, 52, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 52, 1, 0, 'DOG CHOW CACHORRO 1/2KG', 'Jely', 'Entrada'),
(50, 4, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 4, 1, 0, 'DOG CHOW CACHORRO 20KG', 'Jely', 'Entrada'),
(51, 0, 'CAMPI', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 0, 1, 0, 'DON-CAN 25KG', 'Jely', 'Entrada'),
(52, 21, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 21, 1, 0, 'DYNO 1KG', 'Jely', 'Entrada'),
(53, 11, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 11, 1, 0, 'DYNO 25KG', 'Jely', 'Entrada'),
(54, 39, 'NOGAL', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 39, 1, 0, 'ECONOMICO INTEGRAL 40KG', 'Jely', 'Entrada'),
(55, 0, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 0, 1, 0, 'ENGORDA ALTA 40KG', 'Jely', 'Entrada'),
(56, 24, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 24, 1, 0, 'ENGORDA C', 'Jely', 'Entrada'),
(57, 19, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 19, 1, 0, 'ENGORDA FINAL CERDO T', 'Jely', 'Entrada'),
(58, 18, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 18, 1, 0, 'ENGORDA FINAL CERDOS T 5 KG', 'Jely', 'Entrada'),
(59, 15, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 15, 1, 0, 'ENGORDA GA 40KG', 'Jely', 'Entrada'),
(60, 0, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 0, 1, 0, 'ENGORDA GANADO RELAMPAGO PLUS 18%', 'Jely', 'Entrada'),
(61, 8, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 8, 1, 0, 'ENGORDA MIX ROLADO 14%', 'Jely', 'Entrada'),
(62, 0, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 0, 1, 0, 'ESTAMPIDA CLASICO 13%', 'Jely', 'Entrada'),
(63, 13, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 13, 1, 0, 'ESTAMPIDA TRABAJO', 'Jely', 'Entrada'),
(64, 11, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 11, 1, 0, 'FELIX 1/2KG', 'Jely', 'Entrada'),
(65, 2, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 2, 1, 0, 'FELIX 10KG', 'Jely', 'Entrada'),
(66, 9, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 9, 1, 0, 'FELIX LATA 156G', 'Jely', 'Entrada'),
(67, 23, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 23, 1, 0, 'FINALIZADOR PAVOS 5KG', 'Jely', 'Entrada'),
(68, 17, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 17, 1, 0, 'FRENCHYS CAT 1/2KG', 'Jely', 'Entrada'),
(69, 54, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 54, 1, 0, 'GALLO MANTENIMIENTO 5 KG', 'Jely', 'Entrada'),
(70, 0, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 0, 1, 0, 'GALLOS COMBATE 40KG', 'Jely', 'Entrada'),
(71, 6, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 6, 1, 0, 'GALLOS COMBATE 5KG', 'Jely', 'Entrada'),
(72, 0, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 0, 1, 0, 'GALLOS MANTENIMIENTOS 40KG', 'Jely', 'Entrada'),
(73, 1, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 1, 1, 0, 'GANADOR ADULTO 25KG ', 'Jely', 'Entrada'),
(74, 1, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 1, 1, 0, 'GANADOR ADULTO RAZAS PEQ 20KG', 'Jely', 'Entrada'),
(75, 0, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 0, 1, 0, 'GANADOR CACHORRO 20KG ', 'Jely', 'Entrada'),
(76, 2, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:22.000000', 0, 2, 1, 0, 'GANADOR DUO 4KG', 'Jely', 'Entrada'),
(77, 2, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 2, 1, 0, 'GANADOR PREM ADUL RZA PEQ 4 KG', 'Jely', 'Entrada'),
(78, 3, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 3, 1, 0, 'GANADOR PREM ADULTO RZA MD Y GDE 4KG', 'Jely', 'Entrada'),
(79, 0, 'MALTA', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 0, 1, 0, 'GANADOR PREMIUM ADULTO RAZAS MEDIANAS Y GD', 'Jely', 'Entrada'),
(80, 2, 'MALTA', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 2, 1, 0, 'GANADOR PREMIUM ADULTO RP 20KG', 'Jely', 'Entrada'),
(81, 18, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 18, 1, 0, 'GANADOR PREMIUM ADULTO RZ MD Y GD 1 KG ', 'Jely', 'Entrada'),
(82, 0, 'MALTA', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 0, 1, 0, 'GANADOR PREMIUM CACHORRO 20KG RAZAS MED Y GDE', 'Jely', 'Entrada'),
(83, 3, 'MALTA', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 3, 1, 0, 'GANADOR PREMIUM CACHORRO 20KG RAZAS PEQ', 'Jely', 'Entrada'),
(84, 41, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 41, 1, 0, 'GANADOR PREMIUM CACHORRO RZ PEQUEÑAS 1/2 KG ', 'Jely', 'Entrada'),
(85, 8, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 8, 1, 0, 'GANANDOR ADULTO RZ PEQUEÑAS 1 KG ', 'Jely', 'Entrada'),
(86, 17, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 17, 1, 0, 'GATINA 1/2KG', 'Jely', 'Entrada'),
(87, 0, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 0, 1, 0, 'GATINA 15KG', 'Jely', 'Entrada'),
(88, 22, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 22, 1, 0, 'HOBIPET 1KG', 'Jely', 'Entrada'),
(89, 8, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 8, 1, 0, 'HOBIPET 25KG', 'Jely', 'Entrada'),
(90, 3, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 3, 1, 0, 'HOBIPET TOTAL 25KG', 'Jely', 'Entrada'),
(91, 9, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 9, 1, 0, 'INIACIADOR GA 40KG', 'Jely', 'Entrada'),
(92, 17, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 17, 1, 0, 'INICIADOR CERDOS C', 'Jely', 'Entrada'),
(93, 13, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 13, 1, 0, 'INICIADOR PAVOS 5KG', 'Jely', 'Entrada'),
(94, 0, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 0, 1, 0, 'INICIADOR POLLO  T 5KG', 'Jely', 'Entrada'),
(95, 3, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 3, 1, 0, 'INICIADOR POLLO T', 'Jely', 'Entrada'),
(96, 18, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 18, 1, 0, 'INICIADOR POLLO T 1KG', 'Jely', 'Entrada'),
(97, 21, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 21, 1, 0, 'KATTOS 1/2KG', 'Jely', 'Entrada'),
(98, 16, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 16, 1, 0, 'KATTOS 15KG', 'Jely', 'Entrada'),
(99, 0, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 0, 1, 0, 'LINEA AVES ABC', 'Jely', 'Entrada'),
(100, 11, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 11, 1, 0, 'LINEA AVES ABC 5KG', 'Jely', 'Entrada'),
(101, 8, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 8, 1, 0, 'Lecheros 20% Tropico', 'Jely', 'Entrada'),
(102, 0, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 0, 1, 0, 'MAIZ AMARILLO 40KG', 'Jely', 'Entrada'),
(103, 8, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 8, 1, 0, 'MAIZ ENTERO 1KG', 'Jely', 'Entrada'),
(104, 0, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 0, 1, 0, 'MAIZ QUEBRADO 1KG', 'Jely', 'Entrada'),
(105, 12, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 12, 1, 0, 'MAIZ QUEBRADO 40kg', 'Jely', 'Entrada'),
(106, 42, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 42, 1, 0, 'MAIZ QUEBRADO 5KG', 'Jely', 'Entrada'),
(107, 2, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 2, 1, 0, 'MAIZ QUEBRADO NU3', 'Jely', 'Entrada'),
(108, 10, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 10, 1, 0, 'MININO 1/2KG', 'Jely', 'Entrada'),
(109, 6, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 6, 1, 0, 'MININO 15KG', 'Jely', 'Entrada'),
(110, 0, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 0, 1, 0, 'MININO PLUS 10KG', 'Jely', 'Entrada'),
(111, 3, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 3, 1, 0, 'MONTANA MULTIPARTICULA', 'Jely', 'Entrada'),
(112, 15, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 15, 1, 0, 'NUCAN ADULTO 1.8KG', 'Jely', 'Entrada'),
(113, 1, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 1, 1, 0, 'NUCAN ADULTO 1KG', 'Jely', 'Entrada'),
(114, 4, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 4, 1, 0, 'NUCAN ADULTO 25KG', 'Jely', 'Entrada'),
(115, 28, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 28, 1, 0, 'NUCAN CACHORRO 1.8KG', 'Jely', 'Entrada'),
(116, 4, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 4, 1, 0, 'NUCAN CACHORRO 20KG', 'Jely', 'Entrada'),
(117, 0, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 0, 1, 0, 'NUCAT', 'Jely', 'Entrada'),
(118, 3, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 3, 1, 0, 'NUCAT 1.8KG', 'Jely', 'Entrada'),
(119, 21, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 21, 1, 0, 'NUCAT 1/2KG', 'Jely', 'Entrada'),
(120, 0, 'NUPEC', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 0, 1, 0, 'NUPEC ADULTO 15KG', 'Jely', 'Entrada'),
(121, 3, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 3, 1, 0, 'NUPEC ADULTO 2KG', 'Jely', 'Entrada'),
(122, 1, 'NUPEC', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 1, 1, 0, 'NUPEC CACHORRO 15KG', 'Jely', 'Entrada'),
(123, 0, 'NUPEC', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 0, 1, 0, 'NUPEC CACHORRO 2KG', 'Jely', 'Entrada'),
(124, 0, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 0, 1, 0, 'NUPEC CACHORRO RAZAS PEQUEÑAS 8KG', 'Jely', 'Entrada'),
(125, 1, 'NUPEC', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 1, 1, 0, 'NUPEC FELINO KITTEN 1.5KG', 'Jely', 'Entrada'),
(126, 1, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 1, 1, 0, 'NUPIG 1 BETA ', 'Jely', 'Entrada'),
(127, 7, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 7, 1, 0, 'NUPIG CUATRO ALFA 40KG', 'Jely', 'Entrada'),
(128, 31, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 31, 1, 0, 'NUPIG CUATRO GAMA 1KG', 'Jely', 'Entrada'),
(129, 16, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 16, 1, 0, 'NUPIG DOS ALFA', 'Jely', 'Entrada'),
(130, 44, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 44, 1, 0, 'NUPIG DOS ALFA 1KG', 'Jely', 'Entrada'),
(131, 10, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 10, 1, 0, 'NUPIG TRES ALFA', 'Jely', 'Entrada'),
(132, 19, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 19, 1, 0, 'NUPIG TRES ALFA 1KG', 'Jely', 'Entrada'),
(133, 9, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 9, 1, 0, 'NUPIG UNO OMEGA', 'Jely', 'Entrada'),
(134, 38, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 38, 1, 0, 'NUPIG UNO OMEGA 1KG', 'Jely', 'Entrada'),
(135, 0, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 0, 1, 0, 'NUTRESCAN 22KG', 'Jely', 'Entrada'),
(136, 10, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 10, 1, 0, 'NUTRESCAT 15KG', 'Jely', 'Entrada'),
(137, 6, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 6, 1, 0, 'NUTRIMASCOTAS ADULTO 1KG', 'Jely', 'Entrada'),
(138, 10, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 10, 1, 0, 'NUTRIMASCOTAS ADULTO 20kg', 'Jely', 'Entrada'),
(139, 6, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 6, 1, 0, 'NUTRIMASCOTAS ADULTO 5KG', 'Jely', 'Entrada'),
(140, 19, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 19, 1, 0, 'NUTRIMASCOTAS CACHORRO 1/2KG', 'Jely', 'Entrada'),
(141, 2, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 2, 1, 0, 'NUTRIMASCOTAS CACHORRO 20kg', 'Jely', 'Entrada'),
(142, 7, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 7, 1, 0, 'NUTRIMASCOTAS CACHORRO 5KG', 'Jely', 'Entrada'),
(143, 6, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 6, 1, 0, 'OPTIMO ADULTO 1KG', 'Jely', 'Entrada'),
(144, 4, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 4, 1, 0, 'OPTIMO ADULTO 25KG', 'Jely', 'Entrada'),
(145, 6, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 6, 1, 0, 'OPTIMO ADULTO 2KG', 'Jely', 'Entrada'),
(146, 4, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 4, 1, 0, 'OPTIMO ADULTO 4KG', 'Jely', 'Entrada'),
(147, 4, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 4, 1, 0, 'OPTIMO CACHORRO 20kg', 'Jely', 'Entrada'),
(148, 7, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:23.000000', 0, 7, 1, 0, 'OPTIMO CACHORRO 2KG', 'Jely', 'Entrada'),
(149, 5, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:24.000000', 0, 5, 1, 0, 'OPTIMO CACHORRO 4KG', 'Jely', 'Entrada'),
(150, 0, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:24.000000', 0, 0, 1, 0, 'OPTIMO FELINO 1.5KG', 'Jely', 'Entrada'),
(151, 0, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:24.000000', 0, 0, 1, 0, 'OPTIMO FELINO 20k', 'Jely', 'Entrada'),
(152, 34, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:24.000000', 0, 34, 1, 0, 'PODER CANINO 1KG', 'Jely', 'Entrada'),
(153, 3, 'MALTA', 'Nuevo producto', '2022-03-03 13:16:24.000000', 0, 3, 1, 0, 'PODER CANINO 25KG', 'Jely', 'Entrada'),
(154, 10, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:24.000000', 0, 10, 1, 0, 'POSTURA 16%', 'Jely', 'Entrada'),
(155, 24, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:24.000000', 0, 24, 1, 0, 'POSTURA 5KG', 'Jely', 'Entrada'),
(156, 1, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:24.000000', 0, 1, 1, 0, 'PRO PLAN ADULTO OPTIHEALT 13KG', 'Jely', 'Entrada'),
(157, 2, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:24.000000', 0, 2, 1, 0, 'PRO PLAN CACH SENSITIVE 13KG', 'Jely', 'Entrada'),
(158, 0, 'PROPLAN', 'Nuevo producto', '2022-03-03 13:16:24.000000', 0, 0, 1, 0, 'PROPLAN PUPPY OPTISTART 13KG', 'Jely', 'Entrada'),
(159, 1, 'PROPLAN', 'Nuevo producto', '2022-03-03 13:16:24.000000', 0, 1, 1, 0, 'PROPLAN SENSITIVE ADULTO 13KG', 'Jely', 'Entrada'),
(160, 3, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:24.000000', 0, 3, 1, 0, 'RACTOPAMINA 10%', 'Jely', 'Entrada'),
(161, 0, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:24.000000', 0, 0, 1, 0, 'RENDIPOLLO 40KG', 'Jely', 'Entrada'),
(162, 2, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:24.000000', 0, 2, 1, 0, 'REPRODUCTORA C', 'Jely', 'Entrada'),
(163, 7, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:24.000000', 0, 7, 1, 0, 'REPRODUCTORA GA 40KG', 'Jely', 'Entrada'),
(164, 18, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:24.000000', 0, 18, 1, 0, 'REPRODUCTORA LACTANCIA C', 'Jely', 'Entrada'),
(165, 10, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:24.000000', 0, 10, 1, 0, 'REPRODUCTORA LACTANCIA G.A', 'Jely', 'Entrada'),
(166, 7, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:24.000000', 0, 7, 1, 0, 'ROCKO PLUS 1KG', 'Jely', 'Entrada'),
(167, 2, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:24.000000', 0, 2, 1, 0, 'ROCKO PLUS 25KG PERRO ADULTO', 'Jely', 'Entrada'),
(168, 10, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:24.000000', 0, 10, 1, 0, 'SAL MINERAL 1KG', 'Jely', 'Entrada'),
(169, 0, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:24.000000', 0, 0, 1, 0, 'SAL MINERAL BOVINO 20KG', 'Jely', 'Entrada'),
(170, 0, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:24.000000', 0, 0, 1, 0, 'SALVADO 40KG', 'Jely', 'Entrada'),
(171, 9, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:24.000000', 0, 9, 1, 0, 'SOBRE DE FELIX 85G', 'Jely', 'Entrada'),
(172, 1333, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:24.000000', 0, 1333, 1, 0, 'SOBRES DE CAMPI', 'Jely', 'Entrada'),
(173, 0, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:24.000000', 0, 0, 1, 0, 'SOBRES PURINA', 'Jely', 'Entrada'),
(174, 20, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:24.000000', 0, 20, 1, 0, 'SUPERCACHORRO 22KG', 'Jely', 'Entrada'),
(175, 0, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:24.000000', 0, 0, 1, 0, 'SUPERCAN AZUL 25KG', 'Jely', 'Entrada'),
(176, 15, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:24.000000', 0, 15, 1, 0, 'SUPERCAN FEROZ ', 'Jely', 'Entrada'),
(177, 4, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:24.000000', 0, 4, 1, 0, 'SUPERCAN MAX 22KG', 'Jely', 'Entrada'),
(178, 2, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:24.000000', 0, 2, 1, 0, 'SUPERCAN MESTIZO ', 'Jely', 'Entrada'),
(179, 1, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:24.000000', 0, 1, 1, 0, 'SUSTITUTO DE LECHE NUTRILAC 5KG', 'Jely', 'Entrada'),
(180, 13, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:24.000000', 0, 13, 1, 0, 'TERMINADOR POLLO FASE IV', 'Jely', 'Entrada'),
(181, 0, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:24.000000', 0, 0, 1, 0, 'TERMINADOR POLLO T', 'Jely', 'Entrada'),
(182, 7, 'Alpesur', 'Nuevo producto', '2022-03-03 13:16:24.000000', 0, 7, 1, 0, 'TILAPIA 2 1KG', 'Jely', 'Entrada'),
(183, 2, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:24.000000', 0, 2, 1, 0, 'TILAPIA VIMIFOS Crec 3205 25KG', 'Jely', 'Entrada'),
(184, 8, 'MALTA', 'Nuevo producto', '2022-03-03 13:16:24.000000', 0, 8, 1, 0, 'TILAPIA Vimifos ENGORDA 25KG', 'Jely', 'Entrada'),
(185, 26, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:24.000000', 0, 26, 1, 0, 'TITAN 1KG', 'Jely', 'Entrada'),
(186, 2, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:24.000000', 0, 2, 1, 0, 'TITAN 25KG PERRO ADULTO', 'Jely', 'Entrada'),
(187, 15, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:24.000000', 0, 15, 1, 0, 'TITAN GATO 1/2KG', 'Jely', 'Entrada'),
(188, 0, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:24.000000', 0, 0, 1, 0, 'TITAN GATO 15KG', 'Jely', 'Entrada'),
(189, 0, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:24.000000', 0, 0, 1, 0, 'TOP CHOICE 25KG', 'Jely', 'Entrada'),
(190, 37, 'NOGAL', 'Nuevo producto', '2022-03-03 13:16:24.000000', 0, 37, 1, 0, 'VICENTINA 1 25KG', 'Jely', 'Entrada'),
(191, 6, 'NOGAL', 'Nuevo producto', '2022-03-03 13:16:24.000000', 0, 6, 1, 0, 'VICENTINA 2 20KG', 'Jely', 'Entrada'),
(192, 4, 'NOGAL', 'Nuevo producto', '2022-03-03 13:16:24.000000', 0, 4, 1, 0, 'VICENTINA 3 15KG', 'Jely', 'Entrada'),
(193, 3, 'NOGAL', 'Nuevo producto', '2022-03-03 13:16:24.000000', 0, 3, 1, 0, 'VICENTINA 4 25KG', 'Jely', 'Entrada'),
(194, 16, 'NOGAL', 'Nuevo producto', '2022-03-03 13:16:24.000000', 0, 16, 1, 0, 'VICENTINA 5 25KG', 'Jely', 'Entrada'),
(195, 0, 'NOGAL', 'Nuevo producto', '2022-03-03 13:16:24.000000', 0, 0, 1, 0, 'VICENTINA 8 PAP 25KG', 'Jely', 'Entrada'),
(196, 20, 'NOGAL', 'Nuevo producto', '2022-03-03 13:16:24.000000', 0, 20, 1, 0, 'VICENTINA7 NC 20KG', 'Jely', 'Entrada'),
(197, 98, '- Sin Departamento -', 'Nuevo producto', '2022-03-03 13:16:24.000000', 0, 98, 1, 0, 'Producto para realizar pruebas', 'Jely', 'Entrada');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id_producto` int(11) NOT NULL,
  `area` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `cantidad` float NOT NULL,
  `codigo` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `descripcion` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `eliminado` bit(1) NOT NULL,
  `id_sucursal` int(11) DEFAULT NULL,
  `idusuario` int(11) DEFAULT NULL,
  `inventario_minimo` int(11) NOT NULL,
  `precio_costo` float NOT NULL,
  `precio_distribuidor` float NOT NULL,
  `precio_mayoreo` float NOT NULL,
  `precio_venta` float NOT NULL,
  `propietario` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id_producto`, `area`, `cantidad`, `codigo`, `descripcion`, `eliminado`, `id_sucursal`, `idusuario`, `inventario_minimo`, `precio_costo`, `precio_distribuidor`, `precio_mayoreo`, `precio_venta`, `propietario`) VALUES
(1, '- Sin Departamento -', 0, '84339', 'ALPET ADULTO 25KG', b'0', 1, 0, 0, 605.12, 0, 648, 720, 'Jely'),
(2, '- Sin Departamento -', 1, '84337', 'ALPET ADULTO 2KG', b'0', 1, 0, 0, 55.74, 0, 66, 76, 'Jely'),
(3, '- Sin Departamento -', 0, '84338', 'ALPET ADULTO 8KG', b'0', 1, 0, 0, 207.77, 0, 240, 250, 'Jely'),
(4, '- Sin Departamento -', 3, '84334', 'ALPET CACHORRO 2KG', b'0', 1, 0, 0, 70.35, 0, 79, 85, 'Jely'),
(5, '- Sin Departamento -', 1, '84335', 'ALPET CACHORRO 8KG', b'0', 1, 0, 0, 267.04, 0, 305, 315, 'Jely'),
(6, '- Sin Departamento -', 2, '87', 'ARENA TIDY CATS 4.54KG', b'0', 1, 0, 0, 69.36, 0, 87, 90, 'Jely'),
(7, 'ALPESUR', 5, '65', 'AUDAZ 1KG', b'0', 1, 0, 5, 18.73, 0, 22, 23, 'Jely'),
(8, 'ALPESUR', 0, '96268', 'AUDAZ 25KG', b'0', 1, 0, 5, 468.42, 0, 503, 520, 'Jely'),
(9, '- Sin Departamento -', 1, '9885', 'BENEFUL MINIS SALMON 10KG', b'0', 1, 0, 0, 448.68, 0, 474, 479, 'Jely'),
(10, 'ALPESUR', 0, '55', 'BERISCAN CACHORRO 1/2KG', b'0', 1, 0, 5, 14.07, 0, 17, 18, 'Jely'),
(11, 'ALPESUR', 6, '53', 'BERISCAN CACHORRO 20kg', b'0', 1, 0, 5, 540, 0, 580, 585, 'Jely'),
(12, 'ALPESUR', 7, '16', 'BERISCAN PRO 1KG', b'0', 1, 0, 5, 19.16, 0, 23, 24, 'Jely'),
(13, 'ALPESUR', 10, '15', 'BERISCAN PRO 25KG', b'0', 1, 0, 5, 485, 0, 525, 535, 'Jely'),
(14, '- Sin Departamento -', 1, '69A', 'BERISCAT 1/2KG', b'0', 1, 0, 0, 15.16, 0, 19, 19, 'Jely'),
(15, '- Sin Departamento -', 15, '69', 'BERISCAT 15KG', b'0', 1, 0, 0, 440, 0, 470, 475, 'Jely'),
(16, '- Sin Departamento -', 2, '79138', 'BLOCK DE SAL ', b'0', 1, 0, 0, 80.9, 0, 110, 115, 'Jely'),
(17, 'ALPESUR', 0, '77643', 'BORREGO 13%', b'0', 1, 0, 5, 304.59, 0, 340, 345, 'Jely'),
(18, 'ALPESUR', 0.5, '68533', 'BORREGO CRECIMIENTO 16%', b'0', 1, 0, 5, 323.66, 0, 364, 374, 'Jely'),
(19, 'NOGAL', 3, 'NOGAL3', 'CABALLO FIEL', b'0', 1, 0, 0, 387.9, 0, 413, 418, 'Jely'),
(20, 'NOGAL', 19, 'NOGAL1', 'CABALLO FIEL D MANZANA 40KG', b'0', 1, 0, 0, 429.9, 0, 454, 459, 'Jely'),
(21, 'NOGAL', 8, 'NOGAL2', 'CABALLO FIEL PLUS', b'0', 1, 0, 0, 397.9, 0, 423, 428, 'Jely'),
(22, '- Sin Departamento -', 20, '656A', 'CAMPEON 1KG', b'0', 1, 0, 0, 27.69, 0, 31, 31, 'Jely'),
(23, '- Sin Departamento -', 0, '656', 'CAMPEON ADULTO 25KG', b'0', 1, 0, 0, 692.46, 0, 722, 732, 'Jely'),
(24, '- Sin Departamento -', 2, '657A', 'CAMPEON CACHORRO 1/2KG', b'0', 1, 0, 0, 16.27, 0, 21, 21, 'Jely'),
(25, 'PURINA', 0, '9870', 'CAMPEON CACHORRO 20KG', b'0', 1, 0, 0, 621.31, 0, 651, 661, 'Jely'),
(26, '- Sin Departamento -', 9, 'CAMPICAN', 'CAMPICAN 25KG', b'0', 1, 0, 0, 470, 0, 505, 510, 'Jely'),
(27, '- Sin Departamento -', 0, '93625', 'CAMPIDOG 25KG', b'0', 1, 0, 0, 475, 0, 510, 515, 'Jely'),
(28, '- Sin Departamento -', 1, 'CASA CH', 'CASA CHICA PERRO', b'0', 1, 0, 0, 350, 0, 450, 500, 'Jely'),
(29, '- Sin Departamento -', 1, 'CASAGDE', 'CASA GRANDE PERRO', b'0', 1, 0, 0, 900, 0, 1100, 1150, 'Jely'),
(30, '- Sin Departamento -', 4, '309', 'CAT CHOW DELICIAS 20KG', b'0', 1, 0, 0, 842.61, 0, 873, 883, 'Jely'),
(31, '- Sin Departamento -', 7, '317', 'CAT CHOW GATITOS 1.5KG', b'0', 1, 0, 0, 95.56, 0, 104, 111, 'Jely'),
(32, '- Sin Departamento -', 8.5, 'CAZ1', 'CAZADOR 1KG', b'0', 1, 0, 0, 13.2, 0, 16, 17, 'Jely'),
(33, '- Sin Departamento -', 1, 'CAZCA', 'CAZADOR CACHORRO 20KG', b'0', 1, 0, 0, 440, 0, 485, 490, 'Jely'),
(34, '- Sin Departamento -', 0, 'CA', 'CAZADOR ECO 25KG', b'0', 1, 0, 0, 330, 0, 375, 380, 'Jely'),
(35, 'ALPESUR', 37, '29', 'CONEJO 1KG', b'0', 1, 0, 5, 9.07, 0, 12, 13, 'Jely'),
(36, '- Sin Departamento -', 1, '102343', 'CONEJO 5KG', b'0', 1, 0, 0, 60.21, 0, 67, 70, 'Jely'),
(37, 'ALPESUR', 0, '102344', 'CONEJO ALPESUR 40KG', b'0', 1, 0, 5, 388.41, 0, 423, 428, 'Jely'),
(38, '- Sin Departamento -', 2, '69644', 'CRECIMIENTO ALTA 40KG', b'0', 1, 0, 0, 403.6, 0, 439, 444, 'Jely'),
(39, 'ALPESUR', 1, '202', 'CRECIMIENTO C', b'0', 1, 0, 5, 347.79, 0, 383, 388, 'Jely'),
(40, 'ALPESUR', 13, '70774', 'CRECIMIENTO CERDO T', b'0', 1, 0, 5, 319.45, 0, 354, 359, 'Jely'),
(41, 'ALPESUR', 19, '70775', 'CRECIMIENTO CERDO T 5 KG', b'0', 1, 0, 5, 45.78, 0, 53, 56, 'Jely'),
(42, 'ALPESUR', 44, '222', 'CRECIMIENTO GA 40KG', b'0', 1, 0, 5, 393.8, 0, 429, 434, 'Jely'),
(43, 'ALPESUR', 9, '192', 'CRIANZA POLLITA 40KG', b'0', 1, 0, 0, 358.21, 0, 393, 398, 'Jely'),
(44, 'ALPESUR', 0, '203', 'DESARROLLO C CERDOS 40 KG', b'0', 1, 0, 5, 334, 0, 369, 374, 'Jely'),
(45, 'ALPESUR', 0, '223', 'DESARROLLO GA 40KG', b'0', 1, 0, 5, 383.62, 0, 419, 424, 'Jely'),
(46, 'ALPESUR', 0, '827', 'DOG CHOW ADULTO 25KG RAZAS GRANDES', b'0', 1, 0, 0, 1002.98, 0, 1043, 1043, 'Jely'),
(47, 'ALPESUR', 3, '319', 'DOG CHOW ADULTO 25KG RAZAS PEQUEÑAS', b'0', 1, 0, 0, 1002.98, 0, 1033, 1043, 'Jely'),
(48, 'ALPESUR', 12, '319A', 'DOG CHOW ADULTO RAZAS PEQUEÑAS 1KG', b'0', 1, 0, 0, 40.11, 0, 44, 44, 'Jely'),
(49, 'ALPESUR', 52, '162A', 'DOG CHOW CACHORRO 1/2KG', b'0', 1, 0, 0, 22.63, 0, 27, 27, 'Jely'),
(50, 'ALPESUR', 4, '162', 'DOG CHOW CACHORRO 20KG', b'0', 1, 0, 0, 905.3, 0, 935, 945, 'Jely'),
(51, 'CAMPI', 0, '92925', 'DON-CAN 25KG', b'0', 1, 0, 5, 410, 0, 455, 460, 'Jely'),
(52, '- Sin Departamento -', 21, '9925A', 'DYNO 1KG', b'0', 1, 0, 0, 15.4, 0, 19, 19, 'Jely'),
(53, '- Sin Departamento -', 11, '9925', 'DYNO 25KG', b'0', 1, 0, 0, 385, 0, 420, 425, 'Jely'),
(54, 'NOGAL', 39, 'EC123', 'ECONOMICO INTEGRAL 40KG', b'0', 1, 0, 0, 249.3, 0, 287, 290, 'Jely'),
(55, '- Sin Departamento -', 0, '69646', 'ENGORDA ALTA 40KG', b'0', 1, 0, 0, 387.55, 0, 423, 428, 'Jely'),
(56, 'ALPESUR', 24, '204', 'ENGORDA C', b'0', 1, 0, 5, 316.92, 0, 352, 357, 'Jely'),
(57, 'ALPESUR', 19, '70776', 'ENGORDA FINAL CERDO T', b'0', 1, 0, 5, 302.66, 0, 338, 343, 'Jely'),
(58, 'ALPESUR', 18, '70777', 'ENGORDA FINAL CERDOS T 5 KG', b'0', 1, 0, 5, 43.68, 0, 51, 54, 'Jely'),
(59, 'ALPESUR', 15, '224', 'ENGORDA GA 40KG', b'0', 1, 0, 5, 378.63, 0, 414, 419, 'Jely'),
(60, 'ALPESUR', 0, '82339', 'ENGORDA GANADO RELAMPAGO PLUS 18%', b'0', 1, 0, 0, 340.87, 0, 376, 381, 'Jely'),
(61, 'ALPESUR', 8, '93752', 'ENGORDA MIX ROLADO 14%', b'0', 1, 0, 0, 272.98, 0, 308, 313, 'Jely'),
(62, 'ALPESUR', 0, '77753', 'ESTAMPIDA CLASICO 13%', b'0', 1, 0, 5, 339.95, 0, 375, 380, 'Jely'),
(63, 'ALPESUR', 13, '77754', 'ESTAMPIDA TRABAJO', b'0', 1, 0, 5, 315.64, 0, 351, 356, 'Jely'),
(64, '- Sin Departamento -', 11, '2659A', 'FELIX 1/2KG', b'0', 1, 0, 0, 19.59, 0, 24, 24, 'Jely'),
(65, '- Sin Departamento -', 2, '2659', 'FELIX 10KG', b'0', 1, 0, 0, 391.93, 0, 416, 420, 'Jely'),
(66, '- Sin Departamento -', 9, '81', 'FELIX LATA 156G', b'0', 1, 0, 0, 13.99, 0, 20, 23, 'Jely'),
(67, 'ALPESUR', 23, '70773', 'FINALIZADOR PAVOS 5KG', b'0', 1, 0, 5, 53.07, 0, 60, 63, 'Jely'),
(68, '- Sin Departamento -', 17, 'FC', 'FRENCHYS CAT 1/2KG', b'0', 1, 0, 0, 17, 0, 21, 21, 'Jely'),
(69, '- Sin Departamento -', 54, '77001', 'GALLO MANTENIMIENTO 5 KG', b'0', 1, 0, 5, 63.41, 0, 73, 75, 'Jely'),
(70, 'ALPESUR', 0, '77008', 'GALLOS COMBATE 40KG', b'0', 1, 0, 5, 400.46, 0, 445, 455, 'Jely'),
(71, 'ALPESUR', 6, '77006', 'GALLOS COMBATE 5KG', b'0', 1, 0, 5, 65.74, 0, 75, 78, 'Jely'),
(72, 'ALPESUR', 0, '77003', 'GALLOS MANTENIMIENTOS 40KG', b'0', 1, 0, 5, 461.04, 0, 496, 496, 'Jely'),
(73, '- Sin Departamento -', 1, 'MX000643', 'GANADOR ADULTO 25KG ', b'0', 1, 0, 0, 800.58, 0, 845, 850, 'Jely'),
(74, '- Sin Departamento -', 1, 'MX000626', 'GANADOR ADULTO RAZAS PEQ 20KG', b'0', 1, 0, 0, 681.98, 0, 727, 732, 'Jely'),
(75, '- Sin Departamento -', 0, 'MX011076', 'GANADOR CACHORRO 20KG ', b'0', 1, 0, 0, 649.12, 0, 685, 690, 'Jely'),
(76, '- Sin Departamento -', 2, 'MX000637', 'GANADOR DUO 4KG', b'0', 1, 0, 0, 141.5, 0, 175, 175, 'Jely'),
(77, '- Sin Departamento -', 2, '1234', 'GANADOR PREM ADUL RZA PEQ 4 KG', b'0', 1, 0, 0, 196.34, 0, 222, 225, 'Jely'),
(78, '- Sin Departamento -', 3, 'MX011083', 'GANADOR PREM ADULTO RZA MD Y GDE 4KG', b'0', 1, 0, 0, 194.65, 0, 215, 225, 'Jely'),
(79, 'MALTA', 0, 'MX013684', 'GANADOR PREMIUM ADULTO RAZAS MEDIANAS Y GD', b'0', 1, 0, 0, 822.4, 0, 872, 882, 'Jely'),
(80, 'MALTA', 2, 'MX013687', 'GANADOR PREMIUM ADULTO RP 20KG', b'0', 1, 0, 0, 838.17, 0, 888, 898, 'Jely'),
(81, '- Sin Departamento -', 18, 'MX013687A', 'GANADOR PREMIUM ADULTO RZ MD Y GD 1 KG ', b'0', 1, 0, 0, 41.15, 0, 45, 45, 'Jely'),
(82, 'MALTA', 0, 'MX013678', 'GANADOR PREMIUM CACHORRO 20KG RAZAS MED Y GDE', b'0', 1, 0, 0, 862.76, 0, 912, 922, 'Jely'),
(83, 'MALTA', 3, 'MX013680', 'GANADOR PREMIUM CACHORRO 20KG RAZAS PEQ', b'0', 1, 0, 0, 870.06, 0, 920, 930, 'Jely'),
(84, '- Sin Departamento -', 41, 'MX013680A', 'GANADOR PREMIUM CACHORRO RZ PEQUEÑAS 1/2 KG ', b'0', 1, 0, 0, 21.75, 0, 26, 26, 'Jely'),
(85, '- Sin Departamento -', 8, 'MX000626A', 'GANANDOR ADULTO RZ PEQUEÑAS 1 KG ', b'0', 1, 0, 0, 34.09, 0, 43, 43, 'Jely'),
(86, 'ALPESUR', 17, '481A', 'GATINA 1/2KG', b'0', 1, 0, 0, 15.19, 0, 20, 20, 'Jely'),
(87, '- Sin Departamento -', 0, 'GA', 'GATINA 15KG', b'0', 1, 0, 0, 455.81, 0, 486, 486, 'Jely'),
(88, '- Sin Departamento -', 22, 'HOB', 'HOBIPET 1KG', b'0', 1, 0, 0, 13.96, 0, 18, 18, 'Jely'),
(89, '- Sin Departamento -', 8, '12502', 'HOBIPET 25KG', b'0', 1, 0, 0, 349, 0, 390, 395, 'Jely'),
(90, '- Sin Departamento -', 3, 'GPOEH-0006', 'HOBIPET TOTAL 25KG', b'0', 1, 0, 0, 419.95, 0, 460, 465, 'Jely'),
(91, 'ALPESUR', 9, '221', 'INIACIADOR GA 40KG', b'0', 1, 0, 5, 444.45, 0, 479, 484, 'Jely'),
(92, 'ALPESUR', 17, '201', 'INICIADOR CERDOS C', b'0', 1, 0, 5, 370.52, 0, 406, 411, 'Jely'),
(93, 'ALPESUR', 13, '70771', 'INICIADOR PAVOS 5KG', b'0', 1, 0, 5, 59.83, 0, 67, 70, 'Jely'),
(94, 'ALPESUR', 0, '70766', 'INICIADOR POLLO  T 5KG', b'0', 1, 0, 5, 51.81, 0, 59, 62, 'Jely'),
(95, 'ALPESUR', 3, '70764', 'INICIADOR POLLO T', b'0', 1, 0, 5, 367.65, 0, 403, 408, 'Jely'),
(96, 'ALPESUR', 18, '1', 'INICIADOR POLLO T 1KG', b'0', 1, 0, 5, 8.58, 0, 12, 13, 'Jely'),
(97, '- Sin Departamento -', 21, '95215A', 'KATTOS 1/2KG', b'0', 1, 0, 0, 11.83, 0, 16, 16, 'Jely'),
(98, '- Sin Departamento -', 16, '95215', 'KATTOS 15KG', b'0', 1, 0, 0, 355, 0, 385, 390, 'Jely'),
(99, 'ALPESUR', 0, '198', 'LINEA AVES ABC', b'0', 1, 0, 5, 320.28, 0, 355, 360, 'Jely'),
(100, 'ALPESUR', 11, '199', 'LINEA AVES ABC 5KG', b'0', 1, 0, 0, 44.72, 0, 52, 55, 'Jely'),
(101, 'ALPESUR', 8, '75567', 'Lecheros 20% Tropico', b'0', 1, 0, 0, 335.48, 0, 370, 375, 'Jely'),
(102, 'ALPESUR', 0, '55077', 'MAIZ AMARILLO 40KG', b'0', 1, 0, 5, 300, 0, 335, 340, 'Jely'),
(103, '- Sin Departamento -', 8, '61A', 'MAIZ ENTERO 1KG', b'0', 1, 0, 0, 6.66, 0, 10, 11, 'Jely'),
(104, 'ALPESUR', 0, '66', 'MAIZ QUEBRADO 1KG', b'0', 1, 0, 5, 7.9, 0, 12, 12, 'Jely'),
(105, 'ALPESUR', 12, '123', 'MAIZ QUEBRADO 40kg', b'0', 1, 0, 0, 290, 0, 325, 330, 'Jely'),
(106, '- Sin Departamento -', 42, '95601', 'MAIZ QUEBRADO 5KG', b'0', 1, 0, 0, 44.54, 0, 52, 55, 'Jely'),
(107, '- Sin Departamento -', 2, '61', 'MAIZ QUEBRADO NU3', b'0', 1, 0, 0, 304, 0, 345, 350, 'Jely'),
(108, '- Sin Departamento -', 10, 'MIN', 'MININO 1/2KG', b'0', 1, 0, 0, 14.16, 0, 18, 18, 'Jely'),
(109, '- Sin Departamento -', 6, 'MX000586', 'MININO 15KG', b'0', 1, 0, 0, 424.94, 0, 461, 469, 'Jely'),
(110, '- Sin Departamento -', 0, 'MX000593', 'MININO PLUS 10KG', b'0', 1, 0, 0, 396.64, 0, 430, 435, 'Jely'),
(111, '- Sin Departamento -', 3, 'MON', 'MONTANA MULTIPARTICULA', b'0', 1, 0, 0, 307.32, 0, 348, 352, 'Jely'),
(112, 'ALPESUR', 15, '99927', 'NUCAN ADULTO 1.8KG', b'0', 1, 0, 0, 44.18, 0, 55, 65, 'Jely'),
(113, 'ALPESUR', 1, '75', 'NUCAN ADULTO 1KG', b'0', 1, 0, 0, 23.16, 0, 27, 27, 'Jely'),
(114, 'ALPESUR', 4, '99926', 'NUCAN ADULTO 25KG', b'0', 1, 0, 5, 579.07, 0, 623, 695, 'Jely'),
(115, 'ALPESUR', 28, '84959', 'NUCAN CACHORRO 1.8KG', b'0', 1, 0, 0, 52.72, 0, 65, 70, 'Jely'),
(116, 'ALPESUR', 4, '84958', 'NUCAN CACHORRO 20KG', b'0', 1, 0, 0, 541.57, 0, 635, 695, 'Jely'),
(117, 'ALPESUR', 0, '80895', 'NUCAT', b'0', 1, 0, 5, 415.51, 0, 445, 450, 'Jely'),
(118, '- Sin Departamento -', 3, 'NUC', 'NUCAT 1.8KG', b'0', 1, 0, 0, 54.66, 0, 60, 70, 'Jely'),
(119, 'ALPESUR', 21, '14', 'NUCAT 1/2KG', b'0', 1, 0, 5, 13.79, 0, 18, 18, 'Jely'),
(120, 'NUPEC', 0, 'NUPEA', 'NUPEC ADULTO 15KG', b'0', 1, 0, 0, 803.88, 0, 870, 890, 'Jely'),
(121, '- Sin Departamento -', 3, 'NUPEA-01', 'NUPEC ADULTO 2KG', b'0', 1, 0, 0, 133.98, 0, 155, 155, 'Jely'),
(122, 'NUPEC', 1, 'NUPEC15', 'NUPEC CACHORRO 15KG', b'0', 1, 0, 0, 934.14, 0, 1000, 1150, 'Jely'),
(123, 'NUPEC', 0, 'NUPEC', 'NUPEC CACHORRO 2KG', b'0', 1, 0, 0, 149.82, 0, 165, 175, 'Jely'),
(124, '- Sin Departamento -', 0, 'NUPEC8', 'NUPEC CACHORRO RAZAS PEQUEÑAS 8KG', b'0', 1, 0, 0, 610.76, 0, 655, 670, 'Jely'),
(125, 'NUPEC', 1, 'NUPEC FELINO', 'NUPEC FELINO KITTEN 1.5KG', b'0', 1, 0, 0, 140.44, 0, 150, 155, 'Jely'),
(126, '- Sin Departamento -', 1, '263', 'NUPIG 1 BETA ', b'0', 1, 0, 0, 711.36, 0, 761, 766, 'Jely'),
(127, 'ALPESUR', 7, '67487', 'NUPIG CUATRO ALFA 40KG', b'0', 1, 0, 5, 649.92, 0, 709, 715, 'Jely'),
(128, 'ALPESUR', 31, '8', 'NUPIG CUATRO GAMA 1KG', b'0', 1, 0, 5, 16.2, 0, 22, 22, 'Jely'),
(129, 'ALPESUR', 16, '268', 'NUPIG DOS ALFA', b'0', 1, 0, 5, 876.48, 0, 935, 940, 'Jely'),
(130, 'ALPESUR', 44, '6', 'NUPIG DOS ALFA 1KG', b'0', 1, 0, 5, 21.8, 0, 28, 28, 'Jely'),
(131, 'ALPESUR', 10, '285', 'NUPIG TRES ALFA', b'0', 1, 0, 5, 741.12, 0, 800, 810, 'Jely'),
(132, 'ALPESUR', 19, '7', 'NUPIG TRES ALFA 1KG', b'0', 1, 0, 5, 18.45, 0, 23, 23, 'Jely'),
(133, 'ALPESUR', 9, '487', 'NUPIG UNO OMEGA', b'0', 1, 0, 5, 686.4, 0, 740, 745, 'Jely'),
(134, 'ALPESUR', 38, '5', 'NUPIG UNO OMEGA 1KG', b'0', 1, 0, 5, 27.28, 0, 32, 33, 'Jely'),
(135, '- Sin Departamento -', 0, 'NUT2', 'NUTRESCAN 22KG', b'0', 1, 0, 0, 326, 0, 361, 370, 'Jely'),
(136, '- Sin Departamento -', 10, 'NUT', 'NUTRESCAT 15KG', b'0', 1, 0, 0, 420.76, 0, 440, 445, 'Jely'),
(137, 'ALPESUR', 6, '11', 'NUTRIMASCOTAS ADULTO 1KG', b'0', 1, 0, 5, 38.84, 0, 47, 47, 'Jely'),
(138, 'ALPESUR', 10, '70438', 'NUTRIMASCOTAS ADULTO 20kg', b'0', 1, 0, 5, 776.87, 0, 850, 1015, 'Jely'),
(139, 'ALPESUR', 6, '79146', 'NUTRIMASCOTAS ADULTO 5KG', b'0', 1, 0, 5, 218.42, 0, 253, 285, 'Jely'),
(140, 'ALPESUR', 19, '10N', 'NUTRIMASCOTAS CACHORRO 1/2KG', b'0', 1, 0, 5, 21.91, 0, 27, 28, 'Jely'),
(141, 'ALPESUR', 2, '70437', 'NUTRIMASCOTAS CACHORRO 20kg', b'0', 1, 0, 5, 876.51, 0, 945, 1040, 'Jely'),
(142, 'ALPESUR', 7, '79145', 'NUTRIMASCOTAS CACHORRO 5KG', b'0', 1, 0, 5, 243.69, 0, 280, 320, 'Jely'),
(143, 'ALPESUR', 6, '13', 'OPTIMO ADULTO 1KG', b'0', 1, 0, 5, 27.34, 0, 31, 31, 'Jely'),
(144, 'ALPESUR', 4, '70444', 'OPTIMO ADULTO 25KG', b'0', 1, 0, 5, 683.63, 0, 735, 765, 'Jely'),
(145, 'ALPESUR', 6, '80694', 'OPTIMO ADULTO 2KG', b'0', 1, 0, 0, 75.17, 0, 82, 90, 'Jely'),
(146, 'ALPESUR', 4, '80695', 'OPTIMO ADULTO 4KG', b'0', 1, 0, 0, 129.01, 0, 143, 170, 'Jely'),
(147, 'ALPESUR', 4, '70439', 'OPTIMO CACHORRO 20kg', b'0', 1, 0, 5, 611.99, 0, 660, 750, 'Jely'),
(148, 'ALPESUR', 7, '80696', 'OPTIMO CACHORRO 2KG', b'0', 1, 0, 0, 75.17, 0, 84, 90, 'Jely'),
(149, 'ALPESUR', 5, '80697', 'OPTIMO CACHORRO 4KG', b'0', 1, 0, 0, 142.45, 0, 158, 180, 'Jely'),
(150, '- Sin Departamento -', 0, '80699', 'OPTIMO FELINO 1.5KG', b'0', 1, 0, 0, 68.64, 0, 79, 85, 'Jely'),
(151, 'ALPESUR', 0, '70445', 'OPTIMO FELINO 20k', b'0', 1, 0, 0, 673.84, 0, 725, 770, 'Jely'),
(152, '- Sin Departamento -', 34, '57125A', 'PODER CANINO 1KG', b'0', 1, 0, 0, 15.61, 0, 20, 20, 'Jely'),
(153, 'MALTA', 3, 'MX012307', 'PODER CANINO 25KG', b'0', 1, 0, 0, 390.27, 0, 425, 430, 'Jely'),
(154, 'ALPESUR', 10, '196', 'POSTURA 16%', b'0', 1, 0, 5, 351.46, 0, 386, 391, 'Jely'),
(155, 'ALPESUR', 24, '197', 'POSTURA 5KG', b'0', 1, 0, 5, 49.79, 0, 57, 60, 'Jely'),
(156, '- Sin Departamento -', 1, '5634', 'PRO PLAN ADULTO OPTIHEALT 13KG', b'0', 1, 0, 0, 1373.29, 0, 1574, 1574, 'Jely'),
(157, '- Sin Departamento -', 2, '5700', 'PRO PLAN CACH SENSITIVE 13KG', b'0', 1, 0, 0, 1652.12, 0, 1760, 1760, 'Jely'),
(158, 'PROPLAN', 0, '849', 'PROPLAN PUPPY OPTISTART 13KG', b'0', 1, 0, 0, 1652.12, 0, 1732, 1804, 'Jely'),
(159, 'PROPLAN', 1, '3164', 'PROPLAN SENSITIVE ADULTO 13KG', b'0', 1, 0, 0, 1647.81, 0, 1728, 1800, 'Jely'),
(160, 'ALPESUR', 3, '68662', 'RACTOPAMINA 10%', b'0', 1, 0, 5, 411.2, 0, 446, 451, 'Jely'),
(161, '- Sin Departamento -', 0, '100326', 'RENDIPOLLO 40KG', b'0', 1, 0, 0, 297.37, 0, 332, 337, 'Jely'),
(162, 'ALPESUR', 2, '205', 'REPRODUCTORA C', b'0', 1, 0, 5, 330.27, 0, 365, 370, 'Jely'),
(163, 'ALPESUR', 7, '225', 'REPRODUCTORA GA 40KG', b'0', 1, 0, 5, 362.77, 0, 398, 403, 'Jely'),
(164, 'ALPESUR', 18, '209', 'REPRODUCTORA LACTANCIA C', b'0', 1, 0, 5, 353, 0, 388, 393, 'Jely'),
(165, 'ALPESUR', 10, '229', 'REPRODUCTORA LACTANCIA G.A', b'0', 1, 0, 5, 425.72, 0, 461, 466, 'Jely'),
(166, '- Sin Departamento -', 7, 'ROCK', 'ROCKO PLUS 1KG', b'0', 1, 0, 0, 16.75, 0, 22, 22, 'Jely'),
(167, '- Sin Departamento -', 2, 'LAD00035', 'ROCKO PLUS 25KG PERRO ADULTO', b'0', 1, 0, 0, 418.77, 0, 460, 470, 'Jely'),
(168, 'ALPESUR', 10, '51', 'SAL MINERAL 1KG', b'0', 1, 0, 5, 5.2, 0, 10, 10, 'Jely'),
(169, 'ALPESUR', 0, '79142', 'SAL MINERAL BOVINO 20KG', b'0', 1, 0, 5, 110.83, 0, 136, 140, 'Jely'),
(170, 'ALPESUR', 0, '43', 'SALVADO 40KG', b'0', 1, 0, 5, 220, 0, 255, 260, 'Jely'),
(171, '- Sin Departamento -', 9, '81S', 'SOBRE DE FELIX 85G', b'0', 1, 0, 0, 10, 0, 17, 17, 'Jely'),
(172, '- Sin Departamento -', 1333, 'MX011106', 'SOBRES DE CAMPI', b'0', 1, 0, 0, 6.5, 0, 0, 8, 'Jely'),
(173, '- Sin Departamento -', 0, 'SOB', 'SOBRES PURINA', b'0', 1, 0, 0, 7.81, 0, 9, 10, 'Jely'),
(174, '- Sin Departamento -', 20, 'SUP', 'SUPERCACHORRO 22KG', b'0', 1, 0, 0, 419.33, 0, 454, 459, 'Jely'),
(175, '- Sin Departamento -', 0, 'SCA', 'SUPERCAN AZUL 25KG', b'0', 1, 0, 0, 352, 0, 392, 395, 'Jely'),
(176, '- Sin Departamento -', 15, 'SCF', 'SUPERCAN FEROZ ', b'0', 1, 0, 0, 372.49, 0, 407, 413, 'Jely'),
(177, '- Sin Departamento -', 4, 'SUP2', 'SUPERCAN MAX 22KG', b'0', 1, 0, 0, 360.51, 0, 395, 400, 'Jely'),
(178, '- Sin Departamento -', 2, 'SCM', 'SUPERCAN MESTIZO ', b'0', 1, 0, 0, 236.61, 0, 275, 277, 'Jely'),
(179, 'ALPESUR', 1, '461', 'SUSTITUTO DE LECHE NUTRILAC 5KG', b'0', 1, 0, 5, 186.85, 0, 222, 222, 'Jely'),
(180, 'ALPESUR', 13, '103', 'TERMINADOR POLLO FASE IV', b'0', 1, 0, 5, 320.28, 0, 355, 360, 'Jely'),
(181, 'ALPESUR', 0, '70767', 'TERMINADOR POLLO T', b'0', 1, 0, 5, 345.66, 0, 381, 386, 'Jely'),
(182, 'ALPESUR', 7, '48', 'TILAPIA 2 1KG', b'0', 1, 0, 5, 16.34, 0, 21, 21, 'Jely'),
(183, '- Sin Departamento -', 2, 'TILA', 'TILAPIA VIMIFOS Crec 3205 25KG', b'0', 1, 0, 0, 408.72, 0, 442, 448, 'Jely'),
(184, 'MALTA', 8, '48189', 'TILAPIA Vimifos ENGORDA 25KG', b'0', 1, 0, 5, 368.52, 0, 402, 408, 'Jely'),
(185, '- Sin Departamento -', 26, 'TITAN', 'TITAN 1KG', b'0', 1, 0, 0, 22.47, 0, 27, 27, 'Jely'),
(186, '- Sin Departamento -', 2, 'LAD00011', 'TITAN 25KG PERRO ADULTO', b'0', 1, 0, 0, 561.83, 0, 608, 615, 'Jely'),
(187, '- Sin Departamento -', 15, 'TG', 'TITAN GATO 1/2KG', b'0', 1, 0, 0, 12.83, 0, 16, 17, 'Jely'),
(188, '- Sin Departamento -', 0, 'TIT', 'TITAN GATO 15KG', b'0', 1, 0, 0, 367.59, 0, 395, 402, 'Jely'),
(189, '- Sin Departamento -', 0, 'MX000697', 'TOP CHOICE 25KG', b'0', 1, 0, 0, 533.02, 0, 565, 570, 'Jely'),
(190, 'NOGAL', 37, 'PE121', 'VICENTINA 1 25KG', b'0', 1, 0, 0, 492.96, 0, 523, 530, 'Jely'),
(191, 'NOGAL', 6, 'PE122', 'VICENTINA 2 20KG', b'0', 1, 0, 0, 535.13, 0, 565, 572, 'Jely'),
(192, 'NOGAL', 4, 'LU121', 'VICENTINA 3 15KG', b'0', 1, 0, 0, 413.64, 0, 433, 438, 'Jely'),
(193, 'NOGAL', 3, 'NO121', 'VICENTINA 4 25KG', b'0', 1, 0, 0, 419.26, 0, 449, 457, 'Jely'),
(194, 'NOGAL', 16, 'ME121', 'VICENTINA 5 25KG', b'0', 1, 0, 0, 422.91, 0, 448, 453, 'Jely'),
(195, 'NOGAL', 0, 'VICENTINA8', 'VICENTINA 8 PAP 25KG', b'0', 1, 0, 0, 667.73, 0, 698, 703, 'Jely'),
(196, 'NOGAL', 20, 'VICENTINA7', 'VICENTINA7 NC 20KG', b'0', 1, 0, 0, 508.82, 0, 534, 539, 'Jely'),
(197, '- Sin Departamento -', 98, 'PRODUCT-PRUEBA-VENTAS', 'Producto para realizar pruebas', b'0', 1, 0, 2, 2, 4, 4, 5, 'Jely');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sucursal`
--

CREATE TABLE `sucursal` (
  `id_sucursal` bigint(20) NOT NULL,
  `direccion` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `estatus_sucursal` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `id_usuario` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `imagen` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `propietario` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `traspaso`
--

CREATE TABLE `traspaso` (
  `id_traspaso` int(11) NOT NULL,
  `cantidad` float NOT NULL,
  `estatus` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `fecha` datetime(6) DEFAULT NULL,
  `id_producto` int(11) NOT NULL,
  `id_sucursa_recibe` int(11) NOT NULL,
  `id_sucursal_envia` int(11) NOT NULL,
  `monto` float NOT NULL,
  `operacion` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `precio_compra` float NOT NULL,
  `propietario` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `realizada_en` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_sucursal` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `direccion` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `eliminado` bit(1) NOT NULL,
  `en_sesion` bit(1) NOT NULL,
  `fecha` datetime(6) DEFAULT NULL,
  `hora` datetime(6) DEFAULT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `telefono` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `tipo_usuario` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `username` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `foto` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `propietario` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_sucursal`, `id_usuario`, `direccion`, `eliminado`, `en_sesion`, `fecha`, `hora`, `nombre`, `password`, `telefono`, `tipo_usuario`, `username`, `foto`, `propietario`) VALUES
(1, 1, 'dirección admin', b'0', b'0', '2022-03-03 13:20:38.000000', '2022-03-10 13:20:38.000000', 'Administrador', '12345', '0', 'Administrador', 'Admin', 's/f.jpeg', 'Jely');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `id_venta` int(11) NOT NULL,
  `cantidad` float NOT NULL,
  `codigo` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `devocompleta` bit(1) NOT NULL,
  `devolucion` bit(1) NOT NULL,
  `fecha` datetime(6) DEFAULT NULL,
  `finalizada` bit(1) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `id_sucursal` int(11) DEFAULT NULL,
  `id_ticket` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `importe` float NOT NULL,
  `mayoreo` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `precio_costo` float NOT NULL,
  `precio_venta` float NOT NULL,
  `propietario` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `revisada` bit(1) NOT NULL,
  `tipo_compra` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `area`
--
ALTER TABLE `area`
  ADD PRIMARY KEY (`id_area`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Indices de la tabla `credito`
--
ALTER TABLE `credito`
  ADD PRIMARY KEY (`id_credito`);

--
-- Indices de la tabla `movimientos_extras`
--
ALTER TABLE `movimientos_extras`
  ADD PRIMARY KEY (`id_movimiento`);

--
-- Indices de la tabla `movimientos_inv`
--
ALTER TABLE `movimientos_inv`
  ADD PRIMARY KEY (`id_movimiento_inv`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id_producto`);

--
-- Indices de la tabla `sucursal`
--
ALTER TABLE `sucursal`
  ADD PRIMARY KEY (`id_sucursal`);

--
-- Indices de la tabla `traspaso`
--
ALTER TABLE `traspaso`
  ADD PRIMARY KEY (`id_traspaso`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_sucursal`,`id_usuario`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`id_venta`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `area`
--
ALTER TABLE `area`
  MODIFY `id_area` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `credito`
--
ALTER TABLE `credito`
  MODIFY `id_credito` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `movimientos_extras`
--
ALTER TABLE `movimientos_extras`
  MODIFY `id_movimiento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `movimientos_inv`
--
ALTER TABLE `movimientos_inv`
  MODIFY `id_movimiento_inv` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=198;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id_producto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=198;

--
-- AUTO_INCREMENT de la tabla `sucursal`
--
ALTER TABLE `sucursal`
  MODIFY `id_sucursal` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `id_venta` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
