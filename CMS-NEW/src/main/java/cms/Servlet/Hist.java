package cms.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import cms.Dao.*;
import cms.Database.ConnectionProvider;
import cms.User.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "hist", urlPatterns = { "/hist" })
public class Hist extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Hist() {

	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException {

		User user = (User) request.getSession().getAttribute("auth");
		if (user != null) {
			request.setAttribute("person", user);

			try (PrintWriter out = response.getWriter()) {

				int c_id = user.getChild_id();

				HistoryDao hdao = new HistoryDao(ConnectionProvider.getConnection());
				History hst = hdao.getHist(c_id);
				
				HttpSession hsession = request.getSession();
				hsession.setAttribute("hsw", hst);

				if (hst != null) {
					out.println("<html>");
					out.println("<body>");

//					out.print("<h2>Child ID: " + hst.getChild_id() + "  </h2>");
//					out.print("  <h2> Parents Id : : " + user.getId() + "  </h2>");
//					out.print("  <h2> URL : " + hst.getUrl() + "  </h2>");
//					out.print("  <h2> Title : " + hst.getTitle() + "  </h2>");
//					out.print("  <h2> Time : " + hst.getV_time() + "  </h2>");
//					
					response.sendRedirect("Content/HistoryShow.jsp");
	                
					
					out.println("</body>");
					out.println("</html>");

				} else {
					response.sendRedirect("index.jsp?error=1");
				}

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		} else {
			response.sendRedirect("index.jsp?error=1");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Hist.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Hist.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
