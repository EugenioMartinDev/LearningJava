package maintest;

import entidad.Animal;
import entidad.Oso;
import entidad.PezPayaso;
import entidad.Placton;
import entidad.Tiburon;
import entidad.Trucha;

public class MainPez {

	public static void main(String[] args) {
		
		// No se puede instanciar una clase abstracta
		// Animal a = new Animal();
		
		Animal a = new Trucha();
		a.setNombre("Roberta"); 
		a.setPeso(3);  //3 kilos
		Animal b = new PezPayaso();
		b.setNombre("Nemo");

		a.comer(b);
		
		Placton p = new Placton();
		p.setCalorias(100);
		
		System.out.println(a.toString());
		a.comer(p);
		System.out.println(a.toString());
		
		Animal c = new Tiburon();
		c.setNombre("Hawk");
		c.comer(p);
		c.comer(b);
		
		Animal o = new Oso();
		o.setNombre("Yogui");
		o.comer(p);
		o.comer(c);
		
		
	}

}
