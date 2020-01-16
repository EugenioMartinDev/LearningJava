package modelo.entidad;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAnotaciones {
	
	private static ApplicationContext context;

	public static void main(String[] args) {
		
		context = new ClassPathXmlApplicationContext("context.xml");
		
		Pelicula pelicula = context.getBean("pelicula", Pelicula.class);
		
		System.out.println(pelicula);
	}

}
