package servidor.modelo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import modelo.entidad.Coche;


/**
 * Esta clase se encarga de la persistencia con la clase coche
 * e implementa un CRUD (Create, Read, Update, Delete) sobre la 
 * entidad Coche. 
 * Un DAO es el acr�nimo de Data Access Object. Es un objeto
 * que interact�a los objetos coche con la BBDD.
 * 
 * Nosotros vamos a desarrollar este DAO mediante el API de Java
 * JDBC (acr�nimo para Java Data Base Connection). Un API (Application 
 * Program Interface) es un
 * conjunto de librer�a que proporcionan una funcionalidad com�n.
 * Hay otras API's (i.e. JPA - Java Persistence API).
 * 
 * Para usar estas API's, necesitamos los drivers de conexi�n que 
 * ha implementado el proveedor de nuestra base de datos (MySQL).
 * Cada proveedor implementa sus drivers para cada lenguaje de programaci�n.
 * 
 * Hay que buscar en la Web del proveedor el driver para la version 8.0 de MySQL,
 * y descargarlo en el proyecto Java, actualizando el ClassPath del Eclipse.
 * 
 * 
 * 
 * @author aula2m
 * @see Coche
 * @since 04-12-2019
 * @version 1.0
 */
public class DaoCoche {

	// Esto es una interfaz. 
	// El objeto que realiza la conexi�n a la BBDD est� dentro de la librer�a MySQL
	private Connection conexion;
	
	/* En la versi�n 8 de Java no hace falta incluir la clase en memoria. En Java 1.7 
	 * hacia atr�s s� que es necesario.
	//bloque est�tico : se optimiza la carga s�lo una vez, no tantas como instanciaciones de la clase
	static {
		// Le decimos a Java que cargue en memoria el driver de conexi�n 
		// con la BBDD, para poder recuperarlo cuando hagamos la conexi�n.
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
		
		String url = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=" + TimeZone.getDefault().getID();  // protocolo:subprotocolo:subnombre ip:puerto nombreEsquema
		String user = "root";
		String password = "root";
		
		try {
			// DriverManager devuelve la conexi�n a MySQL efectuada por la librer�a 
			// mysql-connector-java-8.0.18.jar. 
			// Trabaja con inyecci�n de dependencias: el m�todo getConnection crea el objeto "conexion".
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
	
	
	public boolean alta(Coche coche) {
		
		if (!abrirConexion()) {
			return false;
		}
		
		boolean alta = true;
		
		// Una posible forma de formar el select. Pero no es �ptima ni es segura.
		// No es �ptima, porque cada consulta se guarda en cach�. Si son parecidas, deber�an estar parametrizadas.
		// No es segura, porque si se concatenan entradas del usuario con la sql, el usuario podr�a incluir varias sql's en
		// una sola entrada. (Y alguna sql concatenada podr�a ser "drop database *";
		/*
		String query = "insert into coches (matricula,marca,modelo) " +
						"value(" + coche.getMatricula() + "," + coche.getMarca() + "," + coche.getModelo() + ");";
		*/
		
		// Es necesario hacer consultas preparadas
		String query = "insert into coche (matricula,marca,modelo) values (?,?,?)";
		
		try {
			// Generamos una consulta preparada
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, coche.getMatricula());
			ps.setString(2, coche.getMarca());
			ps.setString(3, coche.getModelo());
			
			// Esta funci�n devuelve el n�mero de filas afectadas. Si ha afectado 0 filas, ha fallado.
			int numeroFilas = ps.executeUpdate();
			
			if (numeroFilas == 0) {
				alta = false;
				System.out.println("Error en la inserci�n");
			} else {
				System.out.println("Inserci�n completada");
				alta = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			alta = false;
		// El bloque finally se va a ejecutar siempre, venga el c�digo del bloque try o del bloque catch.
		} finally {
			cerrarConexiones();
		}
		
		return alta;
	}
	
	public boolean modificar(Coche coche) {
		
		if (!abrirConexion()) {
			return false;
		}
		
		boolean modificar = true;
		
		// Una posible forma de formar el select. Pero no es �ptima ni es segura.
		// No es �ptima, porque cada consulta se guarda en cach�. Si son parecidas, deber�an estar parametrizadas.
		// No es segura, porque si se concatenan entradas del usuario con la sql, el usuario podr�a incluir varias sql's en
		// una sola entrada. (Y alguna sql concatenada podr�a ser "drop database *";
		/*
		String query = "insert into coches (matricula,marca,modelo) " +
						"value(" + coche.getMatricula() + "," + coche.getMarca() + "," + coche.getModelo() + ");";
		*/
		
		// Es necesario hacer consultas preparadas
		String query = "update coche set matricula=?,marca=?,modelo=? where id=?";
		
		try {
			// Generamos una consulta preparada
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, coche.getMatricula());
			ps.setString(2, coche.getMarca());
			ps.setString(3, coche.getModelo());
			ps.setInt(4, coche.getId());
			
			// Esta funci�n devuelve el n�mero de filas afectadas. Si ha afectado 0 filas, ha fallado.
			int numeroFilas = ps.executeUpdate();
			
			if (numeroFilas == 0) {
				modificar = false;
				System.out.println("Error en la actualizaci�n");
			} else {
				System.out.println("Actualizaci�n completada");
				modificar = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			modificar = false;
		// El bloque finally se va a ejecutar siempre, venga el c�digo del bloque try o del bloque catch.
		} finally {
			cerrarConexiones();
		}
		
		return modificar;
	}
	
	public boolean borrar(Coche coche) {
		
		if (!abrirConexion()) {
			return false;
		}
		
		boolean borrar = true;
		
		// Una posible forma de formar el select. Pero no es �ptima ni es segura.
		// No es �ptima, porque cada consulta se guarda en cach�. Si son parecidas, deber�an estar parametrizadas.
		// No es segura, porque si se concatenan entradas del usuario con la sql, el usuario podr�a incluir varias sql's en
		// una sola entrada. (Y alguna sql concatenada podr�a ser "drop database *";
		/*
		String query = "insert into coches (matricula,marca,modelo) " +
						"value(" + coche.getMatricula() + "," + coche.getMarca() + "," + coche.getModelo() + ");";
		*/
		
		// Es necesario hacer consultas preparadas
		String query = "delete from coche where id=?";
		
		try {
			// Generamos una consulta preparada
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, coche.getId());
			
			// Esta funci�n devuelve el n�mero de filas afectadas. Si ha afectado 0 filas, ha fallado.
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
		// El bloque finally se va a ejecutar siempre, venga el c�digo del bloque try o del bloque catch.
		} finally {
			cerrarConexiones();
		}
		
		return borrar;
	}
	
	/**
	 * @param id
	 * @return Coche or null if not id found in DDBB
	 */
	public Coche obtener(int id) {
		
		if (!abrirConexion()) {
			return null;
		}

		
		// Una posible forma de formar el select. Pero no es �ptima ni es segura.
		// No es �ptima, porque cada consulta se guarda en cach�. Si son parecidas, deber�an estar parametrizadas.
		// No es segura, porque si se concatenan entradas del usuario con la sql, el usuario podr�a incluir varias sql's en
		// una sola entrada. (Y alguna sql concatenada podr�a ser "drop database *";
		/*
		String query = "insert into coches (matricula,marca,modelo) " +
						"value(" + coche.getMatricula() + "," + coche.getMarca() + "," + coche.getModelo() + ");";
		*/
		
		// Es necesario hacer consultas preparadas
		String query = "select id,matricula,marca,modelo from coche where id=?";
		
		try {
			// Generamos una consulta preparada
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, id);
			
			// Esta funci�n devuelve el n�mero de filas afectadas. Si ha afectado 0 filas, ha fallado.
			ResultSet rs = ps.executeQuery();  //executeQuery no modifica la BBDD. executeUpdate s� modifica la BBDD
			// ResultSet es un objeto que tiene toda la lista de registros que ha devuelto 
			// la consulta
			
			Coche coche = null;
			
			while (rs.next()) {
				coche = new Coche();
				coche.setId(rs.getInt(1));
				coche.setMatricula(rs.getString(2));
				coche.setMarca(rs.getString(3));
				coche.setModelo(rs.getString(4));	
			}
			
			return coche;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		// El bloque finally se va a ejecutar siempre, venga el c�digo del bloque try o del bloque catch.
		} finally {
			cerrarConexiones();
		}

	}
	
	public List<Coche> getListaCoches() {
		
		List<Coche> listaCoches = new ArrayList<Coche>();
		
		if (!abrirConexion()) {
			return listaCoches;
		}

		
		// Una posible forma de formar el select. Pero no es �ptima ni es segura.
		// No es �ptima, porque cada consulta se guarda en cach�. Si son parecidas, deber�an estar parametrizadas.
		// No es segura, porque si se concatenan entradas del usuario con la sql, el usuario podr�a incluir varias sql's en
		// una sola entrada. (Y alguna sql concatenada podr�a ser "drop database *";
		/*
		String query = "insert into coches (matricula,marca,modelo) " +
						"value(" + coche.getMatricula() + "," + coche.getMarca() + "," + coche.getModelo() + ");";
		*/
		
		// Es necesario hacer consultas preparadas
		String query = "select id,matricula,marca,modelo from coche";
		
		try {
			// Generamos una consulta preparada
			PreparedStatement ps = conexion.prepareStatement(query);
			
			// Esta funci�n devuelve el n�mero de filas afectadas. Si ha afectado 0 filas, ha fallado.
			ResultSet rs = ps.executeQuery();  //executeQuery no modifica la BBDD. executeUpdate s� modifica la BBDD
			// ResultSet es un objeto que tiene toda la lista de registros que ha devuelto 
			// la consulta
		
			while (rs.next()) {
				Coche coche = new Coche();
				coche.setId(rs.getInt(1));
				coche.setMatricula(rs.getString(2));
				coche.setMarca(rs.getString(3));
				coche.setModelo(rs.getString(4));	
				listaCoches.add(coche);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		// El bloque finally se va a ejecutar siempre, venga el c�digo del bloque try o del bloque catch.
		} finally {
			cerrarConexiones();
		}

		
		return listaCoches;
	}

	public Coche buscarPorMatricula(String matricula) {
		if (!abrirConexion()) {
			return null;
		}

		String query = "select id,matricula,marca,modelo from coche where matricula=?";
		
		try {
			// Generamos una consulta preparada
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, matricula);
			
			// Esta funci�n devuelve el n�mero de filas afectadas. Si ha afectado 0 filas, ha fallado.
			ResultSet rs = ps.executeQuery();  //executeQuery no modifica la BBDD. executeUpdate s� modifica la BBDD
			// ResultSet es un objeto que tiene toda la lista de registros que ha devuelto 
			// la consulta
			
			Coche coche = null;
			
			while (rs.next()) {
				coche = new Coche();
				coche.setId(rs.getInt(1));
				coche.setMatricula(rs.getString(2));
				coche.setMarca(rs.getString(3));
				coche.setModelo(rs.getString(4));	
			}
			
			return coche;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		// El bloque finally se va a ejecutar siempre, venga el c�digo del bloque try o del bloque catch.
		} finally {
			cerrarConexiones();
		}

	}
}
