package doctor.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import doctor.dao.PaymentDao;
import doctor.domain.Payment;


/**
 * Servlet implementation class UserServlet
 */

public class DoctorServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorServletRead() {
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
		Payment doctor = null;
		PaymentDao entity1Dao = new PaymentDao();
		
		try {
			System.out.println("doctor_id");
			System.out.println(request.getParameter("doctor_id"));
			doctor = entity1Dao.findByDID(Integer.parseInt(request.getParameter("doctor_id")));
			
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(doctor.getDoctor_id()!=null){
					System.out.println(doctor);
					request.setAttribute("doctor", doctor);
					request.getRequestDispatcher("/jsps/doctor_entity/doctor_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "Entity not found");
			request.getRequestDispatcher("/jsps/doctor_entity/doctor_read_output.jsp").forward(request, response);
		}
	}
}



