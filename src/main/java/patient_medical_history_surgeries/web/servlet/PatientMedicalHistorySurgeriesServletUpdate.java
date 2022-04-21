package patient_medical_history_surgeries.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import patient_medical_history_surgeries.dao.PatientMedicalHistorySurgeriesDao;
import patient_medical_history_surgeries.domain.PatientMedicalHistorySurgeries;
import patient_medical_history_surgeries.service.*;

/**
 * Servlet implementation class UserServlet
 */

public class PatientMedicalHistorySurgeriesServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PatientMedicalHistorySurgeriesServletUpdate() {
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
		PatientMedicalHistorySurgeriesDao patient_medical_history_surgeriesdao = new PatientMedicalHistorySurgeriesDao();
		PatientMedicalHistorySurgeries patient_medical_history_surgeries = null;

		if(method.equals("search"))
		{
			try {
				patient_medical_history_surgeries = patient_medical_history_surgeriesdao.findByMID(Integer.parseInt(request.getParameter("history_id")), (request.getParameter("surgeries")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(patient_medical_history_surgeries.getHistory_id()!=null && patient_medical_history_surgeries.getSurgeries()!=null){
				request.setAttribute("patient_medical_history_surgeries", patient_medical_history_surgeries);
				request.getRequestDispatcher("/jsps/patient_medical_history_surgeries_entity/patient_medical_history_surgeries_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Payment not found");
				request.getRequestDispatcher("/jsps/patient_medical_history_surgeries_entity/patient_medical_history_surgeries_read_output.jsp").forward(request, response);
			}
			try {
				patient_medical_history_surgeriesdao.delete(patient_medical_history_surgeries.getHistory_id(), patient_medical_history_surgeries.getSurgeries());
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
			PatientMedicalHistorySurgeries form = new PatientMedicalHistorySurgeries();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			System.out.print(info);
			
			form.setHistory_id(Integer.parseInt(info.get(1)));
			
			form.setSurgeries((info.get(2)));
			PatientMedicalHistorySurgeriesService entity1service = new PatientMedicalHistorySurgeriesService();
			
			try {
				entity1service.create(form);

			} catch (ClassNotFoundException | PatientMedicalHistorySurgeriesException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "PatientMedicalHistorySurgeries Updated");
			request.getRequestDispatcher("/jsps/patient_medical_history_surgeries_entity/patient_medical_history_surgeries_read_output.jsp").forward(request, response);
		}
	}
}



