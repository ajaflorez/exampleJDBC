delimiter $$

CREATE DATABASE `essalud` /*!40100 DEFAULT CHARACTER SET utf8 */$$



delimiter $$

CREATE TABLE `asegurado` (
  `autogenerado` varchar(15) NOT NULL,
  `dni` varchar(8) DEFAULT NULL,
  `paterno` varchar(40) DEFAULT NULL,
  `materno` varchar(40) DEFAULT NULL,
  `nombres` varchar(40) DEFAULT NULL,
  `his_cli` varchar(6) DEFAULT NULL,
  `tipo` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`autogenerado`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8$$

delimiter $$

CREATE TABLE `cita` (
  `idcita` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `hora` timestamp NULL DEFAULT NULL,
  `idprogramacion` int(11) DEFAULT NULL,
  `orden` int(11) DEFAULT NULL,
  `autogenerado` varchar(15) DEFAULT NULL,
  `idcondicion` varchar(2) DEFAULT NULL,
  `actomedico` int(11) DEFAULT NULL,
  `idterminalista` varchar(2) DEFAULT NULL,
  `fechatime` datetime DEFAULT NULL,
  PRIMARY KEY (`idcita`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$

delimiter $$

CREATE TABLE `condicion` (
  `idcondicion` varchar(2) NOT NULL,
  `descondicion` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`idcondicion`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8$$

delimiter $$

CREATE TABLE `especialidad` (
  `idespecial` varchar(2) NOT NULL,
  `desespecial` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idespecial`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8$$

delimiter $$

CREATE TABLE `medico` (
  `idmedico` varchar(3) NOT NULL,
  `paterno` varchar(40) DEFAULT NULL,
  `materno` varchar(40) DEFAULT NULL,
  `nombres` varchar(40) DEFAULT NULL,
  `idespecial` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`idmedico`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8$$

delimiter $$

CREATE TABLE `programacion` (
  `idprogramacion` int(11) NOT NULL AUTO_INCREMENT,
  `idmedico` varchar(3) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `consultorio` varchar(3) DEFAULT NULL,
  `idtipoaten` varchar(2) DEFAULT NULL,
  `total` int(11) DEFAULT NULL,
  `idturno` varchar(1) DEFAULT NULL,
  `tiempo` int(11) DEFAULT NULL,
  PRIMARY KEY (`idprogramacion`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8$$

delimiter $$

CREATE TABLE `terminalista` (
  `idterminalista` varchar(2) NOT NULL,
  `paterno` varchar(40) DEFAULT NULL,
  `materno` varchar(40) DEFAULT NULL,
  `nombres` varchar(40) DEFAULT NULL,
  `login` varchar(20) DEFAULT NULL,
  `password` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`idterminalista`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8$$

delimiter $$

CREATE TABLE `tipoase` (
  `tipo` varchar(1) NOT NULL,
  `desc_tipo` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`tipo`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8$$

delimiter $$

CREATE TABLE `tipoaten` (
  `idtipoaten` varchar(2) NOT NULL,
  `destipoaten` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`idtipoaten`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8$$

delimiter $$

CREATE TABLE `turno` (
  `idturno` varchar(1) NOT NULL,
  `desturno` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idturno`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8$$

