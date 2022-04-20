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

import patient_medical_history.domain.Patient_medical_history;
import patient_medical_history.service.Patient_medical_historyException;
import patient_medical_history.service.Patient_medical_historyService;


/**
 * Servlet implementation class UserServlet
 */

public class Patient_medical_historyServletCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Patient_medical_historyServletCreate() {
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
		Patient_medical_historyService paymentservice = new Patient_medical_historyService();
		Map<String,String[]> paramMap = request.getParameterMap();
		Patient_medical_history form = new Patient_medical_history();
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
			
		} catch (ClassNotFoundException | Patient_medical_historyException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		
	}

}
