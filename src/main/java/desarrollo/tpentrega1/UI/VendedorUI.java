package desarrollo.tpentrega1.UI;

import desarrollo.tpentrega1.controllers.VendedorController;
import desarrollo.tpentrega1.entidades.Coordenada;
import desarrollo.tpentrega1.entidades.Vendedor;
import desarrollo.tpentrega1.utilidades.GestionCeldas;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;

public class VendedorUI extends javax.swing.JPanel {

    private VendedorController vendedorController = VendedorController.getInstance();

    public VendedorUI() {
        initComponents();
        actualizarTabla();
        this.tableVendedores.setAutoResizeMode(5);
        this.tableVendedores.setRowHeight(40);
        JTableHeader tableHeader = tableVendedores.getTableHeader();
        tableHeader.setReorderingAllowed(false);
    }

    private void actualizarTabla() {
        String[] columnNames = {"ID", "Nombre", "Dirección", "Latitud", "Longitud", "", ""};
        List<Vendedor> vendedores = vendedorController.obtenerListaVendedores();
        Object[][] data = new Object[vendedores.size()][7];
        int i = 0;
        for (Vendedor v : vendedores) {
            data[i][0] = v.getId();
            data[i][1] = v.getNombre();
            data[i][2] = v.getDireccion();
            data[i][3] = v.getCoordenada().getLat();
            data[i][4] = v.getCoordenada().getLng();
            data[i][5] = "Editar";
            data[i][6] = "Borrar";
            i++;
        }
        tableVendedores.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
        tableVendedores.getColumnModel().getColumn(0).setCellRenderer(new GestionCeldas("numerico"));
        tableVendedores.getColumnModel().getColumn(1).setCellRenderer(new GestionCeldas("texto"));
        tableVendedores.getColumnModel().getColumn(2).setCellRenderer(new GestionCeldas("texto"));
        tableVendedores.getColumnModel().getColumn(3).setCellRenderer(new GestionCeldas("numerico"));
        tableVendedores.getColumnModel().getColumn(4).setCellRenderer(new GestionCeldas("numerico"));
        tableVendedores.getColumnModel().getColumn(5).setCellRenderer(new GestionCeldas("icono"));
        tableVendedores.getColumnModel().getColumn(6).setCellRenderer(new GestionCeldas("icono"));
        tableVendedores.getColumnModel().getColumn(6).setPreferredWidth(10);
        tableVendedores.getColumnModel().getColumn(5).setPreferredWidth(10);
    }

    void update() {
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        crearFrame = new javax.swing.JFrame();
        nombreField = new javax.swing.JTextField();
        direccionField = new javax.swing.JTextField();
        coordenada1Field = new javax.swing.JTextField();
        coordenada2Field = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cancelarCrear = new javax.swing.JButton();
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
        eliminarFrame = new javax.swing.JFrame();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        nombreField2 = new javax.swing.JTextField();
        cancelarEliminar = new javax.swing.JButton();
        eliminarBtn = new javax.swing.JButton();
        ideliminar = new javax.swing.JTextField();
        direccionField2 = new javax.swing.JTextField();
        coordenada1Field2 = new javax.swing.JTextField();
        coordenada2Field2 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableVendedores = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnRefrescar = new javax.swing.JButton();
        btnCrearVendedor = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();

        crearFrame.setLocationByPlatform(true);
        crearFrame.setSize(new java.awt.Dimension(425, 200));

        jLabel3.setText("Nombre");

        cancelarCrear.setText("Cancelar");
        cancelarCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarCrearActionPerformed(evt);
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
                            .addComponent(cancelarCrear)
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
                    .addComponent(cancelarCrear))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        editarFrame.setLocationByPlatform(true);
        editarFrame.setSize(new java.awt.Dimension(425, 200));

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

        javax.swing.GroupLayout editarFrameLayout = new javax.swing.GroupLayout(editarFrame.getContentPane());
        editarFrame.getContentPane().setLayout(editarFrameLayout);
        editarFrameLayout.setHorizontalGroup(
            editarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editarFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editarFrameLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(61, 61, 61)
                        .addComponent(nombreField1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(editarFrameLayout.createSequentialGroup()
                        .addGroup(editarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(35, 35, 35)
                        .addGroup(editarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(editarFrameLayout.createSequentialGroup()
                                .addComponent(ideditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cancelarEditar)
                                .addGap(18, 18, 18)
                                .addComponent(editarBtn))
                            .addGroup(editarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(editarFrameLayout.createSequentialGroup()
                                    .addComponent(coordenada1Field1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(coordenada2Field1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(direccionField1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(56, Short.MAX_VALUE))
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
                .addGap(24, 24, 24)
                .addGroup(editarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editarBtn)
                    .addComponent(cancelarEditar)
                    .addComponent(ideditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        eliminarFrame.setLocationByPlatform(true);
        eliminarFrame.setSize(new java.awt.Dimension(425, 200));

        jLabel16.setText("Dirección");

        jLabel17.setText("Coordenadas");

        cancelarEliminar.setText("Cancelar");
        cancelarEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarEliminarActionPerformed(evt);
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
                            .addComponent(cancelarEliminar)
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
                    .addComponent(cancelarEliminar)
                    .addComponent(ideliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(224, 240, 254));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 204, 153))); // NOI18N
        jScrollPane1.setFont(new java.awt.Font("Segoe UI Historic", 3, 12)); // NOI18N
        jScrollPane1.setRowHeaderView(null);

        tableVendedores.setBackground(new java.awt.Color(255, 204, 153));
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnRefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCrearVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrearVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        jPanel3.setBackground(new java.awt.Color(130, 217, 217));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(224, 240, 254));

        jLabel1.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ID Vendedor:");

        jLabel2.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nombre Vendedor:");

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
                .addContainerGap(24, Short.MAX_VALUE))
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
                .addGap(0, 820, Short.MAX_VALUE)
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 927, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(475, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 939, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 605, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarActionPerformed
        this.actualizarTabla();
    }//GEN-LAST:event_btnRefrescarActionPerformed

    
    //-----------------------------------------------------------------------------------------
    // crear
    //-----------------------------------------------------------------------------------------
    
    
    private void btnCrearVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearVendedorActionPerformed
        crearFrame.setVisible(true);
    }//GEN-LAST:event_btnCrearVendedorActionPerformed

    private void cancelarCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarCrearActionPerformed
        nombreField.setText("");
        direccionField.setText("");
        coordenada1Field.setText("");
        coordenada2Field.setText("");
        crearFrame.setVisible(false);
    }//GEN-LAST:event_cancelarCrearActionPerformed

    private void crearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearBtnActionPerformed
        if (nombreField.getText().isEmpty() || direccionField.getText().isEmpty() || coordenada1Field.getText().isEmpty()
                || coordenada2Field.getText().isEmpty()) {
            //mensaje de error por campos vacios
            JOptionPane.showMessageDialog(null, "error en los campos", "Alerta", JOptionPane.WARNING_MESSAGE);
        } else {
            Coordenada coordenada = new Coordenada(Double.parseDouble(coordenada1Field.getText()), Double.parseDouble(coordenada2Field.getText()));
            Vendedor vend = new Vendedor(nombreField.getText(), direccionField.getText(), coordenada);
            vendedorController.crearNuevoVendedor(vend);
            nombreField.setText("");
            direccionField.setText("");
            coordenada1Field.setText("");
            coordenada2Field.setText("");
            actualizarTabla();
            crearFrame.setVisible(false);
            //mensaje de exito cliente creado
        }
    }//GEN-LAST:event_crearBtnActionPerformed

    //-----------------------------------------------------------------------------------------
    // editar
    //-----------------------------------------------------------------------------------------

    private void cancelarEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarEditarActionPerformed
        nombreField1.setText("");
        direccionField1.setText("");
        coordenada1Field1.setText("");
        coordenada2Field1.setText("");
        editarFrame.setVisible(false);
    }//GEN-LAST:event_cancelarEditarActionPerformed

    private void cancelarBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBtn1ActionPerformed
        nombreField.setText("");
        direccionField.setText("");
        coordenada1Field.setText("");
        coordenada2Field.setText("");
        editarFrame.setVisible(false);
    }//GEN-LAST:event_cancelarBtn1ActionPerformed

    

    private void cancelarEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarEliminarActionPerformed
        nombreField2.setText("");
        direccionField2.setText("");
        coordenada1Field2.setText("");
        coordenada2Field2.setText("");
        eliminarFrame.setVisible(false);
    }//GEN-LAST:event_cancelarEliminarActionPerformed

    //-----------------------------------------------------------------------------------------
    // eliminar
    //-----------------------------------------------------------------------------------------
    
    
    private void eliminarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarBtnActionPerformed
        vendedorController.eliminarVendedor(vendedorController.buscarVendedor(Integer.valueOf(ideliminar.getText())));
        
        actualizarTabla();
        nombreField2.setText("");
        direccionField2.setText("");
        coordenada1Field2.setText("");
        coordenada2Field2.setText("");
        eliminarFrame.setVisible(false);
    }//GEN-LAST:event_eliminarBtnActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        txtNombre.getText();
        Vendedor c = vendedorController.buscarVendedor(Integer.valueOf(txtId.getText()));
        String[] columnNames = {"ID", "Nombre", "Dirección", "Latitud", "Longitud", "", ""};
        Object[][] data = new Object[1][7];
        if (c != null) {
            data[0][0] = c.getId();
            data[0][1] = c.getNombre();
            data[0][2] = c.getDireccion();
            data[0][3] = c.getCoordenada().getLat();
            data[0][4] = c.getCoordenada().getLng();
            data[0][5] = "Editar";
            data[0][6] = "Borrar";
        } else if (c == null) {
            data[0][0] = "";
            data[0][1] = "";
            data[0][2] = "";
            data[0][3] = "";
            data[0][4] = "";
            data[0][5] = "";
            data[0][6] = "";
            //mensaje de error. no se encontró vendedir, setear los fields en 0 y tarjeta de los datos ingresados erroneos?
        }
        tableVendedores.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
        tableVendedores.getColumnModel().getColumn(0).setCellRenderer(new GestionCeldas("numerico"));
        tableVendedores.getColumnModel().getColumn(1).setCellRenderer(new GestionCeldas("texto"));
        tableVendedores.getColumnModel().getColumn(2).setCellRenderer(new GestionCeldas("texto"));
        tableVendedores.getColumnModel().getColumn(3).setCellRenderer(new GestionCeldas("numerico"));
        tableVendedores.getColumnModel().getColumn(4).setCellRenderer(new GestionCeldas("numerico"));
        tableVendedores.getColumnModel().getColumn(5).setCellRenderer(new GestionCeldas("icono"));
        tableVendedores.getColumnModel().getColumn(6).setCellRenderer(new GestionCeldas("icono"));
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tableVendedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableVendedoresMouseClicked
        int fila = tableVendedores.rowAtPoint(evt.getPoint());
        int columna = tableVendedores.columnAtPoint(evt.getPoint());
        if (!tableVendedores.getValueAt(fila, 0).equals("") && !tableVendedores.getValueAt(fila, 1).equals("")
                && !tableVendedores.getValueAt(fila, 2).equals("") && !tableVendedores.getValueAt(fila, 3).equals("")
                && !tableVendedores.getValueAt(fila, 4).equals("") && !tableVendedores.getValueAt(fila, 5).equals("")
                && !tableVendedores.getValueAt(fila, 6).equals("")) {
            if (columna == 5) {
                nombreField1.setText(tableVendedores.getValueAt(fila, 1).toString());
                direccionField1.setText(tableVendedores.getValueAt(fila, 2).toString());
                coordenada1Field1.setText(tableVendedores.getValueAt(fila, 3).toString());
                coordenada2Field1.setText(tableVendedores.getValueAt(fila, 4).toString());
                editarFrame.setVisible(true);
                ideditar.setVisible(false);
                ideditar.setText(tableVendedores.getValueAt(fila, 0).toString());
            } else if (columna == 6) {
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
        if (nombreField1.getText().isEmpty() || direccionField1.getText().isEmpty() || coordenada1Field1.getText().isEmpty()
                || coordenada2Field1.getText().isEmpty()) {
            //mensaje de error por campos vacios
            JOptionPane.showMessageDialog(null, "error en los campos", "Alerta", JOptionPane.WARNING_MESSAGE);
        } else {
            
            Vendedor vend = VendedorController.getInstance().buscarVendedor(Integer.valueOf(ideditar.getText()));
            vend.setNombre(nombreField1.getText());
            vend.setDireccion(direccionField1.getText());
            
            Coordenada coordenada = vend.getCoordenada();
            coordenada.setLat(Double.parseDouble(coordenada1Field1.getText()));
            coordenada.setLng(Double.parseDouble(coordenada2Field1.getText()));
            
            vend.setCoordenada(coordenada);
            
            vendedorController.modificarVendedor(vend);
            actualizarTabla();
            nombreField.setText("");
            direccionField.setText("");
            coordenada1Field.setText("");
            coordenada2Field.setText("");
            editarFrame.setVisible(false);
            //cartel de exito
        }
    }//GEN-LAST:event_editarBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCrearVendedor;
    private javax.swing.JButton btnRefrescar;
    private javax.swing.JButton cancelarCrear;
    private javax.swing.JButton cancelarEditar;
    private javax.swing.JButton cancelarEliminar;
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
    private javax.swing.JTextField ideditar;
    private javax.swing.JTextField ideliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombreField;
    private javax.swing.JTextField nombreField1;
    private javax.swing.JTextField nombreField2;
    private javax.swing.JTable tableVendedores;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

}
