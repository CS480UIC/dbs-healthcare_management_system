package doctor.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class Doctor {
	/*
	 * Correspond to the user table
	 */
	
	private String first_name;
	private String last_name; 
	private String email;
	private String contact_no;
	private Integer doctor_id;
	private String department;
	private Integer experience;
	private String address;
	private Integer hospital_id;
	
	@Override
	public String toString() {
		return "Doctor [first_name=" + first_name + ", last_name=" + last_name + ", email=" + email + ", contact_no="
				+ contact_no + ", doctor_id=" + doctor_id + ", department=" + department + ", experience=" + experience
				+ ", address=" + address + ", hospital_id=" + hospital_id + "]";
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact_no() {
		return contact_no;
	}
	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	public Integer getDoctor_id() {
		//System.out.print(doctor_id);
		return doctor_id;
	}
	public void setDoctor_id(Integer doctor_id) {
		//System.out.print(doctor_id);
		this.doctor_id = doctor_id;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Integer getExperience() {
		return experience;
	}
	public void setExperience(Integer experience) {
		this.experience = experience;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getHospital_id() {
		return hospital_id;
	}
	public void setHospital_id(Integer hospital_id) {
		this.hospital_id = hospital_id;
	}
	
	
	

	
}
