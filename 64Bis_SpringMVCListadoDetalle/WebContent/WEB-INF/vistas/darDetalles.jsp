<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Detalle de Pelicula</h1>
	<table>
	<tr>
		<th>TITULO</th>
		<th>A�O</th>
		<th>RECAUDACION</th>
	</tr>
        <tr>
        <td>${param.titulo }</td>
        <td>${param.year }</td>
        <td>${param.recaudacion }</td>
        </tr>
	</table>
	<hr/>
	<input type="button" value="Volver a listado" onclick="location.href = 'volverListado'" />
</body>
</html>