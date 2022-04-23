package medication.service;


import java.util.List;

import medication.dao.MedicationDao;
import medication.domain.Medication;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class MedicationService {
	private MedicationDao medicationDao = new MedicationDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Medication form) throws MedicationException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		//System.out.println(form);
		Medication medication = medicationDao.findByMID(form.getMedicine_id());
		if(medication.getMedicine_id() != null && medication.getMedicine_id()==form.getMedicine_id()) throw new MedicationException("This medication name has been registered!");
		medicationDao.add(form);
	}
	
	public List<Object> findTotalPrice() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return medicationDao.findTotalPrice();
		
	}
	
	
}
