package payment.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import payment.dao.PaymentDao;
import payment.domain.Payment;


/**
 * Servlet implementation class UserServlet
 */

public class PaymentServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentServletDelete() {
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
		PaymentDao paymentDao = new PaymentDao();
		Payment payment = null;
		if(method.equals("search"))
		{
			try {
				payment = paymentDao.findByPID(Integer.parseInt(request.getParameter("payment_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
			if(payment.getPayment_id()!=null){
						System.out.println(payment);
						request.setAttribute("payment", payment);
						request.getRequestDispatcher("/jsps/payment_entity/payment_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Payment not found");
				request.getRequestDispatcher("/jsps/payment_entity/payment_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				paymentDao.delete(Integer.parseInt(request.getParameter("payment_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Payment Deleted");
			request.getRequestDispatcher("/jsps/payment_entity/payment_read_output.jsp").forward(request, response);
		}
	}
}



