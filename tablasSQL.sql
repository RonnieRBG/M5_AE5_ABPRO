CREATE SCHEMA `gestionclientes` ;

CREATE TABLE `gestionclientes`.`new_table` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `gestionclientes`.`clientes` (
  `id` VARCHAR(45) NOT NULL AUTO_INCREMENT,
  `nombres` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NULL,
  `telefono` INT NULL,
  PRIMARY KEY (`id`));

