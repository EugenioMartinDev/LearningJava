package entidad;

public abstract class Empleado {

	
	/*
	 * 
	 * (Para el curriculum ---->) Herramientas y tecnologias
Java JSE, Java JEE, Sockets, Hilos y procesos, Drivers de conexion a BBDD, JPA, MVC, Spring, Spring MVC, HTML, CSS, GIT, Maven, MySQL, Tomcat.

	 * 
	 * Quiero hacer el modelo de datos de una aplicación que soporte las siguientes
casuisticas

1- La idea es codificar el modelo de datos de una empresa
2- La empresa tendrá tres tipos de empleados, programadores, jefes de proyecto y directores
3- Todos tendran atributos comunes, tales como dni, nombre, salario base y edad
4- Todos los empleados se les podra calcular el sueldo total, pero a cada uno se les calculara de manera
	diferente:
	a) los programadores tendran como sueldo total su salario base
	b) los jefes de proyecto tendrán un sueldo total de su salario base + unos incentivos
		(cada jefe de proyecto tendrá unos incentivos distintos)
	c) los directores tendran un salario total de su salario base + el numero de
		empleados a su cargo * 100

Una vez hecho el modelo de datos se pide probar el modelo creando 4 programadores, 2 jefes de proyecto
, 1 director (con 2 de esos programadores y un jefe de proyecto). Se meterán los empleados en un array
y se ejecutará el calcular sueldo total de cada uno de ellos para observar como el programa muestra
cada uno de los sueldos totales
	 * 
	 */
	
	private String dni;
	private String nombre;
	private double salarioBase;
	private int edad;
	
	
	
	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}



	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
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
		this.nombre = nombre;
	}



	/**
	 * @return the salarioBase
	 */
	public double getSalarioBase() {
		return salarioBase;
	}



	/**
	 * @param salarioBase the salarioBase to set
	 */
	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
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
		this.edad = edad;
	}



	public double sueldoTotal( ) {
		return salarioBase;
	}
}
