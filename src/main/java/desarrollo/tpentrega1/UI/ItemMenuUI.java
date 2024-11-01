
package desarrollo.tpentrega1.UI;
import desarrollo.tpentrega1.controllers.ItemsMenuController;
import desarrollo.tpentrega1.entidades.Bebida;
import desarrollo.tpentrega1.entidades.ItemMenu;
import desarrollo.tpentrega1.entidades.Plato;
import java.awt.Color;
import java.util.List;
import javax.swing.*;

public class ItemMenuUI extends JPanel{
    private JTextField txtId,txtNombre,txtDescripcion,txtPrecio;
    private JTextField txtCalorias,txtPeso,txtGraduacionAlcoholica,txtTamaño;
    private JButton btnCrear,btnBuscar,btnEditar,btnEliminar;
    private JRadioButton rbtnPlato,rbtnBebida;
    private JTable tableBebida,tablePlato;
    private ItemsMenuController itemsMenuController;
    
    public ItemMenuUI(ItemsMenuController itemsMenuController){
        this.itemsMenuController=itemsMenuController;
        
        JLabel lblId= new JLabel("ID:");
        JLabel lblNombre= new JLabel("Nombre:");
        JLabel lblDescripcion= new JLabel("Descripcion:");
        JLabel lblPrecio= new JLabel("Precio:");
        JLabel lblCategoria= new JLabel("Categoria:");
        
        txtId= new JTextField(20);
        txtNombre= new JTextField(20);
        txtDescripcion= new JTextField(20);
        txtPrecio= new JTextField(20);
        
        btnCrear= new JButton("Crear");
        btnBuscar= new JButton("Buscar");
        btnEditar= new JButton("Editar");
        btnEliminar= new JButton("Eliminar");
        
        tableBebida= new JTable();
        tablePlato= new JTable();
       actualizarTabla(tableBebida);
      actualizarTabla(tablePlato);
        
      JScrollPane scrollPaneBebida = new JScrollPane(tableBebida);
      JScrollPane scrollPanePlato = new JScrollPane(tablePlato);
      
      this.setBackground(Color.cyan.darker());
     
      GroupLayout layout= new GroupLayout(this);
      this.setLayout(layout);
      layout.setAutoCreateGaps(true);
      layout.setAutoCreateContainerGaps(true);
      
     // layout.setHorizontalGroup(layout.createSequentialGroup().addGroup())
    }
    
    
   private void actualizarTabla(JTable tabla) {
        List<ItemMenu> itemsMenu = itemsMenuController.obtenerListaItemsMenu();
        if(tabla.toString().equals("tableBebida")){
        String[] columnNamesBebida = {"ID", "Nombre", "Descripcion", "Precio",
            "Graduacion Alcoholica", "Tamaño"};
        
        Object[][] data = new Object[itemsMenu.size()][6];
        for (int j = 0; j < itemsMenu.size(); j++) {
            ItemMenu i = itemsMenu.get(j);
            if(i instanceof Bebida){
            data[j][0] = i.getId();
            data[j][1] = i.getNombre();
            data[j][2] = i.getDescripcion();
            data[j][3] = i.getPrecio();
            data[j][4] = ((Bebida)i).getGraduacionAlcoholica();
            data[j][5] = ((Bebida)i).getTamaño();}
        }
        tabla.setModel(new javax.swing.table.DefaultTableModel(data, columnNamesBebida));
        }
        else{String[] columnNamesPlato = {"ID", "Nombre", "Descripcion", "Precio",
            "Calorias", "Apto Celiacos","Apto Veganos","Peso"};
        
        Object[][] data = new Object[itemsMenu.size()][8];
        for (int j = 0; j < itemsMenu.size(); j++) {
            ItemMenu i = itemsMenu.get(j);
            data[j][0] = i.getId();
            data[j][1] = i.getNombre();
            data[j][2] = i.getDescripcion();
            data[j][3] = i.getPrecio();
            data[j][4] = ((Plato)i).getCalorias();
            data[j][5] = ((Plato)i).aptoCeliaco();
            data[j][6] = ((Plato)i).aptoVegano();
            data[j][7] = ((Plato)i).peso();
        }
        tabla.setModel(new javax.swing.table.DefaultTableModel(data, columnNamesPlato));}
        
        
    }
}
