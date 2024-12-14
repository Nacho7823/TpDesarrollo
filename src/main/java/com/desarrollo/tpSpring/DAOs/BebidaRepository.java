
package com.desarrollo.tpSpring.DAOs;

import com.desarrollo.tpSpring.entities.Bebida;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BebidaRepository extends CrudRepository<Bebida, Long>{
      public List<Bebida> findByTamanio(double tamanio);
//      public List<Bebida> findByGraduacion_alcoholica(double graduacion_alcoholica);
}
