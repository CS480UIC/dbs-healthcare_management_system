package payment.domain;

import java.sql.Date;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class Payment {
	/*
	 * Correspond to the user table
	 */
	private Integer payment_id;
	private String first_name;
	private String last_name;
	private String type_of_payment;
	private String treatment;
	private String doc_referred;
	private Date date;
	private Integer patient_id;
	
	public Integer getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(Integer payment_id) {
		this.payment_id = payment_id;
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
	public String getType_of_payment() {
		return type_of_payment;
	}
	public void setType_of_payment(String type_of_payment) {
		this.type_of_payment = type_of_payment;
	}
	public String getTreatment() {
		return treatment;
	}
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
	public String getDoc_referred() {
		return doc_referred;
	}
	public void setDoc_referred(String doc_referred) {
		this.doc_referred = doc_referred;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(Integer patient_id) {
		this.patient_id = patient_id;
	}
	@Override
	public String toString() {
		return "Payment [payment_id=" + payment_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", type_of_payment=" + type_of_payment + ", treatment=" + treatment + ", doc_referred=" + doc_referred
				+ ", date=" + date + ", patient_id=" + patient_id + "]";
	}
	
	
	
	
	

	
}
