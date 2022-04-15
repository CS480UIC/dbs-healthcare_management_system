package doctor.service;


import doctor.dao.PaymentDao;
import doctor.domain.Payment;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class PaymentService {
	private PaymentDao doctorDao = new PaymentDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Payment form) throws DoctorException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		//System.out.println(form);
		Payment entity1 = doctorDao.findByDID(form.getDoctor_id());
		if(entity1.getDoctor_id() != null && entity1.getDoctor_id()==form.getDoctor_id()) throw new DoctorException("This doctor name has been registered!");
		doctorDao.add(form);
	}
	
	
}
