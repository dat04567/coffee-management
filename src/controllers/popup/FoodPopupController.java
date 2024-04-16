/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.popup;

import entity.ThucUong;
import gui.popup.FoodPopupView;
import javax.swing.JFrame;

/**
 *
 * @author mac
 */
public class FoodPopupController {
 
    JFrame previousView;

    public void add(FoodPopupView view, SuccessCallback sc, ErrorCallback ec) {
        if (previousView != null && previousView.isDisplayable()) {
            previousView.requestFocus();
            return;
        }
        previousView = view;
        view.setVisible(true);
        view.getBtnCancel().addActionListener(evt -> view.dispose());
        
//        view.getBtnOK().addActionListener(evt -> {
//            try {
//                addEmployee(view);
//                view.dispose();
//                view.showMessage("Thêm nhân viên thành công!");
//                sc.onSuccess();
//            } catch (Exception ex) {
//                ec.onError(ex);
//            }
//        });

    }
    
      public void edit(FoodPopupView view, ThucUong thucUong, SuccessCallback sc, ErrorCallback ec) {
        if (previousView != null && previousView.isDisplayable()) {
            previousView.requestFocus();
            return;
        }
        previousView = view;
        view.setVisible(true);
        view.getBtnCancel().addActionListener(evt -> view.dispose());

        view.getLbTitle().setText("Sửa thức uống - ");
//        view.getTxtUsername().setText(employee.getUsername());
//        view.getTxtPassword().setText(employee.getPassword());
//        view.getTxtName().setText(employee.getName());
//        view.getTxtPhoneNumber().setText(employee.getPhoneNumber());
//        view.getCboPermission().setSelectedItem(employee.getPermission().getName());
//        view.getSpnSalary().setValue(employee.getSalary());
//        view.getBtnOK().setText("Cập nhật");
//        view.getBtnOK().addActionListener(evt -> {
//            try {
//                editEmployee(view, employee);
//                view.dispose();
//                view.showMessage("Sửa nhân viên thành công!");
//                sc.onSuccess();
//            } catch (Exception ex) {
//                ec.onError(ex);
//            }
//        });

    }
      
    
//
//    public void addEmployee(EmployeePopupView view) throws Exception {
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
//        if (employeeDao.findByUsername(username) != null) {
//            throw new Exception("Tài khoản đã tồn tại");
//        }
//        Employee e = new Employee();
//        e.setUsername(username);
//        e.setPassword(password);
//        e.setName(name);
//        e.setPhoneNumber(phoneNumber);
//        e.setPermission(EmployeePermission.getByName(view.getCboPermission().getSelectedItem().toString()));
//        e.setSalary(salary);
//        employeeDao.save(e);
//        return;
//    }
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
//    
//    
}