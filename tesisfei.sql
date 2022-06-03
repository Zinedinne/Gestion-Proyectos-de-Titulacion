-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-06-2022 a las 19:03:19
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tesisfei`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `archivopdf`
--

CREATE TABLE `archivopdf` (
  `idProyecto` int(11) NOT NULL,
  `nombre` varchar(9) NOT NULL,
  `archivo` mediumblob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudiante`
--

CREATE TABLE `estudiante` (
  `matricula` varchar(9) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `clave` varchar(4) NOT NULL,
  `idProyecto` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `estudiante`
--

INSERT INTO `estudiante` (`matricula`, `nombre`, `clave`, `idProyecto`) VALUES
('S20015715', 'Saraí Castillo', 'ISOF', 12);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `licenciaturaadscrita`
--

CREATE TABLE `licenciaturaadscrita` (
  `idLicenciaturaAdscrita` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `clave` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `licenciaturaperteneciente`
--

CREATE TABLE `licenciaturaperteneciente` (
  `idLicenciaturaPerteneciente` int(11) NOT NULL,
  `clave` varchar(4) NOT NULL,
  `numeroDePersonal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `participa`
--

CREATE TABLE `participa` (
  `idParticipa` int(11) NOT NULL,
  `rol` varchar(20) NOT NULL,
  `numeroDePersonal` int(11) DEFAULT NULL,
  `idProyecto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `participa`
--

INSERT INTO `participa` (`idParticipa`, `rol`, `numeroDePersonal`, `idProyecto`) VALUES
(36, 'Director', 9876, 11),
(37, 'Sinodal', 7456, 11),
(38, 'Sinodal', 7456, 11),
(39, 'Director', 9876, 12),
(40, 'Sinodal', 7456, 12),
(41, 'Sinodal', 7456, 12);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesor`
--

CREATE TABLE `profesor` (
  `nombre` varchar(50) NOT NULL,
  `numeroDePersonal` int(11) NOT NULL,
  `tipoDeProfesor` varchar(20) NOT NULL,
  `clave` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `profesor`
--

INSERT INTO `profesor` (`nombre`, `numeroDePersonal`, `tipoDeProfesor`, `clave`) VALUES
('Juan Carlos Pérez Arriaga', 9876, 'Tiempo completo', 'ISOF'),
('Juana Lopez Vega', 4563, 'Por horas', 'ISOF'),
('Maria de los Angeles Arenas', 1543, 'Tiempo completo', 'RSCO'),
('Sergio Castillo Valerio', 5784, 'Tiempo completo', 'TSCO'),
('Ana Luz Polo', 7456, 'Tiempo completo', 'ISOF'),
('Angel Juan Sanchez Lopez', 9564, 'Por horas', 'RSCO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `programaeducativo`
--

CREATE TABLE `programaeducativo` (
  `clave` varchar(4) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `tipo` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `programaeducativo`
--

INSERT INTO `programaeducativo` (`clave`, `nombre`, `tipo`) VALUES
('ISOF', 'Ingeniería en Software', 'Licenciatura'),
('RSCO', 'Redes y Servicios de Computo', 'Licenciatura'),
('CYTE', 'Ciencias y Técnicas Estadísticas', 'Licenciatura'),
('ESTA', 'Estadística', 'Licenciatura'),
('TSCO', 'Tecnologías Computacionales', 'Licenciatura'),
('MEST', 'Métodos Estadísticos', 'Especialidad'),
('SICU', 'Sistemas Interactivos Centrados en el Usuario', 'Maestría'),
('ESAP', 'Estadística Aplicada', 'Maestría'),
('GECA', 'Gestión de Calidad', 'Maestría'),
('CICO', 'Ciencias de la Computación', 'Doctorado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proyectodetitulación`
--

CREATE TABLE `proyectodetitulación` (
  `idProyecto` int(11) NOT NULL,
  `titulo` varchar(100) NOT NULL,
  `descripcion` varchar(250) NOT NULL,
  `modalidad` varchar(50) NOT NULL,
  `resultado` varchar(50) NOT NULL,
  `fechaDeTitulacion` date NOT NULL,
  `clave` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `proyectodetitulación`
--

INSERT INTO `proyectodetitulación` (`idProyecto`, `titulo`, `descripcion`, `modalidad`, `resultado`, `fechaDeTitulacion`, `clave`) VALUES
(11, 'Salud', 'Priorizar salud', 'Tesis', 'Aprobado', '2022-04-08', 'ISOF'),
(12, 'salud mental', 'Priorizar salud mental', 'Tesis', 'Aprobado', '2022-05-15', 'ISOF');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `telefono` int(11) NOT NULL,
  `correoInstitucional` varchar(50) NOT NULL,
  `rol` varchar(20) NOT NULL,
  `tipoDePersonal` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuariopass`
--

CREATE TABLE `usuariopass` (
  `usuario` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `idUsuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `archivopdf`
--
ALTER TABLE `archivopdf`
  ADD KEY `idProyecto` (`idProyecto`);

--
-- Indices de la tabla `estudiante`
--
ALTER TABLE `estudiante`
  ADD KEY `matricula` (`matricula`),
  ADD KEY `clave` (`clave`),
  ADD KEY `idProyecto` (`idProyecto`);

--
-- Indices de la tabla `licenciaturaadscrita`
--
ALTER TABLE `licenciaturaadscrita`
  ADD KEY `idLicenciaturaAdscrita` (`idLicenciaturaAdscrita`),
  ADD KEY `idUsuario` (`idUsuario`),
  ADD KEY `clave` (`clave`);

--
-- Indices de la tabla `licenciaturaperteneciente`
--
ALTER TABLE `licenciaturaperteneciente`
  ADD KEY `clave` (`clave`),
  ADD KEY `numeroDePersonal` (`numeroDePersonal`),
  ADD KEY `idLicenciaturaPerteneciente` (`idLicenciaturaPerteneciente`);

--
-- Indices de la tabla `participa`
--
ALTER TABLE `participa`
  ADD PRIMARY KEY (`idParticipa`),
  ADD KEY `idParticipa` (`idParticipa`),
  ADD KEY `idProyecto` (`idProyecto`),
  ADD KEY `numeroDePersonal` (`numeroDePersonal`);

--
-- Indices de la tabla `profesor`
--
ALTER TABLE `profesor`
  ADD KEY `numeroDePersonal` (`numeroDePersonal`),
  ADD KEY `clave` (`clave`);

--
-- Indices de la tabla `programaeducativo`
--
ALTER TABLE `programaeducativo`
  ADD KEY `clave` (`clave`);

--
-- Indices de la tabla `proyectodetitulación`
--
ALTER TABLE `proyectodetitulación`
  ADD KEY `idProyecto` (`idProyecto`),
  ADD KEY `clave` (`clave`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD KEY `idUsuario` (`idUsuario`);

--
-- Indices de la tabla `usuariopass`
--
ALTER TABLE `usuariopass`
  ADD KEY `usuario` (`usuario`),
  ADD KEY `idUsuario` (`idUsuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `licenciaturaadscrita`
--
ALTER TABLE `licenciaturaadscrita`
  MODIFY `idLicenciaturaAdscrita` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `licenciaturaperteneciente`
--
ALTER TABLE `licenciaturaperteneciente`
  MODIFY `idLicenciaturaPerteneciente` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `participa`
--
ALTER TABLE `participa`
  MODIFY `idParticipa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- AUTO_INCREMENT de la tabla `proyectodetitulación`
--
ALTER TABLE `proyectodetitulación`
  MODIFY `idProyecto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `archivopdf`
--
ALTER TABLE `archivopdf`
  ADD CONSTRAINT `archivopdf_ibfk_1` FOREIGN KEY (`idProyecto`) REFERENCES `proyectodetitulación` (`idProyecto`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `estudiante`
--
ALTER TABLE `estudiante`
  ADD CONSTRAINT `estudiante_ibfk_1` FOREIGN KEY (`clave`) REFERENCES `programaeducativo` (`clave`) ON UPDATE NO ACTION,
  ADD CONSTRAINT `estudiante_ibfk_2` FOREIGN KEY (`idProyecto`) REFERENCES `proyectodetitulación` (`idProyecto`) ON UPDATE NO ACTION;

--
-- Filtros para la tabla `licenciaturaadscrita`
--
ALTER TABLE `licenciaturaadscrita`
  ADD CONSTRAINT `licenciaturaadscrita_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON UPDATE NO ACTION,
  ADD CONSTRAINT `licenciaturaadscrita_ibfk_2` FOREIGN KEY (`clave`) REFERENCES `programaeducativo` (`clave`) ON UPDATE NO ACTION;

--
-- Filtros para la tabla `licenciaturaperteneciente`
--
ALTER TABLE `licenciaturaperteneciente`
  ADD CONSTRAINT `licenciaturaperteneciente_ibfk_1` FOREIGN KEY (`clave`) REFERENCES `programaeducativo` (`clave`) ON UPDATE NO ACTION,
  ADD CONSTRAINT `licenciaturaperteneciente_ibfk_2` FOREIGN KEY (`numeroDePersonal`) REFERENCES `profesor` (`numeroDePersonal`) ON UPDATE NO ACTION;

--
-- Filtros para la tabla `participa`
--
ALTER TABLE `participa`
  ADD CONSTRAINT `participa_ibfk_1` FOREIGN KEY (`idProyecto`) REFERENCES `proyectodetitulación` (`idProyecto`) ON UPDATE NO ACTION;

--
-- Filtros para la tabla `profesor`
--
ALTER TABLE `profesor`
  ADD CONSTRAINT `profesor_ibfk_1` FOREIGN KEY (`clave`) REFERENCES `programaeducativo` (`clave`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `proyectodetitulación`
--
ALTER TABLE `proyectodetitulación`
  ADD CONSTRAINT `proyectodetitulación_ibfk_1` FOREIGN KEY (`clave`) REFERENCES `programaeducativo` (`clave`) ON UPDATE NO ACTION;

--
-- Filtros para la tabla `usuariopass`
--
ALTER TABLE `usuariopass`
  ADD CONSTRAINT `usuariopass_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
