package curso.modelo.entidad;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@XmlRootElement
@Component
public class Libros {

	private List<Libro> listaLibros;

	/**
	 * @return the listaLibros
	 */
	public List<Libro> getListaLibros() {
		return listaLibros;
	}

	/**
	 * @param listaLibros the listaLibros to set
	 */
	public void setListaLibros(List<Libro> listaLibros) {
		this.listaLibros = listaLibros;
	}
	
	
}
