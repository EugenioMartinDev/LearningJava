package modelo.entidad;

import java.util.List;

public class Avion {

	private int id;
	private String marca;
	private List<Asiento> listaAsientos;
	private List<Motor> listaMotores;
	private List<Rueda> listaRuedas;
	private double kilometros;
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
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}
	/**
	 * @param marca the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}
	/**
	 * @return the listaAsientos
	 */
	public List<Asiento> getListaAsientos() {
		return listaAsientos;
	}
	/**
	 * @param listaAsientos the listaAsientos to set
	 */
	public void setListaAsientos(List<Asiento> listaAsientos) {
		this.listaAsientos = listaAsientos;
	}
	/**
	 * @return the listaMotores
	 */
	public List<Motor> getListaMotores() {
		return listaMotores;
	}
	/**
	 * @param listaMotores the listaMotores to set
	 */
	public void setListaMotores(List<Motor> listaMotores) {
		this.listaMotores = listaMotores;
	}
	/**
	 * @return the listaRuedas
	 */
	public List<Rueda> getListaRuedas() {
		return listaRuedas;
	}
	/**
	 * @param listaRuedas the listaRuedas to set
	 */
	public void setListaRuedas(List<Rueda> listaRuedas) {
		this.listaRuedas = listaRuedas;
	}
	/**
	 * @return the kilometros
	 */
	public double getKilometros() {
		return kilometros;
	}
	/**
	 * @param kilometros the kilometros to set
	 */
	public void setKilometros(double kilometros) {
		this.kilometros = kilometros;
	}
	/**
	 * 
	 */
	public Avion() {
		super();
	}
	@Override
	public String toString() {
		return "Avion [id=" + id + ", marca=" + marca + ", listaAsientos=" + listaAsientos + ", listaMotores="
				+ listaMotores + ", listaRuedas=" + listaRuedas + ", kilometros=" + kilometros + "]";
	}
	
	
	
}
