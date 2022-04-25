package payment.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import payment.service.PaymentService;

/**
 * Servlet implementation class findAll
 */

public class findTotalPayments extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PaymentService medicationservice = new PaymentService();
		try {
			request.setAttribute("TotalPrice", medicationservice.findTotalPayments());
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			List<Object> li = medicationservice.findTotalPayments();
			for(int i = 0; i < li.size();i++){
				if(li.get(i)!= null){
				System.out.println(li.get(i).toString());
				}
			}
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		request.getRequestDispatcher("/jsps/payment_entity/q9_list_totalpayments.jsp").forward(request, response);
	}

}
