
package com.desarrollo.tpSpring.DAOs;

import com.desarrollo.tpSpring.entities.MercadoPago;
import com.desarrollo.tpSpring.entities.Pago;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Integer> {    
   List<Pago> findByFecha(LocalDate fecha);
   List<Pago> findByMonto(double montoMinimo);

@Query("SELECT p FROM pago p WHERE TYPE(p) = com.desarrollo.tpSpring.entities.MercadoPago")
List<Pago> findAllMercadoPago();

@Query("SELECT p FROM pago p WHERE TYPE(p) = com.desarrollo.tpSpring.entities.Transferencia")
List<Pago> findAllTransferencia();

    @Query("SELECT m FROM mercado_pago m WHERE m.alias = :alias")
    List<MercadoPago> findMercadoPagoByAlias(@Param("alias") String alias);
}
