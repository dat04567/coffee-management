package gui.popup;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import utils.ErrorPopup;


public class FoodPopupView extends javax.swing.JFrame implements PopupView {

    private JButton btnEdit;
    private JButton btnRemove;

    public FoodPopupView() {
        initComponents();
        setLocationRelativeTo(null);
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
    public JButton getBtnEdit() {
        return btnEdit;
    }
    public JButton getBtnRemove() {
        return btnRemove;
    }
    public JButton getBtnCancel() {
        return btnCancel;
    }

    public JComboBox<String> getDonVi() {
        return donVi;
    }

    public void setDonVi(JComboBox<String> donVi) {
        this.donVi = donVi;
    }

    public JComboBox<String> getLoaiNuoc() {
        return loaiNuoc;
    }

    public void setLoaiNuoc(JComboBox<String> loaiNuoc) {
        this.loaiNuoc = loaiNuoc;
    }

    public JTextField getMaThucUong() {
        return maThucUong;
    }

    public void setMaThucUong(JTextField maThucUong) {
        this.maThucUong = maThucUong;
    }

    public JLabel getMaThucUongLbl() {
        return maThucUongLbl;
    }

    public void setMaThucUongLbl(JLabel maThucUongLbl) {
        this.maThucUongLbl = maThucUongLbl;
    }

    public JSpinner getSpnCount() {
        return spnCount;
    }

    public void setSpnCount(JSpinner spnCount) {
        this.spnCount = spnCount;
    }

    public JSpinner getSpnSalary() {
        return spnSalary;
    }

    public void setSpnSalary(JSpinner spnSalary) {
        this.spnSalary = spnSalary;
    }

    public JTextField getTenNuoc() {
        return tenNuoc;
    }

    public void setTenNuoc(JTextField tenNuoc) {
        this.tenNuoc = tenNuoc;
    }

 


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        maThucUongLbl = new javax.swing.JLabel();
        tenNuoc = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        maThucUong = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        spnSalary = new javax.swing.JSpinner();
        spnCount = new javax.swing.JSpinner();
        loaiNuoc = new javax.swing.JComboBox<>();
        donVi = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        btnOK = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(350, 400));
        setResizable(false);

        jPanel2.setPreferredSize(new java.awt.Dimension(350, 50));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTitle.setText("Thêm thức uống");
        jPanel2.add(lbTitle, new java.awt.GridBagConstraints());

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        maThucUongLbl.setText("Mã thức uống:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(maThucUongLbl, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 136;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(tenNuoc, gridBagConstraints);

        jLabel6.setText("Loại nước:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jLabel6, gridBagConstraints);

        jLabel4.setText("Đơn vị:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jLabel4, gridBagConstraints);

        jLabel5.setText("Gam:");
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
        jPanel1.add(maThucUong, gridBagConstraints);

        jLabel3.setText("Tên nước:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jLabel3, gridBagConstraints);

        jLabel7.setText("Giá bán:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jLabel7, gridBagConstraints);

        spnSalary.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 500000.0d, 10000.0d));
        spnSalary.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(spnSalary, gridBagConstraints);

        spnCount.setModel(new javax.swing.SpinnerNumberModel(1, 1, 500, 100));
        spnCount.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(spnCount, gridBagConstraints);

        loaiNuoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nước giải khát", "Coffee", "Sinh Tố" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(loaiNuoc, gridBagConstraints);

        donVi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chai", "Ly" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(donVi, gridBagConstraints);

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOK;
    private javax.swing.JComboBox<String> donVi;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JComboBox<String> loaiNuoc;
    private javax.swing.JTextField maThucUong;
    private javax.swing.JLabel maThucUongLbl;
    private javax.swing.JSpinner spnCount;
    private javax.swing.JSpinner spnSalary;
    private javax.swing.JTextField tenNuoc;
    // End of variables declaration//GEN-END:variables

    @Override
    public JLabel getLbTitle() {
       return lbTitle;
    }

}
