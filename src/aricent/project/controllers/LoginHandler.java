package aricent.project.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aricent.project.model.businesslogic.Authenticator;
import aricent.project.model.businesslogic.MailingSystem;

/**
 * Servlet implementation class
 */
@WebServlet("/LoginHandler")
public class LoginHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginHandler() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if(action.equals("forgotPassword"))
		{
			String email=request.getParameter("email");
			MailingSystem mailingSystem=new MailingSystem();
			System.out.println("mail Sent");
			//Authenticator authenticator=new Authenticator();
			//String password1=authenticator.fetchPassword();
			//mailingSystem.sendMailViaSSL(email, "Password Indformation", "Your Existing password is "+password);
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/Userform/userHome.jsp");
			requestDispatcher.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type = request.getParameter("type");
		String name = request.getParameter("form-username");
		String password = request.getParameter("form-password");

		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(5 * 60);
		String action = request.getParameter("action");
		if (action.equals("login")) {
			Authenticator authenticator1 = new Authenticator(type, name,
					password);
			Authenticator authenticator = authenticator1.login();

			if (type.equals("A") && authenticator != null) {
				session.setAttribute("type", "A");
				session.setAttribute("Id", authenticator.getId());
				session.setAttribute("name", authenticator.getUserName());
				if (authenticator.getFirstLogin() == 0) {
					RequestDispatcher requestDispatcher = request
							.getRequestDispatcher("changePassword.jsp");
					requestDispatcher.forward(request, response);
				} else {
					RequestDispatcher requestDispatcher = request
							.getRequestDispatcher("/AgentForm/agentHome.jsp");
					requestDispatcher.forward(request, response);
				}
			}
			if (type.equals("A") && authenticator == null) {
				request.setAttribute("LoginStatus", "No Such Agent Found");
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("/AgentForm/agentLogin.jsp");
				requestDispatcher.forward(request, response);
			}
			if (type.equals("P") && authenticator != null) {
				session.setAttribute("type", "P");
				session.setAttribute("Id", authenticator.getId());
				session.setAttribute("name", authenticator.getUserName());
				if (authenticator.getFirstLogin() == 0) {
					RequestDispatcher requestDispatcher = request
							.getRequestDispatcher("changePassword.jsp");
					requestDispatcher.forward(request, response);
				} else {
					RequestDispatcher rd = request
							.getRequestDispatcher("/Userform/userHome.jsp");
					rd.forward(request, response);
				}
			}
			if (type.equals("P") && authenticator == null) {
				request.setAttribute("LoginStatus", "No Such User Found");
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("/Userform/existingUser.jsp");
				requestDispatcher.forward(request, response);
			}
		}

		if (action.equals("changePassword")) {
			String oldPassword = request.getParameter("oldPassword");
			String newPassword = request.getParameter("newPassword");
			int id = (int) session.getAttribute("Id");
			String type1 = (String) session.getAttribute("type");
			System.out.println(type1);
			Authenticator authenticator = new Authenticator(id, type1, "name1");
			authenticator.setPassword(oldPassword);
			int result = authenticator.changePassword(newPassword);
			if (result == 1 && authenticator.getType().equals("P")) {
				RequestDispatcher rd = request
						.getRequestDispatcher("/Userform/userHome.jsp");
				rd.forward(request, response);
			} else if (result == 1 && authenticator.getType().equals("A")) {
				RequestDispatcher rd = request
						.getRequestDispatcher("/AgentForm/agentHome.jsp");
				rd.forward(request, response);
			} else if (result == -1) {
				RequestDispatcher rd = request
						.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
			}
		}
		
		if(action.equals("forgotPassword"))
		{
			String email=request.getParameter("email");
			System.out.println("Mail Sent");

			//MailingSystem mailingSystem=new MailingSystem();
			//Authenticator authenticator=new Authenticator();
			//String password1=authenticator.fetchPassword();
			//mailingSystem.sendMailViaSSL(email, "Password Information", "Your Existing password is "+password);
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/home.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}
