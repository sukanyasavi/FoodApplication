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
  max-width: 55%;
}

tr{
  background-color: #eee;
}

th {
  background-color: #555;
  color: #fff;
}
body{
  margin:0;
  padding: 0;
  background: linear-gradient(rgba(0, 0, 0, 0.35), rgba(0, 0, 0, 0.35)), url(../Images/bg.jpg) no-repeat;
  background-size: cover;
  color: black;
  font-family: sans-serif;
  height: 100vh;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}
th,
td {
  text-align: left;
  padding: 0.5em 1em;
  width:"1000";
  
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
a{
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
<body><center>



<h1> Food Application</h1>

 <div class="topnav">
  <a href="/user/userHomePage">Home</a>
 <c:if test="${cust!=null}">
<a href="/user/searchDish">Search For Dish</a>
<a href="/user/searchOrder">Search For Order</a>
<a href ="/viewCart">Cart</a>
<a href="/myOrder">My Order</a><left>
<a href="/login">Logout</a></left>
</c:if>



<br>
</div> 
inserted for cart id: ${msd}
<table border="1">
   
    <tr>
    <th>Cart id</th>
    <th>dish name</th>
    <th>dish image</th>
    
      <th>quantity</th>
       
       <th>price</th>
       <th>total</th>
       
       
       
       </tr>
     <c:forEach items="${list}" var="l">
        <tr>  
            <td>${l.cart_id}</td>
            <td>${l.dish_Name}</td> 
           <td><img src="${path}${l.dish_img}" alt="noimg" border=3 height=100 width=100/></td>
      
              <td><input type="text" name="quantity"  onkeyup="this.setAttribute('value', this.value);" required value="${l.quantity}">
            <td>${l.price}</td>
           <td>${l.price*l.quantity}</td>
            </tr>
    </c:forEach>
</table>






</body>
</html>