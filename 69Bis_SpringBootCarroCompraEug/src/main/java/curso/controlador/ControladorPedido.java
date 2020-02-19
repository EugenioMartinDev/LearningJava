package curso.controlador;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;

import curso.modelo.entidad.Categoria;
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
			@RequestParam(required = false) String nombreCategoria,
			ModelAndView mav) {
		
		if (usuario.isRegistrado()) {
			
			if (nombreCategoria != null && !nombreCategoria.isEmpty()) {
				Categoria categoria = gp.obtenerCategoria(nombreCategoria);
				List<Producto> listaProductosPorCategoria = gp.obtenerProductosPorCategoria(categoria);
				
				pedido.getListaCategorias().clear();
				pedido.getListaCategorias().add(categoria);
				mav.addObject("listaCategorias", pedido.getListaCategorias());	
				
				mav.addObject("categoriaRcvd", nombreCategoria);
				mav.addObject("listaProductosPorCategoria", listaProductosPorCategoria);
			}
			

			
			mav.addObject("listaProductos", pedido.getListaProductos());

			mav.addObject("listaPedidos", pedido.getListaProductosSeleccionados());
						
			mav.setViewName("muestraPedidosCombo");
			
		} else {
			mav.setViewName("redirect:login");
		}
		
		return mav;
	}
	
	@RequestMapping("seleccionCategoria")
	public ModelAndView doSeleccionCategoria(
			ModelAndView mav) {
		
		if (usuario.isRegistrado()) {
			
			pedido.setUsuario(usuario);
			
			if (pedido.getListaProductos() == null || pedido.getListaProductos().isEmpty()) {
				List<Producto> listaProductos = gp.obtenerProductos();
				pedido.setListaProductos(listaProductos);
			}
			List<Categoria> listaCategorias = gp.obtenerCategorias();
			pedido.setListaCategorias(listaCategorias);
						
			mav.addObject("listaCategorias", pedido.getListaCategorias());	

			
			mav.addObject("listaPedidos", pedido.getListaProductosSeleccionados());
					
			
			mav.setViewName("muestraPedidosCombo");
			
		} else {
			mav.setViewName("redirect:login");
		}
		
		return mav;
	}
	
	
	@RequestMapping("tratarPedido")
	public ModelAndView tratarPedido(
			@RequestParam() String producto,
			@RequestParam() int unidades,
			ModelAndView mav) {
		
		label1:
		for (Producto p : pedido.getListaProductos()) {
			
			if (unidades > 0)
			{
				if (producto.contentEquals(p.getNombre())) {
					p.setUnidades(unidades);
					
					boolean duplicado = false;
					label2:
					for (Producto pro : pedido.getListaProductosSeleccionados())
					{
						if (p.getNombre().contentEquals(pro.getNombre())) {
							pro.setUnidades(unidades);
							duplicado = true;
							break label2;
						}				
					}
					if (!duplicado) pedido.getListaProductosSeleccionados().add(p);
					
					break label1;
				}
			}
		}

		mav.setViewName("redirect:seleccionCategoria");

		return mav;		
	}

	@RequestMapping("calcularImporte")
	public ModelAndView calcularImporte(
			ModelAndView mav) {
		
		for (Producto p : pedido.getListaProductos()) {
			pedido.setImporte(pedido.getImporte() + (Math.round(p.getPrecio() * p.getUnidades())*100.0)/100.0);
		}
		
		mav.setViewName("redirect:verResumen");
		return mav;
	}
	
	
	@RequestMapping("verResumen")
	public String verResumen(Model model) {
		
		model.addAttribute("pedido", pedido);
		
		return "resumen";
	}
	
	@RequestMapping("aceptar")
	public ModelAndView aceptar(
			ModelAndView mav) {
		
		pedido.getListaProductosSeleccionados().clear();
		pedido.getListaProductos().clear();
		
		mav.getModelMap().addAttribute("mensaje", "Su pedido ha sido tramitado");
		mav.setViewName("redirect:login");
		
		return mav;
	}
	
	@RequestMapping("cancelar")
	public ModelAndView cancelar(
			ModelAndView mav) {
		
		pedido.getListaProductosSeleccionados().clear();
		pedido.getListaProductos().clear();
		
		mav.getModelMap().addAttribute("error", "Pedido cancelado por el usuario");
		mav.setViewName("redirect:login");
		
		return mav;
	}
}
