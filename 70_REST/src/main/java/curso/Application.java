package curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import curso.modelo.entidad.Pelicula;
import curso.modelo.persistancia.DaoPelicula;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		
		DaoPelicula dp = context.getBean("daoPelicula", DaoPelicula.class);
		
		Pelicula p = new Pelicula();
		p.setTitulo("Cocodrilo Dundee");
		p.setGenero("accion");
		p.setDirector("Pedro almodovar");
		p.setYear(1985);
		
		dp.save(p);
	}

}
