/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMoonlightContrastIJTheme;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class EmployeeReigisteration extends javax.swing.JFrame {

    private static HashMap<String, String> employeeTypeMap = new HashMap<>();
    private static HashMap<String, String> employeeGenderMap = new HashMap<>();
   
    public EmployeeReigisteration() {
        initComponents();
        loadTypes();
        loadGender();
        loadEmployee();
    }

    //Load Employee Types
    private void loadTypes(){
        
        try {
            
            ResultSet resultset = MySQL.execute("SELECT * FROM `employee_type`");
            
            Vector v = new Vector();
            v.add("Select");
            while (resultset.next()) {
                v.add(resultset.getString("name"));
                employeeTypeMap.put(resultset.getString("name"), resultset.getString("id"));
            }
            
            DefaultComboBoxModel model = new DefaultComboBoxModel(v);
            jComboBox1.setModel(model);
            
        } catch (Exception e) {
        }
        
    }
    
    //Load Gender
    private void loadGender(){
        
        try {
            
            ResultSet resultset = MySQL.execute("SELECT * FROM `gender`");
            
            Vector v = new Vector();
            v.add("Select");
            while (resultset.next()) {
                v.add(resultset.getString("name"));
                employeeGenderMap.put(resultset.getString("name"), resultset.getString("id"));
            }
            
            DefaultComboBoxModel model = new DefaultComboBoxModel(v);
            jComboBox2.setModel(model);
            
        } catch (Exception e) {
        }
        
    }
    
    //Load Employees
    private void loadEmployee(){
        
        try {
            
            ResultSet resultSet = MySQL.execute("SELECT * FROM `employee` "
                    + "INNER JOIN `employee_type` ON `employee`.`employee_type_id`=`employee_type`.`id` "
                    + "INNER JOIN `gender` ON `employee`.`gender_id` = `gender`.`id`");
            
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            
            while(resultSet.next()){
                
                Vector v = new Vector();
                v.add(resultSet.getString("email"));
                v.add(resultSet.getString("frist_name"));
                v.add(resultSet.getString("last_name"));
                v.add(resultSet.getString("nic"));
                v.add(resultSet.getString("mobile"));
                v.add(resultSet.getString("gender.name"));
                v.add(resultSet.getString("password"));
                v.add(resultSet.getString("employee_type.name"));
                v.add(resultSet.getString("date_registerd"));
                
                model.addRow(v);
                jTable1.setModel(model);
                
            }
            
        } catch (Exception e) {
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
        jTextField4 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        jLabel1.setText("Email");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Frist Name");

        jLabel3.setText("Last Name");

        jLabel4.setText("NIC");

        jLabel5.setText("Mobile");

        jLabel6.setText("Password");

        jLabel7.setText("Type");

        jLabel8.setText("Gender");

        jButton1.setText("Create Accoount");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Update Account");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField2)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField5)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(3, 3, 3)
                        .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Email", "Frist Name", "Last Name", "NIC", "Mobile", "Gender", "Password", "Type", "Register Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
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
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(1).setResizable(false);
        }

        jButton3.setText("Clear Selection");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Add Employee
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String email = jTextField1.getText();
        String fname = jTextField2.getText();
        String lname = jTextField3.getText();
        String nic = jTextField4.getText();
        String mobile = jTextField5.getText();
        String password = String.valueOf(jPasswordField1.getPassword());
        String type = String.valueOf( jComboBox1.getSelectedItem());
        String gender = String.valueOf( jComboBox2.getSelectedItem());

        if(email.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter Email",  "Warning", JOptionPane.WARNING_MESSAGE);
        }else if(!email.matches("^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@"
            + "[^-][A-Za-z0-9\\+-]+(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$")){
        JOptionPane.showMessageDialog(this, "Please Enter Valid Email", "warning", JOptionPane.WARNING_MESSAGE);
        }else if(fname.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter Frist Name",  "Warning", JOptionPane.WARNING_MESSAGE);
        }else if(lname.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter Last Name",  "Warning", JOptionPane.WARNING_MESSAGE);
        }else if(nic.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter NIC",  "Warning", JOptionPane.WARNING_MESSAGE);
        }else if(mobile.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter Mobile Number",  "Warning", JOptionPane.WARNING_MESSAGE);
        }else if(mobile.matches("^07[01245678] {1} [0-9] {7}$")){
            JOptionPane.showMessageDialog(this, "Please Enter Valid Mobile",  "Warning", JOptionPane.WARNING_MESSAGE);
        }else if(password.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter Password",  "Warning", JOptionPane.WARNING_MESSAGE);
        }else if(password.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$")){
            JOptionPane.showMessageDialog(this, "Minimum eight characters, at least one letter, one number and one special character",  "Warning", JOptionPane.WARNING_MESSAGE);
        }else if(type.equals("Select")){
            JOptionPane.showMessageDialog(this, "Please Select Type",  "Warning", JOptionPane.WARNING_MESSAGE);
        }else if(gender.equals("Select")){
            JOptionPane.showMessageDialog(this, "Please Select Gender",  "Warning", JOptionPane.WARNING_MESSAGE);
        }else{

            try {

                ResultSet resultset = MySQL.execute("SELECT * FROM `employee` WHERE  `email` = '"+email+"' OR `nic` = '"+nic+"' OR `mobile` = '"+mobile+"'");

                if(resultset.next()){
                    JOptionPane.showMessageDialog(this, "Email OR Mobile OR NIC Already Used",  "Warning", JOptionPane.WARNING_MESSAGE);
                }else{

                    Date date = new Date();
                    SimpleDateFormat df = new SimpleDateFormat("yy-MM-dd");
                    String newdate = df.format(date);

                    String eid = employeeTypeMap.get(type);
                    String gid = employeeGenderMap.get(gender);

                    MySQL.execute("INSERT INTO `employee` (`email`, `password`, `frist_name`, `last_name`, `nic`, `mobile`, `employee_type_id`, `date_registerd`, `gender_id`) "
                        + "VALUES('"+email+"', '"+password+"', '"+fname+"',  '"+lname+"', '" +nic+"', '"+mobile+"', '"+eid+"', '"+newdate+"', '"+gid+"')");

                    reset();
                    loadEmployee();

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String email = jTextField1.getText();
        String fname = jTextField2.getText();
        String lname = jTextField3.getText();
        String nic = jTextField4.getText();
        String mobile = jTextField5.getText();
        String password = String.valueOf(jPasswordField1.getPassword());
        String type = String.valueOf( jComboBox1.getSelectedItem());
        String gender = String.valueOf( jComboBox2.getSelectedItem());

        if(email.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter Email",  "Warning", JOptionPane.WARNING_MESSAGE);
        }else if(fname.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter Frist Name",  "Warning", JOptionPane.WARNING_MESSAGE);
        }else if(lname.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter Last Name",  "Warning", JOptionPane.WARNING_MESSAGE);
        }else if(nic.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter NIC",  "Warning", JOptionPane.WARNING_MESSAGE);
        }else if(mobile.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter Mobile Number",  "Warning", JOptionPane.WARNING_MESSAGE);
        }else if(mobile.matches("^07[01245678] {1} [0-9] {7}$")){
            JOptionPane.showMessageDialog(this, "Please Enter Valid Mobile",  "Warning", JOptionPane.WARNING_MESSAGE);
        }else if(password.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter Password",  "Warning", JOptionPane.WARNING_MESSAGE);
        }else if(password.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$")){
            JOptionPane.showMessageDialog(this, "Minimum eight characters, at least one letter, one number and one special character",  "Warning", JOptionPane.WARNING_MESSAGE);
        }else if(type.equals("Select")){
            JOptionPane.showMessageDialog(this, "Please Select Type",  "Warning", JOptionPane.WARNING_MESSAGE);
        }else if(gender.equals("Select")){
            JOptionPane.showMessageDialog(this, "Please Select Gender",  "Warning", JOptionPane.WARNING_MESSAGE);
        }else{

            try {

                ResultSet resultset = MySQL.execute("SELECT * FROM `employee` WHERE `nic` = '"+nic+"' OR `mobile` = '"+mobile+"'");

                boolean canUpdate = false;
                
                if(resultset.next()){
                    
                    if(!resultset.getString("email").equals(email) ){
                        JOptionPane.showMessageDialog(this, "Email OR Mobile OR NIC Already Used",  "Warning", JOptionPane.WARNING_MESSAGE);
                    }else{
                        canUpdate = true;
                    }
                    
                }else{

                    canUpdate = true;

                }
                
                if(canUpdate){
                    
                    String eid = employeeTypeMap.get(type);
                    String gid = employeeGenderMap.get(gender);
                    
                    MySQL.execute("UPDATE `employee` SET "
                            + "`frist_name`='"+fname+"', "
                                    + "`last_name`='"+lname+"', "
                                            + "`nic`='"+nic+"', "
                                                    + "`mobile`='"+mobile+"', "
                                                            + "`gender_id`='"+gid+"', "
                                                                    + "`password`='"+password+"', "
                                                                            + "`employee_type_id`='"+eid+"' "
                                                                                    + "WHERE `email`='"+email+"'");
 
                    reset();
                    loadEmployee();
                    
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
        if(evt.getClickCount() == 1){
            
            int row = jTable1.getSelectedRow();

            String email = String.valueOf(jTable1.getValueAt(row, 0));
            jTextField1.setText(email);
            jTextField1.setEditable(false);
            
            String fname = String.valueOf(jTable1.getValueAt(row, 1));
            jTextField2.setText(fname);
            
            String lname = String.valueOf(jTable1.getValueAt(row, 2));
            jTextField3.setText(lname);
            
            String nic = String.valueOf(jTable1.getValueAt(row, 3));
            jTextField4.setText(nic);
            
            String mobile = String.valueOf(jTable1.getValueAt(row, 4));
            jTextField5.setText(mobile);
            
            String password = String.valueOf(jTable1.getValueAt(row, 6));
            jPasswordField1.setText(password);
            
            String gender = String.valueOf(jTable1.getValueAt(row, 5));
            jComboBox2.setSelectedItem(gender);
            
            String type = String.valueOf(jTable1.getValueAt(row, 7));
            jComboBox1.setSelectedItem(type);
            
        }else if(evt.getClickCount() == 2){
            
            int row = jTable1.getSelectedRow();
            String email = String.valueOf(jTable1.getValueAt(row, 0));
            
//            this.setEnabled(false);
            AddressView addressView = new AddressView(this, true, email);
            addressView.setVisible(true);
            
        }
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jTextField1.setEditable(true);
        jTable1.clearSelection();
        reset();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    //Reset
    private void reset(){
        
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        
        jPasswordField1.setText("");
        
        jComboBox1.setSelectedItem("Select");
        jComboBox2.setSelectedItem("Select");
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        FlatMoonlightContrastIJTheme.setup();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeReigisteration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
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
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
