<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Actualizar registros</title>
</head>
<body>


<h1 style="text-align:center"> Actualizar registros</h1>



<form  name="form" method="get" action="Controlador">




<input type="hidden" name="instruc" value="actualizar">

<input type="hidden" name="Art" value="${ProdAct.idArtic}">



<table width="50%" border="0">









<tr>
<td width="27%"> Nombre Articulo </td>
<td width="73%"> <label for="Nart"> </label>
<input type="text" name="Nart" id="Nart" value="${ProdAct.nombreArt}"> </td>

</tr>



<tr>
<td> Precio </td>
<td> <label for = "precio"> </label>
<input type="text" name="precio" id="precio" value="${ProdAct.precio}"> </td>

</tr>



<tr>
<td width="27%"> Importado </td>
<td width="73%"> <label for="Imp"> </label>
<input type="text" name="Imp" id="Imp" value="${ProdAct.importado}"> </td>

</tr>



<tr>
<td width="27%"> Fecha </td>
<td width="73%"> <label for="Fecha"> </label>
<input type="text" name="Fecha" id="Fecha" value="${ProdAct.fecha}"> </td>

</tr>



<tr>
<td width="27%"> Pais de Origen </td>
<td width="73%"> <label for="Pais"> </label>
<input type="text" name="Pais" id="Pais" value="${ProdAct.pOrig}"> </td>

</tr>



<tr>
<td width="27%"> Seccion</td>
<td width="73%"> <label for="Sec"> </label>
<input type="text" name="Sec" id="Sec" value="${ProdAct.seccion }"> </td>

</tr>



<tr>
<td width="27%"> Codigo Seguridad </td>
<td width="73%"> <label for="Cseg"> </label>
<input type="text" name="Cseg" id="Cseg" value="${ProdAct.codSeg}"> </td>

</tr>













<tr>
 <td><input type="submit" name="actualiza" id="actualiza"     value= "actualizar"> </td>
  <td><input type="reset" name="borrar" value="borrar" value="Restablecer"> </td>



</tr>

</table>


</form>

</body>









</html>