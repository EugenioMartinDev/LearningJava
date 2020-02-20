package curso.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import curso.modelo.entidad.Producto;
import curso.modelo.entidad.Usuario;
import curso.modelo.negocio.GestorPedido;
import curso.modelo.negocio.GestorProducto;

@Controller
public class ControladorPedido {

	@Autowired
	private Usuario usuario;
	
	@Autowired
	private GestorPedido gPedido;
	
	@Autowired
	private GestorProducto gProducto;
	
	//este metodo muestra la pagina de inicio del pedido
	@RequestMapping("inicio")
	public String inicio(Model model) {//Model es el objeto de modelo donde podemos guardar lo objetos que queremos pasar a la vista
		if(!validado()) {
			return "redirect:login";
		}
		List<Producto> listaProductos = gProducto.listar();
		model.addAttribute("listaProductos", listaProductos);
		List<Producto> listaProductosSeleccionados = 
				usuario.getPedido().getListaProductos();
		model.addAttribute("listaProductosSeleccionados", 
				listaProductosSeleccionados);
		model.addAttribute("nombre", usuario.getNombre());
		return "inicio";
	}
	
	@RequestMapping("addProducto")
	public String addProducto(@RequestParam Integer id) {
		if(!validado()) {
			return "redirect:login";
		}
		Producto productoSeleccionado = gProducto.obtener(id);
		usuario.getPedido()
			.getListaProductos().add(productoSeleccionado);
		return "redirect:inicio";
	}
	
	@RequestMapping("pagar")
	public String pagar(Model model) {
		if(!validado()) {
			return "redirect:login";
		}
		gPedido.calcularPrecioTotal();
		model.addAttribute("usuario", usuario);
		return "resumen";
	}
	
	private boolean validado() {
		if(usuario.isLogado()) {
			return true;
		}else {
			return false;
		}
	}
}
