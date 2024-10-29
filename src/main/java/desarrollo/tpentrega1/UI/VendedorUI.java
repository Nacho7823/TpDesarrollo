package desarrollo.tpentrega1.UI;

import desarrollo.tpentrega1.entidades.Coordenada;
import desarrollo.tpentrega1.entidades.Vendedor;
import desarrollo.tpentrega1.controllers.VendedorController;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VendedorUI extends JFrame {
    private JTextField txtId, txtNombre, txtDireccion, txtLatitud, txtLongitud;
    private JButton btnCrear, btnBuscar, btnEditar, btnEliminar;
    private JTable tableVendedores;
    private VendedorController vendedorController;

    public VendedorUI(VendedorController vendedorController) {
        this.vendedorController = vendedorController;
        setTitle("Gestión de Vendedores");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear los componentes
        JLabel lblId = new JLabel("ID:");
        JLabel lblNombre = new JLabel("Nombre:");
        JLabel lblDireccion = new JLabel("Dirección:");
        JLabel lblLatitud = new JLabel("Latitud:");
        JLabel lblLongitud = new JLabel("Longitud:");

        txtId = new JTextField(20);
        txtNombre = new JTextField(20);
        txtDireccion = new JTextField(20);
        txtLatitud = new JTextField(20);
        txtLongitud = new JTextField(20);

        btnCrear = new JButton("Crear");
        btnBuscar = new JButton("Buscar");
        btnEditar = new JButton("Editar");
        btnEliminar = new JButton("Eliminar");

        // Inicializar tabla
        tableVendedores = new JTable();
        actualizarTabla();

        JScrollPane scrollPane = new JScrollPane(tableVendedores);

        // Layout de la ventana principal usando GroupLayout
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(lblId)
                .addComponent(lblNombre)
                .addComponent(lblDireccion)
                .addComponent(lblLatitud)
                .addComponent(lblLongitud))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(txtId)
                .addComponent(txtNombre)
                .addComponent(txtDireccion)
                .addComponent(txtLatitud)
                .addComponent(txtLongitud)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(btnCrear)
                    .addComponent(btnBuscar)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar)))
            .addComponent(scrollPane)
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblId)
                .addComponent(txtId))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblNombre)
                .addComponent(txtNombre))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblDireccion)
                .addComponent(txtDireccion))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblLatitud)
                .addComponent(txtLatitud))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblLongitud)
                .addComponent(txtLongitud))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(btnCrear)
                .addComponent(btnBuscar)
                .addComponent(btnEditar)
                .addComponent(btnEliminar))
            .addComponent(scrollPane)
        );

        add(panel);
        configurarAcciones();
    }

    private void configurarAcciones() {
        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String direccion = txtDireccion.getText();
                double lat = Double.parseDouble(txtLatitud.getText());
                double lng = Double.parseDouble(txtLongitud.getText());

                Coordenada coordenada = new Coordenada(lat, lng);
                vendedorController.crearNuevoVendedor(nombre, direccion, coordenada);
                actualizarTabla();
            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = txtId.getText();
                Vendedor vendedor = vendedorController.buscarVendedor(Integer.parseInt(id));
                if (vendedor != null) {
                    txtNombre.setText(vendedor.getNombre());
                    txtDireccion.setText(vendedor.getDireccion());
                    txtLatitud.setText(String.valueOf(vendedor.getCoordenada().getLat()));
                    txtLongitud.setText(String.valueOf(vendedor.getCoordenada().getLng()));
                } else {
                    JOptionPane.showMessageDialog(null, "Vendedor no encontrado.");
                }
            }
        });

        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = txtId.getText();
                String nombre = txtNombre.getText();
                String direccion = txtDireccion.getText();
                double lat = Double.parseDouble(txtLatitud.getText());
                double lng = Double.parseDouble(txtLongitud.getText());

                Coordenada coordenada = new Coordenada(lat, lng);
                vendedorController.modificarVendedor(id, nombre, direccion, coordenada);
                actualizarTabla();
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = txtId.getText();
                vendedorController.eliminarVendedor(Integer.parseInt(id));
                actualizarTabla();
            }
        });
    }

    private void actualizarTabla() {
        List<Vendedor> vendedores = vendedorController.obtenerListaVendedores();
        String[] columnNames = {"ID", "Nombre", "Dirección", "Latitud", "Longitud"};
        Object[][] data = new Object[vendedores.size()][5];
        for (int i = 0; i < vendedores.size(); i++) {
            Vendedor v = vendedores.get(i);
            data[i][0] = v.getId();
            data[i][1] = v.getNombre();
            data[i][2] = v.getDireccion();
            data[i][3] = v.getCoordenada().getLat();
            data[i][4] = v.getCoordenada().getLng();
        }
        tableVendedores.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    }
}

