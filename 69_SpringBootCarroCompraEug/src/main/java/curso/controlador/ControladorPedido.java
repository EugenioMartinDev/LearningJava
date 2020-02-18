package curso.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;

import curso.modelo.entidad.Pedido;
import curso.modelo.entidad.Producto;
import curso.modelo.entidad.Usuario;
import curso.modelo.negocio.GestorProducto;

@Controller
public class ControladorPedido {

	@Autowired
	private GestorProducto gp;
	
	@Autowired
	private Usuario usuario;
		
	@Autowired
	private Pedido pedido;
	
	@RequestMapping("seleccionProductos")
	public ModelAndView doSeleccionProductos(
			ModelAndView mav) {
		
		if (usuario.isRegistrado()) {
			
			pedido.setUsuario(usuario.getNombre());
			
			List<Producto> listaProductos = gp.obtenerProductos();
			
			for (Producto p : listaProductos) {				
				pedido.getListaProductos().add(p);
			}
			
			mav.addObject("listaPedidos", pedido.getListaProductos());
			mav.setViewName("muestraPedidos");
			
		} else {
			mav.setViewName("redirect:login");
		}
		
		return mav;
	}
	
	@RequestMapping("tratarPedido")
	public ModelAndView tratarPedido(
			@RequestParam() String nombre,
			@RequestParam() double precio,
			@RequestParam() int unidades,
			ModelAndView mav) {
		
		
		List<Producto> listaPedidos = (ArrayList<Producto>) mav.getModelMap().getAttribute("pedido");

		mav.setViewName("login");
		
		return mav;
		
	}

}
