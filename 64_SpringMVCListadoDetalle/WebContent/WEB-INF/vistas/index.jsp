<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Bienvenido a su escritorio!!! ${param.usuario }</h1>
	<h2>${param.mensaje }</h2>
	
	<p>Elija listar el directorio de películas o dar de alta una nueva película</p>
	
	<a href="listado">Listado de películas</a>
	
	<br/>
	
	<a href="altaPeliculas">Alta de películas</a>
	
</body>
</html>