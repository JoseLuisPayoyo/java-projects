package jose.zona_fit;

import jose.zona_fit.modelo.Cliente;
import jose.zona_fit.servicio.IClienteServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
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
			salir = ejecutarOpciones(consola, opcion);
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

	private boolean ejecutarOpciones(Scanner consola, int opcion){
		var salir = false;
		switch (opcion){
			case 1 -> { //listar clientes
				logger.info(nl + "--- Listado de Clientes ---" + nl);
				List<Cliente> clientes = clienteServicio.listarCliente();
				clientes.forEach(cliente -> logger.info(cliente.toString() + nl));
			}

			case 2 -> { //buscar cliente por id
				logger.info(nl + "--- Buscar de Cliente por ID ---" + nl);
				logger.info("Que cliente desea buscar (id): ");
				var idCliente = Integer.parseInt(consola.nextLine());
				Cliente cliente = clienteServicio.buscarClientePorId(idCliente);
				if (cliente != null){
					logger.info("Cliente encontrado: " + cliente + nl);
				}else
					logger.info("Cliente no encontrado: " + cliente + nl);

			}

			case 3 -> { //agregar cliente
				logger.info(nl + "--- Agregar Cliente ---" + nl);
				logger.info("Nombre: ");
				var nombre = consola.nextLine();
				logger.info("Apellido: ");
				var apellido = consola.nextLine();
				logger.info("Membresia: ");
				var membresia = Integer.parseInt(consola.nextLine());

				Cliente cliente = new Cliente();
				cliente.setNombre(nombre);
				cliente.setApellido(apellido);
				cliente.setMembresia(membresia);

				clienteServicio.guardarCliente(cliente);
				logger.info("Cliente agregado: " + cliente + nl);
			}

			case 4 -> { //modificar cliente
				logger.info(nl + "--- Modificar Cliente ---" + nl);
				logger.info("Id Cliente: ");
				var idCliente = Integer.parseInt(consola.nextLine());
				Cliente cliente = clienteServicio.buscarClientePorId(idCliente);
				if (cliente != null){
					logger.info("Nombre: ");
					var nombre = consola.nextLine();
					logger.info("Apellido: ");
					var apellido = consola.nextLine();
					logger.info("Membresia: ");
					var membresia = Integer.parseInt(consola.nextLine());

					cliente.setNombre(nombre);
					cliente.setApellido(apellido);
					cliente.setMembresia(membresia);
					clienteServicio.guardarCliente(cliente);
					logger.info("Cliente modificado: " + cliente + nl);
				} else{
					logger.info("Cliente no encontrado: " + cliente + nl);
				}
			}

			case 5 -> { //eliminar cliente
				logger.info(nl + "--- Eliminar Cliente ---" + nl);
				logger.info("Id Cliente: ");
				var idCliente = Integer.parseInt(consola.nextLine());
				var cliente = clienteServicio.buscarClientePorId(idCliente);
				if (cliente != null){
					clienteServicio.eliminarCliente(cliente);
					logger.info("Cliente eliminado: " + cliente + nl);
				}else{
					logger.info("Cliente no encontrado: " + cliente + nl);
				}
			}

			case 6 -> { //salir
				logger.info("Saliendo...." + nl + nl);
				salir = true;
			}

			default -> logger.info("Opcion no valida");
		}
		return salir;
	}
}
