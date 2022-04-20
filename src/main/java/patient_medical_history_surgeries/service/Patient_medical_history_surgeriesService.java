package patient_medical_history_surgeries.service;


import patient_medical_history_surgeries.dao.Patient_medical_history_surgeriesDao;
import patient_medical_history_surgeries.domain.Patient_medical_history_surgeries;

/**
 * logic functions such as register, login
 * @author AB
 *
 */
public class Patient_medical_history_surgeriesService {
	private Patient_medical_history_surgeriesDao patient_medical_history_surgeriesDao = new Patient_medical_history_surgeriesDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Patient_medical_history_surgeries form) throws Patient_medical_history_surgeriesException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		//System.out.println(form);
		Patient_medical_history_surgeries patient_medical_history_surgeries = patient_medical_history_surgeriesDao.findByMID(form.getHistory_id(), form.getSurgeries());
		if((patient_medical_history_surgeries.getHistory_id() != null && patient_medical_history_surgeries.getHistory_id()==form.getHistory_id()) && (patient_medical_history_surgeries.getSurgeries()!=null && patient_medical_history_surgeries.getSurgeries()== form.getSurgeries()) ) throw new Patient_medical_history_surgeriesException("This patient_medical_history_surgeries name has been registered!");
		patient_medical_history_surgeriesDao.add(form);
	}
	
	
}
