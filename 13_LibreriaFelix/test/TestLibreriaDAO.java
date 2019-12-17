import modelo.entidad.Libro;
import modelo.persistencia.DaoLibreria;

public class TestLibreriaDAO {

	public static void main(String[] args) {

		Libro libro = new Libro();
	
		libro.setTitulo("asdfjkalñf");
		libro.setEditorial("fasdfsdf");
		libro.setIsbn("12341234");
		libro.setAnioPublicacion(1957);
		
		DaoLibreria daoLibreria = new DaoLibreria();
		
		daoLibreria.alta(libro);
		
		System.out.println(daoLibreria.obtener(1));
		
		

	}

}
