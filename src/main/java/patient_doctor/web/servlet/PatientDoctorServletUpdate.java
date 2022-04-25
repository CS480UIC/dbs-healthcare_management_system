package patient_doctor.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import patient_doctor.dao.PatientDoctorDao;
import patient_doctor.domain.PatientDoctor;
import patient_doctor.service.*;

/**
 * Servlet implementation class UserServlet
 */

public class PatientDoctorServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PatientDoctorServletUpdate() {
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
		PatientDoctorDao patient_doctordao = new PatientDoctorDao();
		PatientDoctor patient_doctor = null;

		if(method.equals("search"))
		{
			try {
				patient_doctor = patient_doctordao.findByMID(Integer.parseInt(request.getParameter("patient_id")), Integer.parseInt(request.getParameter("doctor_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(patient_doctor.getPatient_id()!=null && patient_doctor.getDoctor_id()!=null){
				request.setAttribute("patient_doctor", patient_doctor);
				request.getRequestDispatcher("/jsps/patient_doctor_entity/patient_doctor_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Patient_Doctor not found");
				request.getRequestDispatcher("/jsps/patient_doctor_entity/patient_doctor_read_output.jsp").forward(request, response);
			}
			try {
				patient_doctordao.delete(patient_doctor.getPatient_id(), patient_doctor.getDoctor_id());
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			PatientDoctor form = new PatientDoctor();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			System.out.print(info);
			
			form.setPatient_id(Integer.parseInt(info.get(1)));
			form.setDoctor_id(Integer.parseInt(info.get(2)));
			PatientDoctorService entity1service = new PatientDoctorService();
			
			try {
				entity1service.create(form);

			} catch (ClassNotFoundException | PatientDoctorException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "PatientDoctor Updated");
			request.getRequestDispatcher("/jsps/patient_doctor_entity/patient_doctor_read_output.jsp").forward(request, response);
		}
	}
}



