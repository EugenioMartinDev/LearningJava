package bean;

public class Coche {

	
	/* Clase coche con los atributos marca, modelo y matrícula */
	
	private String marca;
	private String modelo;
	private String matricula;
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
	 * @return the modelo
	 */
	public String getModelo() {
		return modelo;
	}
	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	/**
	 * @return the matricula
	 */
	public String getMatricula() {
		return matricula;
	}
	/**
	 * @param matricula the matricula to set
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	@Override
	public String toString() {
		return "coche [marca=" + marca + ", modelo=" + modelo + ", matricula=" + matricula + "]";
	}
	
	
}
