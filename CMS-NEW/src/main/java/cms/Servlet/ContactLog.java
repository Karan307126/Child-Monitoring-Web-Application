package cms.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import cms.Dao.*;
import cms.Database.ConnectionProvider;
import cms.User.*;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



@WebServlet("/ContactLog")
public class ContactLog extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ContactLog() {
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException {

		User user = (User) request.getSession().getAttribute("auth");
		if (user != null) {
			request.setAttribute("person", user);
		
		
		try (PrintWriter out = response.getWriter()) {
			
			int c_id = user.getChild_id();

			ContactDao cdao = new ContactDao(ConnectionProvider.getConnection());
			Contact cnt1 = cdao.getContact(c_id);
			
			HttpSession Csession = request.getSession();
			
			Csession.setAttribute("CLog", cnt1);

			if (cnt1 != null) {
//				out.println("<html>");
//				out.println("<body>");
//
//				out.print("<h2>Child ID: " + cnt1.getChild_id() + "  </h2>");
//                out.print("  <h2> Parents Id : : " + user.getId() + "  </h2>");
//                out.print("  <h2>Phone Number: " + cnt1.getPhone_number() + "  </h2>");
//                out.print("  <h2> Time : " + cnt1.getCtime() + "  </h2>");
//                
//				out.println("</body>");
//				out.println("</html>");
				
				response.sendRedirect("Content/ContactShow.jsp");
                
			} else {
				response.sendRedirect("index.jsp?error=1");
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		}
		else {
			response.sendRedirect("index.jsp?error=1");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Contact.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Contact.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}
}
