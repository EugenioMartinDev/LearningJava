package curso.modelo.negocio;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import curso.modelo.entidad.Categoria;
import curso.modelo.entidad.Producto;
import curso.modelo.persistencia.DaoCategoria;
import curso.modelo.persistencia.DaoProducto;

@Service
public class DataPopulator {

		   @Autowired
		   private DaoProducto dp;
		   
		   @Autowired
		   private DaoCategoria dc;
		   
		   public void execute( ) {

		   try {

			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();

			DefaultHandler handler = new DefaultHandler() {

			boolean inCategoria = false;
			boolean inProducto = false;
			boolean nombreCategoria = false;
			boolean nombreProducto = false;
			boolean precio = false;
			
			String catName = "";
			String proName = "";
			String precioVal = "";

			public void startElement(String uri, String localName,String qName, 
		                Attributes attributes) throws SAXException {

				System.out.println("Start Element :" + qName);

				if (qName.equalsIgnoreCase("CATEGORIA")) {
					inCategoria = true;
				}
				
				if (qName.equalsIgnoreCase("PRODUCTO")) {
					inProducto = true;
				}
				
				if (qName.equalsIgnoreCase("NOMBRECATEGORIA")) {
					nombreCategoria = true;
				}

				if (qName.equalsIgnoreCase("NOMBRE")) {
					nombreProducto = true;
				}

				if (qName.equalsIgnoreCase("PRECIO")) {
					precio = true;
				}

			}

			public void endElement(String uri, String localName,
				String qName) throws SAXException {

				System.out.println("End Element :" + qName);
												
				if (qName.equalsIgnoreCase("CATEGORIA")) {
					inCategoria = false;

				}
				
				if (qName.equalsIgnoreCase("PRODUCTO")) {
					inProducto = false;
					
					Producto producto = new Producto();
					
					Categoria categoria = new Categoria();
					categoria.setNombre(catName);
					categoria = dc.findByNombre(catName);
					
					//producto.setCategoria(categoria);
					producto.setNombre(proName);
					producto.setPrecio(Double.parseDouble(precioVal));
					producto.setUnidades(0);
					
					categoria.addProducto(producto);
					
					System.out.println("Producto : " + producto);
					
					dp.save(producto);
					if (producto.getId() != 0) {
						System.out.println("Producto insertado");
					} else {
						System.out.println("Producto NO se ha insertado");
					}
				}

			}

			public void characters(char ch[], int start, int length) throws SAXException {

				if (inCategoria) {
					if (nombreCategoria) {
						System.out.println("Categoria Name : " + new String(ch, start, length));
						catName = new String(ch, start, length);
						nombreCategoria = false;
						
						Categoria categoria = new Categoria();
						categoria.setNombre(catName);
						dc.save(categoria);
						/**
						Categoria categoriaDB = dc.findByNombre(catName);
						if (categoriaDB == null || categoriaDB.getId() == 0) {
							dc.save(categoria);
						}
						**/
						
					}
					if (inProducto) {
						if (nombreProducto) {
							System.out.println("Producto Name : " + new String(ch, start, length));
							proName = new String(ch, start, length);
							nombreProducto = false;
						}
						if (precio) {
							System.out.println("Precio : " + new String(ch, start, length));
							precioVal = new String(ch, start, length);
							precio = false;
						}
					}
				}
			}

		 };

		 	saxParser.parse("./src/main/resources/supermercado.xml", handler);
		 
		    } catch (Exception e) {
		       e.printStackTrace();
		     }
	}

		  

}
