package modelo.negocio;

import modelo.entidad.Pedido;

public class GestorPedido {

	/**
	 * Metodo que valida que un pedido no este vacio, todos
	 * los campos deben de estar rellenos
	 * @param pedido representa el pedido a validar
	 * @return <b>true</b> en caso de que todos los campos
	 * esten rellenos, <b>false</b> en caso de que haya algun
	 * campo que no lo este 
	 */
	public boolean validar(Pedido pedido) {
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
