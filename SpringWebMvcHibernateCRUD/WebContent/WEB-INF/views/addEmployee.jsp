<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Spring MVC Form Handling</title>
	</head>
	<body>
		<h2>Add Employee Data</h2><span>${msg}</span>
		
		<h1>Message : ${message}</h1>
		
		<form action="/SpringWebMvcHibernateCRUD/save" method="post">
		<input type="hidden" name="id" value="${employee.id}" />
		 <table>
		  <tr>
		   <td>Name: </td><td><input type="text" name="name" value="${employee.name}" /></td>
		  </tr>
		   <tr>
		   <td>Age: </td><td><input type="text" name="age" value="${employee.age}" /></td>
		  </tr>
		    <tr>
		   <td>Address: </td><td><input type="text" name="address" value="${employee.address}" /></td>
		  </tr>
		    <tr>
		   <td>salary: </td><td><input type="text" name="salary" value="${employee.salary}"/></td>
		  </tr>
		  
		    <tr>
		   <td></td>
		   <td><input type="submit" value="Submit"/></td>
		  </tr>
		 </table>
		</form>
	</body>
</html>