package patient_medical_history_surgeries.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import patient_medical_history_surgeries.dao.Patient_medical_history_surgeriesDao;
import patient_medical_history_surgeries.domain.Patient_medical_history_surgeries;


/**
 * Servlet implementation class UserServlet
 */

public class Patient_medical_history_surgeriesServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Patient_medical_history_surgeriesServletDelete() {
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
		Patient_medical_history_surgeriesDao patient_medical_history_surgeriesDao = new Patient_medical_history_surgeriesDao();
		Patient_medical_history_surgeries patient_medical_history_surgeries = null;
		if(method.equals("search"))
		{
			try {
				patient_medical_history_surgeries = patient_medical_history_surgeriesDao.findByMID(Integer.parseInt(request.getParameter("history_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
			if(patient_medical_history_surgeries.getHistory_id()!=null){
						
						request.setAttribute("patient_medical_history_surgeries", patient_medical_history_surgeries);
						request.getRequestDispatcher("/jsps/patient_medical_history_surgeries_entity/patient_medical_history_surgeries_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Patient_medical_history_surgeries not found");
				request.getRequestDispatcher("/jsps/patient_medical_history_surgeries_entity/patient_medical_history_surgeries_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				patient_medical_history_surgeriesDao.delete(Integer.parseInt(request.getParameter("history_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Patient_medical_history_surgeries Deleted");
			request.getRequestDispatcher("/jsps/patient_medical_history_surgeries_entity/patient_medical_history_surgeries_read_output.jsp").forward(request, response);
		}
	}
}



