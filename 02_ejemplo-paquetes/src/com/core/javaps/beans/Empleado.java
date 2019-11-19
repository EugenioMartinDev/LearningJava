package com.core.javaps.beans;

public class Empleado {

	private int idEmpleado;
	private String nombre, apellido, sexo;
	private double salario;
	private int edad;
	private double comision;
	
	
	
	/**
	 * @param idEmpleado
	 * @param nombre
	 * @param apellido
	 * @param sexo
	 * @param salario
	 * @param edad
	 */
	public Empleado(int idEmpleado, String nombre, String apellido, String sexo, double salario, int edad) {
		super();
		this.idEmpleado = idEmpleado;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.salario = salario;
		this.edad = edad;
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

	
	
	@Override
	public String toString() {
		return "Empleado [idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", apellido=" + apellido + ", sexo=" + sexo
				+ ", salario=" + salario + ", edad=" + edad + "]";
	}
	
	
	// METODOS RESPONSABLES DE LA CLASE
	public String nombreCompleto() {
	
		return (apellido+", "+nombre);
	}

	public double salarioMensual() {
		
		return (salario/14);
	}
	
	public double salarioMensual(int meses) {
		
		return (salario/meses);
	}

	public double aumentarSalario(int aumento) {
		
		return salario+= aumento;
	}
	


}
