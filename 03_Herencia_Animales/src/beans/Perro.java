package beans;

public class Perro extends Animal {

	private String dueño;

	/**
	 * 
	 */
	public Perro() {
		super();
	}

	/**
	 * @param dueño
	 */
	public Perro(String dueño) {
		super();
		this.dueño = dueño;
	}

	/**
	 * @return the dueño
	 */
	public String getDueño() {
		return dueño;
	}

	/**
	 * @param dueño the dueño to set
	 */
	public void setDueño(String dueño) {
		this.dueño = dueño;
	}

	@Override
	public String toString() {
		return "Perro [dueño=" + dueño + "]";
	}
	
	
	
}
