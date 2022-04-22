package patient_medical_history_medication.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




//import java.util.ArrayList;
//import java.util.List;

import patient_medical_history_medication.domain.PatientMedicalHistoryMedication;

/**
 * DDL functions performed in database
 */
public class PatientMedicalHistoryMedicationDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "healthcaresystem"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "health"; //TODO change password

	public PatientMedicalHistoryMedication findByMID(Integer ps_id, String s_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		PatientMedicalHistoryMedication patient_medical_history_medication= new PatientMedicalHistoryMedication();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital_database", MySQL_user, MySQL_password);
		    String sql = "select * from patient_medical_history_medication where history_id=? and medication = ? ";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,ps_id);
		    preparestatement.setString(2,s_id);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer history_id = Integer.parseInt(resultSet.getString("history_id"));
		    	String medication=(resultSet.getString("medication"));
		    	System.out.print(history_id);
		    	System.out.print(ps_id);
		    	if((history_id.equals(ps_id))  && (medication.equals(s_id)) ){
		    		patient_medical_history_medication.setHistory_id(history_id);
		    		patient_medical_history_medication.setMedication(medication);
		    		
		    	
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return patient_medical_history_medication;
	}	
	
	/**
	 * insert Doctor
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(PatientMedicalHistoryMedication form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital_database", MySQL_user, MySQL_password);
			
			String sql = "insert into patient_medical_history_medication (history_id,medication) values(?,?)";
			//System.out.println(sql);
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getHistory_id());
		    preparestatement.setString(2,form.getMedication());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @param form
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void update(PatientMedicalHistoryMedication form, PatientMedicalHistoryMedication patient_medical_history_medication) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital_database", MySQL_user, MySQL_password);
			
			String sql = "UPDATE patient_medical_history_medication SET medication=?, history_id=? where history_id = ? and medication = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			
		   
		    
		    preparestatement.setInt(1,form.getHistory_id());
		    preparestatement.setString(2,form.getMedication());
		    
		    preparestatement.setFloat(3,patient_medical_history_medication.getHistory_id());
		    preparestatement.setString(4,patient_medical_history_medication.getMedication());
		    
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @param d_id
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void delete(Integer ps_id, String s_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital_database", MySQL_user, MySQL_password);
			
			String sql = "delete from patient_medical_history_medication where history_id = ? and medication = ? ";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,ps_id);
		    preparestatement.setString(2,s_id);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
