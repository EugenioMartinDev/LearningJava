package main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.Configuracion;
import modelo.entidad.Pelicula;
import modelo.persistencia.PeliculaDao;

public class MainBusquedas {
	public static void main(String[] args) {
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(
						Configuracion.class);
		
		PeliculaDao pd = context.getBean("peliculaDao",PeliculaDao.class);
		List<Pelicula> lista = pd.findByTitulo("titan");
		System.out.println(lista);
		lista = pd.findByTituloContaining("titan");
		System.out.println(lista);
		lista = pd.findByTituloOrGenero("pesadilla", "amor");
		System.out.println(lista);
		lista = pd.findByTituloAndGenero("pesadilla", "amor");
		System.out.println(lista);
	}
}
