package beans;

public class Empleado {

	protected int idEmpleado;
	protected String nombre, apellido, sexo;
	protected double salario;
	protected int edad;
	protected double comision;
	protected Departamento departamento;
	
	public final static int MESES_NOMINA = 14;
	public final static double VALOR_ACCION = 10.239;
	

	/**
	 * @param idEmpleado
	 * @param nombre
	 * @param apellido
	 * @param sexo
	 * @param salario
	 * @param edad
	 * @param comision
	 * @param departamento
	 */
	public Empleado(int idEmpleado, String nombre, String apellido, String sexo, double salario, int edad,
			double comision, Departamento departamento) {
		super();
		this.idEmpleado = idEmpleado;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.salario = salario;
		this.edad = edad;
		this.comision = comision;
		this.departamento = departamento;
	}



	/**
	 * 
	 */
	public Empleado() {
		super();
	}



	/**
	 * @return the idEmpleado
	 */
	public int getIdEmpleado() {
		return idEmpleado;
	}

	/**
	 * @param idEmpleado the idEmpleado to set
	 */
	public void setIdEmpleado(int idEmpleado) {
		if (idEmpleado > 10000)
		{
			System.out.println("Identidad errónea ");
			return;
		}
		this.idEmpleado = idEmpleado;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre.toUpperCase();
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido.toUpperCase();
	}

	/**
	 * @return the sexo
	 */
	public String getSexo() {
		return sexo;
	}

	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(String sexo) {
		if ("H".contentEquals(sexo.toUpperCase())
				||
				"M".contentEquals(sexo.toUpperCase()))
			this.sexo = sexo.toUpperCase();
		else
			System.out.println("Sexo erróneo en la identidad : " + this.idEmpleado);
	}

	/**
	 * @return the salario
	 */
	public double getSalario() {
		return salario;
	}

	/**
	 * @param salario the salario to set
	 */
	public void setSalario(double salario) {
		if (salario > 10000 && salario <90001)
		this.salario = salario;
		else
			System.out.println("Salario erróneo en el empleado : " + idEmpleado);
	}

	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		if (edad > 16 && edad < 90)
		this.edad = edad;
		else
			System.out.println("Edad errónea en el empleado : " + idEmpleado);
	}
	
	/**
	 * @return the comision
	 */
	public double getComision() {
		return comision;
	}

	/**
	 * @param comision the comision to set
	 */
	public void setComision(double comision) {
		this.comision = comision;
	}

	
	
	/**
	 * @return the departamento
	 */
	public Departamento getDepartamento() {
		return departamento;
	}



	/**
	 * @param departamento the departamento to set
	 */
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}


	
	@Override
	public String toString() {
		return "Empleado [idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", apellido=" + apellido + ", sexo=" + sexo
				+ ", salario=" + salario + ", edad=" + edad + ", comision=" + comision + ", departamento="
				+ departamento + "]";
	}



	// METODOS RESPONSABLES DE LA CLASE
	public String nombreCompleto() {
	
		return (apellido+", "+nombre);
	}

	public double salarioMensual() {
		
		return ((salario+comision)/MESES_NOMINA);
	}
	
	public double salarioMensual(int meses) {
		
		return ((salario+comision)/meses);
	}

	public double aumentarSalario(double aumento) {
		
		return salario *= (1+(aumento/100));
	}
	
	public double totalSalario() {
		
		return salario + comision;
	}

}
