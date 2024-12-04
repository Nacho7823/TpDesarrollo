
package desarrollo.tpentrega1.entidades;

public class Bebida extends ItemMenu {
    private double graduacionAlcoholica;
    private double tamaño;

    
 private Bebida(Builder builder) {
        super(builder);
        this.graduacionAlcoholica = builder.graduacionAlcoholica;
        this.tamaño = builder.tamaño;
    }

    public static class Builder extends ItemMenu.Builder<Builder> {
        private double graduacionAlcoholica;
        private double tamaño;

        public Builder graduacionAlcoholica(double graduacionAlcoholica) { 
            this.graduacionAlcoholica = graduacionAlcoholica; 
            return this; 
        }

        public Builder tamaño(double tamaño) { 
            this.tamaño = tamaño; 
            return this; 
        }

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public Bebida build() {
            return new Bebida(this);
        }
    }

    // getters / setters

    @Override
    public double getGraduacionAlcoholica() {
        return graduacionAlcoholica;
    }

    @Override
    public void setGraduacionAlcoholica(double graduacionAlcoholica) {
        this.graduacionAlcoholica = graduacionAlcoholica;
    }

    @Override
    public double getTamaño() {
        return tamaño;
    }

    @Override
    public void setTamaño(double tamaño) {
        this.tamaño = tamaño;
    }

    // funcs

    @Override
    public double getCalorias() {
        return 0;
    }

    @Override
    public boolean aptoCeliaco() {
        return false;
    }

    @Override
    public void setCalorias(double calorias) {}

    @Override
    public void setAptoCeliaco(boolean apto) {}

    @Override
    public void setAptoVegano(boolean apto) {}

    @Override
    public void setPeso(double peso) {}

    @Override
    public double peso() {
        double p;
        if (graduacionAlcoholica == 0)
            p = (tamaño * 1.04 + ((tamaño * 20) / 100));
        else
            p = (tamaño * 0.99 + ((tamaño * 20) / 100));
        return p;
    };

    @Override
    public boolean aptoVegano() {
        return false;
    };

    @Override
    public boolean esBebida() {
        return true;
    };

    @Override
    public boolean esComida() {
        return false;
    };
    @Override
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
