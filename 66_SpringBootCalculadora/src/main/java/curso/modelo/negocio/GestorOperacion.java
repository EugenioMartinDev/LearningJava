package curso.modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.modelo.entidad.Operacion;
import curso.modelo.persistencia.DaoOperacion;

@Service
public class GestorOperacion {

	@Autowired
	private DaoOperacion dao;
	
	public List<Operacion> getLista(){
		return dao.findAll();
	}
	
	public void alta(Operacion o) {
		dao.save(o);
	}
	
	public void calcular(Operacion o) {
		switch (o.getTipo()) {
		case "sumar":
			o.setResultado(o.getNumero1() + o.getNumero2());
			break;
		case "restar":
			o.setResultado(o.getNumero1() - o.getNumero2());
			break;
		case "multiplicar":
			o.setResultado(o.getNumero1() * o.getNumero2());
			break;
		case "dividir":
			o.setResultado(o.getNumero1() / o.getNumero2());
			break;
		default:
			break;
		}
		
		alta(o);
	}
}
