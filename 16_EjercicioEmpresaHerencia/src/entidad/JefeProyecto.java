package entidad;

public class JefeProyecto extends Empleado {

	private double incentivo;
	
	
	
	/**
	 * @return the incentivo
	 */
	public double getIncentivo() {
		return incentivo;
	}



	/**
	 * @param incentivo the incentivo to set
	 */
	public void setIncentivo(double incentivo) {
		this.incentivo = incentivo;
	}

	


	@Override
	public String toString() {
		return "JefeProyecto [incentivo=" + incentivo + ", getDni()=" + getDni() + ", getNombre()=" + getNombre()
				+ ", getSalarioBase()=" + getSalarioBase() + ", getEdad()=" + getEdad() + "]";
	}



	@Override
	public double sueldoTotal() {
		
		return super.sueldoTotal() + incentivo;
	}
	
	
}
