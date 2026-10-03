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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.MySQL;

/**
 *
 * @author Akila_Ya
 */
public class SuplierRegisteration extends javax.swing.JFrame {

   private String companyId;
   
   private GRN grn;
   
   public void setGRN(GRN grn){
       this.grn = grn;
   }
    
    public SuplierRegisteration() {
        initComponents();
        loadSupplier("frist_name", "ASC", "");
    }

//    public JTextField getjTextField1(){
//        return jTextField1;
//    }
    
    public void setCompanyName(String name){
        jTextField1.setText(name);
    }
    
    public void grabFocusMobile(){
        jTextField4.grabFocus();
    }
    
    public void setCompanyId(String id){
       companyId = id;
    }
    
    private void loadSupplier(String column, String type, String search){
        
        try {
            
            ResultSet rs = MySQL.execute("SELECT * FROM `supplier` INNER JOIN `company` ON `supplier`.`company_id` = `company`.`id` "
                    + "WHERE `mobile` LIKE '"+search+"%' ORDER BY `"+column+"` "+type+"");
            
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            
            while(rs.next()){
                
                Vector v = new Vector();
                v.add(rs.getString("mobile"));
                v.add(rs.getString("frist_name"));
                v.add(rs.getString("last_name"));
                v.add(rs.getString("email"));
                v.add(rs.getString("company.name"));
                
                model.addRow(v);
                jTable1.setModel(model);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    private void reset(){
        
        companyId = null;
        jTextField1.setText("");
        
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        
        jTextField4.setEditable(true);
        jButton1.setEnabled(true);
        jButton2.setEnabled(false);
        
        jComboBox1.setSelectedIndex(0);
        
        jLabel4.setText("0");
        jLabel7.setText("0");
        
        jButton4.grabFocus();
        
        jTable1.clearSelection();
        
    }
    
    private void search(){
        
        String search = jTextField4.getText();
                
        int index = jComboBox1.getSelectedIndex();
                
        if(index == 0){
            loadSupplier("frist_name", "ASC", search);
        }else if(index == 1){
            loadSupplier("frist_name", "DESC", search);
        }else if(index == 2){
            loadSupplier("company`.`name", "ASC", search);
        }else if(index == 3){
            loadSupplier("company`.`name", "DESC", search);
        }
        
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Email");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 32, -1));

        jTextField1.setEditable(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 170, -1));

        jLabel2.setText("Frist Name");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 164, -1));

        jLabel3.setText("Last Name");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));
        jPanel2.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 164, -1));

        jLabel5.setText("Mobile");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 48, -1));
        jPanel2.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 164, -1));

        jButton1.setText("Create Accoount");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 164, -1));

        jButton2.setText("Update Account");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 164, -1));

        jButton4.setText("Select Company");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 170, -1));

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
        });
        jPanel2.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 164, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 190, 370));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mobile", "Frist Name", "Last Name", "Email", "Company"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 730, 290));

        jLabel6.setText("Sort By");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 48, 20));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Name ASC", "Name DESC", "Company Name ASC", "Company Name DESC" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jPanel3.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 163, -1));

        jButton3.setText("jButton3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 41, -1));

        jLabel4.setText("0");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 14, 150, 20));

        jLabel8.setText("Total GRN");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(467, 16, -1, -1));

        jLabel7.setText("0");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, 150, 20));

        jLabel9.setText("Pending Payements");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 110, 20));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 11, 750, 370));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased

    }//GEN-LAST:event_jTextField1KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String mobile = jTextField4.getText();
        String fname = jTextField2.getText();
        String lname = jTextField3.getText();
        String email = jTextField5.getText();

        
        if(companyId == null){
            JOptionPane.showMessageDialog(this, "Please Select Company", "Warning", JOptionPane.WARNING_MESSAGE);
        }else if(mobile.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter Mobile", "Warning", JOptionPane.WARNING_MESSAGE);
        }else if(mobile.matches("^0((11)|(2(1|[3-7]))|(3[1-8])|(4(1|5|7))|(5(1|2|4|5|7))|(6(3|[5-7]))|([8-9]1))[0-9]{7}$")){
            JOptionPane.showMessageDialog(this, "Invalid Mobile", "Warning", JOptionPane.WARNING_MESSAGE);
        }else  if(fname.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter Frist Name", "Warning", JOptionPane.WARNING_MESSAGE);
        }else  if(lname.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter Last Name", "Warning", JOptionPane.WARNING_MESSAGE);
        }else  if(email.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter email", "Warning", JOptionPane.WARNING_MESSAGE);
        }else if(!email.matches("^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@"
            + "[^-][A-Za-z0-9\\+-]+(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$")){
            JOptionPane.showMessageDialog(this, "Invalid Email", "Warning", JOptionPane.WARNING_MESSAGE);
        }else{
            
            try {
                
                ResultSet rs = MySQL.execute("SELECT * FROM `supplier` WHERE `mobile`='"+mobile+"' OR `email`='"+email+"'");
                
                if(rs.next()){
                    JOptionPane.showMessageDialog(this, "Supllier Already Registerd", "Warning", JOptionPane.WARNING_MESSAGE);
                }else{
                
                    MySQL.execute("INSERT INTO `supplier` (`mobile`, `frist_name`, `last_name`, `email`, `company_id`) "
                         + "VALUES ('"+mobile+"', '"+fname+"', '"+lname+"', '" +email+"', '"+companyId+"')");
                    
                    loadSupplier("frist_name", "ASC", "");
                    reset();
                
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        int row = jTable1.getSelectedRow();
        
        String mobile = jTextField4.getText();
        String fname = jTextField2.getText();
        String lname = jTextField3.getText();
        String email = jTextField5.getText();
   
        if(mobile.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter Mobile", "Warning", JOptionPane.WARNING_MESSAGE);
        }else if(mobile.matches("^0((11)|(2(1|[3-7]))|(3[1-8])|(4(1|5|7))|(5(1|2|4|5|7))|(6(3|[5-7]))|([8-9]1))[0-9]{7}$")){
            JOptionPane.showMessageDialog(this, "Invalid Mobile", "Warning", JOptionPane.WARNING_MESSAGE);
        }else  if(fname.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter Frist Name", "Warning", JOptionPane.WARNING_MESSAGE);
        }else  if(lname.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter Last Name", "Warning", JOptionPane.WARNING_MESSAGE);
        }else  if(email.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter email", "Warning", JOptionPane.WARNING_MESSAGE);
        }else if(!email.matches("^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@"
            + "[^-][A-Za-z0-9\\+-]+(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$")){
            JOptionPane.showMessageDialog(this, "Invalid Email", "Warning", JOptionPane.WARNING_MESSAGE);
        }else{
            
            try {
                
                ResultSet rs = MySQL.execute("SELECT * FROM `supplier` WHERE `email`='"+email+"' AND `mobile`!='"+mobile+"'");
                
                if(rs.next()){
                    JOptionPane.showMessageDialog(this, "Email Already Used", "Warning", JOptionPane.WARNING_MESSAGE);
                }else{
                
                    String x;
                    
                    if(jTextField1.getText().equals(String.valueOf(jTable1.getValueAt(row, 4)))){
                        x = "";
                    }else{
                        x = ", `company_id`='"+companyId+"' ";
                    }
                    
                    MySQL.execute("UPDATE `supplier` SET `frist_name`='"+fname+"', `last_name`='"+lname+"', `email`='"+email+"'"+x+" WHERE `mobile`='"+mobile+"'");
                    
                    loadSupplier("frist_name", "ASC", "");
                    reset();
                
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }   
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        int row = jTable1.getSelectedRow();

        jTextField4.setText(String.valueOf(jTable1.getValueAt(row, 0)));
        jTextField2.setText(String.valueOf(jTable1.getValueAt(row, 1)));
        jTextField3.setText(String.valueOf(jTable1.getValueAt(row, 2)));
        jTextField5.setText(String.valueOf(jTable1.getValueAt(row, 3)));
        jTextField1.setText(String.valueOf(jTable1.getValueAt(row, 4)));
        
        jTextField4.setEditable(false);
        jButton1.setEnabled(false);
        jButton2.setEnabled(true);
        
        try {
            
            ResultSet rs = MySQL.execute("SELECT * FROM `grn` INNER JOIN `grn_item` ON `grn`.`id` = `grn_item`.`grn_id` "
                    + "WHERE `supplier_mobile`='"+String.valueOf(jTable1.getValueAt(row, 0))+"' ");
            
            double total = 0;            
            HashMap<Integer, Double> grns  = new HashMap<>();    
            while(rs.next()){
                
                double qty = rs.getDouble("grn_item.qty");
                double buying_price = rs.getDouble("grn_item.buying_price");
                
                double itemTotal = qty * buying_price;
                
                total += itemTotal;
                
                grns.put(rs.getInt("grn.id"),  rs.getDouble("grn.paid_amount"));
                
            }
            
            double paidTotal = 0;
            for(Double paid : grns.values()){
                paidTotal += paid;
            }
            
            jLabel4.setText(String.valueOf(grns.size()));
            jLabel7.setText(String.valueOf(total - paidTotal));
            
            if(evt.getClickCount() == 2){
                if(grn != null){
                    grn.getTextField2().setText(String.valueOf(jTable1.getValueAt(row, 0)));
                    grn.getJLabel3().setText(String.valueOf(jTable1.getValueAt(row, 1)) + " " + jTable1.getValueAt(row, 2));
                    
                    this.dispose();
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        search();
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased
        
        search();
        
    }//GEN-LAST:event_jTextField4KeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        CompanyrRegisteration cr = new CompanyrRegisteration(this, true);
        cr.setVisible(true);
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        reset();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

    FlatMoonlightContrastIJTheme.setup();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SuplierRegisteration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
