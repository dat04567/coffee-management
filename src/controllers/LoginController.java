/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dao.NhanVienDao;
import entity.NhanVien;
import gui.EmployeeDashboardView;
import gui.HomeView;
import gui.LoginView;
import java.awt.event.*;
import java.sql.SQLException;

/**
 *
 * @author ho tan dat
 */
public class LoginController {

    private LoginView view;
    private NhanVienDao nhanVienDao = new NhanVienDao();

    public LoginController(LoginView view) {
        this.view = view;
        view.setVisible(true);
        addEvent();
    }

    public LoginView getView() {
        return view;
    }

    public void setView(LoginView view) {
        this.view = view;
        view.setVisible(true);
    }

    public void login() {
        String username = view.getTxtUsername().getText();
        String password = new String(view.getTxtPassword().getPassword());

        try {

            NhanVien employee = nhanVienDao.findByUsername(username);

            if (employee == null) {
                view.showError("Không tồn tại tài khoản!");
                return;
            }
            if (!employee.checkPassword(password)) {
                view.showError("Mật khẩu sai");
                return;
            }

            EmployeeDashboardController controller1 = new EmployeeDashboardController(new EmployeeDashboardView());
            controller1.getView().getLbName().setText(employee.getHoTen());

            view.dispose();// Tắt form đăng nhập        
        } catch (Exception e) {
            view.showError(e);
        }

    }

    public void addEvent() {

        view.getTxtPassword().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    view.getBtnLogin().doClick();
                }
            }
        });

        view.getBtnLogin().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                login();

            }
        });
    }

}
