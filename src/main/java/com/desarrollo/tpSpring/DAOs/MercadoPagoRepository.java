
package com.desarrollo.tpSpring.DAOs;

import com.desarrollo.tpSpring.entities.MercadoPago;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MercadoPagoRepository extends CrudRepository<MercadoPago,String> {
    
}
