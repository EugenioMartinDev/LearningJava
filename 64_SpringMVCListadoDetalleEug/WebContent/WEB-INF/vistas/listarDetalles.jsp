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
  border: 1px solid black;
  width: 25%;
}


</style>
<body>
	<h1>Listado de peliculas</h1>
	<hr/>
	<input type="button" value="Volver a usuario" onclick="location.href = 'volverUsuario'" />
	<hr/>
	<input type="button" value="Volver a alta de pelicula" onclick="location.href = 'volverAltaPelicula'" />
	<hr/>
	<table>
      <c:forEach items="${listaPeliculasBase}" var="peliculaBase">
        <tr>
          <td>${peliculaBase.titulo}</a><td>
          <td><a href="detalle?identity=${peliculaBase.id }">Detalle<a/><td>
        </tr>
      </c:forEach>
	</table>
</body>
</html>