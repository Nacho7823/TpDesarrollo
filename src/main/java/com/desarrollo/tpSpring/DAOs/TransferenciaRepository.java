
package com.desarrollo.tpSpring.DAOs;

import com.desarrollo.tpSpring.entities.Transferencia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferenciaRepository extends CrudRepository<Transferencia,String> {
    
    
    
}
