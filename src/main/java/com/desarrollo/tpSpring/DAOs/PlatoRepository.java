
package com.desarrollo.tpSpring.DAOs;

import com.desarrollo.tpSpring.entities.Plato;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatoRepository extends JpaRepository<Plato,String>{
    public List<Plato> buscarPorPeso(double peso);
    public List<Plato> buscarCeliacos();
    public List<Plato> buscarNoCeliacos();
    public List<Plato> buscarVeganos();
    public List<Plato> buscarNoVeganos();
    public List<Plato> buscarPorCalorias(int calorias);

}
