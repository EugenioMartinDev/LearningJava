package modelo.entidad;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainVehiculos {
	
	public static ApplicationContext context;
	
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("beans.xml");
		
		Coche coche1 = context.getBean("renault",Coche.class);
		Coche coche2 = context.getBean("peugeot",Coche.class);
		Coche coche3 = context.getBean("ferrari",Coche.class);
		Coche coche4 = context.getBean("herbie",Coche.class);
		Coche coche5 = context.getBean("motoAgua",Coche.class);
		
		System.out.println(coche1);
		System.out.println(coche2);
		System.out.println(coche3);
		System.out.println(coche4);
		System.out.println(coche5);
	}
}
