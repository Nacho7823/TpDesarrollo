
package desarrollo.tpentrega1.entidades;

public abstract class ItemMenu {
    
    private String id;
    private String nombre;
    private String descripcion;
    private double precio;
    private String categoria;
 
 protected ItemMenu(Builder<?> builder) {
        this.id = builder.id;
        this.nombre = builder.nombre;
        this.descripcion = builder.descripcion;
        this.precio = builder.precio;
        this.categoria = builder.categoria;
    }

    public static abstract class Builder<T extends Builder<T>> {
        private String id;
        private String nombre;
        private String descripcion;
        private double precio;
        private String categoria;

        public T id(String id) { this.id = id; return self(); }
        public T nombre(String nombre) { this.nombre = nombre; return self(); }
        public T descripcion(String descripcion) { this.descripcion = descripcion; return self(); }
        public T precio(double precio) { this.precio = precio; return self(); }
        public T categoria(String categoria) { this.categoria = categoria; return self(); }

        protected abstract T self();

        public abstract ItemMenu build();
    }

   
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public abstract boolean esComida();
    public abstract boolean esBebida();
    public abstract boolean aptoVegano();
    public abstract double peso();
    public abstract double getCalorias();
    public abstract boolean aptoCeliaco();
    public  abstract void setCalorias(double calorias);
    public abstract void setAptoCeliaco(boolean apto) ;
    public abstract void setAptoVegano(boolean apto) ;
    public abstract void setPeso(double peso) ;
    public abstract double getGraduacionAlcoholica();
    public abstract void setGraduacionAlcoholica(double graduacionAlcoholica);
    public abstract double getTamaño();
    public abstract void setTamaño(double tamaño);
}
