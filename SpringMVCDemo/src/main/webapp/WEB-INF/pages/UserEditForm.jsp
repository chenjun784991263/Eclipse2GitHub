<%@page import="niit.model.User"%>
<%@page import="java.util.List"%>
<%@page import="niit.model.Address"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c1" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New User</title>
</head>
<body>
    
    <div align="center">
        <h1>Edit User</h1>
        <c1:form action="saveUser" method="post" modelAttribute="user">
        <table>
            <c1:hidden path="id"/>
            <tr>
                <td>Name:</td>
                <td><c1:input path="name" /></td>
            </tr>
            <tr>
                <td>PassWord:</td>
                <td><c1:input path="password" /></td>
            </tr>
            <tr>
                <td>Gender:</td>
                <td><c1:input path="gender" /></td>
            </tr>
            <tr>
                <td>Age:</td>
                <td><c1:input path="age" /></td>
            </tr>
               <tr>
                <td>PhoneNumber:</td>
                <td><c1:input path="phonenumber" /></td>
            </tr>
               <tr>
                <td>AddressId:</td>
                <td>
                  <c1:select path="addressid">

 

  <c:forEach var="address" items="${addresslist}">
  
  	<option value="${address.id}" <c:if test="${address.id eq user.addressid}"> selected </c:if>>${address.province}/${address.city}/${address.town}</option>
   
  </c:forEach>
</c1:select>
               </td>
               
            </tr>
            
            
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </c1:form>
    </div>
</body>
</html>