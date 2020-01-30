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
		 	String nombre = request.getParameter("nombre");
		 	String direccion = request.getParameter("direccion");
		 	String email = request.getParameter("email");
		 	String modelo = request.getParameter("modelo");
		 	String procesador = request.getParameter("procesador");
		 	String memoria = request.getParameter("memoria");
		 	String comentario = request.getParameter("comentarios");
		 	String[] devices = request.getParameterValues("devices");
		 
		 	// Así accedemos a los atributos con scriptler
		 	// String pedido = (String) request.getAttribute("nombre");

		 	
		 	
		 %>
		 Nombre : <%=nombre %>
		 <br/> direccion : <%=direccion %>
		 <br/> email : <%=email %>
		 <br/> modelo : <%=modelo %>
		 <br/> procesador : <%=procesador %>
		 <br/> memoria : <%=memoria %>
		 <br/> comentario : <%=comentario %>
		 <br/> email : <%=email %>
		 <h4>Tabla de Dispositivos</h4>
	
		 <table>
		 <%
			for(int i=1;i<devices.length;i++){
		 %>
			<tr>
				<td>Dispositivo <td>
				<td>=<td>
				<td><%=devices[i]%><td>
			</tr>
		 <%
			}
		 %>
		</table>
		 
		 <hr/>
		 <!-- Modo 2 : JSP Expression Language  ${EXPRESSION} -->

		 Nombre : ${param.nombre}
		 <br/>
		 Direccion : ${param.direccion}
		 <br/>
		 Email : ${param.email}
		 
		 <!-- Se ejecuta el método toString de la clase Persona -->
		 <h2>Pintamos objeto pedido</h2>
		 ${pedido}
		 
		  <hr/>
		 
		 <!--  Notacion javaBean . Se pone el nombre del atributo en la clase pues se va a ejecutar el get  -->
		 <h3>Pintamos pedido por partes</h3>
		 nombre: ${pedido.nombre}
		 <br/>
		 direccion : ${pedido.direccion}
		 <br/>
		 email : ${pedido.email}
		 </br>
		 <h4>Ordenador pedido</h4>
		 modelo : ${pedido.pc.modelo}
		 </br>
		 procesador : ${procesador}
		 </br>
		 memoria : ${memoria}
		  </br>
		 dispositivos : ${listaDispositivos}
		  </br>
		 comentarios : ${pedido.comentario}
		 
		  <hr/>
		 
</body>
</html>