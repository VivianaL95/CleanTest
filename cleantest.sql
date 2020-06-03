-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-06-2020 a las 12:29:18
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cleantest`
--
CREATE DATABASE IF NOT EXISTS `cleantest` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci;
USE `cleantest`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bet`
--

CREATE TABLE `bet` (
  `id` int(10) UNSIGNED NOT NULL,
  `number` int(10) UNSIGNED DEFAULT NULL,
  `color` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL,
  `value` double NOT NULL,
  `id_roulette` int(10) UNSIGNED NOT NULL,
  `id_user` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `bet`
--

INSERT INTO `bet` (`id`, `number`, `color`, `value`, `id_roulette`, `id_user`) VALUES
(1, 20, 'BLACK', 1000, 1, 1),
(2, 20, 'BLACK', 1000, 1, 1),
(3, 0, 'BLACK', 1000, 1, 1),
(4, 20, NULL, 1000, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roulette`
--

CREATE TABLE `roulette` (
  `id` int(10) UNSIGNED NOT NULL,
  `state` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `roulette`
--

INSERT INTO `roulette` (`id`, `state`) VALUES
(1, 1),
(2, 0),
(3, 0),
(4, 0),
(5, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `id` int(10) UNSIGNED NOT NULL,
  `balance` double UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id`, `balance`) VALUES
(1, 1000000),
(2, 1000);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `bet`
--
ALTER TABLE `bet`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `roulette`
--
ALTER TABLE `roulette`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `bet`
--
ALTER TABLE `bet`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `roulette`
--
ALTER TABLE `roulette`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
