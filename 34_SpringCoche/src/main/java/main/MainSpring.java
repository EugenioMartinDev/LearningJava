package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import modelo.entidad.Coche;

public class MainSpring {

	//Esta referencia llevara el objeto de contexto de spring
	//y es el que controla el ciclo de vida de los objetos incluidos
	//en el fichero xml
	public static ApplicationContext context;

	
	public static void main(String[] args) {
		
		context = new ClassPathXmlApplicationContext("beans.xml");
		
		Coche c1 = context.getBean("coche1", Coche.class);
		System.out.println(c1);
		Coche c2 = context.getBean("coche2", Coche.class);
		System.out.println(c2);
		Coche c3 = context.getBean("coche3", Coche.class);
		System.out.println(c3);
		Coche c4 = context.getBean("coche4", Coche.class);
		System.out.println(c4);
		Coche c5 = context.getBean("coche5", Coche.class);
		System.out.println(c5);
		
		Coche c6 = context.getBean("coche6", Coche.class);
		System.out.println(c6);

		//imprimirCoches();
	}

	private static void imprimirCoches() {
		System.out.println(context.getBean("coche1", Coche.class));
		System.out.println(context.getBean("coche2", Coche.class));
		System.out.println(context.getBean("coche3", Coche.class));
		System.out.println(context.getBean("coche4", Coche.class));
		System.out.println(context.getBean("coche5", Coche.class));		
	}


}
