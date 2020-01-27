package modelo.entidad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Aeropuerto {

	@Autowired
	@Qualifier("listaAvion1Avion2")
	private List<Avion> listaAviones;

	/**
	 * @return the listaAviones
	 */
	public List<Avion> getListaAviones() {
		return listaAviones;
	}

	/**
	 * @param listaAviones the listaAviones to set
	 */
	public void setListaAviones(List<Avion> listaAviones) {
		this.listaAviones = listaAviones;
	}

	/**
	 * 
	 */
	public Aeropuerto() {
		super();
	}

	@Override
	public String toString() {
		return "Aeropuerto [listaAviones=" + listaAviones + "]";
	}
	
	
	
}
