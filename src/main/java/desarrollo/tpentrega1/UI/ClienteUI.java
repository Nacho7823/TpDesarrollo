package desarrollo.tpentrega1.UI;

import desarrollo.tpentrega1.entidades.Cliente;
import desarrollo.tpentrega1.entidades.Coordenada;
import desarrollo.tpentrega1.controllers.ClienteController;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ClienteUI extends JPanel {
    private JTextField txtId, txtNombre, txtCuit, txtEmail, txtDireccion, txtLatitud, txtLongitud;
    private JButton btnCrear, btnBuscar, btnEditar, btnEliminar;
    private JTable tableClientes;
    private ClienteController clienteController;

    public ClienteUI(ClienteController clienteController) {
        this.clienteController = clienteController;

        // Crear los componentes
        JLabel lblId = new JLabel("ID:");
        JLabel lblNombre = new JLabel("Nombre:");
        JLabel lblCuit = new JLabel("Cuit:");
        JLabel lblEmail = new JLabel("Email:");
        JLabel lblDireccion = new JLabel("Dirección:");
        JLabel lblLatitud = new JLabel("Latitud:");
        JLabel lblLongitud = new JLabel("Longitud:");

        txtId = new JTextField(20);
        txtNombre = new JTextField(20);
        txtCuit = new JTextField(20);
        txtEmail = new JTextField(20);
        txtDireccion = new JTextField(20);
        txtLatitud = new JTextField(20);
        txtLongitud = new JTextField(20);

        btnCrear = new JButton("Crear");
        btnBuscar = new JButton("Buscar");
        btnEditar = new JButton("Editar");
        btnEliminar = new JButton("Eliminar");

        // Inicializar tabla
        tableClientes = new JTable();
        actualizarTabla();

        JScrollPane scrollPane = new JScrollPane(tableClientes);

        // Layout de la ventana principal usando GroupLayout
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(lblId)
                .addComponent(lblNombre)
                .addComponent(lblCuit)
                .addComponent(lblEmail)
                .addComponent(lblDireccion)
                .addComponent(lblLatitud)
                .addComponent(lblLongitud))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(txtId)
                .addComponent(txtNombre)
                .addComponent(txtCuit)
                .addComponent(txtEmail)
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
                .addComponent(lblCuit)
                .addComponent(txtCuit))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblEmail)
                .addComponent(txtEmail))
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

        configurarAcciones();
    }

    private void configurarAcciones() {
        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String cuit = txtCuit.getText();
                String email = txtEmail.getText();
                String direccion = txtDireccion.getText();
                double lat = Double.parseDouble(txtLatitud.getText());
                double lng = Double.parseDouble(txtLongitud.getText());

                Coordenada coordenada = new Coordenada(lat, lng);
                clienteController.crearNuevoCliente(nombre, cuit, email, direccion, coordenada);
                actualizarTabla();
            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = txtId.getText();
                Cliente cliente = clienteController.buscarCliente(Integer.parseInt(id));
                if (cliente != null) {
                    txtNombre.setText(cliente.getNombre());
                    txtCuit.setText(cliente.getCuit());
                    txtEmail.setText(cliente.getEmail());
                    txtDireccion.setText(cliente.getDireccion());
                    txtLatitud.setText(String.valueOf(cliente.getCoordenada().getLat()));
                    txtLongitud.setText(String.valueOf(cliente.getCoordenada().getLng()));
                } else {
                    JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
                }
            }
        });

        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = txtId.getText();
                String nombre = txtNombre.getText();
                String cuit = txtCuit.getText();
                String email = txtEmail.getText();
                String direccion = txtDireccion.getText();
                double lat = Double.parseDouble(txtLatitud.getText());
                double lng = Double.parseDouble(txtLongitud.getText());

                Coordenada coordenada = new Coordenada(lat, lng);
                clienteController.modificarCliente(id, nombre, cuit, email, direccion, coordenada);
                actualizarTabla();
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = txtId.getText();
                clienteController.eliminarCliente(Integer.parseInt(id));
                actualizarTabla();
            }
        });
    }

    private void actualizarTabla() {
        List<Cliente> clientes = clienteController.obtenerListaClientes();
        String[] columnNames = {"ID", "Nombre", "Cuit", "Email", "Dirección", "Latitud", "Longitud"};
        Object[][] data = new Object[clientes.size()][7];
        for (int i = 0; i < clientes.size(); i++) {
            Cliente c = clientes.get(i);
            data[i][0] = c.getId();
            data[i][1] = c.getNombre();
            data[i][2] = c.getCuit();
            data[i][3] = c.getEmail();
            data[i][4] = c.getDireccion();
            data[i][5] = c.getCoordenada().getLat();
            data[i][6] = c.getCoordenada().getLng();
        }
        tableClientes.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    }
}
