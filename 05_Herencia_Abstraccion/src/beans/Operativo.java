package beans;

public class Operativo extends Empleado{
	
	public final static double HORA_EXTRA = 30;
	private int horasExtras;
	/**
	 * 
	 */
	public Operativo() {
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
	 * @param horasExtras
	 */
	public Operativo(int idEmpleado, String nombre, String apellido, String sexo, double salario, int edad,
			double comision, Departamento departamento, int horasExtras) {
		super(idEmpleado, nombre, apellido, sexo, salario, edad, comision, departamento);
		this.horasExtras = horasExtras;
	}
	/**
	 * @return the horasExtras
	 */
	public int getHorasExtras() {
		return horasExtras;
	}
	/**
	 * @param horasExtras the horasExtras to set
	 */
	public void setHorasExtras(int horasExtras) {
		this.horasExtras = horasExtras;
	}
	/**
	 * @return the horaExtra
	 */
	public static double getHoraExtra() {
		return HORA_EXTRA;
	}
	@Override
	public String toString() {
		return "Operativo [idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", apellido=" + apellido + ", sexo="
				+ sexo + ", salario=" + salario + ", edad=" + edad + ", comision=" + comision + ", departamento="
				+ departamento.getIdDepartamento() + ", horasExtras=" + horasExtras + "]";
	}

	public double salarioMensual() {
		// TODO Auto-generated method stub
		return (salario + comision + horasExtras * HORA_EXTRA)/MESES_NOMINA;
	}

	public double salarioMensual(int meses) {
		// TODO Auto-generated method stub
		return ((salario + comision + horasExtras * HORA_EXTRA)/meses);
	}

	public double totalSalario() {
		// TODO Auto-generated method stub
		return salario + horasExtras;
	}

	

	

}
