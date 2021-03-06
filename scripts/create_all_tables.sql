SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `student_grade_management` DEFAULT CHARACTER SET latin1 ;
USE `student_grade_management` ;

-- -----------------------------------------------------
-- Table `student_grade_management`.`faculty`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `student_grade_management`.`faculty` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Title` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `student_grade_management`.`user_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `student_grade_management`.`user_type` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `User_ID` INT(11) NOT NULL,
  `Type_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_user_roles` (`User_ID`),
  CONSTRAINT `FK_user_roles` 
		FOREIGN KEY (`User_ID`) 
		REFERENCES `student_grade_management`.`user` (`ID`)
		ON DELETE CASCADE
		ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `student_grade_management`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `student_grade_management`.`user` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  `Surname` VARCHAR(45) NOT NULL,
  `Username` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  `Active` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`))

  
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `student_grade_management`.`task`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `student_grade_management`.`task` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Title` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `student_grade_management`.`university_subject`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `student_grade_management`.`university_subject` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Title` VARCHAR(255) NOT NULL,
  `Faculty_ID` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `university_subject_ibfk_1_idx` (`Faculty_ID` ASC),
  CONSTRAINT `university_subject_ibfk_1`
    FOREIGN KEY (`Faculty_ID`)
    REFERENCES `student_grade_management`.`faculty` (`ID`)
		ON DELETE CASCADE
		ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `student_grade_management`.`student_group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `student_grade_management`.`student_group` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Title` VARCHAR(255) NOT NULL,
  `Course` INT(11) NOT NULL,
  `Professor_ID` INT(11) NOT NULL,
  `Subject_ID` INT(11) NOT NULL,
  `Faculty_ID` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `Subject_ID` (`Subject_ID` ASC),
  INDEX `Faculty_ID` (`Faculty_ID` ASC),
  INDEX `student_group_ibfk_1_idx` (`Professor_ID` ASC),
  CONSTRAINT `student_group_ibfk_1`
    FOREIGN KEY (`Professor_ID`)
    REFERENCES `student_grade_management`.`user` (`ID`)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
  CONSTRAINT `student_group_ibfk_2`
    FOREIGN KEY (`Subject_ID`)
    REFERENCES `student_grade_management`.`university_subject` (`ID`)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
  CONSTRAINT `student_group_ibfk_3`
    FOREIGN KEY (`Faculty_ID`)
    REFERENCES `student_grade_management`.`faculty` (`ID`)
		ON DELETE CASCADE
		ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

-- -----------------------------------------------------
-- Table `student_grade_management`.`all_groups`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `student_grade_management`.`all_groups` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Student_ID` INT(11) NOT NULL,
  `Student_group_ID` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_all_groups_1_idx` (`Student_ID` ASC),
  INDEX `fk_all_groups_2_idx` (`Student_group_ID` ASC),
  CONSTRAINT `fk_all_groups_1`
    FOREIGN KEY (`Student_ID`)
    REFERENCES `student_grade_management`.`user` (`ID`)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
  CONSTRAINT `fk_all_groups_2`
    FOREIGN KEY (`Student_group_ID`)
    REFERENCES `student_grade_management`.`student_group` (`ID`)
		ON DELETE CASCADE
		ON UPDATE CASCADE)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `student_grade_management`.`grade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `student_grade_management`.`grade` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Title` VARCHAR(255) NOT NULL,
  `Grade` INT(11) NOT NULL,
  `Description` VARCHAR(255) NOT NULL,
  `Date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `Student_ID` INT(11) NOT NULL,
  `Task_ID` INT(11) NOT NULL,
  `Group_ID` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `Task_ID` (`Task_ID` ASC),
  INDEX `Group_ID` (`Group_ID` ASC),
  INDEX `grade_ibfk_1_idx` (`Student_ID` ASC),
  CONSTRAINT `grade_ibfk_1`
    FOREIGN KEY (`Student_ID`)
    REFERENCES `student_grade_management`.`user` (`ID`)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
  CONSTRAINT `grade_ibfk_2`
    FOREIGN KEY (`Task_ID`)
    REFERENCES `student_grade_management`.`task` (`ID`)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
  CONSTRAINT `grade_ibfk_3`
    FOREIGN KEY (`Group_ID`)
    REFERENCES `student_grade_management`.`student_group` (`ID`)
		ON DELETE CASCADE
		ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
