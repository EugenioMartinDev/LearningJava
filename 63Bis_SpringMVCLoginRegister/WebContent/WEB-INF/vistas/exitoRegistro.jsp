<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Existo De Registro</title>
</head>
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
  height: 300px;
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

<body>
<div class="grid-container">
	<div>
		<h1>Bienvenido/a ${param.usuario }</h1>
		<hr/>
		<h2>${param.mensaje}</h2>
	</div>

	<hr/>
	<div>
		<input type="button" value="Login" onclick="location.href = 'login'" />
	</div>
</div>
</body>
</html>