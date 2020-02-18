package curso.modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.modelo.entidad.Producto;
import curso.modelo.persistencia.DaoProducto;

@Service
public class GestorProducto {

	@Autowired
	private DaoProducto dp;

	public List<Producto> obtenerProductos() {
		
		return dp.findAll();
	}
	
}
