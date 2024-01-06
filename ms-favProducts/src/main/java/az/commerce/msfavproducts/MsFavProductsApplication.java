package az.commerce.msfavproducts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsFavProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsFavProductsApplication.class, args);
	}

}
