package insurance.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import insurance.service.InsuranceService;

/**
 * Servlet implementation class findAll
 */

public class findInsurance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InsuranceService doctorservice = new InsuranceService();
		try {
			request.setAttribute("InsuranceList", doctorservice.findallP());
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			List<Object> li = doctorservice.findallP();
			for(int i = 0; i < li.size();i++){
				System.out.println(li.get(i).toString());
			}

		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}


		request.getRequestDispatcher("/jsps/insurance_entity/q8_list_insurance.jsp").forward(request, response);
	}

}
