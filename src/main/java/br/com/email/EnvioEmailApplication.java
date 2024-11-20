package br.com.email;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "API - Envio de email",
				version = "1.0",
				description = "Documentando uma API para envio de email com o javamail",
				contact = @Contact(name = "Carlos Roberto", email = "crrsj1@gmail.com")
		)
)
public class EnvioEmailApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnvioEmailApplication.class, args);
	}

}
