package clases;

public class Manga extends ContenidoMultimedia{

	//atributos
	private int isbn;
	private int numTomos;
	private String editorial;
	private String periodicidad;
	private float precio;
	private int Stock;
	private Proveedor prov;
	//get & set
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public int getNumTomos() {
		return numTomos;
	}
	public void setNumTomos(int numTomos) {
		this.numTomos = numTomos;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public String getPeriodicidad() {
		return periodicidad;
	}
	public void setPeriodicidad(String periodicidad) {
		this.periodicidad = periodicidad;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public int getStock() {
		return Stock;
	}
	public void setStock(int stock) {
		Stock = stock;
	}	
	public final Proveedor getProv() {
		return prov;
	}
	public final void setProv(Proveedor prov) {
		this.prov = prov;
	}
}
