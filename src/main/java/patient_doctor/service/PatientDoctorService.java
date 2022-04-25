package patient_doctor.service;


import patient_doctor.dao.PatientDoctorDao;
import patient_doctor.domain.PatientDoctor;

/**
 * logic functions such as register, login
 * @author AB
 *
 */
public class PatientDoctorService {
	private PatientDoctorDao patient_doctorDao = new PatientDoctorDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(PatientDoctor form) throws PatientDoctorException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		//System.out.println(form);
		PatientDoctor patient_doctor = patient_doctorDao.findByMID(form.getPatient_id(), form.getDoctor_id());
		if((patient_doctor.getPatient_id() != null && patient_doctor.getPatient_id()==form.getPatient_id()) && (patient_doctor.getDoctor_id()!=null && patient_doctor.getDoctor_id()== form.getDoctor_id()) ) throw new PatientDoctorException("This patient_doctor name has been registered!");
		patient_doctorDao.add(form);
	}
	
	
}
