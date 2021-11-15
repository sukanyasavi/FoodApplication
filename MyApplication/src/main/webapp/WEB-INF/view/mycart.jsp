<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>




<html>
<head>
<meta charset="ISO-8859-1">
<title>cart info</title>
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
		url(https://cdn.pixabay.com/photo/2017/02/15/10/39/salad-2068220__340.jpg);
	background-size: cover;
	color: black;
	font-family: sans-serif;
	height: 100vh;
	display: flex;
	flex-direction: column;
	justify-content: space-between;
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
		<h1 style="color: white;">Food Application</h1>
		<br>



		<div class="topnav">
			<a href="/user/userHomePage">Home</a> <a
				href="../../../../../../user/logout"> Logout </a>

		</div>


		<h2 style="color: white;">Cart List</h2>

		<center><h2>Cart details</h2><c:if test="${msd!=null}">
	<h3>${msd }</h3></c:if></center>
		<center>
			<c:if test="${cart.isEmpty()}">
				<c:if test="${msg!=null}">
					<center>
						<h1 style="color: white;">${msg}</h1>
					</center>
				</c:if>
			</c:if>


			<br>
			<c:if test="${!cart.isEmpty()}">
				<center>
					<table>
						<tr>
							<th>CartId</th>
							<th>Image</th>
							<th>dish Name</th>
							<th>Price</th>
							<th>Quantity</th>



							



							<th>Action</th>



						</tr>



						<c:forEach items="${cart}" var="cart">
							<tr>
								<td>${cart.cart_id}<input type="hidden" id="cart_id"
									name="cart_id" value=${cart.cart_id}></input></td>
								<td><img src="/Images/${cart.dish_Name}.jpg" alt="NoImg"
									border=3 height=100 width=100 /></td>
								<td>${cart.dish_Name}</td>




								<td>${cart.price}</td>
								<td>${cart.quantity}</td>
								<td>
								<form action="/user/edit/${cart.cart_id}" method="post">
										<button type="submit" class="btn btn-black">Edit</button>
									</form> <br>
									<form action="/user/remove/${cart.cart_id}" method="post">
										<button type="submit" class="btn btn-black">Remove</button>
									</form> <br>

								</td>


							</tr>

						</c:forEach>
						<td colspan="7"><center>Gross Price :${totalPrice}</center>
							<center>tax : 7%</center>
							<center>Total Price :${totalPrice +totalPrice*0.07 }</center></td>

					</table>


					<form action="/user/addpayment" method="post">
						<button>
							<input type="submit" class="btn btn-black" value="Place order">
						</button>

					</form>

				</center>
			</c:if>
</body>
</html>