<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Creacion de una nueva pelicula en el directorio</h1>
	<form action="doAltaPelicula">
	Titulo: <input type="text" name="titulo"/>
	<br/>
	A�o: <input type="text" name="year"/>
	<br/>
	Recaudacion: <input type="number" name="recaudacion"/>
	<br/>
	<input type="submit" value="Enviar"/>
	</form>
</body>
</html>