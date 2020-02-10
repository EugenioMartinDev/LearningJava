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
	
	public void alta() {
		Usuario u = new Usuario();
		u.setNombre(usuario.getNombre());
		u.setEmail(usuario.getEmail());
		u.setDireccion(usuario.getDireccion());
		u.setPassword(usuario.getPassword());
		du.save(u);
	}

	public boolean login() {
		Usuario uAux = 
				du.findByNombreAndPassword(
						usuario.getNombre(), 
						usuario.getPassword());
		if(uAux == null) {
			return false;
		}else {
			return true;	
		}		
	}
}
