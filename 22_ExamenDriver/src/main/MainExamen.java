package main;

import java.util.Scanner;

import modelo.negocio.GestorPelicula;
import modelo.persistencia.DaoPelicula;
import vista.VistaPeliculas;

/**
 * @author aula2m
 *
 */
public class MainExamen {

	
	/**
	 * Método que se encarga de crear el gestor, el dao y el scanner
	 * que vamos a utilizar en nuestra aplicación.
	 * El ciclo de vida de estos objetos será la de toda la aplicación.
	 * Únicamente nos preocupamos de transferir las referencias a la
	 * aplicación.
	 * @param args
	 */
	public static void main(String[] args) {
		
		VistaPeliculas vp = new VistaPeliculas();
		
		GestorPelicula gestorPelicula = new GestorPelicula();
		//El gestor de las películas necesita del DAO.
		//Por lo tanto se hace por inyección de su dependencia (ID)
		gestorPelicula.setDaoPelicula(new DaoPelicula());
				
		vp.mostrarApp(gestorPelicula, new Scanner(System.in));

	}

}
