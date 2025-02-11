package desarrollo.tpentrega1.UI;

import desarrollo.tpentrega1.controllers.ClienteController;
import desarrollo.tpentrega1.controllers.ItemMenuController;
import desarrollo.tpentrega1.controllers.PedidoController;
import desarrollo.tpentrega1.controllers.VendedorController;
import desarrollo.tpentrega1.entidades.Cliente;
import desarrollo.tpentrega1.entidades.ItemMenu;
import desarrollo.tpentrega1.entidades.MercadoPago;
import desarrollo.tpentrega1.entidades.Pago;
import desarrollo.tpentrega1.entidades.Pedido;
import desarrollo.tpentrega1.entidades.Transferencia;
import desarrollo.tpentrega1.entidades.Vendedor;
import desarrollo.tpentrega1.enums.EstadoPedido;
import desarrollo.tpentrega1.exceptions.DAOException;
import desarrollo.tpentrega1.utilidades.GestionCeldas;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

public class PedidoUI extends javax.swing.JPanel {

    private final VendedorController vendedorController;
    private final ClienteController clienteController;
    private final PedidoController pedidoController;
    private final ItemMenuController itemMenuController;

    public PedidoUI() {
        this.pedidoController = PedidoController.getInstance();
        this.clienteController = ClienteController.getInstance();
        this.vendedorController = VendedorController.getInstance();
        this.itemMenuController = ItemMenuController.getInstance();
        initComponents();
//        tablePedidos.

        actualizarTabla();
    }

    public void update() {
    }

    private void actualizarTabla() {
        List<Pedido> pedidos;
        try {
            pedidos = pedidoController.obtenerListaPedidos();
            String[] columnNames = {"Id", "Cliente", "Vendedor", "Estado", "Forma de pago", "Total", "Items", "", ""};
            Object[][] data = new Object[pedidos.size()][9];
            for (int i = 0; i < pedidos.size(); i++) {
                List<String> items1 = new ArrayList();
                data[i][0] = pedidos.get(i).getId();
                data[i][1] = pedidos.get(i).getCliente();
                data[i][2] = pedidos.get(i).getVendedor().getNombre();
                data[i][3] = pedidos.get(i).getEstado().toString();
                data[i][4] = pedidos.get(i).getPago().getClass();
                data[i][5] = pedidos.get(i).getTotal();
                pedidos.get(i).getItems().stream().forEach(item -> items1.add(item.getNombre()));
                data[i][6] = items1;
                data[i][7] = "Editar";
                data[i][8] = "Borrar";
            }
            tablePedidos.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
            tablePedidos.getColumnModel().getColumn(0).setCellRenderer(new GestionCeldas("numerico"));
            tablePedidos.getColumnModel().getColumn(1).setCellRenderer(new GestionCeldas("texto"));
            tablePedidos.getColumnModel().getColumn(2).setCellRenderer(new GestionCeldas("texto"));
            tablePedidos.getColumnModel().getColumn(3).setCellRenderer(new GestionCeldas("texto"));
            tablePedidos.getColumnModel().getColumn(4).setCellRenderer(new GestionCeldas("texto"));
            tablePedidos.getColumnModel().getColumn(5).setCellRenderer(new GestionCeldas("numerico"));
            tablePedidos.getColumnModel().getColumn(6).setCellRenderer(new GestionCeldas("texto"));
            tablePedidos.getColumnModel().getColumn(7).setCellRenderer(new GestionCeldas("icono"));
            tablePedidos.getColumnModel().getColumn(8).setCellRenderer(new GestionCeldas("icono"));
            tablePedidos.getColumnModel().getColumn(7).setPreferredWidth(10);
            tablePedidos.getColumnModel().getColumn(8).setPreferredWidth(10);
        } catch (DAOException ex) {
            Logger.getLogger(PedidoUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        crearFrame = new javax.swing.JFrame();
        cancelarCrearBtn = new javax.swing.JButton();
        crearBtn = new javax.swing.JButton();
        vendedoresDD = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        itemsDD = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        agregarItemButton = new javax.swing.JButton();
        cantItemSpinner = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        formaDePagoDD = new javax.swing.JComboBox<>();
        totalLabel = new javax.swing.JLabel();
        cbuAliasField = new javax.swing.JTextField();
        cuitField = new javax.swing.JTextField();
        cbuAliasLabel = new javax.swing.JLabel();
        cuitLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaItemsCrear = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        clientesDD = new javax.swing.JComboBox<>();
        editarFrame = new javax.swing.JFrame();
        editarBtn = new javax.swing.JButton();
        cbuAliasField1 = new javax.swing.JTextField();
        vendedoresDD1 = new javax.swing.JComboBox<>();
        cuitField1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbuAliasLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cuitLabel1 = new javax.swing.JLabel();
        itemsDD1 = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaItemsCrear1 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        agregarItemButton1 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        cantItemSpinner1 = new javax.swing.JSpinner();
        clientesDD1 = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        formaDePagoDD1 = new javax.swing.JComboBox<>();
        cancelarCrearBtn1 = new javax.swing.JButton();
        totalLabel1 = new javax.swing.JLabel();
        eliminarFrame = new javax.swing.JFrame();
        eliminarBtn = new javax.swing.JButton();
        cbuAliasField2 = new javax.swing.JTextField();
        vendedoresDD2 = new javax.swing.JComboBox<>();
        cuitField2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbuAliasLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cuitLabel2 = new javax.swing.JLabel();
        itemsDD2 = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaItemsCrear2 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        agregarItemButton2 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        cantItemSpinner2 = new javax.swing.JSpinner();
        clientesDD2 = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        formaDePagoDD2 = new javax.swing.JComboBox<>();
        cancelarCrearBtn2 = new javax.swing.JButton();
        totalLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        btnBuscar1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePedidos = new javax.swing.JTable();
        btnCrearPedido = new javax.swing.JButton();
        btnRefrescar = new javax.swing.JButton();

        crearFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        crearFrame.setBackground(new java.awt.Color(224, 240, 254));
        crearFrame.setLocationByPlatform(true);
        crearFrame.setSize(new java.awt.Dimension(500, 450));

        cancelarCrearBtn.setText("Cancelar");
        cancelarCrearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarCrearBtnActionPerformed(evt);
            }
        });

        crearBtn.setText("Crear");
        crearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearBtnActionPerformed(evt);
            }
        });

        vendedoresDD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendedoresDDActionPerformed(evt);
            }
        });

        jLabel2.setText("Vendedor");

        jLabel3.setText("Items");

        jLabel4.setText("Cantidad");

        agregarItemButton.setText("Agregar");
        agregarItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarItemButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("Forma de pago");

        formaDePagoDD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formaDePagoDDActionPerformed(evt);
            }
        });

        totalLabel.setText("Total: n");

        cbuAliasLabel.setText("Cbu");

        cuitLabel.setText("Cuit");

        tablaItemsCrear.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaItemsCrear.setName(""); // NOI18N
        jScrollPane2.setViewportView(tablaItemsCrear);

        jLabel6.setText("Cliente");

        javax.swing.GroupLayout crearFrameLayout = new javax.swing.GroupLayout(crearFrame.getContentPane());
        crearFrame.getContentPane().setLayout(crearFrameLayout);
        crearFrameLayout.setHorizontalGroup(
            crearFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crearFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(crearFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(crearFrameLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(totalLabel)
                        .addGap(50, 50, 50)
                        .addComponent(cancelarCrearBtn)
                        .addGap(18, 18, 18)
                        .addComponent(crearBtn))
                    .addGroup(crearFrameLayout.createSequentialGroup()
                        .addGroup(crearFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(cbuAliasLabel)
                            .addComponent(cuitLabel)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(crearFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(clientesDD, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbuAliasField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(crearFrameLayout.createSequentialGroup()
                                .addComponent(cantItemSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(agregarItemButton))
                            .addComponent(itemsDD, javax.swing.GroupLayout.Alignment.TRAILING, 0, 371, Short.MAX_VALUE)
                            .addComponent(vendedoresDD, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(formaDePagoDD, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cuitField, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        crearFrameLayout.setVerticalGroup(
            crearFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crearFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(crearFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(clientesDD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(crearFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(vendedoresDD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(crearFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(formaDePagoDD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(crearFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbuAliasField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbuAliasLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(crearFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cuitField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cuitLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(crearFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(itemsDD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(crearFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(agregarItemButton)
                    .addComponent(cantItemSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(crearFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(crearBtn)
                    .addComponent(cancelarCrearBtn)
                    .addComponent(totalLabel))
                .addGap(12, 12, 12))
        );

        editarFrame.setLocationByPlatform(true);
        editarFrame.setSize(new java.awt.Dimension(425, 200));

        editarBtn.setText("Editar");
        editarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarBtnActionPerformed(evt);
            }
        });

        vendedoresDD1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendedoresDD1ActionPerformed(evt);
            }
        });

        jLabel7.setText("Vendedor");

        cbuAliasLabel1.setText("Cbu");

        jLabel9.setText("Items");

        cuitLabel1.setText("Cuit");

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

        jLabel10.setText("Cantidad");

        agregarItemButton1.setText("Agregar");
        agregarItemButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarItemButton1ActionPerformed(evt);
            }
        });

        jLabel14.setText("Cliente");

        jLabel15.setText("Forma de pago");

        formaDePagoDD1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formaDePagoDD1ActionPerformed(evt);
            }
        });

        cancelarCrearBtn1.setText("Cancelar");
        cancelarCrearBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarCrearBtn1ActionPerformed(evt);
            }
        });

        totalLabel1.setText("Total: n");

        javax.swing.GroupLayout editarFrameLayout = new javax.swing.GroupLayout(editarFrame.getContentPane());
        editarFrame.getContentPane().setLayout(editarFrameLayout);
        editarFrameLayout.setHorizontalGroup(
            editarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editarFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                    .addGroup(editarFrameLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(totalLabel1)
                        .addGap(50, 50, 50)
                        .addComponent(cancelarCrearBtn1)
                        .addGap(18, 18, 18)
                        .addComponent(editarBtn))
                    .addGroup(editarFrameLayout.createSequentialGroup()
                        .addGroup(editarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel15)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7)
                            .addComponent(cbuAliasLabel1)
                            .addComponent(cuitLabel1)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(editarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(clientesDD1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbuAliasField1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(editarFrameLayout.createSequentialGroup()
                                .addComponent(cantItemSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(agregarItemButton1))
                            .addComponent(itemsDD1, javax.swing.GroupLayout.Alignment.TRAILING, 0, 338, Short.MAX_VALUE)
                            .addComponent(vendedoresDD1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(formaDePagoDD1, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cuitField1, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        editarFrameLayout.setVerticalGroup(
            editarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editarFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(clientesDD1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(vendedoresDD1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(formaDePagoDD1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbuAliasField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbuAliasLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cuitField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cuitLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(itemsDD1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(agregarItemButton1)
                    .addComponent(cantItemSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(editarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editarBtn)
                    .addComponent(cancelarCrearBtn1)
                    .addComponent(totalLabel1))
                .addGap(12, 12, 12))
        );

        eliminarFrame.setLocationByPlatform(true);
        eliminarFrame.setSize(new java.awt.Dimension(425, 200));

        eliminarBtn.setText("Eliminar");
        eliminarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarBtnActionPerformed(evt);
            }
        });

        vendedoresDD2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendedoresDD2ActionPerformed(evt);
            }
        });

        jLabel8.setText("Vendedor");

        cbuAliasLabel2.setText("Cbu");

        jLabel11.setText("Items");

        cuitLabel2.setText("Cuit");

        tablaItemsCrear2.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaItemsCrear2.setName(""); // NOI18N
        jScrollPane4.setViewportView(tablaItemsCrear2);

        jLabel12.setText("Cantidad");

        agregarItemButton2.setText("Agregar");
        agregarItemButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarItemButton2ActionPerformed(evt);
            }
        });

        jLabel18.setText("Cliente");

        jLabel19.setText("Forma de pago");

        formaDePagoDD2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formaDePagoDD2ActionPerformed(evt);
            }
        });

        cancelarCrearBtn2.setText("Cancelar");
        cancelarCrearBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarCrearBtn2ActionPerformed(evt);
            }
        });

        totalLabel2.setText("Total: n");

        javax.swing.GroupLayout eliminarFrameLayout = new javax.swing.GroupLayout(eliminarFrame.getContentPane());
        eliminarFrame.getContentPane().setLayout(eliminarFrameLayout);
        eliminarFrameLayout.setHorizontalGroup(
            eliminarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eliminarFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(eliminarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addGroup(eliminarFrameLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(totalLabel2)
                        .addGap(50, 50, 50)
                        .addComponent(cancelarCrearBtn2)
                        .addGap(18, 18, 18)
                        .addComponent(eliminarBtn))
                    .addGroup(eliminarFrameLayout.createSequentialGroup()
                        .addGroup(eliminarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel19)
                            .addComponent(jLabel11)
                            .addComponent(jLabel8)
                            .addComponent(cbuAliasLabel2)
                            .addComponent(cuitLabel2)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(eliminarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(clientesDD2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbuAliasField2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(eliminarFrameLayout.createSequentialGroup()
                                .addComponent(cantItemSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(agregarItemButton2))
                            .addComponent(itemsDD2, javax.swing.GroupLayout.Alignment.TRAILING, 0, 302, Short.MAX_VALUE)
                            .addComponent(vendedoresDD2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(formaDePagoDD2, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cuitField2, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        eliminarFrameLayout.setVerticalGroup(
            eliminarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eliminarFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(eliminarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(clientesDD2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(eliminarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(vendedoresDD2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(eliminarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(formaDePagoDD2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(eliminarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbuAliasField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbuAliasLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(eliminarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cuitField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cuitLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(eliminarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(itemsDD2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(eliminarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(agregarItemButton2)
                    .addComponent(cantItemSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(eliminarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eliminarBtn)
                    .addComponent(cancelarCrearBtn2)
                    .addComponent(totalLabel2))
                .addGap(12, 12, 12))
        );

        setBackground(new java.awt.Color(224, 240, 254));

        jLabel1.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ID Pedido:");

        btnBuscar1.setBackground(new java.awt.Color(100, 180, 255));
        btnBuscar1.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        btnBuscar1.setForeground(new java.awt.Color(224, 240, 254));
        btnBuscar1.setText("Buscar");
        btnBuscar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(224, 240, 254), new java.awt.Color(224, 240, 254), null, null));
        btnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar1ActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(224, 240, 254));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 204, 153))); // NOI18N
        jScrollPane1.setFont(new java.awt.Font("Segoe UI Historic", 3, 12)); // NOI18N
        jScrollPane1.setRowHeaderView(null);

        tablePedidos.setBackground(new java.awt.Color(224, 240, 254));
        tablePedidos.setModel(new javax.swing.table.DefaultTableModel(
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
        tablePedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePedidosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePedidos);

        btnCrearPedido.setBackground(new java.awt.Color(100, 180, 252));
        btnCrearPedido.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        btnCrearPedido.setForeground(new java.awt.Color(224, 240, 254));
        btnCrearPedido.setText("Crear Pedido");
        btnCrearPedido.setToolTipText("");
        btnCrearPedido.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(224, 240, 254), null, null));
        btnCrearPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearPedidoActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtId)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCrearPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrearPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void idFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idFieldActionPerformed

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed

    }//GEN-LAST:event_btnBuscar1ActionPerformed

    private void tablePedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePedidosMouseClicked
        /*int fila = tablePedidos.rowAtPoint(evt.getPoint());
        int columna = tablePedidos.columnAtPoint(evt.getPoint());
        if(!tablePedidos.getValueAt(fila, 0).equals("") && !tablePedidos.getValueAt(fila, 1).equals("")
            && !tablePedidos.getValueAt(fila, 2).equals("") && !tablePedidos.getValueAt(fila, 3).equals("")
            && !tablePedidos.getValueAt(fila, 4).equals("") && !tablePedidos.getValueAt(fila, 6).equals("")
            && !tablePedidos.getValueAt(fila, 7).equals("")){
            int idPedido = (int) tablePedidos.getValueAt(fila, 0);
            if(columna==6){
                Pedido pedido = pedidoController.buscarPedido(String.valueOf(idPedido));
                clientesDD1.setSelectedItem(tablePedidos.getValueAt(fila, 1).toString());
                vendedoresDD1.setSelectedItem(tablePedidos.getValueAt(fila, 2).toString());
                formaDePagoDD1.setSelectedItem(tablePedidos.getValueAt(fila, 3).toString());
                if(tablePedidos.getValueAt(fila, 3).toString().equals("Mercado Pago")){
                    cbuAliasLabel1.setText("Alias");
                    cbuAliasField1.setText(pedido.getPago().);
        // con getPago no puedo acceder al alias o cbu???????????
                    cuitField.setVisible(false);
                    cuitLabel.setVisible(false);
                }
                coordenada2Field1.setText(tablePedidos.getValueAt(fila, 4).toString());
                editarFrame.setVisible(true);
                ideditar.setVisible(false);
                ideditar.setText(tablePedidos.getValueAt(fila, 0).toString());
            } else if(columna==7){
                nombreField2.setText(tablePedidos.getValueAt(fila, 1).toString());
                direccionField2.setText(tablePedidos.getValueAt(fila, 2).toString());
                coordenada1Field2.setText(tablePedidos.getValueAt(fila, 3).toString());
                coordenada2Field2.setText(tablePedidos.getValueAt(fila, 4).toString());
                nombreField2.setEnabled(false);
                direccionField2.setEnabled(false);
                coordenada1Field2.setEnabled(false);
                coordenada2Field2.setEnabled(false);
                eliminarFrame.setVisible(true);
                ideliminar.setVisible(false);
                ideliminar.setText(tablePedidos.getValueAt(fila, 0).toString());
            }
        }*/
    }//GEN-LAST:event_tablePedidosMouseClicked

    private void btnCrearPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearPedidoActionPerformed
        String[] columnNames = {"Item", "Cantidad"};
        Object[][] data = null;
        tablaItemsCrear.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
        SpinnerNumberModel modelo = new SpinnerNumberModel();
        modelo.setMinimum(0);
        cantItemSpinner.setModel(modelo);
        try {
            clienteController.obtenerListaClientes().stream().forEach(cliente -> clientesDD.addItem(cliente.getNombre()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se encontraron clientes", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
        vendedoresDD.removeAllItems();
        try {
            vendedorController.obtenerListaVendedores().stream().forEach(vendedor -> vendedoresDD.addItem(vendedor.getNombre()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se encontraron vendedores", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
        vendedoresDD.setEnabled(true);
        itemsDD.setEnabled(false);
        agregarItemButton.setEnabled(false);
        cantItemSpinner.setEnabled(false);
        formaDePagoDD.setEnabled(false);
        cbuAliasField.setEnabled(false);
        cuitField.setEnabled(false);
        formaDePagoDD.removeAllItems();
        formaDePagoDD.addItem("Transferencia");
        formaDePagoDD.addItem("Mercado Pago");
        crearFrame.setVisible(true);
    }//GEN-LAST:event_btnCrearPedidoActionPerformed

    private void btnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarActionPerformed
        this.actualizarTabla();
    }//GEN-LAST:event_btnRefrescarActionPerformed

    private void vendedoresDDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vendedoresDDActionPerformed
        vendedoresDD.setEnabled(false);
        itemsDD.setEnabled(true);
        agregarItemButton.setEnabled(true);
        cantItemSpinner.setEnabled(true);
        formaDePagoDD.setEnabled(true);
        cbuAliasField.setEnabled(true);
        cuitField.setEnabled(true);
        try {

            if (vendedoresDD.getSelectedItem() != null) {
                itemMenuController.obtenerItemsMenuDeVendedor(
                        vendedorController.buscarVendedorPorNombre(
                                vendedoresDD.getSelectedItem().toString()).getId())
                        .stream().forEach(item -> itemsDD.addItem(item.getNombre()));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se encontro el vendedor", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_vendedoresDDActionPerformed

    private void crearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearBtnActionPerformed
        Cliente c;
        Vendedor v;
        try {
            c = clienteController.buscarCliente(Integer.valueOf(clientesDD.getSelectedItem().toString()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se encontro el Cliente", "Alerta", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            v = vendedorController.buscarVendedor(Integer.valueOf(vendedoresDD.getSelectedItem().toString()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se encontro el vendedor", "Alerta", JOptionPane.WARNING_MESSAGE);
            return;
        }
        List<ItemMenu> listaItems = new ArrayList<>();
        Pago pago = null;
        try {
        for (int i = 0; i < tablaItemsCrear.getRowCount(); i++) {
            for (int j = 0; j < (int) tablaItemsCrear.getValueAt(i, 1); j++) {
                listaItems.add(itemMenuController.buscarItemMenuPorNombre(tablaItemsCrear.getValueAt(i, 0).toString()));
            }
        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudieron obtener los items del pedido", "Alerta", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (formaDePagoDD.getSelectedItem().toString().equals("Mercado Pago")) {
            pago = new MercadoPago(cbuAliasField.getText(), Double.parseDouble(totalLabel.getText().substring(2)));
        } else if (formaDePagoDD.getSelectedItem().toString().equals("Transferencia")) {
            pago = new Transferencia(cuitField.getText(), cbuAliasField.getText(), Double.parseDouble(totalLabel.getText().substring(2)));
        }
        try {
            pedidoController.newPedido(c, v, listaItems, pago, EstadoPedido.RECIBIDO);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo creare el pedido", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_crearBtnActionPerformed

    private void cancelarCrearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarCrearBtnActionPerformed
        crearFrame.setVisible(false);
    }//GEN-LAST:event_cancelarCrearBtnActionPerformed

    private void formaDePagoDDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formaDePagoDDActionPerformed
        if (formaDePagoDD.getSelectedItem() != null) {
            if (formaDePagoDD.getSelectedItem().toString().equals("Mercado Pago")) {
                cbuAliasLabel.setText("Alias");
                cuitField.setVisible(false);
                cuitLabel.setVisible(false);
            } else if (formaDePagoDD.getSelectedItem().toString().equals("Transferencia")) {
                cbuAliasLabel.setText("Cbu");
                cuitField.setVisible(true);
                cuitLabel.setVisible(true);
            }
        }
    }//GEN-LAST:event_formaDePagoDDActionPerformed

    private void agregarItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarItemButtonActionPerformed
        try {
            String itemSeleccionado = itemsDD.getSelectedItem().toString();

            int cantSelecionada = (int) cantItemSpinner.getValue();
            DefaultTableModel modelo = (DefaultTableModel) tablaItemsCrear.getModel();
            boolean encontrado = false;
            int i = 0;
            while (i < tablaItemsCrear.getRowCount() && !encontrado) {
                String item = (String) modelo.getValueAt(i, 0);
                if (item.equals(itemSeleccionado)) {
                    encontrado = true;
                    if (cantSelecionada == 0) {
                        modelo.removeRow(i);
                    } else {
                        modelo.setValueAt(cantSelecionada, i, 1);
                    }
                }
                i++;
            }
            if (cantSelecionada != 0) {
                if (!encontrado) {
                    Object[] row = {itemSeleccionado, cantSelecionada};
                    modelo.addRow(row);
                }
            }
            double total = 0;

            if (formaDePagoDD.getSelectedItem().toString().equals("Mercado Pago")) {
                for (int j = 0; j < tablaItemsCrear.getRowCount(); j++) {
                    double subtotal = ((int) tablaItemsCrear.getValueAt(j, 1)) * itemMenuController.buscarItemMenuPorNombre(tablaItemsCrear.getValueAt(j, 0).toString()).getPrecio();
                    total += (subtotal + (subtotal * (0.04)));
                }
            } else if (formaDePagoDD.getSelectedItem().toString().equals("Transferencia")) {
                for (int j = 0; j < tablaItemsCrear.getRowCount(); j++) {
                    double subtotal = ((int) tablaItemsCrear.getValueAt(j, 1)) * itemMenuController.buscarItemMenuPorNombre(tablaItemsCrear.getValueAt(j, 0).toString()).getPrecio();
                    total += (subtotal + (subtotal * (0.02)));
                }
            }
            totalLabel.setText("Total: " + String.valueOf(total));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudieron obtener los items del pedido", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_agregarItemButtonActionPerformed

    private void editarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editarBtnActionPerformed

    private void vendedoresDD1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vendedoresDD1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vendedoresDD1ActionPerformed

    private void agregarItemButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarItemButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_agregarItemButton1ActionPerformed

    private void formaDePagoDD1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formaDePagoDD1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_formaDePagoDD1ActionPerformed

    private void cancelarCrearBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarCrearBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelarCrearBtn1ActionPerformed

    private void eliminarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eliminarBtnActionPerformed

    private void vendedoresDD2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vendedoresDD2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vendedoresDD2ActionPerformed

    private void agregarItemButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarItemButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_agregarItemButton2ActionPerformed

    private void formaDePagoDD2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formaDePagoDD2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_formaDePagoDD2ActionPerformed

    private void cancelarCrearBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarCrearBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelarCrearBtn2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarItemButton;
    private javax.swing.JButton agregarItemButton1;
    private javax.swing.JButton agregarItemButton2;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnCrearPedido;
    private javax.swing.JButton btnRefrescar;
    private javax.swing.JButton cancelarCrearBtn;
    private javax.swing.JButton cancelarCrearBtn1;
    private javax.swing.JButton cancelarCrearBtn2;
    private javax.swing.JSpinner cantItemSpinner;
    private javax.swing.JSpinner cantItemSpinner1;
    private javax.swing.JSpinner cantItemSpinner2;
    private javax.swing.JTextField cbuAliasField;
    private javax.swing.JTextField cbuAliasField1;
    private javax.swing.JTextField cbuAliasField2;
    private javax.swing.JLabel cbuAliasLabel;
    private javax.swing.JLabel cbuAliasLabel1;
    private javax.swing.JLabel cbuAliasLabel2;
    private javax.swing.JComboBox<String> clientesDD;
    private javax.swing.JComboBox<String> clientesDD1;
    private javax.swing.JComboBox<String> clientesDD2;
    private javax.swing.JButton crearBtn;
    private javax.swing.JFrame crearFrame;
    private javax.swing.JTextField cuitField;
    private javax.swing.JTextField cuitField1;
    private javax.swing.JTextField cuitField2;
    private javax.swing.JLabel cuitLabel;
    private javax.swing.JLabel cuitLabel1;
    private javax.swing.JLabel cuitLabel2;
    private javax.swing.JButton editarBtn;
    private javax.swing.JFrame editarFrame;
    private javax.swing.JButton eliminarBtn;
    private javax.swing.JFrame eliminarFrame;
    private javax.swing.JComboBox<String> formaDePagoDD;
    private javax.swing.JComboBox<String> formaDePagoDD1;
    private javax.swing.JComboBox<String> formaDePagoDD2;
    private javax.swing.JComboBox<String> itemsDD;
    private javax.swing.JComboBox<String> itemsDD1;
    private javax.swing.JComboBox<String> itemsDD2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tablaItemsCrear;
    private javax.swing.JTable tablaItemsCrear1;
    private javax.swing.JTable tablaItemsCrear2;
    private javax.swing.JTable tablePedidos;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JLabel totalLabel1;
    private javax.swing.JLabel totalLabel2;
    private javax.swing.JTextField txtId;
    private javax.swing.JComboBox<String> vendedoresDD;
    private javax.swing.JComboBox<String> vendedoresDD1;
    private javax.swing.JComboBox<String> vendedoresDD2;
    // End of variables declaration//GEN-END:variables
}
