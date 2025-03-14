package desarrollo.tpentrega1.UI;

import desarrollo.tpentrega1.controllers.ClienteController;
import desarrollo.tpentrega1.controllers.ItemMenuController;
import desarrollo.tpentrega1.controllers.PedidoController;
import desarrollo.tpentrega1.controllers.VendedorController;
import desarrollo.tpentrega1.entidades.Bebida;
import desarrollo.tpentrega1.entidades.Cliente;
import desarrollo.tpentrega1.entidades.ItemMenu;
import desarrollo.tpentrega1.entidades.MercadoPago;
import desarrollo.tpentrega1.entidades.Pago;
import desarrollo.tpentrega1.entidades.Pedido;
import desarrollo.tpentrega1.entidades.Plato;
import desarrollo.tpentrega1.entidades.Transferencia;
import desarrollo.tpentrega1.entidades.Vendedor;
import desarrollo.tpentrega1.enums.EstadoPedido;
import desarrollo.tpentrega1.exceptions.DAOException;
import desarrollo.tpentrega1.exceptions.InvalidOrderException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PedidoUI extends javax.swing.JPanel {

    private VendedorController vendedorController = VendedorController.getInstance();
    private ClienteController clienteController = ClienteController.getInstance();
    private PedidoController pedidoController = PedidoController.getInstance();
    private ItemMenuController itemsMenuController = ItemMenuController.getInstance();
    private Pedido pedido;


    private JTextField tfFormaPago1;
    private JTextField tfFormaPago2;
    private boolean mostrandoTransferencia = false;

    public PedidoUI() {
        initComponents();

        this.jTable3.setAutoResizeMode(5);

        ddEstado.addItem(EstadoPedido.RECIBIDO.toString());
        ddEstado.addItem(EstadoPedido.PROCESADO.toString());
        ddEstado.addItem(EstadoPedido.ENVIADO.toString());
        ddEstado.setMaximumRowCount(3);

        // FormaDePago
        tfFormaPago1 = new JTextField();
        tfFormaPago2 = new JTextField();
        panFormaDePago.setLayout(new BoxLayout(panFormaDePago, BoxLayout.X_AXIS));
        panFormaDePago.add(tfFormaPago1);

        ddEstado.setMaximumRowCount(2);
        ddFormaDePago.addItem("Transferencia (cuit, cvu)");
        ddFormaDePago.addItem("Mercado Pago (alias)");
        showTransferencia();

        update();

    }

    public void update() {
        ddCliente.removeAllItems();
        List<Cliente> listaClientes = clienteController.obtenerListaClientes();
        for (Cliente c : listaClientes) {
            ddCliente.addItem(c.getNombre());
        }
        ddCliente.setMaximumRowCount(listaClientes.size());

        ddVendedor.removeAllItems();
        List<Vendedor> listaVendedores = vendedorController.obtenerListaVendedores();
        for (Vendedor v : listaVendedores) {
            ddVendedor.addItem(v.getNombre());
        }
        ddVendedor.setMaximumRowCount(listaVendedores.size());

        if (listaClientes.size() > 0 && listaVendedores.size() > 0) {
            try {
                pedido = new Pedido("",
                        listaClientes.get(0),
                        listaVendedores.get(0),
                        new ArrayList<>(),
                        new Transferencia("", "", 0),
                        EstadoPedido.ENVIADO);
                updateAll(pedido);

            } catch (InvalidOrderException ex) {
                setUIEnable(false);
            }
        } else {
            setUIEnable(false);
        }
    }

    private void setUIEnable(boolean e) {
        tfId.setEnabled(e);
        ddCliente.setEnabled(e);
        ddVendedor.setEnabled(e);
        ddEstado.setEnabled(e);
        ddFormaDePago.setEnabled(e);
        tfFormaPago1.setEnabled(e);
        tfFormaPago2.setEnabled(e);
        tableCurrentItems.setEnabled(e);
        btnAgregarItems.setEnabled(e);
        btnEliminarItems.setEnabled(e);
        btnCrear.setEnabled(e);
        btnEditar.setEnabled(e);
        btnBuscar.setEnabled(e);
        btnEliminar.setEnabled(e);
    }

    private void showMp() {
        if (mostrandoTransferencia) {
            panFormaDePago.remove(tfFormaPago2);
            mostrandoTransferencia = false;
            panFormaDePago.revalidate();
            panFormaDePago.repaint();
            tfFormaPago1.setText("");
            tfFormaPago2.setText("");
        }
    }

    private void showTransferencia() {
        if (!mostrandoTransferencia) {
            panFormaDePago.add(tfFormaPago2);
            mostrandoTransferencia = true;
            panFormaDePago.revalidate();
            panFormaDePago.repaint();
            tfFormaPago1.setText("");
            tfFormaPago2.setText("");
        }

    }

    private void updateAll(Pedido pedido) {
        tfId.setText(pedido.getId());
        ddCliente.setSelectedItem(pedido.getCliente());
        ddVendedor.setSelectedItem(pedido.getVendedor());
        ddEstado.setSelectedItem(pedido.getEstado().toString());

        if (pedido.getPago() instanceof Transferencia) {
            Transferencia t = (Transferencia) pedido.getPago();
            showTransferencia();
            tfFormaPago1.setText(t.getCuit());
            tfFormaPago2.setText(t.getCvu());
        } else {
            MercadoPago t = (MercadoPago) pedido.getPago();
            showMp();
            tfFormaPago1.setText(t.getAlias());
        }
        tfTotal.setText(pedido.getTotal() + "");

        updateCurrentTable(pedido.getItems());
        
        //updateAddTable(pedido.getVendedor().getItemsMenu());
        
        updateAddTable();

    }

    private void updateCurrentTable(List<ItemMenu> items) {
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
//            data[i][5] = item.getVendedor().getNombre();
            data[i][5] = "";

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
        tableCurrentItems.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));

    }
/*
    private List<ItemMenu> obtenerFaltantes(Pedido pedido) {
        List<ItemMenu> vitems = pedido.getVendedor().getItemsMenu();
        ArrayList<ItemMenu> faltantes = new ArrayList<>();

        for (ItemMenu it : vitems) {
            if (!pedido.getItems().contains(it)) {
                faltantes.add(it);
            }
        }
        return faltantes;
    }
*/
    private void updateAddTable() {

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
        Vendedor vendedor = pedido.getVendedor();
        List<ItemMenu> items = itemsMenuController.obtenerItemMenusDeVendedor(vendedor.getId());
        Object[][] data = new Object[items.size()][12];
        for (int i = 0; i < items.size(); i++) {
            ItemMenu item = items.get(i);
            data[i][0] = item.getId();
            data[i][1] = item.getNombre();
            data[i][2] = item.getDescripcion();
            data[i][3] = item.getPrecio() + "";
            data[i][4] = item.getCategoria();
            data[i][5] = vendedor.getNombre();
            data[i][5] = "";

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
        tableAddItems.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    }
    
    private Pedido clonarPedido(Pedido p) {
        Pago formaDePago;
        if (p.getPago() instanceof Transferencia){
            Transferencia t = (Transferencia) p.getPago();
            formaDePago = new Transferencia(t.getCuit() + "", t.getCvu() + "", t.getMonto());
        }
        else {
            MercadoPago t = (MercadoPago) p.getPago();
            formaDePago = new MercadoPago(t.getAlias() + "", t.getMonto());
        }
        try {
            Pedido p1 = new Pedido(p.getId() + "",
                    p.getCliente(),
                    p.getVendedor(),
                    new ArrayList<>(p.getItems()),
                    formaDePago,
                    p.getEstado());
            
            return p1;
        } catch (InvalidOrderException ex) {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        itemsFrame = new javax.swing.JFrame();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableAddItems = new javax.swing.JTable();
        btnAddSelectedItem = new javax.swing.JButton();
        lbId = new javax.swing.JLabel();
        lbCliente = new javax.swing.JLabel();
        lbVendedor = new javax.swing.JLabel();
        lbEstado = new javax.swing.JLabel();
        lbFormaDePago = new javax.swing.JLabel();
        lbTotal = new javax.swing.JLabel();
        lbItems = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        ddCliente = new javax.swing.JComboBox<>();
        ddVendedor = new javax.swing.JComboBox<>();
        ddEstado = new javax.swing.JComboBox<>();
        ddFormaDePago = new javax.swing.JComboBox<>();
        panFormaDePago = new javax.swing.JPanel();
        tfTotal = new javax.swing.JTextField();
        btnCrear = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        btnEliminarItems = new javax.swing.JButton();
        btnAgregarItems = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableCurrentItems = new javax.swing.JTable();

        itemsFrame.setLocationByPlatform(true);
        itemsFrame.setSize(new java.awt.Dimension(400, 400));
        itemsFrame.setType(java.awt.Window.Type.POPUP);

        tableAddItems.setModel(new javax.swing.table.DefaultTableModel(
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
        tableAddItems.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(tableAddItems);

        btnAddSelectedItem.setText("Aceptar");
        btnAddSelectedItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSelectedItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout itemsFrameLayout = new javax.swing.GroupLayout(itemsFrame.getContentPane());
        itemsFrame.getContentPane().setLayout(itemsFrameLayout);
        itemsFrameLayout.setHorizontalGroup(
            itemsFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itemsFrameLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddSelectedItem)
                .addContainerGap())
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
        );
        itemsFrameLayout.setVerticalGroup(
            itemsFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itemsFrameLayout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAddSelectedItem)
                .addContainerGap())
        );

        setBackground(new java.awt.Color(224, 240, 254));

        lbId.setText("ID:");

        lbCliente.setText("Cliente:");

        lbVendedor.setText("Vendedor:");

        lbEstado.setText("Estado:");

        lbFormaDePago.setText("Forma de Pago:");

        lbTotal.setText("Total:");

        lbItems.setText("Items:");

        tfId.setToolTipText("");
        tfId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdActionPerformed(evt);
            }
        });

        ddCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        ddCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ddClienteActionPerformed(evt);
            }
        });

        ddVendedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        ddVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ddVendedorActionPerformed(evt);
            }
        });

        ddEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        ddEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ddEstadoActionPerformed(evt);
            }
        });

        ddFormaDePago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        ddFormaDePago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ddFormaDePagoActionPerformed(evt);
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

        tfTotal.setEditable(false);

        btnCrear.setBackground(new java.awt.Color(100, 180, 255));
        btnCrear.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        btnCrear.setForeground(new java.awt.Color(224, 240, 254));
        btnCrear.setText("Crear");
        btnCrear.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(100, 180, 255));
        btnEditar.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(224, 240, 254));
        btnEditar.setText("Editar");
        btnEditar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(100, 180, 255));
        btnBuscar.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(224, 240, 254));
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(100, 180, 255));
        btnEliminar.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(224, 240, 254));
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
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

        btnEliminarItems.setBackground(new java.awt.Color(100, 180, 255));
        btnEliminarItems.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        btnEliminarItems.setForeground(new java.awt.Color(224, 240, 254));
        btnEliminarItems.setText("Eliminar");
        btnEliminarItems.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEliminarItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarItemsActionPerformed(evt);
            }
        });

        btnAgregarItems.setBackground(new java.awt.Color(100, 180, 255));
        btnAgregarItems.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        btnAgregarItems.setForeground(new java.awt.Color(224, 240, 254));
        btnAgregarItems.setText("Agregar");
        btnAgregarItems.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregarItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarItemsActionPerformed(evt);
            }
        });

        tableCurrentItems.setModel(new javax.swing.table.DefaultTableModel(
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
        tableCurrentItems.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(tableCurrentItems);

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
                            .addComponent(lbId)
                            .addComponent(lbVendedor)
                            .addComponent(lbEstado)
                            .addComponent(lbItems)
                            .addComponent(lbFormaDePago)
                            .addComponent(lbCliente)
                            .addComponent(lbTotal))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfId)
                                    .addComponent(ddCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ddFormaDePago, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(panFormaDePago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnEliminarItems, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnAgregarItems, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(tfTotal)
                                    .addComponent(ddEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ddVendedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCliente)
                    .addComponent(ddCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbVendedor)
                    .addComponent(ddVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEstado)
                    .addComponent(ddEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbFormaDePago)
                        .addComponent(ddFormaDePago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panFormaDePago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTotal)
                    .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarItems, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbItems)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEliminarItems, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrear)
                    .addComponent(btnBuscar)
                    .addComponent(btnEliminar)
                    .addComponent(btnEditar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddSelectedItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSelectedItemActionPerformed
int idx = tableAddItems.getSelectedRow();

if (idx != -1) {
    List<ItemMenu> items = itemsMenuController.obtenerItemMenusDeVendedor(pedido.getVendedor().getId());
        ItemMenu it = items.get(idx);
        pedido.addItem(it);
        updateAll(pedido);
    }

    }//GEN-LAST:event_btnAddSelectedItemActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        
        
        try {
            // TODO: verify
            if (pedidoController.buscarPedido(tfId.getText()) != null){
                JOptionPane.showMessageDialog(null, "Un pedido ya contiene ese ID.");
                return;
            }
        } catch (DAOException ex) {
            Logger.getLogger(PedidoUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        pedido.setId(tfId.getText());
        
        int idx = ddCliente.getSelectedIndex();
        pedido.setCliente(clienteController.obtenerListaClientes().get(idx));
        
        idx = ddVendedor.getSelectedIndex();
        pedido.setVendedor(vendedorController.obtenerListaVendedores().get(idx));
        
        idx = ddEstado.getSelectedIndex();
        if (idx == 0)
            pedido.setEstado(EstadoPedido.RECIBIDO);
        else if (idx == 1)
            pedido.setEstado(EstadoPedido.PROCESADO);
        else if (idx == 2)
            pedido.setEstado(EstadoPedido.ENVIADO);
        
        if(mostrandoTransferencia) {
            String cuit = tfFormaPago1.getText();
            String cvu = tfFormaPago2.getText();
            // TODO: verify
            pedido.generarPago(cuit, cvu);
        }
        else {
            String alias = tfFormaPago1.getText();
            // TODO: verify
            pedido.generarPago(alias);
        }
        
        try {
            pedidoController.newPedido(tfId.getText(),
                    pedido.getCliente(),
                    pedido.getVendedor(),
                    pedido.getItems(),
                    (Pago) pedido.getPago(),
                    pedido.getEstado());
        } catch (DAOException ex) {
            Logger.getLogger(PedidoUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            actualizarTabla();
        } catch (DAOException ex) {
            Logger.getLogger(PedidoUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        Pedido p = null;
        try {
            p = pedidoController.buscarPedido(tfId.getText());
        } catch (DAOException ex) {
            Logger.getLogger(PedidoUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (p == null) {
            JOptionPane.showMessageDialog(null, "Pedido no encontrado.");

        } else {
            // clonar
            pedido = clonarPedido(p);
            
            updateAll(pedido);
        }


    }//GEN-LAST:event_btnBuscarActionPerformed

//    protected void actualizarVendedoresDropDown() {
//        int index = ddVendedor.getSelectedIndex();
//        ddVendedor.setSelectedIndex(0);
//        ddVendedor.removeAllItems();
//
//        List<Vendedor> listaVendedores = vendedorController.obtenerListaVendedores();
//        for (Vendedor v : listaVendedores) {
//            ddVendedor.addItem(v.getNombre());
//        }
//        ddVendedor.setSelectedIndex(index);
//    }
//
//    protected void actualizarClientesDropDown() {
//        int index = ddCliente.getSelectedIndex();
//        ddCliente.setSelectedIndex(0);
//        ddCliente.removeAllItems();
//
//        List<Cliente> listaClientes = clienteController.obtenerListaClientes();
//
//        for (Cliente c : listaClientes) {
//            ddCliente.addItem(c.getNombre());
//        }
//        ddCliente.setSelectedIndex(index);
//    }

    private void idFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idFieldActionPerformed

    private void ddVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ddVendedorActionPerformed
        if(pedido == null || ddVendedor.getSelectedIndex() == -1)
            return;
        List<Vendedor> listaVendedores = vendedorController.obtenerListaVendedores();
        if (!listaVendedores.get(ddVendedor.getSelectedIndex()).equals(pedido.getVendedor())){
            pedido.setVendedor(listaVendedores.get(ddVendedor.getSelectedIndex()));
            List<ItemMenu> lista = new ArrayList();
            pedido.setItems(lista);
            updateAll(pedido);
        }
    }//GEN-LAST:event_ddVendedorActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
//        itemsFrame.setVisible(true);
//        this.setTablasItems();
//        actualizarItems(getCantTabla());

        //this.bebidaTable.get
    }//GEN-LAST:event_btnEditarActionPerformed

    private void ddEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ddEstadoActionPerformed
        if (evt.getSource() == ddEstado) {

        }
    }//GEN-LAST:event_ddEstadoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (!(tfId.getText().equals(""))) {
            try {
                pedidoController.eliminarPedido(tfId.getText());
            } catch (DAOException ex) {
                Logger.getLogger(PedidoUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        update();
        try {
            actualizarTabla();
        } catch (DAOException ex) {
            Logger.getLogger(PedidoUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void ddClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ddClienteActionPerformed
        if(pedido == null || ddCliente.getSelectedIndex() == -1)
            return;
        List<Cliente> listaClientes = clienteController.obtenerListaClientes();
        if (!listaClientes.get(ddCliente.getSelectedIndex()).equals(pedido.getCliente())){
            pedido.setCliente(listaClientes.get(ddCliente.getSelectedIndex()));
            updateAll(pedido);
        }
    }//GEN-LAST:event_ddClienteActionPerformed

    private void ddFormaDePagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ddFormaDePagoActionPerformed
        if (ddFormaDePago.getSelectedIndex() == 0) // transferencia
            showTransferencia();
        else
            showMp();
    }//GEN-LAST:event_ddFormaDePagoActionPerformed

    private void btnEliminarItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarItemsActionPerformed
        int idx = tableCurrentItems.getSelectedRow();

        if (idx == -1) {
            return;
        }

        pedido.getItems().remove(idx);
        updateAll(pedido);
        itemsFrame.setVisible(false);

    }//GEN-LAST:event_btnEliminarItemsActionPerformed

    private void btnAgregarItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarItemsActionPerformed
        itemsFrame.setVisible(true);
    }//GEN-LAST:event_btnAgregarItemsActionPerformed

    private void tfIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdActionPerformed
        if (pedido == null)
            return;
        pedido.setId(tfId.getText());
    }//GEN-LAST:event_tfIdActionPerformed

    private void actualizarTabla() throws DAOException {
        List<Pedido> pedidos = pedidoController.obtenerListaPedidos();

        String[] columnNames = {"Id", "Cliente", "Vendedor", "Estado", "Forma de pago", "Total", "Items"};
        Object[][] data = new Object[pedidos.size()][7];
        for (int i = 0; i < pedidos.size(); i++) {
            List<String> items1 = new ArrayList();
            data[i][0] = pedidos.get(i).getId();
            data[i][1] = pedidos.get(i).getCliente();
            data[i][2] = pedidos.get(i).getVendedor().getNombre();
            data[i][3] = pedidos.get(i).getEstado().toString();
            data[i][4] = pedidos.get(i).getPago().getClass();
            data[i][5] = pedidos.get(i).getTotal();
            for (ItemMenu item : pedidos.get(i).getItems()) {
                items1.add(item.getNombre());
            }
            data[i][6] = items1;
        }
        jTable3.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddSelectedItem;
    private javax.swing.JButton btnAgregarItems;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminarItems;
    private javax.swing.JComboBox<String> ddCliente;
    private javax.swing.JComboBox<String> ddEstado;
    private javax.swing.JComboBox<String> ddFormaDePago;
    private javax.swing.JComboBox<String> ddVendedor;
    private javax.swing.JFrame itemsFrame;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable3;
    private javax.swing.JLabel lbCliente;
    private javax.swing.JLabel lbEstado;
    private javax.swing.JLabel lbFormaDePago;
    private javax.swing.JLabel lbId;
    private javax.swing.JLabel lbItems;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JLabel lbVendedor;
    private javax.swing.JPanel panFormaDePago;
    private javax.swing.JTable tableAddItems;
    private javax.swing.JTable tableCurrentItems;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfTotal;
    // End of variables declaration//GEN-END:variables
}
