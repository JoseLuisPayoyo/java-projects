import java.util.Scanner;

public class MaquinaSnack {
    static Scanner scanner = new Scanner(System.in);


    private static void mostrarMenu(){
        System.out.println("""
                *** Menu:
                1. Comprar Snack
                2. Mostrar Ticket
                3. Agregar nuevo snack
                4. Salir
                """);
        System.out.print("Elige una opcion: ");
        int opcion = Integer.parseInt(scanner.nextLine());
    }
}
