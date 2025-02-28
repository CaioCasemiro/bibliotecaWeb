package br.com.bibliotecaWeb;

import org.springframework.boot.SpringApplication;

public class TestBibliotecaWebApplication {

	public static void main(String[] args) {
		SpringApplication.from(BibliotecaWebApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
