package videojuego;

public abstract class Personaje {

	private String nombre;
	private Arma arma;
	private Double potencia;
			
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
	 * @return the arma
	 */
	public Arma getArma() {
		return arma;
	}

	/**
	 * @param arma the arma to set
	 */
	public void setArma(Arma arma) {
		this.arma = arma;
	}

	
	
	/**
	 * @return the potencia
	 */
	public Double getPotencia() {
		return potencia;
	}

	/**
	 * @param potencia the potencia to set
	 */
	public void setPotencia(Double potencia) {
		this.potencia = potencia;
	}

	public abstract void atacar();

	/**
	 * 
	 * @param personaje
	 * @return true is el personaje ha sido vencido
	 */
	public boolean lucha(Personaje personaje) {
		boolean vencido = false;
		atacar();
		Double valorContrincante = personaje.getPotencia();
		Double valorPropio = this.getArma().getValor();
		Double resultado = valorContrincante - valorPropio;
		personaje.setPotencia(resultado);
		if (resultado <=0 ) {
			vencido = true;
		}
		return vencido;
	}
	
}
