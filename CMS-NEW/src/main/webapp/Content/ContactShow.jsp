<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="cms.User.*"%>
<%@page import="cms.Database.*"%>
<%@page import="cms.Dao.*"%>
<%@page import="java.util.*"%>
<%
User auth = (User) request.getSession().getAttribute("auth");
List<Contact> contacts = null;

if (auth != null) {
	request.setAttribute("person", auth);
	ContactDao contactDao = new ContactDao(ConnectionProvider.getConnection());
	contacts = contactDao.childContacts(auth.getChild_id());
} else {
	response.sendRedirect("index.jsp");
}

%>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./Content.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Contact Information</title>
</head>
<body>

	<div class="item-center">
		<h4>CONTACT HISTORY</h4>
	</div>

	


	<div class="container">
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">call NO</th>
					<th scope="col">Child Id</th>
					<th scope="col">Phone NO</th>
					<th scope="col">Date</th>
					<th scope="col">Delete	</th>
				</tr>
			</thead>
			<tbody>

				<%
				if (contacts != null) {
					for (Contact c : contacts) {
				%>
				<tr>
					<td><%=c.getId()%></td>
					<td><%=c.getChild_id()%></td>
					<td><%=c.getPhone_number()%></td>
					<td><%=c.getCtime()%></td>
					<td><a class="btn btn-sm btn-danger"
						href="cancel-order?id=<%=c.getId()%>">Delete</a></td>
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