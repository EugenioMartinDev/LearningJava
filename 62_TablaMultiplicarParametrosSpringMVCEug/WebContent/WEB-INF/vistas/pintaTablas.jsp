<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1"
	content="width=device-width, initial-scale=1.0">
<style> 
/* #grad1 {
	background-color: powderblue;
	/ For browsers that do not support gradients /
	background-image: linear-gradient(deepskyblue, powderblue);
	/ Standard syntax (must be last) /
*/
.item1 {
	grid-area: cabecera1;
	content="width=device-width, initial-scale=1.0";
}

.item2 {
	grid-area: cabecera2;
	content="width=device-width, initial-scale=1.0";
}

.item3 {
	grid-area: tabla1;
	content="width=device-width, initial-scale=1.0";
}

.item4 {
	grid-area: tabla2;
	content="width=device-width, initial-scale=1.0";
}

.grid-container {
	display: grid;
	grid-template-areas: 'cabecera1 cabecera2'
						'tabla1 tabla2';
	content="width=device-width, initial-scale=1.0";
}

</style>
<title>Insert title here</title>
</head>
<body id="grad1">

	<div class="grid-container">
		<div class="item1">

		 <h3>tabla del número : ${tabla1.numero}</h3>		 
		  </div>
		  <div class="item3">
		  <table border="1">
		    <c:forEach var="operacion" items="${tabla1.tablaMultiplicar}" varStatus="status">
	            <tr>
	            	<td><c:out value="${tabla1.numero}"/></td>
	            	<td>&nbsp; * &nbsp;</td>
	            	<td>${status.count }</td>
	            	<td>=</td>
	                <td><c:out value="${operacion}"/></td>
	            </tr>
        	</c:forEach>
		  </table>
		  </div>
		  
		  <div class="item2">
		  <h3>tabla del número : ${tabla2.numero}</h3>		 
		</div>
		<div class="item4">
		  <table border="1">
		    <c:forEach var="operacion" items="${tabla2.tablaMultiplicar}" varStatus="status">
	            <tr>
	            	<td><c:out value="${tabla2.numero}"/></td>
	            	<td>&nbsp; * &nbsp;</td>
	            	<td>${status.count }</td>
	            	<td>=</td>
	                <td><c:out value="${operacion}"/></td>
	            </tr>
        	</c:forEach>
		  </table>
		  </div>
	 </div>
		 
</body>
</html>