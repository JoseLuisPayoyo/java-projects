import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaquinaSnack {
    public static void main(String[] args) {
        maquinaSnacks();
    }

    public static void maquinaSnacks(){
        boolean salir = false;
        var consola = new Scanner(System.in);

        //Creamos lista de tip snack
        ArrayList<Snack> productos = new ArrayList<>();
        System.out.println("*** Maquina de Snack ***");
        Snacks.mostrarSnack(); //mostrar el inventario

        while (!salir){
            try{
                var opcion = mostrarMenu(consola);
                salir = ejecutarOpciones(opcion, consola, productos);
            }catch (Exception e){
                System.out.println("Ocurrio un error: " + e.getMessage());
            }
            finally {
                System.out.println(); //imprime un salto de linea por iteracion
            }
        }
    }

    private static int mostrarMenu(Scanner consola){
        System.out.print("""
                Menu:
                1. Comprar Snack
                2. Mostrar Ticket
                3. Agregar nuevo snack
                4. Salir
                Elige una opcion:\s""");
        //leemos y retornamos la opcion seleccionada por el usuario
        return Integer.parseInt(consola.nextLine());
    }

    private static boolean ejecutarOpciones(int opcion, Scanner consola, List<Snack> productos){
        var salir = false;
        switch (opcion){
            case 1 -> comprarSnack(consola, productos);
            case 2 -> mostrarTicket(productos);
            case 3 -> agregarSnack(consola);
            case 4 -> {
                System.out.println("Hasta pronto");
                salir = true;
            }
            default -> System.out.println("Opcion invalida: " + opcion);
        }
        return salir;
    }

    private static void comprarSnack(Scanner consola, List<Snack> productos){
        System.out.print("Que snack quieres comprar (id): ");
        var idSnack = Integer.parseInt(consola.nextLine());
        //validar que existe
        var snackEncontrado = false;
        for (Snack snack : Snacks.getSnacks()){
            if (snack.getIdSnack() == idSnack){
                productos.add(snack);
                System.out.println("Snack agregado!: " + snack);
                snackEncontrado = true;
                break;
            }
        }
        if (!snackEncontrado){
            System.out.println("ID de snack no encontrado!");
        }
    }

    private static void mostrarTicket(List<Snack> productos){
        var ticket = "***  Ticket de Venta *** ";
        var total = 0.0;
        for (var producto: productos){
            ticket += "\n\t- " + producto.getNombre() + " - $" + producto.getPrecio();
            total += producto.getPrecio();
        }
        ticket += "\n\tTotal -> $" + total;
        System.out.println(ticket);
    }

    private static void agregarSnack(Scanner consola){
        System.out.print("Nombre del snack: ");
        var nombre = consola.nextLine();

        System.out.print("Precio del snack: ");
        var precio = Double.parseDouble(consola.nextLine());
        Snacks.agregarSnack(new Snack(nombre, precio));
        System.out.println("Tu snack se ha agregado correctamente");
        Snacks.mostrarSnack();
    }



}
