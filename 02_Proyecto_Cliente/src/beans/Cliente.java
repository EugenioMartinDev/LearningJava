package beans;

public class Cliente {

		private String usuario;
		private String pws;
		private String nombre;
		private String apellido;
		private String direccion;
		/**
		 * @param usuario
		 * @param pws
		 * @param nombre
		 * @param apellido
		 * @param direccion
		 */
		public Cliente(String usuario, String pws, String nombre, String apellido, String direccion) {
			super();
			this.usuario = usuario;
			this.pws = pws;
			this.nombre = nombre;
			this.apellido = apellido;
			this.direccion = direccion;
		}
		/**
		 * 
		 */
		public Cliente() {
			super();
		}
		/**
		 * @return the usuario
		 */
		public String getUsuario() {
			return usuario;
		}
		/**
		 * @param usuario the usuario to set
		 */
		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}
		/**
		 * @return the pws
		 */
		public String getPws() {
			return pws;
		}
		/**
		 * @param pws the pws to set
		 */
		public void setPws(String pws) {
			this.pws = pws;
		}
		/**
		 * @return the nombre
		 */
		public String getNombre() {
			return nombre;
		}
		/**
		 * @param nombre the nombre to set
		 */
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		/**
		 * @return the apellido
		 */
		public String getApellido() {
			return apellido;
		}
		/**
		 * @param apellido the apellido to set
		 */
		public void setApellido(String apellido) {
			this.apellido = apellido;
		}
		/**
		 * @return the direccion
		 */
		public String getDireccion() {
			return direccion;
		}
		/**
		 * @param direccion the direccion to set
		 */
		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}
		@Override
		public String toString() {
			return "Cliente [usuario=" + usuario + ", pws=" + pws + ", nombre=" + nombre + ", apellido=" + apellido
					+ ", direccion=" + direccion + "]";
		}
		
		
		public static Cliente dameCliente() {
			
			return new Cliente("juan", "j_001", "Juan", "Martínez", "Madrid");
		}
		
		public static Cliente[] dameClientes() {
			
			Cliente[] clientes = {new Cliente("juan", "j_001", "Juan", "Martínez", "Madrid"),
					new Cliente("maria", "m_001", "María", "Suárez", "Barcelona"),
					new Cliente("ana", "a_001", "Ana", "Moreno", "Badajoz"),
					new Cliente("julia", "j_001", "Julia", "López", "Soria")};
						
			return clientes;
			
		}
		
		
}
