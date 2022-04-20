package patient_medical_history_surgeries.domain;

import java.sql.Date;

/**
 * User object
 * 
 * @author AB
 * 
 */
public class PatientMedicalHistorySurgeries {
	/*
	 * Correspond to the user table
	 */
	private Integer history_id;
	private Integer surgeries;
	
	public Integer getHistory_id() {
		return history_id;
	}
	public void setHistory_id(Integer history_id) {
		this.history_id = history_id;
	}
	public Integer getSurgeries() {
		return surgeries;
	}
	public void setSurgeries(Integer surgeries) {
		this.surgeries = surgeries;
	}
	@Override
	public String toString() {
		return "PatientMedicalHistorySurgeries [history_id=" + history_id + ", surgeries=" + surgeries + "]";
	}
	
	
	
	
	
	
	
		
	
	
	

	
}
