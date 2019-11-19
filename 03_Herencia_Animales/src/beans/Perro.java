package beans;

public class Perro extends Animal {

	private String due�o;

	/**
	 * 
	 */
	public Perro() {
		super();
	}

	/**
	 * @param due�o
	 */
	public Perro(String due�o) {
		super();
		this.due�o = due�o;
	}

	/**
	 * @return the due�o
	 */
	public String getDue�o() {
		return due�o;
	}

	/**
	 * @param due�o the due�o to set
	 */
	public void setDue�o(String due�o) {
		this.due�o = due�o;
	}

	@Override
	public String toString() {
		return "Perro [due�o=" + due�o + "]";
	}
	
	
	
}
