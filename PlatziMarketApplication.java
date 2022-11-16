

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.platzi.market.persistence.mapper"})
public class PlatziMarketApplication {
 
	public static void main(String[] args) {
		SpringApplication.run(PlatziMarketApplication.class, args);
	}
    
	
	
	
}
