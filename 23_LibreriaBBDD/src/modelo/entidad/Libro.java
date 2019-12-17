package modelo.entidad;

//como en la bbdd hemos add id, tambien lo add a la
//entidad. Tambien volvemos a sobreescribir el metodo
//toString() ya que tiene un nuevo atributo (id)
public class Libro {
	private int id;
	private String isbn;
	private String titulo;
	private String editorial;
	private int anioPublicacion;
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public int getAnioPublicacion() {
		return anioPublicacion;
	}
	public void setAnioPublicacion(int anioPublicacion) {
		this.anioPublicacion = anioPublicacion;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Libro [id=" + id + ", isbn=" + isbn + ", titulo=" + titulo + ", editorial=" + editorial
				+ ", anioPublicacion=" + anioPublicacion + "]";
	}
	
	
}
