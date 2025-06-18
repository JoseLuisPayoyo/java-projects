import java.util.ArrayList;

public class Snacks {

    private static final ArrayList<Snack> snacks;

    //Bloque estatico inicializador
    static {
        snacks = new ArrayList<>();
        snacks.add(new Snack("Patatas", 70));
        snacks.add(new Snack("Refresco", 50));
        snacks.add(new Snack("Sandwich", 120));
    }

    public ArrayList<Snack> getSnacks() {
        return snacks;
    }

    public static void agregarSnack(Snack s){
        snacks.add(s);
    }

    public static void mostrarSnack(){
        for (Snack snack : snacks){
            System.out.println(snack);
        }
    }

    public static Snack buscarSnackPorNombre(String nombre){
        for (Snack snack : snacks){
            if (snack.getNombre().equalsIgnoreCase(nombre)){
                return snack;
            }
        }
        return null;
    }
}
