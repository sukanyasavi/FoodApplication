<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!--<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%> -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
        url(https://t3.ftcdn.net/jpg/02/60/25/20/240_F_260252039_Fe44ZTbA448cM1Xfs8XeqcJIRuwO30j9.jpg);
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
<h1>Food Application</h1><br>
 

        <div class="topnav">
            <a href="/user/userHomePage">HOME</a> 
             <a href="../../../../../../user/logout"> Logout </a>
            
        </div>
        <br> <br> <br> <br>
        <center>
            <table>
                <form id="save" action="/user/saveToCart/${menu.dishName}" method="post"
                    modelAttribute="menu">
                    <tr>
                        <th>dish Name:</th>
                        <td>${menu.dishName}</td>
                        <th>dish img:</th>
                        <td><img src="/Images/${menu.dishName}.jpg" alt="NoImg"
                            border=3 height=100 width=100 /></td>
                        <th>Price:</th>
                        <td>${menu.price}
                        <td>
                        <th>Quantity:</th>
                        <td><input type="text" id="quantity" name="quantity"
                            required value ="${quantity}"></td>
                    
                        <td></td>
                        <th>Action:</th>
                        <td><input type="submit" value="submit"></td>
                    </tr>
                </form>
            </table>
        </center>

 

        
</body>

 

</html>