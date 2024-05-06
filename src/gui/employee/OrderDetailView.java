/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui.employee;

import com.toedter.calendar.JDateChooser;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.ThucUong;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import utils.ErrorPopup;
import utils.IconManager;
import utils.RightTable;

/**
 *
 * @author mac
 */
public class OrderDetailView extends javax.swing.JPanel {

    /** ArrayList<ThucUong> tableData = new ArrayList<>();
     * Creates new form OrderDetailView
     */
    IconManager im = new IconManager();
    OrderTableModel orderTableModel;
    private HoaDon hoaDon;
    
     
    public OrderDetailView() {
        initComponents();
        pay.setIcon(im.getIcon("pay.png"));
      
        cancel.setIcon(im.getIcon("multiply.png"));
        hoaDon = new HoaDon();
        orderTableModel = new OrderTableModel(hoaDon.getChiTietHoaDons());
        tableFood.setModel(orderTableModel);
        
        onTheDay.setDate(new Date());
        RightTable.setRightTable(tableFood, 2);
        RightTable.setRightTable(tableFood, 3);
        payments.addItem("Tiền mặt");
        payments.addItem("Chuyển khoản");
        
    }

   
    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }
    
    public void setTableData(ArrayList<ChiTietHoaDon> chiTietHoaDons)
    {
        hoaDon.setChiTietHoaDons(chiTietHoaDons);
        orderTableModel.setChiTietHoaDons(chiTietHoaDons);
        orderTableModel.fireTableDataChanged();
    }
    

   
    public  void addChiTietHoaDon(ChiTietHoaDon chiTietHoaDon)
    {
        hoaDon.getChiTietHoaDons().add(chiTietHoaDon);
    }
        
    public JTextField getCustomerName() {
        return customerName;
    }
   
    public JLabel getNameTable() {
        return nameTable;
    }

    public JButton getBtnChoose() {
        return btnChoose;
    }

    public JButton getBtnEdit() {
        return btnEdit;
    }

    public JButton getBtnRemove() {
        return btnRemove;
    }
    
   
    
//    public int findIndexRow(String id)
//    {
//        for (int i = 0; i < tableData.size(); i++) {
//            if( orderTableModel.getValueAt(i, 0).equals(id))
//                return i;
//        }
//        return -1;
//    }

    
    public  OrderTableModel getModel()
    {
        return orderTableModel;
    }

    public JLabel getTongTien() {
        return tongTien;
    }

    public JLabel getTienThua() {
        return tienThua;
    }

    public JSpinner getTienNhanCuaKhach() {
        return tienNhanCuaKhach;
    }

    public JButton getPay() {
        return pay;
    }

    public JDateChooser getOnTheDay() {
        return onTheDay;
    }

    public JComboBox<String> getPayments() {
        return payments;
    }

       public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
    
    
    
    

     public void showError(String message) {
        ErrorPopup.show(new Exception(message));
    }

    public void showError(Exception e) {
        ErrorPopup.show(e);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tableFood = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        nameTable = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        onTheDay = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        customerName = new javax.swing.JTextField();
        btnChoose = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        pay = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tongTien = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tienThua = new javax.swing.JLabel();
        cancel = new javax.swing.JButton();
        tienNhanCuaKhach = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        payments = new javax.swing.JComboBox<>();

        setPreferredSize(new java.awt.Dimension(500, 600));
        setLayout(new java.awt.BorderLayout());

        tableFood.setModel(new javax.swing.table.DefaultTableModel(
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
        tableFood.setPreferredSize(new java.awt.Dimension(300, 300));
        jScrollPane1.setViewportView(tableFood);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        nameTable.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nameTable.setText("Bàn số 2 ");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel2.setText("Ngày vào");

        onTheDay.setToolTipText("");
        onTheDay.setEnabled(false);
        onTheDay.setMaxSelectableDate(new java.util.Date());
        onTheDay.setMinSelectableDate(new java.util.Date());
        onTheDay.setOpaque(false);

        jLabel3.setText("Khách hàng");

        customerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerNameActionPerformed(evt);
            }
        });

        btnChoose.setBackground(new java.awt.Color(51, 204, 0));
        btnChoose.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        btnChoose.setForeground(new java.awt.Color(255, 255, 255));
        btnChoose.setText("Chọn món");

        btnEdit.setBackground(new java.awt.Color(255, 204, 0));
        btnEdit.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("Chỉnh sửa");

        btnRemove.setBackground(new java.awt.Color(255, 0, 0));
        btnRemove.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        btnRemove.setForeground(new java.awt.Color(255, 255, 255));
        btnRemove.setText("Xoá");
        btnRemove.setPreferredSize(new java.awt.Dimension(96, 23));
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameTable)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(27, 27, 27)
                                .addComponent(onTheDay, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(customerName, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nameTable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(onTheDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(customerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit)
                    .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setMaximumSize(new java.awt.Dimension(500, 500));
        jPanel3.setPreferredSize(new java.awt.Dimension(200, 200));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        pay.setText("Thanh toán");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel3.add(pay, gridBagConstraints);

        jLabel4.setText("Tổng tiền");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        jPanel3.add(jLabel4, gridBagConstraints);

        tongTien.setText("0 VNĐ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 10, 0);
        jPanel3.add(tongTien, gridBagConstraints);

        jLabel6.setText("Tiền nhận của khách");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        jPanel3.add(jLabel6, gridBagConstraints);

        jLabel7.setText("Tiền thừa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        jPanel3.add(jLabel7, gridBagConstraints);

        tienThua.setText("0 VNĐ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 10, 0);
        jPanel3.add(tienThua, gridBagConstraints);

        cancel.setText("Huỷ");
        cancel.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel3.add(cancel, gridBagConstraints);

        tienNhanCuaKhach.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 10000.0d));
        tienNhanCuaKhach.setPreferredSize(new java.awt.Dimension(200, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 10, 0);
        jPanel3.add(tienNhanCuaKhach, gridBagConstraints);

        jLabel1.setText("Hình thức thanh toán");
        jLabel1.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel3.add(jLabel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 10, 0);
        jPanel3.add(payments, gridBagConstraints);

        add(jPanel3, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void customerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerNameActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemoveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChoose;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton cancel;
    private javax.swing.JTextField customerName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameTable;
    private com.toedter.calendar.JDateChooser onTheDay;
    private javax.swing.JButton pay;
    private javax.swing.JComboBox<String> payments;
    private javax.swing.JTable tableFood;
    private javax.swing.JSpinner tienNhanCuaKhach;
    private javax.swing.JLabel tienThua;
    private javax.swing.JLabel tongTien;
    // End of variables declaration//GEN-END:variables
}
