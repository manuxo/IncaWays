package pe.edu.upc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"pe.edu.upc.entity"})
public class SpringbootAgenciaviajesApplication{

	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootAgenciaviajesApplication.class, args);
	}

}
