package controlador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import modelo.Modelo;
import productos.Productos;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
 

    
    private Modelo modeloProd;
    
@Resource(name="jdbc/productos")
	
	
	private DataSource miPool;
	
    
    
    
    
    
    
	@Override
public void init() throws ServletException {
	
	super.init();
	
	try {
		
		modeloProd=new Modelo(miPool);
		
		
		
	}catch(Exception e){
		
		
		throw new ServletException(e);
		
	}

	
	
	
	
	
	
}







	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
		

		
		
		//leer el parametro del formulario inserta_producto.jsp
		
		String instr = request.getParameter("instruc");
		
		//si no se envia el parametro, listar productos
		
		
		if(instr==null) {
			
			
			instr="listar";
		}
		
		
		
		//haya recibido el parametro o no, redirigirá el flujo de ejecucion al metodo adecuado (liste o inserte)
		
		
		
		switch(instr) {
		
		case "listar":
			
			obtenerProd(request, response);
			break;
			
			
		case "inserta":
			
			agregaProd(request,response);
			break;
			
			
		case "cargar":
			
			try {
				cargarProductos(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		break;
			
		case "actualizar":
			
			try {
				
			actualizarProductos(request,response);
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
			
		case "eliminar":
			
			try {
				
			eliminarProductos(request,response);
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				
			}
			break;
			
			
		default:
				
			obtenerProd(request, response);	
		
		}
		
		
		


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}



private void eliminarProductos(HttpServletRequest request, HttpServletResponse response) throws Exception {

	
	//capturar el codigo articulo
	String codArtic=request.getParameter("CArtic");
	
	
	//borrar producto de la base de datos (llamada al modelo)
	
	
	modeloProd.eliminarProd(codArtic);
	
	
	//volver al listado de productos (para verificar que la operacion se ha hecho)
	
	
	obtenerProd(request, response);	
	
	
	
	
	
	
	}







private void actualizarProductos(HttpServletRequest request, HttpServletResponse response) throws Exception {

	
	//leer los datos que le vienen del formulario  jsp actualizarProd
	

	
		String codArtic=request.getParameter("Art");
		
		String nArt=request.getParameter("Nart");
		
		String paisOrig=request.getParameter("Pais");
		
		String seccion=request.getParameter("Sec");
		
		String codSeg=request.getParameter("Cseg");

		

		
		
		String imp=request.getParameter("Imp");
		
		
		
		SimpleDateFormat formFecha=new SimpleDateFormat("yyyy-MM-dd");
		
		Date fecha=null;
		
		

	try {
			fecha=formFecha.parse(request.getParameter("Fecha"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
		double precio=Double.parseDouble(request.getParameter("precio"));
		

	
	//crear un objeto de tipo producto con la info del formulario (vista)
	    
	    
		Productos actProd = new Productos (codArtic,seccion,nArt,precio,imp,fecha,paisOrig,codSeg);
	    
	    
	
	//actualizar la base de datos con la informacion del objeto producto
		
		modeloProd.actualProd(actProd);
		
		
	//volver al jsp vista con la informacion actualizada
	
		obtenerProd(request, response);	
	
	
	
		
	}







private void cargarProductos(HttpServletRequest request, HttpServletResponse response) throws Exception{

	
	//leer el codigo articulo que viene del segundo parametro de vista.jsp
	
	
	String codArtic = request.getParameter("CArtic");
	
	
	// enviar codigo articulo a modelo
	
	
	Productos prod= modeloProd.getProduct(codArtic);
	
	
	//colocar atributo correspondiente al codigo articulo
	
	
	request.setAttribute("ProdAct", prod);
	
	
	//enviar producto al formulario de actualizar (jsp)
	
	
	RequestDispatcher dispatcher= request.getRequestDispatcher("/actualizarProd.jsp");
	
	dispatcher.forward(request,response);
	
	
		
	}







private void agregaProd(HttpServletRequest request, HttpServletResponse response) {
	
	//leer la informacion del producto que viene del formulario inserta_producto.jsp
	
	String codArtic=request.getParameter("Art");
	
	String nArt=request.getParameter("Nart");
	
	String paisOrig=request.getParameter("Pais");
	String seccion=request.getParameter("Sec");
	String codSeg=request.getParameter("Cseg");
	
	//int anio=Integer.parseInt(request.getParameter("Anio"));
	

	
	
	String imp=request.getParameter("Imp");
	
	SimpleDateFormat formFecha=new SimpleDateFormat("yyyy-MM-dd");
	
	Date fecha=null;
	
	
	double precio=Double.parseDouble(request.getParameter("precio"));
	
	
    try {
		fecha=formFecha.parse(request.getParameter("Fecha"));
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    

	

	

	
	
	//crear un objeto de tipo producto
	
	Productos nuevProd = new Productos (codArtic,seccion,nArt,precio,imp,fecha,paisOrig,codSeg);
	
	
	
	
	
	
	//enviar el objeto al modelo y despues insertar el objeto producto en la base de datos
	
	
	try {
	modeloProd.agregaNuevoProd(nuevProd);
	
	}catch(Exception e) {
		
		
		e.printStackTrace();
	}
	
	
	
	
	
	
	
	
	
	
	//unz vez insertado, volver a listar los productos para comprobar la insercion
	
	obtenerProd(request, response);	
		
	}







private void obtenerProd(HttpServletRequest request, HttpServletResponse response) {
		
	
	
	//obtener la lista de productos del modelo.java
	
	List<Productos> productos;
	
	
	
	try {
		
		
		
		productos = modeloProd.getProductos();
		
		
	
		
		//agregar la lista de productos al request
		
		
		
		request.setAttribute("LISTAPRODUCTOS", productos);
		
		
		
		

		
		
		//enviar ese request a la pagina JSP
		
		
		
		
		RequestDispatcher miDisp = request.getRequestDispatcher("/Vista.jsp");
		
		
		
		miDisp.forward(request, response);
		
		
		
		
		
		
	}catch(Exception e) {
		
		
		e.printStackTrace();
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	}

}
