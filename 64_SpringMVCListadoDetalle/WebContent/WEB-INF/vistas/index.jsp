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
	
	<p>Elija listar el directorio de pel�culas o dar de alta una nueva pel�cula</p>
	
	<a href="listado">Listado de pel�culas</a>
	
	<br/>
	
	<a href="altaPeliculas">Alta de pel�culas</a>
	
</body>
</html>