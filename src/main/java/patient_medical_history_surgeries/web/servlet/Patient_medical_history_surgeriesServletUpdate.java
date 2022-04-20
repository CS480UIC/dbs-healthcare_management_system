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

import patient_medical_history_surgeries.dao.Patient_medical_history_surgeriesDao;
import patient_medical_history_surgeries.domain.Patient_medical_history_surgeries;

/**
 * Servlet implementation class UserServlet
 */

public class Patient_medical_history_surgeriesServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Patient_medical_history_surgeriesServletUpdate() {
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
		Patient_medical_history_surgeriesDao patient_medical_history_surgeriesdao = new Patient_medical_history_surgeriesDao();
		Patient_medical_history_surgeries patient_medical_history_surgeries = null;

		if(method.equals("search"))
		{
			try {
				patient_medical_history_surgeries = patient_medical_history_surgeriesdao.findByMID(Integer.parseInt(request.getParameter("history_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(patient_medical_history_surgeries.getHistory_id()!=null){
				request.setAttribute("patient_medical_history_surgeries", patient_medical_history_surgeries);
				request.getRequestDispatcher("/jsps/patient_medical_history_surgeries_entity/patient_medical_history_surgeries_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Payment not found");
				request.getRequestDispatcher("/jsps/patient_medical_history_surgeries_entity/patient_medical_history_surgeries_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Patient_medical_history_surgeries form = new Patient_medical_history_surgeries();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			System.out.print(info);
			
			form.setHistory_id(Integer.parseInt(info.get(1)));
			
			form.setSurgeries(Integer.parseInt(info.get(2)));

			try {
				patient_medical_history_surgeriesdao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Patient_medical_history_surgeries Updated");
			request.getRequestDispatcher("/jsps/patient_medical_history_surgeries_entity/patient_medical_history_surgeries_read_output.jsp").forward(request, response);
		}
	}
}



