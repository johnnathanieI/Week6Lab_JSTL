<%-- 
    Document   : shoppingList
    Created on : 24-Feb-2023, 1:35:12 AM
    Author     : johnn
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Shopping List</title>
</head>
<body>
	<h1>Welcome <%= session.getAttribute("username") %>!</h1>
	<form action="ShoppingList" method="post">
		<label for="item">Add item to your list:</label>
		<input type="text" id="item" name="item" required>
		<button type="submit" name="action" value="add">Add</button>
	</form>
	<ul>
		<% 
			ArrayList<String> items = (ArrayList<String>)session.getAttribute("items");
			if (items != null) {
				for (String item : items) {
					out.print("<li>");
					out.print("<input type='radio' name='itemToDelete' value='" + item + "'>");
					out.print(item);
					out.print("</li>");
				}
			}
		%>
	</ul>
	<form action="ShoppingList" method="post">
		<button type="submit" name="action" value="delete">Delete selected item</button>
	</form>
        <a href="ShoppingList?action=logout">Logout</a>
        
</body>
</html>
