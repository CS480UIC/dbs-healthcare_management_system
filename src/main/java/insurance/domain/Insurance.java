package insurance.domain;

import java.sql.Date;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class Insurance {
	/*
	 * Correspond to the user table
	 */
	private Integer insurance_id;
	private String insurance_company;
	private Date start_date;
	private Date end_date;
	private String insurance_plan;
	private Integer patient_id;
	public Integer getInsurance_id() {
		return insurance_id;
	}
	public void setInsurance_id(Integer insurance_id) {
		this.insurance_id = insurance_id;
	}
	public String getInsurance_company() {
		return insurance_company;
	}
	public void setInsurance_company(String insurance_company) {
		this.insurance_company = insurance_company;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public String getInsurance_plan() {
		return insurance_plan;
	}
	public void setInsurance_plan(String insurance_plan) {
		this.insurance_plan = insurance_plan;
	}
	public Integer getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(Integer patient_id) {
		this.patient_id = patient_id;
	}
	@Override
	public String toString() {
		return "Insurance [insurance_id=" + insurance_id + ", insurance_company=" + insurance_company + ", start_date="
				+ start_date + ", end_date=" + end_date + ", insurance_plan=" + insurance_plan + ", patient_id="
				+ patient_id + "]";
	}

	
}
