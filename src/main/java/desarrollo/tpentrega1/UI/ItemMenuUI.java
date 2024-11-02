package desarrollo.tpentrega1.UI;

import desarrollo.tpentrega1.controllers.ItemsMenuController;
import desarrollo.tpentrega1.entidades.Bebida;
import desarrollo.tpentrega1.entidades.ItemMenu;
import desarrollo.tpentrega1.entidades.Plato;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        
        //para comida
        JLabel calorias= new JLabel("Calorias:");
        JLabel peso= new JLabel("Peso:");
        JLabel aptoCeliacosLabel= new JLabel("Apto Celiacos:");
        JLabel aptoVeganosLabel= new JLabel("Apto Veganos:");
        //para bebida
        JLabel graduacion= new JLabel("Graduacion Alcoholica:");
        JLabel tamaño= new JLabel("Tamaño:");
        
        txtId= new JTextField(20);
        txtNombre= new JTextField(20);
        txtDescripcion= new JTextField(20);
        txtPrecio= new JTextField(20);
        
       //para comida
        JTextField txtCalorias= new JTextField(3);
        JTextField txtPeso= new JTextField(3);
        //para bebida
        JTextField txtGraduacion= new JTextField(3);
        JTextField txtTamaño= new JTextField(3);
        
        //para comida
        JCheckBox ApCeCheckBox= new JCheckBox();
        JCheckBox ApVeCheckBox= new JCheckBox();
        
        
        btnCrear= new JButton("Crear");
        btnBuscar= new JButton("Buscar");
        btnEditar= new JButton("Editar");
        btnEliminar= new JButton("Eliminar");
        rbtnBebida= new JRadioButton("Bebida");
        rbtnPlato= new JRadioButton("Plato");
        ButtonGroup categorias= new ButtonGroup();
        categorias.add(rbtnBebida);
        categorias.add(rbtnPlato);
        
        tableBebida= new JTable();
        tableBebida.setName("tableBebida");
        tablePlato= new JTable();
       actualizarTabla(tableBebida,null);
       actualizarTabla(tablePlato,null);
        
      JScrollPane scrollPaneBebida = new JScrollPane(tableBebida);
      JScrollPane scrollPanePlato = new JScrollPane(tablePlato);
      
      this.setBackground(new Color(130, 217, 217));
     
      GroupLayout layout= new GroupLayout(this);
      this.setLayout(layout);
      layout.setAutoCreateGaps(true);
      layout.setAutoCreateContainerGaps(true);
      
layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(lblId)
                .addComponent(lblNombre)
                .addComponent(lblDescripcion)
                .addComponent(lblPrecio)
                .addComponent(lblCategoria))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(txtId)
                .addComponent(txtNombre)
                .addComponent(txtDescripcion)
                .addComponent(txtPrecio)
                .addGroup(layout.createSequentialGroup().addComponent(rbtnBebida).addComponent(rbtnPlato))
                .addGroup(layout.createSequentialGroup()
                    .addComponent(btnCrear)
                    .addComponent(btnBuscar)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar))))
        .addComponent(scrollPaneBebida)
        .addComponent(scrollPanePlato)
);

layout.setVerticalGroup(
    layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(lblId)
            .addComponent(txtId))
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(lblNombre)
            .addComponent(txtNombre))
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(lblDescripcion)
            .addComponent(txtDescripcion))
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(lblPrecio)
            .addComponent(txtPrecio))
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(lblCategoria)
            .addComponent(rbtnBebida)
            .addComponent(rbtnPlato))
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(btnCrear)
            .addComponent(btnBuscar)
            .addComponent(btnEditar)
            .addComponent(btnEliminar))
        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED) // Espacio antes de las tablas
        .addComponent(scrollPaneBebida)
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED) // Espacio entre tablas
        .addComponent(scrollPanePlato)
);


        configurarAcciones();
    }
   /* private void DisEnablePlatoPanel(boolean b){
        CaloriasField.setEnabled(b);
        PesoField.setEnabled(b);
        ApVeCheckBox.setEnabled(b);
        ApCeCheckBox.setEnabled(b);
    }
    private void DisEnableBebidaPanel(boolean b){
        GradAlcField.setEnabled(b);
        TamField.setEnabled(b);
    }*/
private void configurarAcciones() {
        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id=txtId.getText();
                String nombre = txtNombre.getText();
                String descripcion = txtDescripcion.getText();
                String precio = txtPrecio.getText();
                
                
                txtId.setText("");
                txtNombre.setText("");
                txtDescripcion.setText("");
                txtPrecio.setText("");
                
            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = txtId.getText();
                ItemMenu itemMenu = itemsMenuController.buscarItemsMenu(id);
                if (itemMenu != null) {
                    ItemMenu item=itemsMenuController.buscarItemsMenu(id);
                if(item instanceof Bebida){ actualizarTabla(tableBebida,item); actualizarTabla(tablePlato,null);}
                else{actualizarTabla(tableBebida,null); actualizarTabla(tablePlato,item);}
                } else {
                    JOptionPane.showMessageDialog(null, "Item no encontrado.");
                    actualizarTabla(tablePlato,null);
                    actualizarTabla(tableBebida,null);
                }
                txtId.setText("");
                txtNombre.setText("");
                txtDescripcion.setText("");
                txtPrecio.setText("");
            }
        });

        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = txtId.getText();
                String nombre = txtNombre.getText();
                String descripcion = txtDescripcion.getText();
                String precio = txtPrecio.getText();

                ItemMenu item=itemsMenuController.buscarItemsMenu(id);
                if(item instanceof Bebida){ actualizarTabla(tableBebida,item); actualizarTabla(tablePlato,null);}
                else{actualizarTabla(tableBebida,null); actualizarTabla(tablePlato,item);}
                txtId.setText("");
                txtNombre.setText("");
                txtDescripcion.setText("");
                txtPrecio.setText("");
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = txtId.getText();
                ItemMenu item=itemsMenuController.buscarItemsMenu(id);
                if(item instanceof Bebida){actualizarTabla(tablePlato,null); actualizarTabla(tableBebida,item);}
                else{actualizarTabla(tableBebida,null); actualizarTabla(tablePlato,item);}
                itemsMenuController.eliminarItemsMenu(id);
            txtId.setText("");
                txtNombre.setText("");
                txtDescripcion.setText("");
                txtPrecio.setText("");
            }
           
        });
    }
    
    
   private void actualizarTabla(JTable tabla,ItemMenu item) {
        if(item==null){
         if("tableBebida".equals(tabla.getName())){
             String[] columnNamesBebida = {"ID", "Nombre", "Descripcion", "Precio",
            "Graduacion Alcoholica", "Tamaño"};
       
            Object[][] data = new Object[1][6];
            data[0][0] = "";
            data[0][1] = "";
            data[0][2] = "";
            data[0][3] = "";
            data[0][4] = "";
            data[0][5] = "";
        tabla.setModel(new javax.swing.table.DefaultTableModel(data, columnNamesBebida));
         } 
         else{
             String[] columnNamesPlato = {"ID", "Nombre", "Descripcion", "Precio",
            "Calorias", "Apto Celiacos","Apto Veganos","Peso"};
        
        Object[][] data = new Object[1][8];
            data[0][0] = "";
            data[0][1] = "";
            data[0][2] = "";
            data[0][3] = "";
            data[0][4] = "";
            data[0][5] = "";
            data[0][6] = "";
            data[0][7] = "";
        
        tabla.setModel(new javax.swing.table.DefaultTableModel(data, columnNamesPlato));
         }
        }
        else if(item instanceof Bebida){
        String[] columnNamesBebida = {"ID", "Nombre", "Descripcion", "Precio",
            "Graduacion Alcoholica", "Tamaño"};
       
            Object[][] data = new Object[1][6];
            data[0][0] = item.getId();
            data[0][1] = item.getNombre();
            data[0][2] = item.getDescripcion();
            data[0][3] = item.getPrecio();
            data[0][4] = ((Bebida)item).getGraduacionAlcoholica();
            data[0][5] = ((Bebida)item).getTamaño();
        tabla.setModel(new javax.swing.table.DefaultTableModel(data, columnNamesBebida));
        }
        else{
        String[] columnNamesPlato = {"ID", "Nombre", "Descripcion", "Precio",
            "Calorias", "Apto Celiacos","Apto Veganos","Peso"};
        
        Object[][] data = new Object[1][8];
            data[0][0] = item.getId();
            data[0][1] = item.getNombre();
            data[0][2] = item.getDescripcion();
            data[0][3] = item.getPrecio();
            data[0][4] = ((Plato)item).getCalorias();
            data[0][5] = ((Plato)item).aptoCeliaco();
            data[0][6] = ((Plato)item).aptoVegano();
            data[0][7] = ((Plato)item).peso();
        
        tabla.setModel(new javax.swing.table.DefaultTableModel(data, columnNamesPlato));}
        
        }}
