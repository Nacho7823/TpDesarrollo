
package desarrollo.tpentrega1.dao;
import desarrollo.tpentrega1.entidades.Coordenada;
import desarrollo.tpentrega1.exceptions.DAOException;
import java.util.List;

public interface CoordenadaDAO {

    public void crearCoordenada(Coordenada coordenada) throws DAOException;

    public void actualizarCoordenada(Coordenada coordenada) throws DAOException;

    public void eliminarCoordenada(int id) throws DAOException;

    public Coordenada buscarCoordenada(int id) throws DAOException;
    
    public List<Coordenada> obtenerCoordenadas() throws DAOException;
}
