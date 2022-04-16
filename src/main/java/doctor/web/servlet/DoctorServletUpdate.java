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

import doctor.dao.DoctorDao;
import doctor.domain.Doctor;

/**
 * Servlet implementation class UserServlet
 */

public class DoctorServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoctorServletUpdate() {
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
		DoctorDao doctordao = new DoctorDao();
		Doctor entity1 = null;

		if(method.equals("search"))
		{
			try {
				entity1 = doctordao.findByDID(Integer.parseInt(request.getParameter("doctor_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(entity1.getDoctor_id()!=null){
				request.setAttribute("doctor", entity1);
				request.getRequestDispatcher("/jsps/doctor_entity/doctor_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Doctor not found");
				request.getRequestDispatcher("/jsps/doctor_entity/doctor_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Doctor form = new Doctor();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			System.out.print(info);
			form.setDoctor_id(Integer.parseInt(request.getParameter("doctor_id")));
			form.setFirst_name(info.get(2));
			form.setLast_name(info.get(3));	
			form.setEmail(info.get(4));
			form.setContact_no(info.get(5));	
				
			form.setExperience(Integer.parseInt(info.get(6)));	
			form.setDepartment(info.get(7));	
			form.setAddress(info.get(8));
			form.setHospital_id(Integer.parseInt(info.get(9)));

			try {
				doctordao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Doctor Updated");
			request.getRequestDispatcher("/jsps/doctor_entity/doctor_read_output.jsp").forward(request, response);
		}
	}
}



