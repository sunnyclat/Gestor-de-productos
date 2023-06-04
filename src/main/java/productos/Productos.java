package productos;

import java.util.Date;

public class Productos {
	
	
	private String idArtic;
	private String seccion;
	private String nombreArt;
	private double precio;
	private Date fecha;
	private String importado;
	private String pOrig;
	private String codSeg;
	private int anio;
	
	
	

	
	
	
	public Productos(String idArtic, String seccion, String nombreArt, double precio, String importado,Date fecha, 
			String pOrig, String codSeg) {

		this.idArtic = idArtic;
		this.seccion = seccion;
		this.nombreArt = nombreArt;
		this.precio = precio;
		this.fecha = fecha;
		this.importado = importado;
		this.pOrig = pOrig;
		this.codSeg = codSeg;
	
	}





	public Productos(String seccion, String nombreArt, double precio,String importado, Date fecha , String pOrig,
			String codSeg) {

		this.seccion = seccion;
		this.nombreArt = nombreArt;
		this.precio = precio;
		this.fecha = fecha;
		this.importado = importado;
		this.pOrig = pOrig;
		this.codSeg = codSeg;

	}




	public String getIdArtic() {
		return idArtic;
	}




	public void setIdArtic(String idArtic) {
		this.idArtic = idArtic;
	}




	public String getSeccion() {
		return seccion;
	}




	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}




	public String getNombreArt() {
		return nombreArt;
	}




	public void setNombreArt(String nombreArt) {
		this.nombreArt = nombreArt;
	}




	public double getPrecio() {
		return precio;
	}




	public void setPrecio(double precio) {
		this.precio = precio;
	}




	public Date getFecha() {
		return fecha;
	}




	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}




	public String getImportado() {
		return importado;
	}




	public void setImportado(String importado) {
		this.importado = importado;
	}




	public String getpOrig() {
		return pOrig;
	}




	public void setpOrig(String pOrig) {
		this.pOrig = pOrig;
	}




	public String getCodSeg() {
		return codSeg;
	}




	public void setCodSeg(String codSeg) {
		this.codSeg = codSeg;
	}




	public int getAnio() {
		return anio;
	}




	public void setAnio(int anio) {
		this.anio = anio;
	}




	@Override
	public String toString() {
		return "productos [idArtic=" + idArtic + ", seccion=" + seccion + ", nombreArt=" + nombreArt + ", precio="
				+ precio + ", fecha=" + fecha + ", importado=" + importado + ", pOrig=" + pOrig + ", codSeg=" + codSeg
				+ ", anio=" + anio + "]";
	}
	
	
	
	
	
	
	
	

	


	
	
	
	
	
	
	
	

}
