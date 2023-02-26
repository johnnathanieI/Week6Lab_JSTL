<%-- 
    Document   : register
    Created on : 24-Feb-2023, 1:35:04 AM
    Author     : johnn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Shopping List</title>
</head>
<body>
	<h1>Shopping List</h1>
	<form action="ShoppingList" method="post">
		<label for="username">Enter your name:</label>
		<input type="text" id="username" name="username" required>
		<button type="submit" name="action" value="register">Register name</button>
	</form>
</body>
</html>
