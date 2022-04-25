package patient_doctor.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




//import java.util.ArrayList;
//import java.util.List;

import patient_doctor.domain.PatientDoctor;

/**
 * DDL functions performed in database
 */
public class PatientDoctorDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "healthcaresystem"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "health"; //TODO change password

	public PatientDoctor findByMID(Integer ps_id, Integer s_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		PatientDoctor patient_doctor= new PatientDoctor();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital_database", MySQL_user, MySQL_password);
		    String sql = "select * from patient_doctor where patient_id=? and doctor_id = ? ";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,ps_id);
		    preparestatement.setInt(2,s_id);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer patient_id = Integer.parseInt(resultSet.getString("patient_id"));
		    	Integer doctor_id = Integer.parseInt(resultSet.getString("doctor_id"));
		    	System.out.print(patient_id);
		    	System.out.print(ps_id);
		    	if((patient_id.equals(ps_id))  && (doctor_id.equals(s_id)) ){
		    		System.out.print("hiiiiiiiii");
		    		patient_doctor.setPatient_id(patient_id);
		    		patient_doctor.setDoctor_id(doctor_id);
		    		
		    	
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return patient_doctor;
	}	
	
	/**
	 * insert Doctor
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(PatientDoctor form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital_database", MySQL_user, MySQL_password);
			
			String sql = "insert into patient_doctor (patient_id,doctor_id) values(?,?)";
			//System.out.println(sql);
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getPatient_id());
		    preparestatement.setInt(2,form.getDoctor_id());
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
	public void update(PatientDoctor form, PatientDoctor patient_doctor) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital_database", MySQL_user, MySQL_password);
			
			String sql = "UPDATE patient_doctor SET patient_id=?, doctor_id=? where patient_id = ? and doctor_id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			
		   
		    
		    preparestatement.setInt(1,form.getPatient_id());
		    preparestatement.setInt(2,form.getDoctor_id());
		    
		    preparestatement.setFloat(3,patient_doctor.getPatient_id());
		    preparestatement.setFloat(4,patient_doctor.getDoctor_id());
		    
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
			
			String sql = "delete from patient_doctor where patient_id = ? and doctor_id = ? ";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,ps_id);
		    preparestatement.setInt(2,s_id);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
