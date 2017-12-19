<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Product List</h1>

<a href="/SpringWebMvcHibernateCRUD_IDB/create">Add Product</a>


<div style="width:500px; margin:auto">
<c:if test="${!empty products}">
	<table align="left" border="1">
		<tr>
			<th>Product ID</th>
			<th>Product Name</th>
			<th>Description</th>
			<th>Product price</th>
			<th>Product Quantity</th>
			<th> Action </th>
		</tr>

		<c:forEach items="${products}" var="product">
			<tr>
				<td><c:out value="${product.id}"/></td>
				<td><c:out value="${product.productName}"/></td>
				<td><c:out value="${product.description}"/></td>
				<td><c:out value="${product.price}"/></td>
				<td><c:out value="${product.qty}"/></td>
				<td>
				<a href="edit/${product.id}"> Edit</a> | 
				<a href="delete/${product.id}">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</c:if>
</div>


</body>
</html>