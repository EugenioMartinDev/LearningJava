package modelo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import modelo.entidad.Libro;

public class DaoLibreria {

	// Esto es una interfaz, el objeto que realiza la conexion
		// a la bbdd estan dentro de las librerias de MySql
		private Connection conexion;

		// Bloque estatico, este bloque se ejecutará
		// justo al cargar esta clase en la JVM, se ejecutará
		// antes que el metodo main. Esto para versiones
		// anteriores a Java 1.7
		/*
		 * static { //Le decimos a java que carge en memoria el driver //de conexión con
		 * la bbdd, para poder recuperarlo //cuando hagamos la conexión try {
		 * Class.forName("com.mysql.cj.jdbc.Driver"); } catch (ClassNotFoundException e)
		 * { // TODO Auto-generated catch block System.out.println("Driver NO cargado");
		 * e.printStackTrace(); } }
		 */

		public boolean abrirConexion() {
			// protocolo:subprotocolo//IP:PUERTO/NOMBRE_ESQUEMA
			// esta url depende de la bbddd a la que nos conectemos
			String url = "jdbc:mysql://localhost:3306/libreria?serverTimezone=" + TimeZone.getDefault().getID();
			String usuario = "root";
			String password = "root";

			// getConeccion me devuelve un objeto que lleva la conexión
			// a la bbdd, esta clase (DriverManager) es la clase
			// que lleva el control del driver
			// Estamos aplicando la Inyeccion de dependecia, es decir,
			// no creo el objeto aqui (no hago new), sino que es
			// el metodo getConnection el que me crea el objeto
			// en mi lugar
			try {
				conexion = DriverManager.getConnection(url, usuario, password);
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}

		public boolean cerrarConexion() {
			try {
				conexion.close();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		
	public List<Libro> getListaLibros() {
		if (!abrirConexion()) {
			return null;
		}

		String query = "select id,isbn,titulo,editorial,anio from libros";

		try {
			// le decimos a la conexion que nos haga una consulta
			// parametrizada a partir de la query anterior
			PreparedStatement ps = conexion.prepareStatement(query);
			// esta funcion me devuelve el numero de filas
			// afectadas
			ResultSet rs = ps.executeQuery();
			// ResultSet es un objeto que tiene toda la lista
			// de registros que ha devuelto la consulta

			Libro libro = null;
			List<Libro> listaLibros = new ArrayList<Libro>();
			// asi pues, podemos recorrernos la lista
			while (rs.next()) {// preguntamos si hay un registro mas
				libro = new Libro();
				libro.setId(rs.getInt(1));// el id esta en la primera posicion
				libro.setIsbn(rs.getString(2));
				libro.setTitulo(rs.getString(3));
				libro.setEditorial(rs.getString(4));
				libro.setAnioPublicacion(rs.getInt(5));

				listaLibros.add(libro);
			}
			return listaLibros;
		} catch (SQLException e) {
			System.out.println("Error en el insertar");
			e.printStackTrace();
			return null;
		} finally {
			// el bloque finally se va a ejecutar SIEMPRE
			// no importa si ha pasado por el bloque try o
			// por el bloque catch
			cerrarConexion();
		}
	}

	public int alta(Libro libro) {
		if (!abrirConexion()) {
			return 4;
		}

		// así no se debe hacer, porque no es optimo ni seguro
		// para el motor de la base de datos
		/*
		 * String query = "insert into coches (matricula,marca,modelo) " + " value("+
		 * coche.getMatricula()+ "," + coche.getMarca() + ","+ coche.getModelo() + ")";
		 */
		// como hay que hacer es con consultas preparadas, parametrizadas
		String query = "insert into libros (isbn,titulo,editorial,anio) values(?,?,?,?)";

		try {
			// le decimos a la conexion que nos haga una consulta
			// parametrizada a partir de la query anterior
			PreparedStatement ps = conexion.prepareStatement(query);
			// sustimos la primera interrogante por la matricula
			// del coche
			ps.setString(1, libro.getIsbn());
			ps.setString(2, libro.getTitulo());
			ps.setString(3, libro.getEditorial());
			ps.setInt(4, libro.getAnioPublicacion());

			// esta funcion me devuelve el numero de filas
			// afectadas
			int numeroFilas = ps.executeUpdate();
			if (numeroFilas == 0) {
				return 4;
			} else {
				return 0;
			}
		} catch (SQLException e) {
			System.out.println("Error en el insertar");
			e.printStackTrace();
			return 4;
		} finally {
			// el bloque finally se va a ejecutar SIEMPRE
			// no importa si ha pasado por el bloque try o
			// por el bloque catch
			cerrarConexion();
		}
	}

	public Libro buscarPorIsbn(String isbn) {
		if (!abrirConexion()) {
			return null;
		}

		String query = "select id,isbn,titulo,editorial,anio from " 
				+ "libros where isbn=?";

		try {
			// le decimos a la conexion que nos haga una consulta
			// parametrizada a partir de la query anterior
			PreparedStatement ps = conexion.prepareStatement(query);
			// sustimos la primera interrogante por la matricula
			// del coche
			ps.setString(1, isbn);

			// esta funcion me devuelve el numero de filas
			// afectadas
			ResultSet rs = ps.executeQuery();
			// ResultSet es un objeto que tiene toda la lista
			// de registros que ha devuelto la consulta

			Libro libro = null;

			// asi pues, podemos recorrernos la lista
			while (rs.next()) {// preguntamos si hay un registro mas
				libro = new Libro();
				libro.setId(rs.getInt(1));// el id esta en la primera posicion
				libro.setIsbn(rs.getString(2));
				libro.setTitulo(rs.getString(3));
				libro.setEditorial(rs.getString(4));
				libro.setAnioPublicacion(rs.getInt(5));
			}
			return libro;
		} catch (SQLException e) {
			System.out.println("Error en el insertar");
			e.printStackTrace();
			return null;
		} finally {
			// el bloque finally se va a ejecutar SIEMPRE
			// no importa si ha pasado por el bloque try o
			// por el bloque catch
			cerrarConexion();
		}
	}

	public List<Libro> buscarPorEditorial(String editorial) {
		if (!abrirConexion()) {
			return null;
		}

		String query = "select id,isbn,titulo,editorial,anio from " 
				+ "libros where editorial=?";

		try {
			// le decimos a la conexion que nos haga una consulta
			// parametrizada a partir de la query anterior
			PreparedStatement ps = conexion.prepareStatement(query);
			// sustimos la primera interrogante por la matricula
			// del coche
			ps.setString(1, editorial);

			// esta funcion me devuelve el numero de filas
			// afectadas
			ResultSet rs = ps.executeQuery();
			// ResultSet es un objeto que tiene toda la lista
			// de registros que ha devuelto la consulta

			Libro libro = null;
			List<Libro> listaLibros = new ArrayList<Libro>();
			// asi pues, podemos recorrernos la lista
			while (rs.next()) {// preguntamos si hay un registro mas
				libro = new Libro();
				libro.setId(rs.getInt(1));// el id esta en la primera posicion
				libro.setIsbn(rs.getString(2));
				libro.setTitulo(rs.getString(3));
				libro.setEditorial(rs.getString(4));
				libro.setAnioPublicacion(rs.getInt(5));
				
				listaLibros.add(libro);
			}
			return listaLibros;
		} catch (SQLException e) {
			System.out.println("Error en el insertar");
			e.printStackTrace();
			return null;
		} finally {
			// el bloque finally se va a ejecutar SIEMPRE
			// no importa si ha pasado por el bloque try o
			// por el bloque catch
			cerrarConexion();
		}
	}



}
