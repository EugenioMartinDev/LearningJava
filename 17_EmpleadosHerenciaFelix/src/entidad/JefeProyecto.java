package entidad;

public class JefeProyecto extends Empleado {

	private double incentivo;
	
	@Override
	public double calcularSalario() {
		
		return getSalarioBase() + incentivo;
	}

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
		return "JefeProyecto [" + super.toString() + " incentivo="  + incentivo + "]";
	}
	
	

}
