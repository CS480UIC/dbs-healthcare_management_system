package patient_medical_history_medication.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import patient_medical_history_medication.dao.PatientMedicalHistoryMedicationDao;
import patient_medical_history_medication.domain.PatientMedicalHistoryMedication;


/**
 * Servlet implementation class UserServlet
 */

public class PatientMedicalHistoryMedicationServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientMedicalHistoryMedicationServletDelete() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		PatientMedicalHistoryMedicationDao patient_medical_history_medicationDao = new PatientMedicalHistoryMedicationDao();
		PatientMedicalHistoryMedication patient_medical_history_medication = null;
		if(method.equals("search"))
		{
			try {
				patient_medical_history_medication = patient_medical_history_medicationDao.findByMID(Integer.parseInt(request.getParameter("history_id")), (request.getParameter("medication")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
			if(patient_medical_history_medication.getHistory_id()!=null && patient_medical_history_medication.getMedication()!=null){
						
						request.setAttribute("patient_medical_history_medication", patient_medical_history_medication);
						request.getRequestDispatcher("/jsps/patient_medical_history_medication_entity/patient_medical_history_medication_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "PatientMedicalHistoryMedication not found");
				request.getRequestDispatcher("/jsps/patient_medical_history_medication_entity/patient_medical_history_medication_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				patient_medical_history_medicationDao.delete(Integer.parseInt(request.getParameter("history_id")), (request.getParameter("medication")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "PatientMedicalHistoryMedication Deleted");
			request.getRequestDispatcher("/jsps/patient_medical_history_medication_entity/patient_medical_history_medication_read_output.jsp").forward(request, response);
		}
	}
}



