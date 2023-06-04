<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix= "c" %>
    
    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


<style type="text/css">


.head{


font-size: 1.2em;
font-weight:bold;
color:white;
background-color:#456EE6  ;


}





.filas{


text-align:center;
background-color: #F18308  ;


}


table{


float:left;



}


#contenedorBoton{


margin-left: 1000px;



}








</style>










</head>
















<body>



  


















<table>





























<td  class= "head"> Codigo Articulo </td>
<td>
<td>
<td>
<td>
<td  class= "head"> Seccion </td>
<td>
<td>
<td>
<td>
<td  class= "head"> Nombre de articulo </td>
<td>
<td>
<td>
<td>

<td  class= "head"> Precio </td>
<td>
<td>
<td>
<td>
<td  class= "head"> Importado </td>
<td>
<td>
<td>
<td>
<td  class= "head"> Fecha</td>
<td>
<td>
<td>
<td>
<td  class= "head"> Pais de Origen </td>
<td>
<td>
<td>
<td>
<td  class= "head">Codigo de Seguridad </td>
<td>
<td>
<td>
<td>
<td  class= "head"> Accion </td>

<tr>

<tr>


<c:forEach var="tempProd" items= "${LISTAPRODUCTOS}"> 
	
	
<!-- Link para cada producto con su campo clave con el nombre de tempProd -->	



<c:url var= "linkTemp" value="Controlador">
<!-- linkTemp es el nombre que identifica a la clase controlador -->	


<c:param name="instruc" value="cargar"> </c:param>

<c:param name="CArtic" value="${ tempProd.idArtic }"></c:param>
<!-- parametros instruc para cargar datos y CArtic para traerlos de la clase productos -->	


</c:url>



<!-- link para eliminar cada registro con su campo clave -->


	
	<c:url var= "linkTempElim" value="Controlador">



<c:param name="instruc" value="eliminar"> </c:param>

<c:param name="CArtic" value="${ tempProd.idArtic }"></c:param>

<!-- ${ tempProd.idArtic } se mantiene igual, ya que se pasara a la variable parametro Cartic y se enviara al controlador con el codigo articulo-->





</c:url>
	
<tr>




<td class= "filas">${ tempProd.idArtic }</td>
<td>
<td>
<td>
<td>
<td class= "filas">${ tempProd.seccion}</td>
<td>
<td>
<td>
<td>
<td class= "filas">${ tempProd.nombreArt }</td>
<td>
<td>
<td>
<td>
<td class= "filas">${ tempProd.precio }</td>
<td>
<td>
<td>
<td>
<td class= "filas">${ tempProd.importado }</td>
<td>
<td>
<td>
<td>
<td class= "filas">${ tempProd.fecha }</td>
<td>
<td>
<td>
<td>
<td class= "filas">${ tempProd.pOrig }</td>
<td>
<td>
<td>
<td>
<td class= "filas">${ tempProd.codSeg }</td>
<td>
<td>
<td>
<td>
<td class= "filas"> <a href="${linkTemp}"> Actualizar </a>&nbsp;  <a href="${linkTempElim}"> Eliminar </a>  </td>	

<!-- en el link de la clase controlador (linkTemp), viajan 2 parametros: value="cargar" para cargar los registros y  ${tempProd.idArtic} para traer los registros  -->
<!-- el cargar inserta campos nuevos, pero en el caso de no hacerlo, trae los registros ya existentes gracias a ${tempProd.idArtic}-->


<!-- le agregamos la funcion eliminar que vendra en linkTempElim-->

<!-- con &nbsp (no breaking space) creamos un espacio horizontal -->

</c:forEach>

<tr>
</tr>


<tr>
</tr>


<tr>
</tr>



<tr>



<td id="contenedorBoton">


<input style="background-color:   #06BF0F;

font-weight:bold;

width:170px; height:50px;

"

type="button" value="INSERTAR REGISTRO" onClick=" window.location.href= 'inserta_producto.jsp' "/>


</td>




<tr>




</table>





<!-- 
<div id="contenedorBoton">


<input type="button" value="Insertar Registro" onClick=" window.location.href= 'inserta_producto.jsp' "/> </div>
-->


<!-- 
<h1 id="contenedorBoton">




<input type="button" value="Insertar Registro" onClick=" window.location.href= 'inserta_producto.jsp' "/>





</h1>

-->





	
	
	






























</body>
















</html>