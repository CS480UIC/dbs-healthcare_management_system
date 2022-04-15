package medication.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import medication.domain.Medication;
import medication.service.MedicationException;
import medication.service.MedicationService;


/**
 * Servlet implementation class UserServlet
 */

public class MedicationServletCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MedicationServletCreate() {
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
		MedicationService paymentservice = new MedicationService();
		Map<String,String[]> paramMap = request.getParameterMap();
		Medication form = new Medication();
		List<String> info = new ArrayList<String>();

		for(String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}
		
	
		
		 
		form.setMedicine_id(Integer.parseInt(info.get(0)));
		form.setMedicine_name(info.get(1));
		form.setPrice(Integer.parseInt(info.get(2)));	
		form.setMfg_date(java.sql.Date.valueOf(info.get(3)));
		form.setExp_date(java.sql.Date.valueOf(info.get(4)));
		
		form.setMfg_company(info.get(5));	
			
		
		form.setDoctor_id(Integer.parseInt(info.get(6)));	
		
		form.setPatient_id(Integer.parseInt(info.get(7)));
		
		try {
			paymentservice.create(form);
			response.sendRedirect( request.getContextPath() + "/jsps/main.jsp");
			
		} catch (ClassNotFoundException | MedicationException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		
	}

}
