<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario de Registro</title>

<style type="text/css">
h2{
	text-align: center;
	color: red;
}

table, th, td {
  text-align: left;
}
.grid-container {
  grid-gap: 2px;
  background-color: #2196F3;
  padding: 2px;
  height: 500px;
}

.grid-container > div {
  background-color: rgba(255, 255, 255, 0.8);
  text-align: center;
  padding: 20px 0;
  font-size: 20px;
}

.center {
  margin: auto;
  width: 30%;
  border: 1px solid black;
  padding: 10px;
  }

</style>

</head>
<body>
<div class="grid-container">
	<div class="item1">
		<h1 style="background-color:DodgerBlue;text-align: center;color:white;font-family: bookman old style">Registro de Datos</h1>
		<h2 style="color:red">${param.error}</h2>
	</div>
	<div class="item3" style="align-items center;">
		<form action="doRegistro" method="post">
			<div class="center">
				<table style="border: 0px solid black;">
					<tr>
						<td>Usuario</td>
						<td><input type="text" name="usuario" size="35"/></td>
					</tr>
					<tr>
						<td>Contraseña</td>
						<td><input type="password" name="password" size="35"/></td>
					</tr>
					<tr>
						<td>Nombre</td>
						<td><input type="text" name="nombre" size="35"/></td>
					</tr>
					<tr>
						<td>Direccion</td>
						<td><input type="text" name="direccion" size="60"/></td>
					</tr>
					<tr>
						<td>Email</td>
						<td><input type="email" name="email" size="50"/></td>
					</tr>
					<tr>
						<td>Telefono</td>
						<td><input type="text" name="telefono" size="9"/></td>
					</tr>					
				</table>
			</div>
	
			<br/>
			
			<hr/>
	
			<input type="submit" value="Enviar">
		</form>	
	</div>
</div>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
</body>
</html>