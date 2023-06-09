package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import productos.Productos;

public class Modelo {
	
	
	private DataSource origenDatos;
	
	
	
	
	
	public Modelo(DataSource origenDatos) {
		
		this.origenDatos= origenDatos;
		
		
		
	}
	
	
	
	
	
	
	
	
	
	public List<Productos> getProductos() throws  Exception {
		
		List<Productos> prod = new ArrayList<>(); 
		
		
		Connection miConexion=null;
		
		Statement miStatement=null;
		
		ResultSet res = null;
		
		
		
		//----------establecer la conexion -------------------
		
		
		try {
		
		miConexion= origenDatos.getConnection();
		
		
		
		
		//---------crear la sentencia sql y el Statement------------------
		
		
		String instrucSql= "SELECT * FROM PRODUCTOS ";
		
		miStatement= miConexion.createStatement();
		
		
		
		
		
		
		//----------ejecutar sql------------------
		
		
		
		res= miStatement.executeQuery(instrucSql);
		
		
		
		
		
		
		
		
		//--------recorrer el resultSet obtenido de la consulta sql-----------
		
		
		
		while(res.next()) {
			
			
			String c_art= res.getString("CODIGOARTICULO");
			String n_art= res.getString("NOMBREARTICULO");
			double precio= res.getDouble("PRECIO");
			String importado= res.getString("IMPORTADO");
			Date fecha=res.getDate("fecha");
			String paisOrigen=res.getString("PAISORIGEN");
			String seccion=res.getString("SECCION");
			String codSeg=res.getString("CODIGOSEG");
		
			
			
			//Productos tempProd= new Productos(c_art,seccion,n_art,precio,importado,fecha,paisOrigen,codSeg,anio);
			

			Productos tempProd= new Productos(c_art,seccion,n_art,precio,importado,fecha,paisOrigen,codSeg);
			
		  prod.add(tempProd);
			
			
		}
		
		
		}finally {
			
			
			miStatement.close();
			
			miConexion.close();
			
		}
		
		return prod;
		
		
		
		
		
	}

	public void agregaNuevoProd(Productos nuevProd) throws Exception {
		
		
		
		//obtener la conexion
		
		Connection miConexion=null;
		
		PreparedStatement miStatement=null;
		
		
		
		
		
		

		
		
		try {
			
			miConexion= origenDatos.getConnection();
			
			
	
		
		
		
		
		//crear instruccion SQL y ademas crear la consulta preparada
		
		
		
		String sql="INSERT INTO PRODUCTOS (CODIGOARTICULO,NOMBREARTICULO,PRECIO,IMPORTADO,fecha,PAISORIGEN,SECCION,CODIGOSEG)"
				+"VALUES (?,?,?,?,?,?,?,?)";
		

			miStatement= miConexion.prepareStatement(sql);
			
			
			
			
			//establecer parametros del producto
			
			
			
			miStatement.setString(1, nuevProd.getIdArtic() );
			miStatement.setString(2, nuevProd.getNombreArt() );
			miStatement.setDouble(3, nuevProd.getPrecio() );
			
			miStatement.setString(4, nuevProd.getImportado() );
			
			java.util.Date utilDate= nuevProd.getFecha();
			
			java.sql.Date fechaConv=new java.sql.Date(utilDate.getTime());
			
			miStatement.setDate(5, fechaConv);
			
	
		
			miStatement.setString(6, nuevProd.getpOrig() );
			miStatement.setString(7, nuevProd.getSeccion() );
			miStatement.setString(8, nuevProd.getCodSeg() );
			
			
			
			
			
			//ejecutar la instruccion SQL
			
			
			
			miStatement.execute();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
			
		}finally {
			
			
			miStatement.close();
			
			miConexion.close();
			
		}
		
		
		
		
		
		
		

		
		
		
		
	}




public Productos getProduct(String codArtic) throws Exception{
	
	



	
	
	Productos elProd= null;
	
	Connection miConexion=null;
	
	PreparedStatement miStatement = null;
	
	
	ResultSet res=null;
	
	
	
	String cArtic= codArtic;
	
	
	
	
	
	//Establecer la conexion con la base de datos
	
	
	try {
	
	
	miConexion=origenDatos.getConnection();
	
	
	
	
	
	
	//craer sql que busque el producto con el codigo articulo que le hayamos enviado
	
	
	
	String sql = "SELECT * FROM PRODUCTOS WHERE CODIGOARTICULO=?";
	
	
	
	//crear la consulta preparada
	
	
	miStatement = miConexion.prepareStatement(sql);
	
	
	
	
	
	//establecer los parametros 
	
	
	miStatement.setString(1, cArtic);

	
	
	
	
	
	
	
	
	
	//ejecutar la consulta
	
	
	res=miStatement.executeQuery();
	
	
	
	
	//obtener los datos de respuesta
	
	
	
	
	if(res.next()) {
		
		
		String c_art=res.getString("CODIGOARTICULO");
		String n_art= res.getString("NOMBREARTICULO");
		double precio= res.getDouble("PRECIO");
		String importado= res.getString("IMPORTADO");
		Date fecha=res.getDate("fecha");
		String paisOrigen=res.getString("PAISORIGEN");
		String seccion=res.getString("SECCION");
		String codSeg=res.getString("CODIGOSEG");
		
		
		elProd= new Productos(c_art,seccion,n_art,precio,importado,fecha,paisOrigen,codSeg);
		
	}else {
		
		
		throw new Exception("No se encontró el producto cuyo codigo articulo=" + cArtic );
		
	}
	
	
	
	
	
	
	}catch (Exception e){
		
		e.printStackTrace();
		
		
		
	}finally {
		
		
		miStatement.close();
		
		miConexion.close();
		
	}
	
	
	
	
	
	
	
	
	
		return elProd;
	}









public void actualProd(Productos actProd) throws Exception {
	
	
	Connection miConexion=null;
	
	PreparedStatement miStatement=null;
	
	
	//establecer conexion
	
	
	try {
	
	miConexion= origenDatos.getConnection();
	
	
	//crear sentencia SQL
	
	
	String sql ="UPDATE PRODUCTOS SET NOMBREARTICULO=?, PRECIO=?, IMPORTADO=?, fecha=?, PAISORIGEN=?, SECCION=?, CODIGOSEG=? WHERE CODIGOARTICULO=?";
	
	
	
	
	//crear la consulta preparada
	
	
	miStatement = miConexion.prepareStatement(sql);
	
	
	
	
	//establecer los parametros
	
	miStatement.setString(1,actProd.getNombreArt() );
	miStatement.setDouble(2,actProd.getPrecio());
	miStatement.setString(3,actProd.getImportado());
	
	
	java.util.Date utilDate= actProd.getFecha();
	
	java.sql.Date fechaConv=new java.sql.Date(utilDate.getTime());
	
	
	
	miStatement.setDate(4,fechaConv );
	
	


	
	miStatement.setString(5,actProd.getpOrig());
	miStatement.setString(6,actProd.getSeccion() );
	miStatement.setString(7,actProd.getCodSeg() );
	miStatement.setString(8,actProd.getIdArtic() );

	
	
	//ejecutar la instruccion SQL
	
	miStatement.execute();
	
	}finally {
		
		
		miStatement.close();
		
		miConexion.close();
		
	}
	
}









public void eliminarProd(String codArtic) throws Exception {

	
	// Establecer la conexion con la base de datos
	
	
	
	
	
	Connection miConexion=null;
	
	PreparedStatement miStatement=null;
	
	
try {
	
	miConexion= origenDatos.getConnection();
	
	
	
	
	
	
	//crear la instruccion sql de eliminacion
	
	
	String sql= "DELETE FROM PRODUCTOS WHERE CODIGOARTICULO=?";
	
	
	
	
	//preparar la consulta 
	
	
	
	miStatement = miConexion.prepareStatement(sql);
	
	
	
	
	//establecer los parametros de consulta
	
	
	
	miStatement.setString(1, codArtic );
	
	
	
	
	
	//ejecutar la sentencia sql
	
	
	miStatement.execute();
	
}finally {
	
	
	//lo de adentro del finally se ejecutara siempre
	
	
	miStatement.close();
	
	miConexion.close();
	
	
	
}






	
}









	
	

}
