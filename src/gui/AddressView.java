/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MySQL;

/**
 *
 * @author Akila_Ya
 */
public class AddressView extends javax.swing.JDialog {

    private String email;
    private static HashMap<String, String> cityMap = new HashMap<>();
    
    public AddressView(java.awt.Frame parent, boolean modal, String email) {
        super(parent, modal);
        initComponents();      
        jLabel1.setText(email);
        this.email = email;
        
        loadAddress();
        loadCities();
    }
    
    public void loadAddress(){
        
        try {
            
            ResultSet resultset = MySQL.execute("SELECT * FROM `employee_address` "
                    + "INNER JOIN `city` ON `employee_address`.`city_id` = `city`.`id`  WHERE `employee_email`='"+this.email+"'");
            
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setRowCount(0);
            
            while(resultset.next()){
                
                Vector v = new Vector();
                v.add(resultset.getString("id"));
                v.add(resultset.getString("line1"));
                v.add(resultset.getString("line2"));
                v.add(resultset.getString("city.name"));
                
                model.addRow(v);
                jTable2.setModel(model);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    private void loadCities(){
        
        try {    
            
            ResultSet resultset = MySQL.execute("SELECT * FROM `city`");
            
            Vector v = new Vector();
            v.add("Select");
            while (resultset.next()) {
                v.add(resultset.getString("name"));
                cityMap.put(resultset.getString("name"), resultset.getString("id"));
            }
            
            DefaultComboBoxModel model = new DefaultComboBoxModel(v);
            jComboBox1.setModel(model);
            
        } catch (Exception e) {
        }
        
    }

    private void reset(){
        jTextField1.setText("");
        jTextField2.setText("");
        jComboBox1.setSelectedItem("Select");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("...");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Employee");

        jLabel3.setText("Address Line 1");

        jLabel4.setText("Address Line 2");

        jLabel5.setText("Crty");

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Line 1", "Line 2", "City"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
        jScrollPane1.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(59, 59, 59)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField2)
                                .addComponent(jComboBox1, 0, 178, Short.MAX_VALUE)))))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String line1 = jTextField1.getText();
        String line2 = jTextField2.getText();
        String city = String.valueOf(jComboBox1.getSelectedItem());
        
        if(line1.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter Address Line 1",  "Warning", JOptionPane.WARNING_MESSAGE);
        }else if(line2.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter Address Line 2",  "Warning", JOptionPane.WARNING_MESSAGE);
        }else if(city.equals("Select")){
            JOptionPane.showMessageDialog(this, "Please Select City",  "Warning", JOptionPane.WARNING_MESSAGE);
        }else{
            
            boolean isFound = false;
            
            for (int i = 0; i < jTable2.getRowCount(); i++) {
                String getLine1 = String.valueOf(jTable2.getValueAt(i, 1));
                String getLine2 = String.valueOf(jTable2.getValueAt(i, 2));
                String getCity = String.valueOf(jTable2.getValueAt(i, 3));
                
                if(getLine1.equals(line1) && getLine2.equals(line2) && getCity.equals(city)){
                    JOptionPane.showMessageDialog(this, "This Address Already Exists",  "Warning", JOptionPane.WARNING_MESSAGE);
                    isFound = true;
                    break;
                }
            }
            
           if(!isFound){
                try {
                    String cid = cityMap.get(city);          
                    MySQL.execute("INSERT INTO `employee_address` (`line1`, `line2`, `city_id`, `employee_email`) "
                            + "VALUES ('"+line1+"', '"+line2+"', '"+cid+"','"+this.email+"') ");

                    loadAddress();
                    reset();
                } catch (Exception e) {
                    e.printStackTrace();
                }
           }
            
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        
        int row = jTable2.getSelectedRow();
        
        if(evt.getClickCount() == 2){
            
            cityMap.put("ID", String.valueOf(jTable2.getValueAt(row, 0)));
            
            jTextField1.setText(String.valueOf(jTable2.getValueAt(row, 1)));
            jTextField2.setText(String.valueOf(jTable2.getValueAt(row, 2)));
            jComboBox1.setSelectedItem(String.valueOf(jTable2.getValueAt(row, 3)));
           
        }
        
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        String line1 = jTextField1.getText();
        String line2 = jTextField2.getText();
        String city = String.valueOf(jComboBox1.getSelectedItem());
        
        if(line1.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter Address Line 1",  "Warning", JOptionPane.WARNING_MESSAGE);
        }else if(line2.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter Address Line 2",  "Warning", JOptionPane.WARNING_MESSAGE);
        }else if(city.equals("Select")){
            JOptionPane.showMessageDialog(this, "Please Select City",  "Warning", JOptionPane.WARNING_MESSAGE);
        }else{
            
            boolean isFound = false;
            
            for (int i = 0; i < jTable2.getRowCount(); i++) {
                String getLine1 = String.valueOf(jTable2.getValueAt(i, 1));
                String getLine2 = String.valueOf(jTable2.getValueAt(i, 2));
                String getCity = String.valueOf(jTable2.getValueAt(i, 3));
                
                if(getLine1.equals(line1) && getLine2.equals(line2) && getCity.equals(city)){
                    JOptionPane.showMessageDialog(this, "This Address Already Exists",  "Warning", JOptionPane.WARNING_MESSAGE);
                    isFound = true;
                    break;
                }
            }
            
            if(!isFound){

                try {
                    String id = cityMap.get("ID");
                    String cid = cityMap.get(city);          
                    MySQL.execute("UPDATE `employee_address` SET `line1`='"+line1+"', `line2`='"+line2+"', `city_id`='"+cid+"' WHERE `id`='"+id+"'");

                    loadAddress();
                    reset();
                } catch (Exception e) {
                    e.printStackTrace();
                }
             }
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        int row = jTable2.getSelectedRow();
        
        if(row == -1){
             JOptionPane.showMessageDialog(this, "Please Select a Row",  "Warning", JOptionPane.WARNING_MESSAGE);
        }else{
        
            try {

                String id = String.valueOf(jTable2.getValueAt(row, 0));
                MySQL.execute("DELETE FROM `employee_address` WHERE `id`='"+id+"' ");

                loadAddress();
                reset();

            } catch (Exception e) {
            }
        
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
