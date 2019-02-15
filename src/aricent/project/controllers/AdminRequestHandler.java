/***********************************************************************
                         Aricent Technologies Proprietary
 
This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies
 
           File Name                    :AdminServices.java
           Principal Author             : Java_Th3_06
           Subsystem Name               :Project
           Module Name                  :Admin Module
           Date of First Release        :20/01/2016
           Author                       :  Java_TH3_06
           Description                  :This class contains the method to act as a controller for handling request of the Admin
 
 
           Change History
 
           Version                       : Initial Release
           Date(DD/MM/YYYY)              :14/02/2016
           Modified by                   :Java_TH3_06
           Description of change         : Initial Release
 
***********************************************************************/
package aricent.project.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aricent.project.model.businesslogic.AdminServices;
import aricent.project.model.businesslogic.AgentServices;
import aricent.project.model.modelclasses.Admin;
import aricent.project.model.modelclasses.Agent;
import aricent.project.model.modelclasses.PolicyHolder;
import aricent.project.model.modelclasses.PolicySold;

/**
 *	Description :This class consists of block of code which
           redirect the request of the model classess to the appropriate business Login class
 *  
 *	@see AdminServices
 *  @see doGet
 *  @see doPost
 *	@version text
 *	@author Java_TH3__06
 *  @since
 */
@WebServlet("/AdminRequestHandler")
public class AdminRequestHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 *	Description constructor of the AdminRequestHandler 
	 *  @exception HbernateException
	 *  @see AdminRequestHandler
	 *	@version text
	 *	@author JAVA-th3_06
	 *  @since
**/
	public AdminRequestHandler() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 *	Description method to handle all the get request of Admin
	 *@param HttpServletRequest request,
			HttpServletResponse response
	 *  @see doGet
	 *	@version text
	 *	@author JAVA-th3_06
	 *  @since
**/
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if (action.equals("viewAgentDetails")) {
			AdminServices admin = new AdminServices();
			List<Agent> L = admin.viewAgentDetails();
			request.setAttribute("viewAgent", L);
			RequestDispatcher R = request
					.getRequestDispatcher("Admin/viewAgentDetails.jsp");
			R.forward(request, response);
		}
		if (action.equals("viewPaymentDetails")) {
			AdminServices admin = new AdminServices();
			List<List<Object>> L = admin.viewPaymentDetails();
			request.setAttribute("viewPayment", L);
			RequestDispatcher R = request
					.getRequestDispatcher("Admin/viewPaymentDetails.jsp");
			R.forward(request, response);
		}
		if (action.equals("viewPolicyHolderDetails")) {
			AdminServices admin = new AdminServices();
			List<PolicyHolder> L = admin.viewPolicyHolderDetails();
			request.setAttribute("viewPolicyHolder", L);
			RequestDispatcher R = request
					.getRequestDispatcher("Admin/viewPolicyHolderDetails.jsp");
			R.forward(request, response);
		}
		if (action.equals("viewPolicySoldDetails")) {
			AdminServices admin = new AdminServices();
			List<PolicySold> L = admin.viewPolicySoldDetails();
			request.setAttribute("viewPolicySold", L);
			RequestDispatcher R = request
					.getRequestDispatcher("Admin/viewPolicySoldDetails.jsp");
			R.forward(request, response);
		}
		if (action.equals("addNewAgent")) {
			AdminServices adminServices = new AdminServices();
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String fullname = fname + " " + lname;
			String address = request.getParameter("address");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String zip = request.getParameter("zip");

			String add = address + "@" + state + "@" + zip;
			String dob = request.getParameter("dob");
			String fathername = request.getParameter("fathername");
			String email = request.getParameter("email");
			long phone = Long.parseLong(request.getParameter("phone"));

			String d[] = dob.split("/");
			String date = d[2] + "-" + d[1] + "-" + d[0];
			System.out.println(date);
			System.out.println(fullname);
			int result = adminServices.addNewAgent(fullname, fathername, phone,
					email, date, add, city);
			if (result == -1) {

				request.setAttribute("ture",
						"Agent Already Exists with this email, add with unique email");
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("Admin/addAgent.jsp");
				requestDispatcher.forward(request, response);

			}
			if (result == 1) {
				request.setAttribute("ture", "Agent added successfully");
				RequestDispatcher r = request
						.getRequestDispatcher("Admin/adminHome.jsp");
				r.forward(request, response);
			}

		}
		if (action.equals("addNewPolicy")) {
			AdminServices A = new AdminServices();
			String policyName = request.getParameter("Pname");
			String policyType = request.getParameter("Ptype");
			int duration = Integer.valueOf(request.getParameter("Duration"));
			int commission = Integer.valueOf(request.getParameter("Comm"));
			double totalAmount = Double
					.valueOf(request.getParameter("Tamount"));
			System.out.println(policyName + commission + duration);
			int i = A.addNewPolicy(policyName, policyType, duration,
					commission, totalAmount);
			if (i == -1) {

				request.setAttribute("true", "Policy already exists");
				RequestDispatcher r = request
						.getRequestDispatcher("Admin/addPolicy.jsp");
				r.forward(request, response);

			}
			if (i == 1) {
				request.setAttribute("true", "Policy added successfully");
				RequestDispatcher r = request
						.getRequestDispatcher("Admin/adminHome.jsp");
				r.forward(request, response);
			}
		}

		if (action.equals("adminLogin")) {
			AdminServices adminServices = new AdminServices();
			String userName = request.getParameter("form-username");
			String password = request.getParameter("form-password");
			System.out.println(userName);
			System.out.println(password);
			Admin result = adminServices.adminLogin(userName, password);
			System.out.println(result.getUserName());
			if (result == null) {
				request.setAttribute("message", "No Such Admin Exist");
				System.out.println("till here");
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("Admin/adminLogin.jsp");
				requestDispatcher.forward(request, response);
			}
			if (result != null) {
				HttpSession session = request.getSession();
				session.setAttribute("type", "Admin");
				session.setAttribute("Id", result.getAdminId());
				session.setAttribute("name", result.getUserName());
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("Admin/adminHome.jsp");
				requestDispatcher.forward(request, response);
			}
		}

	}

	/**
	 *	Description method to handle all the post request of Admin 
	 *@param HttpServletRequest request,
			HttpServletResponse response
	 *  @see doGet
	 *	@version text
	 *	@author JAVA-th3_06
	 *  @since
**/
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if (action.equals("viewAgentDetails")) {
			AdminServices admin = new AdminServices();
			List<Agent> L = admin.viewAgentDetails();
			request.setAttribute("viewAgent", L);
			RequestDispatcher R = request
					.getRequestDispatcher("Admin/viewAgentDetails.jsp");
			R.forward(request, response);
		}
		if (action.equals("viewPaymentDetails")) {
			AdminServices admin = new AdminServices();
			List<List<Object>> L = admin.viewPaymentDetails();
			request.setAttribute("viewPayment", L);
			RequestDispatcher R = request
					.getRequestDispatcher("Admin/viewPaymentDetails.jsp");
			R.forward(request, response);
		}
		if (action.equals("viewPolicyHolderDetails")) {
			AdminServices admin = new AdminServices();
			List<PolicyHolder> L = admin.viewPolicyHolderDetails();
			request.setAttribute("viewPolicyHolder", L);
			RequestDispatcher R = request
					.getRequestDispatcher("Admin/viewPolicyHolderDetails.jsp");
			R.forward(request, response);
		}
		if (action.equals("viewPolicySoldDetails")) {
			AdminServices admin = new AdminServices();
			List<PolicySold> L = admin.viewPolicySoldDetails();
			request.setAttribute("viewPolicySold", L);
			RequestDispatcher R = request
					.getRequestDispatcher("Admin/viewPolicySoldDetails.jsp");
			R.forward(request, response);
		}
		if (action.equals("addNewAgent")) {
			AdminServices adminServices = new AdminServices();
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String fullname = fname + " " + lname;
			String address = request.getParameter("address");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String zip = request.getParameter("zip");

			String add = address + "@" + state + "@" + zip;
			String dob = request.getParameter("dob");
			String fathername = request.getParameter("fathername");
			String email = request.getParameter("email");
			long phone = Long.parseLong(request.getParameter("phone"));

			String d[] = dob.split("/");
			String date = d[2] + "-" + d[1] + "-" + d[0];
			System.out.println(date);
			System.out.println(fullname);
			int result = adminServices.addNewAgent(fullname, fathername, phone,
					email, date, add, city);
			if (result == -1) {

				request.setAttribute("ture",
						"Agent Already Exists with this email, add with unique email");
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("Admin/addAgent.jsp");
				requestDispatcher.forward(request, response);

			}
			if (result == 1) {
				request.setAttribute("ture", "Agent added successfully");
				RequestDispatcher r = request
						.getRequestDispatcher("Admin/adminHome.jsp");
				r.forward(request, response);
			}

		}
		if (action.equals("addNewPolicy")) {
			AdminServices A = new AdminServices();
			String policyName = request.getParameter("pname");
			String policyType = request.getParameter("ptype");
			int duration = Integer.valueOf(request.getParameter("Duration"));
			int commission = Integer.valueOf(request.getParameter("Comm"));
			double totalAmount = Double
					.valueOf(request.getParameter("Tamount"));
			System.out.println(policyName + commission + duration);
			int i = A.addNewPolicy(policyName, policyType, duration,
					commission, totalAmount);
			if (i == -1) {

				request.setAttribute("true", "Policy already exists");
				RequestDispatcher r = request
						.getRequestDispatcher("Admin/addPolicy.jsp");
				r.forward(request, response);

			}
			if (i == 1) {
				request.setAttribute("true", "Policy added successfully");
				RequestDispatcher r = request
						.getRequestDispatcher("Admin/adminHome.jsp");
				r.forward(request, response);
			}
		}

		if (action.equals("adminLogin")) {
			AdminServices adminServices = new AdminServices();
			String userName = request.getParameter("form-username");
			String password = request.getParameter("form-password");
			System.out.println(userName);
			System.out.println(password);
			Admin result = adminServices.adminLogin(userName, password);
			System.out.println(result.getUserName());
			if (result == null) {
				request.setAttribute("message", "No Such Admin Exist");
				System.out.println("till here");
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("Admin/adminLogin.jsp");
				requestDispatcher.forward(request, response);
			}
			if (result != null) {
				HttpSession session = request.getSession();
				session.setAttribute("type", "Admin");
				session.setAttribute("Id", result.getAdminId());
				session.setAttribute("name", result.getUserName());
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("Admin/adminHome.jsp");
				requestDispatcher.forward(request, response);
			}
		}

	}

}
