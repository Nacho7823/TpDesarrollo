
package desarrollo.tpentrega1.UI;

import desarrollo.tpentrega1.controllers.ItemsMenuController;
import desarrollo.tpentrega1.controllers.PedidoController;
import desarrollo.tpentrega1.controllers.VendedorController;
import desarrollo.tpentrega1.entidades.Bebida;
import desarrollo.tpentrega1.entidades.ItemMenu;
import desarrollo.tpentrega1.entidades.MercadoPago;
import desarrollo.tpentrega1.entidades.Pedido;
import desarrollo.tpentrega1.entidades.Plato;
import desarrollo.tpentrega1.entidades.Transferencia;
import desarrollo.tpentrega1.entidades.Vendedor;
import desarrollo.tpentrega1.enums.EstadoPedido;
import desarrollo.tpentrega1.interfaces.FormaDePago;
import java.util.ArrayList;
import java.util.List;

public class PedidoUI extends javax.swing.JPanel {
    private VendedorController vendedorController;
    private PedidoController pedidoController;
    private ItemsMenuController itemsMenuController;
    private Vendedor vendedor;
    private Pedido pedido;
    List<ItemMenu> items = new ArrayList();
    List<Bebida> bebidas = new ArrayList();
    List<Plato> platos = new ArrayList();
    
    public PedidoUI(PedidoController pedidoController, VendedorController vendedorController, ItemsMenuController itemsMenuController) {
        this.pedidoController = pedidoController;
        this.vendedorController = vendedorController;
        this.itemsMenuController = itemsMenuController;
        initComponents();
        List<Vendedor> listaVendedores = vendedorController.obtenerListaVendedores();
        for (Vendedor v : listaVendedores) {
            vendedoresDropDown.addItem((v.getNombre()).toString());
        }
        vendedoresDropDown.setMaximumRowCount(listaVendedores.size());
        for(EstadoPedido e : EstadoPedido.values()){
            estadoDropDown.addItem(e.toString());
        }
        formaDePagoDropDown.addItem("Transferencia");
        formaDePagoDropDown.addItem("Mercado Pago");
        actualizarItems(items);
        
        //vendedoresDropDown.setModel(new javax.swing.DefaultComboBoxModel<>());
        //ListModel<String> listaItems = pedidoController.getItems(pedidoController.buscarYDevolverPedido(Integer.parseInt(idField.getText())));
        //jList1.setModel(listaItems);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        itemsFrame = new javax.swing.JFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        platoTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        bebidaTable = new javax.swing.JTable();
        aceptarButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        editarItemsButton = new javax.swing.JButton();
        crearButton = new javax.swing.JButton();
        buscarButton = new javax.swing.JButton();
        eliminarButton = new javax.swing.JButton();
        idField = new javax.swing.JTextField();
        totalField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        vendedoresDropDown = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        estadoDropDown = new javax.swing.JComboBox<>();
        formaDePagoDropDown = new javax.swing.JComboBox<>();

        itemsFrame.setLocationByPlatform(true);
        itemsFrame.setSize(new java.awt.Dimension(400, 300));
        itemsFrame.setType(java.awt.Window.Type.POPUP);

        platoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Tipo", "Precio", "Calorias", "Peso", "Apto Vegano", "Apto Celiaco", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        platoTable.setRowSelectionAllowed(false);
        platoTable.setShowGrid(false);
        jScrollPane1.setViewportView(platoTable);
        if (platoTable.getColumnModel().getColumnCount() > 0) {
            platoTable.getColumnModel().getColumn(3).setHeaderValue("Calorias");
            platoTable.getColumnModel().getColumn(4).setResizable(false);
            platoTable.getColumnModel().getColumn(4).setHeaderValue("Peso");
        }

        bebidaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Tipo", "Precio", "Graduacion Alcoholica", "Tamaño", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bebidaTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(bebidaTable);

        aceptarButton.setText("Aceptar");
        aceptarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout itemsFrameLayout = new javax.swing.GroupLayout(itemsFrame.getContentPane());
        itemsFrame.getContentPane().setLayout(itemsFrameLayout);
        itemsFrameLayout.setHorizontalGroup(
            itemsFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itemsFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(itemsFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itemsFrameLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(aceptarButton)))
                .addContainerGap())
        );
        itemsFrameLayout.setVerticalGroup(
            itemsFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itemsFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(aceptarButton)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        setBackground(new java.awt.Color(130, 217, 217));

        jLabel2.setText("Vendedor:");

        jLabel3.setText("Forma de Pago:");

        jLabel4.setText("Estado:");

        jLabel5.setText("Total:");

        editarItemsButton.setText("Editar Items");
        editarItemsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarItemsButtonActionPerformed(evt);
            }
        });

        crearButton.setText("Crear");
        crearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearButtonActionPerformed(evt);
            }
        });

        buscarButton.setText("Buscar");
        buscarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarButtonActionPerformed(evt);
            }
        });

        eliminarButton.setText("Eliminar");

        idField.setToolTipText("");
        idField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idFieldActionPerformed(evt);
            }
        });

        jLabel1.setText("ID:");

        vendedoresDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        vendedoresDropDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendedoresDropDownActionPerformed(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Vendedor", "Estado", "Forma de Pago", "Total", "Items"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTable3);

        jLabel6.setText("Items:");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(jList1);

        estadoDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        estadoDropDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estadoDropDownActionPerformed(evt);
            }
        });

        formaDePagoDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        formaDePagoDropDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formaDePagoDropDownActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(editarItemsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(crearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buscarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(eliminarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(totalField)
                            .addComponent(idField)
                            .addComponent(vendedoresDropDown, 0, 499, Short.MAX_VALUE)
                            .addComponent(jScrollPane4)
                            .addComponent(estadoDropDown, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(formaDePagoDropDown, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(vendedoresDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(estadoDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(formaDePagoDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(crearButton)
                    .addComponent(buscarButton)
                    .addComponent(eliminarButton)
                    .addComponent(editarItemsButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(413, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarButtonActionPerformed
        actualizarItems(getCantTabla());
    }//GEN-LAST:event_aceptarButtonActionPerformed

    private void crearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearButtonActionPerformed
        FormaDePago f = null;
        EstadoPedido ep = null;
        if(formaDePagoDropDown.getSelectedItem().toString().equals("Transferencia")){
            f = new Transferencia();
        } else if(formaDePagoDropDown.getSelectedItem().toString().equals("Mercado Pago")){
            f = new MercadoPago();
        }
        for(EstadoPedido e : EstadoPedido.values()){
            if(e.toString().equals(estadoDropDown.getSelectedItem().toString())){
                ep=e;
            }
            
        }
        pedidoController.newPedido(idField.getText(), vendedor, items, f, ep);        
    }//GEN-LAST:event_crearButtonActionPerformed

    private void buscarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarButtonActionPerformed

    private void idFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idFieldActionPerformed

    private void vendedoresDropDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vendedoresDropDownActionPerformed
        if(evt.getSource()==vendedoresDropDown){
            String nombre=(vendedoresDropDown.getSelectedItem()).toString();
            List<Vendedor> listaVendedores = vendedorController.obtenerListaVendedores();
            for(Vendedor v : listaVendedores){
                if(v.getNombre().equals(nombre)) vendedor=v;
            }
            bebidas=vendedor.getItemBebidas();
            platos=vendedor.getItemComidas();
        }
        
    }//GEN-LAST:event_vendedoresDropDownActionPerformed

    private void editarItemsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarItemsButtonActionPerformed
        itemsFrame.setVisible(true);
        this.setTablasItems();
        actualizarItems(getCantTabla());
        
        //this.bebidaTable.get
    }//GEN-LAST:event_editarItemsButtonActionPerformed

    private void estadoDropDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadoDropDownActionPerformed
        if(evt.getSource()==estadoDropDown){
            
        }
    }//GEN-LAST:event_estadoDropDownActionPerformed

    private void formaDePagoDropDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formaDePagoDropDownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_formaDePagoDropDownActionPerformed
    private void actualizarItems(List<ItemMenu> lista){
        jList1.removeAll();
        try{
            String[] listData = new String[lista.size()];
            int i=0;
            for(ItemMenu item : lista){
                listData[i]=lista.get(i).getNombre();
                i++;
            }
            jList1.removeAll();
            jList1.setListData(listData);
            
        } catch (NullPointerException e){
        }
        
    }
    private void actualizarTabla(){
        List<Pedido> pedidos = pedidoController.obtenerListaPedidos();

        String[] columnNames = {"Cliente", "Vendedor", "id", "forma de pago", "estado"};
        Object[][] data = new Object[pedidos.size()][5];

        for (int i = 0; i < pedidos.size(); i++) {
            data[i][0] = "cliente";
            data[i][1] = "vendedor";
            data[i][2] = "" + i;
            data[i][3] = "mp";
            data[i][4] = "pendiente";
        }

        jTable3.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    }

    private void setTablasItems(){
        if(vendedorController.obtenerListaVendedores().contains(this.vendedor)){
            
            String[] columnNames = {"Nombre", "Tipo", "Precio", "Calorias", "Apto Vegano", "Apto Celiaco", "Peso", "Cantidad"};
            Object[][] data= new Object[platos.size()][8];
            int i=0;
            for(Plato p : platos){
                data[i][0] = p.getNombre();
                data[i][1] = p.getCategoria();
                data[i][2] = p.getPrecio();
                data[i][3] = p.getCalorias();
                data[i][4] = p.aptoVegano();
                data[i][5] = p.aptoCeliaco();
                data[i][6] = p.peso();
                data[i][7] = 0;
                i++;
            }
            this.platoTable.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
            i=0;
            String[] columnNames1 = {"Nombre", "Tipo", "Precio", "Graduacion Alcoholica", "Tamaño", "Cantidad"};
            Object[][] dataB= new Object[bebidas.size()][6];
            for(Bebida b : bebidas){
                dataB[i][0] = b.getNombre();
                dataB[i][1] = b.getCategoria();
                dataB[i][2] = b.getPrecio();
                dataB[i][3] = b.getGraduacionAlcoholica();
                dataB[i][4] = b.getTamaño();
                dataB[i][5] = 0;
                i++;
            }
            this.bebidaTable.setModel(new javax.swing.table.DefaultTableModel(dataB, columnNames1));
        }
    }
    private List<ItemMenu> getCantTabla(){
        int cant;
        int cantExistente = 0;
        for(int i=0; i<platos.size(); i++){
            cant = Integer.parseInt((this.platoTable.getValueAt(i, 7)).toString());//get cantidad del item que quiero
            for( ItemMenu item : itemsMenuController.obtenerListaItemsMenu()){
                if(item.getNombre().equals(this.platoTable.getValueAt(i, 0))){//encuentro el item por nombre
                    cantExistente = getCantItems(item);//me fijo cuantos de este item ya hay en el pedido
                }
            }
            for(int j=0; j<(Math.abs(cant-cantExistente)); j++){
                if((cant-cantExistente)>0){//agrego la cant de items
                    for( ItemMenu item : itemsMenuController.obtenerListaItemsMenu()){
                        if(item.getNombre().equals(this.platoTable.getValueAt(i, 0))){//encuentro el pedido por nombre
                            //pedidoController.addItem(item, pedido);
                            items.add(item);
                        }
                    }
                } else if ((cant-cantExistente)<0){//elimino la cant de items
                    for( ItemMenu item : itemsMenuController.obtenerListaItemsMenu()){
                        if(item.getNombre().equals(this.platoTable.getValueAt(i, 0))){//encuentro el pedido por nombre
                            //pedidoController.removeItem(item, pedido);
                            items.add(item);
                        }
                    }
                }
            }
        }
        for(int i=0; i<bebidas.size(); i++){
            cant = Integer.parseInt((this.bebidaTable.getValueAt(i, 5)).toString());//get cantidad del item que quiero
            System.out.println(cant);
            for( ItemMenu item : itemsMenuController.obtenerListaItemsMenu()){
                if(item.getNombre().equals(this.bebidaTable.getValueAt(i, 0))){//encuentro el item por nombre
                    cantExistente = getCantItems(item);//me fijo cuantos de este item ya hay en el pedido
                }
            }
            for(int j=0; j<(Math.abs(cant-cantExistente)); j++){
                if((cant-cantExistente)>0){//agrego la cant de items
                    for( ItemMenu item : itemsMenuController.obtenerListaItemsMenu()){
                        if(item.getNombre().equals(this.bebidaTable.getValueAt(i, 0))){//encuentro el pedido por nombre
                            //pedidoController.addItem(item, pedido);
                            items.add(item);
                        }
                    }
                } else if ((cant-cantExistente)<0){//elimino la cant de items
                    for( ItemMenu item : itemsMenuController.obtenerListaItemsMenu()){
                        if(item.getNombre().equals(this.bebidaTable.getValueAt(i, 0))){//encuentro el pedido por nombre
                            //pedidoController.removeItem(item, pedido);
                            items.add(item);
                        }
                    }
                }
            }
        }
        return items;
    }
    private int getCantItems(ItemMenu item){
        int cant=0;
        if(!(items==null)){
            for(ItemMenu item1 : items){
            if(item.getNombre().equals(item1.getNombre())) cant++;
            }
        }
        return cant;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarButton;
    private javax.swing.JTable bebidaTable;
    private javax.swing.JButton buscarButton;
    private javax.swing.JButton crearButton;
    private javax.swing.JButton editarItemsButton;
    private javax.swing.JButton eliminarButton;
    private javax.swing.JComboBox<String> estadoDropDown;
    private javax.swing.JComboBox<String> formaDePagoDropDown;
    private javax.swing.JTextField idField;
    private javax.swing.JFrame itemsFrame;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable platoTable;
    private javax.swing.JTextField totalField;
    private javax.swing.JComboBox<String> vendedoresDropDown;
    // End of variables declaration//GEN-END:variables
}