<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrarse</title>

<style type="text/css">
h2{
	text-align: center;
	color: red;
}
</style>

</head>
<body>
	<h1 style="text-align: center;color:green;font-family: bookman old style">Bienvenido al registro</h1>
	<h2 style="color:red">${param.error}</h2>
	<form action="doRegistro" method="post">
		Usuario: <input type="text" name="usuario"/>
		<br/>
		Contraseña: <input type="password" name="password"/>
		<br/>
		Nombre: <input type="text" name="nombre"/>
		<br/>
		Direccion: <input type="text" name="direccion"/>
		<br/>
		Email: <input type="text" name="email"/>
		<br/>
		Telefono: <input type="text" name="telefono"/>
		<br/>
		<hr/>

		<input type="submit" value="Enviar">
	</form>

	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
</body>
</html>