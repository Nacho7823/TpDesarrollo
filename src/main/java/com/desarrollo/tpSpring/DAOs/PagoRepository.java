
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
public interface PagoRepository extends JpaRepository<Pago, String> {    
   List<Pago> BuscarPorFecha(LocalDate fecha);
   List<Pago> BuscarPorMonto(double montoMinimo);

@Query("SELECT p FROM Pago p WHERE TYPE(p) = MercadoPago")
List<Pago> ObtenerMercadoPago();

@Query("SELECT p FROM Pago p WHERE TYPE(p) = Transferencia")
List<Pago> ObtenerTransferencia();

    @Query("SELECT m FROM MercadoPago m WHERE m.alias = :alias")
    List<MercadoPago> findMercadoPagoByAlias(@Param("alias") String alias);
}
