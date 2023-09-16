package utn.estudiantes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import utn.estudiantes.modelo.Estudiante;
import utn.estudiantes.servicio.EstudianteServicio;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication // para ejecutar
public class EstudiantesApplication implements CommandLineRunner {

	@Autowired
	private EstudianteServicio estudianteServicio;

	// utilizamos el loggerFactory para imprimir en consola.
	private static  final Logger logger = LoggerFactory.getLogger(EstudiantesApplication.class);

	String nl = System.lineSeparator();//generico regresa el caracter correcto para el sistema operativo.
	public static void main(String[] args) {

		logger.info("Iniciando la aplicación...");
		//Levantar la fabrica de Spring
		SpringApplication.run(EstudiantesApplication.class, args);
		logger.info("Aplicacion finalizada...");
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info(nl+"Ejecutando el método run de Spring..."+nl);
		var salir = false;
		var consola = new Scanner(System.in);
		while(!salir){
			mostrarMenu();
			salir = ejecutarOpciones(consola);
			logger.info(nl);
		}//fin ciclo while
	}

	private  void mostrarMenu(){
		//logger.info(nl);
		logger.info("""
				************ Sistema de Estudiantes ******************
				1. Listar Estudiantes
				2. Buscar Estudiante
				3. Agregar Estudiante
				4. Modificar Estudiante
				5. Eliminar Estudiante
				6. Salir
				Eliga una opción:""");

	}

	private boolean ejecutarOpciones(Scanner consola){
		var opcion = Integer.parseInt(consola.nextLine());
		var salir = false;
		switch (opcion){
			case 1 ->{//Listar estudiantes
				logger.info(nl+"Listado de estudiantes"+nl);
				List<Estudiante> estudiantes = estudianteServicio.listarEstudiantes();
				estudiantes.forEach((estudiante -> logger.info(estudiante.toString())));
			} //fin switch
			case 2 -> {//Buscar estudiante por id
				logger.info("Digite el id estudiante a buscar:");
				var idEstudiante = Integer.parseInt(consola.nextLine());
				Estudiante estudiante= estudianteServicio.buscarEstudiantePorId(idEstudiante);
				if (estudiante != null)
					logger.info("Estudiante encontrado: "+ estudiante +nl);
				else
					logger.info("Estudiante NO encontrado: "+ estudiante +nl);
			}
			case 3 -> {//Agregar estudiante
				logger.info("Agregar estudiante: "+nl);
				logger.info("Nombre: ");
				var nombre = consola.nextLine();
				logger.info("Apellido: ");
				var apellido = consola.nextLine();
				logger.info("Telefono: ");
				var telefono = consola.nextLine();
				logger.info("Email: ");
				var email = consola.nextLine();
				//Crear el objeto estudiante sin id
				var estudiante = new Estudiante();
				estudiante.setNombre(nombre);
				estudiante.setApellido(apellido);
				estudiante.setTelefono(telefono);
				estudiante.setEmail(email);
				estudianteServicio.guardarEstudiante(estudiante);
				logger.info("Estudiante agregado: "+ estudiante + nl);
			}
			case 4 ->{ //modificar estudiante
				logger.info("Modificar Estudiante: "+nl);
				logger.info("Ingrese el id estudiante: ");
				var idEstudiante = Integer.parseInt(consola.nextLine());
				//Buscamos el estudiante a modificar
				Estudiante estudiante = estudianteServicio.buscarEstudiantePorId(idEstudiante);
				if (estudiante != null){
					logger.info("Nombre: ");
					var nombre = consola.nextLine();
					logger.info("Apellido: ");
					var apellido = consola.nextLine();
					logger.info("Telefono: ");
					var telefono = consola.nextLine();
					logger.info("Email: ");
					var email = consola.nextLine();
					estudiante.setNombre(nombre);
					estudiante.setApellido(apellido);
					estudiante.setTelefono(telefono);
					estudiante.setEmail(email);
					estudianteServicio.guardarEstudiante(estudiante);
					logger.info("Estudiante modificado: "+estudiante+nl);
				}
				else
					logger.info("Estudiante NO encontrado con el id: "+idEstudiante+nl);

			}
			case 5 ->{//Eliminar estudiante
				logger.info("Eliminar estudiante: "+nl);
				logger.info("Digite el id estudiante: ");
				var idEstudiante = Integer.parseInt(consola.nextLine());
				//buscamos el id estudiante eliminar
				var estudiante = estudianteServicio.buscarEstudiantePorId(idEstudiante);
				if(estudiante != null){
					estudianteServicio.eliminarEstudiante(estudiante);
					logger.info("Estudiante eliminado: "+estudiante+nl);
				}
				else
					logger.info("Estudiante NO encontrado con id: "+estudiante+nl);
			}
			case 6 ->{//Salir
				logger.info("Hasta pronto!"+nl+nl);
				salir = true;
			}
			default ->  logger.info("Opción no reconocida "+opcion+nl);
		}//Fin de switch
		return salir;

	}//Fin método ejecutarOpciones
}
