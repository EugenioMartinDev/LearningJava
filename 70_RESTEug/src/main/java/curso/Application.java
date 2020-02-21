package curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import curso.modelo.entidad.Pelicula;
import curso.modelo.persistencia.DaoPelicula;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		
		Pelicula p = new Pelicula();
		
		p.setDirector("Jose");
		p.setTitulo("La mesa");
		p.setYear(1027);
		
		DaoPelicula dao = context.getBean("daoPelicula", DaoPelicula.class);
		
		dao.save(p);
	}

}
