package curso.modelo.entidad;

import java.util.List;

import org.springframework.web.context.annotation.SessionScope;

@SessionScope
public class Pedido {

	private int identidad;
	private String usuario;
	private List<Producto> listaProductos;
	private double importe;


	/**
	 * @return the identidad
	 */
	public int getIdentidad() {
		return identidad;
	}


	/**
	 * @param identidad the identidad to set
	 */
	public void setIdentidad(int identidad) {
		this.identidad = identidad;
	}


	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}


	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	/**
	 * @return the listaProductos
	 */
	public List<Producto> getListaProductos() {
		return listaProductos;
	}


	/**
	 * @param listaProductos the listaProductos to set
	 */
	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}


	/**
	 * @return the importe
	 */
	public double getImporte() {
		return importe;
	}


	/**
	 * @param importe the importe to set
	 */
	public void setImporte(double importe) {
		this.importe = importe;
	}


	@Override
	public String toString() {
		
		String lista = "";
		for (Producto pp : listaProductos) {
			lista = lista + "[" + 
					pp.toString()
					+ "]";
		}
		return lista;
	}
	
	
	
}
