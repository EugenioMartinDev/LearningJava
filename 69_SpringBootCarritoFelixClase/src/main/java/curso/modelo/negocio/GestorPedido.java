package curso.modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.modelo.entidad.Pedido;
import curso.modelo.entidad.Producto;

@Service
public class GestorPedido {

	@Autowired 
	private Pedido pedido;
	
	public void calculaPrecioTotal() {
		
		List<Producto> listaProductos = pedido.getListaProductos();
		
		double precioTotal = 0;
		
		for (Producto p : listaProductos) {
			precioTotal += p.getPrecio();
		}
		pedido.setPrecioTotal(precioTotal);
	}
	
}
