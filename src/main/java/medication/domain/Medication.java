package medication.domain;

import java.sql.Date;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class Medication {
	/*
	 * Correspond to the user table
	 */
	private Integer medicine_id;
	private String medicine_name;
	private Integer price;
	private Date mfg_date;
	private Date exp_date;
	private String mfg_company;
	private Integer doctor_id;
	private Integer patient_id;
	public Integer getMedicine_id() {
		return medicine_id;
	}
	public void setMedicine_id(Integer medicine_id) {
		this.medicine_id = medicine_id;
	}
	public String getMedicine_name() {
		return medicine_name;
	}
	public void setMedicine_name(String medicine_name) {
		this.medicine_name = medicine_name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Date getMfg_date() {
		return mfg_date;
	}
	public void setMfg_date(Date mfg_date) {
		this.mfg_date = mfg_date;
	}
	public Date getExp_date() {
		return exp_date;
	}
	public void setExp_date(Date exp_date) {
		this.exp_date = exp_date;
	}
	public String getMfg_company() {
		return mfg_company;
	}
	public void setMfg_company(String mfg_company) {
		this.mfg_company = mfg_company;
	}
	public Integer getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(Integer doctor_id) {
		this.doctor_id = doctor_id;
	}
	public Integer getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(Integer patient_id) {
		this.patient_id = patient_id;
	}
	@Override
	public String toString() {
		return "Payment [medicine_id=" + medicine_id + ", medicine_name=" + medicine_name + ", price=" + price
				+ ", mfg_date=" + mfg_date + ", exp_date=" + exp_date + ", mfg_company=" + mfg_company + ", doctor_id="
				+ doctor_id + ", patient_id=" + patient_id + "]";
	}
	
	
	
		
	
	
	

	
}
