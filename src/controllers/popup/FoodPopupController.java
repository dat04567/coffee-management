/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.popup;

import controllers.ManagerController;
import dao.ThucUongDao;
import entity.DonViNuoc;
import entity.LoaiNuoc;

import entity.ThucUong;
import gui.ManagerPaneView;
import gui.popup.FoodPopupView;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.YES_OPTION;

/**
 *
 * @author mac
 */
public class FoodPopupController {
 
    JFrame previousView;
    ThucUongDao thucUongDao = new ThucUongDao();

    public void add(FoodPopupView view, SuccessCallback sc, ErrorCallback ec) {
        if (previousView != null && previousView.isDisplayable()) {
            previousView.requestFocus();
            return;
        }
        previousView = view;
        view.setVisible(true);
        view.getBtnCancel().addActionListener(evt -> view.dispose());
        
        view.getBtnOK().addActionListener(evt -> {
            try {
                addThucUong(view);
                view.dispose();
                view.showMessage("Thêm thức uống thành công!");
                sc.onSuccess();
            } catch (Exception ex) {
//                ex.printStackTrace()
                
                ec.onError(ex);
            }
        });

    }
    public void addThucUong(FoodPopupView view) throws Exception {
        String maThucUong = view.getMaThucUong().getText(),
                loaiNuoc = view.getLoaiNuoc().getSelectedItem().toString(),
                donVi = view.getDonVi().getSelectedItem().toString(),
                tenNuoc = view.getTenNuoc().getText().toString();
        int gam = (Integer) (view.getSpnCount().getValue());
        
        double giaBan = (Double) (view.getSpnSalary().getValue());
     
               
        if (maThucUong.isEmpty() || loaiNuoc.isEmpty() || donVi.isEmpty()) {
            throw new Exception("Vui lòng điền đầy đủ thông tin");
        }
        if (giaBan <  0) {
            throw new Exception("Giá bán không thể âm");
        }
        
         if (gam <  0) {
            throw new Exception("Số lượng không thể âm");
        }
         
         if(!maThucUong.matches( "^TU\\d+$"))
        {
              throw new Exception("Bạn không không đúng với định dạng vd ( TU + số ) ");
        }
         DonViNuoc dvn =  donVi.equals("Chai") ? DonViNuoc.Chai : DonViNuoc.Ly;
         
         ThucUong thucUong = new ThucUong(maThucUong, tenNuoc, LoaiNuoc.getByName(loaiNuoc) , dvn,  gam , giaBan);
        try {
            thucUongDao.save(thucUong);
        } catch (SQLException e) {
            if(e.getSQLState().equals("23000"))
                throw new Exception("Không được trùng mã");
            throw new Exception(e.getMessage());
        }
        
        
    
        return;
    }
    
    
    public void edit(FoodPopupView view, ThucUong thucUong, SuccessCallback sc, ErrorCallback ec) {
        if (previousView!= null && previousView.isDisplayable()) {
            previousView.requestFocus();
            return;
        }
        previousView = view;
        view.setVisible(true);
        view.getBtnCancel().addActionListener(evt -> view.dispose());

        view.getLbTitle().setText("Sửa thức uống");
        view.getMaThucUong().setText(thucUong.getMaNuoc());
        view.getMaThucUong().setEditable(false);
        view.getTenNuoc().setText(thucUong.getTenNuoc());
        view.getLoaiNuoc().setSelectedItem(thucUong.getLoaiNuoc());
        view.getDonVi().setSelectedItem(thucUong.getDonViNuoc());
        view.getSpnCount().setValue(thucUong.getGam());
        view.getSpnSalary().setValue(thucUong.getGiaBan());
        view.getBtnOK().setText("Cập nhật");
        view.getBtnOK().addActionListener(evt -> {
            try {
                editThucUong(view, thucUong, sc, ec);
            } catch (Exception ex) {
                ec.onError(ex);
            }
        });
    }

    public void editThucUong(FoodPopupView view, ThucUong thucUong, SuccessCallback sc, ErrorCallback ec) throws Exception {
        String maThucUong = view.getMaThucUong().getText(),
                loaiNuoc = view.getLoaiNuoc().getSelectedItem().toString(),
                donVi = view.getDonVi().getSelectedItem().toString(),
                tenNuoc = view.getTenNuoc().getText().toString();
        int gam = (Integer) (view.getSpnCount().getValue());
        double giaBan = (Double) (view.getSpnSalary().getValue());

        
        
        if (maThucUong.isEmpty() || loaiNuoc.isEmpty() || donVi.isEmpty()) {
            throw new Exception("Vui lòng điền đầy đủ thông tin");
        }
        if (giaBan < 0) {
            throw new Exception("Giá bán không thể âm");
        }
        

        if(maThucUong.matches( "^TU\\d+$"))
        {
              throw new Exception("Bạn không không đúng với định dạng vd ( TU + số ) ");
        }
        if (gam < 0) {
            throw new Exception("Số lượng không thể âm");
        }

        DonViNuoc dvn = donVi.equals("Chai")? DonViNuoc.Chai : DonViNuoc.Ly;

        ThucUong updatedThucUong = new ThucUong(maThucUong, tenNuoc, LoaiNuoc.getByName(loaiNuoc), dvn, gam, giaBan);
//        System.out.println(thucUong.getMaNuoc());
     
       thucUongDao.update(updatedThucUong);
       view.dispose();
       view.showMessage("Sửa thức uống thành công!");
       sc.onSuccess();
      

}
    

   public void remove(ThucUong thucUong, SuccessCallback sc, ErrorCallback ec) {
        try {
            thucUongDao.delete(thucUong);
            sc.onSuccess();
        } catch (Exception ex) {
            ec.onError(ex);
        }
    }
      
     
    
      
 
    
//
//    public boolean editEmployee(EmployeePopupView view, Employee e) throws Exception {
//        String username = view.getTxtUsername().getText(),
//                password = view.getTxtPassword().getText(),
//                phoneNumber = view.getTxtPhoneNumber().getText(),
//                name = view.getTxtName().getText();
//        int salary = (int) view.getSpnSalary().getValue();
//        if (username.isEmpty() || password.isEmpty() || phoneNumber.isEmpty()) {
//            throw new Exception("Vui lòng điền đầy đủ thông tin");
//        }
//        if (salary < 0) {
//            throw new Exception("Lương không thể âm");
//        }
//        Employee temp = employeeDao.findByUsername(username);
//        if (temp != null && temp.getId() != e.getId()) {
//            throw new Exception("Tên tài khoản đã tồn tại");
//        }
//        e.setUsername(username);
//        e.setPassword(password);
//        e.setName(name);
//        e.setPhoneNumber(phoneNumber);
//        e.setPermission(EmployeePermission.getByName(view.getCboPermission().getSelectedItem().toString()));
//        e.setSalary(salary);
//        employeeDao.update(e);
//        return true;
//    }
      
  
      
}
