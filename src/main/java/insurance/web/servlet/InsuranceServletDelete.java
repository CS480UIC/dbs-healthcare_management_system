package insurance.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import insurance.dao.InsuranceDao;
import insurance.domain.Insurance;


/**
 * Servlet implementation class UserServlet
 */

public class InsuranceServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsuranceServletDelete() {
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
		InsuranceDao insuranceDao = new InsuranceDao();
		Insurance insurance = null;
		if(method.equals("search"))
		{
			try {
				insurance = insuranceDao.findByMID(Integer.parseInt(request.getParameter("insurance_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
			if(insurance.getInsurance_id()!=null){
						
						request.setAttribute("insurance", insurance);
						request.getRequestDispatcher("/jsps/insurance_entity/insurance_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Insurance not found");
				request.getRequestDispatcher("/jsps/insurance_entity/insurance_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				insuranceDao.delete(Integer.parseInt(request.getParameter("insurance_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Insurance Deleted");
			request.getRequestDispatcher("/jsps/insurance_entity/insurance_read_output.jsp").forward(request, response);
		}
	}
}



