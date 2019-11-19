package beans;

public class Gerente extends Empleado {
	
	private int plazaGaraje;
	private String movil;
	private double variableSueldo;
	/**
	 * @param idEmpleado
	 * @param nombre
	 * @param apellido
	 * @param sexo
	 * @param salario
	 * @param edad
	 * @param comision
	 * @param departamento
	 * @param plazaGaraje
	 * @param movil
	 * @param variableSueldo
	 */
	public Gerente(int idEmpleado, String nombre, String apellido, String sexo, double salario, int edad,
			double comision, Departamento departamento, int plazaGaraje, String movil, double variableSueldo) {
		super(idEmpleado, nombre, apellido, sexo, salario, edad, comision, departamento);
		this.plazaGaraje = plazaGaraje;
		this.movil = movil;
		this.variableSueldo = variableSueldo;
	}
	/**
	 * 
	 */
	public Gerente() {
		super();
	}
	/**
	 * @return the plazaGaraje
	 */
	public int getPlazaGaraje() {
		return plazaGaraje;
	}
	/**
	 * @param plazaGaraje the plazaGaraje to set
	 */
	public void setPlazaGaraje(int plazaGaraje) {
		this.plazaGaraje = plazaGaraje;
	}
	/**
	 * @return the movil
	 */
	public String getMovil() {
		return movil;
	}
	/**
	 * @param movil the movil to set
	 */
	public void setMovil(String movil) {
		this.movil = movil;
	}
	/**
	 * @return the variableSueldo
	 */
	public double getVariableSueldo() {
		return variableSueldo;
	}
	/**
	 * @param variableSueldo the variableSueldo to set
	 */
	public void setVariableSueldo(double variableSueldo) {
		this.variableSueldo = variableSueldo;
	}
	@Override
	public String toString() {
		if (departamento == null)
		{
			return "Gerente [getIdEmpleado()=" + getIdEmpleado() + ", getNombre()=" + getNombre() + ", getApellido()="
					+ getApellido() + ", getSexo()=" + getSexo() + ", getSalario()=" + getSalario() + ", getEdad()="
					+ getEdad() + ", getComision()=" + getComision() + ", getDepartamento()=" + getDepartamento()
					+ ", toString()=" + super.toString() + ", nombreCompleto()=" + nombreCompleto() + ", salarioMensual()="
					+ salarioMensual() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", plazaGaraje="
					+ plazaGaraje + ", movil=" + movil + ", variableSueldo=" + variableSueldo + "]";
		}
		else
		{
			return "Gerente [getIdEmpleado()=" + getIdEmpleado() + ", getNombre()=" + getNombre() + ", getApellido()="
					+ getApellido() + ", getSexo()=" + getSexo() + ", getSalario()=" + getSalario() + ", getEdad()="
					+ getEdad() + ", getComision()=" + getComision() + ", getDepartamento()=" + getDepartamento().getIdDepartamento()
					+ ", toString()=" + super.toString() + ", nombreCompleto()=" + nombreCompleto() + ", salarioMensual()="
					+ salarioMensual() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", plazaGaraje="
					+ plazaGaraje + ", movil=" + movil + ", variableSueldo=" + variableSueldo + "]";
		}
	}
	
	
	//Inheriting classes overridden
	
	@Override
	public double salarioMensual() {
		
		return (super.salarioMensual()+ variableSueldo/MESES_NOMINA);
	}
	@Override
	public double salarioMensual(int meses) {
		
		return (super.salarioMensual(meses) + variableSueldo/meses);
	}


	@Override
	public double totalSalario() {

		return (super.totalSalario()+variableSueldo);
	}
	
	// METODOS RESPONSABLES DE LA CLASE
	public double aumentarVariable(int aumento) {
		// TODO Auto-generated method stub
		return (variableSueldo += aumento);
	}

	
	

}
