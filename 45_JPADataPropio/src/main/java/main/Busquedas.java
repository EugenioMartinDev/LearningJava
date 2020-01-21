package main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.Configuracion;
import modelo.entidad.Pelicula;
import modelo.persistencia.PeliculaDao;

public class Busquedas {

	public static void main(String[] args) {
		
		
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(
						Configuracion.class);	
		
		PeliculaDao pd = context.getBean("peliculaDao", PeliculaDao.class);
		
		List<Pelicula> lista = pd.findByTitulo("titanic");
		
		System.out.println(lista);

	}

}
