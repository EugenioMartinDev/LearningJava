package entidad;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAutowire {
	
	private static ApplicationContext context;

	public static void main(String[] args) {
		
		context = new ClassPathXmlApplicationContext("beans.xml");
		
		Pelicula pelicula = context.getBean("pelicula", Pelicula.class);
		
		System.out.println(pelicula.getDirector().getNombre()); //Harry Potter en beans.xml

	}

}
