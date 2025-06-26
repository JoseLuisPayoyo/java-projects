package jose.zona_fit;

import jose.zona_fit.servicio.IClienteServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ZonaFitApplication implements CommandLineRunner {

	@Autowired
	private IClienteServicio clienteServicio;
	String nl = System.lineSeparator(); //salto de linea

	private static final Logger logger = LoggerFactory.getLogger(ZonaFitApplication.class); //poder imprimir en pantalla

	public static void main(String[] args) {
		logger.info("Iniciando la app");
		//Levantar spring
		SpringApplication.run(ZonaFitApplication.class, args);
		logger.info("app finalizada");
	}

	@Override
	public void run(String... args) throws Exception {
		zonaFitApp();
	}

	private void zonaFitApp(){

		var salir = false;
		var consola = new Scanner(System.in);

		while(!salir){
			var opcion = mostrarMenu(consola);
			//salir = ejecutarOpciones(consola, opcion);
			logger.info(nl); //salto de linea
		}
	}

	private int mostrarMenu(Scanner consola){
		logger.info("""
				\n*** Aplicacion Zona Fit ***
				1. Listar clientes
				2. Buscar cliente
				3. Agregar cliente
				4. Modificar cliente
				5. Eliminar cliente
				6. Salir
				Elige una opcion:\s""");
		return Integer.parseInt(consola.nextLine());
	}
}
