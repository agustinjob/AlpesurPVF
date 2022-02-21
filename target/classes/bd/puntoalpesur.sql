-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-02-2022 a las 17:03:36
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
-- Base de datos: `puntoalpesur`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `area`
--

CREATE TABLE `area` (
  `idArea` int(11) NOT NULL,
  `nombre` varchar(250) COLLATE utf8_spanish2_ci NOT NULL,
  `realizadaEn` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  `estatus` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  `operacion` varchar(150) COLLATE utf8_spanish2_ci NOT NULL,
  `propietario` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  `idSucursal` int(11) NOT NULL,
  `estatusArea` varchar(150) COLLATE utf8_spanish2_ci NOT NULL DEFAULT 'vigente'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `area`
--

INSERT INTO `area` (`idArea`, `nombre`, `realizadaEn`, `estatus`, `operacion`, `propietario`, `idSucursal`, `estatusArea`) VALUES
(4, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro', 'Jely', 1, 'vigente');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bitacora`
--

CREATE TABLE `bitacora` (
  `idBitacora` int(10) NOT NULL,
  `descripcion` varchar(255) COLLATE utf8_spanish2_ci NOT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  `idUsuario` int(10) NOT NULL,
  `realizadaEn` varchar(100) CHARACTER SET utf16 COLLATE utf16_spanish2_ci NOT NULL,
  `estatus` varchar(100) CHARACTER SET utf16 COLLATE utf16_spanish2_ci NOT NULL,
  `operacion` varchar(150) CHARACTER SET utf16 COLLATE utf16_spanish2_ci NOT NULL,
  `propietario` varchar(100) CHARACTER SET utf16 COLLATE utf16_spanish2_ci NOT NULL,
  `idSucursal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `bitacora`
--

INSERT INTO `bitacora` (`idBitacora`, `descripcion`, `fecha`, `hora`, `idUsuario`, `realizadaEn`, `estatus`, `operacion`, `propietario`, `idSucursal`) VALUES
(1, 'Se regitro la operación de efectivo_inicial', '2022-01-19', '01:30:16', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(2, 'Se regitro la operación de efectivo_inicial', '2022-01-19', '01:39:20', 3, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(3, 'Registró el producto Producto para realizar pruebas', '2022-01-19', '01:46:59', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(4, 'Se regitro la operación de registro_producto', '2022-01-19', '01:46:59', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(5, 'Registró el producto Producto para realizar pruebas', '2022-01-19', '01:46:59', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(6, 'Se regitro la operación de registro_producto', '2022-01-19', '01:46:59', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(7, 'Registro al cliente Cliente de prueba', '2022-01-19', '01:52:35', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(8, 'Registro al cliente Cliente de prueba', '2022-01-19', '01:52:35', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(9, 'Venta registrada', '2022-01-19', '01:52:47', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(10, 'Venta registrada', '2022-01-19', '01:52:47', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(11, 'Se registró un abono de 5.0 en el ticket 1', '2022-01-19', '01:53:24', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(12, 'Se registró un abono de 5.0 en el ticket 1', '2022-01-19', '01:53:45', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(17, 'Venta registrada', '2022-01-19', '11:56:38', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(18, 'Venta registrada', '2022-01-19', '11:56:38', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(19, 'Se modificaron los datos del negocio', '2022-01-19', '15:33:23', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(20, 'Se modificaron los datos del negocio', '2022-01-19', '15:33:23', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(21, 'Se modificaron los datos del negocio', '2022-01-19', '15:33:23', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(22, 'Venta registrada', '2022-01-19', '18:15:12', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(23, 'Venta registrada', '2022-01-19', '18:19:19', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(24, 'Venta registrada', '2022-01-19', '18:19:19', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(25, 'Venta registrada', '2022-01-16', '16:20:35', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(26, 'Venta registrada', '2022-01-16', '16:20:35', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(27, 'Se regitro la operación de efectivo_inicial', '2022-01-16', '16:23:43', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(28, 'Venta registrada', '2022-01-16', '16:24:00', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(29, 'Venta registrada', '2022-01-16', '16:24:00', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(30, 'Venta registrada', '2022-01-16', '16:26:40', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(31, 'Venta registrada', '2022-01-16', '16:26:40', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(32, 'Venta registrada', '2022-01-16', '16:28:08', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(33, 'Venta registrada', '2022-01-16', '16:28:08', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(34, 'Venta registrada', '2022-01-16', '16:30:14', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(35, 'Venta registrada', '2022-01-16', '16:30:14', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(36, 'Venta registrada', '2022-01-16', '16:36:23', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(37, 'Venta registrada', '2022-01-16', '16:36:23', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(38, 'Venta registrada', '2022-01-16', '16:38:10', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(39, 'Venta registrada', '2022-01-16', '16:38:10', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(40, 'Venta registrada', '2022-01-16', '16:40:52', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(41, 'Venta registrada', '2022-01-16', '16:40:52', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(42, 'Venta registrada', '2022-01-16', '16:49:24', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(43, 'Venta registrada', '2022-01-16', '16:49:24', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(45, 'Venta registrada', '2022-01-16', '17:02:33', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(46, 'Venta registrada', '2022-01-16', '17:02:33', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(47, 'Venta registrada', '2022-01-16', '17:07:13', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(48, 'Venta registrada', '2022-01-16', '17:07:13', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(49, 'Venta registrada', '2022-01-16', '17:09:03', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(50, 'Venta registrada', '2022-01-16', '17:09:03', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(51, 'Venta registrada', '2022-01-16', '17:09:39', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(52, 'Venta registrada', '2022-01-16', '17:09:39', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(53, 'Venta registrada', '2022-01-16', '17:14:54', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(54, 'Venta registrada', '2022-01-16', '17:14:54', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(55, 'Venta registrada', '2022-01-16', '17:21:09', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(56, 'Venta registrada', '2022-01-16', '17:21:09', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(57, 'Venta registrada', '2022-01-16', '17:24:31', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(58, 'Venta registrada', '2022-01-16', '17:24:31', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(59, 'Venta registrada', '2022-01-16', '17:48:07', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(60, 'Venta registrada', '2022-01-16', '17:48:07', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(61, 'Venta registrada', '2022-01-16', '18:19:17', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(62, 'Venta registrada', '2022-01-16', '18:19:17', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(63, 'Venta registrada', '2022-01-16', '18:19:27', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(64, 'Venta registrada', '2022-01-16', '18:19:27', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(65, 'Venta registrada', '2022-01-16', '18:21:10', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(66, 'Venta registrada', '2022-01-16', '18:21:10', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(67, 'Venta registrada', '2022-01-16', '18:23:57', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(68, 'Venta registrada', '2022-01-16', '18:23:57', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(69, 'Venta registrada', '2022-01-16', '18:27:01', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(70, 'Venta registrada', '2022-01-16', '18:27:01', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(72, 'Venta registrada', '2022-01-16', '18:31:28', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(73, 'Venta registrada', '2022-01-16', '18:31:28', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(74, 'Venta registrada', '2022-01-16', '18:32:45', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(75, 'Venta registrada', '2022-01-16', '18:32:45', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(76, 'Venta registrada', '2022-01-16', '18:39:26', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(77, 'Venta registrada', '2022-01-16', '18:39:26', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(78, 'Venta registrada', '2022-01-16', '18:41:17', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(79, 'Venta registrada', '2022-01-16', '18:41:17', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(80, 'Venta registrada', '2022-01-16', '18:44:07', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(81, 'Venta registrada', '2022-01-16', '18:44:07', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(82, 'Venta registrada', '2022-01-19', '22:45:36', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(83, 'Venta registrada', '2022-01-19', '22:45:36', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(84, 'Venta registrada', '2022-01-18', '20:46:58', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(85, 'Venta registrada', '2022-01-18', '20:46:58', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(86, 'Se regitro la operación de efectivo_inicial', '2022-01-18', '20:49:28', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(87, 'Venta registrada', '2022-01-18', '20:49:46', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(88, 'Venta registrada', '2022-01-18', '20:49:46', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(89, 'Venta registrada', '2022-01-17', '20:52:52', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(90, 'Venta registrada', '2022-01-17', '20:52:52', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1),
(91, 'Se regitro la operación de efectivo_inicial', '2022-01-22', '21:31:30', 1, 'Local', 'En proceso', 'Bitacoreo', 'Jely', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `idCliente` int(10) NOT NULL,
  `nombre` varchar(255) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `direccion` varchar(255) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `telefono` varchar(255) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `email` varchar(250) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `rfc` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `mayorista` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `limiteCredito` int(10) NOT NULL,
  `eliminado` tinyint(1) NOT NULL,
  `realizadaEn` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `estatus` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `operacion` varchar(150) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `propietario` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `idSucursal` int(11) NOT NULL,
  `estatusCliente` varchar(50) COLLATE utf16_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_spanish2_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`idCliente`, `nombre`, `direccion`, `telefono`, `email`, `rfc`, `mayorista`, `limiteCredito`, `eliminado`, `realizadaEn`, `estatus`, `operacion`, `propietario`, `idSucursal`, `estatusCliente`) VALUES
(1, 'Cliente de prueba', 'prueba', '27272', 'agus_j@hotmail.com', 'hema', 'No', 1000, 0, 'Local', 'Actualizada', 'Registro', 'Jely', 1, 'vigente');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `configuracion`
--

CREATE TABLE `configuracion` (
  `idConfiguracion` int(11) NOT NULL,
  `impresora` varchar(200) COLLATE utf8_spanish2_ci NOT NULL,
  `nombreLocal` varchar(200) COLLATE utf8_spanish2_ci NOT NULL,
  `rfc` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `direccion` varchar(150) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `configuracion`
--

INSERT INTO `configuracion` (`idConfiguracion`, `impresora`, `nombreLocal`, `rfc`, `direccion`) VALUES
(1, 'XP-58', 'Alpesur Fortin', 'HEMA8808', 'Oriente 2 No 38 Colonia Centro');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `credito`
--

CREATE TABLE `credito` (
  `idCredito` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idTicket` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `monto` double NOT NULL,
  `abonado` double NOT NULL,
  `fechaAbono` date NOT NULL,
  `finalizado` tinyint(1) NOT NULL DEFAULT 0,
  `idUsuario` int(11) NOT NULL DEFAULT 1,
  `realizadaEn` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  `estatus` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  `operacion` varchar(150) COLLATE utf8_spanish2_ci NOT NULL,
  `propietario` varchar(100) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `credito`
--

INSERT INTO `credito` (`idCredito`, `idCliente`, `idTicket`, `fecha`, `monto`, `abonado`, `fechaAbono`, `finalizado`, `idUsuario`, `realizadaEn`, `estatus`, `operacion`, `propietario`) VALUES
(15, 1, 1, '2022-01-19', 10, 5, '2022-01-19', 1, 1, 'Local', 'En proceso', 'Registro', 'Jely'),
(16, 1, 1, '2022-01-19', 10, 5, '2022-01-19', 1, 1, 'Local', 'En proceso', 'Registro', 'Jely');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `errores`
--

CREATE TABLE `errores` (
  `idError` int(11) NOT NULL,
  `descripcion` varchar(500) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `idSucursal` int(11) NOT NULL,
  `propietario` varchar(100) COLLATE utf8mb4_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movimientos_extras`
--

CREATE TABLE `movimientos_extras` (
  `idMovimiento` int(10) NOT NULL,
  `tipo` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  `descripcion` varchar(255) COLLATE utf8_spanish2_ci NOT NULL,
  `monto` double NOT NULL,
  `fecha` date NOT NULL,
  `revisado` tinyint(1) NOT NULL DEFAULT 0,
  `idUsuario` int(11) NOT NULL,
  `idSucursal` int(11) NOT NULL,
  `realizadaEn` varchar(100) CHARACTER SET utf16 COLLATE utf16_spanish2_ci NOT NULL,
  `estatus` varchar(100) CHARACTER SET utf16 COLLATE utf16_spanish2_ci NOT NULL,
  `operacion` varchar(100) CHARACTER SET utf16 COLLATE utf16_spanish2_ci NOT NULL,
  `propietario` varchar(150) CHARACTER SET utf16 COLLATE utf16_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `movimientos_extras`
--

INSERT INTO `movimientos_extras` (`idMovimiento`, `tipo`, `descripcion`, `monto`, `fecha`, `revisado`, `idUsuario`, `idSucursal`, `realizadaEn`, `estatus`, `operacion`, `propietario`) VALUES
(1, 'efectivo_inicial', 'Nueva', 100, '2022-01-19', 0, 1, 1, 'Local', 'Actualizada', 'Registro', 'Jely'),
(2, 'efectivo_inicial', 'Nueva', 100, '2022-01-19', 0, 3, 1, 'Local', 'Actualizada', 'Registro', 'Jely'),
(3, 'registro_producto', 'PRODUCT-PRUEBA-VENTAS', 100, '2022-01-19', 0, 1, 1, 'Local', 'Actualizada', 'Registro', 'Jely'),
(4, 'registro_producto', 'PRODUCT-PRUEBA-VENTAS', 100, '2022-01-19', 0, 1, 1, 'Local', 'Actualizada', 'Registro', 'Jely'),
(5, 'efectivo_inicial', 'Nueva', 100, '2022-01-16', 0, 1, 1, 'Local', 'Actualizada', 'Registro', 'Jely'),
(6, 'efectivo_inicial', 'Nueva', 200, '2022-01-18', 0, 1, 1, 'Local', 'Actualizada', 'Registro', 'Jely'),
(7, 'efectivo_inicial', 'Nueva', 100, '2022-01-22', 0, 1, 1, 'Local', 'Actualizada', 'Registro', 'Jely');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movimientos_inventario`
--

CREATE TABLE `movimientos_inventario` (
  `idMovInv` int(11) NOT NULL,
  `hora` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `descripcion` varchar(200) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `movimiento` varchar(200) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `habia` double NOT NULL,
  `cantidad` double NOT NULL,
  `hay` double NOT NULL,
  `cajero` varchar(150) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `Departamento` varchar(150) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `idUsuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `idProducto` int(10) NOT NULL,
  `codigo` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  `descripcion` varchar(150) COLLATE utf8_spanish2_ci NOT NULL,
  `precioCosto` double NOT NULL,
  `precioVenta` double NOT NULL,
  `precioMayoreo` double NOT NULL,
  `precioDistribuidor` float NOT NULL DEFAULT 0,
  `cantidad` double NOT NULL,
  `inventarioMinimo` int(10) NOT NULL,
  `eliminado` tinyint(1) NOT NULL,
  `area` varchar(250) COLLATE utf8_spanish2_ci NOT NULL DEFAULT '',
  `realizadaEn` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  `estatus` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  `operacion` varchar(150) COLLATE utf8_spanish2_ci NOT NULL,
  `propietario` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  `idSucursal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`idProducto`, `codigo`, `descripcion`, `precioCosto`, `precioVenta`, `precioMayoreo`, `precioDistribuidor`, `cantidad`, `inventarioMinimo`, `eliminado`, `area`, `realizadaEn`, `estatus`, `operacion`, `propietario`, `idSucursal`) VALUES
(1, '84339', 'ALPET ADULTO 25KG', 605.12, 720, 648, 0, 0, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(2, '84337', 'ALPET ADULTO 2KG', 55.74, 76, 66, 0, 1, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Modificacion', 'Jely', 1),
(3, '84338', 'ALPET ADULTO 8KG', 207.77, 250, 240, 0, 0, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(4, '84334', 'ALPET CACHORRO 2KG', 70.35, 85, 79, 0, 3, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Modificacion', 'Jely', 1),
(5, '84335', 'ALPET CACHORRO 8KG', 267.04, 315, 305, 0, 1, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(6, '87', 'ARENA TIDY CATS 4.54KG', 69.36, 90, 87, 0, 2, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(7, '65', 'AUDAZ 1KG', 18.73, 23, 22, 0, 5, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Modificacion', 'Jely', 1),
(8, '96268', 'AUDAZ 25KG', 468.42, 520, 503, 0, 0, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(9, '9885', 'BENEFUL MINIS SALMON 10KG', 448.68, 479, 474, 0, 1, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(10, '55', 'BERISCAN CACHORRO 1/2KG', 14.07, 18, 17, 0, 0, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(11, '53', 'BERISCAN CACHORRO 20kg', 540, 585, 580, 0, 6, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Modificacion', 'Jely', 1),
(12, '16', 'BERISCAN PRO 1KG', 19.16, 24, 23, 0, 7, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Modificacion', 'Jely', 1),
(13, '15', 'BERISCAN PRO 25KG', 485, 535, 525, 0, 10, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Modificacion', 'Jely', 1),
(14, '69A', 'BERISCAT 1/2KG', 15.16, 19, 19, 0, 1, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Modificacion', 'Jely', 1),
(15, '69', 'BERISCAT 15KG', 440, 475, 470, 0, 15, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(16, '79138', 'BLOCK DE SAL ', 80.9, 115, 110, 0, 2, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(17, '77643', 'BORREGO 13%', 304.59, 345, 340, 0, 0, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(18, '68533', 'BORREGO CRECIMIENTO 16%', 323.66, 374, 364, 0, 0.5, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(19, 'NOGAL3', 'CABALLO FIEL', 387.9, 418, 413, 0, 3, 0, 0, 'NOGAL', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(20, 'NOGAL1', 'CABALLO FIEL D MANZANA 40KG', 429.9, 459, 454, 0, 19, 0, 0, 'NOGAL', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(21, 'NOGAL2', 'CABALLO FIEL PLUS', 397.9, 428, 423, 0, 8, 0, 0, 'NOGAL', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(22, '656A', 'CAMPEON 1KG', 27.69, 31, 31, 0, 20, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Modificacion', 'Jely', 1),
(23, '656', 'CAMPEON ADULTO 25KG', 692.46, 732, 722, 0, 0, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(24, '657A', 'CAMPEON CACHORRO 1/2KG', 16.27, 21, 21, 0, 2, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(25, '9870', 'CAMPEON CACHORRO 20KG', 621.31, 661, 651, 0, 0, 0, 0, 'PURINA', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(26, 'CAMPICAN', 'CAMPICAN 25KG', 470, 510, 505, 0, 9, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(27, '93625', 'CAMPIDOG 25KG', 475, 515, 510, 0, 0, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(28, 'CASA CH', 'CASA CHICA PERRO', 350, 500, 450, 0, 1, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(29, 'CASAGDE', 'CASA GRANDE PERRO', 900, 1150, 1100, 0, 1, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(30, '309', 'CAT CHOW DELICIAS 20KG', 842.61, 883, 873, 0, 4, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(31, '317', 'CAT CHOW GATITOS 1.5KG', 95.56, 111, 104, 0, 7, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(32, 'CAZ1', 'CAZADOR 1KG', 13.2, 17, 16, 0, 8.5, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(33, 'CAZCA', 'CAZADOR CACHORRO 20KG', 440, 490, 485, 0, 1, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(34, 'CA', 'CAZADOR ECO 25KG', 330, 380, 375, 0, 0, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(35, '29', 'CONEJO 1KG', 9.07, 13, 12, 0, 37, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(36, '102343', 'CONEJO 5KG', 60.21, 70, 67, 0, 1, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(37, '102344', 'CONEJO ALPESUR 40KG', 388.41, 428, 423, 0, 0, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(38, '69644', 'CRECIMIENTO ALTA 40KG', 403.6, 444, 439, 0, 2, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(39, '202', 'CRECIMIENTO C', 347.79, 388, 383, 0, 1, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(40, '70774', 'CRECIMIENTO CERDO T', 319.45, 359, 354, 0, 13, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(41, '70775', 'CRECIMIENTO CERDO T 5 KG', 45.78, 56, 53, 0, 19, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(42, '222', 'CRECIMIENTO GA 40KG', 393.8, 434, 429, 0, 44, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(43, '192', 'CRIANZA POLLITA 40KG', 358.21, 398, 393, 0, 9, 0, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(44, '203', 'DESARROLLO C CERDOS 40 KG', 334, 374, 369, 0, 0, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(45, '223', 'DESARROLLO GA 40KG', 383.62, 424, 419, 0, 0, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(46, '827', 'DOG CHOW ADULTO 25KG RAZAS GRANDES', 1002.98, 1043, 1043, 0, 0, 0, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(47, '319', 'DOG CHOW ADULTO 25KG RAZAS PEQUEÑAS', 1002.98, 1043, 1033, 0, 3, 0, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(48, '319A', 'DOG CHOW ADULTO RAZAS PEQUEÑAS 1KG', 40.11, 44, 44, 0, 12, 0, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(49, '162A', 'DOG CHOW CACHORRO 1/2KG', 22.63, 27, 27, 0, 52, 0, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(50, '162', 'DOG CHOW CACHORRO 20KG', 905.3, 945, 935, 0, 4, 0, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(51, '92925', 'DON-CAN 25KG', 410, 460, 455, 0, 0, 5, 0, 'CAMPI', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(52, '9925A', 'DYNO 1KG', 15.4, 19, 19, 0, 21, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(53, '9925', 'DYNO 25KG', 385, 425, 420, 0, 11, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(54, 'EC123', 'ECONOMICO INTEGRAL 40KG', 249.3, 290, 287, 0, 39, 0, 0, 'NOGAL', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(55, '69646', 'ENGORDA ALTA 40KG', 387.55, 428, 423, 0, 0, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(56, '204', 'ENGORDA C', 316.92, 357, 352, 0, 24, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(57, '70776', 'ENGORDA FINAL CERDO T', 302.66, 343, 338, 0, 19, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(58, '70777', 'ENGORDA FINAL CERDOS T 5 KG', 43.68, 54, 51, 0, 18, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(59, '224', 'ENGORDA GA 40KG', 378.63, 419, 414, 0, 15, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(60, '82339', 'ENGORDA GANADO RELAMPAGO PLUS 18%', 340.87, 381, 376, 0, 0, 0, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(61, '93752', 'ENGORDA MIX ROLADO 14%', 272.98, 313, 308, 0, 8, 0, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(62, '77753', 'ESTAMPIDA CLASICO 13%', 339.95, 380, 375, 0, 0, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(63, '77754', 'ESTAMPIDA TRABAJO', 315.64, 356, 351, 0, 13, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(64, '2659A', 'FELIX 1/2KG', 19.59, 24, 24, 0, 11, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(65, '2659', 'FELIX 10KG', 391.93, 420, 416, 0, 2, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(66, '81', 'FELIX LATA 156G', 13.99, 23, 20, 0, 9, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(67, '70773', 'FINALIZADOR PAVOS 5KG', 53.07, 63, 60, 0, 23, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(68, 'FC', 'FRENCHYS CAT 1/2KG', 17, 21, 21, 0, 17, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(69, '77001', 'GALLO MANTENIMIENTO 5 KG', 63.41, 75, 73, 0, 54, 5, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(70, '77008', 'GALLOS COMBATE 40KG', 400.46, 455, 445, 0, 0, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(71, '77006', 'GALLOS COMBATE 5KG', 65.74, 78, 75, 0, 6, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(72, '77003', 'GALLOS MANTENIMIENTOS 40KG', 461.04, 496, 496, 0, 0, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(73, 'MX000643', 'GANADOR ADULTO 25KG ', 800.58, 850, 845, 0, 1, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(74, 'MX000626', 'GANADOR ADULTO RAZAS PEQ 20KG', 681.98, 732, 727, 0, 1, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(75, 'MX011076', 'GANADOR CACHORRO 20KG ', 649.12, 690, 685, 0, 0, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(76, 'MX000637', 'GANADOR DUO 4KG', 141.5, 175, 175, 0, 2, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(77, '1234', 'GANADOR PREM ADUL RZA PEQ 4 KG', 196.34, 225, 222, 0, 2, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(78, 'MX011083', 'GANADOR PREM ADULTO RZA MD Y GDE 4KG', 194.65, 225, 215, 0, 3, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(79, 'MX013684', 'GANADOR PREMIUM ADULTO RAZAS MEDIANAS Y GD', 822.4, 882, 872, 0, 0, 0, 0, 'MALTA', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(80, 'MX013687', 'GANADOR PREMIUM ADULTO RP 20KG', 838.17, 898, 888, 0, 2, 0, 0, 'MALTA', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(81, 'MX013687A', 'GANADOR PREMIUM ADULTO RZ MD Y GD 1 KG ', 41.15, 45, 45, 0, 18, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(82, 'MX013678', 'GANADOR PREMIUM CACHORRO 20KG RAZAS MED Y GDE', 862.76, 922, 912, 0, 0, 0, 0, 'MALTA', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(83, 'MX013680', 'GANADOR PREMIUM CACHORRO 20KG RAZAS PEQ', 870.06, 930, 920, 0, 3, 0, 0, 'MALTA', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(84, 'MX013680A', 'GANADOR PREMIUM CACHORRO RZ PEQUEÑAS 1/2 KG ', 21.75, 26, 26, 0, 41, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(85, 'MX000626A', 'GANANDOR ADULTO RZ PEQUEÑAS 1 KG ', 34.09, 43, 43, 0, 8, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(86, '481A', 'GATINA 1/2KG', 15.19, 20, 20, 0, 17, 0, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(87, 'GA', 'GATINA 15KG', 455.81, 486, 486, 0, 0, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(88, 'HOB', 'HOBIPET 1KG', 13.96, 18, 18, 0, 22, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(89, '12502', 'HOBIPET 25KG', 349, 395, 390, 0, 8, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(90, 'GPOEH-0006', 'HOBIPET TOTAL 25KG', 419.95, 465, 460, 0, 3, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(91, '221', 'INIACIADOR GA 40KG', 444.45, 484, 479, 0, 9, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(92, '201', 'INICIADOR CERDOS C', 370.52, 411, 406, 0, 17, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(93, '70771', 'INICIADOR PAVOS 5KG', 59.83, 70, 67, 0, 13, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(94, '70766', 'INICIADOR POLLO  T 5KG', 51.81, 62, 59, 0, 0, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(95, '70764', 'INICIADOR POLLO T', 367.65, 408, 403, 0, 3, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(96, '1', 'INICIADOR POLLO T 1KG', 8.58, 13, 12, 0, 18, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(97, '95215A', 'KATTOS 1/2KG', 11.83, 16, 16, 0, 21, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(98, '95215', 'KATTOS 15KG', 355, 390, 385, 0, 16, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(99, '198', 'LINEA AVES ABC', 320.28, 360, 355, 0, 0, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(100, '199', 'LINEA AVES ABC 5KG', 44.72, 55, 52, 0, 11, 0, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(101, '75567', 'Lecheros 20% Tropico', 335.48, 375, 370, 0, 8, 0, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(102, '55077', 'MAIZ AMARILLO 40KG', 300, 340, 335, 0, 0, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(103, '61A', 'MAIZ ENTERO 1KG', 6.66, 11, 10, 0, 8, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(104, '66', 'MAIZ QUEBRADO 1KG', 7.9, 12, 12, 0, 0, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(105, '123', 'MAIZ QUEBRADO 40kg', 290, 330, 325, 0, 12, 0, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(106, '95601', 'MAIZ QUEBRADO 5KG', 44.54, 55, 52, 0, 42, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(107, '61', 'MAIZ QUEBRADO NU3', 304, 350, 345, 0, 2, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(108, 'MIN', 'MININO 1/2KG', 14.16, 18, 18, 0, 10, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(109, 'MX000586', 'MININO 15KG', 424.94, 469, 461, 0, 6, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(110, 'MX000593', 'MININO PLUS 10KG', 396.64, 435, 430, 0, 0, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(111, 'MON', 'MONTANA MULTIPARTICULA', 307.32, 352, 348, 0, 3, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(112, '99927', 'NUCAN ADULTO 1.8KG', 44.18, 65, 55, 0, 15, 0, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(113, '75', 'NUCAN ADULTO 1KG', 23.16, 27, 27, 0, 1, 0, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(114, '99926', 'NUCAN ADULTO 25KG', 579.07, 695, 623, 0, 4, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(115, '84959', 'NUCAN CACHORRO 1.8KG', 52.72, 70, 65, 0, 28, 0, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(116, '84958', 'NUCAN CACHORRO 20KG', 541.57, 695, 635, 0, 4, 0, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(117, '80895', 'NUCAT', 415.51, 450, 445, 0, 0, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(118, 'NUC', 'NUCAT 1.8KG', 54.66, 70, 60, 0, 3, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(119, '14', 'NUCAT 1/2KG', 13.79, 18, 18, 0, 21, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(120, 'NUPEA', 'NUPEC ADULTO 15KG', 803.88, 890, 870, 0, 0, 0, 0, 'NUPEC', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(121, 'NUPEA-01', 'NUPEC ADULTO 2KG', 133.98, 155, 155, 0, 3, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(122, 'NUPEC15', 'NUPEC CACHORRO 15KG', 934.14, 1150, 1000, 0, 1, 0, 0, 'NUPEC', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(123, 'NUPEC', 'NUPEC CACHORRO 2KG', 149.82, 175, 165, 0, 0, 0, 0, 'NUPEC', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(124, 'NUPEC8', 'NUPEC CACHORRO RAZAS PEQUEÑAS 8KG', 610.76, 670, 655, 0, 0, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(125, 'NUPEC FELINO', 'NUPEC FELINO KITTEN 1.5KG', 140.44, 155, 150, 0, 1, 0, 0, 'NUPEC', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(126, '263', 'NUPIG 1 BETA ', 711.36, 766, 761, 0, 1, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(127, '67487', 'NUPIG CUATRO ALFA 40KG', 649.92, 715, 709, 0, 7, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(128, '8', 'NUPIG CUATRO GAMA 1KG', 16.2, 22, 22, 0, 31, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(129, '268', 'NUPIG DOS ALFA', 876.48, 940, 935, 0, 16, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(130, '6', 'NUPIG DOS ALFA 1KG', 21.8, 28, 28, 0, 44, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(131, '285', 'NUPIG TRES ALFA', 741.12, 810, 800, 0, 10, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(132, '7', 'NUPIG TRES ALFA 1KG', 18.45, 23, 23, 0, 19, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(133, '487', 'NUPIG UNO OMEGA', 686.4, 745, 740, 0, 9, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(134, '5', 'NUPIG UNO OMEGA 1KG', 27.28, 33, 32, 0, 38, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(135, 'NUT2', 'NUTRESCAN 22KG', 326, 370, 361, 0, 0, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(136, 'NUT', 'NUTRESCAT 15KG', 420.76, 445, 440, 0, 10, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(137, '11', 'NUTRIMASCOTAS ADULTO 1KG', 38.84, 47, 47, 0, 6, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(138, '70438', 'NUTRIMASCOTAS ADULTO 20kg', 776.87, 1015, 850, 0, 10, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(139, '79146', 'NUTRIMASCOTAS ADULTO 5KG', 218.42, 285, 253, 0, 6, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(140, '10N', 'NUTRIMASCOTAS CACHORRO 1/2KG', 21.91, 28, 27, 0, 19, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(141, '70437', 'NUTRIMASCOTAS CACHORRO 20kg', 876.51, 1040, 945, 0, 2, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(142, '79145', 'NUTRIMASCOTAS CACHORRO 5KG', 243.69, 320, 280, 0, 7, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(143, '13', 'OPTIMO ADULTO 1KG', 27.34, 31, 31, 0, 6, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(144, '70444', 'OPTIMO ADULTO 25KG', 683.63, 765, 735, 0, 4, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(145, '80694', 'OPTIMO ADULTO 2KG', 75.17, 90, 82, 0, 6, 0, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(146, '80695', 'OPTIMO ADULTO 4KG', 129.01, 170, 143, 0, 4, 0, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(147, '70439', 'OPTIMO CACHORRO 20kg', 611.99, 750, 660, 0, 4, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(148, '80696', 'OPTIMO CACHORRO 2KG', 75.17, 90, 84, 0, 7, 0, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(149, '80697', 'OPTIMO CACHORRO 4KG', 142.45, 180, 158, 0, 5, 0, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(150, '80699', 'OPTIMO FELINO 1.5KG', 68.64, 85, 79, 0, 0, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(151, '70445', 'OPTIMO FELINO 20k', 673.84, 770, 725, 0, 0, 0, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(152, '57125A', 'PODER CANINO 1KG', 15.61, 20, 20, 0, 34, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(153, 'MX012307', 'PODER CANINO 25KG', 390.27, 430, 425, 0, 3, 0, 0, 'MALTA', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(154, '196', 'POSTURA 16%', 351.46, 391, 386, 0, 10, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(155, '197', 'POSTURA 5KG', 49.79, 60, 57, 0, 24, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(156, '5634', 'PRO PLAN ADULTO OPTIHEALT 13KG', 1373.29, 1574, 1574, 0, 1, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(157, '5700', 'PRO PLAN CACH SENSITIVE 13KG', 1652.12, 1760, 1760, 0, 2, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(158, '849', 'PROPLAN PUPPY OPTISTART 13KG', 1652.12, 1804, 1732, 0, 0, 0, 0, 'PROPLAN', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(159, '3164', 'PROPLAN SENSITIVE ADULTO 13KG', 1647.81, 1800, 1728, 0, 1, 0, 0, 'PROPLAN', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(160, '68662', 'RACTOPAMINA 10%', 411.2, 451, 446, 0, 3, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(161, '100326', 'RENDIPOLLO 40KG', 297.37, 337, 332, 0, 0, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(162, '205', 'REPRODUCTORA C', 330.27, 370, 365, 0, 2, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(163, '225', 'REPRODUCTORA GA 40KG', 362.77, 403, 398, 0, 7, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(164, '209', 'REPRODUCTORA LACTANCIA C', 353, 393, 388, 0, 18, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(165, '229', 'REPRODUCTORA LACTANCIA G.A', 425.72, 466, 461, 0, 10, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(166, 'ROCK', 'ROCKO PLUS 1KG', 16.75, 22, 22, 0, 7, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(167, 'LAD00035', 'ROCKO PLUS 25KG PERRO ADULTO', 418.77, 470, 460, 0, 2, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(168, '51', 'SAL MINERAL 1KG', 5.2, 10, 10, 0, 10, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(169, '79142', 'SAL MINERAL BOVINO 20KG', 110.83, 140, 136, 0, 0, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(170, '43', 'SALVADO 40KG', 220, 260, 255, 0, 0, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(171, '81S', 'SOBRE DE FELIX 85G', 10, 17, 17, 0, 9, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(172, 'MX011106', 'SOBRES DE CAMPI', 6.5, 8, 0, 0, 1333, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(173, 'SOB', 'SOBRES PURINA', 7.81, 10, 9, 0, 0, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(174, 'SUP', 'SUPERCACHORRO 22KG', 419.33, 459, 454, 0, 20, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(175, 'SCA', 'SUPERCAN AZUL 25KG', 352, 395, 392, 0, 0, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(176, 'SCF', 'SUPERCAN FEROZ ', 372.49, 413, 407, 0, 15, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(177, 'SUP2', 'SUPERCAN MAX 22KG', 360.51, 400, 395, 0, 4, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(178, 'SCM', 'SUPERCAN MESTIZO ', 236.61, 277, 275, 0, 2, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(179, '461', 'SUSTITUTO DE LECHE NUTRILAC 5KG', 186.85, 222, 222, 0, 1, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(180, '103', 'TERMINADOR POLLO FASE IV', 320.28, 360, 355, 0, 13, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(181, '70767', 'TERMINADOR POLLO T', 345.66, 386, 381, 0, 0, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(182, '48', 'TILAPIA 2 1KG', 16.34, 21, 21, 0, 7, 5, 0, 'Alpesur', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(183, 'TILA', 'TILAPIA VIMIFOS Crec 3205 25KG', 408.72, 448, 442, 0, 2, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(184, '48189', 'TILAPIA Vimifos ENGORDA 25KG', 368.52, 408, 402, 0, 8, 5, 0, 'MALTA', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(185, 'TITAN', 'TITAN 1KG', 22.47, 27, 27, 0, 26, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(186, 'LAD00011', 'TITAN 25KG PERRO ADULTO', 561.83, 615, 608, 0, 2, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(187, 'TG', 'TITAN GATO 1/2KG', 12.83, 17, 16, 0, 15, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(188, 'TIT', 'TITAN GATO 15KG', 367.59, 402, 395, 0, 0, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(189, 'MX000697', 'TOP CHOICE 25KG', 533.02, 570, 565, 0, 0, 0, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(190, 'PE121', 'VICENTINA 1 25KG', 492.96, 530, 523, 0, 37, 0, 0, 'NOGAL', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(191, 'PE122', 'VICENTINA 2 20KG', 535.13, 572, 565, 0, 6, 0, 0, 'NOGAL', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(192, 'LU121', 'VICENTINA 3 15KG', 413.64, 438, 433, 0, 4, 0, 0, 'NOGAL', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(193, 'NO121', 'VICENTINA 4 25KG', 419.26, 457, 449, 0, 3, 0, 0, 'NOGAL', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(194, 'ME121', 'VICENTINA 5 25KG', 422.91, 453, 448, 0, 16, 0, 0, 'NOGAL', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(195, 'VICENTINA8', 'VICENTINA 8 PAP 25KG', 667.73, 703, 698, 0, 0, 0, 0, 'NOGAL', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(196, 'VICENTINA7', 'VICENTINA7 NC 20KG', 508.82, 539, 534, 0, 20, 0, 0, 'NOGAL', 'Local', 'Actualizada', 'Registro de producto', 'Jely', 1),
(197, 'PRODUCT-PRUEBA-VENTAS', 'Producto para realizar pruebas', 2, 5, 4, 4, 98, 2, 0, '- Sin Departamento -', 'Local', 'Actualizada', 'Modificacion', 'Jely', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sucursal`
--

CREATE TABLE `sucursal` (
  `idSucursal` int(10) NOT NULL,
  `nombre` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `direccion` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `imagen` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `idUsuario` int(10) NOT NULL,
  `estatus` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `realizadaEn` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL,
  `estatusSucursal` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL,
  `operacion` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL,
  `propietario` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ticketc`
--

CREATE TABLE `ticketc` (
  `idTicket` int(11) NOT NULL,
  `numero` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `ticketc`
--

INSERT INTO `ticketc` (`idTicket`, `numero`) VALUES
(1, 35);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `traspaso`
--

CREATE TABLE `traspaso` (
  `idTraspaso` int(11) NOT NULL,
  `idSucursalE` int(11) NOT NULL,
  `idSucursalR` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  `propietario` varchar(50) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  `precioCompra` float NOT NULL,
  `cantidad` float NOT NULL,
  `monto` float NOT NULL,
  `fecha` date NOT NULL,
  `estatus` varchar(100) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `codigo` varchar(100) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `operacion` varchar(150) COLLATE utf8mb4_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` int(10) NOT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish2_ci NOT NULL,
  `direccion` varchar(255) COLLATE utf8_spanish2_ci NOT NULL,
  `username` varchar(255) COLLATE utf8_spanish2_ci NOT NULL,
  `password` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `tipoUsuario` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  `telefono` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  `eliminado` tinyint(1) NOT NULL DEFAULT 0,
  `fecha` date NOT NULL,
  `enSesion` tinyint(1) NOT NULL DEFAULT 0,
  `hora` time NOT NULL,
  `realizadaEn` varchar(100) CHARACTER SET utf16 COLLATE utf16_spanish2_ci NOT NULL,
  `estatus` varchar(100) CHARACTER SET utf16 COLLATE utf16_spanish2_ci NOT NULL,
  `operacion` varchar(100) CHARACTER SET utf16 COLLATE utf16_spanish2_ci NOT NULL,
  `propietario` varchar(150) CHARACTER SET utf16 COLLATE utf16_spanish2_ci NOT NULL,
  `idSucursal` int(11) NOT NULL,
  `foto` varchar(250) CHARACTER SET utf16 COLLATE utf16_spanish2_ci NOT NULL DEFAULT '2.jpg'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `nombre`, `direccion`, `username`, `password`, `tipoUsuario`, `telefono`, `eliminado`, `fecha`, `enSesion`, `hora`, `realizadaEn`, `estatus`, `operacion`, `propietario`, `idSucursal`, `foto`) VALUES
(1, 'Administrado', 'Administrador', 'Admin', '12345abcde', 'Administrador', '0000', 0, '2022-01-22', 1, '21:33:00', 'Local', 'Actualizada', 'Registro', 'Jely', 1, '2.jpg'),
(2, 'Jelitza Martinez', 'Dir #', 'jelitza.mtz@gmail.com', 'Pisa22', 'Superusuario', '0000', 0, '2022-01-12', 0, '23:11:47', 'Web', 'Actualizada', 'Registro', 'Jely', 1, '2.jpg'),
(3, 'Empleado', 'Dir#', 'Empleado', '12345abcde', 'Empleado', '0000', 0, '2022-01-19', 0, '01:46:39', 'Local', 'Actualizada', 'Registro', 'Jely', 1, '2.jpg'),
(4, 'Usuario tutorial modificado', 'direccion', 'memo@correo.com', '12345', 'Administrador', '248541', 1, '2022-01-18', 0, '23:36:04', 'Local', 'Actualizada', 'Eliminacion', 'Jely', 1, '2.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `idVenta` int(10) NOT NULL,
  `idTicket` int(10) NOT NULL,
  `idSucursal` int(11) NOT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish2_ci NOT NULL,
  `precioVenta` double NOT NULL,
  `importe` double NOT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  `idUsuario` int(10) NOT NULL,
  `idCliente` int(11) NOT NULL DEFAULT 0,
  `mayoreo` varchar(10) COLLATE utf8_spanish2_ci NOT NULL,
  `codigo` varchar(500) COLLATE utf8_spanish2_ci NOT NULL,
  `precioCosto` double NOT NULL,
  `cantidad` double NOT NULL,
  `revisada` tinyint(1) NOT NULL DEFAULT 0,
  `devolucion` tinyint(1) NOT NULL DEFAULT 0,
  `devocompleta` tinyint(1) NOT NULL DEFAULT 0,
  `tipoCompra` varchar(50) COLLATE utf8_spanish2_ci NOT NULL DEFAULT 'efectivo',
  `finalizada` tinyint(1) NOT NULL DEFAULT 1,
  `realizadaEn` varchar(150) COLLATE utf8_spanish2_ci NOT NULL,
  `estatus` varchar(150) COLLATE utf8_spanish2_ci NOT NULL,
  `operacion` varchar(200) COLLATE utf8_spanish2_ci NOT NULL,
  `propietario` varchar(100) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`idVenta`, `idTicket`, `idSucursal`, `nombre`, `precioVenta`, `importe`, `fecha`, `hora`, `idUsuario`, `idCliente`, `mayoreo`, `codigo`, `precioCosto`, `cantidad`, `revisada`, `devolucion`, `devocompleta`, `tipoCompra`, `finalizada`, `realizadaEn`, `estatus`, `operacion`, `propietario`) VALUES
(2, 1, 1, 'ALPET ADULTO 2KG', 76, 76, '2022-01-19', '11:56:38', 1, 0, 'NO', '84337', 55.74, 1, 0, 0, 0, 'efectivo', 1, 'Local', 'Actualizada', 'Registro', 'Jely'),
(3, 2, 1, 'ALPET ADULTO 2KG', 76, 76, '2022-01-19', '18:15:12', 1, 0, 'NO', '84337', 55.74, 1, 0, 0, 0, 'efectivo', 1, 'Local', 'En proceso', 'Registro', 'Jely'),
(4, 3, 1, 'ALPET CACHORRO 2KG', 85, 85, '2022-01-19', '18:19:19', 1, 0, 'NO', '84334', 70.35, 1, 0, 0, 0, 'efectivo', 1, 'Local', 'Actualizada', 'Registro', 'Jely'),
(5, 4, 1, 'AUDAZ 1KG', 23, 23, '2022-01-16', '16:20:35', 1, 0, 'NO', '65', 18.73, 1, 0, 0, 0, 'efectivo', 1, 'Local', 'Actualizada', 'Registro', 'Jely'),
(6, 5, 1, 'AUDAZ 1KG', 23, 23, '2022-01-16', '16:24:00', 1, 0, 'NO', '65', 18.73, 1, 0, 0, 0, 'efectivo', 1, 'Local', 'Actualizada', 'Registro', 'Jely'),
(7, 6, 1, 'BERISCAN CACHORRO 20kg', 585, 585, '2022-01-16', '16:26:40', 1, 0, 'NO', '53', 540, 1, 0, 0, 0, 'efectivo', 1, 'Local', 'Actualizada', 'Registro', 'Jely'),
(8, 7, 1, 'AUDAZ 1KG', 23, 23, '2022-01-16', '16:28:08', 1, 0, 'NO', '65', 18.73, 1, 0, 0, 0, 'efectivo', 1, 'Local', 'Actualizada', 'Registro', 'Jely'),
(9, 8, 1, 'BERISCAT 1/2KG', 19, 19, '2022-01-16', '16:30:14', 1, 0, 'NO', '69A', 15.16, 1, 0, 0, 0, 'efectivo', 1, 'Local', 'Actualizada', 'Registro', 'Jely'),
(10, 9, 1, 'CAMPEON 1KG', 31, 31, '2022-01-16', '16:36:23', 1, 0, 'NO', '656A', 27.69, 1, 0, 0, 0, 'efectivo', 1, 'Local', 'Actualizada', 'Registro', 'Jely'),
(11, 10, 1, 'BERISCAN PRO 1KG', 24, 48, '2022-01-16', '16:38:10', 1, 0, 'NO', '16', 19.16, 2, 0, 0, 0, 'efectivo', 1, 'Local', 'Actualizada', 'Registro', 'Jely'),
(12, 11, 1, 'BERISCAN PRO 25KG', 535, 1605, '2022-01-16', '16:40:52', 1, 0, 'NO', '15', 485, 3, 0, 0, 0, 'efectivo', 1, 'Local', 'Actualizada', 'Registro', 'Jely'),
(13, 12, 1, 'AUDAZ 1KG', 23, 23, '2022-01-16', '16:49:24', 1, 0, 'NO', '65', 18.73, 1, 0, 0, 0, 'efectivo', 1, 'Local', 'Actualizada', 'Registro', 'Jely'),
(14, 13, 1, 'BERISCAN CACHORRO 20kg', 585, 585, '2022-01-16', '17:02:33', 1, 0, 'NO', '53', 540, 1, 0, 0, 0, 'efectivo', 1, 'Local', 'Actualizada', 'Registro', 'Jely'),
(15, 14, 1, 'BERISCAN PRO 25KG', 535, 1070, '2022-01-16', '17:07:13', 1, 0, 'NO', '15', 485, 2, 0, 0, 0, 'efectivo', 1, 'Local', 'Actualizada', 'Registro', 'Jely'),
(16, 15, 1, 'BERISCAN CACHORRO 20kg', 585, 585, '2022-01-16', '17:09:03', 1, 0, 'NO', '53', 540, 1, 0, 0, 0, 'efectivo', 1, 'Local', 'Actualizada', 'Registro', 'Jely'),
(17, 16, 1, 'BERISCAN PRO 1KG', 24, 24, '2022-01-16', '17:09:39', 1, 0, 'NO', '16', 19.16, 1, 0, 0, 0, 'efectivo', 1, 'Local', 'Actualizada', 'Registro', 'Jely'),
(18, 17, 1, 'ALPET ADULTO 2KG', 76, 76, '2022-01-16', '17:14:54', 1, 0, 'NO', '84337', 55.74, 1, 0, 0, 0, 'efectivo', 1, 'Local', 'Actualizada', 'Registro', 'Jely'),
(19, 18, 1, 'BERISCAN PRO 1KG', 24, 24, '2022-01-16', '17:21:09', 1, 0, 'NO', '16', 19.16, 1, 0, 0, 0, 'efectivo', 1, 'Local', 'Actualizada', 'Registro', 'Jely'),
(20, 19, 1, 'BERISCAN PRO 25KG', 535, 535, '2022-01-16', '17:24:31', 1, 0, 'NO', '15', 485, 1, 0, 0, 0, 'efectivo', 1, 'Local', 'Actualizada', 'Registro', 'Jely'),
(21, 20, 1, 'ALPET CACHORRO 2KG', 85, 85, '2022-01-16', '17:48:07', 1, 0, 'NO', '84334', 70.35, 1, 0, 0, 0, 'efectivo', 1, 'Local', 'Actualizada', 'Registro', 'Jely'),
(22, 21, 1, 'AUDAZ 1KG', 23, 23, '2022-01-16', '18:19:17', 1, 0, 'NO', '65', 18.73, 1, 0, 0, 0, 'efectivo', 1, 'Local', 'Actualizada', 'Registro', 'Jely'),
(23, 22, 1, 'ALPET CACHORRO 2KG', 85, 85, '2022-01-16', '18:19:27', 1, 0, 'NO', '84334', 70.35, 1, 0, 0, 0, 'efectivo', 1, 'Local', 'Actualizada', 'Registro', 'Jely'),
(24, 23, 1, 'AUDAZ 1KG', 23, 23, '2022-01-16', '18:21:10', 1, 0, 'NO', '65', 18.73, 1, 0, 0, 0, 'efectivo', 1, 'Local', 'Actualizada', 'Registro', 'Jely'),
(25, 24, 1, 'BERISCAN CACHORRO 20kg', 585, 585, '2022-01-16', '18:23:57', 1, 0, 'NO', '53', 540, 1, 0, 0, 0, 'efectivo', 1, 'Local', 'Actualizada', 'Registro', 'Jely'),
(26, 25, 1, 'ALPET CACHORRO 2KG', 85, 85, '2022-01-16', '18:27:01', 1, 0, 'NO', '84334', 70.35, 1, 0, 0, 0, 'efectivo', 1, 'Local', 'Actualizada', 'Registro', 'Jely'),
(27, 26, 1, 'AUDAZ 1KG', 23, 23, '2022-01-19', '20:31:00', 1, 0, 'NO', '65', 18.73, 1, 0, 0, 0, 'efectivo', 1, 'Local', 'Actualizada', 'Registro', 'Jely'),
(28, 27, 1, 'BERISCAN CACHORRO 20kg', 585, 585, '2022-01-19', '20:34:00', 1, 0, 'NO', '53', 540, 1, 0, 0, 0, 'efectivo', 1, 'Local', 'Actualizada', 'Registro', 'Jely'),
(29, 28, 1, 'BERISCAN PRO 1KG', 24, 48, '2022-01-19', '20:39:00', 1, 0, 'NO', '16', 19.16, 2, 0, 0, 0, 'efectivo', 1, 'Local', 'Actualizada', 'Registro', 'Jely'),
(30, 29, 1, 'BERISCAN CACHORRO 20kg', 585, 585, '2022-01-19', '20:41:00', 1, 0, 'NO', '53', 540, 1, 0, 0, 0, 'efectivo', 1, 'Local', 'Actualizada', 'Registro', 'Jely'),
(31, 30, 1, 'BERISCAN CACHORRO 20kg', 585, 585, '2022-01-19', '20:44:00', 1, 0, 'NO', '53', 540, 1, 0, 0, 0, 'efectivo', 1, 'Local', 'Actualizada', 'Registro', 'Jely'),
(32, 31, 1, 'AUDAZ 1KG', 23, 23, '2022-01-19', '22:45:00', 1, 0, 'NO', '65', 18.73, 1, 0, 0, 0, 'efectivo', 1, 'Local', 'Actualizada', 'Registro', 'Jely'),
(33, 32, 1, 'BERISCAN PRO 1KG', 24, 24, '2022-01-19', '22:47:00', 1, 0, 'NO', '16', 19.16, 1, 0, 0, 0, 'efectivo', 1, 'Local', 'Actualizada', 'Registro', 'Jely'),
(34, 33, 1, 'BERISCAN CACHORRO 20kg', 585, 585, '2022-01-19', '22:49:00', 1, 0, 'NO', '53', 540, 1, 0, 0, 0, 'efectivo', 1, 'Local', 'Actualizada', 'Registro', 'Jely'),
(35, 34, 1, 'ALPET CACHORRO 2KG', 85, 85, '2022-01-19', '22:52:00', 1, 0, 'NO', '84334', 70.35, 1, 0, 0, 0, 'efectivo', 1, 'Local', 'Actualizada', 'Registro', 'Jely');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `area`
--
ALTER TABLE `area`
  ADD PRIMARY KEY (`idArea`);

--
-- Indices de la tabla `bitacora`
--
ALTER TABLE `bitacora`
  ADD PRIMARY KEY (`idBitacora`),
  ADD KEY `FKBitacora453434` (`idUsuario`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idCliente`);

--
-- Indices de la tabla `configuracion`
--
ALTER TABLE `configuracion`
  ADD PRIMARY KEY (`idConfiguracion`);

--
-- Indices de la tabla `credito`
--
ALTER TABLE `credito`
  ADD PRIMARY KEY (`idCredito`);

--
-- Indices de la tabla `errores`
--
ALTER TABLE `errores`
  ADD PRIMARY KEY (`idError`);

--
-- Indices de la tabla `movimientos_extras`
--
ALTER TABLE `movimientos_extras`
  ADD PRIMARY KEY (`idMovimiento`);

--
-- Indices de la tabla `movimientos_inventario`
--
ALTER TABLE `movimientos_inventario`
  ADD PRIMARY KEY (`idMovInv`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idProducto`);

--
-- Indices de la tabla `sucursal`
--
ALTER TABLE `sucursal`
  ADD PRIMARY KEY (`idSucursal`);

--
-- Indices de la tabla `ticketc`
--
ALTER TABLE `ticketc`
  ADD PRIMARY KEY (`idTicket`);

--
-- Indices de la tabla `traspaso`
--
ALTER TABLE `traspaso`
  ADD PRIMARY KEY (`idTraspaso`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`idVenta`),
  ADD KEY `FKVentas635259` (`idUsuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `area`
--
ALTER TABLE `area`
  MODIFY `idArea` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `bitacora`
--
ALTER TABLE `bitacora`
  MODIFY `idBitacora` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=92;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idCliente` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `configuracion`
--
ALTER TABLE `configuracion`
  MODIFY `idConfiguracion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `credito`
--
ALTER TABLE `credito`
  MODIFY `idCredito` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `errores`
--
ALTER TABLE `errores`
  MODIFY `idError` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `movimientos_extras`
--
ALTER TABLE `movimientos_extras`
  MODIFY `idMovimiento` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `movimientos_inventario`
--
ALTER TABLE `movimientos_inventario`
  MODIFY `idMovInv` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `idProducto` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=198;

--
-- AUTO_INCREMENT de la tabla `sucursal`
--
ALTER TABLE `sucursal`
  MODIFY `idSucursal` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `ticketc`
--
ALTER TABLE `ticketc`
  MODIFY `idTicket` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `traspaso`
--
ALTER TABLE `traspaso`
  MODIFY `idTraspaso` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idUsuario` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `idVenta` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `bitacora`
--
ALTER TABLE `bitacora`
  ADD CONSTRAINT `FKBitacora453434` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`);

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `FKVentas635259` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
