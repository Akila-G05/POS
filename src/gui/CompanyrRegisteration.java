/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MySQL;

/**
 *
 * @author Akila_Ya
 */
public class CompanyrRegisteration extends javax.swing.JDialog {

   SuplierRegisteration cr;
  
    public CompanyrRegisteration(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loadCompanies();
        
        cr = (SuplierRegisteration)parent;
    }

    private void loadCompanies(){
        
        try {
            
            ResultSet rs = MySQL.execute("SELECT * FROM `company`");
            
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            
            while(rs.next()){
                
                Vector v = new Vector();
                v.add(rs.getString("id"));
                v.add(rs.getString("name"));
                v.add(rs.getString("hotline"));
                
                model.addRow(v);
                jTable1.setModel(model);
                
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    private void reset(){
        
        jTextField1.setText("");
        jTextField2.setText("");
        jButton1.setEnabled(true);
        
        jTextField1.grabFocus();
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Hotline"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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

        jLabel1.setText("Name");

        jLabel2.setText("Hotline");

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

        jButton4.setText("Clear");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .addContainerGap())
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
    }// </editor-fold>                        

    //ADD
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        String name = jTextField1.getText();
        String hotline = jTextField2.getText();
        
        if(name.isEmpty()){
            JOptionPane.showMessageDialog(this, "Enter Company Name", "warning", JOptionPane.WARNING_MESSAGE);
        }else if(hotline.isEmpty()){
            JOptionPane.showMessageDialog(this, "Enter Company Mobile", "warning", JOptionPane.WARNING_MESSAGE);
        }else if(hotline.matches("^0((11)|(2(1|[3-7]))|(3[1-8])|(4(1|5|7))|(5(1|2|4|5|7))|(6(3|[5-7]))|([8-9]1))[0-9]{7}$")){
            JOptionPane.showMessageDialog(this, "Mobile Not Valid", "warning", JOptionPane.WARNING_MESSAGE);
        }else{

            try {
                
                ResultSet rs = MySQL.execute("SELECT * FROM `company` WHERE `name`='"+name+"' OR `hotline`='"+hotline+"' ");
                
                if(rs.next()){
                    JOptionPane.showMessageDialog(this, "Company Name OR Hotline Already Used", "warning", JOptionPane.WARNING_MESSAGE);
                }else{
                    MySQL.execute("INSERT INTO `company` (`name`, `hotline`) VALUES ('"+name+"', '"+hotline+"')");
                
                    loadCompanies();
                    reset(); 
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        
    }                                        

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {                                     
        
        int row = jTable1.getSelectedRow();
        
        if(evt.getClickCount() == 1){
            
            jTextField1.setText(String.valueOf(jTable1.getValueAt(row, 1)));
            jTextField2.setText(String.valueOf(jTable1.getValueAt(row, 2)));
            
            jButton1.setEnabled(false);
            
        }else if(evt.getClickCount() == 2){
            
            String name = String.valueOf(jTable1.getValueAt(row, 1));
            
//            cr.getjTextField1().setText(name);
            cr.setCompanyName(name);
            this.dispose();
            cr.grabFocusMobile();
            cr.setCompanyId(String.valueOf(jTable1.getValueAt(row, 0)));
            
        }
        
    }                                    

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
       
        int row = jTable1.getSelectedRow();
        String id = String.valueOf(jTable1);
        
        String name = jTextField1.getText();
        String hotline = jTextField2.getText();
        
        String selectedName = String.valueOf(jTable1.getValueAt(row, 1));
        String selectedHotline = String.valueOf(jTable1.getValueAt(row, 2));
        
        if(name.isEmpty()){
            JOptionPane.showMessageDialog(this, "Enter Company Name", "warning", JOptionPane.WARNING_MESSAGE);
        }else if(hotline.isEmpty()){
            JOptionPane.showMessageDialog(this, "Enter Company Mobile", "warning", JOptionPane.WARNING_MESSAGE);
        }else if(hotline.matches("^0((11)|(2(1|[3-7]))|(3[1-8])|(4(1|5|7))|(5(1|2|4|5|7))|(6(3|[5-7]))|([8-9]1))[0-9]{7}$")){
            JOptionPane.showMessageDialog(this, "Mobile Not Valid", "warning", JOptionPane.WARNING_MESSAGE);
        }else if(name.equals(selectedName) && hotline.equals(selectedHotline)){
            JOptionPane.showMessageDialog(this, "Please name Or Hotline To Update", "warning", JOptionPane.WARNING_MESSAGE);
        }else{

            try {
                
                ResultSet rs = MySQL.execute("SELECT * FROM `company` WHERE (`name`='"+name+"' OR `hotline`='"+hotline+"') AND `id`='"+id+"' ");
                
                if(rs.next()){
                    JOptionPane.showMessageDialog(this, "Company Name OR Hotline Already Used", "warning", JOptionPane.WARNING_MESSAGE);
                }else{
                    MySQL.execute("UPDATE `company` SET `name`='"+name+"', `hotline`='"+hotline+"' WHERE `id`='"+id+"'");
                
                    loadCompanies();
                    reset(); 
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        
    }                                        

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        reset();
    }                                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CompanyrRegisteration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CompanyrRegisteration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CompanyrRegisteration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CompanyrRegisteration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CompanyrRegisteration dialog = new CompanyrRegisteration(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration                   
}
