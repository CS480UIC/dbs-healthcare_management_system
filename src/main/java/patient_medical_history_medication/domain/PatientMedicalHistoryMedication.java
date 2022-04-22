package patient_medical_history_medication.domain;

import java.sql.Date;

/**
 * User object
 * 
 * @author AB
 * 
 */
public class PatientMedicalHistoryMedication {
	/*
	 * Correspond to the user table
	 */
	private Integer history_id;
	private String medication;
	public Integer getHistory_id() {
		return history_id;
	}
	public void setHistory_id(Integer history_id) {
		this.history_id = history_id;
	}
	public String getMedication() {
		return medication;
	}
	public void setMedication(String medication) {
		this.medication = medication;
	}
	@Override
	public String toString() {
		return "PatientMedicalHistoryMedication [history_id=" + history_id + ", medication=" + medication + "]";
	}
	
	
	
	
	
	
	
	
	
		
	
	
	

	
}
