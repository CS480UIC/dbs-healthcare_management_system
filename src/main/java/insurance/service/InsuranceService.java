package insurance.service;


import java.util.List;

import insurance.dao.InsuranceDao;
import insurance.domain.Insurance;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class InsuranceService {
	private InsuranceDao insuranceDao = new InsuranceDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Insurance form) throws InsuranceException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		//System.out.println(form);
		Insurance insurance = insuranceDao.findByMID(form.getInsurance_id());
		if(insurance.getInsurance_id() != null && insurance.getInsurance_id()==form.getInsurance_id()) throw new InsuranceException("This insurance name has been registered!");
		insuranceDao.add(form);
	}
	public List<Object> findallP() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return insuranceDao.findallP();
		
	}
	
}
