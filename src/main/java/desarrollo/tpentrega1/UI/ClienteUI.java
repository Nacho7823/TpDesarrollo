package desarrollo.tpentrega1.UI;

import desarrollo.tpentrega1.entidades.Cliente;
import desarrollo.tpentrega1.entidades.Coordenada;
import desarrollo.tpentrega1.controllers.ClienteController;
import desarrollo.tpentrega1.exceptions.DAOException;
import desarrollo.tpentrega1.utilidades.GestionCeldas;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        actualizarTabla();
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
                actualizarTabla();
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
                    actualizarTabla();
                    txtId.setText(cliente.getId());
                    txtNombre.setText(cliente.getNombre());
                    txtCuit.setText(cliente.getCuit());
                    txtEmail.setText(cliente.getEmail());
                    txtDireccion.setText(cliente.getDireccion());
                    txtLatitud.setText(cliente.getCoordenada().getLat() + "");
                    txtLongitud.setText(cliente.getCoordenada().getLng() + "");

                } else {
                    JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
                    actualizarTabla();
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
                actualizarTabla();
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
                actualizarTabla();
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
        tableClientes.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila=tableClientes.rowAtPoint(e.getPoint());
                int columna=tableClientes.columnAtPoint(e.getPoint());
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void mouseExited(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            
        });
    }

    private void actualizarTabla() {
        String[] columnNames = {"ID", "Nombre", "Cuit", "Email", "Dirección", "Latitud", "Longitud", "", ""};
        List<Cliente> clientes = clienteController.obtenerListaClientes();
        Object[][] data = new Object[clientes.size()][9];
        int i = 0;
        for(Cliente c : clientes){
            data[i][0] = c.getId();
            data[i][1] = c.getNombre();
            data[i][2] = c.getCuit();
            data[i][3] = c.getEmail();
            data[i][4] = c.getDireccion();
            data[i][5] = c.getCoordenada().getLat();
            data[i][6] = c.getCoordenada().getLng();
            data[i][7] = "Editar";
            data[i][8] = "Borrar";
            i++;
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
    }
}
