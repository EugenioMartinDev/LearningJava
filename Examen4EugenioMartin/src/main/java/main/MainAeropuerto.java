package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import modelo.entidad.Aeropuerto;
import modelo.entidad.Asiento;
import modelo.entidad.Avion;

public class MainAeropuerto {

	public static ApplicationContext context;
	
	public static void main(String[] args) {
		
		context = new ClassPathXmlApplicationContext("beans.xml");
		
		Avion av1 = context.getBean("avion1", Avion.class);
		for (int i=1; i<=134; i++) {
			Asiento a = context.getBean("asiento", Asiento.class);
			a.setNumero(i);
			av1.getListaAsientos().add(a);
		}
		
		Avion av2 = context.getBean("avion2", Avion.class);
		for (int i=1; i<=64; i++) {
			Asiento a = context.getBean("asiento", Asiento.class);
			a.setNumero(i);
			av2.getListaAsientos().add(a);
		}
		
		Aeropuerto ap = context.getBean("aeropuerto", Aeropuerto.class);
		
		
		
		System.out.println(ap);

	}

}
