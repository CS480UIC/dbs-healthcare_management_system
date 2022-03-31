#SIMPLE
	

	

	

	SELECT hospital_id, name
	FROM hospital
	WHERE employee_count >= 50 AND employee_count <= 100;
	

	

	

	SELECT payment_id, date 
	FROM payment
	WHERE  type_of_payment="cash" ;
	

	

	

	SELECT doctor_id, first_name ,department  FROM doctor WHERE department = "dental";
	

	

	# Aggregrate
	

	SELECT SUM(price) as TOTAL_PRICE
	FROM medication
	WHERE mfg_company = 'tcs';
	

	

	

	SELECT COUNT(payment_id) as TOTAL_FUNDS_COLLECTED 
	FROM payment
	WHERE date > "2022-02-11" ;
	

	

	

	SELECT COUNT(employee_count) as count
	FROM hospital 
	GROUP BY 
    name 
	HAVING SUM(employee_count) < 25 ;
	

	

	#View
	CREATE VIEW view1 AS
	SELECT P.patient_id, P.first_name
	FROM patient P
	INNER JOIN Doctor D ON D.doctor_id = P.doctor_id
	GROUP BY P.patient_id
	ORDER BY P.first_name ASC;
	

	

	select * from view1;
	

	

	

	Create view view2 as 
	SELECT first_name, last_name 
	FROM patient as p
	WHERE EXISTS (SELECT i.patient_id
	     FROM insurance as i
	     WHERE p.patient_id=i.patient_id
	      AND start_date>"2022-01-01");
	

	

	Select * from view2;
	

	

	

	CREATE VIEW view3 AS
	select doctor_id from doctor d where  Exists 
	(select hospital_id from hospital as h
	 where h.employee_count>90);
	

	Select * from view3;