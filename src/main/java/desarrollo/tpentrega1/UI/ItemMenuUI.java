package desarrollo.tpentrega1.UI;

import desarrollo.tpentrega1.controllers.ItemMenuController;
import desarrollo.tpentrega1.controllers.VendedorController;
import desarrollo.tpentrega1.entidades.Bebida;
import desarrollo.tpentrega1.entidades.ItemMenu;
import desarrollo.tpentrega1.entidades.Plato;
import desarrollo.tpentrega1.entidades.Vendedor;
import desarrollo.tpentrega1.utilidades.GestionCeldas;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.table.JTableHeader;

/*
falta
continuar con evento de tabla
*/
public class ItemMenuUI extends javax.swing.JPanel {
    private final ItemMenuController itemMenuController;
    private final VendedorController vendedorController;
    private final ImageIcon icon= new ImageIcon("pedidosya-logo.png");
    
    public ItemMenuUI() {
        this.itemMenuController = ItemMenuController.getInstance();
        this.vendedorController = VendedorController.getInstance();
        initComponents();
        actualizarTabla();
        this.tableItems.setAutoResizeMode(5);
        this.tableItems.setRowHeight(40);
        JTableHeader tableHeader = tableItems.getTableHeader();
        tableHeader.setReorderingAllowed(false);
    }
    void update() {}
    private void actualizarTabla() {
        String[] columnNames = {"ID", "Nombre", "Descripcion", "Precio", "Categoria", "Peso", "Apto Vegano", "Apto Celiaco",
        "Calorias", "Grad. Alcoholica", "Tamaño", "", ""};
        List<ItemMenu> items = new ArrayList();
        for(Vendedor v: vendedorController.obtenerListaVendedores()){
            for(ItemMenu e: itemMenuController.obtenerItemsMenuDeVendedor(v.getId())){
                items.add(e);
            }
        }
        Object[][] data = new Object[items.size()][13];
        int i = 0;
        for(ItemMenu v : items){
            data[i][0] = v.getId();
            data[i][1] = v.getNombre();
            data[i][2] = v.getDescripcion();
            data[i][3] = v.getPrecio();
            data[i][4] = v.getCategoria();
            if(v.getCategoria().equals("Plato")){
                data[i][5] = v.peso();
                if(v.aptoVegano()) data[i][6] = "Si";
                else data[i][6] = "No";
                if(v.aptoCeliaco()) data[i][7] = "Si";
                else data[i][7] = "No";
                data[i][8] = v.getCalorias();
                data[i][9] = "-";
                data[i][10] = "-";
            } else if (v.getCategoria().equals("Bebida")){
                data[i][5] = "-";
                data[i][6] = "-";
                data[i][7] = "-";
                data[i][8] = "-";
                data[i][9] = v.getGraduacionAlcoholica();
                data[i][10] = v.getTamaño();
            }
            data[i][11] = "Editar";
            data[i][12] = "Borrar";
            i++;
        }
        tableItems.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
        tableItems.getColumnModel().getColumn(0).setCellRenderer(new GestionCeldas("numerico"));
        tableItems.getColumnModel().getColumn(1).setCellRenderer(new GestionCeldas("texto"));
        tableItems.getColumnModel().getColumn(2).setCellRenderer(new GestionCeldas("texto"));
        tableItems.getColumnModel().getColumn(3).setCellRenderer(new GestionCeldas("numerico"));
        tableItems.getColumnModel().getColumn(4).setCellRenderer(new GestionCeldas("texto"));
        tableItems.getColumnModel().getColumn(5).setCellRenderer(new GestionCeldas("numerico"));
        tableItems.getColumnModel().getColumn(6).setCellRenderer(new GestionCeldas("texto"));
        tableItems.getColumnModel().getColumn(7).setCellRenderer(new GestionCeldas("texto"));
        tableItems.getColumnModel().getColumn(8).setCellRenderer(new GestionCeldas("numerico"));
        tableItems.getColumnModel().getColumn(9).setCellRenderer(new GestionCeldas("numerico"));
        tableItems.getColumnModel().getColumn(10).setCellRenderer(new GestionCeldas("numerico"));
        tableItems.getColumnModel().getColumn(11).setCellRenderer(new GestionCeldas("icono"));
        tableItems.getColumnModel().getColumn(12).setCellRenderer(new GestionCeldas("icono"));
        tableItems.getColumnModel().getColumn(0).setPreferredWidth(8);
        tableItems.getColumnModel().getColumn(3).setPreferredWidth(50);
        tableItems.getColumnModel().getColumn(4).setPreferredWidth(50);
        tableItems.getColumnModel().getColumn(5).setPreferredWidth(40);
        tableItems.getColumnModel().getColumn(6).setPreferredWidth(60);
        tableItems.getColumnModel().getColumn(7).setPreferredWidth(60);
        tableItems.getColumnModel().getColumn(8).setPreferredWidth(50);
        tableItems.getColumnModel().getColumn(9).setPreferredWidth(30);
        tableItems.getColumnModel().getColumn(10).setPreferredWidth(30);
        tableItems.getColumnModel().getColumn(11).setPreferredWidth(30);
        tableItems.getColumnModel().getColumn(12).setPreferredWidth(30);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        eliminarBebidaFrame = new javax.swing.JFrame();
        gradAlcField2 = new javax.swing.JTextField();
        eliminarBebidaBtn = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        cancelarEliminarBebidaBtn = new javax.swing.JButton();
        precioBField2 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        descripcionBField2 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        nombreBField2 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        tamañoField2 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        idEliminarBebida = new javax.swing.JTextField();
        eliminarPlatoFrame = new javax.swing.JFrame();
        jLabel32 = new javax.swing.JLabel();
        aptoCeliacoField2 = new javax.swing.JTextField();
        aptoVeganoField2 = new javax.swing.JTextField();
        pesoField2 = new javax.swing.JTextField();
        caloriasField2 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        precioPField2 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        descripcionPField2 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        nombrePField2 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        eliminarPlatoBtn = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        cancelarEliminarPlatoBtn = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        idEliminarPlato = new javax.swing.JTextField();
        editarBebidaFrame = new javax.swing.JFrame();
        gradAlcField1 = new javax.swing.JTextField();
        editarBebidaBtn = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        cancelarEditarBebidaBtn = new javax.swing.JButton();
        precioBField1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        descripcionBField1 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        nombreBField1 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        tamañoField1 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        idEditarBebida = new javax.swing.JTextField();
        editarPlatoFrame = new javax.swing.JFrame();
        jLabel25 = new javax.swing.JLabel();
        aptoCeliacoField1 = new javax.swing.JTextField();
        aptoVeganoField1 = new javax.swing.JTextField();
        pesoField1 = new javax.swing.JTextField();
        caloriasField1 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        precioPField1 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        descripcionPField1 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        nombrePField1 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        editarPlatoBtn = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        cancelarEditarPlatoBtn = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        idEditarPlato = new javax.swing.JTextField();
        crearBebidaFrame = new javax.swing.JFrame();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        nombreBField = new javax.swing.JTextField();
        descripcionBField = new javax.swing.JTextField();
        precioBField = new javax.swing.JTextField();
        tamañoField = new javax.swing.JTextField();
        gradAlcField = new javax.swing.JTextField();
        crearBebidaBtn = new javax.swing.JButton();
        cancelarCrearBebidaBtn = new javax.swing.JButton();
        crearPlatoFrame = new javax.swing.JFrame();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        aptoCeliacoField = new javax.swing.JTextField();
        aptoVeganoField = new javax.swing.JTextField();
        pesoField = new javax.swing.JTextField();
        caloriasField = new javax.swing.JTextField();
        precioPField = new javax.swing.JTextField();
        descripcionPField = new javax.swing.JTextField();
        nombrePField = new javax.swing.JTextField();
        crearPlatoBtn = new javax.swing.JButton();
        cancelarCrearPlatoBtn = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableItems = new javax.swing.JTable();
        btnRefrescar = new javax.swing.JButton();
        btnCrearBebida = new javax.swing.JButton();
        btnCrearPlato = new javax.swing.JButton();

        eliminarBebidaFrame.setTitle("Eliminar Bebida");
        eliminarBebidaFrame.setIconImage(icon.getImage());
        eliminarBebidaFrame.setLocationByPlatform(true);
        eliminarBebidaFrame.setSize(new java.awt.Dimension(425, 255));

        eliminarBebidaBtn.setText("Eliminar Bebida");
        eliminarBebidaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarBebidaBtnActionPerformed(evt);
            }
        });

        jLabel20.setText("Nombre:");

        cancelarEliminarBebidaBtn.setText("Cancelar");
        cancelarEliminarBebidaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarEliminarBebidaBtnActionPerformed(evt);
            }
        });

        jLabel21.setText("Descripcion:");

        jLabel22.setText("Precio:");

        jLabel23.setText("Tamaño:");

        jLabel24.setText("Graduación Alcohólica");

        idEliminarBebida.setText("jTextField1");

        javax.swing.GroupLayout eliminarBebidaFrameLayout = new javax.swing.GroupLayout(eliminarBebidaFrame.getContentPane());
        eliminarBebidaFrame.getContentPane().setLayout(eliminarBebidaFrameLayout);
        eliminarBebidaFrameLayout.setHorizontalGroup(
            eliminarBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eliminarBebidaFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(eliminarBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(eliminarBebidaFrameLayout.createSequentialGroup()
                        .addGroup(eliminarBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24))
                        .addGap(18, 18, 18)
                        .addGroup(eliminarBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(precioBField2, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(descripcionBField2)
                            .addComponent(nombreBField2)
                            .addComponent(tamañoField2)
                            .addComponent(gradAlcField2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eliminarBebidaFrameLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(idEliminarBebida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelarEliminarBebidaBtn)
                        .addGap(18, 18, 18)
                        .addComponent(eliminarBebidaBtn)))
                .addContainerGap())
        );
        eliminarBebidaFrameLayout.setVerticalGroup(
            eliminarBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eliminarBebidaFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(eliminarBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(nombreBField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(eliminarBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(descripcionBField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(eliminarBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(precioBField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(eliminarBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tamañoField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(eliminarBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(gradAlcField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(eliminarBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eliminarBebidaBtn)
                    .addComponent(cancelarEliminarBebidaBtn)
                    .addComponent(idEliminarBebida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        eliminarPlatoFrame.setTitle("Eliminar Plato");
        eliminarPlatoFrame.setIconImage(icon.getImage());
        eliminarPlatoFrame.setLocationByPlatform(true);
        eliminarPlatoFrame.setSize(new java.awt.Dimension(425, 330));

        jLabel32.setText("Apto Celiaco:");

        jLabel33.setText("Nombre:");

        jLabel34.setText("Descripcion:");

        jLabel35.setText("Precio:");

        jLabel36.setText("Calorias:");

        eliminarPlatoBtn.setText("Eliminar Plato");
        eliminarPlatoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarPlatoBtnActionPerformed(evt);
            }
        });

        jLabel37.setText("Peso:");

        cancelarEliminarPlatoBtn.setText("Cancelar");
        cancelarEliminarPlatoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarEliminarPlatoBtnActionPerformed(evt);
            }
        });

        jLabel38.setText("Apto Vegano:");

        idEliminarPlato.setText("jTextField1");

        javax.swing.GroupLayout eliminarPlatoFrameLayout = new javax.swing.GroupLayout(eliminarPlatoFrame.getContentPane());
        eliminarPlatoFrame.getContentPane().setLayout(eliminarPlatoFrameLayout);
        eliminarPlatoFrameLayout.setHorizontalGroup(
            eliminarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eliminarPlatoFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(eliminarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(eliminarPlatoFrameLayout.createSequentialGroup()
                        .addGap(0, 102, Short.MAX_VALUE)
                        .addComponent(idEliminarPlato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelarEliminarPlatoBtn)
                        .addGap(18, 18, 18)
                        .addComponent(eliminarPlatoBtn))
                    .addGroup(eliminarPlatoFrameLayout.createSequentialGroup()
                        .addGroup(eliminarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel38)
                            .addComponent(jLabel33)
                            .addComponent(jLabel34)
                            .addComponent(jLabel35)
                            .addComponent(jLabel36)
                            .addComponent(jLabel37)
                            .addComponent(jLabel32))
                        .addGap(18, 18, 18)
                        .addGroup(eliminarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aptoCeliacoField2)
                            .addComponent(caloriasField2)
                            .addComponent(precioPField2)
                            .addComponent(descripcionPField2)
                            .addComponent(nombrePField2)
                            .addComponent(pesoField2)
                            .addComponent(aptoVeganoField2, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        eliminarPlatoFrameLayout.setVerticalGroup(
            eliminarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eliminarPlatoFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(eliminarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(nombrePField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(eliminarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(descripcionPField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(eliminarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(precioPField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(eliminarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(caloriasField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(eliminarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(pesoField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(eliminarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(aptoVeganoField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(eliminarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(aptoCeliacoField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(eliminarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eliminarPlatoBtn)
                    .addComponent(cancelarEliminarPlatoBtn)
                    .addComponent(idEliminarPlato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        editarBebidaFrame.setTitle("Editar Bebida");
        editarBebidaFrame.setIconImage(icon.getImage());
        editarBebidaFrame.setLocationByPlatform(true);
        editarBebidaFrame.setSize(new java.awt.Dimension(425, 255));

        editarBebidaBtn.setText("Editar Bebida");
        editarBebidaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarBebidaBtnActionPerformed(evt);
            }
        });

        jLabel15.setText("Nombre:");

        cancelarEditarBebidaBtn.setText("Cancelar");
        cancelarEditarBebidaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarEditarBebidaBtnActionPerformed(evt);
            }
        });

        jLabel16.setText("Descripcion:");

        jLabel17.setText("Precio:");

        jLabel18.setText("Tamaño:");

        jLabel19.setText("Graduación Alcohólica");

        idEditarBebida.setText("jTextField1");

        javax.swing.GroupLayout editarBebidaFrameLayout = new javax.swing.GroupLayout(editarBebidaFrame.getContentPane());
        editarBebidaFrame.getContentPane().setLayout(editarBebidaFrameLayout);
        editarBebidaFrameLayout.setHorizontalGroup(
            editarBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editarBebidaFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editarBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editarBebidaFrameLayout.createSequentialGroup()
                        .addGroup(editarBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19))
                        .addGap(18, 18, 18)
                        .addGroup(editarBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(precioBField1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(descripcionBField1)
                            .addComponent(nombreBField1)
                            .addComponent(tamañoField1)
                            .addComponent(gradAlcField1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editarBebidaFrameLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(idEditarBebida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelarEditarBebidaBtn)
                        .addGap(18, 18, 18)
                        .addComponent(editarBebidaBtn)))
                .addContainerGap())
        );
        editarBebidaFrameLayout.setVerticalGroup(
            editarBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editarBebidaFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editarBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(nombreBField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editarBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(descripcionBField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editarBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(precioBField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editarBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tamañoField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editarBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(gradAlcField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editarBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editarBebidaBtn)
                    .addComponent(cancelarEditarBebidaBtn)
                    .addComponent(idEditarBebida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        editarPlatoFrame.setTitle("Editar Plato");
        editarPlatoFrame.setAlwaysOnTop(true);
        editarPlatoFrame.setIconImage(icon.getImage());
        editarPlatoFrame.setLocationByPlatform(true);
        editarPlatoFrame.setSize(new java.awt.Dimension(425, 330));

        jLabel25.setText("Apto Celiaco:");

        jLabel26.setText("Nombre:");

        jLabel27.setText("Descripcion:");

        jLabel28.setText("Precio:");

        jLabel29.setText("Calorias:");

        editarPlatoBtn.setText("Editar Plato");
        editarPlatoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarPlatoBtnActionPerformed(evt);
            }
        });

        jLabel30.setText("Peso:");

        cancelarEditarPlatoBtn.setText("Cancelar");
        cancelarEditarPlatoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarEditarPlatoBtnActionPerformed(evt);
            }
        });

        jLabel31.setText("Apto Vegano:");

        idEditarPlato.setText("jTextField1");

        javax.swing.GroupLayout editarPlatoFrameLayout = new javax.swing.GroupLayout(editarPlatoFrame.getContentPane());
        editarPlatoFrame.getContentPane().setLayout(editarPlatoFrameLayout);
        editarPlatoFrameLayout.setHorizontalGroup(
            editarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editarPlatoFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editarPlatoFrameLayout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(18, 18, 18)
                        .addComponent(aptoCeliacoField1))
                    .addGroup(editarPlatoFrameLayout.createSequentialGroup()
                        .addGroup(editarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31)
                            .addComponent(jLabel26)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30))
                        .addGap(18, 18, 18)
                        .addGroup(editarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aptoVeganoField1)
                            .addComponent(pesoField1)
                            .addComponent(caloriasField1)
                            .addComponent(precioPField1)
                            .addComponent(descripcionPField1)
                            .addComponent(nombrePField1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editarPlatoFrameLayout.createSequentialGroup()
                        .addGap(0, 140, Short.MAX_VALUE)
                        .addComponent(idEditarPlato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelarEditarPlatoBtn)
                        .addGap(18, 18, 18)
                        .addComponent(editarPlatoBtn)))
                .addContainerGap())
        );
        editarPlatoFrameLayout.setVerticalGroup(
            editarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editarPlatoFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(nombrePField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(descripcionPField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(precioPField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(caloriasField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(pesoField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(aptoVeganoField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(aptoCeliacoField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editarPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editarPlatoBtn)
                    .addComponent(cancelarEditarPlatoBtn)
                    .addComponent(idEditarPlato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        crearBebidaFrame.setTitle("Crear Bebida");
        crearBebidaFrame.setIconImage(icon.getImage());
        crearBebidaFrame.setLocationByPlatform(true);
        crearBebidaFrame.setSize(new java.awt.Dimension(425, 255));

        jLabel10.setText("Nombre:");

        jLabel11.setText("Descripcion:");

        jLabel12.setText("Precio:");

        jLabel13.setText("Tamaño:");

        jLabel14.setText("Graduación Alcohólica");

        crearBebidaBtn.setText("Crear Bebida");
        crearBebidaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearBebidaBtnActionPerformed(evt);
            }
        });

        cancelarCrearBebidaBtn.setText("Cancelar");
        cancelarCrearBebidaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarCrearBebidaBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout crearBebidaFrameLayout = new javax.swing.GroupLayout(crearBebidaFrame.getContentPane());
        crearBebidaFrame.getContentPane().setLayout(crearBebidaFrameLayout);
        crearBebidaFrameLayout.setHorizontalGroup(
            crearBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crearBebidaFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(crearBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(crearBebidaFrameLayout.createSequentialGroup()
                        .addGroup(crearBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(crearBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(precioBField, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(descripcionBField)
                            .addComponent(nombreBField)
                            .addComponent(tamañoField)
                            .addComponent(gradAlcField)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, crearBebidaFrameLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cancelarCrearBebidaBtn)
                        .addGap(18, 18, 18)
                        .addComponent(crearBebidaBtn)))
                .addContainerGap())
        );
        crearBebidaFrameLayout.setVerticalGroup(
            crearBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crearBebidaFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(crearBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(nombreBField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(crearBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(descripcionBField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(crearBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(precioBField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(crearBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tamañoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(crearBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(gradAlcField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(crearBebidaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(crearBebidaBtn)
                    .addComponent(cancelarCrearBebidaBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        crearPlatoFrame.setTitle("Crear Plato");
        crearPlatoFrame.setIconImage(icon.getImage());
        crearPlatoFrame.setLocationByPlatform(true);
        crearPlatoFrame.setSize(new java.awt.Dimension(425, 330));

        jLabel3.setText("Nombre:");

        jLabel4.setText("Descripcion:");

        jLabel5.setText("Precio:");

        jLabel6.setText("Calorias:");

        jLabel7.setText("Peso:");

        jLabel8.setText("Apto Vegano:");

        jLabel9.setText("Apto Celiaco:");

        crearPlatoBtn.setText("Crear Plato");
        crearPlatoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearPlatoBtnActionPerformed(evt);
            }
        });

        cancelarCrearPlatoBtn.setText("Cancelar");
        cancelarCrearPlatoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarCrearPlatoBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout crearPlatoFrameLayout = new javax.swing.GroupLayout(crearPlatoFrame.getContentPane());
        crearPlatoFrame.getContentPane().setLayout(crearPlatoFrameLayout);
        crearPlatoFrameLayout.setHorizontalGroup(
            crearPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crearPlatoFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(crearPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(crearPlatoFrameLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(aptoCeliacoField))
                    .addGroup(crearPlatoFrameLayout.createSequentialGroup()
                        .addGroup(crearPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(crearPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aptoVeganoField)
                            .addComponent(pesoField)
                            .addComponent(caloriasField)
                            .addComponent(precioPField)
                            .addComponent(descripcionPField)
                            .addComponent(nombrePField)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, crearPlatoFrameLayout.createSequentialGroup()
                        .addGap(0, 206, Short.MAX_VALUE)
                        .addComponent(cancelarCrearPlatoBtn)
                        .addGap(18, 18, 18)
                        .addComponent(crearPlatoBtn)))
                .addContainerGap())
        );
        crearPlatoFrameLayout.setVerticalGroup(
            crearPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crearPlatoFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(crearPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nombrePField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(crearPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(descripcionPField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(crearPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(precioPField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(crearPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(caloriasField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(crearPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(pesoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(crearPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(aptoVeganoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(crearPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(aptoCeliacoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(crearPlatoFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(crearPlatoBtn)
                    .addComponent(cancelarCrearPlatoBtn))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        setBackground(new java.awt.Color(224, 240, 254));

        btnBuscar.setBackground(new java.awt.Color(100, 180, 255));
        btnBuscar.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(224, 240, 254));
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(224, 240, 254), new java.awt.Color(224, 240, 254), null, null));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ID Item:");

        jScrollPane1.setBackground(new java.awt.Color(224, 240, 254));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 204, 153))); // NOI18N
        jScrollPane1.setFont(new java.awt.Font("Segoe UI Historic", 3, 12)); // NOI18N
        jScrollPane1.setRowHeaderView(null);

        tableItems.setBackground(new java.awt.Color(224, 240, 254));
        tableItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableItems.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableItemsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableItems);

        btnRefrescar.setBackground(new java.awt.Color(100, 180, 252));
        btnRefrescar.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        btnRefrescar.setForeground(new java.awt.Color(224, 240, 254));
        btnRefrescar.setText("Refrescar");
        btnRefrescar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(224, 240, 254), null, null));
        btnRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarActionPerformed(evt);
            }
        });

        btnCrearBebida.setBackground(new java.awt.Color(100, 180, 252));
        btnCrearBebida.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        btnCrearBebida.setForeground(new java.awt.Color(224, 240, 254));
        btnCrearBebida.setText("Crear Bebida");
        btnCrearBebida.setToolTipText("");
        btnCrearBebida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(224, 240, 254), null, null));
        btnCrearBebida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearBebidaActionPerformed(evt);
            }
        });

        btnCrearPlato.setBackground(new java.awt.Color(100, 180, 252));
        btnCrearPlato.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        btnCrearPlato.setForeground(new java.awt.Color(224, 240, 254));
        btnCrearPlato.setText("Crear Plato");
        btnCrearPlato.setToolTipText("");
        btnCrearPlato.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(224, 240, 254), null, null));
        btnCrearPlato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearPlatoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnRefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 532, Short.MAX_VALUE)
                        .addComponent(btnCrearPlato, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCrearBebida, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtId)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrearBebida, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrearPlato, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void eliminarBebidaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarBebidaBtnActionPerformed
        itemMenuController.eliminarItemsMenu(itemMenuController.buscarItemsMenu(Integer.valueOf(nombreBField2.getText())));
    }//GEN-LAST:event_eliminarBebidaBtnActionPerformed

    private void cancelarEliminarBebidaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarEliminarBebidaBtnActionPerformed
        nombreBField2.setText("");
        descripcionBField2.setText("");
        precioBField2.setText("");
        tamañoField2.setText("");
        gradAlcField2.setText("");
        eliminarBebidaFrame.setVisible(false);
    }//GEN-LAST:event_cancelarEliminarBebidaBtnActionPerformed

    private void eliminarPlatoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarPlatoBtnActionPerformed
        boolean av=false, ac=false;
        if(aptoVeganoField2.getText().equals("Si")) av = true;
        if(aptoCeliacoField2.getText().equals("Si")) ac = true;
        ItemMenu item = new Plato.Builder()
                .nombre(nombrePField2.getText())
                .descripcion(descripcionPField2.getText())
                .precio(Double.parseDouble(precioPField2.getText()))
                .categoria("Plato")
                .calorias(Double.parseDouble(caloriasField2.getText()))
                .aptoCeliaco(ac)
                .aptoVegano(av)
                .build();
        itemMenuController.eliminarItemsMenu(item);
    }//GEN-LAST:event_eliminarPlatoBtnActionPerformed

    private void cancelarEliminarPlatoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarEliminarPlatoBtnActionPerformed
        nombrePField2.setText("");
        descripcionPField2.setText("");
        precioPField2.setText("");
        caloriasField2.setText("");
        aptoCeliacoField2.setText("");
        aptoVeganoField2.setText("");
        pesoField2.setText("");
        eliminarPlatoFrame.setVisible(false);
    }//GEN-LAST:event_cancelarEliminarPlatoBtnActionPerformed

    private void editarBebidaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarBebidaBtnActionPerformed
        Bebida nuevaBebida = new Bebida.Builder()
                .nombre(nombreBField1.getText())
                .descripcion(descripcionBField1.getText())
                .precio(Double.parseDouble(precioBField1.getText()))
                .categoria("Bebida")
                .tamaño(Double.parseDouble(tamañoField1.getText()))
                .graduacionAlcoholica(Double.parseDouble(gradAlcField1.getText()))
                .build();
        itemMenuController.modificarBebida(nuevaBebida);
    }//GEN-LAST:event_editarBebidaBtnActionPerformed

    private void cancelarEditarBebidaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarEditarBebidaBtnActionPerformed
        nombreBField1.setText("");
        descripcionBField1.setText("");
        precioBField1.setText("");
        tamañoField1.setText("");
        gradAlcField1.setText("");
        editarBebidaFrame.setVisible(false);
    }//GEN-LAST:event_cancelarEditarBebidaBtnActionPerformed

    private void editarPlatoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarPlatoBtnActionPerformed
        boolean av=false, ac=false;
        if(aptoVeganoField1.getText().equals("Si")) av = true;
        if(aptoCeliacoField1.getText().equals("Si")) ac = true;
        Plato plato = new Plato.Builder()
                .nombre(nombrePField1.getText())
                .descripcion(descripcionPField1.getText())
                .precio(Double.parseDouble(precioPField1.getText()))
                .categoria("Plato")
                .calorias(Double.parseDouble(caloriasField1.getText()))
                .aptoCeliaco(ac)
                .aptoVegano(av)
                .build();
        itemMenuController.modificarPlato(plato);
        editarPlatoFrame.setVisible(false);
    }//GEN-LAST:event_editarPlatoBtnActionPerformed

    private void cancelarEditarPlatoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarEditarPlatoBtnActionPerformed
        nombrePField1.setText("");
        descripcionPField1.setText("");
        precioPField1.setText("");
        caloriasField1.setText("");
        aptoCeliacoField1.setText("");
        aptoVeganoField1.setText("");
        pesoField1.setText("");
        editarPlatoFrame.setVisible(false);
    }//GEN-LAST:event_cancelarEditarPlatoBtnActionPerformed

    private void crearBebidaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearBebidaBtnActionPerformed
        itemMenuController.crearNuevaBebida(nombreBField.getText(), descripcionBField.getText(), Double.parseDouble(precioBField.getText()), "Bebida", Double.parseDouble(tamañoField.getText()), Double.parseDouble(gradAlcField.getText()));
    }//GEN-LAST:event_crearBebidaBtnActionPerformed

    private void cancelarCrearBebidaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarCrearBebidaBtnActionPerformed
        nombreBField.setText("");
        descripcionBField.setText("");
        precioBField.setText("");
        tamañoField.setText("");
        gradAlcField.setText("");
        crearBebidaFrame.setVisible(false);
    }//GEN-LAST:event_cancelarCrearBebidaBtnActionPerformed

    private void crearPlatoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearPlatoBtnActionPerformed
        boolean av=false, ac=false;
        if(aptoVeganoField.getText().equals("Si")) av = true;
        if(aptoCeliacoField.getText().equals("Si")) ac = true;
        itemMenuController.crearNuevoItem(nombrePField.getText(), descripcionPField.getText(), (Double.parseDouble(precioPField.getText())), "Plato", (Double.parseDouble(caloriasField.getText())), ac, av, (Double.parseDouble(pesoField.getText())));
    }//GEN-LAST:event_crearPlatoBtnActionPerformed

    private void cancelarCrearPlatoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarCrearPlatoBtnActionPerformed
        nombrePField.setText("");
        descripcionPField.setText("");
        precioPField.setText("");
        caloriasField.setText("");
        aptoCeliacoField.setText("");
        aptoVeganoField.setText("");
        pesoField.setText("");
        crearPlatoFrame.setVisible(false);
    }//GEN-LAST:event_cancelarCrearPlatoBtnActionPerformed

    private void btnCrearPlatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearPlatoActionPerformed
        crearPlatoFrame.setVisible(true);
    }//GEN-LAST:event_btnCrearPlatoActionPerformed

    private void btnCrearBebidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearBebidaActionPerformed
        crearBebidaFrame.setVisible(true);
    }//GEN-LAST:event_btnCrearBebidaActionPerformed

    private void btnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarActionPerformed
        this.actualizarTabla();
    }//GEN-LAST:event_btnRefrescarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        ItemMenu v = itemMenuController.buscarItemsMenu(Integer.valueOf(txtId.getText()));
        String[] columnNames = {"ID", "Nombre", "Descripcion", "Precio", "Categoria", "Peso", "Apto Vegano", "Apto Celiaco",
            "Calorias", "Grad. Alcoholica", "Tamaño", "", ""};
        Object[][] data = new Object[1][13];
        if(v!=null){
            data[0][0] = v.getId();
            data[0][1] = v.getNombre();
            data[0][2] = v.getDescripcion();
            data[0][3] = v.getPrecio();
            data[0][4] = v.getCategoria();
            if(v.getCategoria().equals("Plato")){
                data[0][5] = v.peso();
                if(v.aptoVegano()) data[0][6] = "Si";
                else data[0][6] = "No";
                if(v.aptoCeliaco()) data[0][7] = "Si";
                else data[0][7] = "No";
                data[0][8] = v.getCalorias();
                data[0][9] = "-";
                data[0][10] = "-";
            } else if (v.getCategoria().equals("Bebida")){
                data[0][5] = "-";
                data[0][6] = "-";
                data[0][7] = "-";
                data[0][8] = "-";
                data[0][9] = v.getGraduacionAlcoholica();
                data[0][10] = v.getTamaño();
            }
            data[0][11] = "Editar";
            data[0][12] = "Borrar";
        } else if (v==null){
            data[0][0] = "";
            data[0][1] = "";
            data[0][2] = "";
            data[0][3] = "";
            data[0][4] = "";
            data[0][5] = "";
            data[0][6] = "";
            data[0][7] = "";
            data[0][8] = "";
            data[0][9] = "";
            data[0][10] = "";
            data[0][11] = "";
            data[0][12] = "";
        }
        tableItems.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
        tableItems.getColumnModel().getColumn(0).setCellRenderer(new GestionCeldas("numerico"));
        tableItems.getColumnModel().getColumn(1).setCellRenderer(new GestionCeldas("texto"));
        tableItems.getColumnModel().getColumn(2).setCellRenderer(new GestionCeldas("texto"));
        tableItems.getColumnModel().getColumn(3).setCellRenderer(new GestionCeldas("numerico"));
        tableItems.getColumnModel().getColumn(4).setCellRenderer(new GestionCeldas("texto"));
        tableItems.getColumnModel().getColumn(5).setCellRenderer(new GestionCeldas("numerico"));
        tableItems.getColumnModel().getColumn(6).setCellRenderer(new GestionCeldas("texto"));
        tableItems.getColumnModel().getColumn(7).setCellRenderer(new GestionCeldas("texto"));
        tableItems.getColumnModel().getColumn(8).setCellRenderer(new GestionCeldas("numerico"));
        tableItems.getColumnModel().getColumn(9).setCellRenderer(new GestionCeldas("numerico"));
        tableItems.getColumnModel().getColumn(10).setCellRenderer(new GestionCeldas("numerico"));
        tableItems.getColumnModel().getColumn(11).setCellRenderer(new GestionCeldas("icono"));
        tableItems.getColumnModel().getColumn(12).setCellRenderer(new GestionCeldas("icono"));
        tableItems.getColumnModel().getColumn(0).setPreferredWidth(8);
        tableItems.getColumnModel().getColumn(3).setPreferredWidth(50);
        tableItems.getColumnModel().getColumn(4).setPreferredWidth(50);
        tableItems.getColumnModel().getColumn(5).setPreferredWidth(40);
        tableItems.getColumnModel().getColumn(6).setPreferredWidth(60);
        tableItems.getColumnModel().getColumn(7).setPreferredWidth(60);
        tableItems.getColumnModel().getColumn(8).setPreferredWidth(50);
        tableItems.getColumnModel().getColumn(9).setPreferredWidth(30);
        tableItems.getColumnModel().getColumn(10).setPreferredWidth(30);
        tableItems.getColumnModel().getColumn(11).setPreferredWidth(30);
        tableItems.getColumnModel().getColumn(12).setPreferredWidth(30);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tableItemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableItemsMouseClicked
        int fila = tableItems.rowAtPoint(evt.getPoint());
        int columna = tableItems.columnAtPoint(evt.getPoint());
        if(!tableItems.getValueAt(fila, 0).equals("") && !tableItems.getValueAt(fila, 1).equals("")
            && !tableItems.getValueAt(fila, 2).equals("") && !tableItems.getValueAt(fila, 3).equals("")
            && !tableItems.getValueAt(fila, 4).equals("") && !tableItems.getValueAt(fila, 5).equals("")
            && !tableItems.getValueAt(fila, 6).equals("") && !tableItems.getValueAt(fila, 7).equals("")
            && !tableItems.getValueAt(fila, 8).equals("") && !tableItems.getValueAt(fila, 9).equals("")
            && !tableItems.getValueAt(fila, 10).equals("") && !tableItems.getValueAt(fila, 11).equals("")
            && !tableItems.getValueAt(fila, 12).equals("")){
            if(columna==11){
                if(tableItems.getValueAt(fila, 4).equals("Plato")){
                    nombrePField1.setText(tableItems.getValueAt(fila, 1).toString());
                    descripcionPField1.setText(tableItems.getValueAt(fila, 2).toString());
                    precioPField1.setText(tableItems.getValueAt(fila, 3).toString());
                    caloriasField1.setText(tableItems.getValueAt(fila, 4).toString());
                    aptoCeliacoField1.setText(tableItems.getValueAt(fila, 7).toString());
                    aptoVeganoField1.setText(tableItems.getValueAt(fila, 6).toString());
                    pesoField1.setText(tableItems.getValueAt(fila, 5).toString());
                    idEditarPlato.setVisible(false);
                    idEditarPlato.setText(tableItems.getValueAt(fila, 0).toString());
                    editarPlatoFrame.setVisible(true);
                } else if(tableItems.getValueAt(fila, 4).equals("Bebida")){
                    nombreBField1.setText(tableItems.getValueAt(fila, 1).toString());
                    descripcionBField1.setText(tableItems.getValueAt(fila, 2).toString());
                    precioBField1.setText(tableItems.getValueAt(fila, 3).toString());
                    tamañoField1.setText(tableItems.getValueAt(fila, 10).toString());
                    gradAlcField1.setText(tableItems.getValueAt(fila, 9).toString());
                    idEditarBebida.setVisible(false);
                    idEditarBebida.setText(tableItems.getValueAt(fila, 0).toString());
                    editarBebidaFrame.setVisible(true);
                }
            } else if(columna==12){
                if(tableItems.getValueAt(fila, 4).equals("Plato")){
                    nombrePField2.setText(tableItems.getValueAt(fila, 1).toString());
                    descripcionPField2.setText(tableItems.getValueAt(fila, 2).toString());
                    precioPField2.setText(tableItems.getValueAt(fila, 3).toString());
                    caloriasField2.setText(tableItems.getValueAt(fila, 4).toString());
                    aptoCeliacoField2.setText(tableItems.getValueAt(fila, 7).toString());
                    aptoVeganoField2.setText(tableItems.getValueAt(fila, 6).toString());
                    pesoField2.setText(tableItems.getValueAt(fila, 5).toString());
                    nombrePField2.setEnabled(false);
                    descripcionPField2.setEnabled(false);
                    precioPField2.setEnabled(false);
                    caloriasField2.setEnabled(false);
                    aptoCeliacoField2.setEnabled(false);
                    aptoVeganoField2.setEnabled(false);
                    pesoField2.setEnabled(false);
                    idEliminarPlato.setVisible(false);
                    idEliminarPlato.setText(tableItems.getValueAt(fila, 0).toString());
                    eliminarPlatoFrame.setVisible(true);
                } else if(tableItems.getValueAt(fila, 4).equals("Bebida")){
                    nombreBField2.setText(tableItems.getValueAt(fila, 1).toString());
                    descripcionBField2.setText(tableItems.getValueAt(fila, 2).toString());
                    precioBField2.setText(tableItems.getValueAt(fila, 3).toString());
                    tamañoField2.setText(tableItems.getValueAt(fila, 10).toString());
                    gradAlcField2.setText(tableItems.getValueAt(fila, 9).toString());
                    nombreBField2.setEnabled(false);
                    descripcionBField2.setEnabled(false);
                    precioBField2.setEnabled(false);
                    tamañoField2.setEnabled(false);
                    gradAlcField2.setEnabled(false);
                    idEliminarBebida.setVisible(false);
                    idEliminarBebida.setText(tableItems.getValueAt(fila, 0).toString());
                    eliminarBebidaFrame.setVisible(true);
                }
            }
        }
    }//GEN-LAST:event_tableItemsMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aptoCeliacoField;
    private javax.swing.JTextField aptoCeliacoField1;
    private javax.swing.JTextField aptoCeliacoField2;
    private javax.swing.JTextField aptoVeganoField;
    private javax.swing.JTextField aptoVeganoField1;
    private javax.swing.JTextField aptoVeganoField2;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCrearBebida;
    private javax.swing.JButton btnCrearPlato;
    private javax.swing.JButton btnRefrescar;
    private javax.swing.JTextField caloriasField;
    private javax.swing.JTextField caloriasField1;
    private javax.swing.JTextField caloriasField2;
    private javax.swing.JButton cancelarCrearBebidaBtn;
    private javax.swing.JButton cancelarCrearPlatoBtn;
    private javax.swing.JButton cancelarEditarBebidaBtn;
    private javax.swing.JButton cancelarEditarPlatoBtn;
    private javax.swing.JButton cancelarEliminarBebidaBtn;
    private javax.swing.JButton cancelarEliminarPlatoBtn;
    private javax.swing.JButton crearBebidaBtn;
    private javax.swing.JFrame crearBebidaFrame;
    private javax.swing.JButton crearPlatoBtn;
    private javax.swing.JFrame crearPlatoFrame;
    private javax.swing.JTextField descripcionBField;
    private javax.swing.JTextField descripcionBField1;
    private javax.swing.JTextField descripcionBField2;
    private javax.swing.JTextField descripcionPField;
    private javax.swing.JTextField descripcionPField1;
    private javax.swing.JTextField descripcionPField2;
    private javax.swing.JButton editarBebidaBtn;
    private javax.swing.JFrame editarBebidaFrame;
    private javax.swing.JButton editarPlatoBtn;
    private javax.swing.JFrame editarPlatoFrame;
    private javax.swing.JButton eliminarBebidaBtn;
    private javax.swing.JFrame eliminarBebidaFrame;
    private javax.swing.JButton eliminarPlatoBtn;
    private javax.swing.JFrame eliminarPlatoFrame;
    private javax.swing.JTextField gradAlcField;
    private javax.swing.JTextField gradAlcField1;
    private javax.swing.JTextField gradAlcField2;
    private javax.swing.JTextField idEditarBebida;
    private javax.swing.JTextField idEditarPlato;
    private javax.swing.JTextField idEliminarBebida;
    private javax.swing.JTextField idEliminarPlato;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombreBField;
    private javax.swing.JTextField nombreBField1;
    private javax.swing.JTextField nombreBField2;
    private javax.swing.JTextField nombrePField;
    private javax.swing.JTextField nombrePField1;
    private javax.swing.JTextField nombrePField2;
    private javax.swing.JTextField pesoField;
    private javax.swing.JTextField pesoField1;
    private javax.swing.JTextField pesoField2;
    private javax.swing.JTextField precioBField;
    private javax.swing.JTextField precioBField1;
    private javax.swing.JTextField precioBField2;
    private javax.swing.JTextField precioPField;
    private javax.swing.JTextField precioPField1;
    private javax.swing.JTextField precioPField2;
    private javax.swing.JTable tableItems;
    private javax.swing.JTextField tamañoField;
    private javax.swing.JTextField tamañoField1;
    private javax.swing.JTextField tamañoField2;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
