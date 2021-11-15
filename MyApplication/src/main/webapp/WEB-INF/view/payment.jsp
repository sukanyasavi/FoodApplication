<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!--<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%> -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<style>
main {
	display: flex;
	justify-content: center;
}

table {
	max-width: 50%;
}

tr {
	background-color: #eee;
}

th {
	background-color: #555;
	color: #fff;
}

body {
	margin: 0;
	padding: 0;
	background-image:
		url(https://t3.ftcdn.net/jpg/03/07/55/34/240_F_307553470_Q4HuxDQQEfLJHA7MUKWyh9P05MPyVBVl.jpg);
	background-size: cover;
	color: black;
	font-family: sans-serif;
	height: 100vh;
	display: flex;
	flex-direction: column;
	justify-content: space-between;
	background-size: cover;
	background-attachment: fixed;
}

th {
	text-align: center;
	padding: 5px;
	height: 50px;
}

td {
	text-align: center;
	padding: 5px;
	height: 50px;
}

.topnav {
	overflow: hidden;
	background-color: #333;
}

.topnav a {
	float: left;
	color: #f2f2f2;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 17px;
}

.topnav a:hover {
	background-color: #ddd;
	color: black;
}

.topnav a.active {
	background-color: #4CAF50;
	color: white;
}

a {
	color: #ADF875;
	background-color: transparent;
	text-decoration: none;
}

a:hover {
	color: White;
	font-weight: bold;
	background-color: transparent;
}

a:active {
	color: yellow;
	background-color: transparent;
	text-decoration: underline;
}

input[type=submit] {
	width: 100%;
	background-color: grey;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: black;
}

body, html {
	height: 100%;
	margin: 0;
	font-weight: 700;
}

element.style {
	
}

[type=button]:not(:disabled), [type=reset]:not(:disabled), [type=submit]:not(:disabled),
	button:not(:disabled) {
	cursor: pointer;
}

.btn-primary {
	color: #fff;
	background-color: black;
	border-color: black;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1 style="color: white;">Food Application</h1>
		<br>
		<div class="topnav">
			<a href="/user/userHomePage">Home</a> <a
				href="/user/getcart${pay.cart_id}"> My Cart </a> <a
				href="../../../../../../user/logout">Logout</a>
		</div>
		<br>
		<h4>
			<center>
				<p style="color: white;">Order Form</p>
			</center>
		</h4>
		<br>
		<h5>
			<p style="color: red;">NOTE: For now only Cash On Delivery Option
				is available</p>
		</h5>
		<center>
			<div class="bg">
				<form id="save" action="/user/saveToOrder1" method="post"
					modelAttribute="pay">


					<div class="form-field" align="center">
						<label for="user_name" style="color: black"> Name </label> <input
							type="text" class="form-control" id="user_name"
							placeholder="Enter your Name" name="user_name"
							style="width: 400px;" required value="${user_table.user_name }">
						<div class="valid-feedback"></div>
						<div class="invalid-feedback"></div>
					</div>

					<div class="form-field" align="center">
						<label for="address" style="color: black">Address </label> <input
							type="text" class="form-control" id="address"
							placeholder="Enter your address" name="address"
							style="width: 400px;" required value="${user_table.address }">
						<div class="valid-feedback"></div>
						<div class="invalid-feedback"></div>
					</div>


					<div class="form-field" align="center">
						<label for="ph_number" style="color: black">Phone Number</label> <input
							type="number" class="form-control" id="ph_number"
							placeholder="Enter your number" name="ph_number"
							style="width: 400px;" required value="${user_table.ph_number }">
						<div class="valid-feedback"></div>
						<div class="invalid-feedback"></div>
					</div>

					<div class="form-field" align="center">
						<label for="mode_of_payment" style="color: black">Mode Of
							Payment</label> <input type="text" class="form-control"
							id="mode_of_payment" name="mode_of_payment" style="width: 400px;"
							required value="COD" readonly>
						<div class="valid-feedback"></div>
						<div class="invalid-feedback"></div>
					</div>


					<div class="btnDetails"
						style="margin-top: 30px; text-align: center">
						<button type="submit" class="btn btn-primary">Confirm
							Order</button>
						<a href="/user/getcart${pay.cart_id}" class="btn btn-primary"
							style="width: 10%">Cancel</a>
					</div>

				</form>
			</div>
</body>
</html>



