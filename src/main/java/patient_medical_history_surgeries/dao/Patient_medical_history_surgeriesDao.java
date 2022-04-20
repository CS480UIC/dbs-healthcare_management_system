package patient_medical_history_surgeries.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




//import java.util.ArrayList;
//import java.util.List;

import patient_medical_history_surgeries.domain.Patient_medical_history_surgeries;

/**
 * DDL functions performed in database
 */
public class Patient_medical_history_surgeriesDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "healthcaresystem"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "health"; //TODO change password

	public Patient_medical_history_surgeries findByMID(Integer ps_id, Integer s_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Patient_medical_history_surgeries patient_medical_history_surgeries= new Patient_medical_history_surgeries();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital_database", MySQL_user, MySQL_password);
		    String sql = "select * from patient_medical_history_surgeries where history_id=? and surgeries = ? ";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,ps_id);
		    preparestatement.setInt(2,s_id);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer history_id = Integer.parseInt(resultSet.getString("history_id"));
		    	Integer surgeries=Integer.parseInt(resultSet.getString("surgeries"));
		    	System.out.print(history_id);
		    	System.out.print(ps_id);
		    	if((history_id.equals(ps_id))  && (surgeries.equals(s_id)) ){
		    		System.out.print("hiiiiiiiii");
		    		patient_medical_history_surgeries.setHistory_id(history_id);
		    		patient_medical_history_surgeries.setSurgeries(surgeries);
		    		
		    	
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return patient_medical_history_surgeries;
	}	
	
	/**
	 * insert Doctor
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Patient_medical_history_surgeries form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital_database", MySQL_user, MySQL_password);
			
			String sql = "insert into patient_medical_history_surgeries (history_id,conditions,surgeries) values(?,?)";
			//System.out.println(sql);
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getHistory_id());
		    preparestatement.setInt(2,form.getSurgeries());
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
	public void update(Patient_medical_history_surgeries form, Patient_medical_history_surgeries patient_medical_history_surgeries) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital_database", MySQL_user, MySQL_password);
			
			String sql = "UPDATE patient_medical_history_surgeries SET surgeries=?, history_id=? where history_id = ? and surgeries = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			
		   
		    
		    preparestatement.setInt(1,form.getHistory_id());
		    preparestatement.setInt(2,form.getSurgeries());
		    
		    preparestatement.setFloat(3,patient_medical_history_surgeries.getHistory_id());
		    preparestatement.setInt(4,patient_medical_history_surgeries.getSurgeries());
		    
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
	public void delete(Integer ps_id, Integer s_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital_database", MySQL_user, MySQL_password);
			
			String sql = "delete from patient_medical_history_surgeries where history_id = ? and surgeries = ? ";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,ps_id);
		    preparestatement.setInt(1,s_id);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
