package bean;

public class Habitacion {

	private double m2;
	private String tipo;
	/**
	 * @return the m2
	 */
	public double getM2() {
		return m2;
	}
	/**
	 * @param m2 the m2 to set
	 */
	public void setM2(double m2) {
		this.m2 = m2;
	}
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
	@Override
	public String toString() {
		return "Habitacion [m2=" + m2 + ", tipo=" + tipo + "]";
	}

	
	
	
	
}
