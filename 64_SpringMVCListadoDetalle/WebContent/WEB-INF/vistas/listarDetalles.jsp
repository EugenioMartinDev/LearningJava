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
	<h1>Listado de peliculas del usuario</h1>
	<table>
      <c:forEach items="${listaPeliculas}" var="idTitulo">
        <tr>
          <td>${idTitulo[1]}<td>
          <td><a href="detalle?id=${idTitulo[0] }">Detalle<a/><td>
        </tr>
      </c:forEach>
	</table>
		<hr/>
	<input type="button" value="Ir a incluir nuevas peliculas" onclick="location.href = 'listadoPeliculas'" />
	<hr/>
	<input type="button" value="Salir" onclick="location.href = 'pepe'" />
</body>
</html>