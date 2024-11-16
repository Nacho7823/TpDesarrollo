package DAOSql;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import desarrollo.tpentrega1.dao.sql.VendedorDAOSql;
import desarrollo.tpentrega1.entidades.Vendedor;
import java.util.List;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class DBVendedorTest {
    VendedorDAOSql vendedorDAOSql = VendedorDAOSql.getInstance();
    
    @BeforeEach
    void setUp() throws Exception {
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void testID() throws Exception {
        List<String> ids = new ArrayList();
        for(Vendedor v : vendedorDAOSql.obtenerVendedores()){
            ids.add(v.getId());
        }
        for(Vendedor v : vendedorDAOSql.obtenerVendedores()){
            assertFalse(ids.contains(v.getId()));
        }
    }
}
