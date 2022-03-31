USE `hospital_database`;

DELIMITER $$
USE `hospital_database`$$
CREATE PROCEDURE `hospital` ()
BEGIN
      SELECT COUNT(*) from hospital;
END$$
DELIMITER ;

DELIMITER $$
USE `hospital_database`$$
CREATE PROCEDURE `doctor` ()
BEGIN
      SELECT COUNT(*) from doctor;
END$$
DELIMITER ;

DELIMITER $$
USE `hospital_database`$$
CREATE PROCEDURE `patient` ()
BEGIN
      SELECT COUNT(*) from patient;
END$$
DELIMITER ;


CREATE FUNCTION is_greater
(
@a AS INT 
)

RETURNS VARCHAR(5)
AS BEGIN
RETURN(
CASE
WHEN @a >18 THEN ‘ADULT’
WHEN @a <18 THEN ‘YOUNG’
END
)

DELIMITER $$
CREATE FUNCTION discount
(
price  INT 
)

RETURNS INT
DETERMINISTIC 
BEGIN
	 DECLARE disc INT;
     SET disc=disc-disc/10;
     RETURN disc;
END$$
DELIMITER ;

DELIMITER $$
CREATE FUNCTION SEARCH(id1 int)
RETURNS varchar(20)
BEGIN
     DECLARE NAME1 VARCHAR(20) default "Not Found";  
     SELECT last_name into NAME1 from patient where patient_id=id1 ;
     RETURN  NAME1;
END$$
DELIMITER ;
