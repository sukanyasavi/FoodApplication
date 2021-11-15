<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	background-image:
		url(https://t3.ftcdn.net/jpg/02/21/96/32/240_F_221963263_sJwVYxyqTU2B9TCtqGVoy0x1H6oxAQQt.jpg);
	background-size: cover;
	background-repeat: no-repeat;
	margin: 0;
	padding: 0;
}

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
		url(https://t3.ftcdn.net/jpg/02/21/96/32/240_F_221963263_sJwVYxyqTU2B9TCtqGVoy0x1H6oxAQQt.jpg);
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
</style>
</head>
<body>

	<center>
		<h1>${msg}</h1>
	</center>

	<div class="topnav">
		<a href="/user/userHomePage">HOME</a>
	</div>



</body>
</html>