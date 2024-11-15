package desarrollo.tpentrega1.dao;


public interface ItemsPedidoDao {

    public void buscarPorNombre(String nombre);
    public void buscarDescripcion(String descripcion);
    public void buscarPrecioEntre(int precioMin, int precioMax);
    public void buscarPrecio(int precio);
    public void buscarCategoria(String categoria);
    
        public void buscarBebidas();
    public void buscarPlatos();

    // plato
    public void buscarComidaPeso(double peso);
    public void buscarCeliacos();
    public void buscarNoCeliacos();
    public void buscarVeganos();
    public void buscarNoVeganos();
    public void buscarComidaCalorias(int calorias);

    // bebida
    public void buscarBebidaTamaño(double tamaño);
    public void buscarBebidaGraduacion(double graduacion);

    
}