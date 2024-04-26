/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.popup;

import gui.popup.OrderFoodPopupView;
import gui.popup.OrderFoodUpdateView;
import javax.swing.JFrame;


/**
 *
 * @author mac
 */
public class OrderFoodPopupController {
    
      JFrame previousView;
      
      
       public void add(OrderFoodPopupView view) {
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
       
       public  void edit(OrderFoodUpdateView view)
       {
            if (previousView != null && previousView.isDisplayable()) {
                previousView.requestFocus();
                return;
            }
            previousView = view;
            view.setVisible(true);
            view.getBtnCancel().addActionListener(evt -> view.dispose());
            
            
       }
       
}
