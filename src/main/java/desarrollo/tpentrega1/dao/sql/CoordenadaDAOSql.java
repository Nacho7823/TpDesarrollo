package desarrollo.tpentrega1.dao.sql;

import desarrollo.tpentrega1.dao.CoordenadaDAO;
import desarrollo.tpentrega1.entidades.Coordenada;
import desarrollo.tpentrega1.exceptions.DAOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoordenadaDAOSql extends DAO implements CoordenadaDAO {

    private static CoordenadaDAOSql instance;

    public static CoordenadaDAOSql getInstance() {
        if (instance == null) {
            instance = new CoordenadaDAOSql();
        }
        return instance;
    }

    @Override
    public void crearCoordenada(Coordenada coordenada) throws DAOException {
        try {

            String sql = "INSERT INTO coordenada (longitud, latitud) VALUES (?, ?)";
            int id = create(sql,
                    coordenada.getLng(),
                    coordenada.getLat()
                    );
            
            coordenada.setId_coordenada(id);
            
        } catch(SQLException e){
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public void actualizarCoordenada(Coordenada coordenada) throws DAOException {
        try {

            String sql = "UPDATE coordenada SET longitud = ?, latitud = ? WHERE id_coordenada = ?";

            update(sql,
                    coordenada.getLng(),
                    coordenada.getLat(),
                    coordenada.getId_coordenada()
            );

        } catch (SQLException ex) {
            throw new DAOException("no se pudo actualizar la coordenada: \n" + ex.getMessage());
        }
    }

    @Override
    public void eliminarCoordenada(int id) throws DAOException {
        try {
            
            String sql = "DELETE FROM coordenada WHERE id_coordenada = ?";
            delete(sql, id);
            
        } catch (SQLException e) {
            throw new DAOException("No se pudo eliminar la coordenada: \n" + e.getMessage());
        }
    }

    @Override
    public Coordenada buscarCoordenada(int id) throws DAOException {
        try {

            String sql = "SELECT * FROM coordenada WHERE id_coordenada = ?";
            search(sql, id);

            if (!resultado.next()) {
                throw new DAOException("coordenada not found");
            }
            return new Coordenada(id,
                        resultado.getDouble("latitud"),
                        resultado.getDouble("longitud")
            );
            
        } catch (SQLException e) {
            throw new DAOException("No se pudo buscar la coordenada: \n" + e.getMessage());
        }
    }

    @Override
    public List<Coordenada> obtenerCoordenadas() throws DAOException {
        String sql = "SELECT * FROM coordenada";
        List<Coordenada> listaCoordenadas = new ArrayList<>();

        try {

            search(sql);

            while (resultado.next()) {
                int idCoordenada = resultado.getInt("id_coordenada");
                double longitud = resultado.getDouble("longitud");
                double latitud = resultado.getDouble("latitud");

                Coordenada coord = new Coordenada(idCoordenada, latitud, longitud);

                listaCoordenadas.add(coord);
            }

        } catch (SQLException e) {
            throw new DAOException("No se pudo obtener las coordenadas: \n" + e.getMessage());
        }

        return listaCoordenadas;
    }

}
