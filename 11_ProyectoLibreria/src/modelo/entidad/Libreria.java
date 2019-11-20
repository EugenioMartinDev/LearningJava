package modelo.entidad;

import java.util.ArrayList;


public class Libreria {

	private String nombre;
	private ArrayList<Libro> listaLibros;
			
	/**
	 * 
	 */
	public Libreria() {
		super();
		listaLibros = new ArrayList<Libro>();
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the listaLibros
	 */
	public ArrayList<Libro> getListaLibros() {
		return listaLibros;
	}
	/**
	 * @param arrayList the listaLibros to set
	 */
	public void setListaLibros(ArrayList<Libro> arrayList) {
		this.listaLibros = arrayList;
	}
	@Override
	public String toString() {
		return "Libreria [nombre=" + nombre + ", listaLibros=" + listaLibros + "]";
	}
	
	
}
