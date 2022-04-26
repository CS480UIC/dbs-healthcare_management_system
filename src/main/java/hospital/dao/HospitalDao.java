package hospital.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import doctor.domain.Doctor;

//import java.util.ArrayList;
//import java.util.List;

import hospital.domain.Hospital;
import hospital.domain.HospitalCount;
import patient.domain.Patient;

/**
 * DDL functions performed in database
 */
public class HospitalDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "healthcaresystem"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "health"; //TODO change password

	public Hospital findByDID(Integer h_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Hospital hospital = new Hospital();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital_database", MySQL_user, MySQL_password);
		    String sql = "select * from hospital where hospital_id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,h_id);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer hospital_id = Integer.parseInt(resultSet.getString("hospital_id"));
		    	System.out.print(hospital_id);
		    	System.out.print(h_id);
		    	if(hospital_id.equals(h_id)){
		    		//System.out.print("hiiiiiiiii");
		    		hospital.setHospital_id(hospital_id);
		    		hospital.setName(resultSet.getString("name"));
		    		hospital.setAddress(resultSet.getString("address"));
		    		hospital.setContact_no(resultSet.getString("contact_no"));
		    		hospital.setEmail(resultSet.getString("email"));
		    		hospital.setEmployee_count(Integer.parseInt(resultSet.getString("employee_count")));
		    		
		    			
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return hospital;
	}	
	
	/**
	 * insert Hospital
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Hospital form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital_database", MySQL_user, MySQL_password);
			
			String sql = "insert into hospital (hospital_id,name,address,contact_no,email,employee_count) values(?,?,?,?,?,?)";
			//System.out.println(sql);
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getHospital_id());
		    preparestatement.setString(2,form.getName());
		    preparestatement.setString(3,form.getAddress());
		    preparestatement.setString(4,form.getContact_no());
		    preparestatement.setString(5,form.getEmail());
		    preparestatement.setInt(6,form.getEmployee_count());
		    
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
	public void update(Hospital form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital_database", MySQL_user, MySQL_password);
			
			String sql = "UPDATE hospital SET name = ?,address=?,contact_no=?,email=?,employee_count=? where hospital_id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getName());
		    preparestatement.setString(2,form.getAddress());
		    preparestatement.setString(3,form.getContact_no());
		    preparestatement.setString(4,form.getEmail());
		    preparestatement.setInt(5,form.getEmployee_count());
		    preparestatement.setInt(6,form.getHospital_id());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @param h_id
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void delete(Integer h_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital_database", MySQL_user, MySQL_password);
			
			String sql = "delete from hospital where hospital_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,h_id);
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
			String sql = "select * from hospital where employee_count>50";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Hospital hospital = new Hospital();
				hospital.setName(resultSet.getString("name"));
	    		hospital.setEmail(resultSet.getString("email"));
	    		hospital.setContact_no(resultSet.getString("contact_no"));
	    		list.add(hospital);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	
		
	}
	
	public List<Object> findTotalCount() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital_database", MySQL_user, MySQL_password);
			String sql = "select name,SUM(employee_count) as Count from hospital  GROUP BY name HAVING SUM(employee_count) < 100";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				HospitalCount hospital = new HospitalCount();
				hospital.setName(resultSet.getString("name"));
	    	    hospital.setCount(Integer.parseInt(resultSet.getString("Count")));
	    		
	    		
	    		list.add(hospital);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
}
