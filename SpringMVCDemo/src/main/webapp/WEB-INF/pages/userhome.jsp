<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page isELIgnored="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Management Screen</title>
</head>
<body>
	<div align="center">
		<h1>User List</h1>
		
		<table border="1">
            <tr>
			<th>Name</th>
			<th>PassWord</th>
			<th>Gender</th>
			<th>Age</th>
			<th>PhoneNumber</th>
			<th>Address</th>
            </tr>
			<c:forEach var="user" items="${listuser}">
				<tr>

					<td>${user.name}</td>
					<td>${user.password}</td>
					<td>${user.gender}</td>
					<td>${user.age}</td>
					<td>${user.phonenumber}</td>
					<td>
				   <c:forEach var="address" items="${addresslist}">
                   <c:if test="${address.id eq user.addressid}">${address.province}/${address.city}/${address.town}</c:if>
                   </c:forEach>
				   </td>
					
					<td><a href="editUser?id=${user.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="deleteUser?id=${user.id}">Delete</a></td>

				</tr>
			</c:forEach>
		</table>
		<h4>
			New User Register <a href="newUser">here</a>
		</h4>
		
		<h4>
			New Address Register <a href="addAddress">here</a>
		</h4>
		
	</div>
</body>
</html>