package curso.modelo.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.modelo.entidad.Usuario;
import curso.modelo.persistencia.DaoUsuario;

@Service
public class GestorUsuario {
	
	@Autowired
	private DaoUsuario dao;
	
	public boolean validar(Usuario usuario) {
		if(dao.findByNombreAndPassword(
				usuario.getNombre(), 
				usuario.getPassword()) != null) {
			return true;
		}
		
		return false;
	}
}
