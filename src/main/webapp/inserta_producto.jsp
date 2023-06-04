<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>inserta productos</title>
</head>
<body>


<h1 style="text-align:center"> Insertar Registros</h1>

<!--con el get en el action al controlador (servlet) le decimos que en el metodo doget de controlador
liste lo que encuentre en la base de datos  -->

<form  name="form" method="get" action="Controlador">


<!--junto a la informacion que escriba el usuario en el formulario, tambien viajará una instruccion invisible con nombre "instruc" con el valor 
"insertarDatos" para que yo pueda a traves de un condicional if poder insertar datos si le llego informacion del formulario o listar en el caso de que
no le haya llegado ninguna informacion   -->


<input type="hidden" name="instruc" value="inserta">



<table width="50%" border="0">







<tr>
<td width="27%"> Codigo Articulo </td>
<td width="73%"> <label for="Art"> </label>
<input type="text" name="Art" id="Art"> </td>

</tr>


<tr>
<td width="27%"> Nombre Articulo </td>
<td width="73%"> <label for="Nart"> </label>
<input type="text" name="Nart" id="Nart"> </td>

</tr>



<tr>
<td> Precio </td>
<td> <label for = "precio"> </label>
<input type="text" name="precio" id="precio"> </td>

</tr>



<tr>
<td width="27%"> Importado </td>
<td width="73%"> <label for="Imp"> </label>
<input type="text" name="Imp" id="Imp"> </td>

</tr>



<tr>
<td width="27%"> Fecha </td>
<td width="73%"> <label for="Fecha"> </label>
<input type="text" name="Fecha" id="Fecha"> </td>

</tr>



<tr>
<td width="27%"> Pais de Origen </td>
<td width="73%"> <label for="Pais"> </label>
<input type="text" name="Pais" id="Pais"> </td>

</tr>



<tr>
<td width="27%"> Seccion</td>
<td width="73%"> <label for="Sec"> </label>
<input type="text" name="Sec" id="Sec"> </td>

</tr>



<tr>
<td width="27%"> Codigo Seguridad </td>
<td width="73%"> <label for="Cseg"> </label>
<input type="text" name="Cseg" id="Cseg"> </td>

</tr>













<tr>
 <td><input type="submit" name="insertar" id="insertar"     value= "Insertar"> </td>
  <td><input type="reset" name="borrar" value="borrar" value="Restablecer"> </td>



</tr>

</table>





</form>

</body>









</html>