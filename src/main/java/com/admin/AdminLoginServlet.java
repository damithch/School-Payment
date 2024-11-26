package com.admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminLogin")
public class AdminLoginServlet extends HttpServlet {

	private AdminService adminService;

	// Initialize the service
	@Override
	public void init() throws ServletException {
		super.init();
		adminService = new AdminServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		Admin admin = new Admin(username, password);

		if (adminService.validateAdmin(admin)) {

			request.getRequestDispatcher("AdminDashBorad.jsp").forward(request, response);
		} else {

			request.getRequestDispatcher("loginFailed.jsp").forward(request, response);
		}
	}
}
