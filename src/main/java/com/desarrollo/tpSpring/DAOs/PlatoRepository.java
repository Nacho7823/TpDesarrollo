
package com.desarrollo.tpSpring.DAOs;

import com.desarrollo.tpSpring.entities.Plato;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatoRepository extends JpaRepository<Plato, Long>{
    public List<Plato> findByPeso(double peso);
  /*  public List<Plato> findByAptoCeliaco();
    public List<Plato> findByAptoCeliacoFalse();
    public List<Plato> findByAptoVegano();
    public List<Plato> findByAptoVeganoFalse();*/
    public List<Plato> findByCalorias(int calorias);

}
