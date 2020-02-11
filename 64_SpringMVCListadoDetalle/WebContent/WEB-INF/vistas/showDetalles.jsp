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
	<h1>Listado de Detalle de Peliculas</h1>
	<table>
		<tr>
			<th>IDENTIDAD</th>
			<th>TITULO</th>
			<th>YEAR</th>
			<th>RECAUDACION</th>
		</tr>
        <tr>
          	<td>${pelicula.id}<td>
			<td>${pelicula.titulo}<td>
			<td>${pelicula.year}<td>
			<td>${pelicula.recaudacion}<td>
        </tr>
	</table>
	<hr/>
	<input type="button" value="Ir a listado de peliculas" onclick="location.href = 'altaPeliculas'" />
	<hr/>
	<input type="button" value="Salir" onclick="location.href = 'pepe'" />
</body>
</html>