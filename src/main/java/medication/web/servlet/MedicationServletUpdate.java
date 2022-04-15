package medication.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import medication.dao.MedicationDao;
import medication.domain.Medication;

/**
 * Servlet implementation class UserServlet
 */

public class MedicationServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MedicationServletUpdate() {
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
		MedicationDao medicationdao = new MedicationDao();
		Medication medication = null;

		if(method.equals("search"))
		{
			try {
				medication = medicationdao.findByMID(Integer.parseInt(request.getParameter("medicine_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(medication.getMedicine_id()!=null){
				request.setAttribute("medication", medication);
				request.getRequestDispatcher("/jsps/medication_entity/medication_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Payment not found");
				request.getRequestDispatcher("/jsps/medication_entity/medication_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Medication form = new Medication();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			System.out.print(info);
			
			form.setMedicine_id(Integer.parseInt(info.get(1)));
			form.setMedicine_name(info.get(2));
			form.setPrice(Integer.parseInt(info.get(3)));	
			form.setMfg_date(java.sql.Date.valueOf(info.get(4)));
			form.setExp_date(java.sql.Date.valueOf(info.get(5)));
			
			form.setMfg_company(info.get(6));	
				
			
			form.setDoctor_id(Integer.parseInt(info.get(7)));	
			
			form.setPatient_id(Integer.parseInt(info.get(8)));

			try {
				medicationdao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Medication Updated");
			request.getRequestDispatcher("/jsps/medication_entity/medicine_read_output.jsp").forward(request, response);
		}
	}
}



