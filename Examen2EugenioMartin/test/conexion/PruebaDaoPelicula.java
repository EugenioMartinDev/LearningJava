package conexion;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.negocio.Pelicula;

import modelo.persistencia.DaoPelicula;

public class PruebaDaoPelicula {

	public static void main(String[] args) throws SQLException {
		
		DaoPelicula daoPelicula = new DaoPelicula();
		
		if (daoPelicula.abrirConexion()) {
			System.out.println("conexión establecida");
			
			//Prueba de Alta
			
			System.out.println("PRUEBA DE ALTA");
			System.out.println("______________");
			
			Pelicula pelicula = new Pelicula();
			pelicula.setTitulo("El árbol");			
			pelicula.setDirector("Jose");
			pelicula.setGenero("Humor");
			pelicula.setAnioPublicacion(2007);

			if (daoPelicula.alta(pelicula)) {
				System.out.println("Dado de alta la película El árbol");
			} else {
				System.out.println("Error : falla el alta de la película El árbol");
			};
			
			pelicula.setTitulo("El misil");			
			pelicula.setDirector("Juan");
			pelicula.setGenero("Guerra");
			pelicula.setAnioPublicacion(2015);

			if (daoPelicula.alta(pelicula)) {
				System.out.println("Dado de alta la película El misil");
			} else {
				System.out.println("Error : falla el alta de la película El misil");
			};
			
			pelicula.setTitulo("La jauria");			
			pelicula.setDirector("Pablo");
			pelicula.setGenero("Terror");
			pelicula.setAnioPublicacion(1998);

			if (daoPelicula.alta(pelicula)) {
				System.out.println("Dado de alta la película La jauria");
			} else {
				System.out.println("Error : falla el alta de la película La jauria");
			};
				
			
			// Prueba de Baja

			System.out.println("PRUEBA DE BAJA");
			System.out.println("______________");
			
			int id = 17;
			pelicula = daoPelicula.obtener(id);
			if (pelicula != null) {
				daoPelicula.borrar(id);
				System.out.println("Se ha borrado la pelicula: " + pelicula);
			} else {
				System.out.println("No existe una pelicula de identidad: " + id);
			}
			
			// Prueba de Modificar

			System.out.println("PRUEBA DE MODIFICAR");
			System.out.println("___________________");
			
			Pelicula peliculaMod = new Pelicula();
			
			id = 18;
			peliculaMod.setId(id);
			Pelicula peliculaBuscada = daoPelicula.obtener(id);
			
			if (peliculaBuscada != null) {		
				peliculaMod.setTitulo("El jaguar");			
				peliculaMod.setDirector("Luis");
				peliculaMod.setGenero("Documental");
				peliculaMod.setAnioPublicacion(2018);
				
				if (daoPelicula.modificar(peliculaMod)) {
					System.out.println("Modificada la película: " + peliculaBuscada + " con la nueva:  " + peliculaMod);
				} else {
					System.out.println("Error : falla modificación la película El jaguar");
				};
			} else {
				System.out.println("No existe la película con identidad: " + id);
			}
			
			// Prueba de Buscar

			System.out.println("PRUEBA DE BUSCAR");
			System.out.println("________________");
			
			id = 16;

			pelicula = daoPelicula.obtener(id);
			
			if (pelicula != null ) { 		
				System.out.println("Se ha encontrado la película: " + pelicula);
			} else {
				System.out.println("No se encontrado la película de identidad: " + id);
			}
			
			// Prueba de Listar

			System.out.println("PRUEBA DE LISTAR");
			System.out.println("________________");
			
			ArrayList<Pelicula> listaPeliculas = (ArrayList) daoPelicula.listar();
			
			if (listaPeliculas.size() > 0) {
				System.out.println("Se han encontrado " + listaPeliculas.size() + " películas");
				for (Pelicula elementoPelicula : listaPeliculas) {
					System.out.println(elementoPelicula);
				}
			} else
			{
				System.out.println("No se ha encontrado ninguna película");
			}
			
		} else {
			System.out.println("fallo de conexión");
		}
		
		if (daoPelicula != null) {
			if (daoPelicula.cerrarConexiones()) {
				System.out.println("conexión borrada");
			} else {
				System.out.println("fallo en la desconexión");
			}
	
		}
	}
}
