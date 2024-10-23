/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desarrollo.tpentrega1.entidades.UI;

import desarrollo.tpentrega1.entidades.Coordenada;
import desarrollo.tpentrega1.entidades.Cliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author florh
 */
public class ClienteUI extends JFrame{
    private JTextField txtId, txtNombre,txtCuit, txtEmail, txtDireccion, txtLatitud, txtLongitud;
    private JButton btnCrear, btnBuscar, btnEditar, btnEliminar;
    private JTable tableClientes;
    private ArrayList<Cliente> clientes;

    public ClienteUI(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
        setTitle("Gestión de Clientes");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
        txtCuit= new JTextField(20);
        txtEmail = new JTextField(60);
        txtDireccion = new JTextField(20);
        txtLatitud = new JTextField(20);
        txtLongitud = new JTextField(20);
        

        btnCrear = new JButton("Crear");
        btnBuscar = new JButton("Buscar");
        btnEditar = new JButton("Editar");
        btnEliminar = new JButton("Eliminar");

        // Tabla para mostrar los clientes
        String[] columnNames = {"ID", "Nombre","Cuit", "Email", "Dirección", "Latitud", "Longitud"};
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
        tableClientes = new JTable(data, columnNames);

        // Panel de la tabla
        JScrollPane scrollPane = new JScrollPane(tableClientes);

        // Layout de la ventana principal usando GroupLayout
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // Horizontal Group
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

        // Vertical Group
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

        add(panel);

        // Configurar los botones
        configurarAcciones();
    }

    private void configurarAcciones() {
        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = txtId.getText();
                String nombre = txtNombre.getText();
                String direccion = txtDireccion.getText();
                String cuit = txtCuit.getText();
                String email = txtEmail.getText();
                double lat = Double.parseDouble(txtLatitud.getText());
                double lng = Double.parseDouble(txtLongitud.getText());

                Cliente cliente = new Cliente(id, nombre,cuit, email, direccion, new Coordenada(lat, lng));
                clientes.add(cliente);

                actualizarTabla();
            }
        });

        // Configurar los otros botones para Buscar, Editar y Eliminar
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = txtId.getText();
                for (Cliente cliente : clientes) {
                    if (cliente.getId().equals(id)) {
                        txtNombre.setText(cliente.getNombre());
                        txtCuit.setText(cliente.getCuit());
                        txtEmail.setText(cliente.getEmail());
                        txtDireccion.setText(cliente.getDireccion());
                        txtLatitud.setText(String.valueOf(cliente.getCoordenada().getLat()));
                        txtLongitud.setText(String.valueOf(cliente.getCoordenada().getLng()));
                        break;
                    }
                }
            }
        });

        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = txtId.getText();
                for (Cliente cliente : clientes) {
                    if (cliente.getId().equals(id)) {
                        cliente.setNombre(txtNombre.getText());
                        cliente.setDireccion(txtDireccion.getText());
                        cliente.getCoordenada().setLat(Double.parseDouble(txtLatitud.getText()));
                        cliente.getCoordenada().setLng(Double.parseDouble(txtLongitud.getText()));
                        actualizarTabla();
                        break;
                    }
                }
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = txtId.getText();
                clientes.removeIf(cliente -> cliente.getId().equals(id));
                actualizarTabla();
            }
        });
    }

    private void actualizarTabla() {
        String[] columnNames = {"ID", "Nombre","Cuit","Email", "Dirección", "Latitud", "Longitud"};
        Object[][] data = new Object[clientes.size()][7];
        for (int i = 0; i < clientes.size(); i++) {
            Cliente c = clientes.get(i);
            data[i][0] = c.getId();
            data[i][1] = c.getNombre();
            data[i][2] = c.getCuit();
            data[i][2] = c.getEmail();
            data[i][4] = c.getDireccion();
            data[i][5] = c.getCoordenada().getLat();
            data[i][6] = c.getCoordenada().getLng();
        }
        tableClientes.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    }
}
