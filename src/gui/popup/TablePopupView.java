package gui.popup;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import utils.ErrorPopup;


public class TablePopupView extends javax.swing.JFrame implements PopupView {


    public TablePopupView() {
        initComponents();
        setLocationRelativeTo(null);
        ((JTextFieldDateEditor) thoiGianDatBan.getDateEditor()).setEditable(false);
    }

    public void showError(String message) {
        ErrorPopup.show(new Exception(message));
    }

    public void showError(Exception e) {
        ErrorPopup.show(e);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public JButton getBtnOK() {
        return btnOK;
    }
  
    public JButton getBtnCancel() {
        return btnCancel;
    }

    public JTextField getMaBan() {
        return maDatBan;
    }

    public JTextArea getGhiChuArea() {
        return ghiChuArea;
    }
    

    public void setMaBan(JTextField maBan) {
        this.maDatBan = maBan;
    }

    public JLabel getMaBanLbl() {
        return maBanLbl;
    }

    public void setMaBanLbl(JLabel maBanLbl) {
        this.maBanLbl = maBanLbl;
    }

    public JTextField getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(JTextField soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public JSpinner getSpnCount() {
        return spnCount;
    }

    public void setSpnCount(JSpinner spnCount) {
        this.spnCount = spnCount;
    }

    public JTextField getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(JTextField tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public JDateChooser getThoiGianDatBan() {
        return thoiGianDatBan;
    }

    public void setThoiGianDatBan(JDateChooser thoiGianDatBan) {
        this.thoiGianDatBan = thoiGianDatBan;
    }
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        maBanLbl = new javax.swing.JLabel();
        soDienThoai = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        maDatBan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        spnCount = new javax.swing.JSpinner();
        tenKhachHang = new javax.swing.JTextField();
        thoiGianDatBan = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        ghiChuArea = new javax.swing.JTextArea();
        ghiChu = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnOK = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(350, 400));
        setResizable(false);

        jPanel2.setPreferredSize(new java.awt.Dimension(350, 50));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTitle.setText("Đặt bàn");
        jPanel2.add(lbTitle, new java.awt.GridBagConstraints());

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        maBanLbl.setText("Mã bàn:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(maBanLbl, gridBagConstraints);

        soDienThoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soDienThoaiActionPerformed(evt);
            }
        });
        soDienThoai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                soDienThoaiKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 136;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(soDienThoai, gridBagConstraints);

        jLabel6.setText("Tên Khách hàng:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jLabel6, gridBagConstraints);

        jLabel4.setText("Thời gian đặt bàn:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jLabel4, gridBagConstraints);

        jLabel5.setText("Số lượng bàn:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jLabel5, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 136;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(maDatBan, gridBagConstraints);

        jLabel3.setText("Số điện thoại:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jLabel3, gridBagConstraints);

        spnCount.setModel(new javax.swing.SpinnerNumberModel(1, 1, 25, 1));
        spnCount.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(spnCount, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 136;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(tenKhachHang, gridBagConstraints);

        thoiGianDatBan.setMaxSelectableDate(new java.util.Date(253370743303000L));
        thoiGianDatBan.setMinSelectableDate(new java.util.Date());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(thoiGianDatBan, gridBagConstraints);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(90, 90));
        jScrollPane1.setSize(new java.awt.Dimension(118, 91));

        ghiChuArea.setColumns(20);
        ghiChuArea.setLineWrap(true);
        ghiChuArea.setRows(5);
        ghiChuArea.setBounds(new java.awt.Rectangle(0, 0, 50, 50));
        ghiChuArea.setPreferredSize(new java.awt.Dimension(50, 20));
        jScrollPane1.setViewportView(ghiChuArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jScrollPane1, gridBagConstraints);

        ghiChu.setText("Ghi Chú");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(ghiChu, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel3.setPreferredSize(new java.awt.Dimension(350, 75));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        btnOK.setText("Thêm");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.1;
        jPanel3.add(btnOK, gridBagConstraints);

        btnCancel.setText("Hủy");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.1;
        jPanel3.add(btnCancel, gridBagConstraints);

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void soDienThoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soDienThoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_soDienThoaiActionPerformed

    private void soDienThoaiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_soDienThoaiKeyTyped

        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9') ||
           (c == KeyEvent.VK_BACK_SPACE) ||
           (c == KeyEvent.VK_DELETE))) {
          evt.consume();
        }
    }//GEN-LAST:event_soDienThoaiKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOK;
    private javax.swing.JLabel ghiChu;
    private javax.swing.JTextArea ghiChuArea;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel maBanLbl;
    private javax.swing.JTextField maDatBan;
    private javax.swing.JTextField soDienThoai;
    private javax.swing.JSpinner spnCount;
    private javax.swing.JTextField tenKhachHang;
    private com.toedter.calendar.JDateChooser thoiGianDatBan;
    // End of variables declaration//GEN-END:variables

    @Override
    public JLabel getLbTitle() {
       return lbTitle;
    }

}
