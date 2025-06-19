package maquina_snack_archivos.servicio;

import maquina_snack_archivos.dominio.Snack;

import java.util.ArrayList;
import java.util.List;

public class ServicioSnacksLista implements IServicioSnacks{

    private static final ArrayList<Snack> snacks;

    //Bloque estatico inicializador
    static {
        snacks = new ArrayList<>();
        snacks.add(new Snack("Patatas", 70));
        snacks.add(new Snack("Refresco", 50));
        snacks.add(new Snack("Sandwich", 120));
    }

    public List<Snack> getSnacks() {
        return snacks;
    }

    public  void agregarSnack(Snack s){
        snacks.add(s);
    }

    public void mostrarSnack(){
        for (Snack snack : snacks){
            System.out.println(snack);
        }
    }

}
