package payment.service;


import java.util.List;

import payment.dao.PaymentDao;
import payment.domain.Payment;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class PaymentService {
	private PaymentDao paymentDao = new PaymentDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Payment form) throws PaymentException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		//System.out.println(form);
		Payment payment = paymentDao.findByPID(form.getPayment_id());
		if(payment.getPayment_id() != null && payment.getPayment_id()==form.getPayment_id()) throw new PaymentException("This payment name has been registered!");
		paymentDao.add(form);
	}
	
	public List<Object> findTotalPayments() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return paymentDao.findTotalPayments();
		
	}
	
	
}
