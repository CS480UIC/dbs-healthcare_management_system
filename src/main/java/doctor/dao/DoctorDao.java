package doctor.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import java.util.ArrayList;
//import java.util.List;

import doctor.domain.Doctor;
import doctor.domain.DoctorHospital;


/**
 * DDL functions performed in database
 */
public class DoctorDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "healthcaresystem"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "health"; //TODO change password

	public Doctor findByDID(Integer d_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Doctor doctor = new Doctor();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital_database", MySQL_user, MySQL_password);
		    String sql = "select * from doctor where doctor_id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,d_id);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer doctor_id = Integer.parseInt(resultSet.getString("doctor_id"));
		    	System.out.print(doctor_id);
		    	System.out.print(d_id);
		    	if(doctor_id.equals(d_id)){
		    		System.out.print("hiiiiiiiii");
		    		doctor.setDoctor_id(doctor_id);
		    		doctor.setAddress(resultSet.getString("address"));
		    		doctor.setContact_no(resultSet.getString("contact_no"));
		    		doctor.setDepartment(resultSet.getString("department"));
		    		doctor.setExperience(Integer.parseInt(resultSet.getString("experience")));
		    		doctor.setFirst_name(resultSet.getString("first_name"));
		    		doctor.setHospital_id(Integer.parseInt(resultSet.getString("hospital_id")));
		    		doctor.setLast_name(resultSet.getString("last_name"));
		    		doctor.setEmail(resultSet.getString("email"));		
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return doctor;
	}	
	
	/**
	 * insert Doctor
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Doctor form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital_database", MySQL_user, MySQL_password);
			
			String sql = "insert into doctor (doctor_id,first_name,last_name,email,contact_no,department,experience,address,hospital_id) values(?,?,?,?,?,?,?,?,?)";
			//System.out.println(sql);
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getDoctor_id());
		    preparestatement.setString(2,form.getFirst_name());
		    preparestatement.setString(3,form.getLast_name());
		    preparestatement.setString(4,form.getEmail());
		    preparestatement.setString(5,form.getContact_no());
		    preparestatement.setString(6,form.getDepartment());
		    preparestatement.setInt(7,form.getExperience());
		    preparestatement.setString(8,form.getAddress());
		    preparestatement.setInt(9,form.getHospital_id());
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
	public void update(Doctor form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital_database", MySQL_user, MySQL_password);
			
			String sql = "UPDATE doctor SET first_name = ?, last_name = ?,email=?,contact_no=?,department=?,experience=?,address=?,hospital_id=? where doctor_id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getFirst_name());
			preparestatement.setString(2,form.getLast_name());
		    preparestatement.setString(3,form.getEmail());
		    preparestatement.setString(4,form.getContact_no());
		    preparestatement.setString(5,form.getDepartment());
		    preparestatement.setInt(6,form.getExperience());
		    preparestatement.setString(7,form.getAddress());
		    preparestatement.setInt(8,form.getHospital_id());
		    preparestatement.setInt(9,form.getDoctor_id());
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
			
			String sql = "delete from doctor where doctor_id = ?";
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
			String sql = "select * from doctor where department='dental'";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Doctor doctor = new Doctor();
				doctor.setFirst_name(resultSet.getString("first_name"));
	    		doctor.setDepartment(resultSet.getString("department"));
	    		doctor.setContact_no(resultSet.getString("contact_no"));
	    		list.add(doctor);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	public List<Object> findallH() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital_database", MySQL_user, MySQL_password);
			String sql = "CREATE OR REPLACE VIEW view3 AS\n"
					+ "	select doctor_id,h.name as hospital_name from hospital_database.doctor as d INNER JOIN hospital_database.hospital as h \n"
					+ "    ON d.hospital_id=h.hospital_id\n"
					+ "    where d.hospital_id in \n"
					+ "	(select hospital_id from hospital_database.hospital as h\n"
					+ "	 where h.employee_count>90);\n"
					+ "	\n"
					+ "\n";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.executeUpdate();
			sql = "select * from view3";
		    preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				DoctorHospital doctor = new DoctorHospital();
				doctor.setDoctor_id(Integer.parseInt(resultSet.getString("doctor_id")));
	    		doctor.setHospital_name(resultSet.getString("hospital_name"));	    		
	    		list.add(doctor);
			 }
			connect.close();
		} catch(SQLException e) {
			
			throw new RuntimeException(e);
		}
		return list;
		
	}
}
