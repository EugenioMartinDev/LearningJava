package beans;

public class JefeProyecto extends Empleado{
	
	private String nombreProyecto;
	
	
	/**
	 * 
	 */
	public JefeProyecto() {
		super();
	}	

	/**
	 * @param idEmpleado
	 * @param nombre
	 * @param apellido
	 * @param sexo
	 * @param salario
	 * @param edad
	 * @param comision
	 * @param departamento
	 * @param nombreProyecto
	 */
	public JefeProyecto(int idEmpleado, String nombre, String apellido, String sexo, double salario, int edad,
			double comision, Departamento departamento, String nombreProyecto) {
		super(idEmpleado, nombre, apellido, sexo, salario, edad, comision, departamento);
		this.nombreProyecto = nombreProyecto;
	}

	/**
	 * @return the nombreProyecto
	 */
	public String getNombreProyecto() {
		return nombreProyecto;
	}

	@Override
	public String toString() {
		return "JefeProyecto [idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", apellido=" + apellido + ", sexo="
				+ sexo + ", salario=" + salario + ", edad=" + edad + ", comision=" + comision + ", departamento="
				+ departamento.getIdDepartamento() + ", nombreProyecto=" + nombreProyecto + "]";
	}

	/**
	 * @param nombreProyecto the nombreProyecto to set
	 */
	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}

	@Override
	public double salarioMensual() {		
		return ((salario + comision)/MESES_NOMINA);
	}
	@Override
	public double salarioMensual(int meses) {		
		return ((salario + comision)/meses);
	}

	@Override
	public double totalSalario() {
		return (salario + comision);
	}

}
