
package com.desarrollo.tpSpring.entities;

import jakarta.persistence.Entity;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendeID implements Serializable {
    private int itemMenu;
    private int vendedor;
}
