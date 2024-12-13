
package com.desarrollo.tpSpring.DAOs;

import com.desarrollo.tpSpring.entities.Vendedor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
    
   public List<Vendedor> obtenerVendedoresPorNombre(String nombre);
}
