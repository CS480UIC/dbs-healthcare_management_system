package payment.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import payment.domain.Payment;
import payment.service.PaymentException;
import payment.service.PaymentService;


/**
 * Servlet implementation class UserServlet
 */

public class PaymentServletCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentServletCreate() {
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
		PaymentService paymentservice = new PaymentService();
		Map<String,String[]> paramMap = request.getParameterMap();
		Payment form = new Payment();
		List<String> info = new ArrayList<String>();

		for(String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}
		
	
		
		 
		form.setPayment_id(Integer.parseInt(info.get(0)));
		form.setFirst_name(info.get(1));
		form.setLast_name(info.get(2));	
		form.setType_of_payment(info.get(3));
		form.setDoc_referred(info.get(4));	
			
		form.setDate(java.sql.Date.valueOf(info.get(5)));	
		form.setTreatment(info.get(6));	
		
		form.setPatient_id(Integer.parseInt(info.get(7)));
		
		try {
			paymentservice.create(form);
			response.sendRedirect( request.getContextPath() + "/jsps/main.jsp");
			
		} catch (ClassNotFoundException | PaymentException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		
	}

}
