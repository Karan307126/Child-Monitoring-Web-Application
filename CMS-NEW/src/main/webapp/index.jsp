<%@page import="cms.Database.*"%>
<%@page import="cms.Servlet.*"%>
<%@page import="cms.User.*"%>
<%@page import="cms.Dao.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
User auth = (User) request.getSession().getAttribute("auth");
if (auth != null) {
	request.setAttribute("person", auth);
}
%>

<!DOCTYPE html>
<html>
<head>
<%@include file="/include/header.jsp"%>
<meta charset="UTF-8">

</head>
<body>

	<%@include file="/include/Navbar.jsp"%>
	
  <div class="cont1">
	<div class="container-md container2">
		<img src="img/main-back.jpg"  class="img-fluid" alt="image error1">
		<div class="para">
			<h1 class="para">Child Monitoring System</h1>
			<p class="para">If you have not register then register first or
				you have already registred then login.</p>
			<button type="button" class="btn btn-success para"
				data-bs-toggle="modal" data-bs-target="#loginmodal">Login</button>
			<button type="button" class="btn btn-danger para"
				data-bs-toggle="modal" data-bs-target="#signupmodal">Register</button>
		</div>
	</div>
	
	</div>

	<!--login Modal -->
	<div class="modal fade" id="loginmodal" tabindex="-1"
		aria-labelledby="loginmodalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5" id="loginmodalLabel">Login to app</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form action="Login" method="post">
						<div class="mb-3">
							<label for="exampleInputEmail1" class="form-label">Email
								address</label> <input type="email" class="form-control"
								id="exampleInputEmail1" aria-describedby="emailHelp" name="user">
							<div id="emailHelp" class="form-text">We'll never share
								your email with anyone else.</div>
						</div>
						<div class="mb-3">
							<label for="exampleInputPassword1" class="form-label">Password</label>
							<input type="password" class="form-control"
								id="exampleInputPassword1" name="pass">
						</div>
						<div class="mb-3 form-check">
							<input type="checkbox" class="form-check-input"
								id="exampleCheck1"> <label class="form-check-label"
								for="exampleCheck1">Check me out</label>
						</div>
						<button type="submit" class="btn btn-primary">Submit</button>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	<!--Signup Modal -->
	<div class="modal fade" id="signupmodal" tabindex="-1"
		aria-labelledby="signupmodalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5" id="signupmodalLabel">Get an
						account</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form action="Signup" method="post">
						<div class="mb-3">
							<label for="exampleInputEmail1" class="form-label">Email
								address</label> <input type="email" class="form-control"
								id="exampleInputEmail1" aria-describedby="emailHelp" name="user">
							<div id="emailHelp" class="form-text">We'll never share
								your email with anyone else.</div>
						</div>
						<div class="mb-3">
							<label for="exampleInputPassword1" class="form-label">Password</label>
							<input type="password" class="form-control"
								id="exampleInputPassword1"> <label
								for="cexampleInputPassword1" class="form-label">Conform
								Password</label> <input type="password" class="form-control"
								id="cexampleInputPassword1" name="pass">
						</div>
						<div class="mb-3 form-check">
							<input type="checkbox" class="form-check-input"
								id="exampleCheck1"> <label class="form-check-label"
								for="exampleCheck1">Check me out</label>
						</div>
						<button type="submit" class="btn btn-primary">Submit</button>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	<%@include file="/include/footer.jsp"%>

</body>
</html>