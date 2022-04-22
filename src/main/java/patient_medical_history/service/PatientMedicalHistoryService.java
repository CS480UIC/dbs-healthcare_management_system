package patient_medical_history.service;


import patient_medical_history.dao.PatientMedicalHistoryDao;
import patient_medical_history.domain.PatientMedicalHistory;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class PatientMedicalHistoryService {
	private PatientMedicalHistoryDao patient_medical_historyDao = new PatientMedicalHistoryDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(PatientMedicalHistory form) throws PatientMedicalHistoryException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		//System.out.println(form);
		PatientMedicalHistory patient_medical_history = patient_medical_historyDao.findByMID(form.getHistory_id());
		if(patient_medical_history.getHistory_id() != null && patient_medical_history.getHistory_id()==form.getHistory_id()) throw new PatientMedicalHistoryException("This patient_medical_history name has been registered!");
		patient_medical_historyDao.add(form);
	}
	
	
}
