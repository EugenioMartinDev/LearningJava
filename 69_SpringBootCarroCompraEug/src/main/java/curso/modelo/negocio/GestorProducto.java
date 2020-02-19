package curso.modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import curso.modelo.entidad.Categoria;
import curso.modelo.entidad.Producto;
import curso.modelo.persistencia.DaoCategoria;
import curso.modelo.persistencia.DaoProducto;

@Service
public class GestorProducto {

	@Autowired
	private DaoProducto dp;
	
	@Autowired
	private DaoCategoria dc;

	public List<Producto> obtenerProductos() {
		
		return dp.findAll();
	}

	public List<Categoria> obtenerCategorias() {
		return dc.findAll();
	}

	public List<Producto> obtenerProductosPorCategoria(Categoria categoria) {
		
		return dp.findByCategoria(categoria);

	}

	public Categoria obtenerCategoria(String nombreCategoria) {

		return dc.findByNombre(nombreCategoria);
	}
	
}
