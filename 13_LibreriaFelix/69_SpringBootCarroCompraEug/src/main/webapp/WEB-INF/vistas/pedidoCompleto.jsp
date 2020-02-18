<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pedidos</title>
</head>
<style type="text/css">
  table{
    margin-left:auto; 
    margin-right:auto;
  }
  
table.border {
  border: 1px solid black;
}

table.border th {
  border: 1px solid black;
}

table.border td {
  border: 1px solid black;
}

table.border tbody {
	height: 300px;
	width: 100%;
    overflow-y: auto;
    overflow-x: auto;
}
</style>
<body>
	<h1 style="text-align: center;">Pedido Generado</h1>
	
		<h4>Usuario: ${usuario.nombre }</h4>
		<br/>
		<h4>Domicilio: ${usuario.direccion }</h4>
		<br/>
		
		<table class="border">
			<tr>
				<th>Nombre</th>
				<th>Precio Unitario</th>
				<th>Unidades</th>
				<th>Precio</th>	
			</tr>
			<c:forEach items="${listaProductos}" var="p">
				<tr>
					<td><c:out value="${p.nombre}"></c:out></td>
					<td><c:out value="${p.precio}"></c:out></td>
					<td><c:out value="${p.unidades}"></c:out></td>
					<td><c:out value="${p.unidades*p.precio }"></c:out></td>
				</tr>
			</c:forEach>
		</table>
		<br/>
		<h4>Importe: ${pedido.importe }</h4>
		<br/>
		
	<a href="aceptar">Aceptar el Pedido</a>
	<br/>
	<a href="cancelar">Cancelar el Pedido</a>
</body>
</html>