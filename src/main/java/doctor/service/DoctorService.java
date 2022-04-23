package doctor.service;


import java.util.List;

import doctor.dao.DoctorDao;
import doctor.domain.Doctor;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class DoctorService {
	private DoctorDao doctorDao = new DoctorDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Doctor form) throws DoctorException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		//System.out.println(form);
		Doctor entity1 = doctorDao.findByDID(form.getDoctor_id());
		if(entity1.getDoctor_id() != null && entity1.getDoctor_id()==form.getDoctor_id()) throw new DoctorException("This doctor name has been registered!");
		doctorDao.add(form);
	}
	
	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return doctorDao.findall();
		
	}
	public List<Object> findallH() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return doctorDao.findallH();
		
	}
	
	
}
