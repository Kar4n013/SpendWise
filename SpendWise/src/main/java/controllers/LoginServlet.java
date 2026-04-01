package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pojo.LoginPojo;

import java.io.IOException;

import dao.LoginDao;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("customer_id").trim();

		String password = request.getParameter("password").trim();

		LoginPojo loginPojo = new LoginPojo();

		if (id != null && password != null) {

			int customer_id = Integer.parseInt(id);
			loginPojo.setId(customer_id);
			loginPojo.setPassword(password);
			LoginDao loginDao = new LoginDao(loginPojo);
			
			if (loginDao.verifyLogin()) {
				response.sendRedirect("DashboardServlet");
			} else {
				loginPojo.setId(0);
				loginPojo.setPassword(null);
				request.setAttribute("errorMessage", " ID or Password is incorrect!");
				request.getRequestDispatcher("/Login.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("errorMessage", "Please enter both ID and Password!");
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
	}

}
