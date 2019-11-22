package modelo.entidad;

import java.util.ArrayList;

public class Profesor {

	private String dNI;
	private String nombre;
	private int edad;
	private double salario;
	private String sexo;
	private ArrayList<Curso> listaCursos = new ArrayList<Curso>();

	/**
	 * @return the dNI
	 */
	public String getdNI() {
		return dNI;
	}

	/**
	 * @param dNI the dNI to set
	 */
	public void setdNI(String dNI) {
		this.dNI = dNI;
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
	 * @return the listaCursos
	 */
	public ArrayList<Curso> getListaCursos() {
		return listaCursos;
	}

	/**
	 * @param listaCursos the listaCursos to set
	 */
	public void setListaCursos(ArrayList<Curso> listaCursos) {
		this.listaCursos = listaCursos;
	}

	/**
	 * 
	 */
	public Profesor() {
		super();
	}

	@Override
	public String toString() {
		return "Profesor [dNI=" + dNI + ", nombre=" + nombre + ", edad=" + edad + ", salario=" + salario + ", sexo="
				+ sexo + ", listaCursos=" + listaCursos + "]";
	}

	public void altaCurso(Curso curso) {
		listaCursos.add(curso);
	}

	public void bajaCurso(Curso curso) {
		listaCursos.remove(curso);
	}

	public void listarCursos() {
		System.out.println(listaCursos);
	}

}
