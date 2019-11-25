package vista;

import modelo.entidad.Persona;

public class MainEstatico {

	// Ojo: main es estático, ya que debe existir antes de un 
	// objeto para que la JVM lo ejecute antes del comienzo de la instanciación
	public static void main(String[] args) {
		
		Persona p1 = new Persona();
		//Se accede al método setNombre a través del objeto
		p1.setNombre("Juan");
		p1.setEdad(85);
		//El atributo numeroPersonas es estático (y público, claro). Depende de la
		//clase y no de ningún objeto. Todos los objetos comparten ese atributo.
		Persona.numeroPersonas ++;

		//El método imprimirEstatico (función imprimir) se puede llamar desde un método
		//estático, sin instanciar ningún objeto, porque se ha definido imprimir
		//como estático.
		imprimirEstatico(p1);
		
		//El método imprimirDinamico se debe llamar desde un objeto (new MainEstatico)
		//porque el método estático main no ve a los métodos dinámicos directamente.
		new MainEstatico().imprimirDinamico(p1);
		
		System.out.println("Número de personas : " + Persona.numeroPersonas);

	}

	public static void imprimirEstatico(Persona persona) {
		
		System.out.println(persona);
		
	}
	
	public void imprimirDinamico(Persona persona) {
		
		System.out.println(persona);
		
	}
	
}
