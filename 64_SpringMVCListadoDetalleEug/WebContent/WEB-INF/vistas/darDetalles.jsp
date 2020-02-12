<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
table {
  border-collapse: collapse;
  width: 100%;
}

table, td, th {
  border: 1px solid black;
}

th {
  height: 50px;
}
</style>
<body>
	<h1>Detalle de Pelicula</h1>
	<table>
	<tr>
		<th>TITULO</th>
		<th>AÑO</th>
		<th>RECAUDACION</th>
	</tr>
        <tr>
        <td>${pelicula.titulo }</td>
        <td>${pelicula.year }</td>
        <td>${pelicula.recaudacion }</td>
        </tr>
	</table>
	<hr/>
	<input type="button" value="Volver a listado" onclick="location.href = 'volverListado'" />
</body>
</html>