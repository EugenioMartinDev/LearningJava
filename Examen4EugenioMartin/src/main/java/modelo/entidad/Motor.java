package modelo.entidad;

public class Motor {

	private double cv;
	private double cilindrada;
	/**
	 * @return the cv
	 */
	public double getCv() {
		return cv;
	}
	/**
	 * @param cv the cv to set
	 */
	public void setCv(double cv) {
		this.cv = cv;
	}
	/**
	 * @return the cilindrada
	 */
	public double getCilindrada() {
		return cilindrada;
	}
	/**
	 * @param cilindrada the cilindrada to set
	 */
	public void setCilindrada(double cilindrada) {
		this.cilindrada = cilindrada;
	}
	/**
	 * 
	 */
	public Motor() {
		super();
	}
	@Override
	public String toString() {
		return "Motor [cv=" + cv + ", cilindrada=" + cilindrada + "]";
	}
	
	
	
}
