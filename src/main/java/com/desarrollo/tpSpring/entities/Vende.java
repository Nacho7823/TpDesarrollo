
package com.desarrollo.tpSpring.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name="vende")
@AllArgsConstructor
@NoArgsConstructor
@IdClass(VendeID.class)
public class Vende {
    @Id
    @OneToOne
    @JoinColumn(name = "id_item_menu", nullable = false)
    private ItemMenu itemMenu;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "id_vendedor", nullable = false)
    private Vendedor vendedor;
}
