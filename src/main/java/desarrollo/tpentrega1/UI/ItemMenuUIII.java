package desarrollo.tpentrega1.UI;

import desarrollo.tpentrega1.controllers.ItemsMenuController;
import desarrollo.tpentrega1.controllers.VendedorController;
import desarrollo.tpentrega1.entidades.ItemMenu;
import desarrollo.tpentrega1.entidades.Vendedor;
import desarrollo.tpentrega1.utilidades.GestionCeldas;
import java.util.List;
import javax.swing.table.JTableHeader;

public class ItemMenuUIII extends javax.swing.JFrame {
    private final ItemsMenuController itemsMenuController;
    private final VendedorController vendedorController;
    public ItemMenuUIII(ItemsMenuController itemsMenuController, VendedorController vendedorController) {
        this.itemsMenuController = itemsMenuController;
        this.vendedorController = vendedorController;
        initComponents();
        actualizarTabla();
        this.tableItems.setAutoResizeMode(5);
        this.tableItems.setRowHeight(40);
        JTableHeader tableHeader = tableItems.getTableHeader();
        tableHeader.setReorderingAllowed(false);
    }
    private void actualizarTabla() {
        String[] columnNames = {"ID", "Nombre", "Dirección", "Latitud", "Longitud", "", ""};
        List<ItemMenu> items = null;
        for(Vendedor v: vendedorController.obtenerListaVendedores()){
            for(ItemMenu e: itemsMenuController.obtenerItemsMenuDeVendedor(v.getId())){
                items.add(e);
            }
        }
        
        Object[][] data = new Object[items.size()][10];
        int i = 0;
        for(ItemMenu v : items){
            data[i][0] = v.getId();
            data[i][1] = v.getNombre();
            data[i][2] = v.getDescripcion();
            data[i][3] = v.getPrecio();
            data[i][4] = v.getCategoria();
            data[i][5] = v.peso();
            data[i][6] = v.aptoVegano();
            i++;
        }
        tableItems.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
        tableItems.getColumnModel().getColumn(0).setCellRenderer(new GestionCeldas("numerico"));
        tableItems.getColumnModel().getColumn(1).setCellRenderer(new GestionCeldas("texto"));
        tableItems.getColumnModel().getColumn(2).setCellRenderer(new GestionCeldas("texto"));
        tableItems.getColumnModel().getColumn(3).setCellRenderer(new GestionCeldas("numerico"));
        tableItems.getColumnModel().getColumn(4).setCellRenderer(new GestionCeldas("numerico"));
        tableItems.getColumnModel().getColumn(5).setCellRenderer(new GestionCeldas("icono"));
        tableItems.getColumnModel().getColumn(6).setCellRenderer(new GestionCeldas("icono"));
        tableItems.getColumnModel().getColumn(6).setPreferredWidth(10);
        tableItems.getColumnModel().getColumn(5).setPreferredWidth(10);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        crearPlatoFrame = new javax.swing.JFrame();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        aptoCeliacoField = new javax.swing.JTextField();
        aptoVeganoField = new javax.swing.JTextField();
        pesoField = new javax.swing.JTextField();
        caloriasField = new javax.swing.JTextField();
        precioPField = new javax.swing.JTextField();
        descripcionPField = new javax.swing.JTextField();
        nombrePField = new javax.swing.JTextField();
        crearPlatoBtn = new javax.swing.JButton();
        cancelarCrearPlatoBtn = new javax.swing.JButton();
        crearBebidaFrame = new javax.swing.JFrame();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        nombreBField = new javax.swing.JTextField();
        descripcionBField = new javax.swing.JTextField();
        precioBField = new javax.swing.JTextField();
        tamañoField = new javax.swing.JTextField();
        gradAlcField = new javax.swing.JTextField();
        crearBebidaBtn = new javax.swing.JButton();
        cancelarCrearBebidaBtn = new javax.swing.JButton();
        editarPlatoFrame = new javax.swing.JFrame();
        jLabel25 = new javax.swing.JLabel();
        aptoCeliacoField1 = new javax.swing.JTextField();
        aptoVeganoField1 = new javax.swing.JTextField();
        pesoField1 = new javax.swing.JTextField();
        caloriasField1 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        precioPField1 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        descripcionPField1 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        nombrePField1 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        editarPlatoBtn = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        cancelarEditarPlatoBtn = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        editarBebidaFrame = new javax.swing.JFrame();
        gradAlcField1 = new javax.swing.JTextField();
        editarBebidaBtn = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        cancelarEditarBebidaBtn = new javax.swing.JButton();
        precioBField1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        descripcionBField1 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        nombreBField1 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        tamañoField1 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        eliminarPlatoFrame = new javax.swing.JFrame();
        jLabel32 = new javax.swing.JLabel();
        aptoCeliacoField2 = new javax.swing.JTextField();
        aptoVeganoField2 = new javax.swing.JTextField();
        pesoField2 = new javax.swing.JTextField();
        caloriasField2 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        precioPField2 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        descripcionPField2 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        nombrePField2 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        eliminarPlatoBtn = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        cancelarEliminarPlatoBtn = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        eliminarBebidaFrame = new javax.swing.JFrame();
        gradAlcField2 = new javax.swing.JTextField();
        eliminarBebidaBtn = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        cancelarEliminarBebidaBtn = new javax.swing.JButton();
        precioBField2 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        descripcionBField2 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        nombreBField2 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        tamañoField2 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableItems = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnRefrescar = new javax.swing.JButton();
        btnCrearBebida = new javax.swing.JButton();
        btnCrearPlato = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();

        crearPlatoFrame.setLocationByPlatform(true);
        crearPlatoFrame.setSize(new java.awt.Dimension(400, 500));

        jLabel3.setText("Nombre:");

        jLabel4.setText("Descripcion:");

        jLabel5.setText("Precio:");

        jLabel6.setText("Calorias:");

        jLabel7.setText("Peso:");

        jLabel8.setText("Apto Vegano:");

        jLabel9.setText("Apto Celiaco:");

        crearPlatoBtn.setText("Crear Plato");
        crearPlatoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearPlatoBtnActionPerformed(evt);
            }
        });

        cancelarCrearPlatoBtn.setText("Cancelar");
        cancelarCrearPlatoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarCrearPlatoBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout crearPlatoFrameLayout = new javax.swing.GroupLayout(crearPlatoFrame.getContentPane());
        crearPlatoFrame.getContentPane().setLayout(crearPlatoFrameLayout);
        crearPlatoFrameLayout.setHorizontalGroup(
            crearPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crearPlatoFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(crearPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(crearPlatoFrameLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(aptoCeliacoField))
                    .addGroup(crearPlatoFrameLayout.createSequentialGroup()
                        .addGroup(crearPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(crearPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aptoVeganoField)
                            .addComponent(pesoField)
                            .addComponent(caloriasField)
                            .addComponent(precioPField)
                            .addComponent(descripcionPField)
                            .addComponent(nombrePField)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, crearPlatoFrameLayout.createSequentialGroup()
                        .addGap(0, 206, Short.MAX_VALUE)
                        .addComponent(cancelarCrearPlatoBtn)
                        .addGap(18, 18, 18)
                        .addComponent(crearPlatoBtn)))
                .addContainerGap())
        );
        crearPlatoFrameLayout.setVerticalGroup(
            crearPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crearPlatoFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(crearPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nombrePField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(crearPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(descripcionPField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(crearPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(precioPField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(crearPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(caloriasField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(crearPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(pesoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(crearPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(aptoVeganoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(crearPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(aptoCeliacoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(crearPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(crearPlatoBtn)
                    .addComponent(cancelarCrearPlatoBtn))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jLabel10.setText("Nombre:");

        jLabel11.setText("Descripcion:");

        jLabel12.setText("Precio:");

        jLabel13.setText("Tamaño:");

        jLabel14.setText("Graduación Alcohólica");

        crearBebidaBtn.setText("Crear Bebida");
        crearBebidaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearBebidaBtnActionPerformed(evt);
            }
        });

        cancelarCrearBebidaBtn.setText("Cancelar");
        cancelarCrearBebidaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarCrearBebidaBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout crearBebidaFrameLayout = new javax.swing.GroupLayout(crearBebidaFrame.getContentPane());
        crearBebidaFrame.getContentPane().setLayout(crearBebidaFrameLayout);
        crearBebidaFrameLayout.setHorizontalGroup(
            crearBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crearBebidaFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(crearBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(crearBebidaFrameLayout.createSequentialGroup()
                        .addGroup(crearBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(crearBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(precioBField, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(descripcionBField)
                            .addComponent(nombreBField)
                            .addComponent(tamañoField)
                            .addComponent(gradAlcField)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, crearBebidaFrameLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cancelarCrearBebidaBtn)
                        .addGap(18, 18, 18)
                        .addComponent(crearBebidaBtn)))
                .addContainerGap())
        );
        crearBebidaFrameLayout.setVerticalGroup(
            crearBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crearBebidaFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(crearBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(nombreBField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(crearBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(descripcionBField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(crearBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(precioBField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(crearBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tamañoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(crearBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(gradAlcField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(crearBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(crearBebidaBtn)
                    .addComponent(cancelarCrearBebidaBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel25.setText("Apto Celiaco:");

        jLabel26.setText("Nombre:");

        jLabel27.setText("Descripcion:");

        jLabel28.setText("Precio:");

        jLabel29.setText("Calorias:");

        editarPlatoBtn.setText("Editar Plato");
        editarPlatoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarPlatoBtnActionPerformed(evt);
            }
        });

        jLabel30.setText("Peso:");

        cancelarEditarPlatoBtn.setText("Cancelar");
        cancelarEditarPlatoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarEditarPlatoBtnActionPerformed(evt);
            }
        });

        jLabel31.setText("Apto Vegano:");

        javax.swing.GroupLayout editarPlatoFrameLayout = new javax.swing.GroupLayout(editarPlatoFrame.getContentPane());
        editarPlatoFrame.getContentPane().setLayout(editarPlatoFrameLayout);
        editarPlatoFrameLayout.setHorizontalGroup(
            editarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editarPlatoFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editarPlatoFrameLayout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(18, 18, 18)
                        .addComponent(aptoCeliacoField1))
                    .addGroup(editarPlatoFrameLayout.createSequentialGroup()
                        .addGroup(editarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31)
                            .addComponent(jLabel26)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30))
                        .addGap(18, 18, 18)
                        .addGroup(editarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aptoVeganoField1)
                            .addComponent(pesoField1)
                            .addComponent(caloriasField1)
                            .addComponent(precioPField1)
                            .addComponent(descripcionPField1)
                            .addComponent(nombrePField1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editarPlatoFrameLayout.createSequentialGroup()
                        .addGap(0, 204, Short.MAX_VALUE)
                        .addComponent(cancelarEditarPlatoBtn)
                        .addGap(18, 18, 18)
                        .addComponent(editarPlatoBtn)))
                .addContainerGap())
        );
        editarPlatoFrameLayout.setVerticalGroup(
            editarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editarPlatoFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(nombrePField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(descripcionPField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(precioPField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(caloriasField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(pesoField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(aptoVeganoField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(aptoCeliacoField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editarPlatoBtn)
                    .addComponent(cancelarEditarPlatoBtn))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        editarBebidaBtn.setText("Editar Bebida");
        editarBebidaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarBebidaBtnActionPerformed(evt);
            }
        });

        jLabel15.setText("Nombre:");

        cancelarEditarBebidaBtn.setText("Cancelar");
        cancelarEditarBebidaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarEditarBebidaBtnActionPerformed(evt);
            }
        });

        jLabel16.setText("Descripcion:");

        jLabel17.setText("Precio:");

        jLabel18.setText("Tamaño:");

        jLabel19.setText("Graduación Alcohólica");

        javax.swing.GroupLayout editarBebidaFrameLayout = new javax.swing.GroupLayout(editarBebidaFrame.getContentPane());
        editarBebidaFrame.getContentPane().setLayout(editarBebidaFrameLayout);
        editarBebidaFrameLayout.setHorizontalGroup(
            editarBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editarBebidaFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editarBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editarBebidaFrameLayout.createSequentialGroup()
                        .addGroup(editarBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19))
                        .addGap(18, 18, 18)
                        .addGroup(editarBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(precioBField1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(descripcionBField1)
                            .addComponent(nombreBField1)
                            .addComponent(tamañoField1)
                            .addComponent(gradAlcField1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editarBebidaFrameLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cancelarEditarBebidaBtn)
                        .addGap(18, 18, 18)
                        .addComponent(editarBebidaBtn)))
                .addContainerGap())
        );
        editarBebidaFrameLayout.setVerticalGroup(
            editarBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editarBebidaFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editarBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(nombreBField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editarBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(descripcionBField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editarBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(precioBField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editarBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tamañoField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editarBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(gradAlcField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editarBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editarBebidaBtn)
                    .addComponent(cancelarEditarBebidaBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel32.setText("Apto Celiaco:");

        jLabel33.setText("Nombre:");

        jLabel34.setText("Descripcion:");

        jLabel35.setText("Precio:");

        jLabel36.setText("Calorias:");

        eliminarPlatoBtn.setText("Eliminar Plato");
        eliminarPlatoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarPlatoBtnActionPerformed(evt);
            }
        });

        jLabel37.setText("Peso:");

        cancelarEliminarPlatoBtn.setText("Cancelar");
        cancelarEliminarPlatoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarEliminarPlatoBtnActionPerformed(evt);
            }
        });

        jLabel38.setText("Apto Vegano:");

        javax.swing.GroupLayout eliminarPlatoFrameLayout = new javax.swing.GroupLayout(eliminarPlatoFrame.getContentPane());
        eliminarPlatoFrame.getContentPane().setLayout(eliminarPlatoFrameLayout);
        eliminarPlatoFrameLayout.setHorizontalGroup(
            eliminarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eliminarPlatoFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(eliminarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(eliminarPlatoFrameLayout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addGap(18, 18, 18)
                        .addComponent(aptoCeliacoField2))
                    .addGroup(eliminarPlatoFrameLayout.createSequentialGroup()
                        .addGroup(eliminarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel38)
                            .addComponent(jLabel33)
                            .addComponent(jLabel34)
                            .addComponent(jLabel35)
                            .addComponent(jLabel36)
                            .addComponent(jLabel37))
                        .addGap(18, 18, 18)
                        .addGroup(eliminarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aptoVeganoField2)
                            .addComponent(pesoField2)
                            .addComponent(caloriasField2)
                            .addComponent(precioPField2)
                            .addComponent(descripcionPField2)
                            .addComponent(nombrePField2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eliminarPlatoFrameLayout.createSequentialGroup()
                        .addGap(0, 191, Short.MAX_VALUE)
                        .addComponent(cancelarEliminarPlatoBtn)
                        .addGap(18, 18, 18)
                        .addComponent(eliminarPlatoBtn)))
                .addContainerGap())
        );
        eliminarPlatoFrameLayout.setVerticalGroup(
            eliminarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eliminarPlatoFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(eliminarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(nombrePField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(eliminarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(descripcionPField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(eliminarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(precioPField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(eliminarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(caloriasField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(eliminarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(pesoField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(eliminarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(aptoVeganoField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(eliminarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(aptoCeliacoField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(eliminarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eliminarPlatoBtn)
                    .addComponent(cancelarEliminarPlatoBtn))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        eliminarBebidaBtn.setText("Eliminar Bebida");
        eliminarBebidaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarBebidaBtnActionPerformed(evt);
            }
        });

        jLabel20.setText("Nombre:");

        cancelarEliminarBebidaBtn.setText("Cancelar");
        cancelarEliminarBebidaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarEliminarBebidaBtnActionPerformed(evt);
            }
        });

        jLabel21.setText("Descripcion:");

        jLabel22.setText("Precio:");

        jLabel23.setText("Tamaño:");

        jLabel24.setText("Graduación Alcohólica");

        javax.swing.GroupLayout eliminarBebidaFrameLayout = new javax.swing.GroupLayout(eliminarBebidaFrame.getContentPane());
        eliminarBebidaFrame.getContentPane().setLayout(eliminarBebidaFrameLayout);
        eliminarBebidaFrameLayout.setHorizontalGroup(
            eliminarBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eliminarBebidaFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(eliminarBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(eliminarBebidaFrameLayout.createSequentialGroup()
                        .addGroup(eliminarBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24))
                        .addGap(18, 18, 18)
                        .addGroup(eliminarBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(precioBField2, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(descripcionBField2)
                            .addComponent(nombreBField2)
                            .addComponent(tamañoField2)
                            .addComponent(gradAlcField2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eliminarBebidaFrameLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cancelarEliminarBebidaBtn)
                        .addGap(18, 18, 18)
                        .addComponent(eliminarBebidaBtn)))
                .addContainerGap())
        );
        eliminarBebidaFrameLayout.setVerticalGroup(
            eliminarBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eliminarBebidaFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(eliminarBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(nombreBField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(eliminarBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(descripcionBField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(eliminarBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(precioBField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(eliminarBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tamañoField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(eliminarBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(gradAlcField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(eliminarBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eliminarBebidaBtn)
                    .addComponent(cancelarEliminarBebidaBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(224, 240, 254));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 204, 153))); // NOI18N
        jScrollPane1.setFont(new java.awt.Font("Segoe UI Historic", 3, 12)); // NOI18N
        jScrollPane1.setRowHeaderView(null);

        tableItems.setBackground(new java.awt.Color(224, 240, 254));
        tableItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableItems.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableItemsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableItems);

        jPanel2.setBackground(new java.awt.Color(224, 240, 254));

        btnRefrescar.setBackground(new java.awt.Color(100, 180, 252));
        btnRefrescar.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        btnRefrescar.setForeground(new java.awt.Color(224, 240, 254));
        btnRefrescar.setText("Refrescar");
        btnRefrescar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(224, 240, 254), null, null));
        btnRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarActionPerformed(evt);
            }
        });

        btnCrearBebida.setBackground(new java.awt.Color(100, 180, 252));
        btnCrearBebida.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        btnCrearBebida.setForeground(new java.awt.Color(224, 240, 254));
        btnCrearBebida.setText("Crear Bebida");
        btnCrearBebida.setToolTipText("");
        btnCrearBebida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(224, 240, 254), null, null));
        btnCrearBebida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearBebidaActionPerformed(evt);
            }
        });

        btnCrearPlato.setBackground(new java.awt.Color(100, 180, 252));
        btnCrearPlato.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        btnCrearPlato.setForeground(new java.awt.Color(224, 240, 254));
        btnCrearPlato.setText("Crear Plato");
        btnCrearPlato.setToolTipText("");
        btnCrearPlato.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(224, 240, 254), null, null));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnRefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCrearPlato, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCrearBebida, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrearBebida, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrearPlato, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(224, 240, 254));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(224, 240, 254));

        jLabel1.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ID Item:");

        jLabel2.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nombre Item:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                    .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(224, 240, 254));

        btnBuscar.setBackground(new java.awt.Color(100, 180, 255));
        btnBuscar.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(224, 240, 254));
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(224, 240, 254), new java.awt.Color(224, 240, 254), null, null));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 124, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                    .addContainerGap(37, Short.MAX_VALUE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(42, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 827, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(95, 95, 95)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(460, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 408, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableItemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableItemsMouseClicked

    }//GEN-LAST:event_tableItemsMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCrearBebidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearBebidaActionPerformed

    }//GEN-LAST:event_btnCrearBebidaActionPerformed

    private void btnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarActionPerformed

    }//GEN-LAST:event_btnRefrescarActionPerformed

    private void crearPlatoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearPlatoBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_crearPlatoBtnActionPerformed

    private void cancelarCrearPlatoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarCrearPlatoBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelarCrearPlatoBtnActionPerformed

    private void crearBebidaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearBebidaBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_crearBebidaBtnActionPerformed

    private void cancelarCrearBebidaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarCrearBebidaBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelarCrearBebidaBtnActionPerformed

    private void editarPlatoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarPlatoBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editarPlatoBtnActionPerformed

    private void cancelarEditarPlatoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarEditarPlatoBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelarEditarPlatoBtnActionPerformed

    private void editarBebidaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarBebidaBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editarBebidaBtnActionPerformed

    private void cancelarEditarBebidaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarEditarBebidaBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelarEditarBebidaBtnActionPerformed

    private void eliminarPlatoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarPlatoBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eliminarPlatoBtnActionPerformed

    private void cancelarEliminarPlatoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarEliminarPlatoBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelarEliminarPlatoBtnActionPerformed

    private void eliminarBebidaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarBebidaBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eliminarBebidaBtnActionPerformed

    private void cancelarEliminarBebidaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarEliminarBebidaBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelarEliminarBebidaBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aptoCeliacoField;
    private javax.swing.JTextField aptoCeliacoField1;
    private javax.swing.JTextField aptoCeliacoField2;
    private javax.swing.JTextField aptoVeganoField;
    private javax.swing.JTextField aptoVeganoField1;
    private javax.swing.JTextField aptoVeganoField2;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCrearBebida;
    private javax.swing.JButton btnCrearPlato;
    private javax.swing.JButton btnRefrescar;
    private javax.swing.JTextField caloriasField;
    private javax.swing.JTextField caloriasField1;
    private javax.swing.JTextField caloriasField2;
    private javax.swing.JButton cancelarCrearBebidaBtn;
    private javax.swing.JButton cancelarCrearPlatoBtn;
    private javax.swing.JButton cancelarEditarBebidaBtn;
    private javax.swing.JButton cancelarEditarPlatoBtn;
    private javax.swing.JButton cancelarEliminarBebidaBtn;
    private javax.swing.JButton cancelarEliminarPlatoBtn;
    private javax.swing.JButton crearBebidaBtn;
    private javax.swing.JFrame crearBebidaFrame;
    private javax.swing.JButton crearPlatoBtn;
    private javax.swing.JFrame crearPlatoFrame;
    private javax.swing.JTextField descripcionBField;
    private javax.swing.JTextField descripcionBField1;
    private javax.swing.JTextField descripcionBField2;
    private javax.swing.JTextField descripcionPField;
    private javax.swing.JTextField descripcionPField1;
    private javax.swing.JTextField descripcionPField2;
    private javax.swing.JButton editarBebidaBtn;
    private javax.swing.JFrame editarBebidaFrame;
    private javax.swing.JButton editarPlatoBtn;
    private javax.swing.JFrame editarPlatoFrame;
    private javax.swing.JButton eliminarBebidaBtn;
    private javax.swing.JFrame eliminarBebidaFrame;
    private javax.swing.JButton eliminarPlatoBtn;
    private javax.swing.JFrame eliminarPlatoFrame;
    private javax.swing.JTextField gradAlcField;
    private javax.swing.JTextField gradAlcField1;
    private javax.swing.JTextField gradAlcField2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombreBField;
    private javax.swing.JTextField nombreBField1;
    private javax.swing.JTextField nombreBField2;
    private javax.swing.JTextField nombrePField;
    private javax.swing.JTextField nombrePField1;
    private javax.swing.JTextField nombrePField2;
    private javax.swing.JTextField pesoField;
    private javax.swing.JTextField pesoField1;
    private javax.swing.JTextField pesoField2;
    private javax.swing.JTextField precioBField;
    private javax.swing.JTextField precioBField1;
    private javax.swing.JTextField precioBField2;
    private javax.swing.JTextField precioPField;
    private javax.swing.JTextField precioPField1;
    private javax.swing.JTextField precioPField2;
    private javax.swing.JTable tableItems;
    private javax.swing.JTextField tamañoField;
    private javax.swing.JTextField tamañoField1;
    private javax.swing.JTextField tamañoField2;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
