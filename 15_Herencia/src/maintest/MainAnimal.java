package maintest;

import java.util.ArrayList;

import entidad.Animal;
import entidad.Oso;
import entidad.Pez;
import entidad.PezPayaso;
import entidad.Placton;
import entidad.Tiburon;
import entidad.Trucha;

public class MainAnimal {

	public static void main(String[] args) {
		Tiburon tiburon = new Tiburon();
		tiburon.setNombre("Robustiano");
		tiburon.setEdad(4);
		tiburon.setNumeroAletas(6);
		tiburon.setPeso(250);
		
		ArrayList<Animal> listaAnimales = new ArrayList<Animal>();
		listaAnimales.add(tiburon);
		
		Pez pez = new PezPayaso();
		pez.setNombre("Nemo");
		pez.setNumeroAletas(4);
		pez.setEdad(5);
		pez.setPeso(9);
		
		listaAnimales.add(pez);
		
		pez = new Trucha();
		pez.setNombre("Elisa");
		pez.setNumeroAletas(2);
		pez.setEdad(2);
		pez.setPeso(0.2);
		
		listaAnimales.add(pez);
		
		Oso oso = new Oso();
		oso.setNombre("Yogui");
		oso.setEdad(11);
		oso.setPeso(411);
		
		listaAnimales.add(oso);
		
		Placton placton = new Placton();
		placton.setCalorias(500);
		
		for (Animal animal : listaAnimales) {
			animal.comer(placton);
		}
		
		for (Animal animal : listaAnimales) {
			animal.comer(pez);
		}
		
		for (Animal animal : listaAnimales) {
			animal.comer(new Oso());
		}
		
		

	}

}
