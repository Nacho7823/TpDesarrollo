package desarrollo.tpentrega1.UI;

import desarrollo.tpentrega1.controllers.ItemsMenuController;
import desarrollo.tpentrega1.controllers.VendedorController;
import desarrollo.tpentrega1.entidades.Coordenada;
import desarrollo.tpentrega1.entidades.ItemMenu;
import desarrollo.tpentrega1.entidades.Vendedor;
import desarrollo.tpentrega1.exceptions.DAOException;
import desarrollo.tpentrega1.utilidades.GestionCeldas;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class VendedorUI extends javax.swing.JPanel {
        private final VendedorController vendedorController;
        private final ItemsMenuController itemMenuController;
    private final ImageIcon icon= new ImageIcon("pedidosya-logo.png");

    public VendedorUI(VendedorController vendedorController, ItemsMenuController itemMenuController) {
        this.vendedorController = vendedorController;
        this.itemMenuController = itemMenuController;
        initComponents();
        actualizarTabla();
        this.tableVendedores.setAutoResizeMode(5);
        this.tableVendedores.setRowHeight(40);
        JTableHeader tableHeader = tableVendedores.getTableHeader();
        tableHeader.setReorderingAllowed(false);
    }
    private void actualizarTabla() {
        String[] columnNames = {"ID", "Nombre", "Dirección", "Latitud", "Longitud", "Items", "", ""};
        List<Vendedor> vendedores = vendedorController.obtenerListaVendedores();
        Object[][] data = new Object[vendedores.size()][8];
        int i = 0;
        for(Vendedor v : vendedores){
            data[i][0] = v.getId();
            data[i][1] = v.getNombre();
            data[i][2] = v.getDireccion();
            data[i][3] = v.getCoordenada().getLat();
            data[i][4] = v.getCoordenada().getLng();
            data[i][5] = itemMenuController.obtenerItemsMenuDeVendedor(v.getId()).stream().map(ItemMenu::getNombre).collect(Collectors.joining(", "));
            data[i][6] = "Editar";
            data[i][7] = "Borrar";
            i++;
        }
        tableVendedores.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
        tableVendedores.getColumnModel().getColumn(0).setCellRenderer(new GestionCeldas("numerico"));
        tableVendedores.getColumnModel().getColumn(1).setCellRenderer(new GestionCeldas("texto"));
        tableVendedores.getColumnModel().getColumn(2).setCellRenderer(new GestionCeldas("texto"));
        tableVendedores.getColumnModel().getColumn(3).setCellRenderer(new GestionCeldas("numerico"));
        tableVendedores.getColumnModel().getColumn(4).setCellRenderer(new GestionCeldas("numerico"));
        tableVendedores.getColumnModel().getColumn(5).setCellRenderer(new GestionCeldas("texto"));
        tableVendedores.getColumnModel().getColumn(6).setCellRenderer(new GestionCeldas("icono"));
        tableVendedores.getColumnModel().getColumn(7).setCellRenderer(new GestionCeldas("icono"));
        tableVendedores.getColumnModel().getColumn(6).setPreferredWidth(10);
        tableVendedores.getColumnModel().getColumn(7).setPreferredWidth(10);
    }
    
    private void setTablaItemsEditarVendedor(Vendedor vendedor) throws DAOException{
        String[] columnNames = {"ID", "Nombre", "Categoría", "Precio"};
        List<ItemMenu> items = vendedorController.obtenerItemsDeVendedor(vendedor);
        Object[][] data = new Object[items.size()][4];
        int i = 0;
        for(ItemMenu item : items){
            data[i][0] = item.getId();
            data[i][1] = item.getNombre();
            data[i][2] = item.getCategoria();
            data[i][3] = item.getPrecio();
            i++;
        }
        tablaItemsCrear1.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    }
    void update() {}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        crearFrame = new javax.swing.JFrame();
        nombreField = new javax.swing.JTextField();
        direccionField = new javax.swing.JTextField();
        coordenada1Field = new javax.swing.JTextField();
        coordenada2Field = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cancelarBtn = new javax.swing.JButton();
        crearBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        editarFrame = new javax.swing.JFrame();
        nombreField1 = new javax.swing.JTextField();
        direccionField1 = new javax.swing.JTextField();
        coordenada1Field1 = new javax.swing.JTextField();
        coordenada2Field1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cancelarEditar = new javax.swing.JButton();
        editarBtn = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        ideditar = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaItemsCrear1 = new javax.swing.JTable();
        itemsDD1 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        agregarItemButton1 = new javax.swing.JButton();
        eliminarItemButton = new javax.swing.JButton();
        eliminarFrame = new javax.swing.JFrame();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        nombreField2 = new javax.swing.JTextField();
        cancelarEliminarBtn = new javax.swing.JButton();
        eliminarBtn = new javax.swing.JButton();
        ideliminar = new javax.swing.JTextField();
        direccionField2 = new javax.swing.JTextField();
        coordenada1Field2 = new javax.swing.JTextField();
        coordenada2Field2 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnRefrescar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableVendedores = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        btnCrearVendedor = new javax.swing.JButton();

        crearFrame.setIconImage(icon.getImage());
        crearFrame.setLocationByPlatform(true);
        crearFrame.setSize(new java.awt.Dimension(425, 200));

        jLabel3.setText("Nombre");

        cancelarBtn.setText("Cancelar");
        cancelarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBtnActionPerformed(evt);
            }
        });

        crearBtn.setText("Crear");
        crearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearBtnActionPerformed(evt);
            }
        });

        jLabel6.setText("Dirección");

        jLabel7.setText("Coordenadas");

        javax.swing.GroupLayout crearFrameLayout = new javax.swing.GroupLayout(crearFrame.getContentPane());
        crearFrame.getContentPane().setLayout(crearFrameLayout);
        crearFrameLayout.setHorizontalGroup(
            crearFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crearFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(crearFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(crearFrameLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(61, 61, 61)
                        .addComponent(nombreField, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(crearFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(crearFrameLayout.createSequentialGroup()
                            .addGroup(crearFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7))
                            .addGap(35, 35, 35)
                            .addGroup(crearFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(crearFrameLayout.createSequentialGroup()
                                    .addComponent(coordenada1Field, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(coordenada2Field, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(direccionField, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(crearFrameLayout.createSequentialGroup()
                            .addComponent(cancelarBtn)
                            .addGap(18, 18, 18)
                            .addComponent(crearBtn))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        crearFrameLayout.setVerticalGroup(
            crearFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crearFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(crearFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nombreField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(crearFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(direccionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(crearFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(coordenada1Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(coordenada2Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(crearFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(crearBtn)
                    .addComponent(cancelarBtn))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        editarFrame.setTitle("Editar vendedor");
        editarFrame.setIconImage(icon.getImage());
        editarFrame.setLocationByPlatform(true);
        editarFrame.setPreferredSize(new java.awt.Dimension(386, 570));
        editarFrame.setSize(new java.awt.Dimension(440, 480));

        jLabel8.setText("Nombre");

        cancelarEditar.setText("Cancelar");
        cancelarEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarEditarActionPerformed(evt);
            }
        });

        editarBtn.setText("Editar");
        editarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarBtnActionPerformed(evt);
            }
        });

        jLabel11.setText("Dirección");

        jLabel12.setText("Coordenadas");

        ideditar.setText("jTextField1");

        tablaItemsCrear1.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaItemsCrear1.setName(""); // NOI18N
        jScrollPane3.setViewportView(tablaItemsCrear1);

        jLabel9.setText("Items");

        agregarItemButton1.setText("Agregar");
        agregarItemButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarItemButton1ActionPerformed(evt);
            }
        });

        eliminarItemButton.setText("Eliminar");
        eliminarItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarItemButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout editarFrameLayout = new javax.swing.GroupLayout(editarFrame.getContentPane());
        editarFrame.getContentPane().setLayout(editarFrameLayout);
        editarFrameLayout.setHorizontalGroup(
            editarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editarFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(editarFrameLayout.createSequentialGroup()
                        .addComponent(ideditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(cancelarEditar)
                        .addGap(18, 18, 18)
                        .addComponent(editarBtn))
                    .addGroup(editarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(editarFrameLayout.createSequentialGroup()
                            .addGroup(editarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11)
                                .addComponent(jLabel12)
                                .addComponent(jLabel9)
                                .addComponent(jLabel8))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(editarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(editarFrameLayout.createSequentialGroup()
                                    .addGroup(editarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(itemsDD1, 0, 143, Short.MAX_VALUE)
                                        .addComponent(coordenada1Field1))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(editarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(editarFrameLayout.createSequentialGroup()
                                            .addComponent(eliminarItemButton)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(agregarItemButton1))
                                        .addComponent(coordenada2Field1))
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addComponent(direccionField1)
                                .addComponent(nombreField1, javax.swing.GroupLayout.Alignment.TRAILING)))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        editarFrameLayout.setVerticalGroup(
            editarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editarFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(nombreField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(direccionField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(coordenada1Field1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(coordenada2Field1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(itemsDD1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agregarItemButton1)
                    .addComponent(eliminarItemButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(editarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editarBtn)
                    .addComponent(cancelarEditar)
                    .addComponent(ideditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        eliminarFrame.setTitle("Eliminar vendedor");
        eliminarFrame.setIconImage(icon.getImage());
        eliminarFrame.setLocationByPlatform(true);
        eliminarFrame.setSize(new java.awt.Dimension(425, 200));

        jLabel16.setText("Dirección");

        jLabel17.setText("Coordenadas");

        cancelarEliminarBtn.setText("Cancelar");
        cancelarEliminarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarEliminarBtnActionPerformed(evt);
            }
        });

        eliminarBtn.setText("Eliminar");
        eliminarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarBtnActionPerformed(evt);
            }
        });

        ideliminar.setText("jTextField1");

        jLabel13.setText("Nombre");

        javax.swing.GroupLayout eliminarFrameLayout = new javax.swing.GroupLayout(eliminarFrame.getContentPane());
        eliminarFrame.getContentPane().setLayout(eliminarFrameLayout);
        eliminarFrameLayout.setHorizontalGroup(
            eliminarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eliminarFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(eliminarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(eliminarFrameLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(61, 61, 61)
                        .addComponent(nombreField2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(eliminarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(eliminarFrameLayout.createSequentialGroup()
                            .addGroup(eliminarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel16)
                                .addComponent(jLabel17))
                            .addGap(35, 35, 35)
                            .addGroup(eliminarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(eliminarFrameLayout.createSequentialGroup()
                                    .addComponent(coordenada1Field2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(coordenada2Field2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(direccionField2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(eliminarFrameLayout.createSequentialGroup()
                            .addComponent(ideliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cancelarEliminarBtn)
                            .addGap(18, 18, 18)
                            .addComponent(eliminarBtn))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        eliminarFrameLayout.setVerticalGroup(
            eliminarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eliminarFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(eliminarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(nombreField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(eliminarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(direccionField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(eliminarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(coordenada1Field2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(coordenada2Field2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(eliminarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eliminarBtn)
                    .addComponent(cancelarEliminarBtn)
                    .addComponent(ideliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        setBackground(new java.awt.Color(224, 240, 254));

        jLabel1.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ID Vendedor:");

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

        jScrollPane1.setBackground(new java.awt.Color(224, 240, 254));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 204, 153))); // NOI18N
        jScrollPane1.setFont(new java.awt.Font("Segoe UI Historic", 3, 12)); // NOI18N
        jScrollPane1.setRowHeaderView(null);

        tableVendedores.setBackground(new java.awt.Color(224, 240, 254));
        tableVendedores.setModel(new javax.swing.table.DefaultTableModel(
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
        tableVendedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableVendedoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableVendedores);

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

        btnCrearVendedor.setBackground(new java.awt.Color(100, 180, 252));
        btnCrearVendedor.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        btnCrearVendedor.setForeground(new java.awt.Color(224, 240, 254));
        btnCrearVendedor.setText("Crear Vendedor");
        btnCrearVendedor.setToolTipText("");
        btnCrearVendedor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(224, 240, 254), null, null));
        btnCrearVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearVendedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCrearVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtId)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrearVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarActionPerformed
        this.actualizarTabla();
    }//GEN-LAST:event_btnRefrescarActionPerformed

    private void btnCrearVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearVendedorActionPerformed
        crearFrame.setVisible(true);
    }//GEN-LAST:event_btnCrearVendedorActionPerformed

    private void cancelarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBtnActionPerformed
        nombreField.setText("");
        direccionField.setText("");
        coordenada1Field.setText("");
        coordenada2Field.setText("");
        crearFrame.setVisible(false);
    }//GEN-LAST:event_cancelarBtnActionPerformed

    private void crearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearBtnActionPerformed
        if(nombreField.getText().isEmpty() || direccionField.getText().isEmpty() || coordenada1Field.getText().isEmpty()
            || coordenada2Field.getText().isEmpty()){
            //mensaje de error por campos vacios
        } else {
            Coordenada coordenada = new Coordenada(Double.parseDouble(coordenada1Field.getText()), Double.parseDouble(coordenada2Field.getText()));
            vendedorController.crearNuevoVendedor(nombreField.getText(), direccionField.getText(), coordenada);
            nombreField.setText("");
            direccionField.setText("");
            coordenada1Field.setText("");
            coordenada2Field.setText("");
            actualizarTabla();
            crearFrame.setVisible(false);
            //mensaje de exito cliente creado
        }
    }//GEN-LAST:event_crearBtnActionPerformed


    private void cancelarEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarEditarActionPerformed
        nombreField1.setText("");
        direccionField1.setText("");
        coordenada1Field1.setText("");
        coordenada2Field1.setText("");
        editarFrame.setVisible(false);
    }//GEN-LAST:event_cancelarEditarActionPerformed

    private void cancelarBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBtn1ActionPerformed

    }//GEN-LAST:event_cancelarBtn1ActionPerformed


    private void cancelarEliminarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarEliminarBtnActionPerformed
        nombreField2.setText("");
        direccionField2.setText("");
        coordenada1Field2.setText("");
        coordenada2Field2.setText("");
        eliminarFrame.setVisible(false);
    }//GEN-LAST:event_cancelarEliminarBtnActionPerformed

    private void eliminarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarBtnActionPerformed
        vendedorController.eliminarVendedor(vendedorController.buscarVendedor(ideliminar.getText()));
        //mensaje de exito! mostrar tarjeta del cliente eliminado?
    }//GEN-LAST:event_eliminarBtnActionPerformed

    private void tableVendedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableVendedoresMouseClicked
        int fila = tableVendedores.rowAtPoint(evt.getPoint());
        int columna = tableVendedores.columnAtPoint(evt.getPoint());
        if(!tableVendedores.getValueAt(fila, 0).equals("") && !tableVendedores.getValueAt(fila, 1).equals("")
                 && !tableVendedores.getValueAt(fila, 2).equals("") && !tableVendedores.getValueAt(fila, 3).equals("")
                 && !tableVendedores.getValueAt(fila, 4).equals("") && !tableVendedores.getValueAt(fila, 6).equals("")
                 && !tableVendedores.getValueAt(fila, 7).equals("")){
            if(columna==6){
                nombreField1.setText(tableVendedores.getValueAt(fila, 1).toString());
                direccionField1.setText(tableVendedores.getValueAt(fila, 2).toString());
                coordenada1Field1.setText(tableVendedores.getValueAt(fila, 3).toString());
                coordenada2Field1.setText(tableVendedores.getValueAt(fila, 4).toString());
                try {
                    itemMenuController.obtenerItems().stream().forEach(item -> itemsDD1.addItem(item.getNombre()));
                    setTablaItemsEditarVendedor(vendedorController.buscarVendedor(tableVendedores.getValueAt(fila, 0).toString()));
                } catch (DAOException ex) {
                    Logger.getLogger(VendedorUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                editarFrame.setVisible(true);
                ideditar.setVisible(false);
                ideditar.setText(tableVendedores.getValueAt(fila, 0).toString());
            } else if(columna==7){
                nombreField2.setText(tableVendedores.getValueAt(fila, 1).toString());
                direccionField2.setText(tableVendedores.getValueAt(fila, 2).toString());
                coordenada1Field2.setText(tableVendedores.getValueAt(fila, 3).toString());
                coordenada2Field2.setText(tableVendedores.getValueAt(fila, 4).toString());
                nombreField2.setEnabled(false);
                direccionField2.setEnabled(false);
                coordenada1Field2.setEnabled(false);
                coordenada2Field2.setEnabled(false);
                eliminarFrame.setVisible(true);
                ideliminar.setVisible(false);
                ideliminar.setText(tableVendedores.getValueAt(fila, 0).toString());
            }
        }
    }//GEN-LAST:event_tableVendedoresMouseClicked

    private void editarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarBtnActionPerformed
          if(nombreField1.getText().isEmpty() || direccionField1.getText().isEmpty() || coordenada1Field1.getText().isEmpty() 
                || coordenada2Field1.getText().isEmpty()){
            //mensaje de error por campos vacios
        } else {
            Coordenada coordenada = new Coordenada(Double.parseDouble(coordenada1Field1.getText()), Double.parseDouble(coordenada2Field1.getText()));
            vendedorController.modificarVendedor(ideditar.getText(), nombreField1.getText(), direccionField1.getText(), coordenada);
            actualizarTabla();
            nombreField.setText("");
            direccionField.setText("");
            coordenada1Field.setText("");
            coordenada2Field.setText("");
            editarFrame.setVisible(false);
            //cartel de exito
        }
    }//GEN-LAST:event_editarBtnActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        Vendedor c = vendedorController.buscarVendedor(txtId.getText());
        String[] columnNames = {"ID", "Nombre", "Dirección", "Latitud", "Longitud", "Items", "", ""};
        Object[][] data = new Object[1][8];
        if(c!=null){
            data[0][0] = c.getId();
            data[0][1] = c.getNombre();
            data[0][2] = c.getDireccion();
            data[0][3] = c.getCoordenada().getLat();
            data[0][4] = c.getCoordenada().getLng();
            data[0][5] = itemMenuController.obtenerItemsMenuDeVendedor(c.getId()).stream().map(ItemMenu::getNombre).collect(Collectors.joining(", "));
            data[0][6] = "Editar";
            data[0][7] = "Borrar";
        } else if (c==null){
            data[0][0] = "";
            data[0][1] = "";
            data[0][2] = "";
            data[0][3] = "";
            data[0][4] = "";
            data[0][5] = "";
            data[0][6] = "";
            data[0][7] = "";
            //mensaje de error. no se encontró vendedir, setear los fields en 0 y tarjeta de los datos ingresados erroneos?
        }
        tableVendedores.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
        tableVendedores.getColumnModel().getColumn(0).setCellRenderer(new GestionCeldas("numerico"));
        tableVendedores.getColumnModel().getColumn(1).setCellRenderer(new GestionCeldas("texto"));
        tableVendedores.getColumnModel().getColumn(2).setCellRenderer(new GestionCeldas("texto"));
        tableVendedores.getColumnModel().getColumn(3).setCellRenderer(new GestionCeldas("numerico"));
        tableVendedores.getColumnModel().getColumn(4).setCellRenderer(new GestionCeldas("numerico"));
        tableVendedores.getColumnModel().getColumn(5).setCellRenderer(new GestionCeldas("texto"));
        tableVendedores.getColumnModel().getColumn(6).setCellRenderer(new GestionCeldas("icono"));
        tableVendedores.getColumnModel().getColumn(7).setCellRenderer(new GestionCeldas("icono"));
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void agregarItemButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarItemButton1ActionPerformed
        String itemSeleccionado = itemsDD1.getSelectedItem().toString();
        DefaultTableModel modelo = (DefaultTableModel) tablaItemsCrear1.getModel();
        boolean encontrado=false;
        int i=0;
        while(i<tablaItemsCrear1.getRowCount() && !encontrado){
            String item = (String) modelo.getValueAt(i, 1);
            if(item.equals(itemSeleccionado)){
                encontrado=true;
            }
            i++;
        }
        if(!encontrado){
            ItemMenu item = itemMenuController.buscarItemMenuPorNombre(itemSeleccionado);
            Object[] row = { item.getId(), itemSeleccionado, item.getCategoria(), item.getPrecio() };
            modelo.addRow(row);
        }
    }//GEN-LAST:event_agregarItemButton1ActionPerformed

    private void eliminarItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarItemButtonActionPerformed
        String itemSeleccionado = itemsDD1.getSelectedItem().toString();
        DefaultTableModel modelo = (DefaultTableModel) tablaItemsCrear1.getModel();
        boolean encontrado=false;
        int i=0;
        while(i<tablaItemsCrear1.getRowCount() && !encontrado){
            String item = (String) modelo.getValueAt(i, 1);
            if(item.equals(itemSeleccionado)){
                encontrado=true;
                modelo.removeRow(i);
            }
            i++;
        }

    }//GEN-LAST:event_eliminarItemButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarItemButton1;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCrearVendedor;
    private javax.swing.JButton btnRefrescar;
    private javax.swing.JButton cancelarBtn;
    private javax.swing.JButton cancelarEditar;
    private javax.swing.JButton cancelarEliminarBtn;
    private javax.swing.JTextField coordenada1Field;
    private javax.swing.JTextField coordenada1Field1;
    private javax.swing.JTextField coordenada1Field2;
    private javax.swing.JTextField coordenada2Field;
    private javax.swing.JTextField coordenada2Field1;
    private javax.swing.JTextField coordenada2Field2;
    private javax.swing.JButton crearBtn;
    private javax.swing.JFrame crearFrame;
    private javax.swing.JTextField direccionField;
    private javax.swing.JTextField direccionField1;
    private javax.swing.JTextField direccionField2;
    private javax.swing.JButton editarBtn;
    private javax.swing.JFrame editarFrame;
    private javax.swing.JButton eliminarBtn;
    private javax.swing.JFrame eliminarFrame;
    private javax.swing.JButton eliminarItemButton;
    private javax.swing.JTextField ideditar;
    private javax.swing.JTextField ideliminar;
    private javax.swing.JComboBox<String> itemsDD1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField nombreField;
    private javax.swing.JTextField nombreField1;
    private javax.swing.JTextField nombreField2;
    private javax.swing.JTable tablaItemsCrear1;
    private javax.swing.JTable tableVendedores;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables

    
}

