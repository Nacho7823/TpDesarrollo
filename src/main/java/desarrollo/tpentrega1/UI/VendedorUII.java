package desarrollo.tpentrega1.UI;

import desarrollo.tpentrega1.entidades.Coordenada;
import desarrollo.tpentrega1.entidades.Vendedor;
import desarrollo.tpentrega1.controllers.VendedorController;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.JTableHeader;

public class VendedorUII extends JPanel {
    private JTextField txtId, txtNombre, txtDireccion, txtLatitud, txtLongitud;
    private JButton btnCrear, btnBuscar, btnEditar, btnEliminar;
    private JTable tableVendedores;
    private VendedorController vendedorController;

    public VendedorUII(VendedorController vendedorController) {
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

tableVendedores = new JTable();
actualizarTabla(null);
tableVendedores.setRowHeight(40);
JTableHeader tableHeader = tableVendedores.getTableHeader();

JPanel tablePanel = new JPanel();
tablePanel.setLayout(new BoxLayout(tablePanel, BoxLayout.Y_AXIS));
tablePanel.add(tableHeader); 
tablePanel.add(tableVendedores); 
this.setBackground(new Color(130, 217, 217));
// Configuración del layout usando GroupLayout
GroupLayout layout = new GroupLayout(this);
this.setLayout(layout);
layout.setAutoCreateGaps(true);
layout.setAutoCreateContainerGaps(true);

// Configuración de los grupos horizontales
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
    
    public void update(){
        
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
                Vendedor v = vendedorController.buscarVendedor(id);
                System.out.println(v.toString());
                actualizarTabla(v);
            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = txtId.getText();
                Vendedor vendedor = vendedorController.buscarVendedor(id);
                if (vendedor != null) {
                    actualizarTabla(vendedor);
                    txtId.setText(vendedor.getId());
                    txtNombre.setText(vendedor.getNombre());
                    txtDireccion.setText(vendedor.getDireccion());
                    txtLatitud.setText(vendedor.getCoordenada().getLat() + "");
                    txtLongitud.setText(vendedor.getCoordenada().getLng() + "");
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
                actualizarTabla(vendedorController.buscarVendedor(id));
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = txtId.getText();
                Vendedor v = vendedorController.buscarVendedor(id);
                actualizarTabla(v);
                vendedorController.eliminarVendedor(v);
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
        Object[][] data= new Object[1][5];
        if(v==null){
            data[0][0] = " ";
            data[0][1] = " ";
            data[0][2] = " ";
            data[0][3] = " ";
            data[0][4] = " ";
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

