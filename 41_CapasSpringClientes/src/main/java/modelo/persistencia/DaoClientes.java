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

import modelo.entidad.Cliente;
import utils.Constantes;

/**
 * Data Access Object to access clientes schema.
 * 		Table cliente with id (int pk ai nn), dni (string 9 chars nn, uq), nombre (string), edad (int)
 * @author aula2m
 *
 */
@Repository
public class DaoClientes {


		private Connection conexion;

		/**
		 * Open a connection to DDBB jdbc mysql schema clientes on port 3306
		 * @return true if successful
		 *         false if unsuccessful
		 */
		public boolean abrirConexion( ) {
			
			String url = "jdbc:mysql://localhost:3306/clientes?serverTimezone=" + TimeZone.getDefault().getID();  // protocolo:subprotocolo:subnombre ip:puerto nombreEsquema
			String user = "root";
			String password = "root";
			
			try {
				conexion = DriverManager.getConnection(url, user, password);

				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
					
		}
		
		/**
		 * Close a connection to DDBB jdbc mysql schema clientes on port 3306
		 * @return true if successful
		 *         false if unsuccessful
		 */
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
		
		/**
		 * Insert a new cliente in cliente table
		 * Open and close a connection
		 * @param cliente
		 * @return true if successfully inserted
		 *         false if unsuccessfully inserted
		 */
		public boolean alta(Cliente cliente) {
			
			if (!abrirConexion()) {
				return false;
			}
			
			boolean alta = true;
			
			// Una posible forma de formar el select. Pero no es óptima ni es segura.
			// No es óptima, porque cada consulta se guarda en caché. Si son parecidas, deberían estar parametrizadas.
			// No es segura, porque si se concatenan entradas del usuario con la sql, el usuario podría incluir varias sql's en
			// una sola entrada. (Y alguna sql concatenada podría ser "drop database *";

			
			// Es necesario hacer consultas preparadas
			String query = "insert into cliente (dni, nombre, edad) values (?,?,?)";
			
			try {
				// Generamos una consulta preparada
				PreparedStatement ps = conexion.prepareStatement(query);
				ps.setString(1, cliente.getDni());
				ps.setString(2, cliente.getNombre());
				ps.setInt(3, cliente.getEdad());

				
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

		/**
		 * Delete a cliente from cliente table
		 * @param id
		 * @return true if successfully deleted
		 *         false if unsuccessfully deleted
		 */
		public boolean borrar(int id) {
					
			if (buscarPorId(id) == null) return false;
			
			if (!abrirConexion()) {
				return false;
			}
			
			boolean borrar = true;
			
			// Una posible forma de formar el select. Pero no es óptima ni es segura.
			// No es óptima, porque cada consulta se guarda en caché. Si son parecidas, deberían estar parametrizadas.
			// No es segura, porque si se concatenan entradas del usuario con la sql, el usuario podría incluir varias sql's en
			// una sola entrada. (Y alguna sql concatenada podría ser "drop database *";
			
			// Es necesario hacer consultas preparadas
			String query = "delete from cliente where id=?";
			
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
		 * Get all current cliente in cliente table
		 * @return list of cliente or an empty list
		 */
		public List<Cliente> listar() {
			
			List<Cliente> listaClientes = new ArrayList<Cliente>();
			
			if (!abrirConexion()) {
				return listaClientes;
			}

			
			// Una posible forma de formar el select. Pero no es óptima ni es segura.
			// No es óptima, porque cada consulta se guarda en caché. Si son parecidas, deberían estar parametrizadas.
			// No es segura, porque si se concatenan entradas del usuario con la sql, el usuario podría incluir varias sql's en
			// una sola entrada. (Y alguna sql concatenada podría ser "drop database *";

			
			// Es necesario hacer consultas preparadas
			String query = "select id, dni, nombre, edad from cliente";
			
			try {
				// Generamos una consulta preparada
				PreparedStatement ps = conexion.prepareStatement(query);
				
				// Esta función devuelve el número de filas afectadas. Si ha afectado 0 filas, ha fallado.
				ResultSet rs = ps.executeQuery();  //executeQuery no modifica la BBDD. executeUpdate sí modifica la BBDD
				// ResultSet es un objeto que tiene toda la lista de registros que ha devuelto 
				// la consulta
			
				while (rs.next()) {
					Cliente cliente = new Cliente();
					cliente.setId(rs.getInt(1));
					cliente.setDni(rs.getString(2));
					cliente.setNombre(rs.getString(3));
					cliente.setEdad(rs.getInt(4));
					listaClientes.add(cliente);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			// El bloque finally se va a ejecutar siempre, venga el código del bloque try o del bloque catch.
			} finally {
				cerrarConexiones();
			}

			
			return listaClientes;
		}

		/**
		 * Get a cliente from table cliente 
		 * @param nombre
		 * @return cliente for the given id or null if it is not found
		 */
		public List<Cliente> buscarPorNombre(String nombre) {
			if (!abrirConexion()) {
				return null;
			}

			List<Cliente> listaClientes = new ArrayList<Cliente>();
			
			// Una posible forma de formar el select. Pero no es óptima ni es segura.
			// No es óptima, porque cada consulta se guarda en caché. Si son parecidas, deberían estar parametrizadas.
			// No es segura, porque si se concatenan entradas del usuario con la sql, el usuario podría incluir varias sql's en
			// una sola entrada. (Y alguna sql concatenada podría ser "drop database *";
			
			// Es necesario hacer consultas preparadas
			String query = "select id, dni, nombre, edad from cliente where nombre = ?";
			
			try {
				// Generamos una consulta preparada
				PreparedStatement ps = conexion.prepareStatement(query);
				ps.setString(1, nombre);
				
				// Esta función devuelve el número de filas afectadas. Si ha afectado 0 filas, ha fallado.
				ResultSet rs = ps.executeQuery();  //executeQuery no modifica la BBDD. executeUpdate sí modifica la BBDD
				// ResultSet es un objeto que tiene toda la lista de registros que ha devuelto 
				// la consulta

				
				while (rs.next()) {
					Cliente cliente = new Cliente();
					cliente.setId(rs.getInt(1));
					cliente.setDni(rs.getString(2));
					cliente.setNombre(rs.getString(3));
					cliente.setEdad(rs.getInt(4));	
					listaClientes.add(cliente);
				}
				
				return listaClientes;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			// El bloque finally se va a ejecutar siempre, venga el código del bloque try o del bloque catch.
			} finally {
				cerrarConexiones();
			}

		}

		/**
		 * Get a cliente from table cliente 
		 * @param id
		 * @return cliente for the given id or null if it is not found
		 */
		public Cliente buscarPorId(int id) {
			
			if (!abrirConexion()) {
				return null;
			}

			List<Cliente> listaClientes = new ArrayList<Cliente>();
			
			// Una posible forma de formar el select. Pero no es óptima ni es segura.
			// No es óptima, porque cada consulta se guarda en caché. Si son parecidas, deberían estar parametrizadas.
			// No es segura, porque si se concatenan entradas del usuario con la sql, el usuario podría incluir varias sql's en
			// una sola entrada. (Y alguna sql concatenada podría ser "drop database *";
			
			// Es necesario hacer consultas preparadas
			String query = "select id, dni, nombre, edad from cliente where id = ?";
			
			try {
				// Generamos una consulta preparada
				PreparedStatement ps = conexion.prepareStatement(query);
				ps.setInt(1, id);
				
				// Esta función devuelve el número de filas afectadas. Si ha afectado 0 filas, ha fallado.
				ResultSet rs = ps.executeQuery();  //executeQuery no modifica la BBDD. executeUpdate sí modifica la BBDD
				// ResultSet es un objeto que tiene toda la lista de registros que ha devuelto 
				// la consulta

				
				while (rs.next()) {
					Cliente cliente = new Cliente();
					cliente.setId(rs.getInt(1));
					cliente.setDni(rs.getString(2));
					cliente.setNombre(rs.getString(3));
					cliente.setEdad(rs.getInt(4));	
					listaClientes.add(cliente);
				}
				
				if (listaClientes.size() > 0) {
					return listaClientes.get(0);
				} else {
					return null;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			// El bloque finally se va a ejecutar siempre, venga el código del bloque try o del bloque catch.
			} finally {
				cerrarConexiones();
			}

		}

		/**
		 * Function to Get a cliente from table cliente 
		 * @param dni
		 * @return list of cliente or empty list 
		 */
		public List<Cliente> buscarPorDni(String dni) {
			if (!abrirConexion()) {
				return null;
			}

			List<Cliente> listaClientes = new ArrayList<Cliente>();
			
			// Una posible forma de formar el select. Pero no es óptima ni es segura.
			// No es óptima, porque cada consulta se guarda en caché. Si son parecidas, deberían estar parametrizadas.
			// No es segura, porque si se concatenan entradas del usuario con la sql, el usuario podría incluir varias sql's en
			// una sola entrada. (Y alguna sql concatenada podría ser "drop database *";
			
			// Es necesario hacer consultas preparadas
			String query = "select id, dni, nombre, edad from cliente where dni = ?";
			
			try {
				// Generamos una consulta preparada
				PreparedStatement ps = conexion.prepareStatement(query);
				ps.setString(1, dni);
				
				// Esta función devuelve el número de filas afectadas. Si ha afectado 0 filas, ha fallado.
				ResultSet rs = ps.executeQuery();  //executeQuery no modifica la BBDD. executeUpdate sí modifica la BBDD
				// ResultSet es un objeto que tiene toda la lista de registros que ha devuelto 
				// la consulta

				
				while (rs.next()) {
					Cliente cliente = new Cliente();
					cliente.setId(rs.getInt(1));
					cliente.setDni(rs.getString(2));
					cliente.setNombre(rs.getString(3));
					cliente.setEdad(rs.getInt(4));	
					listaClientes.add(cliente);
				}
				
				return listaClientes;
				
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
