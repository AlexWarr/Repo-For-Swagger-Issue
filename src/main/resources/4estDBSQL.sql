-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema 4est
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `4est` ;

-- -----------------------------------------------------
-- Schema 4est
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `4est` DEFAULT CHARACTER SET utf8 ;
USE `4est` ;

-- -----------------------------------------------------
-- Table `4est`.`Plant_Species`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `4est`.`Plant_Species` ;

CREATE TABLE IF NOT EXISTS `4est`.`Plant_Species` (
  `Plant_Latin_Name` VARCHAR(100) NOT NULL,
  `Plant_Common_Name` VARCHAR(50) NOT NULL,
  `Plant_Phylum` VARCHAR(45) NOT NULL,
  `Body_Trunk_Stem_Description` LONGTEXT NOT NULL,
  `Branch_Leaf_Pattern_Description` LONGTEXT NOT NULL,
  `Flower_Fruit_Description` LONGTEXT NOT NULL,
  `Toxic` TINYINT NOT NULL,
  `Edible` TINYINT NOT NULL,
  `Medicinal` TINYINT NOT NULL,
  `Plant_Description` LONGTEXT NOT NULL,
  PRIMARY KEY (`Plant_Latin_Name`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `4est`.`Location`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `4est`.`Location` ;

CREATE TABLE IF NOT EXISTS `4est`.`Location` (
  `Location_Name` VARCHAR(60) NOT NULL,
  `Geography` VARCHAR(45) NOT NULL,
  `Vegitative_Zone` VARCHAR(45) NOT NULL,
  `Growing_Zone` VARCHAR(10) NULL,
  `Elevation` INT NULL,
  `Location_Notes` LONGTEXT NOT NULL,
  PRIMARY KEY (`Location_Name`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `4est`.`Plant`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `4est`.`Plant` ;

CREATE TABLE IF NOT EXISTS `4est`.`Plant` (
  `Plant_ID` INT NOT NULL AUTO_INCREMENT,
  `Body_Trunk_Stem_Description` LONGTEXT NULL,
  `Branch_Leaf_Pattern_Description` LONGTEXT NULL,
  `Flower_Fruit_Description` LONGTEXT NULL,
  `Plant_Notes` LONGTEXT NOT NULL,
  `Plant_Species_Plant_Latin_Name` VARCHAR(100) NOT NULL,
  `Location_Location_Name` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`Plant_ID`, `Plant_Species_Plant_Latin_Name`, `Location_Location_Name`),
  CONSTRAINT `fk_Plant_Plant_Species1`
    FOREIGN KEY (`Plant_Species_Plant_Latin_Name`)
    REFERENCES `4est`.`Plant_Species` (`Plant_Latin_Name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Plant_Location1`
    FOREIGN KEY (`Location_Location_Name`)
    REFERENCES `4est`.`Location` (`Location_Name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `Plant_ID_UNIQUE` ON `4est`.`Plant` (`Plant_ID` ASC) VISIBLE;

CREATE INDEX `fk_Plant_Plant_Species1_idx` ON `4est`.`Plant` (`Plant_Species_Plant_Latin_Name` ASC) VISIBLE;

CREATE INDEX `fk_Plant_Location1_idx` ON `4est`.`Plant` (`Location_Location_Name` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `4est`.`Moment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `4est`.`Moment` ;

CREATE TABLE IF NOT EXISTS `4est`.`Moment` (
  `Date` DATETIME NOT NULL,
  `Season` VARCHAR(45) NOT NULL,
  `Plant_Growth_Phase` VARCHAR(45) NOT NULL,
  `Weather` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Date`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `Date_UNIQUE` ON `4est`.`Moment` (`Date` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `4est`.`Entry`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `4est`.`Entry` ;

CREATE TABLE IF NOT EXISTS `4est`.`Entry` (
  `Entry_Number` INT NOT NULL AUTO_INCREMENT,
  `Notes` LONGTEXT NOT NULL,
  `Location_Location_Name` VARCHAR(60) NOT NULL,
  `Plant_Plant_ID` INT NOT NULL,
  `Plant_Plant_Species_Plant_Latin_Name` VARCHAR(100) NOT NULL,
  `Moment_Date` DATETIME NOT NULL,
  PRIMARY KEY (`Entry_Number`, `Location_Location_Name`, `Plant_Plant_ID`, `Plant_Plant_Species_Plant_Latin_Name`, `Moment_Date`),
  CONSTRAINT `fk_Entry_Location1`
    FOREIGN KEY (`Location_Location_Name`)
    REFERENCES `4est`.`Location` (`Location_Name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Entry_Plant1`
    FOREIGN KEY (`Plant_Plant_ID` , `Plant_Plant_Species_Plant_Latin_Name`)
    REFERENCES `4est`.`Plant` (`Plant_ID` , `Plant_Species_Plant_Latin_Name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Entry_Moment1`
    FOREIGN KEY (`Moment_Date`)
    REFERENCES `4est`.`Moment` (`Date`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Entry_Location1_idx` ON `4est`.`Entry` (`Location_Location_Name` ASC) VISIBLE;

CREATE INDEX `fk_Entry_Plant1_idx` ON `4est`.`Entry` (`Plant_Plant_ID` ASC, `Plant_Plant_Species_Plant_Latin_Name` ASC) VISIBLE;

CREATE INDEX `fk_Entry_Moment1_idx` ON `4est`.`Entry` (`Moment_Date` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `4est`.`timestamps`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `4est`.`timestamps` ;

CREATE TABLE IF NOT EXISTS `4est`.`timestamps` (
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL);


-- -----------------------------------------------------
-- Table `4est`.`Location_has_Plant_Species`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `4est`.`Location_has_Plant_Species` ;

CREATE TABLE IF NOT EXISTS `4est`.`Location_has_Plant_Species` (
  `Location_Location_Name` VARCHAR(60) NOT NULL,
  `Plant_Species_Plant_Latin_Name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`Location_Location_Name`, `Plant_Species_Plant_Latin_Name`),
  CONSTRAINT `fk_Location_has_Plant_Species_Location`
    FOREIGN KEY (`Location_Location_Name`)
    REFERENCES `4est`.`Location` (`Location_Name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Location_has_Plant_Species_Plant_Species1`
    FOREIGN KEY (`Plant_Species_Plant_Latin_Name`)
    REFERENCES `4est`.`Plant_Species` (`Plant_Latin_Name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Location_has_Plant_Species_Plant_Species1_idx` ON `4est`.`Location_has_Plant_Species` (`Plant_Species_Plant_Latin_Name` ASC) VISIBLE;

CREATE INDEX `fk_Location_has_Plant_Species_Location_idx` ON `4est`.`Location_has_Plant_Species` (`Location_Location_Name` ASC) VISIBLE;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
