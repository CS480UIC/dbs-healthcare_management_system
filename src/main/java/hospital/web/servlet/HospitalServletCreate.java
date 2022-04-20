package hospital.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hospital.domain.Hospital;
import hospital.service.HospitalException;
import hospital.service.HospitalService;


/**
 * Servlet implementation class UserServlet
 */

public class HospitalServletCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HospitalServletCreate() {
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
		HospitalService entity1service = new HospitalService();
		Map<String,String[]> paramMap = request.getParameterMap();
		Hospital form = new Hospital();
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
		
		 
		form.setHospital_id(Integer.parseInt(info.get(0)));
		form.setName(info.get(1));
		form.setAddress(info.get(2));
		form.setContact_no(info.get(3));	
		form.setEmail(info.get(4));		
		form.setEmployee_count(Integer.parseInt(info.get(5)));	
		
		
		try {
			entity1service.create(form);
			response.sendRedirect( request.getContextPath() + "/jsps/main.jsp");
			
		} catch (ClassNotFoundException | HospitalException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		
	}

}
