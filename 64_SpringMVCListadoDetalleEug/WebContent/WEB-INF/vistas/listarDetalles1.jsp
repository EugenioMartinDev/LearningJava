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
	<h1>Listado de peliculas</h1>
	<jsp:useBean id="listaPeliculas" class="directorio.modelo.entidad.listaPeliculas" scope="request" />
	<table>
      <c:forEach items="${listaPeliculas}" var="peliculaBase" varStatus="i">
        <tr>
        <td>${i.count }</td>
          <td>${peliculaBase.id}</a><td>
          <td><a href="detalle?identity=${peliculaBase.id }">Detalle<a/><td>
        </tr>
      </c:forEach>
	</table>
	<hr/>
	<input type="button" value="Volver a usuario" onclick="location.href = 'volverUsuario'" />
	<hr/>
	<input type="button" value="Volver a alta de pelicula" onclick="location.href = 'volverAltaPelicula'" />
</body>
</html>