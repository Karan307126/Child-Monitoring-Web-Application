package cms.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import cms.Dao.*;
import cms.Database.ConnectionProvider;
import cms.User.*;
import cms.User.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/loct")
public class Loctrack extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Loctrack() {

	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException {

		User user = (User) request.getSession().getAttribute("auth");
		if (user != null) {
			request.setAttribute("person", user);

			try (PrintWriter out = response.getWriter()) {

				int c_id = user.getChild_id();

				LocationDao ldao = new LocationDao(ConnectionProvider.getConnection());
				Location hst = ldao.getLoc(c_id);
				
				HttpSession lSession = request.getSession();
				lSession.setAttribute("lat_log", hst);
				

				if (hst != null) {
					out.println("<html>");
					out.println("<body>");

//					out.print("<h2>Child ID: " + hst.getChild_id() + "  </h2>");
//					out.print("  <h2> Parents Id : : " + user.getId() + "  </h2>");
//					out.print("  <h2> Latitude : " + hst.getLat() + "  </h2>");
//					out.print("  <h2> Longitude : " + hst.getLon() + "  </h2>");
//					out.print("  <h2> Time : " + hst.getL_time() + "  </h2>");
   
					response.sendRedirect("Content/LocationShow.jsp");
	                
					
//					out.println("<form action=\"showLoc.jsp\" method=\"get\">");
//					out.println("<button type=\"submit\" value=\"submit\" > SHOW LOCATION </button> </form>");
					
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
			Logger.getLogger(Loctrack.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			processRequest(request, response);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Loctrack.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
