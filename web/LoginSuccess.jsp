<%-- 
    Document   : LoginSuccessful
    Created on : 21-mag-2016, 17.15.35
    Author     : foxma
--%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Login Success Page</title>
</head>
<body>

<h3>Hi  Login successful. Your Session </h3>
<br>


<br>

<!-- need to encode all the URLs where we want session information to be passed -->
<a href="/Amm2016/M3/CheckoutPage.jsp">Checkout Page</a>
<form action="/Amm2016/LogoutServlet" method="post">
<input type="submit" value="Logout" >
</form>
</body>
</html>