package patient_medical_history.service;


import patient_medical_history.dao.Patient_medical_historyDao;
import patient_medical_history.domain.Patient_medical_history;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class Patient_medical_historyService {
	private Patient_medical_historyDao patient_medical_historyDao = new Patient_medical_historyDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Patient_medical_history form) throws Patient_medical_historyException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		//System.out.println(form);
		Patient_medical_history patient_medical_history = patient_medical_historyDao.findByMID(form.getHistory_id());
		if(patient_medical_history.getHistory_id() != null && patient_medical_history.getHistory_id()==form.getHistory_id()) throw new Patient_medical_historyException("This patient_medical_history name has been registered!");
		patient_medical_historyDao.add(form);
	}
	
	
}
