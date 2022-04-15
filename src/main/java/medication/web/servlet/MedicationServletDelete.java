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

public class MedicationServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MedicationServletDelete() {
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
		MedicationDao medicationDao = new MedicationDao();
		Medication medication = null;
		if(method.equals("search"))
		{
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
						
						request.setAttribute("medication", medication);
						request.getRequestDispatcher("/jsps/medication_entity/medication_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Medication not found");
				request.getRequestDispatcher("/jsps/medication_entity/medication_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				medicationDao.delete(Integer.parseInt(request.getParameter("medicine_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Medication Deleted");
			request.getRequestDispatcher("/jsps/medication_entity/medication_read_output.jsp").forward(request, response);
		}
	}
}



