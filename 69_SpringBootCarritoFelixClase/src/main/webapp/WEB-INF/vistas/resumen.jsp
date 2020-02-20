<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<style type="text/css">
  table {
    margin-left:auto; 
    margin-right:auto;
  }

</style>
<body>
	<h1>Bienvenido usuario ${usuario.nombre}!!</h1>
	<table>
		<tr>
			<th>id</th>
			<th>nombre</th>
			<th>precio</th>
		</tr>
		<c:forEach items="${usuario.pedido.listaProductos}" var="p">
			<tr>
				<td>${p.id}</td>
				<td>${p.nombre}</td>
				<td>${p.precio}</td>
			</tr>
		</c:forEach>
	</table>
	<h3 style="color:red">Precio total de la compra ${usuario.pedido.precioTotal }</h3>
	
</body>
</html>