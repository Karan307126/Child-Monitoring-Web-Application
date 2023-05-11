package cms.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import cms.Database.ConnectionProvider;
import cms.Dao.*;
import cms.User.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		String url = "jdbc:mysql://localhost:3306/de";
//		String username = "root";
//		String password = "mysql";
//		String query = "SELECT * FROM user WHERE id = ?";
//		int userID = 3;

		try (PrintWriter out = response.getWriter()) {
			String username = request.getParameter("user");
			String pass = request.getParameter("pass");

			UserDao udao = new UserDao(ConnectionProvider.getConnection());
			User user = udao.checkUser(username, pass);

			if (user != null) {
				out.print("Logged In Successfully , Welcome . Dear User : " + username);
				out.println("  \n     Your Id : "+user.getId());
				request.getSession().setAttribute("auth", user);
				response.sendRedirect("index.jsp");

			} else {
				response.sendRedirect("index.jsp?error=1");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public String getServletInfo() {
		return "Short description";
	}
}
