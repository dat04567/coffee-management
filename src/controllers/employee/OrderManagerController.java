/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.employee;

import controllers.popup.OrderFoodPopupController;
import gui.employee.FoodManagerView;
import gui.employee.OrderManagerView;
import gui.popup.OrderFoodPopupView;
import gui.popup.OrderFoodUpdateView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.text.View;

/**
 *
 * @author mac
 */
public class OrderManagerController {
    TableController tableController;
    OrderManagerView view;
    OrderFoodPopupController orderFoodPopupController = new OrderFoodPopupController();
   
    public OrderManagerController(OrderManagerView view) {
        this.view = view;
        tableController = new TableController(view.getTableManPnl());
        tableController.addTable(25);
        tableController.addTableEvent(this::addTableEvent);
        addOrderDetailEvent();
    }
    
    public void addTableEvent(JButton btnTable)
    {
        String numberTxt = btnTable.getText();
        view.getNameTable().setText(numberTxt);
    }
    
    
    
    
    public void addOrderDetailEvent()
    {
        
        view.getBtnChoose().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               orderFoodPopupController.add(new OrderFoodPopupView());
            }
        });
        
        view.getBtnEdit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               orderFoodPopupController.edit(new OrderFoodUpdateView());
            }
        });
        
        view.getBtnRemove().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });
        
    }
   
    
    
    
}
