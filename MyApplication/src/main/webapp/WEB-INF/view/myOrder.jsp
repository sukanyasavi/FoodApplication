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
    max-width: 100%;
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
    background: linear-gradient(rgba(0, 0, 0, 0.35), rgba(0, 0, 0, 0.35)),
        url(../Images/order.jpg) no-repeat;
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

 

d {
    top: 50%;
    left: 50%;
    padding: 2.5rem;
}

 

.d input[type="text"] {
    outline: none;
    width: 60%;
    padding: 0.625rem 1.25rem;
    cursor: pointer;
    border-radius: 0.312rem;
    font-size: 1rem;
    background-color: white;
}

 

.d input[type="submit"] {
    border: none;
    outline: none;
    color: white;
    background-color: black;
    padding: 0.625rem 1.25rem;
    cursor: pointer;
    border-radius: 0.312rem;
    font-size: 1rem;
}

 

.d input[type="submit"]:hover {
    background-color: #1cb1f5;
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
            <c:if test="${cust==null}">
                <a href="/user/myOrderDetails">Order Details</a>
            </c:if>
        </div>
        <br>
          <h2 style="color: white;"><center>My Orders</center></h2>
        <div class="d">
            <center>
                <form action="searchOrderOpr" method="post">
                    <div class="inputBox">
                        <input type="text" name="search_order" required
                            value="${search_Order}"
                            onkeyup="this.setAttribute('value', this.value);"
                            placeholder="Search for Order...."> <input type="submit"
                            name="searchOrder" value="Search Order">
                    </div>
                </form>
            </center>
        </div>
        </div>
        <center>
            <c:if test="${Items.isEmpty()}">
                <c:if test="${msg!=null}">
                    <center>
                        <h1 style="color: white;">${msg}</h1>
                    </center>
                </c:if>
            </c:if><br>
 <c:if test="${!Items.isEmpty()}">
                <center>
                    <table>
                        <tr>
                            <th>Order_Id</th>
                            <th>dishName</th>
                            <th>Date of Order</th>
                            <th>Mode of Payment</th>
                        </tr>

 

                        <c:forEach var="Item" items="${Items}">
                            <tr> 
                                <td> <form action="/user/specificOrder/${Item.order_id }" method="post">
                                <button type="submit">ORD${Item.order_id}</button></form></td>
                                <td>${Item.dish_Name }</td>
                                <td>${Item.date_of_order}</td>
                                <td>${Item.mode_of_payment}</td>
                            </tr>
                        </c:forEach>
                    </table>

 

                </center>
            </c:if>

 

            </div>
</body>
</html>