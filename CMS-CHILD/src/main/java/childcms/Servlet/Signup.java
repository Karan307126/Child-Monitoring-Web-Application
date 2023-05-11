package childcms.Servlet;

import java.io.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import childcms.Database.ConnectionProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Signup() {
		super();
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException {
		PrintWriter out = response.getWriter();

		try {
			
			
			try (Connection conn = ConnectionProvider.getConnection()) {
				String user = request.getParameter("user");
				String pas = request.getParameter("pass");

				try (PreparedStatement pst = conn
						.prepareStatement("INSERT INTO child (username,password) VALUES (?,?)")) {
					pst.setString(1, user);
					pst.setString(2, pas);
					pst.executeUpdate();
				}
			}
			out.println("<h1> SuccessFully Registered ! </h1>");
			
			response.sendRedirect("index.jsp");

		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
