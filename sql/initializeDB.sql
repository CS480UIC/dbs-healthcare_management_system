
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';


CREATE SCHEMA IF NOT EXISTS `hospital_database` DEFAULT CHARACTER SET utf8 ;
USE `hospital_database` ;

-- -----------------------------------------------------
-- Table `hospital_database`.`hospital`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hospital_database`.`hospital` ;

CREATE TABLE IF NOT EXISTS `hospital_database`.`hospital` (
  `hospital_id` INT NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  `address` VARCHAR(100) NOT NULL,
  `contact_no` CHAR(10) NOT NULL,
  `email` VARCHAR(40) NOT NULL,
  `employee_count` INT NOT NULL,
  PRIMARY KEY (`hospital_id`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `hospital_id_UNIQUE` ON `hospital_database`.`hospital` (`hospital_id` ASC) VISIBLE;

CREATE UNIQUE INDEX `contact_no_UNIQUE` ON `hospital_database`.`hospital` (`contact_no` ASC) VISIBLE;

CREATE UNIQUE INDEX `email_UNIQUE` ON `hospital_database`.`hospital` (`email` ASC) VISIBLE;

LOCK TABLES `hospital` WRITE;
/*!40000 ALTER TABLE `hospital` DISABLE KEYS */;
INSERT INTO `hospital` VALUES (312,'GBR','321,Nrt','3426734524','gbr@gmai.com',45),(1027,'Ramesh hospitals','231,W Polk St','4356473452','ramesh@gmail.com',67),(4123,'apollo','Amazon forest,Africa','1234567890','balayya@lion.ap',56),(5231,'MK','234,palnadu,ap','3452453666','mk@gmail.com',98),(9023,'Rush','1439,w harrison st','6745453454','rush@gmail.com',121);
/*!40000 ALTER TABLE `hospital` ENABLE KEYS */;
UNLOCK TABLES;


-- -----------------------------------------------------
-- Table `hospital_database`.`doctor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hospital_database`.`doctor` ;

CREATE TABLE IF NOT EXISTS `hospital_database`.`doctor` (
  `doctor_id` INT NOT NULL,
  `first_name` VARCHAR(20) NOT NULL,
  `last_name` VARCHAR(20) NOT NULL,
  `email` VARCHAR(40) NOT NULL,
  `contact_no` CHAR(10) NOT NULL,
  `department` VARCHAR(20) NOT NULL,
  `experience` INT NOT NULL,
  `address` VARCHAR(100) NOT NULL,
  `hospital_id` INT NOT NULL,
  PRIMARY KEY (`doctor_id`),
  CONSTRAINT `hospital_id`
    FOREIGN KEY (`hospital_id`)
    REFERENCES `hospital_database`.`hospital` (`hospital_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `doctor_id_UNIQUE` ON `hospital_database`.`doctor` (`doctor_id` ASC) VISIBLE;

CREATE UNIQUE INDEX `contact_no_UNIQUE` ON `hospital_database`.`doctor` (`contact_no` ASC) VISIBLE;

CREATE UNIQUE INDEX `email_UNIQUE` ON `hospital_database`.`doctor` (`email` ASC) VISIBLE;

CREATE INDEX `hospital_id_idx` ON `hospital_database`.`doctor` (`hospital_id` ASC) VISIBLE;

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` VALUES (102,'Manoj Kumar','Alluri','mallur3@uic.edu','3129006364','neuroscience',4,'1429 w Lexington St ',1027),(123,'Sumanth ','Donepudi','alluri.manog9@gmail.com','3124567891','General',5,'1430 W Taylor St',9023),(324,'Anish','Puli','anish2@uic.edu','3452134212','Cardiologist',7,'1324 W Morgan St',5231),(453,'Shiva ','Donga','sdonep2@uic.edu','4356748121','dental',3,'1234 W Harrison St',312),(543,'Teddy','Buddy','teddy3@uic.edu','3162784563','childcare',2,'907, W Edoka st',4123);
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
UNLOCK TABLES;

-- -----------------------------------------------------
-- Table `hospital_database`.`patient`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hospital_database`.`patient` ;

CREATE TABLE IF NOT EXISTS `hospital_database`.`patient` (
  `patient_id` INT NOT NULL,
  `first_name` VARCHAR(20) NOT NULL,
  `last_name` VARCHAR(20) NOT NULL,
  `contact_no` CHAR(10) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `gender` VARCHAR(10) NOT NULL,
  `age` INT NOT NULL,
  `user_name` VARCHAR(20) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  `hospital_id` INT NULL,
  `doctor_id` INT NULL,
  PRIMARY KEY (`patient_id`),
  CONSTRAINT `hospital_patient_id`
    FOREIGN KEY (`hospital_id`)
    REFERENCES `hospital_database`.`hospital` (`hospital_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `doctor_id`
    FOREIGN KEY (`doctor_id`)
    REFERENCES `hospital_database`.`doctor` (`doctor_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `patient_id_UNIQUE` ON `hospital_database`.`patient` (`patient_id` ASC) VISIBLE;

CREATE UNIQUE INDEX `contact_no_UNIQUE` ON `hospital_database`.`patient` (`contact_no` ASC) VISIBLE;

CREATE UNIQUE INDEX `email_UNIQUE` ON `hospital_database`.`patient` (`email` ASC) VISIBLE;

CREATE INDEX `hospital_id_idx` ON `hospital_database`.`patient` (`hospital_id` ASC) VISIBLE;

CREATE INDEX `doctor_id_idx` ON `hospital_database`.`patient` (`doctor_id` ASC) VISIBLE;

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (1212,'nirmal','Alluri','4563745671','nirmal@uic.edu','MALE',34,'n3421','1.23E+06',9023,123,'1429 W Lexignton st'),(3434,'Adeem','shaik','3242424656','adeem@gmai.com','Male',25,'ade345','Adeem2k16',1027,102,'1429 W Lexignton st'),(3435,'kavya','cher','2134312351','kl234@gmnail.com','Female',22,'k342','k4de3',312,453,'1429 W Lexignton st'),(6766,'Surya','vineeth','8185056522','hjuh@uic.edu','Male',32,'vg809','ftg2683',4123,543,'1429 W Lexignton st'),(56464,'Pranavi','Alle','6543453434','prav@uic.edu','Female',43,'n564','hi594',5231,324,'1429 W Lexignton st');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

-- -----------------------------------------------------
-- Table `hospital_database`.`insurance`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hospital_database`.`insurance` ;

CREATE TABLE IF NOT EXISTS `hospital_database`.`insurance` (
  `insurance_id` INT NOT NULL,
  `insurance_company` VARCHAR(20) NOT NULL,
  `start_date` DATE NOT NULL,
  `end_date` DATE NOT NULL,
  `insurance_plan` VARCHAR(20) NOT NULL,
  `patient_id` INT NOT NULL,
  PRIMARY KEY (`insurance_id`),
  CONSTRAINT `patient_id`
    FOREIGN KEY (`patient_id`)
    REFERENCES `hospital_database`.`patient` (`patient_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `insurance_id_UNIQUE` ON `hospital_database`.`insurance` (`insurance_id` ASC) VISIBLE;

CREATE INDEX `patient_id_idx` ON `hospital_database`.`insurance` (`patient_id` ASC) VISIBLE;

LOCK TABLES `insurance` WRITE;
/*!40000 ALTER TABLE `insurance` DISABLE KEYS */;
INSERT INTO `insurance` VALUES (1001,'AFG Insurance','2021-01-05','2022-10-05','yearly plan',3434),(2002,'QWE insurance','2021-05-02','2022-08-05','6 month plan',1212),(3003,'DFG insurance','2021-02-03','2022-04-01','quarterly plan',3435),(4004,'HP insurance','2021-03-02','2022-03-02','yearly plan',56464),(5005,'LOP Insurace','2021-03-05','2022-05-09','yearly plan',6766);
/*!40000 ALTER TABLE `insurance` ENABLE KEYS */;
UNLOCK TABLES;

-- -----------------------------------------------------
-- Table `hospital_database`.`patient_doctor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hospital_database`.`patient_doctor` ;

CREATE TABLE IF NOT EXISTS `hospital_database`.`patient_doctor` (
  `patient_id` INT NOT NULL,
  `doctor_id` INT NOT NULL,
  PRIMARY KEY (`patient_id`, `doctor_id`),
  CONSTRAINT `patient_patient_doctor_id`
    FOREIGN KEY (`patient_id`)
    REFERENCES `hospital_database`.`patient` (`patient_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `doctor_patient_doctor_id`
    FOREIGN KEY (`doctor_id`)
    REFERENCES `hospital_database`.`doctor` (`doctor_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `doctor_id_idx` ON `hospital_database`.`patient_doctor` (`doctor_id` ASC) VISIBLE;

LOCK TABLES `patient_doctor` WRITE;
/*!40000 ALTER TABLE `patient_doctor` DISABLE KEYS */;
INSERT INTO `patient_doctor` VALUES (3434,102),(1212,123),(56464,324),(3435,453),(6766,543);
/*!40000 ALTER TABLE `patient_doctor` ENABLE KEYS */;
UNLOCK TABLES;

-- -----------------------------------------------------
-- Table `hospital_database`.`medication`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hospital_database`.`medication` ;

CREATE TABLE IF NOT EXISTS `hospital_database`.`medication` (
  `medicine_id` INT NOT NULL,
  `medicine_name` VARCHAR(45) NOT NULL,
  `price` INT NOT NULL,
  `mfg_date` DATE NOT NULL,
  `exp_date` DATE NOT NULL,
  `mfg_company` VARCHAR(45) NOT NULL,
  `doctor_id` INT NULL,
  `patient_id` INT NULL,
  PRIMARY KEY (`medicine_id`),
  CONSTRAINT `doctor_medication_id`
    FOREIGN KEY (`doctor_id`)
    REFERENCES `hospital_database`.`doctor` (`doctor_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `patient_medication_id`
    FOREIGN KEY (`patient_id`)
    REFERENCES `hospital_database`.`patient` (`patient_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `medicine_id_UNIQUE` ON `hospital_database`.`medication` (`medicine_id` ASC) VISIBLE;

CREATE INDEX `doctor_id_idx` ON `hospital_database`.`medication` (`doctor_id` ASC) VISIBLE;

CREATE INDEX `patient_id_idx` ON `hospital_database`.`medication` (`patient_id` ASC) VISIBLE;

LOCK TABLES `medication` WRITE;
/*!40000 ALTER TABLE `medication` DISABLE KEYS */;
INSERT INTO `medication` VALUES (213,'citrizen',6,'2022-12-01','2023-12-01','tcs',324,56464),(345,'dolo',3,'2022-11-11','2023-11-11','zentek',102,3434),(567,'cetmal',5,'2022-12-01','2023-12-01','gbr',123,1212),(678,'coldact',2,'2022-09-12','2023-09-12','ncr',453,3435),(989,'gob',8,'2021-12-12','2022-12-12','wipro',543,6766);
/*!40000 ALTER TABLE `medication` ENABLE KEYS */;
UNLOCK TABLES;

-- -----------------------------------------------------
-- Table `hospital_database`.`payment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hospital_database`.`payment` ;

CREATE TABLE IF NOT EXISTS `hospital_database`.`payment` (
  `payment_id` INT NOT NULL,
  `first_name` VARCHAR(20) NOT NULL,
  `last_name` VARCHAR(20) NOT NULL,
  `type_of_payment` VARCHAR(20) NOT NULL,
  `treatment` VARCHAR(20) NOT NULL,
  `doc_referred` VARCHAR(20) NOT NULL,
  `date` DATE NOT NULL,
  `patient_id` INT NOT NULL,
  PRIMARY KEY (`payment_id`),
  CONSTRAINT `patient_payment_id`
    FOREIGN KEY (`patient_id`)
    REFERENCES `hospital_database`.`patient` (`patient_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `payment_id_UNIQUE` ON `hospital_database`.`payment` (`payment_id` ASC) VISIBLE;

CREATE INDEX `patient_id_idx` ON `hospital_database`.`payment` (`patient_id` ASC) VISIBLE;

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (100001,'Adeem','shaik','credit card','Fever','Manoj Kumar','2022-01-12',3434),(100002,'nirmal','Alluri','echeck','Cough','Sumanth','2022-02-03',1212),(100003,'kavya','cher','echeck','thumb fracture','Shiva','2022-03-06',3435),(100004,'Pranavi','Alle','cash','headache','Anish','2022-04-09',56464),(100005,'Surya','vineeth','cash','hair loss','Teddy','2022-08-09',6766);
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

-- -----------------------------------------------------
-- Table `hospital_database`.`patient_medical_history`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hospital_database`.`patient_medical_history` ;

CREATE TABLE IF NOT EXISTS `hospital_database`.`patient_medical_history` (
  `history_id` INT NOT NULL,
  `conditions` VARCHAR(45) NULL,
  `last_visit` DATE NULL,
  `patient_id` INT NULL,
  PRIMARY KEY (`history_id`),
  CONSTRAINT `patient_medical_history_id`
    FOREIGN KEY (`patient_id`)
    REFERENCES `hospital_database`.`patient` (`patient_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `history_id_UNIQUE` ON `hospital_database`.`patient_medical_history` (`history_id` ASC) VISIBLE;

CREATE INDEX `patient_id_idx` ON `hospital_database`.`patient_medical_history` (`patient_id` ASC) VISIBLE;

LOCK TABLES `patient_medical_history` WRITE;
/*!40000 ALTER TABLE `patient_medical_history` DISABLE KEYS */;
INSERT INTO `patient_medical_history` VALUES (101,'fever','2022-01-04',3434),(104,'cold','2022-09-02',1212),(106,'covid','2022-01-03',3435),(110,'cancer','2022-11-02',56464),(121,'injury leg','2022-01-03',6766);
/*!40000 ALTER TABLE `patient_medical_history` ENABLE KEYS */;
UNLOCK TABLES;

-- -----------------------------------------------------
-- Table `hospital_database`.`patient_medical_history_medication`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hospital_database`.`patient_medical_history_medication` ;

CREATE TABLE IF NOT EXISTS `hospital_database`.`patient_medical_history_medication` (
  `history_id` INT NOT NULL,
  `medication` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`history_id`, `medication`),
  CONSTRAINT `hiatory_id`
    FOREIGN KEY (`history_id`)
    REFERENCES `hospital_database`.`patient_medical_history` (`history_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

LOCK TABLES `patient_medical_history_medication` WRITE;
/*!40000 ALTER TABLE `patient_medical_history_medication` DISABLE KEYS */;
INSERT INTO `patient_medical_history_medication` VALUES (101,'leg injury'),(104,'cancer'),(106,'fever'),(110,'covid'),(121,'cold');
/*!40000 ALTER TABLE `patient_medical_history_medication` ENABLE KEYS */;
UNLOCK TABLES;

-- -----------------------------------------------------
-- Table `hospital_database`.`patient_medical_history_surgeries`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hospital_database`.`patient_medical_history_surgeries` ;

CREATE TABLE IF NOT EXISTS `hospital_database`.`patient_medical_history_surgeries` (
  `history_id` INT NOT NULL,
  `surgeries` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`history_id`, `surgeries`),
  CONSTRAINT `history_surgeries_id`
    FOREIGN KEY (`history_id`)
    REFERENCES `hospital_database`.`patient_medical_history` (`history_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


LOCK TABLES `patient_medical_history_surgeries` WRITE;
/*!40000 ALTER TABLE `patient_medical_history_surgeries` DISABLE KEYS */;
INSERT INTO `patient_medical_history_surgeries` VALUES (101,'brain'),(104,'liver'),(106,'hand'),(110,'heart'),(121,'leg');
/*!40000 ALTER TABLE `patient_medical_history_surgeries` ENABLE KEYS */;
UNLOCK TABLES;


-- -----------------------------------------------------
-- Table `hospital_database`.`admin`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hospital_database`.`admin` ;

CREATE TABLE IF NOT EXISTS `hospital_database`.`admin` (
  `user_name` VARCHAR(20) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`user_name`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `user_name_UNIQUE` ON `hospital_database`.`admin` (`user_name` ASC) VISIBLE;

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('User1','Password1'),('User2','Password2'),('User3','Password3'),('User4','Password4'),('User5','Password5');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `entity1`
--

DROP TABLE IF EXISTS `entity1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entity1` (
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;


LOCK TABLES `entity1` WRITE;
/*!40000 ALTER TABLE `entity1` DISABLE KEYS */;
INSERT INTO `entity1` VALUES ('User1','Password1','email1@gmail.com'),('User2','Password2','email2@gmail.com'),('User3','Password3','email3@gmail.com'),('User4','Password4','email4@gmail.com'),('User5','Password5','email5@gmail.com');
/*!40000 ALTER TABLE `entity1` ENABLE KEYS */;
UNLOCK TABLES;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
