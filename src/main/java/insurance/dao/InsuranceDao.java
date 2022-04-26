package insurance.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import insurance.domain.*;

//import java.util.ArrayList;
//import java.util.List;

import insurance.domain.Insurance;

/**
 * DDL functions performed in database
 */
public class InsuranceDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "healthcaresystem"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "health"; //TODO change password

	public Insurance findByMID(Integer m_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Insurance insurance= new Insurance();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital_database", MySQL_user, MySQL_password);
		    String sql = "select * from insurance where insurance_id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,m_id);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer insurance_id = Integer.parseInt(resultSet.getString("insurance_id"));
		    	System.out.print(insurance_id);
		    	System.out.print(m_id);
		    	if(insurance_id.equals(m_id)){
		    		insurance.setInsurance_id(insurance_id);
		    		insurance.setInsurance_company(resultSet.getString("insurance_company"));
		    		insurance.setStart_date(java.sql.Date.valueOf(resultSet.getString("start_date")));
		    		insurance.setEnd_date(java.sql.Date.valueOf(resultSet.getString("end_date")));
		    		insurance.setInsurance_plan(resultSet.getString("insurance_plan"));
		    		insurance.setPatient_id(Integer.parseInt(resultSet.getString("patient_id")));
		    		
		    	
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return insurance;
	}	
	
	/**
	 * insert Doctor
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Insurance form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital_database", MySQL_user, MySQL_password);
			
			String sql = "insert into insurance (insurance_id,insurance_company,start_date,end_date,insurance_plan,patient_id) values(?,?,?,?,?,?)";
			//System.out.println(sql);
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getInsurance_id());
		    preparestatement.setString(2,form.getInsurance_company());
		    preparestatement.setDate(3,form.getStart_date());
		    preparestatement.setDate(4,form.getEnd_date());
		    preparestatement.setString(5,form.getInsurance_plan());
		    preparestatement.setInt(6,form.getPatient_id());
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
	public void update(Insurance form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital_database", MySQL_user, MySQL_password);
			
			String sql = "UPDATE insurance SET insurance_company = ?, start_date=?,end_date=?,insurance_plan=?,patient_id=? where insurance_id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			
		    preparestatement.setString(1,form.getInsurance_company());
		    preparestatement.setDate(2,form.getStart_date());
		    preparestatement.setDate(3,form.getEnd_date());
		    preparestatement.setString(4,form.getInsurance_plan());
		    preparestatement.setInt(5,form.getPatient_id());
		    preparestatement.setInt(6,form.getInsurance_id());
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
	public void delete(Integer m_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital_database", MySQL_user, MySQL_password);
			
			String sql = "delete from insurance where insurance_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,m_id);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public List<Object> findallP() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital_database", MySQL_user, MySQL_password);
			String sql = "Create OR REPLACE view view2 as \n"
					+ "	SELECT p.first_name, p.last_name \n"
					+ "	FROM hospital_database.patient as p\n"
					+ "	WHERE EXISTS (SELECT i.patient_id\n"
					+ "	     FROM hospital_database.insurance  as i\n"
					+ "	      WHERE p.patient_id=i.patient_id\n"
					+ "	      AND start_date>=\"2021-03-01\")";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.executeUpdate();
			sql = "select * from view2";
		    preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				InsurancePatient doctor = new InsurancePatient();
				doctor.setFirst_name(resultSet.getString("first_name"));
				doctor.setLast_name(resultSet.getString("last_name"));    		
	    		list.add(doctor);
			 }
			connect.close();
		} catch(SQLException e) {

			throw new RuntimeException(e);
		}
		return list;

	}
}
