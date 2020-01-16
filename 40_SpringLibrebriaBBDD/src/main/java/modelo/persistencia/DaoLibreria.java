package modelo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import org.springframework.stereotype.Repository;

import modelo.entidad.Libro;
import vista.MainVistaPersistente;

@Repository
public class DaoLibreria {
	/**
	 * Esta clase se encarga de la persistencia con la clase coche
	 * e implementa un CRUD (Create, Read, Update, Delete) sobre la 
	 * entidad Coche. 
	 * Un DAO es el acrónimo de Data Access Object. Es un objeto
	 * que interactúa los objetos coche con la BBDD.
	 * 
	 * Nosotros vamos a desarrollar este DAO mediante el API de Java
	 * JDBC (acrónimo para Java Data Base Connection). Un API (Application 
	 * Program Interface) es un
	 * conjunto de librería que proporcionan una funcionalidad común.
	 * Hay otras API's (i.e. JPA - Java Persistence API).
	 * 
	 * Para usar estas API's, necesitamos los drivers de conexión que 
	 * ha implementado el proveedor de nuestra base de datos (MySQL).
	 * Cada proveedor implementa sus drivers para cada lenguaje de programación.
	 * 
	 * Hay que buscar en la Web del proveedor el driver para la version 8.0 de MySQL,
	 * y descargarlo en el proyecto Java, actualizando el ClassPath del Eclipse.
	 * 
	 * 
	 * 
	 * @author aula2m
	 * @see Pelicula
	 * @since 16-12-2019
	 * @version 1.0
	 */

		// Esto es una interfaz. 
		// El objeto que realiza la conexión a la BBDD está dentro de la librería MySQL
		private Connection conexion;
		
		/* En la versión 8 de Java no hace falta incluir la clase en memoria. En Java 1.7 
		 * hacia atrás sí que es necesario.
		//bloque estático : se optimiza la carga sólo una vez, no tantas como instanciaciones de la clase
		static {
			// Le decimos a Java que cargue en memoria el driver de conexión 
			// con la BBDD, para poder recuperarlo cuando hagamos la conexión.
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Driver no cargado");
				e.printStackTrace();
			}
		}
		*/
		public boolean abrirConexion( ) {
			
			String url = "jdbc:mysql://localhost:3306/libreria?serverTimezone=" + TimeZone.getDefault().getID();  // protocolo:subprotocolo:subnombre ip:puerto nombreEsquema
			String user = "root";
			String password = "root";
			
			try {
				// DriverManager devuelve la conexión a MySQL efectuada por la librería 
				// mysql-connector-java-8.0.18.jar. 
				// Trabaja con inyección de dependencias: el método getConnection crea el objeto "conexion".
				conexion = DriverManager.getConnection(url, user, password);

				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
					
		}
		
		public boolean cerrarConexiones() {
			
			try {
				conexion.close();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		
		
		public boolean alta(Libro libro) {
			
			if (!abrirConexion()) {
				return false;
			}
			
			boolean alta = true;
			
			// Una posible forma de formar el select. Pero no es óptima ni es segura.
			// No es óptima, porque cada consulta se guarda en caché. Si son parecidas, deberían estar parametrizadas.
			// No es segura, porque si se concatenan entradas del usuario con la sql, el usuario podría incluir varias sql's en
			// una sola entrada. (Y alguna sql concatenada podría ser "drop database *";

			
			// Es necesario hacer consultas preparadas
			String query = "insert into libros (titulo, editorial, isbn, anio) values (?,?,?,?)";
			
			try {
				// Generamos una consulta preparada
				PreparedStatement ps = conexion.prepareStatement(query);
				ps.setString(1, libro.getTitulo());
				ps.setString(2, libro.getEditorial());
				ps.setString(3, libro.getIsbn());
				ps.setInt(4, libro.getAnioPublicacion());
				
				// Esta función devuelve el número de filas afectadas. Si ha afectado 0 filas, ha fallado.
				int numeroFilas = ps.executeUpdate();
				
				if (numeroFilas == 0) {
					alta = false;
					System.out.println("Error en la inserción");
				} else {
					System.out.println("Inserción completada");
					alta = true;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				alta = false;
			// El bloque finally se va a ejecutar siempre, venga el código del bloque try o del bloque catch.
			} finally {
				cerrarConexiones();
			}
			
			return alta;
		}
		
		public boolean modificar(Libro libro) {
			
			if (!abrirConexion()) {
				return false;
			}
			
			boolean modificar = true;
			
			// Una posible forma de formar el select. Pero no es óptima ni es segura.
			// No es óptima, porque cada consulta se guarda en caché. Si son parecidas, deberían estar parametrizadas.
			// No es segura, porque si se concatenan entradas del usuario con la sql, el usuario podría incluir varias sql's en
			// una sola entrada. (Y alguna sql concatenada podría ser "drop database *";

			
			// Es necesario hacer consultas preparadas
			String query = "update libros set titulo=?, editorial=?, isbn=?, anio=? where id=?";
			
			try {
				// Generamos una consulta preparada
				PreparedStatement ps = conexion.prepareStatement(query);
				ps.setString(1, libro.getTitulo());
				ps.setString(2, libro.getEditorial());
				ps.setString(3, libro.getIsbn());
				ps.setInt(4, libro.getAnioPublicacion());
				ps.setInt(5, libro.getId());
				
				// Esta función devuelve el número de filas afectadas. Si ha afectado 0 filas, ha fallado.
				int numeroFilas = ps.executeUpdate();
				
				if (numeroFilas == 0) {
					modificar = false;
					System.out.println("Error en la actualización");
				} else {
					System.out.println("Actualización completada");
					modificar = true;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				modificar = false;
			// El bloque finally se va a ejecutar siempre, venga el código del bloque try o del bloque catch.
			} finally {
				cerrarConexiones();
			}
			
			return modificar;
		}
		
		public boolean borrar(int id) {
			
			if (!abrirConexion()) {
				return false;
			}
			
			boolean borrar = true;
			
			// Una posible forma de formar el select. Pero no es óptima ni es segura.
			// No es óptima, porque cada consulta se guarda en caché. Si son parecidas, deberían estar parametrizadas.
			// No es segura, porque si se concatenan entradas del usuario con la sql, el usuario podría incluir varias sql's en
			// una sola entrada. (Y alguna sql concatenada podría ser "drop database *";
			
			// Es necesario hacer consultas preparadas
			String query = "delete from libros where id=?";
			
			try {
				// Generamos una consulta preparada
				PreparedStatement ps = conexion.prepareStatement(query);
				ps.setInt(1, id);
				
				// Esta función devuelve el número de filas afectadas. Si ha afectado 0 filas, ha fallado.
				int numeroFilas = ps.executeUpdate();
				
				if (numeroFilas == 0) {
					borrar = false;
					System.out.println("Error en el borrado");
				} else {
					System.out.println("Borrado completado");
					borrar = true;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				borrar = false;
			// El bloque finally se va a ejecutar siempre, venga el código del bloque try o del bloque catch.
			} finally {
				cerrarConexiones();
			}
			
			return borrar;
		}
		
		/**
		 * @param id
		 * @return Coche or null if not id found in DDBB
		 */
		public Libro obtener(int id) {
			
			if (!abrirConexion()) {
				return null;
			}

			
			// Una posible forma de formar el select. Pero no es óptima ni es segura.
			// No es óptima, porque cada consulta se guarda en caché. Si son parecidas, deberían estar parametrizadas.
			// No es segura, porque si se concatenan entradas del usuario con la sql, el usuario podría incluir varias sql's en
			// una sola entrada. (Y alguna sql concatenada podría ser "drop database *";
			
			// Es necesario hacer consultas preparadas
			String query = "select id, titulo, editorial, isbn, anio from libros where id=?";
			
			try {
				// Generamos una consulta preparada
				PreparedStatement ps = conexion.prepareStatement(query);
				ps.setInt(1, id);
				
				// Esta función devuelve el número de filas afectadas. Si ha afectado 0 filas, ha fallado.
				ResultSet rs = ps.executeQuery();  //executeQuery no modifica la BBDD. executeUpdate sí modifica la BBDD
				// ResultSet es un objeto que tiene toda la lista de registros que ha devuelto 
				// la consulta
				
				Libro libro = null;
				
				while (rs.next()) {
					//libro = new Libro();
					libro = MainVistaPersistente.context.getBean("libro", Libro.class);
					libro.setId(rs.getInt(1));
					libro.setTitulo(rs.getString(2));
					libro.setEditorial(rs.getString(3));
					libro.setIsbn(rs.getString(4));	
					libro.setAnioPublicacion(rs.getInt(5));
				}
				
				return libro;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			// El bloque finally se va a ejecutar siempre, venga el código del bloque try o del bloque catch.
			} finally {
				cerrarConexiones();
			}

		}
		
		public List<Libro> listar() {
			
			List<Libro> listarLibros = new ArrayList<Libro>();
			
			if (!abrirConexion()) {
				return listarLibros;
			}

			
			// Una posible forma de formar el select. Pero no es óptima ni es segura.
			// No es óptima, porque cada consulta se guarda en caché. Si son parecidas, deberían estar parametrizadas.
			// No es segura, porque si se concatenan entradas del usuario con la sql, el usuario podría incluir varias sql's en
			// una sola entrada. (Y alguna sql concatenada podría ser "drop database *";

			
			// Es necesario hacer consultas preparadas
			String query = "select id, titulo, editorial, isbn, anio from libros";
			
			try {
				// Generamos una consulta preparada
				PreparedStatement ps = conexion.prepareStatement(query);
				
				// Esta función devuelve el número de filas afectadas. Si ha afectado 0 filas, ha fallado.
				ResultSet rs = ps.executeQuery();  //executeQuery no modifica la BBDD. executeUpdate sí modifica la BBDD
				// ResultSet es un objeto que tiene toda la lista de registros que ha devuelto 
				// la consulta
			
				while (rs.next()) {
					Libro libro = new Libro();
					libro.setId(rs.getInt(1));
					libro.setTitulo(rs.getString(2));
					libro.setEditorial(rs.getString(3));
					libro.setIsbn(rs.getString(4));	
					libro.setAnioPublicacion(rs.getInt(5));	
					listarLibros.add(libro);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			// El bloque finally se va a ejecutar siempre, venga el código del bloque try o del bloque catch.
			} finally {
				cerrarConexiones();
			}

			
			return listarLibros;
		}

		public List<Libro> buscarPorEditorial(String editorial) {
			if (!abrirConexion()) {
				return null;
			}

			List<Libro> listarLibros = new ArrayList<Libro>();
			
			// Una posible forma de formar el select. Pero no es óptima ni es segura.
			// No es óptima, porque cada consulta se guarda en caché. Si son parecidas, deberían estar parametrizadas.
			// No es segura, porque si se concatenan entradas del usuario con la sql, el usuario podría incluir varias sql's en
			// una sola entrada. (Y alguna sql concatenada podría ser "drop database *";
			
			// Es necesario hacer consultas preparadas
			String query = "select id, titulo, editorial, isbn, anio from libros where editorial = ?";
			
			try {
				// Generamos una consulta preparada
				PreparedStatement ps = conexion.prepareStatement(query);
				ps.setString(1, editorial);
				
				// Esta función devuelve el número de filas afectadas. Si ha afectado 0 filas, ha fallado.
				ResultSet rs = ps.executeQuery();  //executeQuery no modifica la BBDD. executeUpdate sí modifica la BBDD
				// ResultSet es un objeto que tiene toda la lista de registros que ha devuelto 
				// la consulta
				
				Libro libro = null;
				
				while (rs.next()) {
					libro = new Libro();
					libro.setId(rs.getInt(1));
					libro.setTitulo(rs.getString(2));
					libro.setEditorial(rs.getString(3));
					libro.setIsbn(rs.getString(4));	
					libro.setAnioPublicacion(rs.getInt(5));
					listarLibros.add(libro);
				}
				
				return listarLibros;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			// El bloque finally se va a ejecutar siempre, venga el código del bloque try o del bloque catch.
			} finally {
				cerrarConexiones();
			}

		}

		public Libro buscarPorIsbn(String isbn) {
			if (!abrirConexion()) {
				return null;
			}

			
			// Una posible forma de formar el select. Pero no es óptima ni es segura.
			// No es óptima, porque cada consulta se guarda en caché. Si son parecidas, deberían estar parametrizadas.
			// No es segura, porque si se concatenan entradas del usuario con la sql, el usuario podría incluir varias sql's en
			// una sola entrada. (Y alguna sql concatenada podría ser "drop database *";
			
			// Es necesario hacer consultas preparadas
			String query = "select id, titulo, editorial, isbn, anio from libros where isbn = ?";
			
			try {
				// Generamos una consulta preparada
				PreparedStatement ps = conexion.prepareStatement(query);
				ps.setString(1, isbn);
				
				// Esta función devuelve el número de filas afectadas. Si ha afectado 0 filas, ha fallado.
				ResultSet rs = ps.executeQuery();  //executeQuery no modifica la BBDD. executeUpdate sí modifica la BBDD
				// ResultSet es un objeto que tiene toda la lista de registros que ha devuelto 
				// la consulta
				
				Libro libro = null;
				
				while (rs.next()) {
					libro = new Libro();
					libro.setId(rs.getInt(1));
					libro.setTitulo(rs.getString(2));
					libro.setEditorial(rs.getString(3));
					libro.setIsbn(rs.getString(4));	
					libro.setAnioPublicacion(rs.getInt(5));
				}
				
				return libro;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			// El bloque finally se va a ejecutar siempre, venga el código del bloque try o del bloque catch.
			} finally {
				cerrarConexiones();
			}

		}


	}
