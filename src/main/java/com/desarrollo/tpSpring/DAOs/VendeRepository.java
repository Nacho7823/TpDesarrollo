
package com.desarrollo.tpSpring.DAOs;

import com.desarrollo.tpSpring.entities.Vende;
import com.desarrollo.tpSpring.entities.VendeID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendeRepository extends JpaRepository<Vende, VendeID> {
    
}
