package curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import curso.modelo.entidad.Producto;
import curso.modelo.entidad.Usuario;
import curso.modelo.persistencia.DaoProducto;
import curso.modelo.persistencia.DaoUsuario;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		
		Producto p = context.getBean("producto", Producto.class);
		
		DaoProducto daoProducto = context.getBean("daoProducto", DaoProducto.class);
		
		p.setNombre("Patatas");
		p.setPrecio(1.2);
		daoProducto.save(p);
		
		p = context.getBean("producto", Producto.class);
		
		p.setNombre("Tomates");
		p.setPrecio(1.5);
		daoProducto.save(p);
		
		p = context.getBean("producto", Producto.class);
				
		p.setNombre("Huevos");
		p.setPrecio(2);
		daoProducto.save(p);
		
		p = context.getBean("producto", Producto.class);
		
		p.setNombre("Leche");
		p.setPrecio(0.8);
		daoProducto.save(p);
		
		p = context.getBean("producto", Producto.class);
		
		p.setNombre("Vino");
		p.setPrecio(3.5);
		daoProducto.save(p);
		
		DaoUsuario daoUsuario = context.getBean("daoUsuario", DaoUsuario.class);
		
		Usuario usuario = new Usuario();
		usuario.setNombre("felix");
		usuario.setPassword("1234");
	
		daoUsuario.save(usuario);
	}

}
