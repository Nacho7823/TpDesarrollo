package desarrollo.tpentrega1.UI;

import desarrollo.tpentrega1.entidades.Cliente;
import desarrollo.tpentrega1.entidades.Coordenada;
import desarrollo.tpentrega1.controllers.ClienteController;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.JTableHeader;

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
        actualizarTabla(null);
        tableClientes.setRowHeight(40);
        JTableHeader tableHeader = tableClientes.getTableHeader();
        tableHeader.setReorderingAllowed(false);

        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new BoxLayout(tablePanel, BoxLayout.Y_AXIS));
        tablePanel.add(tableHeader);
        tablePanel.add(tableClientes);

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
                                        .addComponent(btnEliminar))))
                .addComponent(tablePanel)
        );

        // Configuración de los grupos verticales
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
                .addComponent(tablePanel)
        );

        configurarAcciones();
    }

    public void update() {
        
    }
    
    private void configurarAcciones() {
        btnCrear.addActionListener(new ActionListener() {
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
                clienteController.crearNuevoCliente(id, nombre, cuit, email, direccion, coordenada);
                actualizarTabla(clienteController.obtenerListaClientes().getLast());
                txtId.setText("");
                txtNombre.setText("");
                txtCuit.setText("");
                txtEmail.setText("");
                txtDireccion.setText("");
                txtLatitud.setText("");
                txtLongitud.setText("");

            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = txtId.getText();
                Cliente cliente = clienteController.buscarCliente(id);
                if (cliente != null) {
                    actualizarTabla(cliente);
                    txtId.setText(cliente.getId());
                    txtNombre.setText(cliente.getNombre());
                    txtCuit.setText(cliente.getCuit());
                    txtEmail.setText(cliente.getEmail());
                    txtDireccion.setText(cliente.getDireccion());
                    txtLatitud.setText(cliente.getCoordenada().getLat() + "");
                    txtLongitud.setText(cliente.getCoordenada().getLng() + "");

                } else {
                    JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
                    actualizarTabla(null);
                        txtId.setText("");
                    txtNombre.setText("");
                    txtCuit.setText("");
                    txtEmail.setText("");
                    txtDireccion.setText("");
                    txtLatitud.setText("");
                    txtLongitud.setText("");
                }
                txtId.setText("");
                txtNombre.setText("");
                txtCuit.setText("");
                txtEmail.setText("");
                txtDireccion.setText("");
                txtLatitud.setText("");
                txtLongitud.setText("");
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
                actualizarTabla(clienteController.buscarCliente(id));
                txtId.setText("");
                txtNombre.setText("");
                txtCuit.setText("");
                txtEmail.setText("");
                txtDireccion.setText("");
                txtLatitud.setText("");
                txtLongitud.setText("");
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = txtId.getText();
                Cliente c = clienteController.buscarCliente(id);
                actualizarTabla(c);
                clienteController.eliminarCliente(c);
                txtId.setText("");
                txtNombre.setText("");
                txtCuit.setText("");
                txtEmail.setText("");
                txtDireccion.setText("");
                txtLatitud.setText("");
                txtLongitud.setText("");
            }

        });
    }

    private void actualizarTabla(Cliente c) {
        String[] columnNames = {"ID", "Nombre", "Cuit", "Email", "Dirección", "Latitud", "Longitud"};
        Object[][] data = new Object[1][7];
        if (c == null) {
            data[0][0] = " ";
            data[0][1] = " ";
            data[0][2] = " ";
            data[0][3] = " ";
            data[0][4] = " ";
            data[0][5] = " ";
            data[0][6] = " ";
        } else {
            data[0][0] = c.getId();
            data[0][1] = c.getNombre();
            data[0][2] = c.getCuit();
            data[0][3] = c.getEmail();
            data[0][4] = c.getDireccion();
            data[0][5] = c.getCoordenada().getLat();
            data[0][6] = c.getCoordenada().getLng();
        }
        tableClientes.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    }
}
