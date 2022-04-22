package patient_medical_history_medication.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import patient_medical_history_medication.dao.PatientMedicalHistoryMedicationDao;
import patient_medical_history_medication.domain.PatientMedicalHistoryMedication;
import patient_medical_history_medication.service.*;

/**
 * Servlet implementation class UserServlet
 */

public class PatientMedicalHistoryMedicationServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PatientMedicalHistoryMedicationServletUpdate() {
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
		PatientMedicalHistoryMedicationDao patient_medical_history_medicationdao = new PatientMedicalHistoryMedicationDao();
		PatientMedicalHistoryMedication patient_medical_history_medication = null;

		if(method.equals("search"))
		{
			try {
				patient_medical_history_medication = patient_medical_history_medicationdao.findByMID(Integer.parseInt(request.getParameter("history_id")), (request.getParameter("medication")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(patient_medical_history_medication.getHistory_id()!=null && patient_medical_history_medication.getMedication()!=null){
				request.setAttribute("patient_medical_history_medication", patient_medical_history_medication);
				request.getRequestDispatcher("/jsps/patient_medical_history_medication_entity/patient_medical_history_medication_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Payment not found");
				request.getRequestDispatcher("/jsps/patient_medical_history_medication_entity/patient_medical_history_medication_read_output.jsp").forward(request, response);
			}
			try {
				patient_medical_history_medicationdao.delete(patient_medical_history_medication.getHistory_id(), patient_medical_history_medication.getMedication());
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			PatientMedicalHistoryMedication form = new PatientMedicalHistoryMedication();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			System.out.print(info);
			
			form.setHistory_id(Integer.parseInt(info.get(1)));
			
			form.setMedication((info.get(2)));
			PatientMedicalHistoryMedicationService entity1service = new PatientMedicalHistoryMedicationService();
			
			try {
				entity1service.create(form);

			} catch (ClassNotFoundException | PatientMedicalHistoryMedicationException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "PatientMedicalHistoryMedication Updated");
			request.getRequestDispatcher("/jsps/patient_medical_history_medication_entity/patient_medical_history_medication_read_output.jsp").forward(request, response);
		}
	}
}



