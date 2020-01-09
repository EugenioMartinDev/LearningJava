package videojuego;

public abstract class Arma {
	private String tipo;
	private int danioMax;
	private int danioMin;

	/**
	 * @return the danioMax
	 */
	public int getDanioMax() {
		return danioMax;
	}

	/**
	 * @param danioMax the danioMax to set
	 */
	public void setDanioMax(int danioMax) {
		this.danioMax = danioMax;
	}

	/**
	 * @return the danioMin
	 */
	public int getDanioMin() {
		return danioMin;
	}

	/**
	 * @param danioMin the danioMin to set
	 */
	public void setDanioMin(int danioMin) {
		this.danioMin = danioMin;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public abstract int usar();

	@Override
	public String toString() {
		return "Arma [tipo=" + tipo + ", danioMax=" + danioMax + ", danioMin=" + danioMin + "]";
	}
	
	
}
