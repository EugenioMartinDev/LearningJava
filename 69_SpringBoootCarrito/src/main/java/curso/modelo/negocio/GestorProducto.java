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
	
	public List<Producto> listar(){
		return dao.findAll();
	}
	
	public Producto obtener(int id) {
		//Optional es un invento de java 8 para intentar
		//resolver la problematica de los null pointer
		//En un envoltorio (wrapper) de producto
		Optional<Producto> op = dao.findById(id);
		if(op.isPresent()) {
			return op.get();//get devuelve el objeto interno
		}else {
			return null;
		}
		
	}
	
}
