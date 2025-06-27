package zona_fit.presentacion;

import zona_fit.datos.ClienteDAO;
import zona_fit.datos.IClienteDAO;
import zona_fit.dominio.Cliente;

import java.util.Scanner;

public class ZonaFitApp {
    public static void main(String[] args) {
        zonaFitApp();
    }

    private static void zonaFitApp(){
        boolean salir = false;
        Scanner scanner = new Scanner(System.in);
        // Creamos un objeto de la clase clienteDao
        IClienteDAO clienteDAO = new ClienteDAO();
        while(!salir){
            try {
                var opcion = mostrarMenu(scanner);
                salir = ejecutarOpciones(scanner, opcion, clienteDAO);
            } catch (Exception e) {
                System.out.println("Error al ejecutar opciones: " + e.getMessage());
            }
            System.out.println();
        }
    }

    private static int mostrarMenu(Scanner scanner){
        System.out.println("""
                *** Zona Fit ***
                1. Listar Cliente
                2. Buscar Cliente
                3. Agregar Cliente
                4. Modificar Cliente
                5. Eliminar Cliente
                6. Salir""");
        System.out.print("Eliga una opcion: ");
        return Integer.parseInt(scanner.nextLine());
    }

    private static boolean ejecutarOpciones(Scanner scanner, int opcion, IClienteDAO clienteDAO){
        var salir = false;
        switch (opcion){
            case 1 -> { //1. Listar clientes
                System.out.println("--- Listado de Clientes ---");
                var clientes = clienteDAO.listarClientes();
                clientes.forEach(System.out::println);
            }

            case 2 -> { //2. Buscar Cliente
                System.out.print("Introuce el id del cliente: ");
                var idCliente = Integer.parseInt(scanner.nextLine());
                var cliente = new Cliente(idCliente);
                var encontrado = clienteDAO.buscarClientePorId(cliente);
                if (encontrado){
                    System.out.println("Cliente encontrado: " + cliente);
                } else{
                    System.out.println("Cliente con id: " + idCliente + " no encontrado");
                }
            }

            case 3 -> { //3. agregar cliente
                System.out.println("--- Agregar Cliente ---");
                System.out.print("Nombre del cliente: ");
                var nombre = scanner.nextLine();

                System.out.print("Apellido del cliente: ");
                var apellido = scanner.nextLine();

                System.out.print("Membresia: ");
                var membresia = Integer.parseInt(scanner.nextLine());
                var cliente = new Cliente(nombre, apellido, membresia);
                var agregado = clienteDAO.agregarCliente(cliente);
                if (agregado){
                    System.out.println("Cliente agregado con exito: " + cliente);
                } else{
                    System.out.println("No se ha posido agregar el cliente: " + cliente);
                }
            }

            case 4 -> { //4. Modificar cliente
                System.out.println("--- Modificar Cliente ---");
                System.out.print("Id cliente: ");
                var idCliente = Integer.parseInt(scanner.nextLine());

                System.out.print("Nombre del cliente: ");
                var nombre = scanner.nextLine();

                System.out.print("Apellido del cliente: ");
                var apellido = scanner.nextLine();

                System.out.print("Membresia: ");
                var membresia = Integer.parseInt(scanner.nextLine());

                //creamos el objeto
                var cliente = new Cliente(idCliente, nombre, apellido, membresia);
                var modificado = clienteDAO.modificarCliente(cliente);
                if (modificado){
                    System.out.println("Modificado con exito: " + cliente);
                } else{
                    System.out.println("No se ha posido modificar: " + cliente);
                }
            }

            case 5 -> { //5. eliminar
                System.out.print("Id del cliente a eliminar: ");
                var idCliente = Integer.parseInt(scanner.nextLine());

                var cliente = new Cliente(idCliente);
                var eliminado = clienteDAO.eliminarCliente(cliente);
                if (eliminado){
                    System.out.println("Cliente eliminado con exito: " + cliente);
                } else{
                    System.out.println("No se ha posiso eliminar el cliente: " + cliente);
                }
            }

            case 6 -> {
                System.out.println("Saliendo....");
                salir = true;
            }
            default -> System.out.println("Opcion no valida");
        }
        return salir;
    }
}
