package main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import modelo.entidad.Direccion;
import modelo.entidad.Persona;

public class MainSpring {

	//Esta referencia llevara el objeto de contexto de spring
	//y es el que controla el ciclo de vida de los objetos incluidos
	//en el fichero xml
	public static ApplicationContext context;
	
	public static void main(String[] args) {
		
		context = new ClassPathXmlApplicationContext("beans.xml");
		Persona p1 = (Persona) context.getBean("persona1");
		p1.setNombre("Harry Potter");
		Persona p2 = new Persona();
		p2.setNombre("Erion");
		
		imprimirPersonaNombre(p2);
		imprimirPersonaNombreSpring();
		
		//cast automático
		Persona pBud = context.getBean("bud",Persona.class);
		System.out.println(pBud);
		
		Persona pTerence = context.getBean("terence", Persona.class);
		System.out.println(pTerence);
		
		Persona pRon = context.getBean("ron", Persona.class);
		System.out.println(pRon);
		
		Direccion dRon = context.getBean("direccion1", Direccion.class);
		System.out.println(dRon);
		
		Persona pEsneip = context.getBean("esneip", Persona.class);
		System.out.println(pEsneip);
		
		//No se puede obtener directamente la dirección de Esneip porque no tiene referencia
		
		List<Persona> listaPersonas = context.getBean("listaPersonas", List.class);
		
		listaPersonas.add(pRon);
		System.out.println(listaPersonas);
		
		//Ahora obtenemos la  lista de objetos inyectados por dependencias
		
		List<Persona> personas = context.getBean("personas", List.class);
		personas.add(pEsneip);
		System.out.println("Personas inyectadas en bean.xml y otra añadida en en Main");
		for (Persona p : personas) {
			System.out.println(p);
		}
		
		
		// Ejemplo PROTOTYPE
		
		Persona p8 = context.getBean("personaPrototype", Persona.class);
		Persona p7 = context.getBean("personaPrototype", Persona.class);
		
		List<Persona> listaPersonasPrototype = context.getBean("listaPersonasSingleton", List.class);
		listaPersonasPrototype.add(p7);
		listaPersonasPrototype.add(p7);
		
		System.out.println("Asignar el ciclo de vida prototype a Spring");
		System.out.println(listaPersonasPrototype);
		

	}

	private static void imprimirPersonaNombreSpring() {
		Persona p1 = (Persona) context.getBean("persona1");
		System.out.println(p1.getNombre());
		
	}

	private static void imprimirPersonaNombre(Persona p) {
		System.out.println(p.getNombre());
		
	}

}
