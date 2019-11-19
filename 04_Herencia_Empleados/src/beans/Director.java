package beans;

public class Director extends Empleado {

	private int acciones;
	private String tablet;
	/**
	 * @param idEmpleado
	 * @param nombre
	 * @param apellido
	 * @param sexo
	 * @param salario
	 * @param edad
	 * @param comision
	 * @param departamento
	 * @param acciones
	 * @param tablet
	 */
	public Director(int idEmpleado, String nombre, String apellido, String sexo, double salario, int edad,
			double comision, Departamento departamento, int acciones, String tablet) {
		super(idEmpleado, nombre, apellido, sexo, salario, edad, comision, departamento);
		this.acciones = acciones;
		this.tablet = tablet;
	}
	/**
	 * 
	 */
	public Director() {
		super();
	}
	/**
	 * @return the acciones
	 */
	public int getAcciones() {
		return acciones;
	}
	/**
	 * @param acciones the acciones to set
	 */
	public void setAcciones(int acciones) {
		this.acciones = acciones;
	}
	/**
	 * @return the tablet
	 */
	public String getTablet() {
		return tablet;
	}
	/**
	 * @param tablet the tablet to set
	 */
	public void setTablet(String tablet) {
		this.tablet = tablet;
	}
	@Override
	public String toString() {
		if (departamento == null)
			return "Director [getIdEmpleado()=" + getIdEmpleado() + ", getNombre()=" + getNombre() + ", getApellido()="
					+ getApellido() + ", getSexo()=" + getSexo() + ", getSalario()=" + getSalario() + ", getEdad()="
					+ getEdad() + ", getComision()=" + getComision() + ", getDepartamento()=" + getDepartamento()
					+ ", toString()=" + super.toString() + ", nombreCompleto()=" + nombreCompleto() + ", salarioMensual()="
					+ salarioMensual() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", acciones="
					+ acciones + ", tablet=" + tablet + "]";
		else
			return "Director [getIdEmpleado()=" + getIdEmpleado() + ", getNombre()=" + getNombre() + ", getApellido()="
			+ getApellido() + ", getSexo()=" + getSexo() + ", getSalario()=" + getSalario() + ", getEdad()="
			+ getEdad() + ", getComision()=" + getComision() + ", getDepartamento()=" + getDepartamento().getIdDepartamento()
			+ ", toString()=" + super.toString() + ", nombreCompleto()=" + nombreCompleto() + ", salarioMensual()="
			+ salarioMensual() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", acciones="
			+ acciones + ", tablet=" + tablet + "]";
	}
	
	
	
	
	@Override
	public double totalSalario() {
		// TODO Auto-generated method stub
		return super.totalSalario() + acciones*VALOR_ACCION;
	}
	
	
	@Override
	public double salarioMensual() {
		// TODO Auto-generated method stub
		return totalSalario()/MESES_NOMINA;
	}
	
	@Override
	public double salarioMensual(int meses) {
		// TODO Auto-generated method stub
		return totalSalario()/meses;
	}
	
	// METODOS RESPONSABLES DE LA CLASE
	public int pagoAcciones(int pagoEnAcciones) {
		return acciones =+ pagoEnAcciones;
	}

}
