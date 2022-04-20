package hospital.domain;

/**
 * User object
 * 
 * @author Amulya
 * 
 */
public class Hospital {
	
	
	private Integer hospital_id;
	private String name;
	private String address;
	private String contact_no;
	private String email;
	private Integer employee_count;
	
	public Integer getHospital_id() {
		return hospital_id;
	}
	public void setHospital_id(Integer hospital_id) {
		this.hospital_id = hospital_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public Integer getEmployee_count() {
		return employee_count;
	}
	public void setEmployee_count(Integer employee_count) {
		this.employee_count = employee_count;
	}
	
	@Override
	public String toString() {
		return "Hospital [hospital_id=" + hospital_id + ", name=" + name + ", address=" + address + ", contact_no="
				+ contact_no + ", email=" + email + ", employee_count=" + employee_count + "]";
	}
	/*
	 * Correspond to the user table
	 */
	
	
}