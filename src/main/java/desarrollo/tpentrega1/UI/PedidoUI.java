package desarrollo.tpentrega1.UI;

import desarrollo.tpentrega1.controllers.ClienteController;
import desarrollo.tpentrega1.controllers.PedidoController;
import desarrollo.tpentrega1.controllers.VendedorController;
import desarrollo.tpentrega1.entidades.Bebida;
import desarrollo.tpentrega1.entidades.Cliente;
import desarrollo.tpentrega1.entidades.ItemMenu;
import desarrollo.tpentrega1.entidades.MercadoPago;
import desarrollo.tpentrega1.entidades.Pedido;
import desarrollo.tpentrega1.entidades.Plato;
import desarrollo.tpentrega1.entidades.Transferencia;
import desarrollo.tpentrega1.entidades.Vendedor;
import desarrollo.tpentrega1.enums.EstadoPedido;
import java.awt.CardLayout;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListModel;

public class PedidoUI extends javax.swing.JPanel {

    private VendedorController vendedorController;
    private ClienteController clienteController;
    private PedidoController pedidoController;

    private JTextField tfFormaPago1;
    private JTextField tfFormaPago2;
    private boolean mostrarTransferencia = false;

    /*
    private String id;
    private String nombre;
    private String descripcion;
    private double precio;
    private String categoria;
    private Vendedor vendedor;
    
    private double graduacionAlcoholica;
    private double tamaño;
    
    private double calorias;
    private boolean aptoCeliaco;
    private boolean aptoVegano;
    private double peso;
     */
    public PedidoUI(PedidoController pedidoController, VendedorController vendedorController, ClienteController clienteController) {
        initComponents();

        this.pedidoController = pedidoController;
        this.vendedorController = vendedorController;
        this.pedidoController = pedidoController;

        List<Vendedor> listaVendedores = vendedorController.obtenerListaVendedores();
        List<Cliente> listaClientes = clienteController.obtenerListaClientes();
        for (Vendedor v : listaVendedores) {
            ddVendedor.addItem(v.getId() + " - " + v.getNombre());
        }

        for (Cliente c : listaClientes) {
            ddCliente.addItem(c.getId() + " - " + c.getNombre());
        }
        ddCliente.setMaximumRowCount(listaClientes.size());

        ddEstado.addItem(EstadoPedido.RECIBIDO.toString());
        ddEstado.addItem(EstadoPedido.PROCESADO.toString());
        ddEstado.addItem(EstadoPedido.ENVIADO.toString());
        ddEstado.setMaximumRowCount(3);

        // FormaDePago
        tfFormaPago1 = new JTextField();
        tfFormaPago2 = new JTextField();
        panFormaDePago.setLayout(new BoxLayout(panFormaDePago, BoxLayout.X_AXIS));
        panFormaDePago.add(tfFormaPago1);

        ddFormaPago.addItem("Mercado Pago (alias)");
        ddFormaPago.addItem("Transferencia (cuit, cvu)");
        ddEstado.setMaximumRowCount(2);

        //vendedoresDropDown.setModel(new javax.swing.DefaultComboBoxModel<>());
        //ListModel<String> listaItems = pedidoController.getItems(pedidoController.buscarYDevolverPedido(Integer.parseInt(idField.getText())));
        //jList1.setModel(listaItems);
    }

    private void showMp() {
        if (mostrarTransferencia) {
            panFormaDePago.remove(tfFormaPago2);
            mostrarTransferencia = false;
            panFormaDePago.revalidate();
            panFormaDePago.repaint();
        }
    }

    private void showTransferencia() {
        if (!mostrarTransferencia) {
            panFormaDePago.add(tfFormaPago2);
            mostrarTransferencia = true;
            panFormaDePago.revalidate();
            panFormaDePago.repaint();
        }

    }

    private void updateTable(List<ItemMenu> items) {
        String[] columnNames = {
            "ID",
            "Nombre",
            "Descipcion",
            "precio",
            "categoria",
            "vendedor",
            "graduacionAlcoholica",
            "tamaño",
            "calorias",
            "aptoCeliaco",
            "aptoVegano",
            "peso"
        };

        Object[][] data = new Object[items.size()][12];
        for (int i = 0; i < items.size(); i++) {
            ItemMenu item = items.get(i);
            data[i][0] = item.getId();
            data[i][1] = item.getNombre();
            data[i][2] = item.getDescripcion();
            data[i][3] = item.getPrecio() + "";
            data[i][4] = item.getCategoria();
            data[i][5] = item.getVendedor().getNombre();

            if (item instanceof Bebida) {
                data[i][6] = ((Bebida) item).getGraduacionAlcoholica() + "";
                data[i][7] = ((Bebida) item).getTamaño() + "";
                data[i][8] = "-";
                data[i][9] = "-";
                data[i][10] = "-";
                data[i][11] = "-";
            } else {
                data[i][6] = "-";
                data[i][7] = "-";
                data[i][8] = ((Plato) item).getCalorias() + "";
                data[i][9] = ((Plato) item).aptoCeliaco() + "";
                data[i][10] = ((Plato) item).aptoVegano() + "";
                data[i][11] = ((Plato) item).peso() + "";
            }

        }
        tableItems.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));

    }

    //actualizarTabla();
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        itemsFrame = new javax.swing.JFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableItems = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        tfAddItem = new javax.swing.JTextField();
        btnRemoveItem = new javax.swing.JButton();
        btnAddItem = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        editarItemsButton = new javax.swing.JButton();
        crearButton = new javax.swing.JButton();
        buscarButton = new javax.swing.JButton();
        eliminarButton = new javax.swing.JButton();
        tfId = new javax.swing.JTextField();
        ddVendedor = new javax.swing.JComboBox<>();
        ddCliente = new javax.swing.JComboBox<>();
        ddEstado = new javax.swing.JComboBox<>();
        tfTotal = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        listItems = new javax.swing.JList<>();
        ddFormaPago = new javax.swing.JComboBox<>();
        panFormaDePago = new javax.swing.JPanel();

        itemsFrame.setLocationByPlatform(true);
        itemsFrame.setSize(new java.awt.Dimension(400, 300));
        itemsFrame.setType(java.awt.Window.Type.POPUP);

        tableItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Tipo", "Precio", "Graduacion Alcoholica", "Tamaño", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableItems.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tableItems);

        jPanel1.setPreferredSize(new java.awt.Dimension(200, 82));

        btnRemoveItem.setLabel("Eliminar");

        btnAddItem.setLabel("Agregar");
        btnAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItemActionPerformed(evt);
            }
        });

        jLabel8.setText("ID de item");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfAddItem, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoveItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfAddItem)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAddItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(btnRemoveItem)))
                .addContainerGap())
        );

        javax.swing.GroupLayout itemsFrameLayout = new javax.swing.GroupLayout(itemsFrame.getContentPane());
        itemsFrame.getContentPane().setLayout(itemsFrameLayout);
        itemsFrameLayout.setHorizontalGroup(
            itemsFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
        );
        itemsFrameLayout.setVerticalGroup(
            itemsFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itemsFrameLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setBackground(new java.awt.Color(130, 217, 217));

        jLabel1.setText("ID:");

        jLabel2.setText("Vendedor:");

        jLabel7.setText("Cliente:");

        jLabel4.setText("Estado:");

        jLabel3.setText("Forma de Pago:");

        jLabel5.setText("Total:");

        jLabel6.setText("Items:");

        editarItemsButton.setText("Editar Items");
        editarItemsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarItemsButtonActionPerformed(evt);
            }
        });

        crearButton.setText("Crear");
        crearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearButtonActionPerformed(evt);
            }
        });

        buscarButton.setText("Buscar");
        buscarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarButtonActionPerformed(evt);
            }
        });

        eliminarButton.setText("Eliminar");

        tfId.setToolTipText("");
        tfId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdActionPerformed(evt);
            }
        });

        ddVendedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        ddVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ddVendedorActionPerformed(evt);
            }
        });

        ddCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        ddCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ddClienteActionPerformed(evt);
            }
        });

        ddEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        ddEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ddEstadoActionPerformed(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Vendedor", "Estado", "Forma de Pago", "Total", "Items"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTable3);

        listItems.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(listItems);

        ddFormaPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        ddFormaPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ddFormaPagoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panFormaDePagoLayout = new javax.swing.GroupLayout(panFormaDePago);
        panFormaDePago.setLayout(panFormaDePagoLayout);
        panFormaDePagoLayout.setHorizontalGroup(
            panFormaDePagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panFormaDePagoLayout.setVerticalGroup(
            panFormaDePagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfId)
                            .addComponent(tfTotal)
                            .addComponent(ddVendedor, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ddCliente, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 141, Short.MAX_VALUE)
                                .addComponent(editarItemsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(crearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buscarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(eliminarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ddFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panFormaDePago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(ddEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(58, 58, 58)
                        .addComponent(jScrollPane4)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ddVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(ddCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ddEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(ddFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panFormaDePago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(crearButton)
                    .addComponent(buscarButton)
                    .addComponent(eliminarButton)
                    .addComponent(editarItemsButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void crearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_crearButtonActionPerformed

    private void buscarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarButtonActionPerformed
        /*
        private Cliente cliente;
    private Vendedor vendedor;
    private String id;
    private PedidoDetalle pedidoDetalle;
    private FormaDePago formaDePago;
    private double total;
    private EstadoPedido estado;
    private List<Observador> observadores = new ArrayList<>();*/

        Pedido pedido = pedidoController.buscarYDevolverPedido(tfId.getText());

        if (pedido == null) {
            JOptionPane.showMessageDialog(null, "pedido no encontrado.");
            return;
        }

        ddVendedor.setSelectedItem(pedido.getVendedor().getId() + " - " + pedido.getVendedor().getNombre());
        ddCliente.setSelectedItem(pedido.getCliente().getId() + " - " + pedido.getCliente().getNombre());

        ddEstado.setSelectedItem(pedido.getEstado().toString());

        if (pedido.getFormaDePago() instanceof MercadoPago) {
            MercadoPago mp = (MercadoPago) pedido.getFormaDePago();
            showMp();
            tfFormaPago1.setText(mp.getAlias());
            ddFormaPago.setSelectedIndex(0);
            ddFormaPago.setSelectedIndex(0);
        } else {
            Transferencia tr = (Transferencia) pedido.getFormaDePago();
            showTransferencia();
            tfFormaPago1.setText(tr.getCuit());
            tfFormaPago2.setText(tr.getCvu());
            ddFormaPago.setSelectedIndex(1);
        }

        tfTotal.setText(pedido.getTotal() + "");
        
        updateTable(pedido.getItems());


    }//GEN-LAST:event_buscarButtonActionPerformed

    private void tfIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdActionPerformed

    private void ddClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ddClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ddClienteActionPerformed

    private void editarItemsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarItemsButtonActionPerformed
        itemsFrame.setVisible(true);
    }//GEN-LAST:event_editarItemsButtonActionPerformed

    private void ddVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ddVendedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ddVendedorActionPerformed

    private void ddEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ddEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ddEstadoActionPerformed

    private void ddFormaPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ddFormaPagoActionPerformed
        if (ddFormaPago.getSelectedIndex() == 0) {//mercadoPago
            showMp();
        } else {
            showTransferencia();
        }
    }//GEN-LAST:event_ddFormaPagoActionPerformed

    private void btnAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddItemActionPerformed

    private void actualizarTabla() {
        List<Pedido> pedidos = pedidoController.obtenerListaPedidos();

        String[] columnNames = {"Cliente", "Vendedor", "id", "forma de pago", "estado"};
        Object[][] data = new Object[pedidos.size()][5];

        for (int i = 0; i < pedidos.size(); i++) {
            data[i][0] = "cliente";
            data[i][1] = "vendedor";
            data[i][2] = "" + i;
            data[i][3] = "mp";
            data[i][4] = "pendiente";
        }

        jTable3.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddItem;
    private javax.swing.JButton btnRemoveItem;
    private javax.swing.JButton buscarButton;
    private javax.swing.JButton crearButton;
    private javax.swing.JComboBox<String> ddCliente;
    private javax.swing.JComboBox<String> ddEstado;
    private javax.swing.JComboBox<String> ddFormaPago;
    private javax.swing.JComboBox<String> ddVendedor;
    private javax.swing.JButton editarItemsButton;
    private javax.swing.JButton eliminarButton;
    private javax.swing.JFrame itemsFrame;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable3;
    private javax.swing.JList<String> listItems;
    private javax.swing.JPanel panFormaDePago;
    private javax.swing.JTable tableItems;
    private javax.swing.JTextField tfAddItem;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfTotal;
    // End of variables declaration//GEN-END:variables
}
