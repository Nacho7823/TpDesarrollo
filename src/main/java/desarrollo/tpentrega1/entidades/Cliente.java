
package desarrollo.tpentrega1.entidades;

import desarrollo.tpentrega1.interfaces.Observador;
import desarrollo.tpentrega1.enums.EstadoPedido;

public class Cliente implements Observador{
    private String id;
    private String nombre;          // no esta en el diagrama pero la etapa 1 lo pide
    private String cuit;
    private String email;
    private String direccion;
    private Coordenada coordenada;
    private Pago pago;

    public Cliente(String id, String nombre, String cuit, String email, String direccion, Coordenada coordenada) {
        this.id = id;
        this.nombre = nombre;
        this.cuit = cuit;
        this.email = email;
        this.direccion = direccion;
        this.coordenada = coordenada;
    }

    public Cliente() {
        
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
        
        // Si el pedido está en estado 'ENVIADO', generar un pago
        if (pedido.getEstado().equals(EstadoPedido.ENVIADO)) {
            generarPago(pedido);
        }
    }

    private void generarPago(Pedido pedido) {
        pago = new Pago(pedido.getTotal());
        System.out.println("Pago generado por el pedido " + pedido.getEstado());
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
    

