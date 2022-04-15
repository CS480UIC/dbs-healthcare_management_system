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

public class DoctorServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorServletDelete() {
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
		PaymentDao doctorDao = new PaymentDao();
		Payment entity1 = null;
		if(method.equals("search"))
		{
			try {
				entity1 = doctorDao.findByDID(Integer.parseInt(request.getParameter("doctor_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
			if(entity1.getDoctor_id()!=null){
						System.out.println(entity1);
						request.setAttribute("doctor", entity1);
						request.getRequestDispatcher("/jsps/doctor_entity/doctor_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Entity not found");
				request.getRequestDispatcher("/jsps/doctor_entity/doctor_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				doctorDao.delete(Integer.parseInt(request.getParameter("doctor_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Doctor Deleted");
			request.getRequestDispatcher("/jsps/doctor_entity/doctor_read_output.jsp").forward(request, response);
		}
	}
}



