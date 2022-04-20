package hospital.service;


import hospital.dao.HospitalDao;
import hospital.domain.Hospital;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class HospitalService {
	private HospitalDao hospitalDao = new HospitalDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Hospital form) throws HospitalException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		//System.out.println(form);
		Hospital entity1 = hospitalDao.findByDID(form.getHospital_id());
		if(entity1.getHospital_id() != null && entity1.getHospital_id()==form.getHospital_id()) throw new HospitalException("This hospital name has been registered!");
		hospitalDao.add(form);
	}
	
	
}
