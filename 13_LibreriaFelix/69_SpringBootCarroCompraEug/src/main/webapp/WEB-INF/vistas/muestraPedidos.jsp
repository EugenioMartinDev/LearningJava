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
	<h1>Listado de Productos</h1>
	
	<c:forEach items="${listaPedidos}" var="p">
		<form action="tratarPedido">
			<input type="text" name="nombre" value="${p.nombre }" readonly="readonly"/>
			<input type="text" name="precio" value="${p.precio }" readonly="readonly"/> 
			<input type="number" step=1 name="unidades" value="${p.unidades }"/>
			</br>
			<input type="submit" value="Añadir"/>
		</form>		
	</c:forEach>
	<a href="generarPedido">Generar el Pedido</a>
</body>
</html>