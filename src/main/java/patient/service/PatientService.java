package patient.service;


import java.util.List;

import patient.dao.PatientDao;
import patient.domain.Patient;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class PatientService {
	private PatientDao patientDao = new PatientDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Patient form) throws PatientException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		//System.out.println(form);
		Patient entity1 = patientDao.findByDID(form.getPatient_id());
		if(entity1.getPatient_id() != null && entity1.getPatient_id()==form.getPatient_id()) throw new PatientException("This patient name has been registered!");
		patientDao.add(form);
	}
	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return patientDao.findall();
		
	}
	
}
