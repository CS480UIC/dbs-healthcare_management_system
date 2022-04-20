package patient_medical_history_surgeries.service;


import patient_medical_history_surgeries.dao.PatientMedicalHistorySurgeriesDao;
import patient_medical_history_surgeries.domain.PatientMedicalHistorySurgeries;

/**
 * logic functions such as register, login
 * @author AB
 *
 */
public class PatientMedicalHistorySurgeriesService {
	private PatientMedicalHistorySurgeriesDao patient_medical_history_surgeriesDao = new PatientMedicalHistorySurgeriesDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(PatientMedicalHistorySurgeries form) throws PatientMedicalHistorySurgeriesException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		//System.out.println(form);
		PatientMedicalHistorySurgeries patient_medical_history_surgeries = patient_medical_history_surgeriesDao.findByMID(form.getHistory_id(), form.getSurgeries());
		if((patient_medical_history_surgeries.getHistory_id() != null && patient_medical_history_surgeries.getHistory_id()==form.getHistory_id()) && (patient_medical_history_surgeries.getSurgeries()!=null && patient_medical_history_surgeries.getSurgeries()== form.getSurgeries()) ) throw new PatientMedicalHistorySurgeriesException("This patient_medical_history_surgeries name has been registered!");
		patient_medical_history_surgeriesDao.add(form);
	}
	
	
}
