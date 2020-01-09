package videojuego;

public abstract class Personaje {

	private int vida;
	private String nombre;
	private Arma arma;
	
	
	/**
	 * @return the vida
	 */
	public int getVida() {
		return vida;
	}


	/**
	 * @param vida the vida to set
	 */
	public void setVida(int vida) {
		this.vida = vida;
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


	public abstract void atacar();
	
}
