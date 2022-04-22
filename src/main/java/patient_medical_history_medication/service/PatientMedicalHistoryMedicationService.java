package patient_medical_history_medication.service;


import patient_medical_history_medication.dao.PatientMedicalHistoryMedicationDao;
import patient_medical_history_medication.domain.PatientMedicalHistoryMedication;

/**
 * logic functions such as register, login
 * @author AB
 *
 */
public class PatientMedicalHistoryMedicationService {
	private PatientMedicalHistoryMedicationDao patient_medical_history_medicationDao = new PatientMedicalHistoryMedicationDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(PatientMedicalHistoryMedication form) throws PatientMedicalHistoryMedicationException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		//System.out.println(form);
		PatientMedicalHistoryMedication patient_medical_history_medication = patient_medical_history_medicationDao.findByMID(form.getHistory_id(), form.getMedication());
		if((patient_medical_history_medication.getHistory_id() != null && patient_medical_history_medication.getHistory_id()==form.getHistory_id()) && (patient_medical_history_medication.getMedication()!=null && patient_medical_history_medication.getMedication()== form.getMedication()) ) throw new PatientMedicalHistoryMedicationException("This patient_medical_history_medication name has been registered!");
		patient_medical_history_medicationDao.add(form);
	}
	
	
}
