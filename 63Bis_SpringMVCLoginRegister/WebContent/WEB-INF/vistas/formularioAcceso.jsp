<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario de Acceso</title>

<style type="text/css">
h2{
	text-align: center;
	color: red;
}

.item1 { grid-area: header; }
.item2 { grid-area: menu; }
.item3 { grid-area: main; }
.item4 { grid-area: right; }
.item5 { grid-area: footer; }
.item6 { grid-area: dummy; }

.grid-container {
  display: grid;
  grid-template-areas:
    'header header header header header header'
    'menu menu main main right right'
    'menu menu footer footer right right';
  grid-gap: 2px;
  background-color: #2196F3;
  padding: 2px;
}

.grid-container > div {
  background-color: rgba(255, 255, 255, 0.8);
  text-align: center;
  padding: 20px 0;
  font-size: 20px;
}

.center {
  margin: auto;
  width: 60%;
  border: 1px solid black;
  padding: 10px;
  }

</style>

</head>
<body>

<div class="grid-container">
	<div class="item1">
		<h1 style="background-color:DodgerBlue;text-align: center;color:white;font-family: bookman old style">Bienvenidos/as a nuestra WEB </h1>
		<h2 style="color:red">${param.error}</h2>
	</div>
	<div class="item2" style="background-color:white">
		<img src="../imagenes/locked.jpg" alt="LOGIN Icon" style="width:400px;height:200px">
	</div>
	<div class="item3" style="align-items center;">
		
		<form action="doLogin" method="post">
			<div class="center">
			<table>
				<tr>
					<td>Usuario</td>
					<td><input type="text" name="usuario"/></td>
				</tr>
				<tr>
					<td>Contraseña</td>
					<td><input type="password" name="password"/></td>
				</tr>
				
			</table>
			</div>
	
			<br/>
			
			<hr/>
	
			<input type="submit" value="Enviar">
		</form>

	</div>
	<div class="item4" style="background-color:white">
		<img src="../imagenes/login.jpg" alt="LOGIN Icon" style="width:auto;">
	</div>
	<div class="item5">
		<input type="button" value="Registrarse" onclick="location.href = 'registrarse'" />
	</div>
</div>

	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
</body>
</html>