/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui.popup;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mac
 */
public class OrderFoodPopupView extends javax.swing.JFrame {

    /**
     * Creates new form NewJPanel
     */
    
    
    String[] list = {"Mã thức uống",  "Tên nước", "Giá Bán", "Số lượng"};
  
    DefaultTableModel tableModel = new DefaultTableModel();
    public OrderFoodPopupView() {
        initComponents();
        setLocationRelativeTo(null);
        menuFood.setModel(tableModel);
      
        setTableModel();
        
        
        
       
        pack();
         
    }
      public void setTableModel() {
          for (String string : list) {
              tableModel.addColumn(string);
        }

    }
    
   
      
    

    public JButton getBtnCancel() {
        return btnCancel;
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        menuFood = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(" Chọn thực đơn"));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 10, 1));

        btnSearch.setForeground(new java.awt.Color(204, 204, 204));
        btnSearch.setText("Bạn muốn tìm gì ?");
        btnSearch.setToolTipText("");
        btnSearch.setFocusable(false);
        btnSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                btnSearchFocusLost(evt);
            }
        });
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(176, Short.MAX_VALUE)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(452, 300));

        menuFood.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(menuFood);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel2.setPreferredSize(new java.awt.Dimension(100, 50));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jButton1.setBackground(new java.awt.Color(0, 129, 215));
        jButton1.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Chọn và đóng");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weightx = 0.5;
        jPanel2.add(jButton1, gridBagConstraints);

        btnCancel.setBackground(java.awt.Color.red);
        btnCancel.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Huỷ chọn");
        btnCancel.setPreferredSize(new java.awt.Dimension(118, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weightx = 0.5;
        jPanel2.add(btnCancel, gridBagConstraints);

        jPanel3.add(jPanel2, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        getAccessibleContext().setAccessibleName("Thêm món");
        getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnSearchFocusGained
         if (btnSearch.getText().equals("Bạn muốn tìm gì ?")) {
                btnSearch.setText(null);
                btnSearch.setForeground(Color.BLACK);
                btnSearch.setFocusable(true);
                    
          }
    }//GEN-LAST:event_btnSearchFocusGained

    private void btnSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnSearchFocusLost
         if (btnSearch.getText().isEmpty()) {
                btnSearch.setText("Bạn muốn tìm gì ?");
                btnSearch.setForeground(Color.GRAY);
                
         }
    }//GEN-LAST:event_btnSearchFocusLost

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        btnSearch.setFocusable(true);
        btnSearch.requestFocus();
        
        
    }//GEN-LAST:event_btnSearchMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JTextField btnSearch;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable menuFood;
    // End of variables declaration//GEN-END:variables
}