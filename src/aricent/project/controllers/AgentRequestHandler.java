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
           Description                  :This class contains the method to act as a controller for handling request of the Agent
 
 
           Change History
 
           Version                       : Initial Release
           Date(DD/MM/YYYY)              :14/02/2016
           Modified by                   :Java_TH3_06
           Description of change         : Initial Release
 
***********************************************************************/
package aricent.project.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aricent.project.model.businesslogic.AgentServices;
import aricent.project.model.modelclasses.Policy;
import aricent.project.model.modelclasses.PolicyHolder;

/**
 * 
 *	Description about the class.
 *  
 *	@see doGet 
 *	@see doPost
 *	@version text
 *	@author java_TH3_06
 *
 */
@WebServlet("/AgentRequestHandler")
public class AgentRequestHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public AgentRequestHandler() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
		/*if(request.getSession().getAttribute("Id")==null)
		{
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/error/sessionExpired.jsp");
			requestDispatcher.forward(request, response);
		}*/
		String action = request.getParameter("action");
		if (action.equals("updatePersonelDetails")) {
			String name = request.getParameter("name");
			String number = request.getParameter("number");
			String address = request.getParameter("address");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String zip = request.getParameter("zip");
			HttpSession session = request.getSession();
			int Id = (int) session.getAttribute("Id");
			AgentServices agentServices = new AgentServices();
			int result = agentServices.updateDetails(Id, name, number, address,
					city, state, zip);

			if (result == 1) {
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("/AgentForm/agentHome.jsp");
				requestDispatcher.forward(request, response);
			} else {
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("logout.jsp");
				requestDispatcher.forward(request, response);

			}

		}
		if (action.equals("viewPersonelDetail")) {
			AgentServices agentServices = new AgentServices();
			List<Object> list = new ArrayList<Object>();
			HttpSession session = request.getSession();
			int Id = (int) session.getAttribute("Id");
			list = agentServices.viewDetails(Id);
			request.setAttribute("details", list);
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/AgentForm/updateDetails.jsp");
			requestDispatcher.forward(request, response);
		}

		if (action.equals("fetchPolicyToAddUser")) {
			AgentServices agentServices = new AgentServices();
			List<Policy> list = new ArrayList<Policy>();
			list = agentServices.viewPolicy();
			request.setAttribute("PolicyDetails", list);
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/AgentForm/addUser.jsp");
			requestDispatcher.forward(request, response);
		}
		if (action.equals("viewPolicyHolder")) {
			AgentServices agentServices = new AgentServices();
			HttpSession session = request.getSession();
			int Id = (int) session.getAttribute("Id");
			List<PolicyHolder> list = agentServices.viewPolicyHoders(Id);
			request.setAttribute("users", list);
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/AgentForm/userDetails.jsp");
			requestDispatcher.forward(request, response);
		}
		if (action.equals("viewPolicySold")) {

			AgentServices agentServies = new AgentServices();
			HttpSession session = request.getSession();
			int Id = (int) session.getAttribute("Id");
			List<List<Object>> list = agentServies.viewPolicySold(Id);
			request.setAttribute("viewPolicyDetails", list);
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/AgentForm/viewPolicySold.jsp");
			requestDispatcher.forward(request, response);
		}
		if (action.equals("viewMaturedPolicy")) {
			AgentServices agentServies = new AgentServices();
			HttpSession session = request.getSession();
			int Id = (int) session.getAttribute("Id");
			List<List<Object>> list = agentServies.viewPolicyMatured(Id);
			request.setAttribute("AgentMaturedList", list);
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/AgentForm/viewMaturedPolicy.jsp");
			requestDispatcher.forward(request, response);
		}
		if (action.equals("viewCommission")) {
			AgentServices A = new AgentServices();
			HttpSession session = request.getSession();
			int Id = (int) session.getAttribute("Id");
			List<List<Object>> list = A.viewCommission(Id);
			request.setAttribute("CommissionList", list);

			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/AgentForm/commission.jsp");
			requestDispatcher.forward(request, response);
		}

		if (action.equals("addPolicyHolder")) {
			try {
				HttpSession session = request.getSession();
				int agentId = (int) session.getAttribute("Id");
				String firstname = request.getParameter("firstname");
				String lastname = request.getParameter("lastname");
				String address = request.getParameter("address");
				String city = request.getParameter("city");
				String state = request.getParameter("state");
				String zip = request.getParameter("zip");
				String fatherName = request.getParameter("fathersname");
				String phone = request.getParameter("phonenumber");
				long phonenumber = Long.valueOf(phone);
				String email = request.getParameter("email");
				String dob = request.getParameter("dob");
				int payMode = Integer.parseInt(request.getParameter("payMode"));
				int policyId = Integer.parseInt(request
						.getParameter("policyId"));
				String s[];
				s = dob.split("/");
				Date date = Date.valueOf(s[2] + "-" + s[1] + "-" + s[0]);
				String name = firstname + " " + lastname;
				AgentServices agentServices = new AgentServices();
				System.out.println("00jjj");
				PolicyHolder result = agentServices
						.checkUserAvailability(email);
				if (result == null) {

					agentServices.addNewPolicyHolder(agentId, name, state, zip,
							payMode, policyId, fatherName, phonenumber, email,
							date, address, city);
					request.setAttribute("Message",
							"Policy Holder Successfully added");
					RequestDispatcher requestDispatcher = request
							.getRequestDispatcher("/AgentForm/agentHome.jsp");
					requestDispatcher.forward(request, response);
				}
				if (result != null) {
					request.setAttribute("policyHolder", result);
					RequestDispatcher rd = request
							.getRequestDispatcher("/AgentForm/confirmUser.jsp");
					rd.forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (action.equals("addPolicyHolder1")) {
			AgentServices agentServices = new AgentServices();
			if (request.getParameter("decision").equals("yes")) {
				int userId = Integer.parseInt(request
						.getParameter("policyHolder"));
				int policyId = Integer.parseInt(request
						.getParameter("policyId"));
				HttpSession session = request.getSession();
				int agentId = (int) session.getAttribute("Id");
				int payMode = Integer.parseInt(request.getParameter("payMode"));
				int result = agentServices.addPolicySold(userId, policyId,
						payMode, agentId);
				System.out.println(result);
				if (result == 1) {
					RequestDispatcher requestDispatcher = request
							.getRequestDispatcher("/AgentForm/agentHome.jsp");
					requestDispatcher.forward(request, response);
				}
			}
			if (request.getParameter("decision").equals("no")) {
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("/AgentForm/addUser.jsp");
				requestDispatcher.forward(request, response);
			}
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
		if (action.equals("updatePersonelDetails")) {
			String name = request.getParameter("name");
			String number = request.getParameter("number");
			String address = request.getParameter("address");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String zip = request.getParameter("zip");
			HttpSession session = request.getSession();
			int Id = (int) session.getAttribute("Id");
			AgentServices agentServices = new AgentServices();
			int result = agentServices.updateDetails(Id, name, number, address,
					city, state, zip);

			if (result == 1) {
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("/AgentForm/agentHome.jsp");
				requestDispatcher.forward(request, response);
			} else {
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("logout.jsp");
				requestDispatcher.forward(request, response);

			}

		}
		if (action.equals("viewPersonelDetail")) {
			AgentServices agentServices = new AgentServices();
			List<Object> list = new ArrayList<Object>();
			HttpSession session = request.getSession();
			int Id = (int) session.getAttribute("Id");
			list = agentServices.viewDetails(Id);
			request.setAttribute("details", list);
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/AgentForm/updateDetails.jsp");
			requestDispatcher.forward(request, response);
		}

		if (action.equals("fetchPolicyToAddUser")) {
			AgentServices agentServices = new AgentServices();
			List<Policy> list = new ArrayList<Policy>();
			list = agentServices.viewPolicy();
			request.setAttribute("PolicyDetails", list);
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/AgentForm/addUser.jsp");
			requestDispatcher.forward(request, response);
		}
		if (action.equals("viewPolicyHolder")) {
			AgentServices agentServices = new AgentServices();
			HttpSession session = request.getSession();
			int Id = (int) session.getAttribute("Id");
			List<PolicyHolder> list = agentServices.viewPolicyHoders(Id);
			request.setAttribute("users", list);
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/AgentForm/userDetails.jsp");
			requestDispatcher.forward(request, response);
		}
		if (action.equals("viewPolicySold")) {

			AgentServices agentServies = new AgentServices();
			HttpSession session = request.getSession();
			int Id = (int) session.getAttribute("Id");
			List<List<Object>> list = agentServies.viewPolicySold(Id);
			request.setAttribute("viewPolicyDetails", list);
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/AgentForm/viewPolicySold.jsp");
			requestDispatcher.forward(request, response);
		}
		if (action.equals("viewMaturedPolicy")) {
			AgentServices agentServies = new AgentServices();
			HttpSession session = request.getSession();
			int Id = (int) session.getAttribute("Id");
			List<List<Object>> list = agentServies.viewPolicySold(Id);
			request.setAttribute("AgentMaturedList", list);
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/AgentForm/viewMaturedPolicy.jsp");
			requestDispatcher.forward(request, response);
		}
		if (action.equals("viewCommission")) {
			AgentServices A = new AgentServices();
			HttpSession session = request.getSession();
			int Id = (int) session.getAttribute("Id");
			List<List<Object>> list = A.viewCommission(Id);
			request.setAttribute("CommissionList", list);

			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/AgentForm/commission.jsp");
			requestDispatcher.forward(request, response);
		}

		if (action.equals("addPolicyHolder")) {
			try {
				HttpSession session = request.getSession();
				int agentId = (int) session.getAttribute("Id");
				String firstname = request.getParameter("firstname");
				String lastname = request.getParameter("lastname");
				String address = request.getParameter("address");
				String city = request.getParameter("city");
				String state = request.getParameter("state");
				String zip = request.getParameter("zip");
				String fatherName = request.getParameter("fathersname");
				String phone = request.getParameter("phonenumber");
				long phonenumber = Long.valueOf(phone);
				String email = request.getParameter("email");
				String dob = request.getParameter("dob");
				int payMode = Integer.parseInt(request.getParameter("payMode"));
				int policyId = Integer.parseInt(request
						.getParameter("policyId"));
				String s[];
				s = dob.split("/");
				Date date = Date.valueOf(s[2] + "-" + s[1] + "-" + s[0]);
				String name = firstname + " " + lastname;
				AgentServices agentServices = new AgentServices();
				System.out.println("00jjj");
				PolicyHolder result = agentServices
						.checkUserAvailability(email);
				if (result == null) {

					agentServices.addNewPolicyHolder(agentId, name, state, zip,
							payMode, policyId, fatherName, phonenumber, email,
							date, address, city);
					request.setAttribute("Message",
							"Policy Holder Successfully added");
					RequestDispatcher requestDispatcher = request
							.getRequestDispatcher("/AgentForm/agentHome.jsp");
					requestDispatcher.forward(request, response);
				}
				if (result != null) {
					request.setAttribute("policyHolder", result);
					RequestDispatcher rd = request
							.getRequestDispatcher("/AgentForm/confirmUser.jsp");
					rd.forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (action.equals("addPolicyHolder1")) {
			AgentServices agentServices = new AgentServices();
			if (request.getParameter("decision").equals("yes")) {
				int userId = Integer.parseInt(request
						.getParameter("policyHolder"));
				int policyId = Integer.parseInt(request
						.getParameter("policyId"));
				HttpSession session = request.getSession();
				int agentId = (int) session.getAttribute("Id");
				int payMode = Integer.parseInt(request.getParameter("payMode"));
				int result = agentServices.addPolicySold(userId, policyId,
						payMode, agentId);
				System.out.println(result);
				if (result == 1) {
					RequestDispatcher requestDispatcher = request
							.getRequestDispatcher("/AgentForm/agentHome.jsp");
					requestDispatcher.forward(request, response);
				}
			}
			if (request.getParameter("decision").equals("no")) {
				List<Policy> list = new ArrayList<Policy>();
				list = agentServices.viewPolicy();
				request.setAttribute("PolicyDetails", list);
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("/AgentForm/addUser.jsp");
				requestDispatcher.forward(request, response);
			}
		}
	}
}
