package hospital.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hospital.service.HospitalService;

/**
 * Servlet implementation class findAll
 */

public class findTotalCount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HospitalService hospitalservice = new HospitalService();
		try {
			request.setAttribute("TotalCount", hospitalservice.findTotalCount());
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			List<Object> li = hospitalservice.findTotalCount();
			for(int i = 0; i < li.size();i++){
				if(li.get(i)!= null){
				System.out.println(li.get(i).toString());
				}
			}
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		request.getRequestDispatcher("/jsps/hospital_entity/q9_list_totalcount.jsp").forward(request, response);
	}

}
