
package desarrollo.tpentrega1.entidades;

import desarrollo.tpentrega1.interfaces.Observador;

public class Cliente implements Observador{
    private int id;
    private String nombre;
    private String cuit;
    private String email;
    private String direccion;
    private Coordenada coordenada;

    public Cliente(int id, String nombre, String cuit, String email, String direccion, Coordenada coordenada) {
        this.id = id;
        this.nombre = nombre;
        this.cuit = cuit;
        this.email = email;
        this.direccion = direccion;
        this.coordenada = coordenada;
    }
        public Cliente( String nombre, String cuit, String email, String direccion, Coordenada coordenada) {
        this.id = -1;
        this.nombre = nombre;
        this.cuit = cuit;
        this.email = email;
        this.direccion = direccion;
        this.coordenada = coordenada;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    public void setCoordenadas(Coordenada coordenada) {
        this.coordenada = coordenada;
    }
    
    // funcs

    @Override
    public void actualizar(Pedido pedido) {
        System.out.println("Cliente " + nombre + " ha sido notificado del cambio de estado del pedido " 
                            + pedido.getEstado());
    }



    @Override
    public String toString() {
        return "Cliente{" + 
        "id=" + id + 
        ", nombre=" + nombre + 
        ", cuit=" + cuit + 
        ", email=" + email + 
        ", direccion=" + direccion + 
        ", coordenada=" + coordenada + '}';
    }
    
    
    
}
    

