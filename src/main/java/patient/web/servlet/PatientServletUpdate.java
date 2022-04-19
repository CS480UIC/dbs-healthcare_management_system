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

import patient.dao.PatientDao;
import patient.domain.Patient;

/**
 * Servlet implementation class UserServlet
 */

public class PatientServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PatientServletUpdate() {
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
		PatientDao patientdao = new PatientDao();
		Patient entity1 = null;

		if(method.equals("search"))
		{
			try {
				entity1 = patientdao.findByDID(Integer.parseInt(request.getParameter("patient_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(entity1.getPatient_id()!=null){
				request.setAttribute("patient", entity1);
				request.getRequestDispatcher("/jsps/patient_entity/patient_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Patient not found");
				request.getRequestDispatcher("/jsps/patient_entity/patient_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Patient form = new Patient();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			System.out.print(info);
			form.setPatient_id(Integer.parseInt(request.getParameter("patient_id")));
			form.setFirst_name(info.get(2));
			form.setLast_name(info.get(3));	
			form.setContact_no(info.get(4));	
			form.setEmail(info.get(5));
			form.setGender(info.get(6));	
			form.setAge(Integer.parseInt(info.get(7)));	
			form.setUser_name(info.get(8));	
			form.setPassword(info.get(9));
			form.setHospital_id(Integer.parseInt(info.get(10)));
			form.setDoctor_id(Integer.parseInt(info.get(11)));

			try {
				patientdao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Patient Updated");
			request.getRequestDispatcher("/jsps/patient_entity/patient_read_output.jsp").forward(request, response);
		}
	}
}



