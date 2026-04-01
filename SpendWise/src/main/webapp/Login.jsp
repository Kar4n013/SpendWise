<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Customer Login</title>

<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body class="bg-light">

	<div
		class="container vh-100 d-flex justify-content-center align-items-center">

		<div class="card shadow p-4" style="width: 400px;">

			<h3 class="text-center mb-4">Customer Login</h3>
			<%
			String error = (String) request.getAttribute("errorMessage");
			if (error != null) {
			%>

			<div class="alert alert-danger text-center">
				<%=error%>
			</div>

			<%
			}
			%>
			<form action="LoginServlet" method="post">

				<div class="mb-3">
					<label for="customer_id" class="form-label">Customer ID</label> <input
						type="text" class="form-control" id="customer_id"
						name="customer_id" placeholder="Enter Customer ID" required>
				</div>

				<div class="mb-3">
					<label for="password" class="form-label">Password</label> <input
						type="password" class="form-control" id="password" name="password"
						placeholder="Enter Password" required>
				</div>

				<div class="d-grid">
					<button type="submit" class="btn btn-primary">Login</button>
				</div>

			</form>

		</div>

	</div>

	<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>