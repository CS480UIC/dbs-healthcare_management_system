package patient.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import patient.domain.Patient;
import patient.service.PatientException;
import patient.service.PatientService;


/**
 * Servlet implementation class UserServlet
 */

public class PatientServletCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientServletCreate() {
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
		PatientService entity1service = new PatientService();
		Map<String,String[]> paramMap = request.getParameterMap();
		Patient form = new Patient();
		List<String> info = new ArrayList<String>();

		for(String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}
		System.out.println("0");
		System.out.println(info.get(0));
		System.out.println("1");
		System.out.println(info.get(1));
		System.out.println("2");
		System.out.println(info.get(2));
		System.out.println("3");
		System.out.println(info.get(3));
		
		 
		form.setPatient_id(Integer.parseInt(info.get(0)));
		form.setFirst_name(info.get(1));
		form.setLast_name(info.get(2));	
		form.setContact_no(info.get(3));
		form.setEmail(info.get(4));
		form.setGender(info.get(5));
		form.setAge(Integer.parseInt(info.get(6)));
		form.setUser_name((info.get(7)));	
		form.setPassword(info.get(8));	
		form.setHospital_id(Integer.parseInt(info.get(9)));
		form.setDoctor_id(Integer.parseInt(info.get(10)));
		
		try {
			entity1service.create(form);
			response.sendRedirect( request.getContextPath() + "/jsps/main.jsp");
			
		} catch (ClassNotFoundException | PatientException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		
	}

}
