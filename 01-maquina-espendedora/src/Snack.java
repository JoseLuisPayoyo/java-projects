import java.util.Objects;

public class Snack {

    private static int contadorSnacks;
    private int idSnack;
    private String nombre;
    private double precio;

    public Snack(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
        contadorSnacks++;
        idSnack = contadorSnacks;
    }

    public int getIdSnack() {
        return idSnack;
    }

    public void setIdSnack(int idSnack) {
        this.idSnack = idSnack;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Snack snack = (Snack) o;
        return idSnack == snack.idSnack && Double.compare(precio, snack.precio) == 0 && Objects.equals(nombre, snack.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSnack, nombre, precio);
    }
}
