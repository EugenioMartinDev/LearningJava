<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>Detalle de ${u.nombre}</h1>
	</center>
	<table>
		<tr>
			<td>Nombre:</td>
			<td>${u.nombre}</td>
		</tr>
		<tr>
			<td>Edad:</td>
			<td>${u.edad}</td>
		</tr>
		<tr>
			<td>Peso:</td>
			<td>${u.peso}</td>
		</tr>
	</table>
	
	<a href="inicio.jsp?nombre=${u.nombre}">Volver a inicio</a>
</body>
</html>