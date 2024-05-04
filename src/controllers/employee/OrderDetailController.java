/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.employee;

import controllers.popup.OrderFoodPopupController;
import dao.ChiTietHoaDonDao;
import dao.HoaDonDao;
import entity.Ban;
import entity.ChiTietHoaDon;
import entity.HoaDon;

import gui.employee.OrderDetailView;
import gui.employee.OrderManagerView;
import gui.employee.TableItem;
import gui.popup.OrderFoodPopupView;
import gui.popup.OrderFoodUpdateView;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mac
 */
public class OrderDetailController {

    OrderDetailView prevView = null;
    OrderFoodPopupController orderFoodPopupController = new OrderFoodPopupController();
    private HoaDonDao hoaDonDao = new HoaDonDao();
    private ChiTietHoaDonDao chiTietHoaDonDao = new ChiTietHoaDonDao();
    private TableItem tableItem;

    public OrderDetailController() {
         
    }

    interface OrderEvent {

        public abstract TableItem getTableItem();

    }
    
    
    public void addOrderDetail(OrderManagerView view,  HoaDon hoaDon, int i )
    {
         OrderDetailView viewDetail = new OrderDetailView();
         this.prevView = viewDetail;
         viewDetail.setHoaDon(hoaDon);
         view.getOrderDetailPanel().add(viewDetail, "B" + i);
    }
  

    public void addOrderEvent(OrderDetailView view, OrderEvent evnt)  {
        this.prevView = view;
        orderFoodPopupController.setOrderView(view);
        this.tableItem = evnt.getTableItem();
        
      
        orderFoodPopupController.setTableItem(tableItem);

//        buttonOrder = item.getNumberTable();
        view.getBtnChoose().addActionListener(evt -> {
            OrderFoodPopupView orderFoodPopupView = new OrderFoodPopupView();
            orderFoodPopupController.add(orderFoodPopupView, this::updateData, view::showError);
            orderFoodPopupController.updateData(orderFoodPopupView);

        });

        view.getBtnEdit().addActionListener(evt -> {
            orderFoodPopupController.edit(new OrderFoodUpdateView());
        });

        view.getBtnRemove().addActionListener(evt -> {

        });

    }
    
    
    

    public void updateData(){
        try {
            ArrayList<ChiTietHoaDon> chiTietHoaDons  = chiTietHoaDonDao.getAllByMaHoaDon(prevView.getHoaDon().getMaHoaDon());
            prevView.setTableData(chiTietHoaDons);
        } catch (Exception e) {
            prevView.showError(e);
        }
    }

}
