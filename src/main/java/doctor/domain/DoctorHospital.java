package doctor.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class DoctorHospital {
	/*
	 * Correspond to the user table
	 */
	
	private Integer doctor_id;
	private String hospital_name;
	public Integer getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(Integer doctor_id) {
		this.doctor_id = doctor_id;
	}
	public String getHospital_name() {
		return hospital_name;
	}
	public void setHospital_name(String hospital_name) {
		this.hospital_name = hospital_name;
	}
	@Override
	public String toString() {
		return "DoctorHospital [doctor_id=" + doctor_id + ", hospital_name=" + hospital_name + "]";
	} 
	
	
	
	

	
}
