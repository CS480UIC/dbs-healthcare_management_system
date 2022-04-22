package patient.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class PatientDoctor {
	/*
	 * Correspond to the user table
	 */
	private Integer patient_id;
	private String first_name;
	private String d_first_Name;
	public Integer getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(Integer patient_id) {
		this.patient_id = patient_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getD_first_Name() {
		return d_first_Name;
	}
	public void setD_first_Name(String d_first_Name) {
		this.d_first_Name = d_first_Name;
	}
	@Override
	public String toString() {
		return "PatientDoctor [patient_id=" + patient_id + ", first_name=" + first_name + ", d_first_Name="
				+ d_first_Name + "]";
	}
	
	
	
	
}