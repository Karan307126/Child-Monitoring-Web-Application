package childcms.Servlet;

import java.io.*;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import childcms.Child.*;
import childcms.Dao.*;
import childcms.Database.ConnectionProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException {

		try (PrintWriter out = response.getWriter()) {
			String username = request.getParameter("user");
			String pass = request.getParameter("pass");

			ChildDao cdao = new ChildDao(ConnectionProvider.getConnection());
			Child child = cdao.checkUser(username, pass);

			if (child != null) {
				out.print("Logged In Successfully , Welcome . Dear User : " + username);
				out.println("  \n     Your Id : "+child.getId());
				request.getSession().setAttribute("auth", child);
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

}
