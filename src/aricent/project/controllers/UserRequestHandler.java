package aricent.project.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aricent.project.model.businesslogic.UserServices;
import aricent.project.model.modelclasses.Agent;
import aricent.project.model.modelclasses.PolicyHolder;

/**
 * Servlet implementation class UserRequestHandler
 */
@WebServlet("/UserRequestHandler")
public class UserRequestHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserRequestHandler() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/*if(request.getSession().getAttribute("Id").equals("null"))
		{
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/error/sessionExpired.jsp");
			requestDispatcher.forward(request, response);
		}*/
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		System.out.println(request.getSession().getAttribute("Id"));
		System.out.println(action);
		HttpSession session = request.getSession();
		// if(action.equals("Payment"))
		// {

		// }
		if (action.equals("viewPolicy")) {
			List<List<Object>> list = new ArrayList<List<Object>>();
			UserServices userSerices = new UserServices();
			int Id = (int) session.getAttribute("Id");
			list = userSerices.viewPolicyStatus(Id);
			request.setAttribute("policystaus", list);
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/Userform/userPolicyStatus.jsp");
			requestDispatcher.forward(request, response);

		}

		if (action.equals("viewPolicyMatured")) {
			UserServices userServices = new UserServices();
			int Id = (int) session.getAttribute("Id");
			List<List<Object>> list = userServices.viewPolicyMatured(Id);
			request.setAttribute("UserMaturedList", list);
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/Userform/userPolicyMatured.jsp");
			requestDispatcher.forward(request, response);
		}
		if (action.equals("changeMode1")) {
			UserServices userServices = new UserServices();
			int Id = (int) session.getAttribute("Id");
			List<List<Object>> list = userServices.selectPolicyMode(Id);
			request.setAttribute("SelectMode", list);
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/Userform/selectPolicy.jsp");
			requestDispatcher.forward(request, response);

		}

		if (action.equals("changeMode2")) {
			String values = request.getParameter("values");
			System.out.println(values);
			String val[] = values.split("-");
			String policyMode = request.getParameter("policyMode");

			UserServices userServices = new UserServices();
			int result = userServices.changePolicyMode(
					Integer.parseInt(val[0]), Integer.parseInt(policyMode));
			if (result == 1) {
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("/Userform/userHome.jsp");
				requestDispatcher.forward(request, response);
			} else {
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("logout.jsp");
				requestDispatcher.forward(request, response);
			}

		}

		if (action.equals("viewAgent")) {
			UserServices userServices = new UserServices();
			int Id = (int) session.getAttribute("Id");
			List<Agent> list = userServices.viewAgents(Id);
			request.setAttribute("viewAgents", list);
			RequestDispatcher R = request
					.getRequestDispatcher("/Userform/userAgentDetail.jsp");
			R.forward(request, response);
		}

		if (action.equals("viewPayStatement")) {
			List<List<Object>> list = new ArrayList<List<Object>>();
			UserServices userServices = new UserServices();
			int Id = (int) session.getAttribute("Id");
			list = userServices.viewPaymentDetails(Id);
			request.setAttribute("list", list);
			RequestDispatcher R = request
					.getRequestDispatcher("/Userform/userPaymentsDetail.jsp");
			R.forward(request, response);
		}

		if (action.equals("payment1")) {
			UserServices user = new UserServices();
			int Id = (int) session.getAttribute("Id");
			List<List<Object>> list = user.calculatePayment(Id);
			request.setAttribute("selectPolicy", list);
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/Userform/calculatePayment.jsp");
			requestDispatcher.forward(request, response);

		}

		if (action.equals("payment2")) {
			String TransId = request.getParameter("TransactId");
			String Amount = request.getParameter("payAmount");
			int transId = (int) Double.parseDouble(TransId);
			int amount = (int) Double.parseDouble(Amount);
			UserServices userServices = new UserServices();
			userServices.updatePayments(transId, amount);
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/Userform/userHome.jsp");
			requestDispatcher.forward(request, response);
		}

		if (action.equals("updateDetails")) {
			UserServices userServices = new UserServices();
			// int Id=(int)session.getAttribute("Id");
			// List<Object> list=userServices.updateDetails(Id);
			// PolicyHolder policyHolder=(PolicyHolder)list.get(0);
			// request.setAttribute("Details", policyHolder);
			RequestDispatcher R = request
					.getRequestDispatcher("/Userform/userDetail.jsp");
			R.forward(request, response);
		}

		if (action.equals("viewDetails")) {
			UserServices userServices = new UserServices();
			int Id = (int) session.getAttribute("Id");
			List<Object> list = userServices.viewDetails(Id);
			request.setAttribute("Details", list);
			RequestDispatcher R = request
					.getRequestDispatcher("/Userform/userDetails.jsp");
			R.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*if(request.getSession().getAttribute("Id")==null)
		{
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/error/sessionExpired.jsp");
			requestDispatcher.forward(request, response);
		}*/
		String action = request.getParameter("action");
		System.out.println(action);
		HttpSession session = request.getSession();
		// if(action.equals("Payment"))
		// {

		// }
		if (action.equals("viewPolicy")) {
			List<List<Object>> list = new ArrayList<List<Object>>();
			UserServices userSerices = new UserServices();
			int Id = (int) session.getAttribute("Id");
			list = userSerices.viewPolicyStatus(Id);
			request.setAttribute("policystaus", list);
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/Userform/userPolicyStatus.jsp");
			requestDispatcher.forward(request, response);

		}

		if (action.equals("viewPolicyMatured")) {
			UserServices userServices = new UserServices();
			int Id = (int) session.getAttribute("Id");
			List<List<Object>> list = userServices.viewPolicyMatured(Id);
			request.setAttribute("UserMaturedList", list);
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/Userform/userPolicyMatured.jsp");
			requestDispatcher.forward(request, response);
		}
		if (action.equals("changeMode1")) {
			UserServices userServices = new UserServices();
			int Id = (int) session.getAttribute("Id");
			List<List<Object>> list = userServices.selectPolicyMode(Id);
			request.setAttribute("SelectMode", list);
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/Userform/selectPolicy.jsp");
			requestDispatcher.forward(request, response);

		}

		if (action.equals("changemode2")) {
			System.out.println("bu");
			String values = request.getParameter("values");
			System.out.println(values);
			String val[] = values.split("-");
			String policyMode = request.getParameter("policyMode");

			UserServices userServices = new UserServices();
			System.out.println("hi");
			int result = userServices.changePolicyMode(
					Integer.parseInt(val[0]), Integer.parseInt(policyMode));
			System.out.println("hiiii");
			if (result == 1) {
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("/Userform/userHome.jsp");
				requestDispatcher.forward(request, response);
			} else {
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("logout.jsp");
				requestDispatcher.forward(request, response);
			}

		}

		if (action.equals("viewAgent")) {
			UserServices userServices = new UserServices();
			int Id = (int) session.getAttribute("Id");
			List<Agent> list = userServices.viewAgents(Id);
			request.setAttribute("viewAgents", list);
			RequestDispatcher R = request
					.getRequestDispatcher("/Userform/userAgentDetail.jsp");
			R.forward(request, response);
		}

		if (action.equals("viewPayStatement")) {
			List<List<Object>> list = new ArrayList<List<Object>>();
			UserServices userServices = new UserServices();
			int Id = (int) session.getAttribute("Id");
			list = userServices.viewPaymentDetails(Id);
			request.setAttribute("list", list);
			RequestDispatcher R = request
					.getRequestDispatcher("/Userform/userPaymentsDetail.jsp");
			R.forward(request, response);
		}

		if (action.equals("payment1")) {
			UserServices user = new UserServices();
			int Id = (int) session.getAttribute("Id");
			List<List<Object>> list = user.calculatePayment(Id);
			request.setAttribute("selectPolicy", list);
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/Userform/calculatePayment.jsp");
			requestDispatcher.forward(request, response);

		}

		if (action.equals("payment2")) {
			String TransId = request.getParameter("TransactId");
			String Amount = request.getParameter("payAmount");
			int transId = (int) Double.parseDouble(TransId);
			int amount = (int) Double.parseDouble(Amount);
			UserServices userServices = new UserServices();
			userServices.updatePayments(transId, amount);
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/Userform/userHome.jsp");
			requestDispatcher.forward(request, response);
		}

		if (action.equals("updateDetails")) {
			String name = request.getParameter("name");
			int Id = (int) session.getAttribute("Id");

			String number = request.getParameter("number");
			String address = request.getParameter("address");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String Zip = request.getParameter("zip");

			UserServices userServices = new UserServices();
			int result = userServices.updateDetails(Id, name, number, address,
					city, state, Zip);
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/UserRequestHandler?action=viewDetails");
			requestDispatcher.forward(request, response);

		}

		if (action.equals("viewDetails")) {
			UserServices userServices = new UserServices();
			int Id = (int) session.getAttribute("Id");
			List<Object> list = userServices.viewDetails(Id);
			request.setAttribute("Details", list);
			RequestDispatcher R = request
					.getRequestDispatcher("/Userform/userDetails.jsp");
			R.forward(request, response);
		}

	}

}
