
package desarrollo.tpentrega1.entidades;

public class Bebida extends ItemMenu {
    private double graduacionAlcoholica;
    private double tamaño;

    public Bebida(){}

    public Bebida(String id,
                String nombre,
                String descripcion,
                double precio,
                String categoria,
                double tamaño,
                double graduacionAlcoholica) {
        super(id, nombre, descripcion, precio, categoria);
        this.graduacionAlcoholica = graduacionAlcoholica;
        this.tamaño = tamaño;
    }

    public Bebida(double tamaño, double graduacionAlcoholica) {
        this.graduacionAlcoholica = graduacionAlcoholica;
        this.tamaño = tamaño;
    }

    // getters / setters

    public double getGraduacionAlcoholica() {
        return graduacionAlcoholica;
    }

    public void setGraduacionAlcoholica(double graduacionAlcoholica) {
        this.graduacionAlcoholica = graduacionAlcoholica;
    }

    public double getTamaño() {
        return tamaño;
    }

    public void setTamaño(double tamaño) {
        this.tamaño = tamaño;
    }

    // funcs

    public double peso() {
        double p;
        if (graduacionAlcoholica == 0)
            p = (tamaño * 1.04 + ((tamaño * 20) / 100));
        else
            p = (tamaño * 0.99 + ((tamaño * 20) / 100));
        return p;
    };

    public boolean aptoVegano() {
        return false;
    };

    public boolean esBebida() {
        return true;
    };

    public boolean esComida() {
        return false;
    };
    public String toString() {
    return "Bebida{" +
            "tamaño=" + this.tamaño +
            ", graduacionAlcoholica=" + this.graduacionAlcoholica +
            ", nombre=" + this.getNombre() +
            ", descripcion=" + this.getDescripcion() +
            ", precio=" + this.getPrecio() +
            '}';
}
}
