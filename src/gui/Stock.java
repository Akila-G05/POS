/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMoonlightContrastIJTheme;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MySQL;


public class Stock extends javax.swing.JFrame {

    HashMap<String, String> brands = new HashMap<>();
    
    private GRN grn;
    
    public void setGRN(GRN grn){
        this.grn = grn;
    }
    
    private Invoice invoice; 
    
    public void setInvoice(Invoice invoice){
        this.invoice = invoice;
    }
    
    public Stock() {
        initComponents();
        loadBrands();
        loadProducts();
        loadStock();
    }

    private void loadBrands(){
        
        try {
            
            ResultSet rs = MySQL.execute("SELECT * FROM `brand`");
            
            Vector v = new Vector();
            v.add("Select");
            
            while(rs.next()){
                v.add(rs.getString("name"));      
                brands.put(rs.getString("name"), rs.getString("id"));
            }
            
            DefaultComboBoxModel model = new DefaultComboBoxModel(v);
            jComboBox1.setModel(model);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    private void loadProducts(){
        
        try {
            
            ResultSet rs = MySQL.execute("SELECT * FROM `product` INNER JOIN `brand` ON `product`.`brand_id` = `brand`.`id`");
            
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setRowCount(0);
            
            while(rs.next()){
                
                Vector v = new Vector();
                v.add(rs.getString("product.id"));
                v.add(rs.getString("brand.name"));
                v.add(rs.getString("product.name"));
                
                model.addRow(v);
                jTable2.setModel(model);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    private void resetProductUi(){
        
        jTextField2.setText("");
        jTextField1.setText("");
        jTextField3.setText("");
        jComboBox1.setSelectedIndex(0);
        
    }
    
    private void loadStock(){
        
        try {
            
            int row = jTable2.getSelectedRow();
            
            String query = "SELECT * FROM `stock` INNER JOIN `product` ON `stock`.`product_id` = `product`.`id` "
                    + "INNER JOIN `brand` ON `brand`.`id`=`product`.`brand_id` ";
            
            if(row != -1){
                String pid = String.valueOf(jTable2.getValueAt(row, 0));
                query += "WHERE `stock`.`product_id` = '"+pid+"' ";
            }
            
            
            if(query.contains("WHERE")){
                query+="AND ";
            }else{
                query+="WHERE ";
            }
            
            
            double min_price = 0;
            double max_price = 0;
            
            if(!jFormattedTextField1.getText().isEmpty()){
                min_price = Double.parseDouble(jFormattedTextField1.getText());
            }
            
            if(!jFormattedTextField2.getText().isEmpty()){
                max_price = Double.parseDouble(jFormattedTextField2.getText());
            }
            
            if(min_price > 0 && max_price == 0){
                query += "`stock`.`selling_price` > '"+min_price+"'";
            }else if(min_price == 0 && max_price > 0){
                query += "`stock`.`selling_price` < '"+max_price+"'";
            }else if(min_price > 0 && max_price > 0){
                query += "`stock`.`selling_price` > '"+min_price+"' AND `stock`.`selling_price` < '"+max_price+"'";
            }
            
            query += "ORDER BY ";      
            String sort = String.valueOf(jComboBox2.getSelectedItem());   
            
            query = query.replace("WHERE ORDER BY ", "ORDER BY ");
            query = query.replace("AND ORDER BY ", "ORDER BY ");

            if(sort == "Stock ID ASC"){
                query += "`stock`.`id` ASC"; 
            }else if(sort == "Stock ID DESC"){
                query += "`stock`.`id` DESC"; 
            }else if(sort == "Brand ASC"){
                query += "`brand`.`name` ASC"; 
            }else if(sort == "Brand DESC"){
                query += "`brand`.`name` DESC"; 
            }else if(sort == "Name ASC"){
                query += "`product`.`name` ASC"; 
            }else if(sort == "Name DESC"){
                query += "`product`.`name` DESC"; 
            }else if(sort == "Selling Price ASC"){
                query += "`stock`.`selling_price` ASC"; 
            }else if(sort == "Selling Price DESC"){
                query += "`stock`.`selling_price` DESC"; 
            }else if(sort == "Quantity ASC"){
                query += "`stock`.`qty` ASC"; 
            }else if(sort == "Quantity DESC"){
                query += "`stock`.`qty` DESC"; 
            }
            
            ResultSet rs = MySQL.execute(query);
            
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            
            while(rs.next()){
                
                Vector v = new Vector();
                v.add(rs.getString("stock.id"));
                v.add(rs.getString("product.id"));
                v.add(rs.getString("brand.name"));
                v.add(rs.getString("product.name"));
                v.add(rs.getString("selling_price"));
                v.add(rs.getString("qty"));
                v.add(rs.getString("mfd"));
                v.add(rs.getString("exp"));
                
                model.addRow(v);
                jTable1.setModel(model);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Product ID", "Brand", "Product Name", "Selling Price", "Qty", "MFG", "EXP"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Brand", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(0).setHeaderValue("ID");
            jTable2.getColumnModel().getColumn(1).setHeaderValue("Brand");
            jTable2.getColumnModel().getColumn(2).setHeaderValue("Name");
        }

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));

        jLabel1.setText("Product ID");

        jLabel2.setText("Brand");

        jLabel3.setText("Product Name");

        jButton1.setText("Add New Product");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Update Product");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("+");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("...");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3))
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton3)))
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));

        jLabel4.setText("Sort By");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Stock ID ASC", "Stock ID DESC", "Brand ASC", "Brand DESC", "Name ASC", "Name DESC", "Selling Price ASC", "Selling Price DESC", "Quantity ASC", "Quantity DESC" }));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });

        jLabel5.setText("Selling Price");

        jLabel6.setText("To");

        jLabel7.setText("EXP");

        jDateChooser1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel8.setText("To");

        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jFormattedTextField1.setText("0");
        jFormattedTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField1ActionPerformed(evt);
            }
        });

        jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jFormattedTextField2.setText("0");
        jFormattedTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField2ActionPerformed(evt);
            }
        });

        jButton5.setText("Find");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(36, 36, 36)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7)
                        .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton5))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        String brand = jTextField2.getText();
        
        if(brand.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter Brand Name", "Warning", JOptionPane.WARNING_MESSAGE );
        }else{
            
            try {
                
                ResultSet rs = MySQL.execute("SELECT * FROM `brand` WHERE `name` = '"+brand+"'");
                
                if(rs.next()){
                    JOptionPane.showMessageDialog(this, "This Brand Already Exist", "Warning", JOptionPane.WARNING_MESSAGE );
                }else{
                    
                    if(jComboBox1.getSelectedIndex() == 0){
                        MySQL.execute("INSERT INTO `brand` (`name`) VALUES ('"+brand+"')");
                        JOptionPane.showMessageDialog(this, "New Brand Added", "Success", JOptionPane.INFORMATION_MESSAGE );
                    }else{
                        int response = JOptionPane.showConfirmDialog(this, "Are you sure want to update this brand??", "Update", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        
                        if(response == JOptionPane.YES_OPTION){
                            MySQL.execute("UPDATE `brand` SET `name`='"+brand+"' WHERE `name`='"+String.valueOf(jComboBox1.getSelectedItem())+"'");
                            JOptionPane.showMessageDialog(this, "Brand Updated", "Success", JOptionPane.INFORMATION_MESSAGE );
                        }
                    }

                    loadBrands();
                    resetProductUi();
                    
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        String id = jTextField1.getText();
        String brand = String.valueOf(jComboBox1.getSelectedItem());
        String name = jTextField3.getText();
        
        if(id.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter Product ID", "Warning", JOptionPane.WARNING_MESSAGE );
        }else if(jComboBox1.getSelectedItem() == "Select"){
            JOptionPane.showMessageDialog(this, "PleaseSelect Brand", "Warning", JOptionPane.WARNING_MESSAGE );
        }else if(name.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter Product Name", "Warning", JOptionPane.WARNING_MESSAGE );
        }else{
            
            try { 
                
                ResultSet rs = MySQL.execute("SELECT * FROM `product` WHERE `id`='"+id+"' OR (`name` = '"+name+"' AND `brand_id` = '"+brands.get(brand)+"')");

                if(rs.next()){
                    JOptionPane.showMessageDialog(this, "Product Already Added", "Warning", JOptionPane.WARNING_MESSAGE );
                }else{
                    MySQL.execute("INSERT INTO `product` (`id`, `brand_id`, `name`) VALUES ('"+id+"', '"+brands.get(brand)+"', '"+name+"')");
                    JOptionPane.showMessageDialog(this, "Product Added", "Success", JOptionPane.INFORMATION_MESSAGE );
                    
                    resetProductUi();
                    loadProducts();
                }
                    
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
       
        int row = jTable2.getSelectedRow();
        
        if(evt.getClickCount() == 1){
            
            jTextField1.setText(String.valueOf(jTable2.getValueAt(row, 0)));
            jTextField3.setText(String.valueOf(jTable2.getValueAt(row, 2)));
            jComboBox1.setSelectedItem(String.valueOf(jTable2.getValueAt(row, 1)));
            
            jTextField1.setEditable(false);
            
            loadStock();
            
        }
        
        if(evt.getClickCount() == 2){
            
            grn.getjTextField3().setText(String.valueOf(jTable2.getValueAt(row, 0)));
            grn.getjLabel12().setText(String.valueOf(jTable2.getValueAt(row, 1)));
            grn.getjLabel14().setText(String.valueOf(jTable2.getValueAt(row, 2)));
            
            grn.getQtyField().grabFocus();
            this.dispose();
            
        }
        
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        String id = jTextField1.getText();
        String brand = String.valueOf(jComboBox1.getSelectedItem());
        String name = jTextField3.getText();
        
        if(jComboBox1.getSelectedItem() == "Select"){
            JOptionPane.showMessageDialog(this, "Please Select Brand", "Warning", JOptionPane.WARNING_MESSAGE );
        }else if(name.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter Product Name", "Warning", JOptionPane.WARNING_MESSAGE );
        }else{
            
            try { 
                
                ResultSet rs = MySQL.execute("SELECT * FROM `product` WHERE `name` = '"+name+"' AND `brand_id` = '"+brands.get(brand)+"' AND `id`!='"+id+"'");

                if(rs.next()){
                    JOptionPane.showMessageDialog(this, "Product Already Added", "Warning", JOptionPane.WARNING_MESSAGE );
                }else{
                    MySQL.execute("UPDATE `product` SET `brand_id` = '"+brands.get(brand)+"', `name` = '"+name+"' WHERE `id` = '"+id+"' ");
                    JOptionPane.showMessageDialog(this, "Product Updated", "Success", JOptionPane.INFORMATION_MESSAGE );
                    
                    resetProductUi();
                    loadProducts();
                }
                    
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        loadStock();
        resetProductUi();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        
        loadStock();
        
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       
        String price_min = jFormattedTextField1.getText();
        String price_max = jFormattedTextField2.getText();
        
        if(Double.parseDouble(price_min) < Double.parseDouble(price_max)){
            JOptionPane.showMessageDialog(this, "Min Price Greater Than Max Price", "Warning", JOptionPane.WARNING_MESSAGE);
            jFormattedTextField2.setText("");
            loadStock();
        }else {
            
            loadStock();
            
        }
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jFormattedTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
        int row = jTable1.getSelectedRow();
        
        if(evt.getClickCount() == 2){
            
            if(invoice != null){
                
                invoice.getjTextField3().setText(String.valueOf(jTable1.getValueAt(row, 0)));
                invoice.getjLabel12().setText(String.valueOf(jTable1.getValueAt(row, 2)));
                invoice.getjLabel14().setText(String.valueOf(jTable1.getValueAt(row, 3)));
                invoice.getjFormattedTextField3().setText(String.valueOf(jTable1.getValueAt(row, 4)));
                invoice.getjLabel24().setText(String.valueOf(jTable1.getValueAt(row, 5)));
                invoice.getjLabel25().setText(String.valueOf(jTable1.getValueAt(row, 6)));
                invoice.getjLabel26().setText(String.valueOf(jTable1.getValueAt(row, 7)));
                
                this.dispose();
                
            }
            
        }
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jFormattedTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        FlatMoonlightContrastIJTheme.setup();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Stock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
