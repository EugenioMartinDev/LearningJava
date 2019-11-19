package beans;

public class Departamento {

	private int idDepartamento;	
	private String nombre;	
	private Empleado jefe;

	/**
	 * @param idDepartamento
	 * @param nombre
	 */
	public Departamento(int idDepartamento, String nombre) {
		super();
		this.idDepartamento = idDepartamento;
		this.nombre = nombre;
	}

	/**
	 * @param idDepartamento
	 * @param nombre
	 * @param jefe
	 */
	public Departamento(int idDepartamento, String nombre, Empleado jefe) {
		super();
		this.idDepartamento = idDepartamento;
		this.nombre = nombre;
		this.jefe = jefe;
	}

	/**
	 * 
	 */
	public Departamento() {
		super();
	}

	/**
	 * @return the idDepartamento
	 */
	public int getIdDepartamento() {
		return idDepartamento;
	}

	/**
	 * @param idDepartamento the idDepartamento to set
	 */
	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
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
	 * @return the jefe
	 */
	public Empleado getJefe() {
		return jefe;
	}

	/**
	 * @param jefe the jefe to set
	 */
	public void setJefe(Empleado jefe) {
		this.jefe = jefe;
	}

	@Override
	public String toString() {
		if (jefe == null)
			return "Departamento [idDepartamento=" + idDepartamento + ", nombre=" + nombre + " jefe " + jefe +  "]";
		else
			return "Departamento [idDepartamento=" + idDepartamento + ", nombre=" + nombre + " jefe " + jefe.getNombre() + " " + jefe.getApellido() +  "]";
	}
	
}
