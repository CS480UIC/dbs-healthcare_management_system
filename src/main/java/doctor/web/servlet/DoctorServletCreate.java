package doctor.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import doctor.domain.Payment;
import doctor.service.DoctorException;
import doctor.service.PaymentService;


/**
 * Servlet implementation class UserServlet
 */

public class DoctorServletCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorServletCreate() {
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
		PaymentService entity1service = new PaymentService();
		Map<String,String[]> paramMap = request.getParameterMap();
		Payment form = new Payment();
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
		
		 
		form.setDoctor_id(Integer.parseInt(info.get(0)));
		form.setFirst_name(info.get(1));
		form.setLast_name(info.get(2));	
		form.setEmail(info.get(3));
		form.setContact_no(info.get(4));	
			
		form.setExperience(Integer.parseInt(info.get(5)));	
		form.setDepartment(info.get(6));	
		form.setAddress(info.get(7));
		form.setHospital_id(Integer.parseInt(info.get(8)));
		
		try {
			entity1service.create(form);
			response.sendRedirect( request.getContextPath() + "/jsps/main.jsp");
			
		} catch (ClassNotFoundException | DoctorException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		
	}

}
