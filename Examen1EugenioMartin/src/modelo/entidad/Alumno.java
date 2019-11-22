package modelo.entidad;

public class Alumno {

	private String dNI;
	private String nombreCompleto;
	private String sexo;
	private int edad;
	private Curso curso;

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
	 * @return the nombreCompleto
	 */
	public String getNombreCompleto() {
		return nombreCompleto;
	}

	/**
	 * @param nombreCompleto the nombreCompleto to set
	 */
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
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
	 * @return the curso
	 */
	public Curso getCurso() {
		return curso;
	}

	/**
	 * @param curso the curso to set
	 */
	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	/**
	 * 
	 */
	public Alumno() {
		super();
	}

	@Override
	public String toString() {
		return "Alumno [dNI=" + dNI + ", nombreCompleto=" + nombreCompleto + ", sexo=" + sexo + ", edad=" + edad
				+ ", curso=" + curso.getIdCurso() + " de nombre= " + curso.getNombreCurso() + "]";
	}

}
