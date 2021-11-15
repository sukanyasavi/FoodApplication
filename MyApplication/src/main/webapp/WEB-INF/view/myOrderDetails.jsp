<%@page import="com.food.model.Menu_Table"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
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
		url(https://images-na.ssl-images-amazon.com/images/S/sgp-catalog-images/region_US/8pg4d-0NG3KRTWE8F-Full-Image_GalleryBackground-en-US-1554535973450._SX1080_.jpg);
	background-size: cover;
	color: black;
	font-family: sans-serif;
	height: 100vh;
	display: flex;
	flex-direction: column;
	justify-content: space-between;
}

th, td {
	text-align: left;
	padding: 0.5em 1em;
	width: "100";
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
		<h1 style="color: white;">Food Application</h1><br>
		<div class="topnav">
			<a href="/user/userHomePage">Home</a>
			<c:if test="${cust==null}">
				<a href="../../../../../../user/logout"> Logout </a>
			</c:if>
<a href="/user/myOrder">Back</a> <br>
		</div>
<br>
		<center>
			<c:if test="${Items.isEmpty()}">
				<c:if test="${msg!=null}">
					<center>
						<h1>${msg}</h1>
					</center>
				</c:if>
			</c:if>
<br>
			<c:if test="${!Items.isEmpty()}">
				<table>
					<tr>
						<th>Order_Id</th>

						<th>dishName</th>
						<th>dish Image</th>
						<th>Quantity</th>
						<th>amount</th>
	
						<th>Total+7%tax</th>
						<th>Billing Details</th>
						<th>Date of Order</th>
						<th>Mode of Payment</th>
					</tr>

					<c:forEach var="Item" items="${Items}">
						<tr>
							<td>ORD${Item.order_id}</td>
							<td>${Item.dish_Name }</td>
							<td><img src="/Images/${Item.dish_img}" alt="noimg"
								border=3 height=100 width=100 /></td>
							<td>${Item.quantity}</td>
							<td>${Item.price}</td>
							   <td>${Item.price + Item.price*0.07 }</td>
							<td>${Item.name }<br>${Item.address }<br>${Item.phone_no }</td>
							<td>${Item.date_of_order}</td>
							<td>${Item.mode_of_payment}</td>

						</tr>
					</c:forEach>
				</table>
			</c:if>
		</center>

		</div>
</body>
</html>