<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	margin: 0;
	padding: 0;
	background: linear-gradient(rgba(0, 0, 0, 0.35), rgba(0, 0, 0, 0.35)),
		url(../Images/background1.jpg) no-repeat;
	color: black;
	font-family: sans-serif;
	height: 150vh;
	flex-direction: column;
	justify-content: space-between;
	background-position: 100% 100%;
	background-position: center;
}

th, td {
	text-align: left;
	padding: 0.5em 1em;
	width: "1000";
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
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>Food Application</h1>
		<div class="topnav">
			<a href="/user/userHomePage">Home</a>
			<c:if test="${cust==null}">
				<a href="../../../../../../user/logout"> Logout </a>
					<a href="/user/myOrder">My Order</a>
		<a href="/user/getcart${pay.cart_id}"> My Cart </a> 
					
			</c:if>
		</div>
		</style>
		</head>
		<body>
			<tr>
			<form 
					modelAttribute="pay">
					</form>
				<center>
					<h1>
						Order Successfull...!!!
					</h1>
				</center>
			</tr>
		</body>
</html>