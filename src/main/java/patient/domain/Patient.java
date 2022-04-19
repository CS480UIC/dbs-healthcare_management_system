package patient.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class Patient {
	/*
	 * Correspond to the user table
	 */
	private Integer patient_id;
	private String first_name;
	private String last_name; 
	private String contact_no;
	private String email;
	private String gender;
	private Integer age;
	private String user_name;
	private String password;
	private Integer hospital_id;
	private Integer doctor_id;
	
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
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getContact_no() {
		return contact_no;
	}
	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getHospital_id() {
		return hospital_id;
	}
	public void setHospital_id(Integer hospital_id) {
		this.hospital_id = hospital_id;
	}
	public Integer getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(Integer doctor_id) {
		this.doctor_id = doctor_id;
	}
	@Override
	public String toString() {
		return "Patient [patient_id=" + patient_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", contact_no=" + contact_no + ", email=" + email + ", gender=" + gender + ", age=" + age
				+ ", user_name=" + user_name + ", password=" + password + ", hospital_id=" + hospital_id
				+ ", doctor_id=" + doctor_id + "]";
	}

	
}