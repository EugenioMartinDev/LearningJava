<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Listado de peliculas del usuario ${param.nombre }</h1>
	<table>
      <c:forEach items="${param.listaPeliculas}" var="pelicula">
        <tr>
          <td>"${pelicula.titulo}"<td>
          <td><a href="detalle?${pelicula.id }">Detalle<a/><td>
        </tr>
      </c:forEach>
	</table>
</body>
</html>