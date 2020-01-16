package vista;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import modelo.entidad.Director;
import modelo.entidad.Pelicula;
import modelo.negocio.GestorPeliculas;

//Esta clase hace labores de vista, cuya funcion basicamente
//es la de comunciarse con el cliente (entrada y salida de 
//información. Así como interacturar con la capa de modelo.negocio
public class MainPelicula {
	
	public static ApplicationContext context;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		context = new ClassPathXmlApplicationContext("context.xml");
		String opcion = "0";
		//creamos el gestor pelicula que es el que va
		//a llevar la logica de la aplicacion
		GestorPeliculas gp = context.getBean("gestorPeliculas", GestorPeliculas.class);
		do {
			System.out.println("1- Alta de pelicula");
			System.out.println("2- lista de peliculas");
			System.out.println("3- Buscar pelicula por titulo");
			System.out.println("4- Buscar por genero");
			opcion = sc.nextLine();
			if(opcion.equals("1")) {
				System.out.println("Introduzca el titulo:");
				//nextLine coje toda la frase, next coje palabra
				String titulo = sc.nextLine();
				System.out.println("Introduzca el genero:");
				String genero = sc.nextLine();
				System.out.println("Introduzca el nombre del director:");
				String nombreDirector = sc.nextLine();
				System.out.println("Introduzca la edad:");
				String edad = sc.nextLine();
				System.out.println("Introduzca el año de estreno:");
				String anioEstreno = sc.nextLine();
				
				int iEdad = Integer.parseInt(edad);//me cambia la edad de string a un entero
				int iAnioEstreno = Integer.parseInt(anioEstreno);
				
				Pelicula p = context.getBean("pelicula",Pelicula.class);
				p.setTitulo(titulo);
				p.setGenero(genero);
				p.setAnioEstreno(iAnioEstreno);
				
				p.getDirector().setNombre(nombreDirector);
				p.getDirector().setEdad(iEdad);
				
				//basandonos en la explicacion de la documentacion
				//del metodo alta, podemos darle información a nuestro
				//usuario
				boolean alta = gp.alta(p);
				if(alta) {
					System.out.println("Pelicula introducida correctamente");
				}else {
					System.out.println("La pelicula tiene que tener al menos 5 caracteres");
				}
			}else if(opcion.equals("2")) {
				ArrayList<Pelicula> peliculas = gp.getListaPeliculas();
				for(Pelicula p : peliculas) {
					System.out.println(p);
				}
			}else if(opcion.equals("3")) {
				System.out.println("Introduzca el titulo a buscar");
				String titulo = sc.nextLine();
				Pelicula p = gp.buscarPorTitulo(titulo);
				if(p == null) {
					System.out.println("La pelicula no se ha encontrado");
				}else {
					System.out.println(p);
				}
			}else if(opcion.equals("4")) {
				System.out.println("Introduzca el genero a buscar");
				String genero = sc.nextLine();
				//como la parte de la logica de negocio
				//la lleva el gestor, usamos el gestor creado
				//para buscar por genero
				ArrayList<Pelicula> lista = gp.buscarPorGenero(genero);
				if(lista.size() != 0) {
					System.out.println("La lista de peliculas por genero es:");
					for(Pelicula p : lista) {
						System.out.println(p);
					}
				}else {
					System.out.println("No hay conincidencias por genero");
				}
			}
		}while(!opcion.equals("0"));
		System.out.println("Fin del programa");
	}
	
	
	
}



