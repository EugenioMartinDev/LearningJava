package modelo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import modelo.negocio.Pelicula;

public class DaoPelicula {

	private Connection conexion;

	/**
	 * Conexión con la base de datos repositorio_peliculas 
	 * con el usuario root
	 * @return false si se produce la exception SQLException
	 * @throws SQLException 
	 */
	public boolean abrirConexion( ) throws SQLException {
		
		String url = "jdbc:mysql://localhost:3306/repositorio_peliculas?serverTimezone=" + TimeZone.getDefault().getID();  

		String user = "root";
		String password = "root";
		
		try {
			conexion = DriverManager.getConnection(url, user, password);

			return true;
		} catch (SQLException e) {
			throw e;
		}
				
	}
	
	/**
	 * Desconexión con la base de datos repositorio_peliculas
	 * @return false si se produce la excepción SQLException
	 * @throws SQLException 
	 */
	public boolean cerrarConexiones() throws SQLException {
		
		try {
			conexion.close();
			return true;
		} catch (SQLException e) {
			throw e;
		}
	}
	
	
	/**
	 * Alta de Peliculas
	 * @param boolean
	 * @return
	 * @throws SQLException
	 */
	public boolean alta(Pelicula pelicula) throws SQLException {
		
		if (!abrirConexion()) {
			return false;
		}
		
		boolean alta = true;

		String query = "insert into peliculas (titulo, director, genero, anio_publicacion) values (?,?,?,?)";
		
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, pelicula.getTitulo());
			ps.setString(2, pelicula.getDirector());
			ps.setString(3, pelicula.getGenero());
			ps.setInt(4, pelicula.getAnioPublicacion());

			int numeroFilas = ps.executeUpdate();
			
			if (numeroFilas == 0) {
				alta = false;
				System.out.println("Error en la inserción");
			} else {
				System.out.println("Inserción completada");
				alta = true;
			}
			
		} catch (SQLException e) {
			throw e;
		} finally {
			cerrarConexiones();
		}
		
		return alta;
	}
	
	/**
	 * Modifica un campo de la pelicula
	 * @param boolean
	 * @return
	 * @throws SQLException
	 */
	public boolean modificar(Pelicula pelicula) throws SQLException {
		
		if (!abrirConexion()) {
			return false;
		}
		
		boolean modificar = true;

		String query = "update peliculas set titulo=?,director=?,genero=?,anio_publicacion=? where id=?";
		
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, pelicula.getTitulo());
			ps.setString(2, pelicula.getDirector());
			ps.setString(3, pelicula.getGenero());
			ps.setInt(4, pelicula.getAnioPublicacion());
			ps.setInt(5, pelicula.getId());
			
			int numeroFilas = ps.executeUpdate();
			
			if (numeroFilas == 0) {
				modificar = false;
				System.out.println("Error en la actualización");
			} else {
				System.out.println("Actualización completada");
				modificar = true;
			}
			
		} catch (SQLException e) {
			throw e;
		} finally {
			cerrarConexiones();
		}
		
		return modificar;
	}
	
	/**
	 * Borra una película
	 * @param identidad de la película en la base de datos
	 * @return
	 * @throws SQLException
	 */
	public boolean borrar(int id) throws SQLException {
		
		if (!abrirConexion()) {
			return false;
		}
		
		boolean borrar = true;

		String query = "delete from peliculas where id=?";
		
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, id);
			
			int numeroFilas = ps.executeUpdate();
			
			if (numeroFilas == 0) {
				borrar = false;
				System.out.println("Error en el borrado");
			} else {
				System.out.println("Borrado completado");
				borrar = true;
			}
			
		} catch (SQLException e) {
			throw e;
		} finally {
			cerrarConexiones();
		}
		
		return borrar;
	}
	
	/**
	 * Obtiene los datos de una película
	 * @param identidad de la bse de datos
	 * @return Pelicula or null if not id found in DDBB
	 * @throws SQLException 
	 */
	public Pelicula obtener(int id) throws SQLException {
		
		if (!abrirConexion()) {
			return null;
		}

		String query = "select id,titulo,director,genero,anio_publicacion from peliculas where id=?";
		
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();  
			
			Pelicula pelicula = null;
			
			while (rs.next()) {
				pelicula = new Pelicula();
				pelicula.setId(rs.getInt(1));
				pelicula.setTitulo(rs.getString(2));
				pelicula.setDirector(rs.getString(3));
				pelicula.setGenero(rs.getString(4));
				pelicula.setAnioPublicacion(rs.getInt(5));
			}
			
			return pelicula;
			
		} catch (SQLException e) {
			throw e;
		} finally {
			cerrarConexiones();
		}

	}
	
	
	/**
	 * Lista todas las películas de la base de datos
	 * @return Lista de las películas
	 * @throws SQLException
	 */
	public List<Pelicula> listar() throws SQLException {
		
		List<Pelicula> listaPelicula = new ArrayList<Pelicula>();
		
		if (!abrirConexion()) {
			return listaPelicula;
		}

		String query = "select id,titulo,director,genero,anio_publicacion from peliculas";
		
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
		
			while (rs.next()) {
				Pelicula pelicula = new Pelicula();
				pelicula.setId(rs.getInt(1));
				pelicula.setTitulo(rs.getString(2));
				pelicula.setDirector(rs.getString(3));
				pelicula.setGenero(rs.getString(4));
				pelicula.setAnioPublicacion(rs.getInt(5));	
				listaPelicula.add(pelicula);
			}
			
		} catch (SQLException e) {
			throw e;
		} finally {
			cerrarConexiones();
		}
		
		return listaPelicula;
	}
	
	
	/**
	 * Lista todas las películas de la base de datos
	 * @return Lista de las películas
	 * @throws SQLException
	 */
	public List<Pelicula> listarOrdenAnio() throws SQLException {
		
		List<Pelicula> listaPelicula = new ArrayList<Pelicula>();
		
		if (!abrirConexion()) {
			return listaPelicula;
		}

		String query = "select id,titulo,director,genero,anio_publicacion from peliculas order by anio_publicacion";
		
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
		
			while (rs.next()) {
				Pelicula pelicula = new Pelicula();
				pelicula.setId(rs.getInt(1));
				pelicula.setTitulo(rs.getString(2));
				pelicula.setDirector(rs.getString(3));
				pelicula.setGenero(rs.getString(4));
				pelicula.setAnioPublicacion(rs.getInt(5));	
				listaPelicula.add(pelicula);
			}
			
		} catch (SQLException e) {
			throw e;
		} finally {
			cerrarConexiones();
		}
		
		return listaPelicula;
	}
	
}
