package medication.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import doctor.domain.Doctor;

//import java.util.ArrayList;
//import java.util.List;

import medication.domain.Medication;

/**
 * DDL functions performed in database
 */
public class MedicationDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "healthcaresystem"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "health"; //TODO change password

	public Medication findByMID(Integer m_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Medication medication= new Medication();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital_database", MySQL_user, MySQL_password);
		    String sql = "select * from medication where medicine_id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,m_id);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer medicine_id = Integer.parseInt(resultSet.getString("medicine_id"));
		    	System.out.print(medicine_id);
		    	System.out.print(m_id);
		    	if(medicine_id.equals(m_id)){
		    		System.out.print("hiiiiiiiii");
		    		medication.setMedicine_id(medicine_id);
		    		medication.setMedicine_name(resultSet.getString("medicine_name"));
		    		medication.setPrice(Integer.parseInt(resultSet.getString("price")));
		    		medication.setMfg_date(java.sql.Date.valueOf(resultSet.getString("mfg_date")));
		    		medication.setExp_date(java.sql.Date.valueOf(resultSet.getString("exp_date")));
		    		medication.setMfg_company(resultSet.getString("mfg_company"));
		    		medication.setDoctor_id(Integer.parseInt(resultSet.getString("doctor_id")));
		    		medication.setPatient_id(Integer.parseInt(resultSet.getString("patient_id")));
		    		
		    		
		    	
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return medication;
	}	
	
	/**
	 * insert Doctor
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Medication form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital_database", MySQL_user, MySQL_password);
			
			String sql = "insert into medication (medicine_id,medicine_name,price,mfg_date,exp_date,mfg_company,doctor_id,patient_id) values(?,?,?,?,?,?,?,?)";
			//System.out.println(sql);
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getMedicine_id());
		    preparestatement.setString(2,form.getMedicine_name());
		    preparestatement.setInt(3,form.getPrice());
		    preparestatement.setDate(4,form.getMfg_date());
		    preparestatement.setDate(5,form.getExp_date());
		    preparestatement.setString(6,form.getMfg_company());
		    preparestatement.setInt(7,form.getDoctor_id());
		    preparestatement.setInt(8,form.getPatient_id());
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
	public void update(Medication form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital_database", MySQL_user, MySQL_password);
			
			String sql = "UPDATE medication SET medicine_name = ?, price = ?,mfg_date=?,exp_date=?,mfg_company=?,doctor_id=?,patient_id=? where medicine_id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			
		    preparestatement.setString(1,form.getMedicine_name());
		    preparestatement.setInt(2,form.getPrice());
		    preparestatement.setDate(3,form.getMfg_date());
		    preparestatement.setDate(4,form.getExp_date());
		    preparestatement.setString(5,form.getMfg_company());
		    preparestatement.setInt(6,form.getDoctor_id());
		    preparestatement.setInt(7,form.getPatient_id());
		    preparestatement.setInt(8,form.getMedicine_id());
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
			
			String sql = "delete from medication where medicine_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,m_id);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Object> findTotalPrice() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital_database", MySQL_user, MySQL_password);
			String sql = "select SUM(price) as TOTAL_PRICE from medication  where mfg_company='tcs'";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				
				
	    	
	    		
	    		list.add(resultSet.getString("TOTAL_PRICE"));
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
}
}
