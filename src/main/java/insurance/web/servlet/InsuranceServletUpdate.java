package insurance.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import insurance.dao.InsuranceDao;
import insurance.domain.Insurance;

/**
 * Servlet implementation class UserServlet
 */

public class InsuranceServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsuranceServletUpdate() {
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
		InsuranceDao insurancedao = new InsuranceDao();
		Insurance insurance = null;

		if(method.equals("search"))
		{
			try {
				insurance = insurancedao.findByMID(Integer.parseInt(request.getParameter("insurance_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(insurance.getInsurance_id()!=null){
				request.setAttribute("insurance", insurance);
				request.getRequestDispatcher("/jsps/insurance_entity/insurance_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Payment not found");
				request.getRequestDispatcher("/jsps/insurance_entity/insurance_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Insurance form = new Insurance();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			System.out.print(info);
			
			form.setInsurance_id(Integer.parseInt(info.get(1)));
			form.setInsurance_company(info.get(2));
			form.setStart_date(java.sql.Date.valueOf(info.get(3)));
			form.setEnd_date(java.sql.Date.valueOf(info.get(4)));
			form.setInsurance_plan(info.get(5));	
			form.setPatient_id(Integer.parseInt(info.get(6)));

			try {
				insurancedao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Insurance Updated");
			request.getRequestDispatcher("/jsps/insurance_entity/insurance_read_output.jsp").forward(request, response);
		}
	}
}



