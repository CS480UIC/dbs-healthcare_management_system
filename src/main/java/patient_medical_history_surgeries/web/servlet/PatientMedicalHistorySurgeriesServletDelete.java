package patient_medical_history_surgeries.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import patient_medical_history_surgeries.dao.PatientMedicalHistorySurgeriesDao;
import patient_medical_history_surgeries.domain.PatientMedicalHistorySurgeries;


/**
 * Servlet implementation class UserServlet
 */

public class PatientMedicalHistorySurgeriesServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientMedicalHistorySurgeriesServletDelete() {
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
		PatientMedicalHistorySurgeriesDao patient_medical_history_surgeriesDao = new PatientMedicalHistorySurgeriesDao();
		PatientMedicalHistorySurgeries patient_medical_history_surgeries = null;
		if(method.equals("search"))
		{
			try {
				patient_medical_history_surgeries = patient_medical_history_surgeriesDao.findByMID(Integer.parseInt(request.getParameter("history_id")), (request.getParameter("surgeries")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
			if(patient_medical_history_surgeries.getHistory_id()!=null && patient_medical_history_surgeries.getSurgeries()!=null){
						
						request.setAttribute("patient_medical_history_surgeries", patient_medical_history_surgeries);
						request.getRequestDispatcher("/jsps/patient_medical_history_surgeries_entity/patient_medical_history_surgeries_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "PatientMedicalHistorySurgeries not found");
				request.getRequestDispatcher("/jsps/patient_medical_history_surgeries_entity/patient_medical_history_surgeries_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				patient_medical_history_surgeriesDao.delete(Integer.parseInt(request.getParameter("history_id")), (request.getParameter("surgeries")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "PatientMedicalHistorySurgeries Deleted");
			request.getRequestDispatcher("/jsps/patient_medical_history_surgeries_entity/patient_medical_history_surgeries_read_output.jsp").forward(request, response);
		}
	}
}



