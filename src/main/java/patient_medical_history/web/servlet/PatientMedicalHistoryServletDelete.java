package patient_medical_history.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import patient_medical_history.dao.PatientMedicalHistoryDao;
import patient_medical_history.domain.PatientMedicalHistory;


/**
 * Servlet implementation class UserServlet
 */

public class PatientMedicalHistoryServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientMedicalHistoryServletDelete() {
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
		PatientMedicalHistoryDao patient_medical_historyDao = new PatientMedicalHistoryDao();
		PatientMedicalHistory patient_medical_history = null;
		if(method.equals("search"))
		{
			try {
				patient_medical_history = patient_medical_historyDao.findByMID(Integer.parseInt(request.getParameter("history_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
			if(patient_medical_history.getHistory_id()!=null){
						
						request.setAttribute("patient_medical_history", patient_medical_history);
						request.getRequestDispatcher("/jsps/patient_medical_history_entity/patient_medical_history_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "PatientMedicalHistory not found");
				request.getRequestDispatcher("/jsps/patient_medical_history_entity/patient_medical_history_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				patient_medical_historyDao.delete(Integer.parseInt(request.getParameter("history_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "PatientMedicalHistory Deleted");
			request.getRequestDispatcher("/jsps/patient_medical_history_entity/patient_medical_history_read_output.jsp").forward(request, response);
		}
	}
}



