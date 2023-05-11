<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<%@include file="/include/header.jsp"%>

<style>
* {
	margin: 0px;
	padding: 0px;
}
</style>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@include file="/include/Navbar.jsp"%>

	<div class="container mt-5">
		<h1 class="text-center mb-5">Contact Us</h1>
		<div class="row">
			<div class="col-md-8">
				<form>
					<div class="form-group">
						<label for="name">Name</label> <input type="text"
							class="form-control" id="name" placeholder="Enter your name" />
					</div>
					<div class="form-group">
						<label for="email">Email address</label> <input type="email"
							class="form-control" id="email" placeholder="Enter your email" />
					</div>
					<div class="form-group">
						<label for="message">Message</label>
						<textarea class="form-control" id="message" rows="5"
							placeholder="Enter your message"></textarea>
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>
			<div class="col-md-4">
				<h5>Contact Information</h5>
				<p>If you have any questions or concerns, please don't hesitate
					to contact us using the information below.</p>
				<p>
					<strong>Address:</strong> 123 Main Street, Anytown India 12345
				</p>
				<p>
					<strong>Phone:</strong> 555-555-5555
				</p>
				<p>
					<strong>Email:</strong> info@childmonitoringsystem.com
				</p>
			</div>
		</div>
	</div>

	<%@include file="/include/footer.jsp"%>

	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>

</body>
</html>