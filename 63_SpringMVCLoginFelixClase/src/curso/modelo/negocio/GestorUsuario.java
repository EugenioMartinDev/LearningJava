package curso.modelo.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.modelo.entidad.Usuario;
import curso.modelo.persistencia.DaoUsuario;

@Service
public class GestorUsuario {

	@Autowired
	private DaoUsuario du;
	
	@Autowired
	private Usuario usuario;
	
	public void alta(Usuario usuario) {		
		du.save(usuario);		
	}
	
	public boolean login(Usuario usuario) {
		Usuario uAux = du.findByNombreAndPassword(usuario.getNombre(), usuario.getPassword());
		
		if (uAux == null) {
			return false;
		}
		
		return true;		
	}
	
}
