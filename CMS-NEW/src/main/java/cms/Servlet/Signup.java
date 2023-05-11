package cms.Servlet;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Signup() {
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException {
		PrintWriter out = response.getWriter();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/de";
			String username = "root";
			String pssword = "mysql";
			out.println("<h1>world!!!</h1>");
			try (Connection conn = DriverManager.getConnection(url, username, pssword)) {
				String user = request.getParameter("user");
				String pas = request.getParameter("pass");

				try (PreparedStatement pst = conn
						.prepareStatement("INSERT INTO user (username,password) VALUES (?,?)")) {
					pst.setString(1, user);
					pst.setString(2, pas);
					pst.executeUpdate();
				}
			}
			out.println("<h1> last </h1>");

		} catch (ClassNotFoundException | SQLException e) {
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

	public String getServletInfo() {
		return "Short description";
	}
}
