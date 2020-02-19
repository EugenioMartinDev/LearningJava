package curso.modelo.negocio;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.modelo.entidad.Producto;
import curso.modelo.persistencia.DaoProducto;

@Service
public class GestorProducto {

	@Autowired
	private DaoProducto dao;
	
	public List<Producto> getLista(){
		
		List<Producto> listaInversa = dao.findAll();		
		Collections.reverse(listaInversa);
		
		return listaInversa;
		
	}
	
	public void alta(Producto o) {
		dao.save(o);
	}

}
