package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import modelo.entidad.Casa;

public class MainSpring {

	public static ApplicationContext context;
	
	public static void main(String[] args) {
		
		context = new ClassPathXmlApplicationContext("beans.xml");
		
		Casa casa = context.getBean("casa", Casa.class);
		
		System.out.println(casa);

	}


}
