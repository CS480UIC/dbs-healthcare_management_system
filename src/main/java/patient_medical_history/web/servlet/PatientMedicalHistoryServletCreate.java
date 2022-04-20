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

import patient_medical_history.domain.PatientMedicalHistory;
import patient_medical_history.service.PatientMedicalHistoryException;
import patient_medical_history.service.PatientMedicalHistoryService;


/**
 * Servlet implementation class UserServlet
 */

public class PatientMedicalHistoryServletCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientMedicalHistoryServletCreate() {
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
		PatientMedicalHistoryService paymentservice = new PatientMedicalHistoryService();
		Map<String,String[]> paramMap = request.getParameterMap();
		PatientMedicalHistory form = new PatientMedicalHistory();
		List<String> info = new ArrayList<String>();

		for(String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}
		
	
		
		 
		form.setHistory_id(Integer.parseInt(info.get(0)));
		form.setConditions(info.get(1));
		form.setLast_visit(java.sql.Date.valueOf(info.get(2)));	
		
		form.setPatient_id(Integer.parseInt(info.get(3)));
		
		try {
			paymentservice.create(form);
			response.sendRedirect( request.getContextPath() + "/jsps/main.jsp");
			
		} catch (ClassNotFoundException | PatientMedicalHistoryException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		
	}

}
