package desarrollo.tpentrega1.UI;

import desarrollo.tpentrega1.controllers.ItemsMenuController;
import desarrollo.tpentrega1.entidades.Bebida;
import desarrollo.tpentrega1.entidades.ItemMenu;
import desarrollo.tpentrega1.entidades.Plato;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.JTableHeader;

public class ItemMenuUI extends JPanel {

    private JTextField txtId, txtNombre, txtDescripcion, txtPrecio, txtIdVendedor;
    private JTextField txtCalorias, txtPeso, txtGraduacionAlcoholica, txtTamaño;
    private JButton btnCrear, btnBuscar, btnEditar, btnEliminar;
    private JRadioButton rbtnPlato, rbtnBebida;
    private JTable tableBebida, tablePlato;
    private ItemsMenuController itemsMenuController;
    private ItemType cardPanel;

    public ItemMenuUI(ItemsMenuController itemsMenuController) {
        this.itemsMenuController = itemsMenuController;

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
        txtIdVendedor = new JTextField(20);

        //para comida
        JTextField txtCalorias = new JTextField(3);
        JTextField txtPeso = new JTextField(3);
        //para bebida
        JTextField txtGraduacion = new JTextField(3);
        JTextField txtTamaño = new JTextField(3);

        //para comida
        JCheckBox ApCeCheckBox = new JCheckBox();
        JCheckBox ApVeCheckBox = new JCheckBox();

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
                                .addComponent(txtIdVendedor)
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
                                .addComponent(txtIdVendedor))
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

        configurarAcciones();
    }

    private void configurarAcciones() {
        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = txtId.getText();
                String nombre = txtNombre.getText();
                String descripcion = txtDescripcion.getText();
                double precio = Double.parseDouble(txtPrecio.getText());
                String idVendedor = txtIdVendedor.getText();

                txtId.setText("");
                txtNombre.setText("");
                txtDescripcion.setText("");
                txtPrecio.setText("");
                txtIdVendedor.setText("");

                cardPanel.resetCalorias();
                cardPanel.resetGraduacionAlcoholica();
                cardPanel.resetPeso();
                cardPanel.resetTamaño();
                cardPanel.resetAptoCeliacos();
                cardPanel.resetAptoVegano();

                String categoria = "";  // ??? FIXME:

                if (rbtnPlato.isSelected()) {
                    double calorias = cardPanel.getCalorias();
                    boolean aptoCeliaco = cardPanel.getAptoCeliaco();
                    boolean aptoVegano = cardPanel.getAptoVegano();
                    double peso = cardPanel.getPeso();

                    // TODO: add vendedor
                    itemsMenuController.crearNuevoPlato(id, nombre, descripcion, precio, categoria,
                            calorias, aptoCeliaco, aptoVegano, peso);;
//                    itemsMenuController.crearNuevoPlato(id, nombre, descripcion, precio, categoria, idVendedor, 
//                            calorias, aptoCeliaco, aptoVegano, peso);
                } else {
                    double tamaño = cardPanel.getTamaño();
                    double graduacionAlcoholica = cardPanel.getGraduacionAlcoholica();
                    // TODO: add vendedor
                    itemsMenuController.crearNuevaBebida(id, nombre, descripcion, precio, categoria,
                            tamaño, graduacionAlcoholica);
//                    itemsMenuController.crearNuevaBebida(id, nombre, descripcion, precio, categoria, idVendedor, 
//                            tamaño, graduacionAlcoholica);
                }

            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = txtId.getText();
                ItemMenu itemMenu = itemsMenuController.buscarItemsMenu(id);
                if (itemMenu != null) {
                    ItemMenu item = itemsMenuController.buscarItemsMenu(id);

                    if (item instanceof Bebida) {
                        txtId.setText(id);
                        txtNombre.setText(item.getNombre());
                        txtDescripcion.setText(item.getDescripcion());
                        txtPrecio.setText(item.getPrecio() + "");

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
                itemsMenuController.eliminarItemsMenu(id);
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
