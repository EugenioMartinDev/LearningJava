package curso.modelo.negocio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.modelo.entidad.Producto;
import curso.modelo.persistencia.DaoProducto;

@Service
public class GestorProducto {

	@Autowired
	private DaoProducto dao;
	
	public List<Producto> listar() {
		return dao.findAll();
	}
	
	public Producto obtener(int id) {
		//Optional (desde Java8) : resuelve el problema del null pointer
		//Es un wrapper que contiene el objeto si encuentra el objeto o un nulo si no lo encuentra
		Optional<Producto> op = dao.findById(id);
		
		if (op.isPresent()) {
			return op.get();
		} else {
			return null;
		}
	}

}
