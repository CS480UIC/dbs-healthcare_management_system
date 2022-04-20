package patient.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import doctor.domain.Doctor;
import patient.domain.Patient;


//import java.util.ArrayList;
//import java.util.List;


/**
 * DDL functions performed in database
 */
public class PatientDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "healthcaresystem"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "health"; //TODO change password

	public Patient findByDID(Integer d_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Patient patient = new Patient();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital_database", MySQL_user, MySQL_password);
		    String sql = "select * from patient where patient_id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,d_id);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer patient_id = Integer.parseInt(resultSet.getString("patient_id"));
		    	System.out.print(patient_id);
		    	System.out.print(d_id);
		    	if(patient_id.equals(d_id)){
		    		System.out.print("hiiiiiiiii");
		    		patient.setPatient_id(Integer.parseInt(resultSet.getString("patient_id")));
		    		patient.setFirst_name(resultSet.getString("first_name"));
		    		patient.setLast_name(resultSet.getString("last_name"));
		    		patient.setContact_no(resultSet.getString("contact_no"));
		    		patient.setEmail(resultSet.getString("email"));
		    		patient.setGender(resultSet.getString("gender"));
		    		patient.setAge(Integer.parseInt(resultSet.getString("age")));
		    		patient.setUser_name(resultSet.getString("user_name"));
		    		patient.setPassword(resultSet.getString("password"));
		    		patient.setHospital_id(Integer.parseInt(resultSet.getString("hospital_id")));
		    		patient.setDoctor_id(Integer.parseInt(resultSet.getString("doctor_id")));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return patient;
	}	
	
	/**
	 * insert Doctor
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Patient form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital_database", MySQL_user, MySQL_password);
			
			String sql = "insert into patient (patient_id,first_name,last_name,contact_no,email,gender,age,user_name,password,hospital_id,doctor_id) values(?,?,?,?,?,?,?,?,?,?,?)";
			//System.out.println(sql);
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getPatient_id());
		    preparestatement.setString(2,form.getFirst_name());
		    preparestatement.setString(3,form.getLast_name());
		    preparestatement.setString(4,form.getContact_no());
		    preparestatement.setString(5,form.getEmail());
		    preparestatement.setString(6,form.getGender());
		    preparestatement.setInt(7,form.getAge());
		    preparestatement.setString(8,form.getUser_name());
		    preparestatement.setString(9,form.getPassword());
		    preparestatement.setInt(10,form.getHospital_id());
		    preparestatement.setInt(11,form.getDoctor_id());
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
	public void update(Patient form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital_database", MySQL_user, MySQL_password);
			
			String sql = "UPDATE patient SET first_name = ?, last_name = ?,contact_no=?,email=?,gender=?,age=?,user_name=?,password=?,hospital_id=?,doctor_id=? where patient_id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getPatient_id());
		    preparestatement.setString(2,form.getFirst_name());
		    preparestatement.setString(3,form.getLast_name());
		    preparestatement.setString(4,form.getContact_no());
		    preparestatement.setString(5,form.getEmail());
		    preparestatement.setString(6,form.getGender());
		    preparestatement.setInt(7,form.getAge());
		    preparestatement.setString(8,form.getUser_name());
		    preparestatement.setString(9,form.getPassword());
		    preparestatement.setInt(10,form.getHospital_id());
		    preparestatement.setInt(11,form.getDoctor_id());
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
	public void delete(Integer d_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital_database", MySQL_user, MySQL_password);
			
			String sql = "delete from patient where patient_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,d_id);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital_database", MySQL_user, MySQL_password);
			String sql = "select * from patient";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Patient patient = new Patient();
				patient.setFirst_name(resultSet.getString("first_name"));
	    		patient.setEmail(resultSet.getString("email"));
	    		patient.setContact_no(resultSet.getString("contact_no"));
	    		list.add(patient);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
}
