<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Bienvenidos a nuestra pagina web</h1>
	<h3 style="color:blue">${param.mensaje }</h3>
	<h3 style="color:red">${param.error }</h3>
	<form action="doLogin">
	Nombre: <input type="text" name="nombre"/>
	<br/>
	Password: <input type="password" name="pass"/>
	<br/>
	<input type="submit" value="Enviar"/>
	</form>
	<br>
	<a href="mostrarAlta">¿Quiere registrarse?</a>
</body>
</html>