<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>bienvenido</title>
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
  height: 100px;
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
		<h1>Bienvenido/a </h1>${param.usuario}
		<hr/>
	</div>
</div>
</body>
</html>