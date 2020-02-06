package curso.modelo.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.modelo.entidad.Pedido;

@Service
public class GestorPedido {

	@Autowired
	private Pedido pedido;
	
	//classic way
	//public boolean validar(Pedido p) {
		
	//}
	
	public boolean validar() {
		try {
			if(pedido.getNombreCliente().isEmpty()) {
				return false;
			}else if(pedido.getDireccion().isEmpty()) {
				return false;
			}else if(pedido.getEmail().isEmpty()) {
				return false;
			}else if(pedido.getOrdenador().getRam().isEmpty()) {
				return false;
			}else if(pedido.getOrdenador().getProcesador().isEmpty()) {
				return false;
			}else if(pedido.getOrdenador().getListaPerifericos().isEmpty()) {
				return false;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
}
