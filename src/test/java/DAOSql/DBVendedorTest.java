package DAOSql;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import desarrollo.tpentrega1.dao.sql.VendedorDAOSql;
import desarrollo.tpentrega1.entidades.Vendedor;
import java.util.List;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


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
//        List<Integer> ids = new ArrayList();
//        for(Vendedor v : vendedorDAOSql.obtenerVendedores()){
//            ids.add(v.getId());
//            assertFalse(v.getId()==null);
//        }
//        for(Vendedor v : vendedorDAOSql.obtenerVendedores()){
//            assertTrue(ids.remove(v.getId()));
//            assertFalse(ids.contains(v.getId()));
//        }
    }
}
