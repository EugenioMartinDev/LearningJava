package modelo.entidad;

public class Coche {
	
	private String matricula;
	private String marca;
	private String modelo;
	private boolean segundaMano;
	private Double precio;
	private Integer peso;
	private Motor motor;
	
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
	 * @return the segundaMano
	 */
	public boolean isSegundaMano() {
		return segundaMano;
	}
	/**
	 * @param segundaMano the segundaMano to set
	 */
	public void setSegundaMano(boolean segundaMano) {
		this.segundaMano = segundaMano;
	}
	/**
	 * @return the precio
	 */
	public Double getPrecio() {
		return precio;
	}
	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	/**
	 * @return the peso
	 */
	public Integer getPeso() {
		return peso;
	}
	/**
	 * @param peso the peso to set
	 */
	public void setPeso(Integer peso) {
		this.peso = peso;
	}
	
	
	/**
	 * @return the motor
	 */
	public Motor getMotor() {
		return motor;
	}
	/**
	 * @param motor the motor to set
	 */
	public void setMotor(Motor motor) {
		this.motor = motor;
	}
	@Override
	public String toString() {
		return "Coche [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", segundaMano="
				+ segundaMano + ", precio=" + precio + ", peso=" + peso + ", motor=" + motor + "]";
	}
	/**
	 * @param matricula
	 * @param marca
	 * @param modelo
	 * @param segundaMano
	 * @param precio
	 * @param peso
	 * @param motor
	 */
	public Coche(String matricula, String marca, String modelo, boolean segundaMano, Double precio, Integer peso,
			Motor motor) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.segundaMano = segundaMano;
		this.precio = precio;
		this.peso = peso;
		this.motor = motor;
	}
	/**
	 * 
	 */
	public Coche() {
		super();
	}

	
	
	
}
