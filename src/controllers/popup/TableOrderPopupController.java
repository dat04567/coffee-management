/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.popup;

import dao.ChiTietDatBanDao;
import dao.DatBanDao;
import dao.KhachHangDao;
import entity.ChiTietDatBan;
import entity.DatBan;
import entity.KhachHang;
import gui.popup.TablePopupView;
import java.util.Date;
import javax.swing.JFrame;
import java.sql.Timestamp;
import java.sql.SQLException;

/**
 *
 * @author mac
 */
public class TableOrderPopupController {

    JFrame previousView;
    private DatBanDao datBanDao = new DatBanDao();
    private KhachHangDao khachHangDao = new KhachHangDao();
    private ChiTietDatBanDao chiTietDatBanDao = new ChiTietDatBanDao();

    public void add(TablePopupView view, SuccessCallback sc, ErrorCallback ec) {
        if (previousView != null && previousView.isDisplayable()) {
            previousView.requestFocus();
            return;
        }
        previousView = view;
        view.setVisible(true);
        view.getBtnCancel().addActionListener(evt -> view.dispose());

        view.getBtnOK().addActionListener(evt -> {
            try {
                addDatBan(view);
                view.dispose();
                view.showMessage("Thêm thành công!");
                sc.onSuccess();
            } catch (Exception ex) {
                ec.onError(ex);
            }
        });

    }

    public void addDatBan(TablePopupView view) throws Exception {

        String maDatBan = view.getMaBan().getText();
        String soDienThoai = view.getSoDienThoai().getText();
        String tenKhachHang = view.getTenKhachHang().getText();

        if (maDatBan.trim().equals("") || tenKhachHang.trim().equals("")) {
            throw new Exception("Vui lòng điền đầy đủ thông tin");
        }

        Date ngayDat = view.getThoiGianDatBan().getDate();
        int soLuongBan = (int) view.getSpnCount().getValue();
        String ghiChu = view.getGhiChuArea().getText();
//       luu thong tin khach hang  
        KhachHang khachHang = new KhachHang(tenKhachHang, soDienThoai);

        try {
            int maKhachHang = khachHangDao.save(khachHang);
            khachHang.setMaKhachHang(maKhachHang);

////         luu thong tin dat ban 
            Timestamp timestamp = new Timestamp(ngayDat.getTime());

            DatBan datBan = new DatBan(maDatBan, soLuongBan, khachHang, ghiChu);
            datBanDao.save(datBan);

//         luu thong tin chi tiet dat ban 
            ChiTietDatBan chiTietDatBan = new ChiTietDatBan(timestamp, datBan);
            chiTietDatBanDao.save(chiTietDatBan);

        } catch (SQLException e) {
            if(e.getSQLState().equals("23000"))
                throw new Exception("Không được trùng mã");
            throw new Exception(e.getMessage());
        }
        

    }

    public void edit(TablePopupView view, DatBan datBan, SuccessCallback sc, ErrorCallback ec) {
        if (previousView != null && previousView.isDisplayable()) {
            previousView.requestFocus();
            return;
        }
        previousView = view;
        view.setVisible(true);
        view.getBtnCancel().addActionListener(evt -> view.dispose());

        view.getLbTitle().setText("Sửa đặt bàn");
        view.getMaBan().setText(datBan.getMaBan());
        view.getMaBan().setEditable(false);
//        lam tiep 
//        view.getTenNuoc().setText(thucUong.getTenNuoc());
//        view.getLoaiNuoc().setSelectedItem(thucUong.getLoaiNuoc());
//        view.getDonVi().setSelectedItem(thucUong.getDonViNuoc());
//        view.getSpnCount().setValue(thucUong.getSoLuongNuoc());
//        view.getSpnSalary().setValue(thucUong.getGiaBan());

        view.getBtnOK().setText("Cập nhật");
        view.getBtnOK().addActionListener(evt -> {
            try {
                editDatBan(view, datBan);
            } catch (Exception ex) {
                ec.onError(ex);
            }
        });
    }

    public void editDatBan(TablePopupView view, DatBan ban) {
//        thao my code 
    }

}
