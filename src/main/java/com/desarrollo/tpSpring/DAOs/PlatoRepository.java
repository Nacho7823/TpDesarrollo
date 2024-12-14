
package com.desarrollo.tpSpring.DAOs;

import com.desarrollo.tpSpring.entities.Plato;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatoRepository extends JpaRepository<Plato, Long>{
    public List<Plato> findByPeso(double peso);
   public List<Plato> findByAptoCeliaco(boolean apto);
    public List<Plato> findByAptoVegano(boolean apto);
    public List<Plato> findByCalorias(int calorias);

}
