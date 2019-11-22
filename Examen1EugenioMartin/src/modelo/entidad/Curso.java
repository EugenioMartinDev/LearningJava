package modelo.entidad;

import java.util.ArrayList;

public class Curso {

	private String idCurso;
	private String nombreCurso;
	private int horas;
	private double precio;
	private Profesor profesor;
	private ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();

	/**
	 * @return the idCurso
	 */
	public String getIdCurso() {
		return idCurso;
	}

	/**
	 * @param idCurso the idCurso to set
	 */
	public void setIdCurso(String idCurso) {
		this.idCurso = idCurso;
	}

	/**
	 * @return the nombreCurso
	 */
	public String getNombreCurso() {
		return nombreCurso;
	}

	/**
	 * @param nombreCurso the nombreCurso to set
	 */
	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}

	/**
	 * @return the horas
	 */
	public int getHoras() {
		return horas;
	}

	/**
	 * @param horas the horas to set
	 */
	public void setHoras(int horas) {
		this.horas = horas;
	}

	/**
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * @return the profesor
	 */
	public Profesor getProfesor() {
		return profesor;
	}

	/**
	 * @param profesor the profesor to set
	 */
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	/**
	 * @return the listaAlumnos
	 */
	public ArrayList<Alumno> getListaAlumnos() {
		return listaAlumnos;
	}

	/**
	 * @param listaAlumnos the listaAlumnos to set
	 */
	public void setListaAlumnos(ArrayList<Alumno> listaAlumnos) {
		this.listaAlumnos = listaAlumnos;
	}

	/**
	 * 
	 */
	public Curso() {
		super();
	}

	@Override
	public String toString() {
		return "Curso [idCurso=" + idCurso + ", nombreCurso=" + nombreCurso + ", horas=" + horas + ", precio=" + precio
				+ ", profesor=" + profesor.getNombre() + " de nombre " + profesor.getNombre() + ", listaAlumnos="
				+ listaAlumnos + "]";
	}

	public void altaAlumno(Alumno alumno) {
		listaAlumnos.add(alumno);
	}

	public void bajaAlumno(Alumno alumno) {
		listaAlumnos.remove(alumno);
	}

	public void listaAlumnos() {
		System.out.println(listaAlumnos);
	}

}
