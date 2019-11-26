package entidad;

//Para heredar una clase de otra se usa la palabra
//reservada extends

//Se puede definir una clase abstracta aunque no tenga métodos abstractos.
public abstract class Pez extends Animal {

	private int numeroAletas;

	/**
	 * @return the numeroAletas
	 */
	public int getNumeroAletas() {
		return numeroAletas;
	}

	/**
	 * @param numeroAletas the numeroAletas to set
	 */
	public void setNumeroAletas(int numeroAletas) {
		this.numeroAletas = numeroAletas;
	}

	// En "source" se selecciona el atributo propio numeroAletas y el atributo
	// protected heredado : nombre
	// También se seleccionan los getters de los atributos privados heredados : getPeso y getEdad.

	@Override
	public String toString() {
		return "Pez [numeroAletas=" + numeroAletas + ", nombre=" + nombre + ", getPeso()=" + getPeso() + ", getEdad()="
				+ getEdad() + "]";
	}
	
	

	@Override
	public void comer(Object comida) {
		// instanceof preguntamos la clase del objeto apuntado
		if (comida instanceof Placton) {
			Placton placton = (Placton) comida;
			System.out.println(
					"Soy un pez que me llamo " + nombre + " y como placton con " + placton.getCalorias() + " calorías");
			double pesoPorCaloria = (double)placton.getCalorias()/1000;
			this.setPeso(this.getPeso() + pesoPorCaloria);  //"this" no es necesario pero ayuda a seleccionar el método
			
		} else {
			System.out.println("Puajjjj... no me gusta eso :( :(");
		}

	}

}
