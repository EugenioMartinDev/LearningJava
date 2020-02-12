package directorio.modelo.entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Entity
@Table(name="listadoPeli")
public class Peli {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String titulo;
	private String year;
	private Double recaudacion;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}
	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}
	/**
	 * @return the recaudacion
	 */
	public Double getRecaudacion() {
		return recaudacion;
	}
	/**
	 * @param recaudacion the recaudacion to set
	 */
	public void setRecaudacion(Double recaudacion) {
		this.recaudacion = recaudacion;
	}
	@Override
	public String toString() {
		return "Peli [id=" + id + ", titulo=" + titulo + ", year=" + year + ", recaudacion=" + recaudacion + "]";
	}
	
	
	
}
