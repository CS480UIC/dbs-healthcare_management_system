package medication.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import medication.dao.MedicationDao;
import medication.domain.Medication;


/**
 * Servlet implementation class UserServlet
 */

public class MedicationServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MedicationServletRead() {
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
		Medication medication = null;
	    MedicationDao medicationDao = new MedicationDao();
		
		try {
			
			medication = medicationDao.findByMID(Integer.parseInt(request.getParameter("medicine_id")));
			
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(medication.getMedicine_id()!=null){
					System.out.println(medication);
					request.setAttribute("medication", medication);
					request.getRequestDispatcher("/jsps/medication_entity/medication_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "Medication not found");
			request.getRequestDispatcher("/jsps/medication_entity/medication_read_output.jsp").forward(request, response);
		}
	}
}



