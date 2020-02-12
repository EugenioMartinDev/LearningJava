package directorio.modelo.negocio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import directorio.modelo.entidad.Peli;
import directorio.modelo.entidad.PeliculaBase;
import directorio.modelo.persistencia.DaoPeli;
import directorio.modelo.persistencia.DaoPeliculaBase;

@Service
public class GestorPelicula {

	@Autowired
	DaoPeli dp;
	

	@Autowired
	DaoPeliculaBase dpb;



	public String alta(Peli pelicula) {
		
		pelicula.setId(0);

		if (pelicula.getTitulo().isEmpty() 
				||
			pelicula.getYear().isEmpty()
				||
			pelicula.getRecaudacion() == null)
		{
			return "Todos los campos tienen que incluir informacion";
		}
		
		dp.save(pelicula);
		return "La pelicula ha sido insertada en el directorio";

	}

	
	public List<PeliculaBase> listar() {
		
		List<PeliculaBase> listaPeliculasBase = dpb.findAll();
		
		System.out.println("listaPeliculasBase " + listaPeliculasBase.toString());
		for (PeliculaBase pb : listaPeliculasBase) {
			System.out.println(pb.getId() + " " + pb.getTitulo() + " " + pb.getPelicula());
		}

		
		return listaPeliculasBase;
	}


	public Peli getPelicula(int id) {
		Peli pelicula = dp.findById(id).get();
		return pelicula;
	}
	

	public List<Peli> getListaIdTitulo() {
		List<Object[]> lista = dp.selectIdAndTitulo();
		List<Peli> listaPeliculas = new ArrayList<Peli>();
		for(Object[] array : lista) {
			Peli p = new Peli();
			int id = (int)array[0];
			p.setId(id);
			String titulo = (String)array[1];
			p.setTitulo(titulo);
			System.out.println(p);
			listaPeliculas.add(p);
		}
		
		return listaPeliculas;
	}
	
}
