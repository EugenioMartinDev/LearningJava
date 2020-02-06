<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
h2{
	text-align: center;
	color: red;
}
</style>

</head>
<body>
	<h1 style="text-align: center;color:green;font-family: bookman old style">Bienvenidos a nuestros formularios </h1>
	<h2 style="color:red">${param.error}</h2>
	<form action="doLogin" method="post">
		Usuario: <input type="text" name="usuario"/>
		<br/>
		Contraseña: <input type="password" name="contraseña"/>
		<br/>
		
		<hr/>

		<input type="submit" value="Enviar">
	</form>
	
	<input type="button" value="Registrarse" onclick="location.href = 'registrarse'" />
	
	
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
</body>
</html>