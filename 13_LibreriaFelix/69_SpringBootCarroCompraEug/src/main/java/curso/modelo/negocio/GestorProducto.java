package curso.modelo.negocio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.modelo.entidad.Pedido;
import curso.modelo.entidad.Producto;
import curso.modelo.persistencia.DaoProducto;

@Service
public class GestorProducto {

	@Autowired
	private DaoProducto dp;
	
	@Autowired
	private Pedido pedido;

	public List<Producto> obtenerProductos() {
		
		return dp.findAll();
	}

	public void tratarPedido(Producto p) {
		
		String nombre = p.getNombre();
		for (Producto pro : pedido.getListaProductos()) {
			if (nombre.contentEquals(pro.getNombre())) {
				pro.setUnidades(p.getUnidades());
				return;
			}
		}
		
	}

	public void generarPedido() {

		List<Producto> listaProductos = new ArrayList<Producto>();
		Double importe = 0.0;
		for (Producto pro : pedido.getListaProductos()) {
			if (pro.getUnidades() != 0) {
				importe = importe + pro.getPrecio() * pro.getUnidades();
				listaProductos.add(pro);
			}
		}
		
		pedido.setImporte(importe);	
		pedido.setListaProductos(listaProductos);
				
	}
	
	
}
