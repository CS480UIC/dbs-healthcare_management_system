package patient_medical_history.domain;

import java.sql.Date;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class PatientMedicalHistory {
	/*
	 * Correspond to the user table
	 */
	private Integer history_id;
	private String conditions;
	private Date last_visit;
	private Integer patient_id;
	
	
	
	public Integer getHistory_id() {
		return history_id;
	}
	public void setHistory_id(Integer history_id) {
		this.history_id = history_id;
	}
	public String getConditions() {
		return conditions;
	}
	public void setConditions(String conditions) {
		this.conditions = conditions;
	}
	public Date getLast_visit() {
		return last_visit;
	}
	public void setLast_visit(Date last_visit) {
		this.last_visit = last_visit;
	}
	public Integer getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(Integer patient_id) {
		this.patient_id = patient_id;
	}
	
	@Override
	public String toString() {
		return "Patient_medical_history [history_id=" + history_id + ", conditions=" + conditions + ", last_visit="
				+ last_visit + ", patient_id=" + patient_id + "]";
	}
	
	
		
	
	
	

	
}
