package cfg;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;

import modelo.entidad.Cliente;
import modelo.negocio.GestorClientes;
import modelo.persistencia.DaoClientes;
import vista.Vista;


public class ConfiguracionSpring {

	@Bean
	@Scope("prototype")
	public Cliente cliente() {
		Cliente c = new Cliente();
		return c;
	}

	@Bean
	public GestorClientes gestorClientes(DaoClientes daoClientes) {
		GestorClientes gc = new GestorClientes();
		gc.setDaoClientes(daoClientes);
		return gc;		
	}
	
	@Bean
	public DaoClientes daoClientes() {
		DaoClientes dc = new DaoClientes();
		return dc;
		
	}
	
	@Bean
	public Vista vista(GestorClientes gestorClientes) {
		Vista v = new Vista();
		v.setGc(gestorClientes);
		return v;		
	}
	
	
}
