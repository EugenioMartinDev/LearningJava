<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="text-align: center;">
	<h1>RESUMEN DEL PEDIDO</h1>
	<hr/>
	<table style="margin-left: auto;margin-right: auto;" border="1">
		<tr>
			<td>Nombre:</td>
			<td>${param.nombre }</td>
		</tr>
		<tr>
			<td>Direccion:</td>
			<td>${param.direccion }</td>
		</tr>
		<tr>
			<td>Email:</td>
			<td>${param.email }</td>
		</tr>
		<tr>
			<td>Ram:</td>
			<td>${param.ram }</td>
		</tr>
		<tr>
			<td>Procesador:</td>
			<td>${param.procesador }</td>
		</tr>
		<c:forEach items="${paramValues.listaPerifericos}" 
			 	var="periferico" varStatus="i">
             	<tr>
             		<td>Periferico ${i.count}</td>
                	<td>${periferico}</td>
                </tr>
             </c:forEach>
		<tr>
			<td>Comentarios del cliente:</td>
			<td>${param.comentario }</td>
		</tr>
	</table>
</div>
</body>
</html>