/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.employee;

import controllers.popup.OrderFoodPopupController;
import dao.HoaDonDao;
import dao.ThucUongDao;
import entity.Ban;
import entity.HoaDon;
import entity.ThucUong;
import gui.employee.FoodManagerView;
import gui.employee.OrderDetailView;
import gui.employee.OrderManagerView;
import gui.employee.TableItem;
import gui.popup.OrderFoodPopupView;
import gui.popup.OrderFoodUpdateView;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
    OrderDetailController orderDetailController;
    ThucUongDao thucUongDao = new ThucUongDao();
   
            
    public OrderManagerController(OrderManagerView view) {
        this.view = view;
        tableController = new TableController(view);
        orderDetailController = new OrderDetailController();
        
        tableController.addTable();
        tableController.addTableEvent(this::addTableEvent);
        
//        default 
        
    }
    
 
    public void addTableEvent(TableItem item)
    {
        JButton btnTable = item.getNumberTable();
        String numberTxt = btnTable.getText().split(" ")[1];

        int numberTable = Integer.parseInt(numberTxt);
       
        OrderDetailView orderView =  (OrderDetailView) view.getOrderDetailPanel().getComponent(numberTable);
        view.getCardLayout().show(view.getOrderDetailPanel(), "B" + numberTxt);
        orderView.getNameTable().setText(btnTable.getText());
        
        orderDetailController.addOrderEvent(orderView, tableController::getTableItemActive );
    }
   
    
 
    
    
    
  
 
    
  
    
    
   
    
    
    
    
    
}
