package curso.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.context.request.NativeWebRequest;
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
			
			pedido.setListaProductos(listaProductos);

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
		
		
		Producto p = new Producto();
		p.setNombre(nombre);
		p.setPrecio(precio);
		p.setUnidades(unidades);
		
		System.out.println("tratar Pedido : " + pedido);
		
		gp.tratarPedido(p);
		
		System.out.println("tratado Pedido : " + pedido);

		mav.addObject("listaPedidos", pedido.getListaProductos());
		mav.setViewName("muestraPedidos");
		
		System.out.println("controlador : " + pedido);
		
		
		return mav;
		
	}
	
	@RequestMapping("generarPedido")
	public ModelAndView generarPedido(
			ModelAndView mav) {
		
		System.out.println("Generar Pedido : " + pedido);
		
		gp.generarPedido();
		
		System.out.println("Generado Pedido : " + pedido);
		
		mav.getModelMap().addAttribute("pedido", pedido);	
		mav.getModelMap().addAttribute("listaProductos", pedido.getListaProductos());
		mav.getModelMap().addAttribute("usuario", usuario);
		mav.getModelMap().addAttribute("nombre", usuario.getNombre());
		mav.getModelMap().addAttribute("direccion", usuario.getDireccion());
		
		System.out.println("generarPedido " + pedido);
		System.out.println("generarPedido " + usuario);
		
		mav.setViewName("redirect:pedidoCompleto");		
		
		return mav;
	}
	
	@RequestMapping("pedidoCompleto")
	public ModelAndView pedidoCompleto(
			ModelAndView mav) {		
		mav.addObject("usuario", usuario);
		mav.addObject("pedido", pedido);
		mav.addObject("listaProductos", pedido.getListaProductos());
		
		mav.setViewName("pedidoCompleto");
		
		return mav;
	}
	
	@RequestMapping("aceptar")
	public ModelAndView aceptar(
			ModelAndView mav) {
		
		mav.getModelMap().addAttribute("mensaje", "Pedido tramitado. En breve lo recibira en su domicilio");
		mav.setViewName("redirect:login");
	
		return mav;
	}
	
	@RequestMapping("cancelar")
	public ModelAndView cancelar(
			ModelAndView mav) {
		
		mav.getModelMap().addAttribute("error", "Pedido cancelado por el usuario");
		mav.setViewName("redirect:login");
	
		return mav;
	}

}
