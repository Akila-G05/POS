/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMoonlightContrastIJTheme;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MySQL;

/**
 *
 * @author Akila_Ya
 */
public class CustomerRegistration extends javax.swing.JFrame {

    private Invoice invoice;
    
    public void setInvoice(Invoice invoice){
        this.invoice = invoice;
    }
   
    public CustomerRegistration() {
        initComponents();
        loadCustomers("frist_name", "ASC", "07");
    }
    
    private void search(){
        
        int sortIndex = jComboBox1.getSelectedIndex();
        String mobile = jTextField1.getText();
        
        if(sortIndex == 0){
            loadCustomers("frist_name", "ASC", mobile);
        }else if(sortIndex == 1){
            loadCustomers("frist_name", "DESC", mobile);
        }else if(sortIndex == 2){
            loadCustomers("Points", "ASC", mobile);
        }else if(sortIndex == 3){
            loadCustomers("Points", "DESC", mobile);
        }
       
        
    }

    private void loadCustomers(String column, String method, String mobile){
        
        try {
            
            ResultSet rs = MySQL.execute("SELECT * FROM `customer` WHERE `mobile` LIKE '%"+mobile+"%' ORDER BY `"+column+"` "+method+" ");
            
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            
            while(rs.next()){
                
                Vector v = new Vector();
                v.add(rs.getString("mobile"));
                v.add(rs.getString("frist_name"));
                v.add(rs.getString("last_name"));
                v.add(rs.getString("email"));
                v.add(rs.getString("points"));
                
                model.addRow(v);
                jTable1.setModel(model);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    private void reset(){
        
        jTextField1.setText("");
        jTextField1.setEditable(true);
        
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField5.setText("");
        jButton1.setEnabled(true);
        
        jTable1.clearSelection();
        
        jTextField1.grabFocus();
        
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
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Email");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 165, 32, -1));

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
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 32, 164, -1));

        jLabel2.setText("Frist Name");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 63, -1, -1));
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 83, 164, -1));

        jLabel3.setText("Last Name");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 114, -1, -1));
        jPanel2.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 134, 164, -1));

        jLabel5.setText("Mobile");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 12, 48, -1));
        jPanel2.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 185, 164, -1));

        jButton1.setText("Create Accoount");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 236, 164, -1));

        jButton2.setText("Update Account");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 265, 164, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 190, 311));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mobile", "Frist Name", "Last Name", "Email", "Points"
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

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 49, 730, 250));

        jLabel6.setText("Sort By");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 16, 48, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Name ASC", "Name DESC", "Points ASC", "Points DESC" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jPanel3.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 13, 163, -1));

        jButton3.setText("jButton3");
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 12, 41, -1));

        jLabel4.setText("...");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 14, 150, 20));

        jLabel8.setText("Total Invoices");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(467, 16, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 11, 750, 310));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String mobile = jTextField1.getText();
        String fname = jTextField2.getText();
        String lname = jTextField3.getText();
        String email = jTextField5.getText();
       
        if(mobile.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter Mobile Number",  "Warning", JOptionPane.WARNING_MESSAGE);
        }else if(mobile.matches("^07[01245678] {1} [0-9] {7}$")){
            JOptionPane.showMessageDialog(this, "Please Enter Valid Mobile",  "Warning", JOptionPane.WARNING_MESSAGE);
        }else if(fname.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter Frist Name",  "Warning", JOptionPane.WARNING_MESSAGE);
        }else if(lname.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter Last Name",  "Warning", JOptionPane.WARNING_MESSAGE);
        }else if(email.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter Email",  "Warning", JOptionPane.WARNING_MESSAGE);
        }else if(!email.matches("^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@"
            + "[^-][A-Za-z0-9\\+-]+(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$")){
            JOptionPane.showMessageDialog(this, "Please Enter Valid Email", "warning", JOptionPane.WARNING_MESSAGE);
        }else{
            
            try {
                
                ResultSet resultset = MySQL.execute("SELECT * FROM `customer` WHERE `mobile`='"+mobile+"' OR `email`='"+mobile+"' ");
                
                if(resultset.next()){
                    JOptionPane.showMessageDialog(this, "Customer Already Regiserd.", "warning", JOptionPane.WARNING_MESSAGE);
                }else{
                    
                    MySQL.execute("INSERT INTO `customer` (`mobile`, `frist_name`, `last_name`, `email`, `points`) "
                            + "VALUES ('"+mobile+"', '"+fname+"', '"+lname+"', '"+email+"', '0')");
                    
                    reset();
                    loadCustomers("frist_name", "ASC", "07");
                    
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        String mobile = jTextField1.getText();
        String fname = jTextField2.getText();
        String lname = jTextField3.getText();
        String email = jTextField5.getText();
       
        if(fname.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter Frist Name",  "Warning", JOptionPane.WARNING_MESSAGE);
        }else if(lname.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter Last Name",  "Warning", JOptionPane.WARNING_MESSAGE);
        }else if(email.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter Email",  "Warning", JOptionPane.WARNING_MESSAGE);
        }else if(!email.matches("^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@"
            + "[^-][A-Za-z0-9\\+-]+(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$")){
            JOptionPane.showMessageDialog(this, "Please Enter Valid Email", "warning", JOptionPane.WARNING_MESSAGE);
        }else{
            
            try {
                
                ResultSet resultset = MySQL.execute("SELECT * FROM `customer` WHERE `email`='"+email+"'");
                
                boolean isFound = false;
                
                if(resultset.next()){
                    
                    if(resultset.getString("mobile").equals(mobile)){
                        isFound = true;
                        System.out.println("1");
                    }else{
                        JOptionPane.showMessageDialog(this, "Email Already Registerd.", "warning", JOptionPane.WARNING_MESSAGE);
                    }
                    
                }else{
                    isFound = true;       
                    System.out.println("2");
                }
                
                if(isFound){
                    MySQL.execute("UPDATE `customer` SET `frist_name`=  '"+fname+"', `last_name`=  '"+lname+"', `email`=  '"+email+"' WHERE `mobile`='"+mobile+"'");
                    
                    reset();
                    loadCustomers("frist_name", "ASC", "07");
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        int row = jTable1.getSelectedRow();
       if(evt.getClickCount() == 1){
           
           String mobile = String.valueOf(jTable1.getValueAt(row, 0));
           
           jTextField1.setText(mobile);
           jTextField1.setEditable(false);
           
           jTextField2.setText(String.valueOf(jTable1.getValueAt(row, 1)));
           jTextField3.setText(String.valueOf(jTable1.getValueAt(row, 2)));
           jTextField5.setText(String.valueOf(jTable1.getValueAt(row, 3)));
           
           jButton1.setEnabled(false);
           
           try {
               
               ResultSet rs = MySQL.execute("SELECT COUNT(`id`) FROM `invoice` WHERE `customer_mobile`='"+mobile+"'");
               
               if(rs.next()){
                   String count = rs.getString(1);
                   jLabel4.setText(count);
               }else{
                   jLabel4.setText("0");
               }
               
           } catch (Exception e) {
               e.printStackTrace();
           }
           
       }else if(evt.getClickCount() == 2){
           if(invoice != null){
               invoice.getjTextField2().setText(String.valueOf(jTable1.getValueAt(row, 0)));
               invoice.getjLabel5().setText(String.valueOf(jTable1.getValueAt(row, 1) +" "+ jTable1.getValueAt(row, 2)));
               invoice.getjLabel6().setText(String.valueOf(jTable1.getValueAt(row, 4)));
               
               this.dispose();
           }
       }

    }//GEN-LAST:event_jTable1MouseClicked

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
       
        search();
        
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        search();
    }//GEN-LAST:event_jTextField1KeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        FlatMoonlightContrastIJTheme.setup();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerRegistration().setVisible(true);
            }
        });
    }

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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
