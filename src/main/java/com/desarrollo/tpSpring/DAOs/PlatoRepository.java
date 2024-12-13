
package com.desarrollo.tpSpring.DAOs;

import com.desarrollo.tpSpring.entities.Plato;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatoRepository extends CrudRepository<Plato,String>{
    
}
