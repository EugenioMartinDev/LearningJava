package modelo.entidad;


public class Persona {
	
		private String nombre;
		private int edad;
		private double peso;
		private Direccion direccion;
		
		/**
		 * 
		 */
		public Persona() {
			super();
		}
		/**
		 * @param nombre
		 * @param edad
		 * @param peso
		 */
		public Persona(String nombre, int edad, double peso) {
			super();
			this.nombre = nombre;
			this.edad = edad;
			this.peso = peso;
		}		
		/**
		 * @param nombre
		 * @param edad
		 * @param peso
		 * @param direccion
		 */
		public Persona(String nombre, int edad, double peso, Direccion direccion) {
			super();
			this.nombre = nombre;
			this.edad = edad;
			this.peso = peso;
			this.direccion = direccion;
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
		 * @return the peso
		 */
		public double getPeso() {
			return peso;
		}
		/**
		 * @param peso the peso to set
		 */
		public void setPeso(double peso) {
			this.peso = peso;
		}
		
		/**
		 * @return the direccion
		 */
		public Direccion getDireccion() {
			return direccion;
		}
		/**
		 * @param direccion the direccion to set
		 */
		public void setDireccion(Direccion direccion) {
			this.direccion = direccion;
		}
		@Override
		public String toString() {
			return "Persona [nombre=" + nombre + ", edad=" + edad + ", peso=" + peso + ", direccion=" + direccion + "]";
		}

		
		
		
}
