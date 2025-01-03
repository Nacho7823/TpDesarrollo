package desarrollo.tpentrega1.UI;

import desarrollo.tpentrega1.utilidades.UsuarioTableModel;
import desarrollo.tpentrega1.controllers.ClienteController;
import desarrollo.tpentrega1.entidades.Cliente;
import desarrollo.tpentrega1.entidades.Coordenada;
import desarrollo.tpentrega1.utilidades.ButtonEditor;
import desarrollo.tpentrega1.utilidades.ButtonRenderer;
import desarrollo.tpentrega1.utilidades.GestionCeldas;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.table.JTableHeader;

public class ClienteUI extends javax.swing.JPanel {
    private final ClienteController clienteController;
    private final Alerta alerta = new Alerta();
    private final ImageIcon icon= new ImageIcon("pedidosya-logo.png");
   
    public ClienteUI(ClienteController clienteController) {
        this.clienteController = clienteController;
        initComponents();
        actualizarTabla();
        this.tableClientes.setAutoResizeMode(5);
        tableClientes.setRowHeight(40);
        JTableHeader tableHeader = tableClientes.getTableHeader();
        tableHeader.setReorderingAllowed(false);
    }
    private void actualizarTabla() {
        String[] columnNames = {"ID", "Nombre", "Cuit", "Email", "Dirección", "Latitud", "Longitud", "", ""};
        List<Cliente> clientes = clienteController.obtenerListaClientes();
        
        tableClientes.setModel(new UsuarioTableModel(clientes, columnNames));
        
        tableClientes.getColumnModel().getColumn(7).setCellRenderer(new ButtonRenderer("Editar"));
        tableClientes.getColumnModel().getColumn(8).setCellRenderer(new ButtonRenderer("Borrar"));

        // Editores para las columnas
        tableClientes.getColumnModel().getColumn(7).setCellEditor(new ButtonEditor("Editar"));
        tableClientes.getColumnModel().getColumn(8).setCellEditor(new ButtonEditor("Borrar")); 

        tableClientes.getColumnModel().getColumn(0).setCellRenderer(new GestionCeldas("numerico"));
        tableClientes.getColumnModel().getColumn(1).setCellRenderer(new GestionCeldas("texto"));
        tableClientes.getColumnModel().getColumn(2).setCellRenderer(new GestionCeldas("numerico"));
        tableClientes.getColumnModel().getColumn(3).setCellRenderer(new GestionCeldas("texto"));
        tableClientes.getColumnModel().getColumn(4).setCellRenderer(new GestionCeldas("texto"));
        tableClientes.getColumnModel().getColumn(5).setCellRenderer(new GestionCeldas("numerico"));
        tableClientes.getColumnModel().getColumn(6).setCellRenderer(new GestionCeldas("numerico"));
        tableClientes.getColumnModel().getColumn(7).setCellRenderer(new GestionCeldas("icono"));
        tableClientes.getColumnModel().getColumn(8).setCellRenderer(new GestionCeldas("icono"));
        tableClientes.getColumnModel().getColumn(7).setPreferredWidth(10);
        tableClientes.getColumnModel().getColumn(8).setPreferredWidth(10);
    }
    
    void update() {
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        crearFrame = new javax.swing.JFrame();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nombreField = new javax.swing.JTextField();
        cuitField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        direccionField = new javax.swing.JTextField();
        coordenada1Field = new javax.swing.JTextField();
        coordenada2Field = new javax.swing.JTextField();
        cancelarBtn = new javax.swing.JButton();
        crearBtn = new javax.swing.JButton();
        editarFrame = new javax.swing.JFrame();
        nombreField1 = new javax.swing.JTextField();
        cuitField1 = new javax.swing.JTextField();
        emailField1 = new javax.swing.JTextField();
        direccionField1 = new javax.swing.JTextField();
        coordenada1Field1 = new javax.swing.JTextField();
        coordenada2Field1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cancelarEditarBtn = new javax.swing.JButton();
        editarBtn = new javax.swing.JButton();
        ideditar = new javax.swing.JTextField();
        eliminarFrame = new javax.swing.JFrame();
        nombreField2 = new javax.swing.JTextField();
        cuitField2 = new javax.swing.JTextField();
        emailField2 = new javax.swing.JTextField();
        direccionField2 = new javax.swing.JTextField();
        coordenada1Field2 = new javax.swing.JTextField();
        coordenada2Field2 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cancelarEliminarBtn = new javax.swing.JButton();
        eliminarBtn = new javax.swing.JButton();
        ideliminar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableClientes = new javax.swing.JTable();
        panelSuperior = new javax.swing.JPanel();
        panelSuperiorIzquierdo = new javax.swing.JPanel();
        panelTextos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        panelSuperiorDerecho = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        btnRefrescar = new javax.swing.JButton();
        btnCrearCliente = new javax.swing.JButton();

        crearFrame.setTitle("Crear nuevo cliente");
        crearFrame.setIconImage(icon.getImage());
        crearFrame.setLocation(new java.awt.Point(10, 20));
        crearFrame.setLocationByPlatform(true);
        crearFrame.setSize(new java.awt.Dimension(450, 280));

        jLabel3.setText("Nombre");

        jLabel4.setText("Cuit");

        jLabel5.setText("Email");

        jLabel6.setText("Dirección");

        jLabel7.setText("Coordenadas");

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

        javax.swing.GroupLayout crearFrameLayout = new javax.swing.GroupLayout(crearFrame.getContentPane());
        crearFrame.getContentPane().setLayout(crearFrameLayout);
        crearFrameLayout.setHorizontalGroup(
            crearFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crearFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(crearFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(crearFrameLayout.createSequentialGroup()
                        .addGroup(crearFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, crearFrameLayout.createSequentialGroup()
                                .addGroup(crearFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addGap(35, 35, 35))
                            .addGroup(crearFrameLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(61, 61, 61)))
                        .addGroup(crearFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombreField, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cuitField, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(crearFrameLayout.createSequentialGroup()
                                .addComponent(coordenada1Field, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(coordenada2Field, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(direccionField, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(crearFrameLayout.createSequentialGroup()
                        .addComponent(cancelarBtn)
                        .addGap(18, 18, 18)
                        .addComponent(crearBtn)))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        crearFrameLayout.setVerticalGroup(
            crearFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crearFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(crearFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nombreField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(crearFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cuitField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(crearFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(crearFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(direccionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(crearFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(coordenada1Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(coordenada2Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(crearFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(crearBtn)
                    .addComponent(cancelarBtn))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        editarFrame.setTitle("Editar un cliente");
        editarFrame.setIconImage(icon.getImage());
        editarFrame.setLocationByPlatform(true);
        editarFrame.setSize(new java.awt.Dimension(450, 280));

        jLabel8.setText("Nombre");

        jLabel9.setText("Cuit");

        jLabel10.setText("Email");

        jLabel11.setText("Dirección");

        jLabel12.setText("Coordenadas");

        cancelarEditarBtn.setText("Cancelar");
        cancelarEditarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarEditarBtnActionPerformed(evt);
            }
        });

        editarBtn.setText("Editar");
        editarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarBtnActionPerformed(evt);
            }
        });

        ideditar.setText("jTextField1");

        javax.swing.GroupLayout editarFrameLayout = new javax.swing.GroupLayout(editarFrame.getContentPane());
        editarFrame.getContentPane().setLayout(editarFrameLayout);
        editarFrameLayout.setHorizontalGroup(
            editarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editarFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editarFrameLayout.createSequentialGroup()
                        .addGroup(editarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addGap(35, 35, 35))
                    .addGroup(editarFrameLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(61, 61, 61)))
                .addGroup(editarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(editarFrameLayout.createSequentialGroup()
                        .addComponent(ideditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelarEditarBtn)
                        .addGap(18, 18, 18)
                        .addComponent(editarBtn))
                    .addGroup(editarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(nombreField1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cuitField1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(emailField1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(editarFrameLayout.createSequentialGroup()
                            .addComponent(coordenada1Field1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(coordenada2Field1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(direccionField1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        editarFrameLayout.setVerticalGroup(
            editarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editarFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(nombreField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cuitField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(emailField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(direccionField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(coordenada1Field1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(coordenada2Field1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelarEditarBtn)
                    .addComponent(editarBtn)
                    .addComponent(ideditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        eliminarFrame.setTitle("Eliminar un cliente");
        eliminarFrame.setIconImage(icon.getImage());
        eliminarFrame.setLocationByPlatform(true);
        eliminarFrame.setSize(new java.awt.Dimension(450, 280));

        jLabel13.setText("Nombre");

        jLabel14.setText("Cuit");

        jLabel15.setText("Email");

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

        javax.swing.GroupLayout eliminarFrameLayout = new javax.swing.GroupLayout(eliminarFrame.getContentPane());
        eliminarFrame.getContentPane().setLayout(eliminarFrameLayout);
        eliminarFrameLayout.setHorizontalGroup(
            eliminarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eliminarFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(eliminarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(eliminarFrameLayout.createSequentialGroup()
                        .addGroup(eliminarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eliminarFrameLayout.createSequentialGroup()
                                .addGroup(eliminarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel14))
                                .addGap(35, 35, 35))
                            .addGroup(eliminarFrameLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(61, 61, 61)))
                        .addGroup(eliminarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombreField2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cuitField2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailField2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(eliminarBtn)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        eliminarFrameLayout.setVerticalGroup(
            eliminarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eliminarFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(eliminarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(nombreField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(eliminarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(cuitField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(eliminarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(emailField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(eliminarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(direccionField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(eliminarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(coordenada1Field2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(coordenada2Field2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(eliminarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eliminarBtn)
                    .addComponent(cancelarEliminarBtn)
                    .addComponent(ideliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        setBackground(new java.awt.Color(224, 240, 254));

        jScrollPane1.setBackground(new java.awt.Color(224, 240, 254));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 204, 153))); // NOI18N
        jScrollPane1.setFont(new java.awt.Font("Segoe UI Historic", 3, 12)); // NOI18N
        jScrollPane1.setRowHeaderView(null);

        tableClientes.setBackground(new java.awt.Color(224, 240, 254));
        tableClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        tableClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableClientes);

        panelSuperior.setBackground(new java.awt.Color(224, 240, 254));

        panelSuperiorIzquierdo.setBackground(new java.awt.Color(224, 240, 254));

        panelTextos.setBackground(new java.awt.Color(224, 240, 254));
        panelTextos.setPreferredSize(new java.awt.Dimension(870, 124));

        jLabel1.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ID Cliente:");

        javax.swing.GroupLayout panelTextosLayout = new javax.swing.GroupLayout(panelTextos);
        panelTextos.setLayout(panelTextosLayout);
        panelTextosLayout.setHorizontalGroup(
            panelTextosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTextosLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, 721, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelTextosLayout.setVerticalGroup(
            panelTextosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTextosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout panelSuperiorIzquierdoLayout = new javax.swing.GroupLayout(panelSuperiorIzquierdo);
        panelSuperiorIzquierdo.setLayout(panelSuperiorIzquierdoLayout);
        panelSuperiorIzquierdoLayout.setHorizontalGroup(
            panelSuperiorIzquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTextos, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
        );
        panelSuperiorIzquierdoLayout.setVerticalGroup(
            panelSuperiorIzquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorIzquierdoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTextos, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelSuperiorDerecho.setBackground(new java.awt.Color(224, 240, 254));

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

        javax.swing.GroupLayout panelSuperiorDerechoLayout = new javax.swing.GroupLayout(panelSuperiorDerecho);
        panelSuperiorDerecho.setLayout(panelSuperiorDerechoLayout);
        panelSuperiorDerechoLayout.setHorizontalGroup(
            panelSuperiorDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSuperiorDerechoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelSuperiorDerechoLayout.setVerticalGroup(
            panelSuperiorDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorDerechoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelSuperiorLayout = new javax.swing.GroupLayout(panelSuperior);
        panelSuperior.setLayout(panelSuperiorLayout);
        panelSuperiorLayout.setHorizontalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelSuperiorIzquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelSuperiorDerecho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelSuperiorLayout.setVerticalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSuperiorDerecho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelSuperiorIzquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnRefrescar.setBackground(new java.awt.Color(100, 180, 252));
        btnRefrescar.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        btnRefrescar.setForeground(new java.awt.Color(224, 240, 254));
        btnRefrescar.setText("Refrescar");
        btnRefrescar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarActionPerformed(evt);
            }
        });

        btnCrearCliente.setBackground(new java.awt.Color(100, 180, 252));
        btnCrearCliente.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        btnCrearCliente.setForeground(new java.awt.Color(224, 240, 254));
        btnCrearCliente.setText("Crear Cliente");
        btnCrearCliente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(224, 240, 254), null, null));
        btnCrearCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 984, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnRefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCrearCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrearCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(436, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarActionPerformed
        this.actualizarTabla();
    }//GEN-LAST:event_btnRefrescarActionPerformed

    private void btnCrearClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearClienteActionPerformed
        crearFrame.setVisible(true);
    }//GEN-LAST:event_btnCrearClienteActionPerformed

    private void crearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearBtnActionPerformed
        if(nombreField.getText().isEmpty() || cuitField.getText().isEmpty() || emailField.getText().isEmpty() 
                || direccionField.getText().isEmpty() || coordenada1Field.getText().isEmpty() 
                || coordenada2Field.getText().isEmpty()){
            alerta.setText("Ningun campo puede ser vacio");
            alerta.setVisible(true);
        } else {
            Coordenada coordenada = new Coordenada(Double.parseDouble(coordenada1Field.getText()), Double.parseDouble(coordenada2Field.getText()));
            try{
                clienteController.crearNuevoCliente(nombreField.getText(), cuitField.getText(), emailField.getText(), direccionField.getText(), coordenada);
                nombreField.setText("");
                cuitField.setText("");
                emailField.setText("");
                direccionField.setText("");
                coordenada1Field.setText("");
                coordenada2Field.setText("");  
                actualizarTabla();
                alerta.setText("El cliente fue creado exitosamente");
                alerta.setVisible(true);
                crearFrame.setVisible(false);
            } catch(Exception e){
                alerta.setText(e.getMessage());
                alerta.setVisible(true);
            }
        }
    }//GEN-LAST:event_crearBtnActionPerformed

    private void cancelarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBtnActionPerformed
        nombreField.setText("");
        cuitField.setText("");
        emailField.setText("");
        direccionField.setText("");
        coordenada1Field.setText("");
        coordenada2Field.setText("");        
        crearFrame.setVisible(false);
    }//GEN-LAST:event_cancelarBtnActionPerformed

    private void tableClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableClientesMouseClicked
        int fila = tableClientes.rowAtPoint(evt.getPoint());
        int columna = tableClientes.columnAtPoint(evt.getPoint());
        if(!tableClientes.getValueAt(fila, 0).equals("") && !tableClientes.getValueAt(fila, 1).equals("")
                 && !tableClientes.getValueAt(fila, 2).equals("") && !tableClientes.getValueAt(fila, 3).equals("")
                 && !tableClientes.getValueAt(fila, 4).equals("") && !tableClientes.getValueAt(fila, 5).equals("")
                 && !tableClientes.getValueAt(fila, 6).equals("")){
            if(columna==7){
                nombreField1.setText(tableClientes.getValueAt(fila, 1).toString());
                cuitField1.setText(tableClientes.getValueAt(fila, 2).toString());
                emailField1.setText(tableClientes.getValueAt(fila, 3).toString());
                direccionField1.setText(tableClientes.getValueAt(fila, 4).toString());
                coordenada1Field1.setText(tableClientes.getValueAt(fila, 5).toString());
                coordenada2Field1.setText(tableClientes.getValueAt(fila, 6).toString());
                editarFrame.setVisible(true);
                ideditar.setVisible(false);
                ideditar.setText(tableClientes.getValueAt(fila, 0).toString());
            } else if(columna==8){
                nombreField2.setText(tableClientes.getValueAt(fila, 1).toString());
                cuitField2.setText(tableClientes.getValueAt(fila, 2).toString());
                emailField2.setText(tableClientes.getValueAt(fila, 3).toString());
                direccionField2.setText(tableClientes.getValueAt(fila, 4).toString());
                coordenada1Field2.setText(tableClientes.getValueAt(fila, 5).toString());
                coordenada2Field2.setText(tableClientes.getValueAt(fila, 6).toString());
                nombreField2.setEnabled(false);
                cuitField2.setEnabled(false);
                emailField2.setEnabled(false);
                direccionField2.setEnabled(false);
                coordenada1Field2.setEnabled(false);
                coordenada2Field2.setEnabled(false);
                eliminarFrame.setVisible(true);
                ideliminar.setVisible(false);
                ideliminar.setText(tableClientes.getValueAt(fila, 0).toString());
            }
        }
    }//GEN-LAST:event_tableClientesMouseClicked

    private void editarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarBtnActionPerformed
        if(nombreField1.getText().isEmpty() || cuitField1.getText().isEmpty() || emailField1.getText().isEmpty() 
                || direccionField1.getText().isEmpty() || coordenada1Field1.getText().isEmpty() 
                || coordenada2Field1.getText().isEmpty()){
            alerta.setText("Ningun campo puede ser vacio");
            alerta.setVisible(true);
        } else {
            Coordenada coordenada = new Coordenada(Double.parseDouble(coordenada1Field1.getText()), Double.parseDouble(coordenada2Field1.getText()));
            try{
                clienteController.modificarCliente(ideditar.getText(), nombreField1.getText(), cuitField1.getText(), emailField1.getText(), direccionField1.getText(), coordenada);
                nombreField1.setText("");
                cuitField1.setText("");
                emailField1.setText("");
                direccionField1.setText("");
                coordenada1Field1.setText("");
                coordenada2Field1.setText("");  
                actualizarTabla();
                alerta.setText("El cliente fue editado exitosamente");
                alerta.setVisible(true);
                editarFrame.setVisible(false);
            } catch(Exception e){
                alerta.setText(e.getMessage());
                alerta.setVisible(true);
            }
            
        }
    }//GEN-LAST:event_editarBtnActionPerformed

    private void cancelarEliminarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarEliminarBtnActionPerformed
        nombreField2.setText("");
        cuitField2.setText("");
        emailField2.setText("");
        direccionField2.setText("");
        coordenada1Field2.setText("");
        coordenada2Field2.setText("");        
        eliminarFrame.setVisible(false);
    }//GEN-LAST:event_cancelarEliminarBtnActionPerformed

    private void eliminarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarBtnActionPerformed
        try{
            clienteController.eliminarCliente(clienteController.buscarCliente(ideliminar.getText()));
            alerta.setText("El cliente fue eliminado exitosamente");
            alerta.setVisible(true);
        }catch(Exception e){
            alerta.setText(e.getMessage());
            alerta.setVisible(true);
        }
    }//GEN-LAST:event_eliminarBtnActionPerformed

    private void cancelarEditarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarEditarBtnActionPerformed
        nombreField1.setText("");
        cuitField1.setText("");
        emailField1.setText("");
        direccionField1.setText("");
        coordenada1Field1.setText("");
        coordenada2Field1.setText("");        
        editarFrame.setVisible(false);
    }//GEN-LAST:event_cancelarEditarBtnActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        Cliente c = clienteController.buscarCliente(txtId.getText());
        String[] columnNames = {"ID", "Nombre", "Cuit", "Email", "Dirección", "Latitud", "Longitud", "", ""};
        Object[][] data = new Object[1][9];
        if(c!=null){
            data[0][0] = c.getId();
            data[0][1] = c.getNombre();
            data[0][2] = c.getCuit();
            data[0][3] = c.getEmail();
            data[0][4] = c.getDireccion();
            data[0][5] = c.getCoordenada().getLat();
            data[0][6] = c.getCoordenada().getLng();
            data[0][7] = "Editar";
            data[0][8] = "Borrar";
        } else if (c==null){
            data[0][0] = "";
            data[0][1] = "";
            data[0][2] = "";
            data[0][3] = "";
            data[0][4] = "";
            data[0][5] = "";
            data[0][6] = "";
            data[0][7] = "";
            data[0][8] = "";
            alerta.setText("No se encontro el cliente");
            alerta.setVisible(true);
        }
        tableClientes.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
        tableClientes.getColumnModel().getColumn(0).setCellRenderer(new GestionCeldas("numerico"));
        tableClientes.getColumnModel().getColumn(1).setCellRenderer(new GestionCeldas("texto"));
        tableClientes.getColumnModel().getColumn(2).setCellRenderer(new GestionCeldas("numerico"));
        tableClientes.getColumnModel().getColumn(3).setCellRenderer(new GestionCeldas("texto"));
        tableClientes.getColumnModel().getColumn(4).setCellRenderer(new GestionCeldas("texto"));
        tableClientes.getColumnModel().getColumn(5).setCellRenderer(new GestionCeldas("numerico"));
        tableClientes.getColumnModel().getColumn(6).setCellRenderer(new GestionCeldas("numerico"));
        tableClientes.getColumnModel().getColumn(7).setCellRenderer(new GestionCeldas("icono"));
        tableClientes.getColumnModel().getColumn(8).setCellRenderer(new GestionCeldas("icono"));
    }//GEN-LAST:event_btnBuscarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCrearCliente;
    private javax.swing.JButton btnRefrescar;
    private javax.swing.JButton cancelarBtn;
    private javax.swing.JButton cancelarEditarBtn;
    private javax.swing.JButton cancelarEliminarBtn;
    private javax.swing.JTextField coordenada1Field;
    private javax.swing.JTextField coordenada1Field1;
    private javax.swing.JTextField coordenada1Field2;
    private javax.swing.JTextField coordenada2Field;
    private javax.swing.JTextField coordenada2Field1;
    private javax.swing.JTextField coordenada2Field2;
    private javax.swing.JButton crearBtn;
    private javax.swing.JFrame crearFrame;
    private javax.swing.JTextField cuitField;
    private javax.swing.JTextField cuitField1;
    private javax.swing.JTextField cuitField2;
    private javax.swing.JTextField direccionField;
    private javax.swing.JTextField direccionField1;
    private javax.swing.JTextField direccionField2;
    private javax.swing.JButton editarBtn;
    private javax.swing.JFrame editarFrame;
    private javax.swing.JButton eliminarBtn;
    private javax.swing.JFrame eliminarFrame;
    private javax.swing.JTextField emailField;
    private javax.swing.JTextField emailField1;
    private javax.swing.JTextField emailField2;
    private javax.swing.JTextField ideditar;
    private javax.swing.JTextField ideliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombreField;
    private javax.swing.JTextField nombreField1;
    private javax.swing.JTextField nombreField2;
    private javax.swing.JPanel panelSuperior;
    private javax.swing.JPanel panelSuperiorDerecho;
    private javax.swing.JPanel panelSuperiorIzquierdo;
    private javax.swing.JPanel panelTextos;
    private javax.swing.JTable tableClientes;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables

}
