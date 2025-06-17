import java.util.ArrayList;

public class Snacks {

    private ArrayList<Snack> snacks = new ArrayList<>();

    public ArrayList<Snack> getSnacks() {
        return snacks;
    }

    public boolean agregarSnack(Snack s){
        boolean aniadido = false;
        if (s != null){
            snacks.add(s);
            System.out.println("Snack añadido correctamente");
            return true;
        }else{
            System.out.println("No se ha podido añadir el snack");
            return false;
        }
    }

    public void mostrarSnack(){
        for (Snack snack : snacks){
            System.out.println(snack);
        }
    }

    public Snack buscarSnackPorNombre(String nombre){
        for (Snack snack : snacks){
            if (snack.getNombre().equalsIgnoreCase(nombre)){
                return snack;
            }
        }
        return null;
    }
}
