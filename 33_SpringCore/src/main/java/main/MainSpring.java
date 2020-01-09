package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import modelo.entidad.Persona;

public class MainSpring {

	//Esta referencia llevara el objeto de contexto de spring
	//y es el que controla el ciclo de vida de los objetos incluidos
	//en el fichero xml
	public static ApplicationContext context;
	
	public static void main(String[] args) {
		
		context = new ClassPathXmlApplicationContext("beans.xml");
		Persona p1 = (Persona) context.getBean("persona1");
		System.out.println(p1);

	}

}
