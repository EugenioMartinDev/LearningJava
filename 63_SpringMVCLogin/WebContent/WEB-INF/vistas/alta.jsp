<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Bienvenidos a nuestro registro</h1>
	<form action="doAlta">
	Nombre: <input type="text" name="nombre"/>
	<br/>
	Password: <input type="password" name="pass"/>
	<br/>
	email: <input type="text" name="email"/>
	<br/>
	Direccion: <input type="text" name="direccion"/>
	<br/>
	<input type="submit" value="Enviar"/>
	</form>
</body>
</html>