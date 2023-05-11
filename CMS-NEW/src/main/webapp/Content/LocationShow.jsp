<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="cms.User.*"%>
<%@page import="cms.Database.*"%>
<%@page import="cms.Dao.*"%>
<%@page import="java.util.*"%>
<%
User auth = (User) request.getSession().getAttribute("auth");
List<Location> location = null;

if (auth != null) {
	request.setAttribute("person", auth);
	LocationDao locationDao = new LocationDao(ConnectionProvider.getConnection());
	location = locationDao.childLocation(auth.getChild_id());
} else {
	response.sendRedirect("index.jsp");
}
%>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="./Content.css" />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<div class="item-center">
		<h4>LOCATION HISTORY</h4>
	</div>




	<div class="container">
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">LOCATION NO</th>
					<th scope="col">Child Id</th>
					<th scope="col">Latitude</th>
					<th scope="col">Longitude</th>
					<th scope="col">Date</th>
					<th scope="col">Location </th>
					<th scope="col">Delete</th>
				</tr>
			</thead>
			<tbody>

				<%
				if (location != null) {
					for (Location l : location) {
				%>
				<tr>
					<td><%=l.getId()%></td>
					<td><%=l.getChild_id()%></td>
					<td><%=l.getLat()%></td>
					<td><%=l.getLon()%></td>
					<td><%=l.getL_time() %></td>
					<% Location l1 = (Location)request.getSession().getAttribute("lat_log"); %>
					<td><a class="btn btn-sm btn-light " 
						href="ShowLocServlet?id=<%=l.getId()%>">Location</a></td>
					<td><a class="btn btn-sm btn-danger"
						href="cancel-order?id=<%=l.getId()%>">Delete</a></td>
				</tr>
				<%
				}
				}
				%>

			</tbody>
		</table>
	</div>


</body>
</html>