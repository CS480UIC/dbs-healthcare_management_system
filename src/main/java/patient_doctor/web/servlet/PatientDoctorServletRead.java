package patient_doctor.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import patient_doctor.dao.PatientDoctorDao;
import patient_doctor.domain.PatientDoctor;


/**
 * Servlet implementation class UserServlet
 */

public class PatientDoctorServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientDoctorServletRead() {
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
		PatientDoctor patient_doctor = null;
	    PatientDoctorDao patient_doctorDao = new PatientDoctorDao();
		
		try {
			
			patient_doctor = patient_doctorDao.findByMID(Integer.parseInt(request.getParameter("patient_id")), Integer.parseInt(request.getParameter("doctor_id")));
			
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(patient_doctor.getPatient_id()!=null && patient_doctor.getDoctor_id()!=null){
					System.out.println(patient_doctor.getPatient_id());
					System.out.println(patient_doctor.getDoctor_id());
					request.setAttribute("patient_doctor", patient_doctor);
					request.getRequestDispatcher("/jsps/patient_doctor_entity/patient_doctor_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "PatientDoctor not found");
			request.getRequestDispatcher("/jsps/patient_doctor_entity/patient_doctor_read_output.jsp").forward(request, response);
		}
	}
}



