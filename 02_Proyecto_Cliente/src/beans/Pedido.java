package beans;

public class Pedido {

	private int idPedido;
	private String descripcion;
	private double importe;
	private boolean conIva;
	private Cliente cliente;
	/**
	 * @param idPedido
	 * @param descripcion
	 * @param importe
	 * @param conIva
	 * @param cliente
	 */
	public Pedido(int idPedido, String descripcion, double importe, boolean conIva, Cliente cliente) {
		super();
		this.idPedido = idPedido;
		this.descripcion = descripcion;
		this.importe = importe;
		this.conIva = conIva;
		this.cliente = cliente;
	}
	/**
	 * 
	 */
	public Pedido() {
		super();
	}
	/**
	 * @return the idPedido
	 */
	public int getIdPedido() {
		return idPedido;
	}
	/**
	 * @param idPedido the idPedido to set
	 */
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	/**
	 * @return the conIva
	 */
	public boolean isConIva() {
		return conIva;
	}
	/**
	 * @param conIva the conIva to set
	 */
	public void setConIva(boolean conIva) {
		this.conIva = conIva;
	}
	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}
	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", descripcion=" + descripcion + ", importe=" + importe + ", conIva="
				+ conIva + ", cliente=" + cliente + "]";
	}
	
	
	public static Pedido damePedido() {
		
		return null;
	}
	
	
	public static Pedido[] damePedidos() {
		
		Pedido[] pedidos = null;
		
		return pedidos;
	}
	
	public double totalImporte(int iva) {
		
		if (this.conIva){
			return (this.importe+this.importe*iva/100);
		}
		else
			System.out.print("Pedido " + this.idPedido + " no incluye IVA |||| ");
		
		return this.importe;
	}
}
