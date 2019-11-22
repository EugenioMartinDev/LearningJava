package entidad;

import java.util.ArrayList;

public class Profesor {

	private String dni;
	private String nombre;
	private int edad;
	private double salario;
	private String sexo;
	private ArrayList<Curso> listaCurso;
	/**
	 * 
	 */
	public Profesor() {
		super();
	}
	/**
	 * @param dni
	 * @param nombre
	 * @param edad
	 * @param salario
	 * @param sexo
	 * @param listaCurso
	 */
	public Profesor(String dni, String nombre, int edad, double salario, String sexo, ArrayList<Curso> listaCurso) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
		this.salario = salario;
		this.sexo = sexo;
		this.listaCurso = listaCurso;
	}
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
		this.salario = salario;
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
		this.sexo = sexo;
	}
	/**
	 * @return the listaCurso
	 */
	public ArrayList<Curso> getListaCurso() {
		return listaCurso;
	}
	/**
	 * @param listaCurso the listaCurso to set
	 */
	public void setListaCurso(ArrayList<Curso> listaCurso) {
		this.listaCurso = listaCurso;
	}
	@Override
	public String toString() {
		return "Profesor [dni=" + dni + ", nombre=" + nombre + ", edad=" + edad + ", salario=" + salario + ", sexo="
				+ sexo + ", listaCurso=" + listaCurso + "]";
	}
	
	
	
}
