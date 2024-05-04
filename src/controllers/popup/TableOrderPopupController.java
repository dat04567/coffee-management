/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.popup;

import entity.DatBan;
import gui.popup.TablePopupView;
import javax.swing.JFrame;

/**
 *
 * @author mac
 */
public class TableOrderPopupController {
       JFrame previousView;
    
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
     public void addDatBan(TablePopupView view)
     {
         
     }
     
      public void edit(TablePopupView view, DatBan datBan, SuccessCallback sc, ErrorCallback ec) {
        if (previousView!= null && previousView.isDisplayable()) {
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
      
    public  void editDatBan(TablePopupView view , DatBan ban)
    {
//        thao my code 
    }
     
      
      
    
}
