package curso.modelo.entidad;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Component
public class Pedido {

	private int albaran;
	private String usuario;
	private List<Producto> listaProductos;
	private double importe;


	/**
	 * @return the albaran
	 */
	public int getAlbaran() {
		return albaran;
	}


	/**
	 * @param identidad the albaran to set
	 */
	public void setAlbaran(int albaran) {
		this.albaran = albaran;
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
		return "Pedido [albaran=" + albaran + ", usuario=" + usuario + ", listaProductos=" + lista
				+ ", importe=" + importe + "]";
	}
	
	
	
}
