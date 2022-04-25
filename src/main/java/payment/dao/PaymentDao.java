package payment.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import java.util.ArrayList;
//import java.util.List;

import payment.domain.Payment;

/**
 * DDL functions performed in database
 */
public class PaymentDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "healthcaresystem"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "health"; //TODO change password

	public Payment findByPID(Integer p_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Payment payment = new Payment();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital_database", MySQL_user, MySQL_password);
		    String sql = "select * from payment where payment_id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,p_id);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer payment_id = Integer.parseInt(resultSet.getString("payment_id"));
		    	System.out.print(payment_id);
		    	System.out.print(p_id);
		    	if(payment_id.equals(p_id)){
		    		System.out.print("hiiiiiiiii");
		    		payment.setPayment_id(payment_id);
		    		payment.setFirst_name(resultSet.getString("first_name"));
		    		payment.setLast_name(resultSet.getString("last_name"));
		    		payment.setTreatment(resultSet.getString("treatment"));
		    		payment.setDoc_referred(resultSet.getString("doc_referred"));
		    		payment.setType_of_payment(resultSet.getString("type_of_payment"));
		    		payment.setDate(java.sql.Date.valueOf(resultSet.getString("date")));
		    		payment.setPatient_id(Integer.parseInt(resultSet.getString("patient_id")));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return payment;
	}	
	
	/**
	 * insert Doctor
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Payment form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital_database", MySQL_user, MySQL_password);
			
			String sql = "insert into payment (payment_id,first_name,last_name,type_of_payment,doc_referred,date,treatment,patient_id) values(?,?,?,?,?,?,?,?)";
			//System.out.println(sql);
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getPayment_id());
		    preparestatement.setString(2,form.getFirst_name());
		    preparestatement.setString(3,form.getLast_name());
		    preparestatement.setString(4,form.getType_of_payment());
		    preparestatement.setString(5,form.getDoc_referred());
		    preparestatement.setDate(6,form.getDate());
		    preparestatement.setString(7,form.getTreatment());
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
	public void update(Payment form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital_database", MySQL_user, MySQL_password);
			
			String sql = "UPDATE payment SET first_name = ?, last_name = ?,type_of_payment=?,doc_referred=?,date=?,treatment=?,patient_id=? where payment_id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			
		    preparestatement.setString(1,form.getFirst_name());
		    preparestatement.setString(2,form.getLast_name());
		    preparestatement.setString(3,form.getType_of_payment());
		    preparestatement.setString(4,form.getDoc_referred());
		    preparestatement.setDate(5,form.getDate());
		    preparestatement.setString(6,form.getTreatment());
		    preparestatement.setInt(7,form.getPatient_id());
		    preparestatement.setInt(8,form.getPayment_id());
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
	public void delete(Integer p_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital_database", MySQL_user, MySQL_password);
			
			String sql = "delete from payment where payment_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,p_id);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public  List<Object> findTotalPayments() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital_database", MySQL_user, MySQL_password);
			String sql = "select COUNT(payment_id) as TOTAL_FUNDS_COLLECTED from PAYMENT  where date > \"2022-02-11\"";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
			
	    		list.add(resultSet.getString("TOTAL_FUNDS_COLLECTED"));
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
}
