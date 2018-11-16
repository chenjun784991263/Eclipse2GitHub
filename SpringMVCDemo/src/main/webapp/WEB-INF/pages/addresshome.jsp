<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Address Management Screen</title>
</head>
<body>
	<div align="center">
		<h1>Address List</h1>
		
		<table border="1">
            <tr>
			<th>Province</th>
			<th>City</th>
			<th>Town</th>
			
            </tr>
			<c:forEach var="address" items="${addresslist}">
				<tr>

					<td>${address.province}</td>
					<td>${address.city}</td>
					<td>${address.town}</td>
					
					<td><a href="editAddress?id=${address.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="deleteAddress?id=${address.id}">Delete</a></td>

				</tr>
			</c:forEach>
		</table>
		<h4>
			New Address Register <a href="newAddress">here</a>
		</h4>
	    <h4>
			New User Register <a href="AddUser">here</a>
		</h4>
	
	
	</div>
</body>
</html>