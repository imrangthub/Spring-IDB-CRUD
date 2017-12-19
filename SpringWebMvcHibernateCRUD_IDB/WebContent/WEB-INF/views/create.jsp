<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create | Product</title>
</head>
<body>
<div style="width: 200px; margin:auto">
 <div style="color:green;">
  ${successMsg}
 </div>
 <div style="color:red;">
  ${errorMsg}
 </div>
</div>

<div style="width: 400px; margin:auto; margin-top:200px;">
	<form action="/SpringWebMvcHibernateCRUD_IDB/add" method="post">
		<input type="hidden" name="id" value="${product.id}" />
		 <table>
		  <tr>
		   <td>Product Name: </td><td><input type="text" name="productName" value="${product.productName}" /></td>
		  </tr>
		   <tr>
		   <td>Description: </td><td><input type="text" name="description" value="${product.description}" /></td>
		  </tr>
		    <tr>
		   <td>Price: </td><td><input type="text" name="price" value="${product.price}" /></td>
		  </tr>
		    <tr>
		   <td>Quantity: </td><td><input type="text" name="qty" value="${product.qty}"/></td>
		  </tr>
		  
		    <tr>
		   <td></td>
		   <td><input type="submit" value="Submit"/></td>
		  </tr>
		 </table>
		</form>
</div>



</body>
</html>