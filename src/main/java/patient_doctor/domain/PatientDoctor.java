package patient_doctor.domain;

import java.sql.Date;

/**
 * User object
 * 
 * @author AB
 * 
 */
public class PatientDoctor {
	/*
	 * Correspond to the user table
	 */
	private Integer patient_id;
	private Integer doctor_id;
	public Integer getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(Integer patient_id) {
		this.patient_id = patient_id;
	}
	public Integer getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(Integer doctor_id) {
		this.doctor_id = doctor_id;
	}
	@Override
	public String toString() {
		return "PatientDoctor [patient_id=" + patient_id + ", doctor_id=" + doctor_id + "]";
	}
	
	
	
	
	
	
	
		
	
	
	

	
}
