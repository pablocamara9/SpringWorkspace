package com.example.monumentos;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
		description = "API con iformación sobre los distintos monumentos del mundo",
		version = "1.3",
		contact = @Contact(
				name = "Pablo Cámara García",
				email = "camara.gapab23@triana.salesianos.edu"),
		license = @License(
				name = "Una licencia licenciada"),
		title = "API sobre Monumentos")
)
public class MonumentosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonumentosApplication.class, args);
	}

}
