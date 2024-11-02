package desarrollo.tpentrega1.UI;

import desarrollo.tpentrega1.entidades.Coordenada;
import desarrollo.tpentrega1.entidades.Vendedor;
import desarrollo.tpentrega1.controllers.VendedorController;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VendedorUI extends JPanel {
    private JTextField txtId, txtNombre, txtDireccion, txtLatitud, txtLongitud;
    private JButton btnCrear, btnBuscar, btnEditar, btnEliminar;
    private JTable tableVendedores;
    private VendedorController vendedorController;

    public VendedorUI(VendedorController vendedorController) {
        this.vendedorController = vendedorController;
        
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
        actualizarTabla(null);

        JScrollPane scrollPane = new JScrollPane(tableVendedores);
 
        this.setBackground(new Color(130, 217, 217));
        // Layout de la ventana principal usando GroupLayout
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

         layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
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
                        .addComponent(btnEliminar))))
            .addComponent(scrollPane) 
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
                String id= txtId.getText();
                String nombre = txtNombre.getText();
                String direccion = txtDireccion.getText();
                double lat = Double.parseDouble(txtLatitud.getText());
                double lng = Double.parseDouble(txtLongitud.getText());

                Coordenada coordenada = new Coordenada(lat, lng);
                vendedorController.crearNuevoVendedor(id,nombre, direccion, coordenada);
                actualizarTabla(vendedorController.buscarVendedor(Integer.parseInt(id)));
            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = txtId.getText();
                Vendedor vendedor = vendedorController.buscarVendedor(Integer.parseInt(id));
                if (vendedor != null) {
                    actualizarTabla(vendedor);
                } else {
                    JOptionPane.showMessageDialog(null, "Vendedor no encontrado.");
                    actualizarTabla(null);
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
                actualizarTabla(vendedorController.buscarVendedor(Integer.parseInt(id)));
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = txtId.getText();
                actualizarTabla(vendedorController.buscarVendedor(Integer.parseInt(id)));
                vendedorController.eliminarVendedor(Integer.parseInt(id));

            }
        });
    }

    private void actualizarTabla(Vendedor v) {
                       txtId.setText("");
                txtNombre.setText("");
                txtDireccion.setText("");
                txtLatitud.setText("");
                txtLongitud.setText("");
        String[] columnNames = {"ID", "Nombre", "Dirección", "Latitud", "Longitud"};
        Object[][] data= new Object[1][7];
        if(v==null){
            data[0][0] = " ";
            data[0][1] = " ";
            data[0][2] = " ";
            data[0][3] = " ";
            data[0][4] = " ";
            data[0][5] = " ";
            data[0][6] = " ";
        }
        else {
            data[0][0] = v.getId();
            data[0][1] = v.getNombre();
            data[0][2] = v.getDireccion();
            data[0][3] = v.getCoordenada().getLat();
            data[0][4] = v.getCoordenada().getLng();
                }
        tableVendedores.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    }
}

