
package desarrollo.tpentrega1.entidades;

public abstract class ItemMenu {
    
    private String id;
    private String nombre;
    private String descripcion;
    private double precio;
    private String categoria;
    private Vendedor vendedor;

    public ItemMenu() {}

    public ItemMenu(String id, String nombre, String descripcion, double precio, String categoria, Vendedor vendedor) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        this.vendedor = vendedor;
        if(vendedor != null)
            vendedor.addItemMenu(this);
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

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
        if(vendedor != null)
            vendedor.addItemMenu(this);
    }
    
    

    public abstract boolean esComida();
    public abstract boolean esBebida();
    public abstract boolean aptoVegano();
    public abstract double peso();
    
}
