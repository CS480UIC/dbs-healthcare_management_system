package patient_medical_history.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import patient_medical_history.dao.PatientMedicalHistoryDao;
import patient_medical_history.domain.PatientMedicalHistory;

/**
 * Servlet implementation class UserServlet
 */

public class PatientMedicalHistoryServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PatientMedicalHistoryServletUpdate() {
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
		PatientMedicalHistoryDao patient_medical_historydao = new PatientMedicalHistoryDao();
		PatientMedicalHistory patient_medical_history = null;

		if(method.equals("search"))
		{
			try {
				patient_medical_history = patient_medical_historydao.findByMID(Integer.parseInt(request.getParameter("history_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(patient_medical_history.getHistory_id()!=null){
				request.setAttribute("patient_medical_history", patient_medical_history);
				request.getRequestDispatcher("/jsps/patient_medical_history_entity/patient_medical_history_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Payment not found");
				request.getRequestDispatcher("/jsps/patient_medical_history_entity/patient_medical_history_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			PatientMedicalHistory form = new PatientMedicalHistory();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			System.out.print(info);
			
			form.setHistory_id(Integer.parseInt(info.get(1)));
			form.setConditions(info.get(2));
			form.setLast_visit(java.sql.Date.valueOf(info.get(3)));
			
			form.setPatient_id(Integer.parseInt(info.get(4)));

			try {
				patient_medical_historydao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "PatientMedicalHistory Updated");
			request.getRequestDispatcher("/jsps/patient_medical_history_entity/patient_medical_history_read_output.jsp").forward(request, response);
		}
	}
}



