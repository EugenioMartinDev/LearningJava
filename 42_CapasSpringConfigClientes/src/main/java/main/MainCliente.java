package main;


import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cfg.ConfiguracionSpring;
import modelo.negocio.GestorClientes;
import utils.Constantes;
import vista.Vista;

/*
 * 
 * Ejercio

CRUD (create, read, update, delete) de clientes

los clientes van a tener los siguientes atributos

id, dni, nombre, edad

tendremos un menu que muestre lo siguiente

1- alta de cliente
2- listar clientes
3- buscar cliente por id
4- buscar clientes por nombre
5- borrar cliente por id

Requisitos funcionales (van a ir en el gestor)
	1- El dni tiene que tener 9 caracteres
	2- (optativo) el dni debe de acabar con letra
	3- (optativo) no puede haber 2 dnis iguales en la bbdd (esto podria ir en la bbdd)
 * 
 */

public class MainCliente {
	
	public static ApplicationContext context;
	
	public static void main(String[] args) {
		
		context = new AnnotationConfigApplicationContext(ConfiguracionSpring.class);
		
		Vista vistaCliente = context.getBean("vista", Vista.class);
		Scanner sc = new Scanner(System.in);
		vistaCliente.setSc(sc);
		
		vistaCliente.execute();
		
		sc.close();
		

	}


}
