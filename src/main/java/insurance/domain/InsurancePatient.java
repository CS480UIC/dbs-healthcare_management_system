package insurance.domain;

import java.sql.Date;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class InsurancePatient {
	/*
	 * Correspond to the user table
	 */
	private String first_name;
	private String last_name;
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
	@Override
	public String toString() {
		return "InsurancePatient [first_name=" + first_name + ", last_name=" + last_name + "]";
	}
	
	
}
