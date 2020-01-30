<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" content="width=device-width, initial-scale=1.0">
<!-- Ejempo de incluir ccs : in block -->
<style type="text/css">
h1{
	text-align: center;
	font-family: "courier";
}
h3{
	text-align: left;
	font-family: "ariel";
}

input[type=text], input[type=radio], input[type=checkbox], select {
  width: 15%;
}

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

div.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}

.grid-container {
	display: grid;
	grid-template-columns: auto auto auto;
	background-color: powderblue;
	padding: 10px;
	height: 600px;
	align-content: center;
}

.grid-item {
	text-align: center;
}

.grid-item2 {
	text-align: left;
}

</style>
<title>Formulario 3</title>
</head>
<body>

<div class="container">	
	<div class="grid-item"></div>
	<div class="grid-item">
		<h1>BIENVENIDO A NUESTRA TIENDA DE ORDENADORES</h1>
	</div>
	<div class="grid-item"></div>
	<div class="grid-item"></div>	
	<div class="grid-item2">
	<form action="PcForm" method="post">
		<!-- Botón de radio -->
		Nombre: <input type="text" name="nombre" required="required"/>
		<br/>Titulo: <input type="text" name="direccion" required="required"/>
		<br/>Email: <input type="email" name="email"/>
		<br/><h3>Elija el modelo de ordenador</h3>
		<br/>Modelo: <input type="radio" name="modelo" value="Junior" required/>Juvenil			
		<br/>Modelo: <input type="radio" name="modelo" value="Familiar"/>Para toda la familia
		<br/>Modelo: <input type="radio" name="modelo" value="Standard"/>Trabajo
		<br/>Modelo: <input type="radio" name="modelo" value="Game"/>Juegos
		<br/>Modelo: <input type="radio" name="modelo" value="Professional"/>Desarrollo y Diseño
		<!-- Botón de selección -->
		<br/><h3>Elija el procesador</h3>
		<br/><select name="procesador" required autofocus>
			<option value="">None</option>
			<option value="1">INTEL 1</option>
			<option value="2">AMD 1</option>
			<option value="3">INTEL 2</option>
			<option value="4">AMD 2</option>
			<option value="5">INTEL 3</option>
			<option value="6">AMD 3</option>
		</select>
		<!-- Botón de selección -->
		<br/><h3>Elija la memoria RAM</h3>
		<br/><select name="memoria" required autofocus>
			<option value="">None</option>
			<option value="1">2 MB</option>
			<option value="2">4 MB</option>
			<option value="3">8 MB</option>
			<option value="4">16 MB</option>
			<option value="5">32 MB</option>
		</select>
		<!-- Botón de chequeo -->
		<br/><h3>Elija los dispositivos</h3>
		<!-- También se puede requerir este checkbox con required -->
		<br/><input type="checkbox" name="devices" value="printer"/>Impresora
		<br/><input type="checkbox" name="devices" value="mouse"/>Ratón
		<br/><input type="checkbox" name="devices" value="cooler"/>Refrigeración
		<br/><input type="checkbox" name="devices" value="screen"/>Pantalla
		<!-- Area de texto -->
		<h3>Comentarios adicionales</h3>
			<textarea rows="5" cols="80" name="comentarios"></textarea>				
		<br/><input type="submit" value="Enviar"/>
	</form>
	</div>
	<div class="grid-item"></div>
</div>
</body>
</html>