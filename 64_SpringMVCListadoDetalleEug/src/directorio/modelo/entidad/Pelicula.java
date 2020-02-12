package directorio.modelo.entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Entity
@Table(name="listadoPeliculas")
public class Pelicula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne
	@MapsId
	private PeliculaBase peliculaBase;
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
	
	/**
	 * @return the peliculaBase
	 */
	public PeliculaBase getPeliculaBase() {
		return peliculaBase;
	}
	/**
	 * @param peliculaBase the peliculaBase to set
	 */
	public void setPeliculaBase(PeliculaBase peliculaBase) {
		this.peliculaBase = peliculaBase;
	}
	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", year=" + year + ", recaudacion=" + recaudacion + "]";
	}
	
	

}
