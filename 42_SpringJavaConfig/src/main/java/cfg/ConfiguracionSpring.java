package cfg;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;

import entidad.Director;
import entidad.Pelicula;

//Esta clase ahora llevará la configuración de Spring en vez del fichero xml

//También se pueden dar de alta beans mediante las anotaciones en las entidades y hacer las referencias en este fichero.
@ComponentScan(basePackages = {"modelo", "entidad"}) 
public class ConfiguracionSpring {

	//Los beans se dan de alta con métodos anotados con la anotación @Bean
	//El id que se asigna es el nombre del método y la clase es del tipo devuelto
	@Bean
	@Scope("prototype")
	public Director director() {
		Director d = new Director();
		//ejemplo de asignar un valor de defecto.
		d.setNombre("Steven Spilberg");  //equivalente a property
		return d;
	}
	//Lo de arriba sería equivalente <bean id="director" class=Director.class
	//                                <property name="Nombre" value="Steven Spilberg"></property>
	//                                </bean>
	
	//Se inyecta el objeto director mediante un parámetro de entrada en el método pelicula. Spring hace por defecto Autowired.
	//Si hay dos objetos con la misma id, daría error, porque Autowired no sabría cuál elegir.
	@Bean
	@Scope("prototype")
	public Pelicula pelicula(Director director) {
		Pelicula p = new Pelicula();
		p.setDirector(director);
		return p;
		
	}
	
	@Bean(name="director")
	@Scope("prototype")
	public Director otroDirector() {
		Director d = new Director();
		//ejemplo de asignar un valor de defecto.
		d.setNombre("George Lucas");  //equivalente a property
		return d;
	}
	
	//Con la anotacion Qualifier se puede elegir el objeto en concreto
	@Bean
	@Scope("prototype")
	public Pelicula otraPelicula(@Qualifier("directorPepe")Director director) {
		Pelicula p = new Pelicula();
		p.setDirector(director);
		return p;
		
	}
	
	@Bean
	@Scope("prototype")
	public Director directorPepe() {
		Director d = new Director();
		//ejemplo de asignar un valor de defecto.
		d.setNombre("Pepe pepez");  //equivalente a property
		return d;
	}
	

	
	
}
