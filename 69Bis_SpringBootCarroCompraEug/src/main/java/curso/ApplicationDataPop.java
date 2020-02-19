package curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import curso.modelo.negocio.DataPopulator;

@SpringBootApplication
public class ApplicationDataPop implements CommandLineRunner {

	@Autowired
	private DataPopulator dataPop;
	
	public static void main(String[] args) {
		SpringApplication.run(ApplicationDataPop.class, args);
	}

	
	  @Override
	  public void run(String... args) throws Exception {
		  dataPop.execute();
	  }
}
