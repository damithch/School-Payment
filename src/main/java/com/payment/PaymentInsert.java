package com.payment;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/payment")
public class PaymentInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Retrieve parameters from the request
		String studentId = request.getParameter("student_id");
		String paymentAmountStr = request.getParameter("payment_amount");
		String paymentDate = request.getParameter("payment_date");
		String paymentMethod = request.getParameter("payment_method");
		String paymentStatus = request.getParameter("payment_status");
		String receiptNumber = request.getParameter("receipt_number");
		String paymentReference = request.getParameter("payment_reference");
		String paymentNotes = request.getParameter("payment_notes");

		try {
			// Validate required fields
			if (studentId == null || studentId.trim().isEmpty() || paymentAmountStr == null
					|| paymentAmountStr.trim().isEmpty() || paymentDate == null || paymentDate.trim().isEmpty()
					|| paymentMethod == null || paymentMethod.trim().isEmpty() || paymentStatus == null
					|| paymentStatus.trim().isEmpty()) {
				request.setAttribute("errorMessage", "All fields must be filled out.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
				dispatcher.forward(request, response);
				return;
			}

			// Convert payment amount to BigDecimal and validate it
			BigDecimal paymentAmount = new BigDecimal(paymentAmountStr);
			if (!isValidPaymentAmount(paymentAmount)) {
				request.setAttribute("errorMessage",
						"Payment amount must be greater than 0.0 and less than or equal to 1,000,000.0.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("Invalid.jsp");
				dispatcher.forward(request, response);
				return;
			}

			// Validate payment date format
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			dateFormat.setLenient(false);
			try {
				dateFormat.parse(paymentDate);
			} catch (ParseException e) {
				request.setAttribute("errorMessage", "Invalid payment date format. Use yyyy-MM-dd.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
				dispatcher.forward(request, response);
				return;
			}

			// Check for existing payment
			if (PaymentDbUtil.isPaymentExists(studentId, paymentDate, receiptNumber)) {
				request.setAttribute("errorMessage", "A payment with the same details already exists.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
				dispatcher.forward(request, response);
				return;
			}

			// Insert payment into the database
			boolean isInserted = PaymentDbUtil.insertPayment(studentId, paymentAmount, paymentDate, paymentMethod,
					paymentStatus, receiptNumber, paymentReference, paymentNotes);

			String targetJSP = isInserted ? "success.jsp" : "unsuccess.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(targetJSP);
			dispatcher.forward(request, response);
		} catch (NumberFormatException e) {

			request.setAttribute("errorMessage", "Invalid payment amount format.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {

			request.setAttribute("errorMessage", "An error occurred while processing the payment: " + e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
		}
	}

	// Method to validate the payment amount
	private boolean isValidPaymentAmount(BigDecimal amount) {
		return amount.compareTo(BigDecimal.ZERO) > 0 && amount.compareTo(new BigDecimal("1000000.0")) <= 0;
	}
}
