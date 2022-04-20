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

import patient_medical_history_surgeries.domain.Patient_medical_history_surgeries;
import patient_medical_history_surgeries.service.Patient_medical_history_surgeriesException;
import patient_medical_history_surgeries.service.Patient_medical_history_surgeriesService;


/**
 * Servlet implementation class UserServlet
 */

public class Patient_medical_history_surgeriesServletCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Patient_medical_history_surgeriesServletCreate() {
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
		Patient_medical_history_surgeriesService paymentservice = new Patient_medical_history_surgeriesService();
		Map<String,String[]> paramMap = request.getParameterMap();
		Patient_medical_history_surgeries form = new Patient_medical_history_surgeries();
		List<String> info = new ArrayList<String>();

		for(String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}
		
	
		
		 
		form.setHistory_id(Integer.parseInt(info.get(0)));
		
		form.setSurgeries(Integer.parseInt(info.get(1)));
		
		try {
			paymentservice.create(form);
			response.sendRedirect( request.getContextPath() + "/jsps/main.jsp");
			
		} catch (ClassNotFoundException | Patient_medical_history_surgeriesException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		
	}

}
