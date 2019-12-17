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
	 * M�todo que se encarga de crear el gestor, el dao y el scanner
	 * que vamos a utilizar en nuestra aplicaci�n.
	 * El ciclo de vida de estos objetos ser� la de toda la aplicaci�n.
	 * �nicamente nos preocupamos de transferir las referencias a la
	 * aplicaci�n.
	 * @param args
	 */
	public static void main(String[] args) {
		
		VistaPeliculas vp = new VistaPeliculas();
		
		GestorPelicula gestorPelicula = new GestorPelicula();
		//El gestor de las pel�culas necesita del DAO.
		//Por lo tanto se hace por inyecci�n de su dependencia (ID)
		gestorPelicula.setDaoPelicula(new DaoPelicula());
				
		vp.mostrarApp(gestorPelicula, new Scanner(System.in));

	}

}
