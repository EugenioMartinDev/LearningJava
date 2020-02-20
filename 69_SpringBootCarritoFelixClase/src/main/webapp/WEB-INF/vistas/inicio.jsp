<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style type="text/css">
  table {
    margin-left:auto; 
    margin-right:auto;
  }

</style>
<body>
	<h1>Bienvenido usuario ${nombre}!!</h1>
	<table>
		<tr>
			<th>id</th>
			<th>nombre</th>
			<th>precio</th>
			<th>añadir</th>
		</tr>
		<c:forEach items="${listaProductos}" var="p">
			<tr>
				<td>${p.id}</td>
				<td>${p.nombre}</td>
				<td>${p.precio}</td>
				<td><a href="addProducto?id=${p.id}">Add carrito</a></td>
			</tr>
		</c:forEach>
	</table>
	<form action="pagar">
		<input type="submit" value="Pagar"/>
	</form>
	<hr/>
		<h2>Lista de productos seleccionados</h2>
		<table>
		<tr>
			<th>id</th>
			<th>nombre</th>
			<th>precio</th>
		</tr>
		<c:forEach items="${listaProductosSeleccionados}" var="p">
			<tr>
				<td>${p.id}</td>
				<td>${p.nombre}</td>
				<td>${p.precio}</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>