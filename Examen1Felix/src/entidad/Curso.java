package entidad;

import java.util.ArrayList;

public class Curso {

	private int id;
	private String nombre;
	private double horas;
	private double precio;
	private ArrayList<Alumno> listaAlumnos;
	/**
	 * 
	 */
	public Curso() {
		super();
	}
	/**
	 * @param id
	 * @param nombre
	 * @param horas
	 * @param precio
	 * @param listaAlumnos
	 */
	public Curso(int id, String nombre, double horas, double precio, ArrayList<Alumno> listaAlumnos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.horas = horas;
		this.precio = precio;
		this.listaAlumnos = listaAlumnos;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	 * @return the horas
	 */
	public double getHoras() {
		return horas;
	}
	/**
	 * @param horas the horas to set
	 */
	public void setHoras(double horas) {
		this.horas = horas;
	}
	/**
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}
	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	/**
	 * @return the listaAlumnos
	 */
	public ArrayList<Alumno> getListaAlumnos() {
		return listaAlumnos;
	}
	/**
	 * @param listaAlumnos the listaAlumnos to set
	 */
	public void setListaAlumnos(ArrayList<Alumno> listaAlumnos) {
		this.listaAlumnos = listaAlumnos;
	}
	@Override
	public String toString() {
		return "Curso [id=" + id + ", nombre=" + nombre + ", horas=" + horas + ", precio=" + precio + ", listaAlumnos="
				+ listaAlumnos + "]";
	}
	
	
	
}
