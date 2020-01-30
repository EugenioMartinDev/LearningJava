<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- Podemos acceder de varias maneras a los atributos y a los parámetros.
		 El objeto request es accesible con la referencia request.
		 1.- Vía scriptler, que se usa menos.
		 2.- Vía JSP Expresion Language -->
		 
		 <!-- Modo 1 : Scriptler -->
		 <%
		 	// Así accedemos a los parámetros con scriptler
		 	String nombreParametro = request.getParameter("nombre");
		 	String peso = request.getParameter("peso");
		 
		 	// Así accedemos a los atributos con scriptler
		 	Double libras = (Double) request.getAttribute("librasConvertidas");
		 	String nombre = (String) request.getAttribute("nombreUsuario");
		 	
		 	
		 %>
		 Nombre : <%=nombreParametro %>
		 <br/> Peso en kilos : <%=peso %>
		 <br/> Peso en libras : <%=libras %>
		 
		 <!-- Modo 2 : JSP Expression Language  ${EXPRESSION} -->
		 
		 <hr/>
		 Nombre : ${nombreUsuario}
		 <br/>
		 Peso en kilos : ${param.peso}
		 <br/>
		 Peso en libras : ${librasConvertidas}
		 
		 <!-- Se ejecuta el método toString de la clase Persona -->
		 <h2>Pintamos objeto persona</h2>
		 ${persona}
		 
		 <!--  Notacion javaBean . Se pone el nombre del atributo en la clase pues se va a ejecutar el get  -->
		 <h3>Pintamos persona por partes</h3>
		 nombre: ${persona.nombre}
		 <br/>
		 peso en kilos : ${persona.peso}
		 </br>
		 peso en libras : ${persona.libras}
		 
		 
		 
</body>
</html>