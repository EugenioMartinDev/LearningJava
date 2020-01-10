package modelo.entidad;

public class Motor {

	private String tipo;
	private Double potencia;
	private Double cilindrada;
	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * @return the potencia
	 */
	public Double getPotencia() {
		return potencia;
	}
	/**
	 * @param potencia the potencia to set
	 */
	public void setPotencia(Double potencia) {
		this.potencia = potencia;
	}
	/**
	 * @return the cilindrada
	 */
	public Double getCilindrada() {
		return cilindrada;
	}
	/**
	 * @param cilindrada the cilindrada to set
	 */
	public void setCilindrada(Double cilindrada) {
		this.cilindrada = cilindrada;
	}
	@Override
	public String toString() {
		return "Motor [tipo=" + tipo + ", potencia=" + potencia + ", cilindrada=" + cilindrada + "]";
	}
	/**
	 * @param tipo
	 * @param potencia
	 * @param cilindrada
	 */
	public Motor(String tipo, Double potencia, Double cilindrada) {
		super();
		this.tipo = tipo;
		this.potencia = potencia;
		this.cilindrada = cilindrada;
	}
	/**
	 * 
	 */
	public Motor() {
		super();
	}
	
	
	
}
