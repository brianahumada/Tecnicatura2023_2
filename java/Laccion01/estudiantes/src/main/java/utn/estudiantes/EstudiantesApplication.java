package utn.estudiantes;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import utn.estudiantes.servicio.EstudianteServicio;

@SpringBootApplication // para ejecutar
public class EstudiantesApplication implements CommandLineRunner {

	@Autowired
	private EstudianteServicio estudianteServicio;

	// utilizamos el loggerFactory para imprimir en consola.
	private static  final Logger longger = LoggerFactory.getLogger(EstudiantesApplication.class);

	String nl = System.lineSeparator();//generico regresa el caracter correcto para el sistema operativo.
	public static void main(String[] args) {

		longger.info("Iniciando la aplicación...");
		//Levantar la fabrica de Spring
		SpringApplication.run(EstudiantesApplication.class, args);
		longger.info("Aplicacion finalizada...");
	}

	@Override
	public void run(String... args) throws Exception {
		longger.info(nl+"Ejecutando el método run de Spring..."+nl);
	}
}
