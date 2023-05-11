package cms.Servlet;

import java.io.IOException;
import java.io.*;

import cms.Dao.*;
import cms.Database.*;
import cms.User.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Content/ShowLocServlet")
public class ShowLocServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowLocServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try (PrintWriter out = response.getWriter()) {
			String id = request.getParameter("id");
			if (id != null) {
				LocationDao locationDao = new LocationDao(ConnectionProvider.getConnection());
				Location lct1 =   locationDao.getTemp(Integer.parseInt(id));
				
				HttpSession ltmp = request.getSession();
				ltmp.setAttribute("ll", lct1);
				
				response.sendRedirect("showLoc.jsp");
				
			}
			response.sendRedirect("orders.jsp");
		}  catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
