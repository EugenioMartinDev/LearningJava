<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bienvenida</title>
</head>
<body>
<div style="text-align: center;">
	<h1>Bienvenido ${param.usuario }</h1>
	<h2>${param.mensaje }</h2>
	<hr/>
</div>
</body>
</html>