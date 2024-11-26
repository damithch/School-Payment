package com.payment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PaymentDelete")
public class PaymentDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String paymentIdStr = request.getParameter("payment_id");

		try {

			int paymentId = Integer.parseInt(paymentIdStr);

			boolean isDeleted = PaymentDbUtil.deletePayment(paymentId);

			if (isDeleted) {
				response.sendRedirect("paymentDeltSuccessful.jsp");
			} else {
				response.sendRedirect("paymentDeltUnsuccessful.jsp");
			}
		} catch (NumberFormatException e) {

			request.setAttribute("errorMessage", "Invalid payment ID format: " + e.getMessage());
			response.sendRedirect("paymentDeltUnsuccessful.jsp");
		} catch (Exception e) {

			request.setAttribute("errorMessage", "An error occurred while deleting the payment: " + e.getMessage());
			response.sendRedirect("paymentDeltUnsuccessful.jsp");
		}
	}
}
