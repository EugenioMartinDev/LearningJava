<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- podemos acceder de varias maneras a los atributos
	y a los parametros 
	
	La primera seria via scriptler, que se usa menos, se considera
	ya un poco deprecated(obsoleta)
	-->
	
	<%
		//así accdemos a los parametros
		String nombreParametro = request.getParameter("nombre");
		String pesoParametro = request.getParameter("peso");
		
		//asi accedemos a los atributos
		Double l = (Double)request.getAttribute("l");
		String n = (String)request.getAttribute("n");
	%>
	Nombre: <%=n %>
	<br/>
	Peso en kilos: <%=pesoParametro %>
	<br/>
	Peso en libras: <%=l %>
	<br/>
	
	<!-- Segunda manera, que es la que quiero que useis 
		se llama JSP Expresion Language
		${EXPRESION}
	-->
	<hr/>
	Nombre: ${n}
	<br/>
	Peso en libras: ${l}
	<br/>
	Peso en kilos: ${param.peso}
	<br/>
	<h2>Pintamos el objeto persona</h2>
	${persona}
	<h3>Pintamos la persona por partes</h3>
	<!-- si queremos pintar el nombre tiene que existir el get
		en la clase, porque es el que invocará
	 -->
	nombre: ${persona.nombre }
	<br/>
	peso en kilos: ${persona.pesoKilos }
	<br/>
	peso en libras: ${persona.pesoLibras }
		
</body>
</html>