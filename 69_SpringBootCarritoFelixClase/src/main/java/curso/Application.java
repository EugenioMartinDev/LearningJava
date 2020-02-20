package curso;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

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
		p.setId(0);
		daoProducto.save(p);
		
		p.setNombre("Tomates");
		p.setPrecio(3.4);
		p.setId(0);
		daoProducto.save(p);
		
		p.setNombre("Huevos");
		p.setPrecio(2.3);
		p.setId(0);
		daoProducto.save(p);
		
		p.setNombre("Leche");
		p.setPrecio(4.8);
		p.setId(0);
		daoProducto.save(p);
		
		p.setNombre("Vino");
		p.setPrecio(12.4);
		p.setId(0);
		daoProducto.save(p);
		
		Usuario usuario = new Usuario();
		
		DaoUsuario daoUsuario = context.getBean("daoUsuario", DaoUsuario.class);
		
		usuario.setNombre("Felix");
		usuario.setPassword("1234");
		
		daoUsuario.save(usuario);
		
		
	}

}
