package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class controlador
 */
@WebServlet("/controlador")
public class ControladorPrueba extends HttpServlet {
	private static final long serialVersionUID = 1L;

  //Definir o establecer el dataSource
	
	@Resource(name="jdbc/productos")
	
	
	private DataSource miPool;
	
	
	
	
    public ControladorPrueba() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		/*
		
		String [] productos = {"Destornillador","tornillo","taladro"};
		
		
		
		request.setAttribute("lista_productos", productos);
		
		
		//en el argumento del dispatcher ira la ruta del jsp(vista)
		RequestDispatcher miDispatch = request.getRequestDispatcher("/vista.jsp");
		
		miDispatch.forward(request, response);
		
		
		*/
		
		//crear el obj printWritter
		
		PrintWriter salida= response.getWriter();
		
		
		response.setContentType("text/palin");
		
		
		//crear conexion con base de datos
		
		Connection miConexion=null;
		
		Statement miStatement=null;
		
		ResultSet res=null;
		
		
		
		
		try {
			
			
			miConexion= miPool.getConnection();
			
			
			String miSql="SELECT * FROM PRODUCTOS";
			
			miStatement= miConexion.createStatement();
			
			
			
			
			res= miStatement.executeQuery(miSql);
			
			
			while(res.next()) {
				
				
				String nombre= res.getString(2);
				
				
				salida.println(nombre);
				
				
				
				
				
			}
			
			
			
			
			
			
			
		}catch(Exception e) {
			
			
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
