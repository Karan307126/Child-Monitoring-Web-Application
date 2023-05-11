<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="cms.User.*"%>
<%@page import="cms.Database.*"%>
<%@page import="cms.Dao.*"%>
<%@page import="java.util.*"%>
<%
User auth = (User) request.getSession().getAttribute("auth");
List<History> history = null;

if (auth != null) {
	request.setAttribute("person", auth);
	HistoryDao historyDao = new HistoryDao(ConnectionProvider.getConnection());
	history = historyDao.childHistory(auth.getChild_id());
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
		<h4>BROWSING HISTORY</h4>
	</div>




	<div class="container">
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">URL NO</th>
					<th scope="col">Child Id</th>
					<th scope="col">TITLE</th>
					<th scope="col">URL</th>
					<th scope="col">Date</th>
					<th scope="col">Delete</th>
				</tr>
			</thead>
			<tbody>

				<%
				if (history != null) {
					for (History h : history) {
				%>
				<tr>
					<td><%=h.getId()%></td>
					<td><%=h.getChild_id()%></td>
					<td><%=h.getUrl()%></td>
					<td><%=h.getTitle()%></td>
					<td><%=h.getV_time()%></td>
					<td><a class="btn btn-sm btn-danger"
						href="cancel-order?id=<%=h.getId()%>">Delete</a></td>
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