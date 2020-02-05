<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
	<h1>Bienvenido </h1>${usuario}
	<hr/>
	<a href="ServletDetalle?usuario=${usuario }" title="Detalle">Detalle></a>
</center>
</body>
</html>