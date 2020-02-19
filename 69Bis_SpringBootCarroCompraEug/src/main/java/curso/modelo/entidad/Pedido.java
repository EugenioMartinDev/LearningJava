package curso.modelo.entidad;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Component
public class Pedido {

	private int identidad;
	private Usuario usuario;
	private List<Categoria> listaCategorias;
	private List<Producto> listaProductosPorCategoria;
	private List<Producto> listaProductos;
	private List<Producto> listaProductosSeleccionados = new ArrayList<Producto>();
	private double importe;


	/**
	 * @return the listaProductosSeleccionados
	 */
	public List<Producto> getListaProductosSeleccionados() {
		return listaProductosSeleccionados;
	}



	/**
	 * @param listaProductosSeleccionados the listaProductosSeleccionados to set
	 */
	public void setListaProductosSeleccionados(List<Producto> listaProductosSeleccionados) {
		this.listaProductosSeleccionados = listaProductosSeleccionados;
	}



	/**
	 * @return the listaCategorias
	 */
	public List<Categoria> getListaCategorias() {
		return listaCategorias;
	}



	/**
	 * @param listaCategorias the listaCategorias to set
	 */
	public void setListaCategorias(List<Categoria> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}



	/**
	 * @return the listaProductosPorCategoria
	 */
	public List<Producto> getListaProductosPorCategoria() {
		return listaProductosPorCategoria;
	}



	/**
	 * @param listaProductosPorCategoria the listaProductosPorCategoria to set
	 */
	public void setListaProductosPorCategoria(List<Producto> listaProductosPorCategoria) {
		this.listaProductosPorCategoria = listaProductosPorCategoria;
	}



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
	public Usuario getUsuario() {
		return usuario;
	}



	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
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
		
		return "Pedido [identidad=" + identidad + ", usuario=" + usuario + ", listaProductos=" + lista
				+ ", importe=" + importe + "]";
	}
	
	
	
}
