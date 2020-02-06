package curso.modelo.entidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class Pedido {
	private String nombreCliente;
	private String direccion;
	private String email;
	@Autowired
	private Ordenador ordenador;
	private String comentario;
	
	
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Ordenador getOrdenador() {
		return ordenador;
	}
	public void setOrdenador(Ordenador ordenador) {
		this.ordenador = ordenador;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	@Override
	public String toString() {
		return "Pedido [nombreCliente=" + nombreCliente + ", direccion=" + direccion + ", email=" + email
				+ ", ordenador=" + ordenador + ", comentario=" + comentario + "]";
	}
	
	
}
