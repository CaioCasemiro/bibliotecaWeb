package br.com.bibliotecaWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "br.com.bibliotecaWeb")
@EntityScan(basePackages = {"br.com.bibliotecaWeb.model", "br.com.bibliotecaWeb.repository", "br.com.bibliotecaWeb.service"})

public class BibliotecaWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaWebApplication.class, args);
	
	}

}
