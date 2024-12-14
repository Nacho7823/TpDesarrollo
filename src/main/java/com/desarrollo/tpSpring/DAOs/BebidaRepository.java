
package com.desarrollo.tpSpring.DAOs;

import com.desarrollo.tpSpring.entities.Bebida;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BebidaRepository extends CrudRepository<Bebida,String>{
    public List<Bebida> findByTamaño(double tamaño);
    public List<Bebida> findByGraduacionAlcoholica(double graduacion);
}
