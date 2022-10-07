-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.9.1-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para salones
CREATE DATABASE IF NOT EXISTS `salones` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `salones`;

-- Volcando estructura para tabla salones.alquiler
CREATE TABLE IF NOT EXISTS `alquiler` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `fecha` datetime NOT NULL,
  `hora_inicio` time NOT NULL,
  `hora_salida` time NOT NULL,
  `valor` decimal(8,2) NOT NULL DEFAULT 0.00,
  PRIMARY KEY (`id`,`username`,`fecha`) USING BTREE,
  KEY `FK_usuario` (`username`),
  CONSTRAINT `FK_salon` FOREIGN KEY (`id`) REFERENCES `salon` (`id`),
  CONSTRAINT `FK_usuario` FOREIGN KEY (`username`) REFERENCES `usuario` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla salones.alquiler: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `alquiler` DISABLE KEYS */;
/*!40000 ALTER TABLE `alquiler` ENABLE KEYS */;

-- Volcando estructura para tabla salones.salon
CREATE TABLE IF NOT EXISTS `salon` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `categoria` varchar(100) DEFAULT NULL,
  `capacidad` int(4) DEFAULT NULL,
  `valor_hora` decimal(8,2) DEFAULT NULL,
  `novedad` tinyint(4) DEFAULT NULL,
  `descripcion` varchar(250) DEFAULT NULL,
  `bandera` binary(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla salones.salon: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `salon` DISABLE KEYS */;
INSERT INTO `salon` (`id`, `nombre`, `categoria`, `capacidad`, `valor_hora`, `novedad`, `descripcion`, `bandera`) VALUES
	(1, 'La vida es bella', 'Conferencias ', 50, 200000.00, 0, 'El salón se encuentra dotado de proyector, canaletas, mesas y sillas para un MAXómo de 50 personas.', _binary 0x31),
	(2, 'Lluvia de oro', 'Reunión Social', 200, 100000.00, 0, 'El salón tiene capacidad para 200 invitados', _binary 0x31),
	(3, 'Noche en las Vegas', 'Love Party', 300, 200000.00, 1, 'El salón permite albegar a 350 invitados, tiene servicio de baño privado, barra - cocina, luces estreboscópica, maquina de humo', _binary 0x31);
/*!40000 ALTER TABLE `salon` ENABLE KEYS */;

-- Volcando estructura para tabla salones.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `username` varchar(50) NOT NULL,
  `contrasena` varchar(50) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `apellidos` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `telefono` int(10) DEFAULT NULL,
  `saldo` double(22,2) DEFAULT NULL,
  `premium` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla salones.usuario: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`username`, `contrasena`, `nombre`, `apellidos`, `email`, `direccion`, `telefono`, `saldo`, `premium`) VALUES
	('Jesus', '00000', 'Jesus', 'Porras', 'jesus@gmail.com', 'Carrera 2 5-6', 145203, 500000.00, 1),
	('Sofia', '123', 'Sofia M', 'Otalora', 'sofi@gmail.com', 'Carrera 1 23-32', 145203, 150000.00, 0),
	('Stephany', '1234', 'Stephany', 'Otalora', 'ota@gmil.com', 'Calle 1 34-56', 310369, 1000000.00, 1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
