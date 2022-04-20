package patient_medical_history.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




//import java.util.ArrayList;
//import java.util.List;

import patient_medical_history.domain.Patient_medical_history;

/**
 * DDL functions performed in database
 */
public class Patient_medical_historyDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "healthcaresystem"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "health"; //TODO change password

	public Patient_medical_history findByMID(Integer pm_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Patient_medical_history patient_medical_history= new Patient_medical_history();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital_database", MySQL_user, MySQL_password);
		    String sql = "select * from patient_medical_history where medicine_id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,pm_id);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer history_id = Integer.parseInt(resultSet.getString("history_id"));
		    	System.out.print(history_id);
		    	System.out.print(pm_id);
		    	if(history_id.equals(pm_id)){
		    		System.out.print("hiiiiiiiii");
		    		patient_medical_history.setHistory_id(history_id);
		    		patient_medical_history.setConditions(resultSet.getString("conditions"));
		    		patient_medical_history.setLast_visit(java.sql.Date.valueOf(resultSet.getString("last_visit")));
		    		patient_medical_history.setPatient_id(Integer.parseInt(resultSet.getString("patient_id")));
		    		
		    	
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return patient_medical_history;
	}	
	
	/**
	 * insert Doctor
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Patient_medical_history form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital_database", MySQL_user, MySQL_password);
			
			String sql = "insert into patient_medical_history (history_id,conditions,last_visit,patient_id) values(?,?,?,?)";
			//System.out.println(sql);
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getHistory_id());
		    preparestatement.setString(2,form.getConditions());
		    preparestatement.setDate(3,form.getLast_visit());
		    preparestatement.setInt(4,form.getPatient_id());
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
	public void update(Patient_medical_history form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital_database", MySQL_user, MySQL_password);
			
			String sql = "UPDATE patient_medical_history SET conditions = ?, last_visit=?,patient_id=? where history_id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			
		    preparestatement.setString(1,form.getConditions());
		    preparestatement.setDate(2,form.getLast_visit());
		    preparestatement.setInt(3,form.getPatient_id());
		    preparestatement.setInt(4,form.getHistory_id());
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
	public void delete(Integer pm_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital_database", MySQL_user, MySQL_password);
			
			String sql = "delete from patient_medical_history where history_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,pm_id);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
