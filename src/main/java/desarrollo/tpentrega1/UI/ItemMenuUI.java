package desarrollo.tpentrega1.UI;

import desarrollo.tpentrega1.controllers.ItemsMenuController;
import desarrollo.tpentrega1.controllers.VendedorController;
import desarrollo.tpentrega1.entidades.Bebida;
import desarrollo.tpentrega1.entidades.ItemMenu;
import desarrollo.tpentrega1.entidades.Plato;
import desarrollo.tpentrega1.entidades.Vendedor;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import javax.swing.table.JTableHeader;

public class ItemMenuUI extends JPanel {

    private JTextField txtId, txtNombre, txtDescripcion, txtPrecio;
//    private JTextField txtCalorias, txtPeso, txtGraduacionAlcoholica, txtTamaño;
    private JButton btnCrear, btnBuscar, btnEditar, btnEliminar;
    private JRadioButton rbtnPlato, rbtnBebida;
    private JTable tableBebida, tablePlato;
    private JComboBox<String> ddIdVendedor;

    private ItemsMenuController itemsMenuController;
    private VendedorController vendedorController;
    private ItemType cardPanel;

    public ItemMenuUI(ItemsMenuController itemsMenuController, VendedorController vendedorController) {
        this.itemsMenuController = itemsMenuController;
        this.vendedorController = vendedorController;

        JLabel lblId = new JLabel("ID:");
        JLabel lblNombre = new JLabel("Nombre:");
        JLabel lblDescripcion = new JLabel("Descripcion:");
        JLabel lblPrecio = new JLabel("Precio:");
        JLabel lblIdVendedor = new JLabel("idVendedor:");
        JLabel lblCategoria = new JLabel("Categoria:");

        //para comida
        JLabel calorias = new JLabel("Calorias:");
        JLabel peso = new JLabel("Peso:");
        JLabel aptoCeliacosLabel = new JLabel("Apto Celiacos:");
        JLabel aptoVeganosLabel = new JLabel("Apto Veganos:");
        //para bebida
        JLabel graduacion = new JLabel("Graduacion Alcoholica:");
        JLabel tamaño = new JLabel("Tamaño:");

        txtId = new JTextField(20);
        txtNombre = new JTextField(20);
        txtDescripcion = new JTextField(20);
        txtPrecio = new JTextField(20);
        ddIdVendedor = new JComboBox();

        btnCrear = new JButton("Crear");
        btnBuscar = new JButton("Buscar");
        btnEditar = new JButton("Editar");
        btnEliminar = new JButton("Eliminar");
        rbtnBebida = new JRadioButton("Bebida");
        rbtnPlato = new JRadioButton("Plato");
        ButtonGroup categorias = new ButtonGroup();
        categorias.add(rbtnBebida);
        categorias.add(rbtnPlato);

        rbtnPlato.setSelected(true);
        rbtnBebida.setSelected(false);

        cardPanel = new ItemType();

        rbtnBebida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardPanel.mostrarBebida();
            }
        });
        rbtnPlato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardPanel.mostrarPlato();
            }
        });

        tableBebida = new JTable();
        tableBebida.setName("tableBebida");
        tablePlato = new JTable();
        actualizarTabla(tableBebida, null);
        tableBebida.setRowHeight(40);
        JTableHeader tableHeaderB = tableBebida.getTableHeader();
        actualizarTabla(tablePlato, null);
        tablePlato.setRowHeight(40);
        JTableHeader tableHeaderP = tablePlato.getTableHeader();

        JPanel tablePanelB = new JPanel();
        tablePanelB.setLayout(new BoxLayout(tablePanelB, BoxLayout.Y_AXIS));
        tablePanelB.add(tableHeaderB);
        tablePanelB.add(tableBebida);
        JPanel tablePanelP = new JPanel();
        tablePanelP.setLayout(new BoxLayout(tablePanelP, BoxLayout.Y_AXIS));
        tablePanelP.add(tableHeaderP);
        tablePanelP.add(tablePlato);

        this.setBackground(new Color(130, 217, 217));

        GroupLayout layout = new GroupLayout(this);
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
                                .addComponent(lblIdVendedor)
                                .addComponent(lblCategoria))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(txtId)
                                .addComponent(txtNombre)
                                .addComponent(txtDescripcion)
                                .addComponent(txtPrecio)
                                .addComponent(ddIdVendedor)
                                .addGroup(layout.createSequentialGroup().addComponent(rbtnBebida).addComponent(rbtnPlato))
                                // Establece el tamaño preferido de cardPanel
                                .addComponent(cardPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnCrear)
                                        .addComponent(btnBuscar)
                                        .addComponent(btnEditar)
                                        .addComponent(btnEliminar))))
                .addComponent(tablePanelB)
                .addComponent(tablePanelP)
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
                                .addComponent(lblIdVendedor)
                                .addComponent(ddIdVendedor))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lblCategoria)
                                .addComponent(rbtnBebida)
                                .addComponent(rbtnPlato))
                        // Ajusta cardPanel a tamaño preferido
                        .addComponent(cardPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(btnCrear)
                                .addComponent(btnBuscar)
                                .addComponent(btnEditar)
                                .addComponent(btnEliminar))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tablePanelB)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tablePanelP)
        );
        update();
        configurarAcciones();
    }

    public void update() {
        List<Vendedor> vendedores = vendedorController.obtenerListaVendedores();
        if (vendedores.size() == 0) {
            setUIEnable(false);
            return;
        }
        setUIEnable(true);

        ddIdVendedor.setMaximumRowCount(2);
        for (Vendedor v : vendedores) {
            ddIdVendedor.addItem(v.getNombre());
        }
        cardPanel.resetAptoCeliacos();
        cardPanel.resetAptoVegano();
        cardPanel.resetCalorias();
        cardPanel.resetGraduacionAlcoholica();
        cardPanel.resetPeso();
        cardPanel.resetTamaño();

    }

    private void setUIEnable(boolean e) {
        /*private JTextField txtId, txtNombre, txtDescripcion, txtPrecio;
    private JTextField txtCalorias, txtPeso, txtGraduacionAlcoholica, txtTamaño;
    private JButton btnCrear, btnBuscar, btnEditar, btnEliminar;
    private JRadioButton rbtnPlato, rbtnBebida;
    private JTable tableBebida, tablePlato;
    private JComboBox<String> ddIdVendedor;
         */

        txtId.setEnabled(e);
        txtNombre.setEnabled(e);
        txtDescripcion.setEnabled(e);
        txtPrecio.setEnabled(e);
        cardPanel.setUIEnable(e);
        rbtnPlato.setEnabled(e);
        rbtnBebida.setEnabled(e);
        btnCrear.setEnabled(e);
        btnEditar.setEnabled(e);
        btnBuscar.setEnabled(e);
        btnEliminar.setEnabled(e);
        ddIdVendedor.setEnabled(e);
    }

    private void configurarAcciones() {
        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = txtId.getText();
                String nombre = txtNombre.getText();
                String descripcion = txtDescripcion.getText();
                double precio = Double.parseDouble(txtPrecio.getText());
                Vendedor vendedor = vendedorController.obtenerListaVendedores().get(ddIdVendedor.getSelectedIndex());

                String categoria = "";  // ??? FIXME:

                if (rbtnPlato.isSelected()) {
                    double calorias = cardPanel.getCalorias();
                    boolean aptoCeliaco = cardPanel.getAptoCeliaco();
                    boolean aptoVegano = cardPanel.getAptoVegano();
                    double peso = cardPanel.getPeso();
                    
                    System.out.println("cel: " + aptoCeliaco);
                    System.out.println("veg: " + aptoVegano);

                    // TODO: add vendedor
                    Plato plato = itemsMenuController.crearNuevoItem(nombre, descripcion, precio, categoria,
                            calorias, aptoCeliaco, aptoVegano, peso);
                    vendedor.addItemMenu(plato);

                    System.out.println(plato.toString());
                } else {
                    double tamaño = cardPanel.getTamaño();
                    double graduacionAlcoholica = cardPanel.getGraduacionAlcoholica();
                    // TODO: add vendedor
                    Bebida bebida = itemsMenuController.crearNuevaBebida(id, nombre, descripcion, precio, categoria, vendedor,
                            tamaño, graduacionAlcoholica);

                    System.out.println(bebida.toString());
                }
                txtId.setText("");
                txtNombre.setText("");
                txtDescripcion.setText("");
                txtPrecio.setText("");

                cardPanel.resetCalorias();
                cardPanel.resetGraduacionAlcoholica();
                cardPanel.resetPeso();
                cardPanel.resetTamaño();
                cardPanel.resetAptoCeliacos();
                cardPanel.resetAptoVegano();

            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = txtId.getText();
                ItemMenu itemMenu = itemsMenuController.buscarItemsMenu(id);
                if (itemMenu != null) {
                    ItemMenu item = itemsMenuController.buscarItemsMenu(id);

                    txtId.setText(id);
                    txtNombre.setText(item.getNombre());
                    txtDescripcion.setText(item.getDescripcion());
                    txtPrecio.setText(item.getPrecio() + "");
                    List<Vendedor> vendedores = vendedorController.obtenerListaVendedores();
                    for (int i = 0; i < vendedores.size(); i++) {
                        if (vendedores.get(i).getItemsMenu().contains(item)) {
                            ddIdVendedor.setSelectedIndex(i);
                        }
                    }
                    if (item instanceof Bebida) {

                        rbtnBebida.setSelected(true);
                        rbtnPlato.setSelected(false);

                        cardPanel.mostrarBebida();

                        cardPanel.setTamaño(((Bebida) item).getTamaño());
                        cardPanel.setGraduacionAlcoholica(((Bebida) item).getGraduacionAlcoholica());

                        actualizarTabla(tableBebida, item);
                        actualizarTabla(tablePlato, null);
                    } else {
                        txtId.setText(id);
                        txtNombre.setText(item.getNombre());
                        txtDescripcion.setText(item.getDescripcion());
                        txtPrecio.setText(item.getPrecio() + "");

                        rbtnBebida.setSelected(true);
                        rbtnPlato.setSelected(false);

                        cardPanel.mostrarPlato();

                        cardPanel.setCalorias(((Plato) item).getCalorias());
                        cardPanel.setAptoVegano(((Plato) item).aptoVegano());
                        cardPanel.setAptoCeliaco(((Plato) item).aptoCeliaco());
                        cardPanel.setPeso(((Plato) item).peso());

                        actualizarTabla(tableBebida, null);
                        actualizarTabla(tablePlato, item);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Item no encontrado.");
                    actualizarTabla(tablePlato, null);
                    actualizarTabla(tableBebida, null);
                    txtId.setText("");
                    txtNombre.setText("");
                    txtDescripcion.setText("");
                    txtPrecio.setText("");

                    cardPanel.resetAptoCeliacos();
                    cardPanel.resetAptoVegano();
                    cardPanel.resetCalorias();
                    cardPanel.resetGraduacionAlcoholica();
                    cardPanel.resetPeso();
                    cardPanel.resetTamaño();

                }
            }
        });

        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = txtId.getText();
                String nombre = txtNombre.getText();
                String descripcion = txtDescripcion.getText();
                double precio = Double.parseDouble(txtPrecio.getText());

                ItemMenu item = itemsMenuController.buscarItemsMenu(id);

                item.setId(id);
                item.setNombre(nombre);
                item.setPrecio(precio);

                if (rbtnPlato.isSelected()) {
                    Plato plato = (Plato) item;
                    plato.setAptoCeliaco(cardPanel.getAptoCeliaco());
                    plato.setAptoVegano(cardPanel.getAptoVegano());
                    plato.setCalorias(cardPanel.getCalorias());

                    itemsMenuController.modificarPlato(plato);
                } else {
                    Bebida bebida = (Bebida) item;
                    bebida.setGraduacionAlcoholica(cardPanel.getGraduacionAlcoholica());
                    bebida.setTamaño(cardPanel.getTamaño());

                    itemsMenuController.modificarBebida(bebida);
                }
//                itemsMenuController.modificarItemsMenu(id, nombre, descripcion, precio, nombre);

                if (item instanceof Bebida) {
                    actualizarTabla(tableBebida, item);
                    actualizarTabla(tablePlato, null);
                } else {
                    actualizarTabla(tableBebida, null);
                    actualizarTabla(tablePlato, item);
                }
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
                ItemMenu item = itemsMenuController.buscarItemsMenu(id);
                if (item instanceof Bebida) {
                    actualizarTabla(tablePlato, null);
                    actualizarTabla(tableBebida, item);
                } else {
                    actualizarTabla(tableBebida, null);
                    actualizarTabla(tablePlato, item);
                }
                itemsMenuController.eliminarItemsMenu(item);
                txtId.setText("");
                txtNombre.setText("");
                txtDescripcion.setText("");
                txtPrecio.setText("");
            }

        });
    }

    private void actualizarTabla(JTable tabla, ItemMenu item) {
        if (item == null) {
            if ("tableBebida".equals(tabla.getName())) {
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
            } else {
                String[] columnNamesPlato = {"ID", "Nombre", "Descripcion", "Precio",
                    "Calorias", "Apto Celiacos", "Apto Veganos", "Peso"};

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
        } else if (item instanceof Bebida) {
            String[] columnNamesBebida = {"ID", "Nombre", "Descripcion", "Precio",
                "Graduacion Alcoholica", "Tamaño"};

            Object[][] data = new Object[1][6];
            data[0][0] = item.getId();
            data[0][1] = item.getNombre();
            data[0][2] = item.getDescripcion();
            data[0][3] = item.getPrecio();
            data[0][4] = ((Bebida) item).getGraduacionAlcoholica();
            data[0][5] = ((Bebida) item).getTamaño();
            tabla.setModel(new javax.swing.table.DefaultTableModel(data, columnNamesBebida));
        } else {
            String[] columnNamesPlato = {"ID", "Nombre", "Descripcion", "Precio",
                "Calorias", "Apto Celiacos", "Apto Veganos", "Peso"};

            Object[][] data = new Object[1][8];
            data[0][0] = item.getId();
            data[0][1] = item.getNombre();
            data[0][2] = item.getDescripcion();
            data[0][3] = item.getPrecio();
            data[0][4] = ((Plato) item).getCalorias();
            data[0][5] = ((Plato) item).aptoCeliaco();
            data[0][6] = ((Plato) item).aptoVegano();
            data[0][7] = ((Plato) item).peso();

            tabla.setModel(new javax.swing.table.DefaultTableModel(data, columnNamesPlato));
        }

    }
}
